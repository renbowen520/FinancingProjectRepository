package com.financing.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financing.bean.News_type;
import com.financing.service.News_type_service;

@Controller
@RequestMapping("/News_type_Controller")
public class News_type_Controller {
	
	
	@Autowired
	private News_type_service news_type_service;
	
	
	@RequestMapping("/update")
	public String update(String id,String name,String info,String sort,String supType) {
	    News_type news_type =  this.news_type_service.getById(Integer.valueOf(id));
	    news_type.setUpdTime(new Date());
	    news_type.setInfo(info);
	    news_type.setName(name);
	    news_type.setSort(Integer.valueOf(sort));
        news_type.setSupType(Integer.valueOf(supType));
	     news_type_service.update(news_type);
		   return "redirect:/AdminController/menus6";
	}
	
	
	 @RequestMapping(value="/supType",produces="text/html;charset=UTF-8") 
	 @ResponseBody
	 public  String  supType(int id)  { //�첽�����ϼ��б�
		 News_type news_type = this.news_type_service.getById(id);
		 int  supType=news_type.getSupType();
		 if(supType==0) {
	    	 return "�����".toString();
	     }else {
	    	 return news_type_service.getById(supType).getName().toString();
	      }
	}
	 
	 
	 @RequestMapping("/list")
	 @ResponseBody
	 public List<News_type>list (){//�������е��б�
		   List<News_type>list = news_type_service.list_News_type();
		   return  list;
	 }
	 
	 @RequestMapping("/add")
	 public String add(News_type news_type) {  //�����Ѷ���
		     news_type.setAddTime(new Date());
		    System.out.println("a="+news_type.getAddTime());
		    news_type_service.save(news_type);
		    return "redirect:/AdminController/menus6";
	 }

/*	 @RequestMapping("/show")
	 public String show(Model model) {
		  List<News_type>list = news_type_service.list_News_type();//��ѯ����
		  model.addAttribute("news_type", list) ;
		  return  "admin/menus6";
	 }*/

	 @RequestMapping("/getById")
	 @ResponseBody
	 public News_type getById(int id) {
		   System.out.println("id="+id);
		   return   this.news_type_service.getById(id);
	 }
}
