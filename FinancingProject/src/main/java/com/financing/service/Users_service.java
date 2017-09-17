package com.financing.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.financing.Interface_dao.IN_Users_dao;
import com.financing.Interface_service.IN_Users_service;


public class Users_service  implements IN_Users_service{

	@Autowired
  private 	IN_Users_dao users_dao;
	

}
