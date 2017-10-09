package com.financing.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_Member_dao;
import com.financing.Interface_service.IN_Member_service;
import com.financing.bean.Award_records;
import com.financing.bean.Bank;
import com.financing.bean.Bbin_info;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_profit_record;
import com.financing.bean.Member_tally;
import com.financing.bean.Member_trade_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Subject_order_record;
import com.financing.bean.Subject_purchase_record;
import com.financing.bean.Sys_region;

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

	@Override
	public Member getByPhone(String phone) {
		return md.getByPhone(phone);
	}

	@Override
	public String getma(int k) {
	  
		return  md.getma(k);
	}

	@Override
	public Member getByCode(String code) {
		// TODO Auto-generated method stub
		return md.getByCode(code);
	}

	@Override
	public void save(Member member) {
		md.save(member);
		
	}

	@Override
	public Member getById(int id) {
		// TODO Auto-generated method stub
		return md.getById(id);

	}


	@Override
	public void saveAll(Member member, Bbin_info bbin_info, Award_records award_records,
			Member_account member_account) {
	md.saveAll(member, bbin_info, award_records, member_account);
		
	}


	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		md.update(member);
	}


	@Override
	public Member getByIdentity(String identity) {
		// TODO Auto-generated method stub
		return md.getByIdentity(identity);
	}


	@Override
	public List<Bank> get_bank() {
		// TODO Auto-generated method stub
		return md.get_bank();
	}


/*	@Override
	public List<Sys_region> get_s111(int id) {
		// TODO Auto-generated method stub
		return md.get_s111(id);
	}


	@Override
	public List<Sys_region> get_s222(int id) {
		// TODO Auto-generated method stub
		return md.get_s222(id);
	}
*/

	@Override
	public List<Sys_region> get_s333(int rid, int pid) {
		// TODO Auto-generated method stub
		return md.get_s333(rid, pid);
	}


	@Override
	public Bank get_bank_id(int id) {
		// TODO Auto-generated method stub
		return md.get_bank_id(id);
	}


	@Override
	public void save_goumai(Subject_order_record s1, Subject_purchase_record s2, Member_trade_record s3, Member_tally s4,
			Member_account s5) {
		// TODO Auto-generated method stub
		md.save_goumai(s1, s2, s3, s4, s5);
	}


	@Override
	public List<Subject_purchase_record> get_money(int id) {
		 // TODO Auto-generated method stub
		  return  md.get_money(id);
	}


	@Override
	public List<Member_profit_record> get_lixi(int id) {
	    	// TODO Auto-generated method stub
		    return md.get_lixi(id);
	}


	@Override
	public List<Member_deposit_record> get_cz(int id) {
		// TODO Auto-generated method stub
		return   md.get_cz(id);
	}
}
