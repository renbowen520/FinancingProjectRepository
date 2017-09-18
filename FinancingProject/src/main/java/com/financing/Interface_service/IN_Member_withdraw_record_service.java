package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import com.financing.bean.Member;
import com.financing.bean.Member_withdraw_record;

public interface IN_Member_withdraw_record_service {
	List<Member_withdraw_record> listMember_withdraw_record(Map map);
	 List<Member> listMember();
	 
}
