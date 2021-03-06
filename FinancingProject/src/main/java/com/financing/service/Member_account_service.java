package com.financing.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.financing.Interface_dao.IN_Member_account_dao;
import com.financing.Interface_service.IN_Member_account_service;
import com.financing.bean.Member_account;
import com.financing.dao.Member_account_dao;

@Service
@Transactional
public class Member_account_service implements IN_Member_account_service {

	@Autowired
	private IN_Member_account_dao IN_Member_account_dao;

	@Override
	public void save(Member_account member_account) {
	IN_Member_account_dao.save(member_account);
		
	}

	@Override
	public void update_account(Member_account member_account) {
		// TODO Auto-generated method stub
		IN_Member_account_dao.update_account(member_account);
	}

	@Override
	public Member_account getById(int id) {
		// TODO Auto-generated method stub
		return IN_Member_account_dao.getById(id);
	}
	
	

}
