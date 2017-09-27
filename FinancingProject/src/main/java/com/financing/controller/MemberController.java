package com.financing.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.financing.Interface_service.IN_Member_bankcards_service;
import com.financing.Interface_service.IN_Member_service;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_bankcards;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Subject_purchase_record;
import com.financing.bean.Users;

@Controller
@RequestMapping("/MemberController")
public class MemberController {

	
	@Autowired 
	private IN_Member_service member_service;
	
	@Autowired
	private IN_Member_bankcards_service IN_Member_bankcards_service;
	
	
	
	@RequestMapping("/bk")   //��
	public String bk(HttpSession session) {
	    Member member = (Member) session.getAttribute("member_login");
	     if(member!=null) {
	    	return "jsp/bk";
	     }else {
	    	  return "redirect:/IndexController/index"; 
	     }
		
		
		
	}
	
	
	
	@RequestMapping("cz")  //��ֵ
	public String cz(HttpSession session) {
	    Member member = (Member) session.getAttribute("member_login");
     if(member!=null) {
    	    //����id��ѯ�ǲ��ǰ��� 
    	 List<Member_bankcards>list = IN_Member_bankcards_service.getById(member.getId());
            if(!list.isEmpty()) {  //����
            	return "";
            }else {  //û�а�
            	  return "redirect:/MemberController/bk"; 
            }
     }else {
    	  return "redirect:/IndexController/index"; 
     }
    
	}
	
	
	
	
	@RequestMapping("/pwd2")   //�޸��������ʱ��֤ԭ����
	 @ResponseBody
	 public String pwd2(@RequestParam String pwd111, HttpSession session) { 
		    Member member = (Member) session.getAttribute("member_login");
	
	
		    String p = member.getWithdraw_password();
	     String p2=   new Md5Hash(pwd111,member.getSalt2()).toString();
	   /*  System.out.println("=="+pwd);
	     System.out.println("p===="+p);
	     System.out.println("p2====="+p2);*/
	     boolean b;
	     Map<String, Boolean> map = new HashMap<>();
	      if(p.equals(p2)) {
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
	
	
	@RequestMapping("/up_withdraw_password")
	public String  up_withdraw_password(String  pwd222,HttpSession session) {
	//	System.out.println("����ȡ������=="+pwd222);
		//�޸��������
		
		Member member = (Member) session.getAttribute("member_login");
	
		if(member!=null) {
		
		//���ݵ�½��id ��ѯʵ����
		Member member2 = member_service.getById(member.getId());
		//�õ�������
	     String y = member_service.getma(10);
       String p1=   new Md5Hash(pwd222,y).toString();
       //����ʱ�䣬�Σ�����
       member2.setWithdraw_password(p1);
       member2.setSalt2(y);
       member2.setUpdate_date(new Date());
       member_service.update(member2);
      //����session�д洢��
       session.setAttribute("member_login", member2);
       //��������
	    return "redirect:/IndexController/personal_center";
	    
		}else {
			  return "redirect:/IndexController/index"; 
		}
	}
	
	
	
	
	@RequestMapping("/withdraw_password")
	public String  withdraw_password(String  pwd7,HttpSession session) {
	//	System.out.println("����ȡ������=="+pwd7);
		//�����������
		Member member = (Member) session.getAttribute("member_login");
	
		if(member!=null) {
		
		//���ݵ�½��id ��ѯʵ����
		Member member2 = member_service.getById(member.getId());
		//�õ�������
	     String y = member_service.getma(10);
       String p1=   new Md5Hash(pwd7,y).toString();
       //����ʱ�䣬�Σ�����
       member2.setWithdraw_password(p1);
       member2.setSalt2(y);
       member2.setUpdate_date(new Date());
       member_service.update(member2);
      //����session�д洢��
       session.setAttribute("member_login", member2);
       //��������
	    return "redirect:/IndexController/personal_center";
	    
		}else {
			  return "redirect:/IndexController/index"; 
		}
	}
	
	
	
	@RequestMapping("/up_pwd")
	public String  up_pwd(String pwd,HttpSession session) {  //�޸�����
		Member member = (Member) session.getAttribute("member_login");
	
		if(member!=null) {	
		
		//���ݵ�½��id ��ѯʵ����
		Member member2 = member_service.getById(member.getId());
		//�õ�������
	     String y = member_service.getma(10);
        String p1=   new Md5Hash(pwd,y).toString();
       //����ʱ�䣬�Σ�����
        member2.setPassword(p1);
        member2.setSalt(y);
        member2.setUpdate_date(new Date());
        member_service.update(member2);
       //����session�д洢��
        session.setAttribute("member_login", member2);
        //��������
	    return "redirect:/IndexController/personal_center";
	    
		}else {
	    	  return "redirect:/IndexController/index"; 
	
	    }
	}
	
	
	 @RequestMapping("/pwd")   //�޸�����ʱ��֤ԭ����
	 @ResponseBody
	 public String pwd(@RequestParam String pwd, HttpSession session) { 
		    Member member = (Member) session.getAttribute("member_login");
	     String p = member.getPassword();
	     String p2=   new Md5Hash(pwd,member.getSalt()).toString();
	   /*  System.out.println("=="+pwd);
	     System.out.println("p===="+p);
	     System.out.println("p2====="+p2);*/
	     boolean b;
	     Map<String, Boolean> map = new HashMap<>();
	      if(p.equals(p2)) {
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
	
	
	
	@RequestMapping("/zhanghao")
	public String menus8(Model model,@ModelAttribute("mname")String mname,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("member_namem")String member_namem,@ModelAttribute("invitatioinCodem")String invitatioinCodem) {
		Map map=new HashMap<>();
		map.put("mname", mname);
		map.put("mobile_Phonem", mobile_Phonem);
		map.put("member_namem", member_namem);
		map.put("invitatioinCodem", invitatioinCodem);
		List<Member> listmember=this.member_service.listMember(map);
		model.addAttribute("listmember", listmember);
		return "admin/menus8";
	}
	
	@RequestMapping("/menus25/{id}")
	public String menus25(Model model,@ModelAttribute("id")int id){
		List<Member> listmemberByid=this.member_service.getMemberByid(id);//�˺���Ϣ
		System.out.println(listmemberByid.size());
		List<Member_account> member_account =this.member_service.getMember_accountByid(id);//�ʽ���Ϣ
		List<Subject_purchase_record> subject_purchase_record =this.member_service.getSubject_purchase_record(id);//Ͷ�ʼ�¼
		List<Member_withdraw_record> member_withdraw_record = this.member_service.getMember_withdraw_recordByid(id);//���ּ�¼
		List<Member_deposit_record> member_deposit_record = this.member_service.getMember_deposit_recordByid(id);//��ֵ��¼
		model.addAttribute("listmemberByid", listmemberByid.get(0));
		model.addAttribute("member_account", member_account.get(0));
		model.addAttribute("member_withdraw_record", member_withdraw_record);
		model.addAttribute("member_deposit_record", member_deposit_record);
		model.addAttribute("subject_purchase_record", subject_purchase_record);
		return"admin/menus25";
	}
}
