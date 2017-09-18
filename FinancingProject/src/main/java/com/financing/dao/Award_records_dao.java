package com.financing.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Award_records_dao;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
@Component
public class Award_records_dao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	//²éÑ¯ÑûÇë¼ÇÂ¼ÑûÇëÈË


}
