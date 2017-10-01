package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_trade_record;

public interface IN_Member_deposit_record_dao {
	  Session getSession();
	  List<Member_deposit_record> listMember_deposit_record(Map map);
	  void save(Member_deposit_record member_deposit_record);
	  Member_deposit_record get_deposit(String no);
	  void update(Member_deposit_record member_deposit_record
				,Member_trade_record member_trade_record
				) ;
	 

}
