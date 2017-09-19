package com.financing.service;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_Member_dao;
import com.financing.Interface_service.IN_Member_service;
import com.financing.bean.Member;
import com.financing.dao.Member_dao;

@Service
@Transactional
public class Member_service  implements IN_Member_service{

	@Autowired
	private IN_Member_dao md;
	
	public List<Member> listMember(Map map){
		return this.md.listMember(map);
	}

	@Override
	public Member getByPhone(String phone) {
		return md.getByPhone(phone);
	}
}
