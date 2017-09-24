package com.financing.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.startup.PasswdUserDatabase;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.financing.Interface_service.IN_Member_service;
import com.financing.Interface_service.IN_Users_service;
import com.financing.Interface_service.IN_user_role_service;
import com.financing.bean.User_role;
import com.financing.bean.Users;

@Controller
@RequestMapping("/UsersController")
public class UsersController {

	
	@Autowired
	private IN_Users_service IN_Users_service;
	
	@Autowired
	private IN_user_role_service IN_user_role_service;
	
	@Autowired
	private IN_Member_service  IN_Member_service;
	
	 @RequestMapping("/get_users/{id}")
	 @ResponseBody 
 	 public Users get_users(@PathVariable("id")int id) {   //�첽���� �༭ǰ�Ĳ�ѯ
    	  Users users = IN_Users_service.getById(id);
    	  return users;
	 }
	
	 @RequestMapping("/show_add")
	 public String show_add() {
		 
		 return "admin/show_add";
	 }
	 
	
	 @RequestMapping("/up_users")
	 public String   up_users(Users users,int role_id) {  //�����˺�
	 /*   System.out.println("��ɫ"+role_id);
	    System.out.println("id"+users.getId());
	    System.out.println("�ֻ���"+users.getMobile_Phone());
	    System.out.println("����:"+users.getPassword());*/
		//���ݽ�ɫid��ѯʵ����
	    User_role user_role = IN_user_role_service.getById(role_id);
	    Users  users2  = IN_Users_service.getById(users.getId());
	    //�ж������ǲ��ǿ�
	    if(users.getPassword()!=null && !users.getPassword().equals("")) {
	    	 //������д��
	    	//��ȡ������
	    	       String y = IN_Member_service.getma(10);
			       String p1=   new Md5Hash(users.getPassword(),y).toString();
			       users2.setPassword(p1);
				    users2.setSalt(y);
	    }
	     users2.setStatus(0);
	     users2.setUser_name(users.getUser_name());
	     users2.setUser_role(user_role);
	     users2.setUpdate_date(new Date());
	     IN_Users_service.update(users2);
         SecurityUtils.getSubject().getSession().setAttribute("admin_login",users2);  

	     return "redirect:/AdminController/menus19";
	}
	
	 
	 
	 @RequestMapping("/up_admin_pwd")
	 @ResponseBody
	 public boolean up_admin_pwd(String  pwd) {
		 Users users =  (Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login");
         //���ݵ�½��id ��ѯʵ����
		 Users    users22 = IN_Users_service.getById(users.getId());
		//�õ�������
		     String y = IN_Member_service.getma(10);
	         String p1=   new Md5Hash(pwd,y).toString();
            //����ʱ�䣬�Σ�����
	         users22.setPassword(p1);
            users22.setSalt(y);
            users22.setUpdate_date(new Date());
            IN_Users_service.update(users22);
            //����session�д洢��
            SecurityUtils.getSubject().getSession().setAttribute("admin_login",users22);  
       Users  Users99=   (Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login");
            System.out.println("���º������:"+Users99.getPassword());
            
            return true;
	 }
	 
	 
	 @RequestMapping("/pwd")   //�޸�����ʱ��֤ԭ����
	 @ResponseBody
	 public String pwd(@RequestParam String pwd) { 
		 Users users =  (Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login");
	     String p = users.getPassword();
	     String p2=   new Md5Hash(pwd,users.getSalt()).toString();
	/*      System.out.println("=="+pwd);
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
	 
	 
	
	@RequestMapping("/yz")  //��֤�ֻ���Ψһ��
	@ResponseBody
	public  String   yz(@RequestParam String a4) {
	   Users users=	 IN_Users_service.getByPhone(a4);
	 boolean b ;
	   Map<String, Boolean> map = new HashMap<>();
	   if(users!=null) {
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
	
	  @RequestMapping("/add_users")
	   public String add_users(String a1,String a2,String a4,String a5) {  //����˺�
	 	/*  System.out.println(a1);
	 	  System.out.println(a2);
	 	  System.out.println(a4);
	 	  System.out.println(a5);*/
		   Users users = new Users();
		   User_role user_role=  IN_user_role_service.getById(Integer.valueOf(a5));
		   users.setUser_role(user_role);
		   users.setUser_name(a1);
		   users.setMobile_Phone(a4);
		  //��������
		     String y = IN_Member_service.getma(10);
		     String p1=   new Md5Hash(a2,y).toString();
		     users.setSalt(y);
		      users.setPassword(p1);
		     users.setStatus(0);
		     users.setCreate_date(new Date());
		     IN_Users_service.save_users(users);
		     return "redirect:/AdminController/menus19";
	  }
	
	@RequestMapping("/de")
	public String de(String  delete_id) {  //ɾ���˺�
	//	 System.out.println("id="+delete_id);
		   Users users = IN_Users_service.getById(Integer.valueOf(delete_id));
		   users.setStatus(2);//ɾ��״̬
		   users.setUpdate_date(new Date());  //����ʱ��
		   IN_Users_service.update(users);
		   return "redirect:/AdminController/menus19";
	}
	
}
