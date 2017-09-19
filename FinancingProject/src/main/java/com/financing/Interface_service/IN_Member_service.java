package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_trade_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Subject_purchase_record;

public interface IN_Member_service {
	 List<Member> listMember(Map map);
	 List<Member> getMemberByid(int id);
	 List<Member_account> getMember_accountByid(int id);
	 List<Member_withdraw_record>getMember_withdraw_recordByid(int id);
	 List<Member_deposit_record> getMember_deposit_recordByid(int id);
	 List<Subject_purchase_record> getSubject_purchase_record(int id);
}
