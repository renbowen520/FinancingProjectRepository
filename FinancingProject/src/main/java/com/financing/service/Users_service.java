package com.financing.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financing.Interface_dao.IN_Users_dao;
import com.financing.Interface_service.IN_Users_service;
import com.financing.bean.Users;

@Service
@Transactional
public class Users_service  implements IN_Users_service{

	@Autowired
  private 	IN_Users_dao users_dao;
	
	public Users getByPhone(String phone) {  //≤È’“”√ªß
		 return users_dao.getByPhone(phone);
	}

}
