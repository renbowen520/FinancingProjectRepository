package com.financing.controller;

import javax.persistence.Index;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.bean.Member;

//前台跳转页面相关的控制层

@Controller
@RequestMapping("/IndexController")
public class IndexController {
        
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
	public String  product() {
		return "jsp/product";
	}
	
	  //新闻中心
		@RequestMapping("/news")
		public String  news() {
			return "jsp/news";
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
