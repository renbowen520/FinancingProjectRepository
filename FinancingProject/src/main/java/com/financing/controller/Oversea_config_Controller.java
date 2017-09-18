package com.financing.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.financing.Interface_service.IN_Oversea_config_service;
import com.financing.bean.Oversea_config;
import com.financing.bean.Oversea_config_subscribe;
import com.financing.service.Oversea_config_Service;

@Controller
@RequestMapping("/oversea")
public class Oversea_config_Controller {
	@Autowired
	private IN_Oversea_config_service oversea_config_Service;
	
	@RequestMapping("/menus4")
	//查询海外配置
	public String menus4(Model model){
		List<Oversea_config> listOversea=this.oversea_config_Service.listOversea();
		model.addAttribute("listOversea", listOversea);
		return "admin/menus4";
	}
	
	//保存海外配置
	@RequestMapping("/save")
	public String save(Oversea_config oversea_config,Model model){
		oversea_config.setAddTime(new Date());
		oversea_config.setUpdTime(new Date());
		oversea_config_Service.save(oversea_config);
		return "redirect:/oversea/menus4";
	}
	
	
	@RequestMapping("/addoversea")
	public String addoversea(){
		return "admin/addoversea";
	}
	
	//修改之前的查询
	@RequestMapping("/bfupdate/{id}")
	public String bfupdate(@PathVariable("id")int id,Model model,Oversea_config oversea_config){
		oversea_config.setAddTime(new Date());
		oversea_config.setUpdTime(new Date());
		oversea_config=oversea_config_Service.getById(id);
		model.addAttribute("oversea_config", oversea_config);
		return "admin/gupdate";
	}
	
	//修改海外配置
	@RequestMapping("/update")
	public String update(Oversea_config oversea_config,Model model){
		oversea_config.setAddTime(new Date());
		oversea_config.setUpdTime(new Date());
		this.oversea_config_Service.update(oversea_config);
		return "redirect:/oversea/menus4";
	}
	//查看海外配置订阅
	@RequestMapping("/config/{id}")
	public String listconfigrecord(Model model,@PathVariable("id")int id){
		List<Oversea_config_subscribe> listConfig=this.oversea_config_Service.listConfig(id);
		model.addAttribute("listConfig", listConfig);
		return "admin/gconfig";
	}
}
