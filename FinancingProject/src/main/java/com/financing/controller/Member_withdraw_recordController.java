package com.financing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.Interface_service.IN_Member_withdraw_record_service;
import com.financing.bean.Member;
import com.financing.bean.Member_withdraw_record;
import com.financing.service.Member_withdraw_record_service;

@Controller
@RequestMapping("/Member_withdraw_recordController")
public class Member_withdraw_recordController {

		@Autowired
		private IN_Member_withdraw_record_service mwrs;
		
		//显示提现信息
		@RequestMapping("/Member_withdraw_record")
		public String menus13(Model model,@ModelAttribute("member_namem")String member_namem,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("bank_cardm")String bank_cardm,@ModelAttribute("create_datem")String create_datem) {
			Map map=new HashMap<>();
			map.put("member_namem", member_namem);
			map.put("mobile_Phonem", mobile_Phonem);
			map.put("bank_cardm", bank_cardm);
			map.put("create_datem", create_datem);
			
			List<Member_withdraw_record> listMember_withdraw_record=this.mwrs.listMember_withdraw_record(map);
			List<Member> listmember=this.mwrs.listMember();
			model.addAttribute("listMember_withdraw_record", listMember_withdraw_record);
			model.addAttribute("listmember", listmember);
			return "admin/menus13";
		}
		
		
		
		
}
