package com.financing.Interface_dao;

import java.util.List;

import org.hibernate.Session;

import com.financing.bean.User_role;
import com.financing.bean.Users;

public interface IN_user_role_dao {
	 Session getSession();
	  List<User_role>   list_user_role();
	  User_role getById(int id);
	  void save_role(User_role user_role);
	  List<User_role> list_user_role_All();
	  List<Users> get_users(int rid);
	  void update(User_role user_role);
}
