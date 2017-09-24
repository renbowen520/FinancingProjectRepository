package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.financing.bean.User_log;
import com.financing.bean.Users;

public interface IN_Users_dao {
	   Session getSession();
	  Users getByPhone(String phone);
	  List<Users> list_Users(Map map);
	  void update(Users users);
	  Users getById(int id);
	  void save_users(Users users);
	  String getIpAddr(HttpServletRequest request);
	  void  save_User_log(User_log user_log);
}
