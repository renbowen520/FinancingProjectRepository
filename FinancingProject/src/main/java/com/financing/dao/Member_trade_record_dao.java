package com.financing.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_member_trade_record_dao;
import com.financing.bean.Member_trade_record;
@Component
public class Member_trade_record_dao  implements IN_member_trade_record_dao {

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public void save(Member_trade_record member_trade_record) {
		  Session session = this.getSession();
		  session.save(member_trade_record);
	}
	
}
