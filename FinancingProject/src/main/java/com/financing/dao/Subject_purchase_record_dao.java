package com.financing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Subject_purchase_record_dao;
import com.financing.bean.Subject_purchase_record;

@Component
public class Subject_purchase_record_dao implements IN_Subject_purchase_record_dao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	public List<Subject_purchase_record> getSubject_purchase_record(int id){
		String hql="from Subject_purchase_record where subject_id="+id;
		Session session=getSession();
		List<Subject_purchase_record> listSubject_purchase_record=session.createQuery(hql).list();
		return listSubject_purchase_record;
	}
}
