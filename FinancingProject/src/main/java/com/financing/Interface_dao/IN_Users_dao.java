package com.financing.Interface_dao;

import org.hibernate.Session;

import com.financing.bean.Users;

public interface IN_Users_dao {
	   Session getSession();
	   public	 Users getByPhone(String phone);
}
