package com.financing.service;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financing.Interface_dao.IN_Users_dao;
import com.financing.Interface_service.IN_Users_service;
import com.financing.bean.User_log;
import com.financing.bean.Users;

@Service
@Transactional
public class Users_service  implements IN_Users_service{

	@Autowired
  private 	IN_Users_dao users_dao;
	
	public Users getByPhone(String phone) {  //≤È’“”√ªß
		 return users_dao.getByPhone(phone);
	}

	@Override
	public List<Users> list_Users(Map map) {
		// TODO Auto-generated method stub
		return users_dao.list_Users(map);
	}

	@Override
	public Users getById(int id) {
		// TODO Auto-generated method stub
		return users_dao.getById(id);
	}

	@Override
	public void update(Users users) {
		users_dao.update(users);
	}

	@Override
	public void save_users(Users users) {
	   users_dao.save_users(users);
		
	}

	@Override
	public String getIpAddr(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return users_dao.getIpAddr(request);
	}

	@Override
	public void save_User_log(User_log user_log) {
		// TODO Auto-generated method stub
		users_dao.save_User_log(user_log);
	}



}
