package com.financing.controller;
import java.util.Date;

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
import com.financing.Interface_service.IN_award_records_service;
import com.financing.Interface_service.IN_bbin_info_service;
import com.financing.bean.Award_records;
import com.financing.bean.Bbin_info;
import com.financing.bean.Member;



//该控制层主要用来处理登陆 注册相关的业务
@Controller
@RequestMapping("/LoginController")
public class LoginController  {

	@Autowired
	private IN_bbin_info_service  IN_bbin_info_service;
	
   @Autowired
	private IN_Member_service IN_Member_service;
	
   @Autowired
   private IN_award_records_service IN_award_records_service;
   
   @RequestMapping("/out")
   public String out(HttpSession session) { //注销
	    session.removeAttribute("member_login");
	   return "jsp/index";
	   
   }

   @RequestMapping("/r")
   public String r() {
	   return "jsp/register";
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
	public String register(Member member,String ma,Model model,HttpSession session) {   
	    //  System.out.println(member.getMember_name());	 
		//  System.out.println(member.getMobile_Phone());
		//  System.out.println(member.getPassword());
		//  System.out.println("邀请码:"+ma);
		//  System.out.println(member.getQqNumber());
		  // 首先查询手机是不是被注册了
		  Member member55 = IN_Member_service.getByPhone(member.getMobile_Phone());
		  if(member55==null) {//手机没有被注册
		  //生产自己的邀请码
		  member.setInvitationCode(""+new Date().getTime());
		  if(ma!=null &&!ma.equals("")) {
			   //如果填写了 邀请码  那么需要查询
		   Member	   member2 = IN_Member_service.getByCode(ma);
		   if(member2!=null) {//查询到邀请码是正确的
			   //设置自己的被邀请码
			   member.setInvitedCode(member2.getInvitationCode());
		   }//没有就不写
		  } 
		      member.setStatus(0); //账号 正常状态
		      String salt=  IN_Member_service.getma(10);//密码盐
		      member.setSalt(salt);//设置盐
		      String p1=   new Md5Hash(member.getPassword(),salt).toString();
		     member.setPassword(p1);  //设置加密的密码
		 
		  //保存账号
		  IN_Member_service.save(member);
		  //根据手机号查询出新添加的id
	    Member member33=	  IN_Member_service.getByPhone(member.getMobile_Phone());
	//	 System.out.println("id="+member33.getId());
		//注册赠送888体验金 
		 Bbin_info bbin_info= new Bbin_info();
		 bbin_info.setMember(member33);
		 bbin_info.setAmont(888);
		 bbin_info.setStatus(0);//正常
		 bbin_info.setCreate_date(new Date());//添加时间
		 IN_bbin_info_service.save(bbin_info);
		 //向奖励表添加
		 Award_records  a1 = new Award_records();
		 Award_records  a2 = new Award_records();
		 a2.setMember(member33);
		 a1.setMember(member33);
		 a1.setAddTime(new Date());
		 a2.setAddTime(new Date());
		 a1.setType(0);//注册
		 a1.setIsAward(0);
		 a2.setType(1);//投资
		 a2.setIsAward(0);
		 IN_award_records_service.save(a1);//保存
		 IN_award_records_service.save(a2);
		 session.setAttribute("member_login", member33);//存入session中
		 session.setAttribute("no_phone", "");
	     return "jsp/personal_center"; //进入个人中心
	}else { //手机号被注册了
		 session.setAttribute("member_register",member );
		 session.setAttribute("no_phone", "手机号码已被注册!");
		 return "redirect:/LoginController/r";
	}
}
}