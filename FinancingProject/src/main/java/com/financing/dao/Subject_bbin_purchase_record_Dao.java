package com.financing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Subject_bbin_purchase_record_dao;
import com.financing.bean.Subject_bbin_purchase_record;

@Component
public class Subject_bbin_purchase_record_Dao implements IN_Subject_bbin_purchase_record_dao{

		@Autowired 
		private SessionFactory sessionFactory;
		
		public Session getSession(){
			return this.sessionFactory.getCurrentSession();
		}
		//体验金付息计划显示信息
		public List<Subject_bbin_purchase_record> listsubject_bbin_purchase_record(int id){
			String hql="from Subject_bbin_purchase_record where subject.id="+id;
			Session session=getSession();
			List<Subject_bbin_purchase_record>listsubject_bbin_purchase_record=session.createQuery(hql).list();
			return listsubject_bbin_purchase_record;
		}
		
}
