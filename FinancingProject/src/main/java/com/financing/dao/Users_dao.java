package com.financing.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Oversea_config;
import com.financing.bean.Subject;
import com.financing.bean.Users;
@Component
public class Users_dao {
    //对用户表的操作 
	 
	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	
	
} 
