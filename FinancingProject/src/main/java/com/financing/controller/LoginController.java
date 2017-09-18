package com.financing.controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.financing.bean.Member;



//该控制层主要用来处理登陆 注册相关的业务
@Controller
@RequestMapping("/LoginController")
public class LoginController  {

	
	@RequestMapping("/login")
	public String  login(String phone,String password) {
		System.out.println(phone);
		System.out.println(password);
		/*Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(phone,password);
		try{
			subject.login(token);
			Session session=subject.getSession();
			System.out.println("sessionId:"+session.getId());
			System.out.println("sessionHost:"+session.getHost());
			System.out.println("sessionTimeout:"+session.getTimeout());
			session.setAttribute("info", "session的数据");
			return "redirect:/index.jsp";
		}catch(Exception e){
			e.printStackTrace();
		}*/
		return "";
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
