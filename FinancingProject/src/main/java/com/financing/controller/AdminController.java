package com.financing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.financing.bean.Oversea_config;
import com.financing.bean.Subject;
import com.financing.service.Oversea_config_Service;
import com.financing.service.SubjectService;

@Controller
@RequestMapping("/AdminController")
public class AdminController {
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private Oversea_config_Service oversea_config_service;
	
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
	public String menus1(Model model,@RequestParam(required=false)String sname) {
		Map map=new HashMap();
		map.put("sname",sname);
		List<Subject> listSubject=this.subjectService.listSubject(map);
//		for (Subject subject : listSubject) {
//			System.out.println(subject);
//		}
		model.addAttribute("sname",sname);
		model.addAttribute("listSubject", listSubject);
		return "admin/menus1";
	}

	@RequestMapping("/menus2")
	public String menus2() {
		return "admin/menus2";
	}
	@RequestMapping("/menus3")
	public String menus3() {
		return "admin/menus3";
	}
	@RequestMapping("/menus4")
	//查询海外配置
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
	@RequestMapping("/menus8")
	public String menus8() {
		return "admin/menus8";
	}
	@RequestMapping("/menus9")
	public String menus9() {
		return "admin/menus9";
	}
	@RequestMapping("/menus10")
	public String menus10() {
		return "admin/menus10";
	}
	@RequestMapping("/menus11")
	public String menus11() {
		return "admin/menus11";
	}
	@RequestMapping("/menus12")
	public String menus12() {
		return "admin/menus12";
	}
	@RequestMapping("/menus13")
	public String menus13() {
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
