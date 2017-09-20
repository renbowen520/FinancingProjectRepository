package com.financing.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_bbin_info_dao;
import com.financing.bean.Bbin_info;


@Component
public class Bbin_info_dao  implements IN_bbin_info_dao{

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	
	public void save(Bbin_info bbin_info) {
	  Session session =this.getSession();
	  session.save(bbin_info);
		
	}
}
