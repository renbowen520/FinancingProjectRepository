package com.financing.Interface_service;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.financing.bean.User_log;
import com.financing.bean.Users;

public interface IN_Users_service {
   
	 Users getByPhone(String phone);
	
	List<Users> list_Users(Map map);
	Users getById(int id);
	  void update(Users users);
	  void save_users(Users users);
	  String getIpAddr(HttpServletRequest request);
	  void  save_User_log(User_log user_log);
}
