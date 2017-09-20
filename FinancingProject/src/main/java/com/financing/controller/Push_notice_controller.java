package com.financing.controller;

import java.sql.PseudoColumnUsage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.tribes.transport.bio.util.SingleRemoveSynchronizedAddLock;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financing.Interface_service.IN_push_notice_service;
import com.financing.bean.Push_notice;

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
	
	
	
	@RequestMapping("/delete/{id}") //ɾ��
	public String delete(@PathVariable("id")int  id) {
		Push_notice push_notice = IN_push_notice_service.getById(id);
		push_notice.setStatus(1);
		IN_push_notice_service.delete(push_notice);
	    return"redirect:/AdminController/menus17";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request) { //����
	  Push_notice  push_notice = new Push_notice();
	  push_notice.setTitle(request.getParameter("t1"));
	  push_notice.setContent(request.getParameter("t2"));
      push_notice.setStatus(0);
	 	push_notice.setCreate_date(new Date());	
	 	IN_push_notice_service.save(push_notice);
	 	 return"redirect:/AdminController/menus17";
	}
	
	@RequestMapping("/update")
	public String  update(Push_notice push_notice) throws ParseException {
		  // System.out.println(push_notice.getId());
		  // System.out.println(push_notice.getTitle());
		  //System.out.println(push_notice.getContent());
		   Push_notice pp= IN_push_notice_service.getById(push_notice.getId());
		    pp.setUpdate_date(new Date());
		    pp.setStatus(0);
		    pp.setContent(push_notice.getContent());
		    pp.setTitle(push_notice.getTitle());
	      IN_push_notice_service.delete(pp);  //���µķ���
		  return"redirect:/AdminController/menus17";
	}
	
	
}
