package com.financing.Interface_dao;

import java.util.List;

import org.hibernate.Session;

import com.financing.bean.Member_bankcards;

public interface IN_Member_bankcards_dao {
	 Session getSession();
	 List<Member_bankcards> listmember_bankcards();
}
