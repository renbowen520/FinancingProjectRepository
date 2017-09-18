package com.financing.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Users_dao;
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
	
	public	 Users getByPhone(String phone) {
		   Session session = this.getSession();
		  Query query = session.createQuery("from Users  where mobile_Phone=:phone");
		  query.setString("phone", phone);
		  List<Users> list=query.list();
	 	  Users users2=null; 
	 	for(Users users:list){
		   users2=users;
		}
		System.out.println("d="+users2.getUser_name());
		return users2;
	}
	
} 
