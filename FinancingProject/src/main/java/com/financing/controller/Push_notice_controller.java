package com.financing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.Interface_service.IN_push_notice_service;
import com.financing.bean.Push_notice;

@Controller
@RequestMapping("/Push_notice_controller")
public class Push_notice_controller {

	@Autowired
	private IN_push_notice_service IN_push_notice_service;
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")int  id) {
		Push_notice push_notice = IN_push_notice_service.getById(id);
		push_notice.setStatus(1);
		IN_push_notice_service.delete(push_notice);
	    return"redirect:/AdminController/menus17";
	}
}
