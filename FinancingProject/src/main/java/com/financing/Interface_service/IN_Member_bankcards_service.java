package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import com.financing.bean.Member_bankcards;

public interface IN_Member_bankcards_service {
	List<Member_bankcards> listMember_bankcards(Map map);
	 List<Member_bankcards> getById(int id);
	 Member_bankcards get_ka(String card_no);
	 void save(Member_bankcards member_bankcards);
}
