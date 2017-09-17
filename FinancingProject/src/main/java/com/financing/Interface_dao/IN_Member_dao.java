package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.Member;

public interface IN_Member_dao {
	Session getSession();
	 List<Member> listMember(Map map);
	 String listMemberM(Map map,String hql);
}
