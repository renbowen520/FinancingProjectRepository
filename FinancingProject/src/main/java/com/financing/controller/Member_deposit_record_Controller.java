package com.financing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.bean.Member_deposit_record;
import com.financing.service.Member_deposit_record_service;

@Controller
@RequestMapping("/Member_deposit_record_Controller")
public class Member_deposit_record_Controller {
	@Autowired
	private Member_deposit_record_service mdrs;
	
	
	@RequestMapping("/chongzhi")//≥‰÷µπ‹¿Ì
	public String menus12(Model model,@ModelAttribute("serial_numberm")String serial_numberm,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("statusm")String statusm,@ModelAttribute("pay_channel_namem")String pay_channel_namem,@ModelAttribute("create_datem")String create_datem) {
		Map map=new HashMap<>();
		map.put("serial_numberm", serial_numberm);
		map.put("mobile_Phonem", mobile_Phonem);
		map.put("statusm", statusm);
		map.put("pay_channel_namem", pay_channel_namem);
		map.put("create_datem", create_datem);
		List<Member_deposit_record> listMember_deposit_record=this.mdrs.listMember_deposit_record(map);
		model.addAttribute("listMember_deposit_record", listMember_deposit_record);
		return "admin/menus12";
	}
}
