package com.financing.Interface_dao;
import com.financing.bean.Member_account;


public interface IN_Member_account_dao {
	Member_account getById(int id);
	void save(Member_account  member_account);
	void update_account(Member_account member_account);
}
