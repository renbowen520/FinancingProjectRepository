package com.financing.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_Member_deposit_record_dao;
import com.financing.Interface_service.IN_Member_deposit_record_service;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_trade_record;
import com.financing.dao.Member_deposit_record_dao;

@Service
@Transactional
public class Member_deposit_record_service  implements IN_Member_deposit_record_service{

	
	@Autowired
	private IN_Member_deposit_record_dao mdrd;
	
	public List<Member_deposit_record> listMember_deposit_record(Map map){
		
		return this.mdrd.listMember_deposit_record(map);
	}

	@Override
	public void save(Member_deposit_record member_deposit_record) {
		// TODO Auto-generated method stub
		mdrd.save(member_deposit_record);
	}

	@Override
	public Member_deposit_record get_deposit(String no) {
		// TODO Auto-generated method stub
		return mdrd.get_deposit(no);
	}

	@Override
	public void update(Member_deposit_record member_deposit_record, Member_trade_record member_trade_record) {
		// TODO Auto-generated method stub
		mdrd.update(member_deposit_record, member_trade_record);
	}

}
