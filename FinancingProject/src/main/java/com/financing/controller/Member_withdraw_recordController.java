package com.financing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.bean.Member;
import com.financing.bean.Member_withdraw_record;
import com.financing.service.Member_withdraw_record_service;

@Controller
@RequestMapping("/Member_withdraw_recordController")
public class Member_withdraw_recordController {

		@Autowired
		private Member_withdraw_record_service mwrs;
		
		//显示提现信息
		@RequestMapping("/Member_withdraw_record")
		public List<Member_withdraw_record> listMember_withdraw_record(){
			return this.mwrs.listMember_withdraw_record();
		}
		
		
		
		
}
