package com.financing.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

	
	//���溣������
	@RequestMapping("/save")
	public String save(Oversea_config oversea_config,Model model,
			@RequestParam("file")MultipartFile mpf,HttpServletRequest request) throws IOException{
		oversea_config.setAddTime(new Date());
		oversea_config.setUpdTime(new Date());
		//����ϴ��ļ�������
		String  filename=mpf.getOriginalFilename();
		System.out.println("filename="+filename);
		String leftpath=request.getRealPath("/upload/");
		File file=new File(leftpath,filename);
		System.out.println("file="+file);
		if(!file.exists()){
			file.createNewFile();
		}
		//���ϴ����ļ����ݴ��͸��´������ļ�
		mpf.transferTo(file);
		oversea_config.setOversea_icon(filename);
		oversea_config_Service.save(oversea_config);
		return "redirect:/AdminController/menus4";
	}
	
	
	@RequestMapping("/addoversea")
	public String addoversea(){
		return "admin/addoversea";
	}
	
	//�޸�֮ǰ�Ĳ�ѯ
	@RequestMapping("/bfupdate/{id}")
	public String bfupdate(@PathVariable("id")int id,Model model){
		//oversea_config.setAddTime(new Date());
	 //	oversea_config.setUpdTime(new Date());
	   Oversea_config 	oversea_config=oversea_config_Service.getById(id);
		model.addAttribute("oversea_config", oversea_config);
		return "admin/gupdate";
	}
	
	//�޸ĺ�������
	@RequestMapping("/update")
	public String update(Oversea_config e,Model model){
	
		
		//���²�ѯһ��
		   Oversea_config 	ok=oversea_config_Service.getById(e.getId());
		   ok.setUpdTime(new Date());
		   ok.setTitle(e.getTitle());
		 ok.setDescription(e.getDescription());
         ok.setUser_type(e.getUser_type());
         ok.setSortColum(e.getSortColum());
         ok.setStatus(e.getStatus());
         ok.setEnd_date(e.getEnd_date());
         ok.setContext(e.getContext());
	/*	 System.out.println("id="+e.getId());
		 System.out.println("title"+e.getTitle());
		 System.out.println("miaosh==="+e.getDescription());
		 System.out.println("ȫ��===="+e.getUser_type());
		 System.out.println("����===="+e.getSortColum());
		 System.out.println("תͶ̥===="+e.getStatus());
		 System.out.println("����ʱ��"+e.getEnd_date());*/
		
      	this.oversea_config_Service.update(ok);
		return "redirect:/AdminController/menus4";
	}
	//�鿴�������ö���
	@RequestMapping("/config/{id}")
	public String listconfigrecord(Model model,@PathVariable("id")int id){
		List<Oversea_config_subscribe> listConfig=this.oversea_config_Service.listConfig(id);
		model.addAttribute("listConfig", listConfig);
		return "admin/gconfig";
	}
}
