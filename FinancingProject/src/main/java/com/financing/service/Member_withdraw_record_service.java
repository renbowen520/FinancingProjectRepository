package com.financing.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_Member_wothdraw_record_dao;
import com.financing.Interface_service.IN_Member_withdraw_record_service;
import com.financing.bean.Member;
import com.financing.bean.Member_withdraw_record;
import com.financing.dao.Member_withdraw_record_dao;

@Service
@Transactional
public class Member_withdraw_record_service implements IN_Member_withdraw_record_service {

		@Autowired
		private  IN_Member_wothdraw_record_dao mwrd;
		//显示提现表的信息
		public List<Member_withdraw_record> listMember_withdraw_record(Map map){
			return this.mwrd.listmember_withdraw_record(map);
		}
		//显示用户信息
		public List<Member> listMember(){
			return this.mwrd.listMember();
		}
}
