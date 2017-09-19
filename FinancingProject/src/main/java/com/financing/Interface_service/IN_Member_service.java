package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import com.financing.bean.Member;

public interface IN_Member_service {
	 List<Member> listMember(Map map);
	 Member getByPhone(String phone) ;
	 String getma(int k); 
	 Member getByCode(String code);
	 void save(Member member);
}
