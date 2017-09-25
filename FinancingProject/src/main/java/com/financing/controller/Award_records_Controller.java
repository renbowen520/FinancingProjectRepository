package com.financing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.Interface_service.IN_award_records_service;
import com.financing.bean.Award_records;



@Controller
@RequestMapping("/Award_records_controller")
public class Award_records_Controller {
	@Autowired
	private IN_award_records_service IN_award_records_service;
	@RequestMapping("/menus14")//���뽱��
	public String menus14(Model model,@ModelAttribute("member_namem")String member_namem,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("invitationCodem")String invitationCodem,@ModelAttribute("invitedCodem")String invitedCodem,@ModelAttribute("typem")String typem,@ModelAttribute("isAwardm")String isAwardm) {
		System.out.println("���뽱��");
		Map map=new HashMap<>();
		map.put("member_namem", member_namem);
		System.out.println("���뽱������="+member_namem);
		map.put("mobile_Phonem", mobile_Phonem);
		System.out.println("���뽱���ֻ���="+mobile_Phonem);
		map.put("invitationCodem", invitationCodem);
		System.out.println("���뽱��������="+invitationCodem);
		map.put("invitedCodem", invitedCodem);
		System.out.println("���뽱����������="+invitedCodem);
		map.put("typem", typem);
		System.out.println("���뽱���Ƿ���ע�ά��="+typem);
		map.put("isAwardm", isAwardm);
		System.out.println("���뽱���Ƿ���Ͷ�ʽ���="+isAwardm);
		List<Award_records> listaward_records=this.IN_award_records_service.listAward_records(map);
		System.out.println(listaward_records.size());
		model.addAttribute("listaward_records", listaward_records);
		return "admin/menus14";
	}
}
