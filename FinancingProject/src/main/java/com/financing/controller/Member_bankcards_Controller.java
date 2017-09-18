package com.financing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.Interface_service.IN_Member_bankcards_service;
import com.financing.bean.Member_bankcards;

@Controller
@RequestMapping("/Member_bankcards_Controller" )
public class Member_bankcards_Controller {

	
	@Autowired
	private IN_Member_bankcards_service mbs;
	
	@RequestMapping("/bangka")//∞Ûø®π‹¿Ì
	public String menus10(Model model,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("member_namem")String member_namem,@ModelAttribute("card_nom")String card_nom,@ModelAttribute("create_datem")String create_datem) {
		Map map=new HashMap<>();
		map.put("mobile_Phonem", mobile_Phonem);
		map.put("member_namem", member_namem);
		map.put("card_nom", card_nom);
		map.put("create_datem", create_datem);
		List<Member_bankcards> listMember_bankcards=this.mbs.listMember_bankcards(map);
		model.addAttribute("listMember_bankcards", listMember_bankcards);
		
		return "admin/menus10";
	}
}
