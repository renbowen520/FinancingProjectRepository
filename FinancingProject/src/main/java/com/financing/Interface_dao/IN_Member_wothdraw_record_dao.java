package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import com.financing.bean.Member;
import com.financing.bean.Member_withdraw_record;

public interface IN_Member_wothdraw_record_dao {
	Session getSession();
	List<Member_withdraw_record> listmember_withdraw_record();
	String listMember_withdraw_record(Map map);
	List<Member> listMember();
	
}
