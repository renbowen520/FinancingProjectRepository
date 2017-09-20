package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.Member;
import com.financing.bean.Menber_tally;

public interface IN_Member_dao {
	Session getSession();
	 List<Member> listMember(Map map);
	 String listMemberM(Map map,String hql);
	 Member getByPhone(String phone);
	 String getma(int k);
	 Member getByCode(String code);
	 void save(Member member) ;
	 Member getById(int id);	 
	 
}
