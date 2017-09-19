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



//�ÿ��Ʋ���Ҫ���������½ ע����ص�ҵ��
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
   public String out(HttpSession session) { //ע��
	    session.removeAttribute("member_login");
	   return "jsp/index";
	   
   }

   @RequestMapping("/r")
   public String r() {
	   return "jsp/register";
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
	public String register(Member member,String ma,Model model,HttpSession session) {   
	    //  System.out.println(member.getMember_name());	 
		//  System.out.println(member.getMobile_Phone());
		//  System.out.println(member.getPassword());
		//  System.out.println("������:"+ma);
		//  System.out.println(member.getQqNumber());
		  // ���Ȳ�ѯ�ֻ��ǲ��Ǳ�ע����
		  Member member55 = IN_Member_service.getByPhone(member.getMobile_Phone());
		  if(member55==null) {//�ֻ�û�б�ע��
		  //�����Լ���������
		  member.setInvitationCode(""+new Date().getTime());
		  if(ma!=null &&!ma.equals("")) {
			   //�����д�� ������  ��ô��Ҫ��ѯ
		   Member	   member2 = IN_Member_service.getByCode(ma);
		   if(member2!=null) {//��ѯ������������ȷ��
			   //�����Լ��ı�������
			   member.setInvitedCode(member2.getInvitationCode());
		   }//û�оͲ�д
		  } 
		      member.setStatus(0); //�˺� ����״̬
		      String salt=  IN_Member_service.getma(10);//������
		      member.setSalt(salt);//������
		      String p1=   new Md5Hash(member.getPassword(),salt).toString();
		     member.setPassword(p1);  //���ü��ܵ�����
		 
		  //�����˺�
		  IN_Member_service.save(member);
		  //�����ֻ��Ų�ѯ������ӵ�id
	    Member member33=	  IN_Member_service.getByPhone(member.getMobile_Phone());
	//	 System.out.println("id="+member33.getId());
		//ע������888����� 
		 Bbin_info bbin_info= new Bbin_info();
		 bbin_info.setMember(member33);
		 bbin_info.setAmont(888);
		 bbin_info.setStatus(0);//����
		 bbin_info.setCreate_date(new Date());//���ʱ��
		 IN_bbin_info_service.save(bbin_info);
		 //���������
		 Award_records  a1 = new Award_records();
		 Award_records  a2 = new Award_records();
		 a2.setMember(member33);
		 a1.setMember(member33);
		 a1.setAddTime(new Date());
		 a2.setAddTime(new Date());
		 a1.setType(0);//ע��
		 a1.setIsAward(0);
		 a2.setType(1);//Ͷ��
		 a2.setIsAward(0);
		 IN_award_records_service.save(a1);//����
		 IN_award_records_service.save(a2);
		 session.setAttribute("member_login", member33);//����session��
		 session.setAttribute("no_phone", "");
	     return "jsp/personal_center"; //�����������
	}else { //�ֻ��ű�ע����
		 session.setAttribute("member_register",member );
		 session.setAttribute("no_phone", "�ֻ������ѱ�ע��!");
		 return "redirect:/LoginController/r";
	}
}
}