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




//�ÿ��Ʋ���Ҫ��������ǰ��̨��½ ע����ص�ҵ��
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
   public String  admin_out(HttpSession session,HttpServletRequest request) {  //��̨�˳�
	     //�˳���־
	   
	  Users users =  (Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login");
	  //   Users users=(Users) session.getAttribute("admin_login");
	     User_log  log= new User_log();
         log.setUsers(users);
         log.setAction(1);
         log.setCreate_date(new Date());
         log.setLogin_ip(IN_Users_service.getIpAddr(request));
         IN_Users_service.save_User_log(log);
         
	     //���session
         SecurityUtils.getSubject().getSession().removeAttribute("admin_login");
       //  session.removeAttribute("admin_login");
	     SecurityUtils.getSubject().logout();
	     return "redirect:/IndexController/index";
   }
   
 
   @RequestMapping("/admin_logon")
   public String  admin_logon(HttpSession session,HttpServletRequest request) {  //��̨ע��
	     //���session
	    //�˳���־
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
   
   
   
   //��̨��½
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
 		       //	System.out.println("ǰ̨�û����ܵ���ֵ:"+users888.getUser_name());
 				//	System.out.println("sessionId:"+session.getId());
 			  //	System.out.println("sessionHost:"+session.getHost());
 		//	System.out.println("sessionTimeout:"+shiro_session.getTimeout());
 				 //    return "redirect:/AdminController/admin";//��½�ɹ��������̨
 		
 		 	    //    SecurityUtils.getSubject().getSession().setTimeout(600000);
 		 	      SecurityUtils.getSubject().getSession().setAttribute("admin_login", users888);
 			//��½�ɹ�����ӵ�½��¼
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
   public String out(HttpSession session) { //ǰ̨ע��
	    session.removeAttribute("member_login");
	   return "redirect:/IndexController/index";
   }


	 @RequestMapping("/login")
	public String    login(HttpSession session,Member member0,Model model) {
         //�����ֻ��Ų�ѯ�û� 
/*		 System.out.println(member0.getMobile_Phone());
		 System.out.println(member0.getPassword());*/
		 Member member = IN_Member_service.getByPhone(member0.getMobile_Phone()) ;
		   if(member!=null&&member.getStatus()==0) {  //��ѯ����,����״̬0
			   //������������
			     String p1=   new Md5Hash(member0.getPassword(),member.getSalt()).toString();
			   //���������ͬ
			   if(p1.equals(member.getPassword())) {
				   session.setAttribute("member_login", member);
		   List<Member_bankcards>list=	IN_Member_bankcards_service.getById(member.getId());
		 //��ѯ�󶨵����п�
		   session.setAttribute("member_bankcards_bk", list);
		   //��ѯ�˺�
		   Member_account  member_account = IN_Member_account_service.getById(member.getId());
		   session.setAttribute("member_account", member_account);
		   
		   //��ѯͶ�ʽ��
		   List<Subject_purchase_record>list2= IN_Member_service.get_money(member.getId());
		   double  m = 0;
		   if(!list2.isEmpty()) {
			      for (Subject_purchase_record s2 : list2) {
					m+=s2.getAmount();
				}
		   }
		//   System.out.println("Ͷ�ʽ��:"+m);
		   
		   //��ѯ������Ϣ
		   List<Member_profit_record>list3 = IN_Member_service.get_lixi(member.getId());
		   double  m2=0;
		   if(!list3.isEmpty()) {
			   for (Member_profit_record member_profit_record : list3) {
				m2+=member_profit_record.getAmount();
			}
		   }
	//	   System.out.println("��Ϣ���:"+m2);  
	//	System.out.println("�ܽ��"+m2+m+member_account.getUseable_balance() );
		   session.setAttribute("lixi", m2);
		   session.setAttribute("sum",m2+m+member_account.getUseable_balance() );
		   session.setAttribute("touzi",m );
		   
		   session.setAttribute("no_login", "");
				    //��������
				   return "redirect:/IndexController/personal_center";
			   }else {
				    session.setAttribute("no_login", "�˺Ż����������!");
					 return "redirect:/IndexController/login";
				   
			   }
		   }else { //û�в�ѯ��
			   session.setAttribute("no_login", "�˺Ų����ڻ��߱�����!");
				 return "redirect:/IndexController/login"; //�˺Ų�����
		   }
		 
		  
	}
	
	 
		@RequestMapping("/yz")  //��֤�ֻ���Ψһ��
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
		
		
		@RequestMapping("/yz_ma")  //��֤��
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
		
		
		
	
	@RequestMapping("/register")//�û�ע��
	public String register(Member member,Model model,HttpSession session) {   
	  /*    System.out.println(member.getMember_name());	 
		  System.out.println(member.getMobile_Phone());
		  System.out.println(member.getPassword());
		  System.out.println("bei������:"+member.getInvitationCode());
		  System.out.println(member.getQqNumber());*/
		 
		  //�����Լ���������
		     member.setInvitationCode(""+new Date().getTime());
		      member.setStatus(0); //�˺� ����״̬
		      String salt=  IN_Member_service.getma(10);//������
		      member.setSalt(salt);//������
		      String p1=   new Md5Hash(member.getPassword(),salt).toString();
		     member.setPassword(p1);  //���ü��ܵ�����
		    member.setCreate_date(new Date());
		     
		      //������
		     //ע������888����� 
		     Bbin_info bbin_info= new Bbin_info();
			 bbin_info.setMember(member);
			 bbin_info.setAmont(888);
			 bbin_info.setStatus(0);//����
			 bbin_info.setCreate_date(new Date());//���ʱ��
		     
		 //���������
		 Award_records  a1 = new Award_records();
		 a1.setMember(member);
		 a1.setAddTime(new Date());
		 a1.setType(0);//ע��
		 a1.setIsAward(0);//δ����
	
		  //���� �˻�
	 Member_account  m2= new Member_account();
	m2.setUseable_balance(0);
	m2.setImuseale_balance(0);
	m2.setTotal_profit(0);
	m2.setCreate_date(new Date());
	m2.setBonus_amount(0);
	m2.setInvest_amount(0);
	m2.setDelflag(0);
	m2.setMember(member);
	 
	 //ȫ������  ������һ��������
	 IN_Member_service.saveAll(member, bbin_info, a1, m2);
	   //���²�ѯ�˺� 
		Member   member999 =IN_Member_service.getByPhone(member.getMobile_Phone()) ;
		 session.setAttribute("member_login", member999);//����session��
		 //�����������
		 return "redirect:/IndexController/personal_center";
	}
	
	  
}
