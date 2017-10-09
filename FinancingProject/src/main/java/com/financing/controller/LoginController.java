package com.financing.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.financing.Interface_service.IN_Member_account_service;
import com.financing.Interface_service.IN_Member_bankcards_service;
import com.financing.Interface_service.IN_Member_service;
import com.financing.Interface_service.IN_Users_service;
import com.financing.Interface_service.IN_award_records_service;
import com.financing.Interface_service.IN_bbin_info_service;
import com.financing.Interface_service.IN_user_role_service;
import com.financing.bean.Award_records;
import com.financing.bean.Bbin_info;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_bankcards;
import com.financing.bean.Member_profit_record;
import com.financing.bean.Subject_purchase_record;
import com.financing.bean.User_log;
import com.financing.bean.Users;




//该控制层主要用来处理前后台登陆 注册相关的业务
@Controller
@RequestMapping("/LoginController")
public class LoginController  {

	
	@Autowired
	private IN_Users_service IN_Users_service;
	
	
	@Autowired
	private IN_bbin_info_service  IN_bbin_info_service;
	
   @Autowired
	private IN_Member_service IN_Member_service;
	
   @Autowired
   private IN_award_records_service IN_award_records_service;
   
   @Autowired
    private IN_Member_account_service IN_Member_account_service;
 
   @Autowired
   private IN_Member_bankcards_service IN_Member_bankcards_service;
   
   @RequestMapping("/admin_out")
   public String  admin_out(HttpSession session,HttpServletRequest request) {  //后台退出
	     //退出日志
	   
	  Users users =  (Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login");
	  //   Users users=(Users) session.getAttribute("admin_login");
	     User_log  log= new User_log();
         log.setUsers(users);
         log.setAction(1);
         log.setCreate_date(new Date());
         log.setLogin_ip(IN_Users_service.getIpAddr(request));
         IN_Users_service.save_User_log(log);
         
	     //清空session
         SecurityUtils.getSubject().getSession().removeAttribute("admin_login");
       //  session.removeAttribute("admin_login");
	     SecurityUtils.getSubject().logout();
	     return "redirect:/IndexController/index";
   }
   
 
   @RequestMapping("/admin_logon")
   public String  admin_logon(HttpSession session,HttpServletRequest request) {  //后台注销
	     //清空session
	    //退出日志
	  Users users =  (Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login");
	//   Users users=(Users) session.getAttribute("admin_login");
	     User_log  log= new User_log();
           log.setUsers(users);
           log.setAction(1);
           log.setCreate_date(new Date());
           log.setLogin_ip(IN_Users_service.getIpAddr(request));
           IN_Users_service.save_User_log(log);
     //      session.removeAttribute("admin_login");
      SecurityUtils.getSubject().getSession().removeAttribute("admin_login");
 	       SecurityUtils.getSubject().logout();
	       return "redirect:/IndexController/adminLogin";
   }
   
   
   
   //后台登陆
 	@RequestMapping("adminLogin")
 	public String adminLogin(Users users,HttpServletRequest request) {
 		  System.out.println(users.getPassword());
 		  System.out.println(users.getMobile_Phone());
 		  org.apache.shiro.subject.Subject sub=SecurityUtils.getSubject();
 		  UsernamePasswordToken token = new UsernamePasswordToken(users.getMobile_Phone(),users.getPassword());
 		   try {
 			          sub.login(token);
 Session shiro_session=sub.getSession();
 		 	        Users users888= (Users) sub.getPrincipal();
 		 	   //     session.setAttribute("admin_login", users888);
 		       //	System.out.println("前台用户接受到了值:"+users888.getUser_name());
 				//	System.out.println("sessionId:"+session.getId());
 			  //	System.out.println("sessionHost:"+session.getHost());
 		//	System.out.println("sessionTimeout:"+shiro_session.getTimeout());
 				 //    return "redirect:/AdminController/admin";//登陆成功后调到后台
 		
 		 	    //    SecurityUtils.getSubject().getSession().setTimeout(600000);
 		 	      SecurityUtils.getSubject().getSession().setAttribute("admin_login", users888);
 			//登陆成功后添加登陆记录
 		           User_log  log= new User_log();
 		            log.setUsers(users888);
 		            log.setAction(0);
 		            log.setCreate_date(new Date());
 		            log.setLogin_ip(IN_Users_service.getIpAddr(request));
 		            IN_Users_service.save_User_log(log);
 				    return "redirect:/AdminController/admin";
 		   } catch (Exception e) {
 				    e.printStackTrace();
 				    token.clear();
 		            return "redirect:/IndexController/error";
 			 }
 	}
   

 	
	

   
   
   @RequestMapping("/out")
   public String out(HttpSession session) { //前台注销
	    session.removeAttribute("member_login");
	   return "redirect:/IndexController/index";
   }


	 @RequestMapping("/login")
	public String    login(HttpSession session,Member member0,Model model) {
         //根据手机号查询用户 
/*		 System.out.println(member0.getMobile_Phone());
		 System.out.println(member0.getPassword());*/
		 Member member = IN_Member_service.getByPhone(member0.getMobile_Phone()) ;
		   if(member!=null&&member.getStatus()==0) {  //查询到了,并且状态0
			   //输入的密码加密
			     String p1=   new Md5Hash(member0.getPassword(),member.getSalt()).toString();
			   //如果密码相同
			   if(p1.equals(member.getPassword())) {
				   session.setAttribute("member_login", member);
		   List<Member_bankcards>list=	IN_Member_bankcards_service.getById(member.getId());
		 //查询绑定的银行卡
		   session.setAttribute("member_bankcards_bk", list);
		   //查询账号
		   Member_account  member_account = IN_Member_account_service.getById(member.getId());
		   session.setAttribute("member_account", member_account);
		   
		   //查询投资金额
		   List<Subject_purchase_record>list2= IN_Member_service.get_money(member.getId());
		   double  m = 0;
		   if(!list2.isEmpty()) {
			      for (Subject_purchase_record s2 : list2) {
					m+=s2.getAmount();
				}
		   }
		//   System.out.println("投资金额:"+m);
		   
		   //查询所有利息
		   List<Member_profit_record>list3 = IN_Member_service.get_lixi(member.getId());
		   double  m2=0;
		   if(!list3.isEmpty()) {
			   for (Member_profit_record member_profit_record : list3) {
				m2+=member_profit_record.getAmount();
			}
		   }
	//	   System.out.println("利息金额:"+m2);  
	//	System.out.println("总金额"+m2+m+member_account.getUseable_balance() );
		   session.setAttribute("lixi", m2);
		   session.setAttribute("sum",m2+m+member_account.getUseable_balance() );
		   session.setAttribute("touzi",m );
		   
		   session.setAttribute("no_login", "");
				    //个人中心
				   return "redirect:/IndexController/personal_center";
			   }else {
				    session.setAttribute("no_login", "账号或者密码错误!");
					 return "redirect:/IndexController/login";
				   
			   }
		   }else { //没有查询到
			   session.setAttribute("no_login", "账号不存在或者被锁定!");
				 return "redirect:/IndexController/login"; //账号不存在
		   }
		 
		  
	}
	
	 
		@RequestMapping("/yz")  //验证手机号唯一性
		@ResponseBody
		public  String   yz(@RequestParam String mobile_Phone) {
	  Member member=		IN_Member_service.getByPhone(mobile_Phone);
		
		 boolean b ;
		   Map<String, Boolean> map = new HashMap<>();
		   if(member!=null) {
			  b=false;
		   }else {
			  b=true;
		   }
		   map.put("valid", b);
		   ObjectMapper mapper = new ObjectMapper();
	       String resultString = "";
	       try {
	           resultString = mapper.writeValueAsString(map);
	       } catch (JsonProcessingException e) {
	           e.printStackTrace();
	       }
	         return resultString;
		}
		
		
		@RequestMapping("/yz_ma")  //验证吗
		@ResponseBody
		public  String   yz_ma(@RequestParam String invitedCode) {
			Member member=		IN_Member_service.getByCode(invitedCode);
		
		 boolean b ;
		   Map<String, Boolean> map = new HashMap<>();
		   if(member!=null) {
			  b=true;
		   }else {
			  b=false;
		   }
		   map.put("valid", b);
		   ObjectMapper mapper = new ObjectMapper();
	       String resultString = "";
	       try {
	           resultString = mapper.writeValueAsString(map);
	       } catch (JsonProcessingException e) {
	           e.printStackTrace();
	       }
	         return resultString;
		}
		
		
		
	
	@RequestMapping("/register")//用户注册
	public String register(Member member,Model model,HttpSession session) {   
	  /*    System.out.println(member.getMember_name());	 
		  System.out.println(member.getMobile_Phone());
		  System.out.println(member.getPassword());
		  System.out.println("bei邀请码:"+member.getInvitationCode());
		  System.out.println(member.getQqNumber());*/
		 
		  //生产自己的邀请码
		     member.setInvitationCode(""+new Date().getTime());
		      member.setStatus(0); //账号 正常状态
		      String salt=  IN_Member_service.getma(10);//密码盐
		      member.setSalt(salt);//设置盐
		      String p1=   new Md5Hash(member.getPassword(),salt).toString();
		     member.setPassword(p1);  //设置加密的密码
		    member.setCreate_date(new Date());
		     
		      //体验金表
		     //注册赠送888体验金 
		     Bbin_info bbin_info= new Bbin_info();
			 bbin_info.setMember(member);
			 bbin_info.setAmont(888);
			 bbin_info.setStatus(0);//正常
			 bbin_info.setCreate_date(new Date());//添加时间
		     
		 //向奖励表添加
		 Award_records  a1 = new Award_records();
		 a1.setMember(member);
		 a1.setAddTime(new Date());
		 a1.setType(0);//注册
		 a1.setIsAward(0);//未奖励
	
		  //关联 账户
	 Member_account  m2= new Member_account();
	m2.setUseable_balance(0);
	m2.setImuseale_balance(0);
	m2.setTotal_profit(0);
	m2.setCreate_date(new Date());
	m2.setBonus_amount(0);
	m2.setInvest_amount(0);
	m2.setDelflag(0);
	m2.setMember(member);
	 
	 //全部保存  必须在一个事物中
	 IN_Member_service.saveAll(member, bbin_info, a1, m2);
	   //重新查询账号 
		Member   member999 =IN_Member_service.getByPhone(member.getMobile_Phone()) ;
		 session.setAttribute("member_login", member999);//存入session中
		 //进入个人中心
		 return "redirect:/IndexController/personal_center";
	}
	
	  
}
