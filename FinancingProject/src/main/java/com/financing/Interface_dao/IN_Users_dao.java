package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.Users;

public interface IN_Users_dao {
	   Session getSession();
	  Users getByPhone(String phone);
	  List<Users> list_Users(Map map);
	  void update(Users users);
	  Users getById(int id);
	  void save_users(Users users);
}
