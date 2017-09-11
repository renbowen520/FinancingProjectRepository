package com.financing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//前台跳转页面相关的控制层

@Controller
@RequestMapping("/IndexController")
public class IndexController {
        
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
				 public String  personal_center() {
					  return "jsp/personal_center";
				  }
				 
				 //登陆
				 @RequestMapping("/login")
				 public String login() {
					 return "jsp/login";
				 }
				
				 //注册
				 @RequestMapping("/register")
				 public String  register() {
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
