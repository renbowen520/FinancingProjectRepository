package com.financing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Member_withdraw_record;

@Component
public class Member_withdraw_record_dao {//���ּ�¼���ܰ�
		
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	//��ʾ�������ּ�¼
	public List<Member_withdraw_record> listmember_withdraw_record(){
		String hql="";
		Session session=getSession();
		List<Member_withdraw_record> listmember_withdraw_record=session.createQuery(hql).list();
		return listmember_withdraw_record;
	}
}
