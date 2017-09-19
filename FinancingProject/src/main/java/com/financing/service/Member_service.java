package com.financing.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_Member_dao;
import com.financing.Interface_service.IN_Member_service;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Subject_purchase_record;

@Service
@Transactional
public class Member_service  implements IN_Member_service{

	@Autowired
	private IN_Member_dao md;
	
	public List<Member> listMember(Map map){
		return this.md.listMember(map);
	}
	
	//根据账号id显示该帐号的信息
	public List<Member> getMemberByid(int id){
		return this.md.getMemberById(id);
	}
	
	//根据账号id显示该帐号的资金信息
	public List<Member_account> getMember_accountByid(int id){
		return this.md.listMember_account(id);
	}
	
	//根据账号id显示该帐号的投资记录
	public List<Subject_purchase_record> getSubject_purchase_record(int id){
		return this.md.getSubject_purchase_record(id);
	}
	
	//根据账号id显示该帐号的提现记录
	public List<Member_withdraw_record>getMember_withdraw_recordByid(int id){
		return this.md.getMember_withdraw_recordByid(id);
	}
	//根据账号id显示该帐号的充值记录
	public List<Member_deposit_record> getMember_deposit_recordByid(int id){
		return this.md.getMember_deposit_recordById(id);
	}
}
