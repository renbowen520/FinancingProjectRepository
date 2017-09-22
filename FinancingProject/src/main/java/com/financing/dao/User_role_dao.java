package com.financing.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_user_role_dao;
import com.financing.bean.Member;
import com.financing.bean.User_role;


@Component
public class User_role_dao  implements IN_user_role_dao {

	@Resource
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
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
	
	


}
