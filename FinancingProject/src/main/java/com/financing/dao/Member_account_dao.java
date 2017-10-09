package com.financing.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Member_account_dao;
import com.financing.bean.Bbin_info;
import com.financing.bean.Member;
import com.financing.bean.Member_account;

@Component
public class Member_account_dao implements IN_Member_account_dao {
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	

	
	
	//¸ù¾Ýid²éÑ¯
	public  Member_account getById(int id) {
		   Session session =this.getSession();
		String hql ="from  Member_account  m  where  m.member.id=:id";
		Query query =session.createQuery(hql);
		 query.setInteger("id", id);
		  List<Member_account> list=query.list();
		  	Member_account m=null; 
		 	for(Member_account aaa:list){
		 		m=aaa;
			}
			return m; 
	   

	}
	
	public void save(Member_account member_account) {
	   Session session =this.getSession();
	   session.save(member_account);
		
	}
	public void update_account(Member_account member_account) {
		   Session session =this.getSession();
		   session.update(member_account);
	}
	
}
