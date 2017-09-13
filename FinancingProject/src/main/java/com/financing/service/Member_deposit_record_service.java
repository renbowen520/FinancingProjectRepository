package com.financing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.bean.Member_deposit_record;
import com.financing.dao.Member_deposit_record_dao;

@Service
@Transactional
public class Member_deposit_record_service {

	
	@Autowired
	private Member_deposit_record_dao mdrd;
	
	public List<Member_deposit_record> listMember_deposit_record(){
		
		return this.mdrd.listMember_deposit_record();
	}
}
