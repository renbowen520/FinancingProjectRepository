package com.financing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Index;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.Interface_service.IN_Finance_produce_funds_service;
import com.financing.Interface_service.IN_Oversea_config_service;
import com.financing.Interface_service.IN_Subject_service;
import com.financing.bean.Finance_product_funds;
import com.financing.bean.Member;
import com.financing.bean.Oversea_config;
import com.financing.bean.Subject;

//前台跳转页面相关的控制层

@Controller
@RequestMapping("/IndexController")
public class IndexController {
	@Autowired
	private IN_Subject_service subjectService;
	@Autowired
	private IN_Finance_produce_funds_service finance_product_funds_Service;
	@Autowired
	private IN_Oversea_config_service oversea_config_Service;
	
	//后台登陆
	@RequestMapping("/adminLogin")
	public String adminLogin() {
		
		return "jsp/AdminLogin";
	}
	
	
	//主页
	@RequestMapping("/index")
	public String Index() {
		return "jsp/index";
	}
	
	
	//网上体验中心
  @RequestMapping("/Online_experience_center")
  public String  Online_experience_center() {
	  return "jsp/Online_experience_center";
  }
 
  //产品中心
	@RequestMapping("/product")
	public String  product(Model model,HttpServletRequest request) {
		Map map=new HashMap<>();
		map=initMap(request, map);
		List<Subject> subject=this.subjectService.subject(map);
		model.addAttribute("subject", subject);
		return "jsp/product";
	}
	public Map initMap(HttpServletRequest request,Map map){
		String type=request.getParameter("type");
		String year_rate=request.getParameter("year_rate");
		String status=request.getParameter("status");
		String period_start=request.getParameter("period_start");
		String period_end=request.getParameter("period_end");
		String flag=request.getParameter("flag");
		System.out.println("year_rate="+year_rate);
		map.put("type",type);
		map.put("year_rate", year_rate);
		map.put("status", status);
		map.put("period_start",period_start);
		map.put("period_end",period_end);
		map.put("flag", flag);
		if(type!=null){
			request.setAttribute("type", type);
		}
		if(year_rate!=null){
			request.setAttribute("year_rate", year_rate);
		}
		if(status!=null){
			request.setAttribute("status", status);
		}
		if(period_start!=null){
			request.setAttribute("period_start",period_start);
		}
		if(period_end!=null){
			request.setAttribute("period_end",period_end);
		}
		if(flag!=null){
			request.setAttribute("flag",flag);
		}
		return map; 
	}
	
	//私募
	@RequestMapping("/finance")
	public String  finance(Model model) {
		Map map=new HashMap();
		List<Finance_product_funds> finance=finance_product_funds_Service.finance(map);
		model.addAttribute("finance", finance);
		return "jsp/finance";
	}
	//海外配置
	@RequestMapping("/oversea")
	public String  oversea(Model model) {
		Map map=new HashMap();
		List<Oversea_config> oversea=this.oversea_config_Service.listOversea();
		model.addAttribute("oversea", oversea);
		return "jsp/oversea";
	}
	  //新闻中心
		@RequestMapping("/news")
		public String  news() {
			return "jsp/news";
		}
		
		//购买固收
		@RequestMapping("/buyproduct")
		public String  buyproduct() {
			
			
			return "jsp/buy";
		}
		
		  //商学院
			@RequestMapping("/help")
			public String  help() {
				return "jsp/help";
			}
			
		
			  //投研中心
				@RequestMapping("/investment_research")
				public String  investment_research() {
					  return "jsp/investment_research";
				}
			
				 //个人中心  
				 @RequestMapping("/personal_center")
				 public String  personal_center(HttpSession session) {
					 Member member = (Member) session.getAttribute("member_login"); 
					if(member!=null) {
						  return "jsp/personal_center";
					}else {
						 return "jsp/login";
					}
					
				  }
				 
				 //登陆
				 @RequestMapping("/login")
				 public String login() {
					 return "jsp/login";
				 }
				
				 //注册
				 @RequestMapping("/register")
				 public String  register(HttpSession session) {
					 session.setAttribute("no_phone", "");
					 return "jsp/register";
				 }
				 
				 // 重置密码
				 @RequestMapping("/resetting")
				 public String   resetting() {
					 return "jsp/resetting";
				 }
				
				 // 下载中心
				 @RequestMapping("/download")
				 public String   download() {
					 return "jsp/download";
				 }
}
