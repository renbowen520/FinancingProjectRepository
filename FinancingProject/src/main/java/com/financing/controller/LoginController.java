package com.financing.controller;

import java.awt.Menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.bean.Member;



//�ÿ��Ʋ���Ҫ���������½ ע����ص�ҵ��
@Controller
@RequestMapping("/LoginController")
public class LoginController {

	
	@RequestMapping("/login")
	public String  login(String phone,String password) {
		System.out.println(phone);
		System.out.println(password);
		
		return "";
	}
	
	
	@RequestMapping("/register")//�û�ע��
	public String register(Member member) {   
	    System.out.println(member.getMember_name());	 
		 System.out.println(member.getMobile_Phone());
		 System.out.println(member.getPassword());
		System.out.println(member.getInvitedCode());
		System.out.println(member.getQqNumber());
		return "";
	}
	
	
}
