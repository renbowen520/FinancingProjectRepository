package com.financing.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_user_role_dao;
import com.financing.bean.Member;
import com.financing.bean.User_role;
import com.financing.bean.Users;


@Component
public class User_role_dao  implements IN_user_role_dao {

	@Resource
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}

	public void update(User_role user_role) {
		  Session session=getSession();
		  session.update(user_role);
	}
	
	
	public List<Users> get_users(int rid){
		  Session session=getSession();
		  Query query = session.createQuery("from Users   u where u.user_role.id=:rid");
		  query.setInteger("rid", rid);
		  List<Users> list=query.list();
		  return list;
	}
	
	
	public void save_role(User_role user_role) {
		Session session=getSession();
		session.save(user_role);
	}
	
	public User_role getById(int id) {
		Session session=getSession();
		User_role  user_role = (User_role) session.get(User_role.class, id);
		return user_role;
		
	}
	
	
	@Override
	public List<User_role> list_user_role() {
		String hql="from User_role   where 0=0";
		Session session=getSession();
		List<User_role> list=session.createQuery(hql).list();
		return list;
	}
	
	
	public List<User_role> list_user_role_All() {
		String hql="from User_role u    where  u.delFlag=0 ";
		Session session=getSession();
		List<User_role> list=session.createQuery(hql).list();
		return list;
	}
	

}
