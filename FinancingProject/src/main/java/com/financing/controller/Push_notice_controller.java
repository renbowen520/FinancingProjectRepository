package com.financing.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.transport.bio.util.SingleRemoveSynchronizedAddLock;
import org.apache.shiro.SecurityUtils;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financing.Interface_service.IN_push_notice_service;
import com.financing.bean.Push_notice;
import com.financing.bean.Users;

@Controller
@RequestMapping("/Push_notice_controller")
public class Push_notice_controller {

	@Autowired
	private IN_push_notice_service IN_push_notice_service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public Push_notice getById(int id) {
	Push_notice   push_notice  =IN_push_notice_service.getById(id);
		return push_notice;
	}
	
	
	
	@RequestMapping("/delete/{id}") //删除
	public String delete(@PathVariable("id")int  id) {
		Push_notice push_notice = IN_push_notice_service.getById(id);
		push_notice.setStatus(1);
		IN_push_notice_service.delete(push_notice);
	    return"redirect:/AdminController/menus17";
	}
	
	@RequestMapping("/add")
	public String add(String t1,String t2,HttpSession session) { //新增
	  Push_notice  push_notice = new Push_notice();
	  push_notice.setTitle(t1);
	  push_notice.setContent(t2);
      push_notice.setStatus(0);//状态
	//	 Users users = (Users) session.getAttribute("admin_login");

	   Users users =  (Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login");
      push_notice.setUsers(users);//发布人
	 	push_notice.setCreate_date(new Date());	
	 	IN_push_notice_service.save(push_notice);
	 	 return"redirect:/AdminController/menus17";
	}
	
	@RequestMapping("/update")
	public String  update(Push_notice push_notice,HttpSession session)  {
		   Push_notice pp= IN_push_notice_service.getById(push_notice.getId());
		    pp.setUpdate_date(new Date());
		    pp.setStatus(0);
		    pp.setContent(push_notice.getContent());
		    pp.setTitle(push_notice.getTitle());
		    
		//    Users users2 =  (Users)session.getAttribute("admin_login"); 
		  Users users2 =  (Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login");
           pp.setUsers2(users2);//更新人
	      IN_push_notice_service.delete(pp);  //更新的方法
		  return"redirect:/AdminController/menus17";
	}
	
	
}
