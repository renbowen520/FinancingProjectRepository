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



//该控制层主要用来处理登陆 注册相关的业务
@Controller
@RequestMapping("/LoginController")
public class LoginController  {

   @Autowired
	private IN_Member_service IN_Member_service;
	
   @RequestMapping("/out")
   public String out(HttpSession session) { //注销
	    session.removeAttribute("member_login");
	   return "jsp/index";
	   
   }

   
	 @RequestMapping("/login")
	public String    login(HttpSession session,Member member0,Model model) {
         //根据手机号查询用户 
		 System.out.println(member0.getMobile_Phone());
		 System.out.println(member0.getPassword());
		 Member member = IN_Member_service.getByPhone(member0.getMobile_Phone()) ;
		   if(member!=null) {  //查询到了
			   //输入的密码加密
			     String p1=   new Md5Hash(member0.getPassword(),member.getSalt()).toString();
			   //如果密码相同
			   if(p1.equals(member.getPassword())) {
				   session.setAttribute("member_login", member);
				   session.setAttribute("no_login", "");
			//	   model.addAttribute("member_login", member);//存入session
				//   model.addAttribute("no_login", "");
				   return  "jsp/personal_center"; //个人中心
			   }else {
				   session.setAttribute("no_login", "账号或者密码错误!");
			//	   model.addAttribute("no_login", "账号或者密码错误!");
			       return "jsp/login";
			   }
		   }else { //没有查询到
			   return "jsp/login"; //账号不存在
		   }
		 
		  
	}
	
	
	@RequestMapping("/register")//用户注册
	public String register(Member member) {   
	    System.out.println(member.getMember_name());	 
		 System.out.println(member.getMobile_Phone());
		 System.out.println(member.getPassword());
		System.out.println(member.getInvitedCode());
		System.out.println(member.getQqNumber());
		return "";
	}
	
	
}
