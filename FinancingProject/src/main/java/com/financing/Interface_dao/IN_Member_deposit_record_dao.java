package com.financing.Interface_dao;

import java.util.List;

import org.hibernate.Session;

import com.financing.bean.Member_deposit_record;

public interface IN_Member_deposit_record_dao {
	Session getSession();
	List<Member_deposit_record> listMember_deposit_record();
	
}
