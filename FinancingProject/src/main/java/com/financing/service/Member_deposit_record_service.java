package com.financing.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_Member_deposit_record_dao;
import com.financing.Interface_service.IN_Member_deposit_record_service;
import com.financing.bean.Member_deposit_record;
import com.financing.dao.Member_deposit_record_dao;

@Service
@Transactional
public class Member_deposit_record_service  implements IN_Member_deposit_record_service{

	
	@Autowired
	private IN_Member_deposit_record_dao mdrd;
	
	public List<Member_deposit_record> listMember_deposit_record(Map map){
		
		return this.mdrd.listMember_deposit_record(map);
	}
}
