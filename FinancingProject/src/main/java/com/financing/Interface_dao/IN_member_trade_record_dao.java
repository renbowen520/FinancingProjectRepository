package com.financing.Interface_dao;

import org.hibernate.Session;

import com.financing.bean.Member_trade_record;

public interface IN_member_trade_record_dao {
	  Session getSession();
	  void save(Member_trade_record member_trade_record);
}
