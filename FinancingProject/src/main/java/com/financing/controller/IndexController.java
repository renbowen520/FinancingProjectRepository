package com.financing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//ǰ̨��תҳ����صĿ��Ʋ�

@Controller
@RequestMapping("/IndexController")
public class IndexController {
        
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
				 public String  personal_center() {
					  return "jsp/personal_center";
				  }
				 
				 //��½
				 @RequestMapping("/login")
				 public String login() {
					 return "jsp/login";
				 }
				
				 //ע��
				 @RequestMapping("/register")
				 public String  register() {
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
