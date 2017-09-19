package com.financing.controller;

import javax.persistence.Index;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.bean.Member;

//ǰ̨��תҳ����صĿ��Ʋ�

@Controller
@RequestMapping("/IndexController")
public class IndexController {
        
	//��̨��½
	@RequestMapping("/adminLogin")
	public String adminLogin() {
		
		return "jsp/AdminLogin";
	}
	
	
	//��ҳ
	@RequestMapping("/index")
	public String Index() {
		return "jsp/index";
	}
	
	
	//������������
  @RequestMapping("/Online_experience_center")
  public String  Online_experience_center() {
	  return "jsp/Online_experience_center";
  }
  
  //��Ʒ����
	@RequestMapping("/product")
	public String  product() {
		return "jsp/product";
	}
	
	  //��������
		@RequestMapping("/news")
		public String  news() {
			return "jsp/news";
		}
		
		  //��ѧԺ
			@RequestMapping("/help")
			public String  help() {
				return "jsp/help";
			}
			
		
			  //Ͷ������
				@RequestMapping("/investment_research")
				public String  investment_research() {
					  return "jsp/investment_research";
				}
			
				 //��������  
				 @RequestMapping("/personal_center")
				 public String  personal_center(HttpSession session) {
					 Member member = (Member) session.getAttribute("member_login"); 
					if(member!=null) {
						  return "jsp/personal_center";
					}else {
						 return "jsp/login";
					}
					
				  }
				 
				 //��½
				 @RequestMapping("/login")
				 public String login() {
					 return "jsp/login";
				 }
				
				 //ע��
				 @RequestMapping("/register")
				 public String  register(HttpSession session) {
					 session.setAttribute("no_phone", "");
					 return "jsp/register";
				 }
				 
				 // ��������
				 @RequestMapping("/resetting")
				 public String   resetting() {
					 return "jsp/resetting";
				 }
				
				 // ��������
				 @RequestMapping("/download")
				 public String   download() {
					 return "jsp/download";
				 }
}
