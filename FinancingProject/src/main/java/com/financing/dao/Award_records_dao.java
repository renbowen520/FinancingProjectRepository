package com.financing.dao;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_award_records_dao;
import com.financing.bean.Award_records;

@Component
public class Award_records_dao  implements IN_award_records_dao{

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Award_records award_records) {
		 Session  session = this.getSession();
		 session.save(award_records);
	}


	public List<Award_records> listaward_records(){
		String hql="from Award_records ";
		Session session=getSession();
		List<Award_records> listaward_records=session.createQuery(hql).list();
		return listaward_records;
	}

	public String listMap(Map map,String hql){
		return null;
	}
}
