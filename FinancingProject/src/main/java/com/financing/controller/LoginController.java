package com.financing.controller;

import java.awt.Menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.bean.Member;



//�ÿ��Ʋ���Ҫ���������½ ע����ص�ҵ��
@Controller
@RequestMapping("/LoginController")
public class LoginController {

	
	
	@RequestMapping("/register")
	public String register(Member member) {   //�û�ע��
	    System.out.println(member.getMember_name());	 
		 System.out.println(member.getMobile_Phone());
		 System.out.println(member.getPassword());
		System.out.println(member.getInvitedCode());
		System.out.println(member.getQqNumber());
		return "";
	}
	
	
}
