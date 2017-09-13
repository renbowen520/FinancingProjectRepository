package com.financing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Member_bankcards;

@Component

public class Member_bankcards_dao {
	
	
		@Autowired
		private SessionFactory sessionFactory;
		
		public Session getSession(){
			return this.sessionFactory.getCurrentSession();
		}
		
		//查询绑卡信息以及身份信息
		public List<Member_bankcards> listmember_bankcards(){
			String hql=" from Member_bankcards";
			Session session=getSession();
			List<Member_bankcards> listmember_bankcards=session.createQuery(hql).list();
			return listmember_bankcards;
		}
}
