package com.financing.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Member_account_dao;
import com.financing.bean.Bbin_info;
import com.financing.bean.Member_account;

@Component
public class Member_account_dao implements IN_Member_account_dao {
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	
	public void save(Member_account member_account) {
	   Session session =this.getSession();
	   session.save(member_account);
		
	}
}
