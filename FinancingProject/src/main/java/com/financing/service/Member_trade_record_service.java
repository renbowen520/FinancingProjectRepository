package com.financing.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_member_trade_record_dao;
import com.financing.Interface_service.IN_member_trade_record_service;
import com.financing.bean.Member_trade_record;


@Service
@Transactional
public class Member_trade_record_service  implements IN_member_trade_record_service{

@Autowired
private IN_member_trade_record_dao IN_member_trade_record_dao;
	
	@Override
	public void save(Member_trade_record member_trade_record) {
		
		IN_member_trade_record_dao.save(member_trade_record);
	}

}
