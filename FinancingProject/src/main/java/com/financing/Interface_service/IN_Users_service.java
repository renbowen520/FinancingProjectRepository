package com.financing.Interface_service;
import java.util.List;
import java.util.Map;

import com.financing.bean.Users;

public interface IN_Users_service {
   
	 Users getByPhone(String phone);
	
	List<Users> list_Users(Map map);
	Users getById(int id);
	  void update(Users users);
	  void save_users(Users users);
	
}
