package com.financing.Interface_dao;

import java.util.List;

import org.hibernate.Session;

import com.financing.bean.User_role;

public interface IN_user_role_dao {
	 Session getSession();
	  List<User_role>   list_user_role();
	  User_role getById(int id);
}
