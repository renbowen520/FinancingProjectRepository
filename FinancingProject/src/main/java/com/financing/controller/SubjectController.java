package com.financing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.bean.Subject;
import com.financing.service.SubjectService;



@Controller
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	//跳到新增页面
	@RequestMapping("/addfixget")
	public String addfixget(){
		return "addfixget";
	}
	
	//保存固收类
	@RequestMapping("/save")
	public String save(Subject subject){
		subjectService.save(subject);
		return "redirect:/AdminController/menus1";
	}
	@RequestMapping("/bfupdate/{id}")
	//修改之前的查询
	public String bfupdate(@PathVariable("id")int id,Model model){
		Subject subject=subjectService.getById(id);
		model.addAttribute("subject", subject);
		return "redirect:/subject/update";
	}
	//修改固收类
	public String update(Subject subject){
		this.subjectService.update(subject);
		return "redirect:/AdminController/menus1";
	}
}
