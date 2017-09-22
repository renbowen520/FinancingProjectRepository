package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Users_dao;
import com.financing.bean.Feedback;
import com.financing.bean.Oversea_config;
import com.financing.bean.Subject;
import com.financing.bean.Users;
@Component
public class Users_dao  implements IN_Users_dao{
    //对用户表的操作 
	 
	@Resource
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	public void save_users(Users users) {
		 Session session = this.getSession();
		 session.save(users);
	}
	
	
	public void update(Users users) {
		  Session session = this.getSession();
		   session.update(users);
	}
	
	
	public	 Users getByPhone(String phone) {
		   Session session = this.getSession();
		  Query query = session.createQuery("from Users  where mobile_Phone=:phone");
		  query.setString("phone", phone);
		  List<Users> list=query.list();
	 	  Users users2=null; 
	 	for(Users users:list){
		   users2=users;
		}
		return users2;
	}

	@Override
	public List<Users> list_Users(Map map) {
	
		  String hql="from  Users s     where  0=0    ";
		  Session session = this.getSession();
		    hql=  this.gethql(hql, map);
		   List<Users>list = session.createQuery(hql).list();
	/*	   for (Users users : list) {
			System.out.println("users====="+users.getUser_role().getCname());
		}*/
		   return list;
	}
	
	public String gethql(String hql,Map map) {
		 String q1 = (String) map.get("users_q1");
		 String q2 = (String) map.get("users_q2");
		 if(!q1.equals("")&&q1!=null) {
			     hql+="    and  s.user_name  like '%"+q1+"%'";
		   }
        if(!q2.equals("")&&q2!=null) {
        	  hql+="    and  s.mobile_Phone   like  '%"+q2+"%'";
		   }
         hql+=  "     order by   s.status asc ";
		   return hql;
	}

	@Override
	public Users getById(int id) {
		  Session session = this.getSession();
		  Users users = (Users) session.get(Users.class, id);
		 return users;
	}
	
} 
