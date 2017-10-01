package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import com.financing.bean.Award_records;
import com.financing.bean.Bank;
import com.financing.bean.Bbin_info;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_trade_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Subject_purchase_record;
import com.financing.bean.Sys_region;

public interface IN_Member_service {
	 List<Member> listMember(Map map);

	 List<Member> getMemberByid(int id);
	 List<Member_account> getMember_accountByid(int id);
	 List<Member_withdraw_record>getMember_withdraw_recordByid(int id);
	 List<Member_deposit_record> getMember_deposit_recordByid(int id);
	 List<Subject_purchase_record> getSubject_purchase_record(int id);

	 Member getByPhone(String phone) ;
	 String getma(int k); 
	 Member getByCode(String code);
	 void save(Member member);
	 Member getById(int id);
	 void saveAll(Member member
				,Bbin_info bbin_info,Award_records award_records,
				Member_account member_account
				);
	 
	 void update(Member member);
	 Member getByIdentity(String identity);
	 List<Bank> get_bank();
/*	 List<Sys_region> get_s111(int  id ) ;
	 List<Sys_region> get_s222(int  id ) ;*/
	 List<Sys_region> get_s333( int rid,int  pid );
	 Bank get_bank_id(int id);
}
