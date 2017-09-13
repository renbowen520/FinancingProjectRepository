package com.financing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Member_deposit_record;

@Component
public class Member_deposit_record_dao {
		@Autowired
		private SessionFactory sessionFactory;
		
		public Session getSession(){
			return this.sessionFactory.getCurrentSession();
		};
		
		//显示充值记录表
		public List<Member_deposit_record> listMember_deposit_record(){
			String hql=" from Member_deposit_record";
			Session session=getSession();
			List<Member_deposit_record> listMember_deposit_record=session.createQuery(hql).list();
			return listMember_deposit_record;
		}
		
		
}
