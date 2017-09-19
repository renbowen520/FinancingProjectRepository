package com.financing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.Interface_service.IN_Member_service;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Subject_purchase_record;

@Controller
@RequestMapping("/MemberController")
public class MemberController {

	
	@Autowired 
	private IN_Member_service member_service;
	
	@RequestMapping("/zhanghao")
	public String menus8(Model model,@ModelAttribute("mname")String mname,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("member_namem")String member_namem,@ModelAttribute("invitatioinCodem")String invitatioinCodem) {
		Map map=new HashMap<>();
		map.put("mname", mname);
		map.put("mobile_Phonem", mobile_Phonem);
		map.put("member_namem", member_namem);
		map.put("invitatioinCodem", invitatioinCodem);
		List<Member> listmember=this.member_service.listMember(map);
		model.addAttribute("listmember", listmember);
		return "admin/menus8";
	}
	
	@RequestMapping("/menus25/{id}")
	public String menus25(Model model,@ModelAttribute("id")int id){
		List<Member> listmemberByid=this.member_service.getMemberByid(id);//账号信息
		System.out.println(listmemberByid.size());
		List<Member_account> member_account =this.member_service.getMember_accountByid(id);//资金信息
		List<Subject_purchase_record> subject_purchase_record =this.member_service.getSubject_purchase_record(id);//投资记录
		List<Member_withdraw_record> member_withdraw_record = this.member_service.getMember_withdraw_recordByid(id);//提现记录
		List<Member_deposit_record> member_deposit_record = this.member_service.getMember_deposit_recordByid(id);//充值记录
		model.addAttribute("listmemberByid", listmemberByid.get(0));
		model.addAttribute("member_account", member_account.get(0));
		model.addAttribute("member_withdraw_record", member_withdraw_record);
		model.addAttribute("member_deposit_record", member_deposit_record);
		model.addAttribute("subject_purchase_record", subject_purchase_record);
		return"admin/menus25";
	}
}
