package com.financing.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
 	 public Users get_users(@PathVariable("id")int id) {   //异步请求 编辑前的查询
    	  Users users = IN_Users_service.getById(id);
    	  return users;
	 }
	
	
	 @RequestMapping("/up_users")
	 public String   up_users(Users users,int role_id) {  //更新账号
	    System.out.println("角色"+role_id);
	    System.out.println("id"+users.getId());
	    System.out.println("手机号"+users.getMobile_Phone());
	    System.out.println("密码:"+users.getPassword());
		//根据角色id查询实体类
	    User_role user_role = IN_user_role_service.getById(role_id);
	    Users  users2  = IN_Users_service.getById(users.getId());
	    //判断密码是不是空
	    if(users.getPassword()!=null && !users.getPassword().equals("")) {
	    	 //重新填写了
	    	//获取密码盐
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
	     return "redirect:/AdminController/menus19";
	}
	
	
	@RequestMapping("/yz")  //验证手机号唯一性
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
	   public String add_users(String a1,String a2,String a4,String a5) {  //添加账号
	 	/*  System.out.println(a1);
	 	  System.out.println(a2);
	 	  System.out.println(a4);
	 	  System.out.println(a5);*/
		   Users users = new Users();
		   User_role user_role=  IN_user_role_service.getById(Integer.valueOf(a5));
		   users.setUser_role(user_role);
		   users.setUser_name(a1);
		   users.setMobile_Phone(a4);
		  //设置密码
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
	public String de(String  delete_id) {  //删除账号
	//	 System.out.println("id="+delete_id);
		   Users users = IN_Users_service.getById(Integer.valueOf(delete_id));
		   users.setStatus(2);//删除状态
		   IN_Users_service.update(users);
		   return "redirect:/AdminController/menus19";
	}
	
}
