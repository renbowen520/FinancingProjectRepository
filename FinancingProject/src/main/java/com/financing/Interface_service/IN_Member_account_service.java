package com.financing.Interface_service;

import com.financing.bean.Member_account;
import com.financing.dao.Member_account_dao;

public interface IN_Member_account_service {
	void save(Member_account member_account);
	void update_account(Member_account member_account);
	Member_account getById(int id);
}
