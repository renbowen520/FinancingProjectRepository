package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.Member_bankcards;

public interface IN_Member_bankcards_dao {
	 Session getSession();
	 List<Member_bankcards> listmember_bankcards(Map map);
	 List<Member_bankcards> getById(int id);
	 Member_bankcards get_ka(String card_no);
	 void save(Member_bankcards member_bankcards);
}
