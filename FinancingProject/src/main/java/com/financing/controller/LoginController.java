package com.financing.controller;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financing.Interface_service.IN_Member_service;
import com.financing.bean.Member;



//�ÿ��Ʋ���Ҫ���������½ ע����ص�ҵ��
@Controller
@RequestMapping("/LoginController")
public class LoginController  {

   @Autowired
	private IN_Member_service IN_Member_service;
	
   @RequestMapping("/out")
   public String out(HttpSession session) { //ע��
	    session.removeAttribute("member_login");
	   return "jsp/index";
	   
   }

   
	 @RequestMapping("/login")
	public String    login(HttpSession session,Member member0,Model model) {
         //�����ֻ��Ų�ѯ�û� 
		 System.out.println(member0.getMobile_Phone());
		 System.out.println(member0.getPassword());
		 Member member = IN_Member_service.getByPhone(member0.getMobile_Phone()) ;
		   if(member!=null) {  //��ѯ����
			   //������������
			     String p1=   new Md5Hash(member0.getPassword(),member.getSalt()).toString();
			   //���������ͬ
			   if(p1.equals(member.getPassword())) {
				   session.setAttribute("member_login", member);
				   session.setAttribute("no_login", "");
			//	   model.addAttribute("member_login", member);//����session
				//   model.addAttribute("no_login", "");
				   return  "jsp/personal_center"; //��������
			   }else {
				   session.setAttribute("no_login", "�˺Ż����������!");
			//	   model.addAttribute("no_login", "�˺Ż����������!");
			       return "jsp/login";
			   }
		   }else { //û�в�ѯ��
			   return "jsp/login"; //�˺Ų�����
		   }
		 
		  
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
