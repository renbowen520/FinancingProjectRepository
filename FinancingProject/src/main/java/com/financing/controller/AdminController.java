package com.financing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.financing.bean.Finance_product_funds;
import com.financing.bean.Member;
import com.financing.service.Finance_product_funds_Service;
import com.financing.service.Member_bankcards_service;
import com.financing.service.Member_deposit_record_service;
import com.financing.service.Member_service;
import org.springframework.web.bind.annotation.RequestParam;

import com.financing.bean.Member;
import com.financing.bean.Member_bankcards;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Oversea_config;
import com.financing.bean.Subject;
import com.financing.service.Member_service;
import com.financing.service.Member_withdraw_record_service;
import com.financing.service.Oversea_config_Service;
import com.financing.service.SubjectService;

@Controller
@RequestMapping("/AdminController")
public class AdminController {
 
	@Autowired 
	private Member_service member_service;
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private Finance_product_funds_Service finance_product_funds_Service;
	@Autowired
	private Oversea_config_Service oversea_config_service;
	
	@Autowired
	private Member_deposit_record_service mdrs;
	@Autowired
	private Member_withdraw_record_service member_withdraw_record_service;
	
	@Autowired
	private Member_bankcards_service mbs;
	
	 //显示后台
	@RequestMapping("/admin")
	public String admin() {
		 return "admin/admin";
	}
	 
	//后台登陆
	@RequestMapping("/adminlogin")
	public String adminlogin() {
		return "admin/AdminLogin";
	}
	
	
	//显示后台首页图片
	@RequestMapping("/show")
	public String main1() {
		return "admin/show";
	} 
	
	//固收类
	@RequestMapping("/menus1")
	public String menus1(Model model,@ModelAttribute("sname")String sname) {
		Map map=new HashMap();
		map.put("sname",sname);
		List<Subject> listSubject=this.subjectService.listSubject(map);
		model.addAttribute("sname",sname);
		model.addAttribute("listSubject", listSubject);
		return "admin/menus1";
	}
//私募基金
	@RequestMapping("/menus2")
	public String menus2(Model model,@ModelAttribute("sname")String sname){
		Map map=new HashMap();
		map.put("sname",sname);
		List<Finance_product_funds> listfinance=this.finance_product_funds_Service.listfinance(map);
		model.addAttribute("listfinance", listfinance);
		return "admin/menus2";
	}
	@RequestMapping("/menus3")
	public String menus3() {
		return "admin/menus3";
	}
	//查询海外配置
	@RequestMapping("/menus4")
	public String menus4(Model model){
		List<Oversea_config> listOversea=this.oversea_config_service.listOversea();
		model.addAttribute("listOversea", listOversea);
		return "admin/menus4";
	}
	@RequestMapping("/menus5")
	public String menus5() {
		return "admin/menus5";
	}
	@RequestMapping("/menus6")
	public String menus6() {
		return "admin/menus6";
	}
	@RequestMapping("/menus7")
	public String menus7() {
		return "admin/menus7";
	}
	@RequestMapping("/menus8")//帐号管理
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
	@RequestMapping("/menus9")
	public String menus9() {
		return "admin/menus9";
	}
	@RequestMapping("/menus10")//绑卡管理
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
	@RequestMapping("/menus11")//付息计划
	public String menus11(Model model,@ModelAttribute("namem")String namem,@ModelAttribute("statusm")String statusm,@ModelAttribute("typem")String typem) {//付息计划
		Map map=new HashMap<>();
		map.put("namem", namem);
		map.put("statusm", statusm);
		map.put("typem", typem);
		List<Subject>listSubject=subjectService.listSubject(map);
		model.addAttribute("listSubject", listSubject);
		
		return "admin/menus11";
	}
	@RequestMapping("/menus12")//充值管理
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
	@RequestMapping("/menus13")//提现管理
	public String menus13(Model model,@ModelAttribute("member_namem")String member_namem,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("bank_cardm")String bank_cardm,@ModelAttribute("create_datem")String create_datem) {
		Map map=new HashMap<>();
		map.put("member_namem", member_namem);
		map.put("mobile_Phonem", mobile_Phonem);
		map.put("bank_cardm", bank_cardm);
		map.put("create_datem", create_datem);
		
		List<Member_withdraw_record> listMember_withdraw_record=this.member_withdraw_record_service.listMember_withdraw_record(map);
		List<Member> listmember=this.member_withdraw_record_service.listMember();
		model.addAttribute("listMember_withdraw_record", listMember_withdraw_record);
		model.addAttribute("listmember", listmember);
		return "admin/menus13";
	}
	@RequestMapping("/menus14")
	public String menus14() {
		return "admin/menus14";
	}
	@RequestMapping("/menus15")
	public String menus15() {
		return "admin/menus15";
	}
	@RequestMapping("/menus16")
	public String menus16() {
		return "admin/menus16";
	}
	@RequestMapping("/menus17")
	public String menus17() {
		return "admin/menus17";
	}
	@RequestMapping("/menus18")
	public String menus18() {
		return "admin/menus18";
	}
	@RequestMapping("/menus19")
	public String menus19() {
		return "admin/menus19";
	}
	@RequestMapping("/menus20")
	public String menus20() {
		return "admin/menus20";
	}
	@RequestMapping("/menus21")
	public String menus21() {
		return "admin/menus21";
	}

}
