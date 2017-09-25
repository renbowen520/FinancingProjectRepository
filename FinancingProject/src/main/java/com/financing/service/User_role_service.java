package com.financing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_user_role_dao;
import com.financing.Interface_service.IN_user_role_service;
import com.financing.bean.User_role;
import com.financing.bean.Users;


@Service
@Transactional
public class User_role_service  implements  IN_user_role_service{

@Autowired
private  IN_user_role_dao IN_user_role_dao;
	
	@Override
	public List<User_role> list_user_role() {
		// TODO Auto-generated method stub
		return IN_user_role_dao.list_user_role();
	}

	@Override
	public User_role getById(int id) {
		// TODO Auto-generated method stub
		return IN_user_role_dao.getById(id);
	}

	@Override
	public void save_role(User_role user_role) {
	 IN_user_role_dao.save_role(user_role);
		
	}

	@Override
	public List<User_role> list_user_role_All() {
		// TODO Auto-generated method stub
		return  IN_user_role_dao.list_user_role_All();
	}

	@Override
	public List<Users> get_users(int rid) {
		// TODO Auto-generated method stub
		return IN_user_role_dao.get_users(rid);
	}

	@Override
	public void update(User_role user_role) {
		// TODO Auto-generated method stub
		IN_user_role_dao.update(user_role);
	}

}
