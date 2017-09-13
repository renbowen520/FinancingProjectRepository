package com.financing.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.bean.Member_bankcards;
import com.financing.dao.Member_bankcards_dao;

@Service
@Transactional
public class Member_bankcards_service {

	
		@Autowired
		private Member_bankcards_dao mbd;
		
		public List<Member_bankcards> listMember_bankcards(Map map){
			return this.mbd.listmember_bankcards(map);
		}
}
