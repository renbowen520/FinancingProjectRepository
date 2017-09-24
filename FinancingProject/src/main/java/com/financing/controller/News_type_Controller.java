package com.financing.controller;
import java.util.Date;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financing.Interface_service.IN_News_service;
import com.financing.Interface_service.IN_News_type_service;
import com.financing.bean.News_type;
import com.financing.bean.Users;
import com.financing.service.News_type_service;

@Controller
@RequestMapping("/News_type_Controller")
public class News_type_Controller {
	
	
	@Autowired
	private IN_News_type_service news_type_service;
	
	@Autowired
	private IN_News_service IN_News_service;
	
	
	@RequestMapping("/de")  //删除
	public String de(int id999) {
	//	System.out.println("id==="+id999);
		   News_type news_type = news_type_service.getById(id999);
		    news_type.setStatus(1);
	        news_type.setUsers2((Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login"));
		    news_type.setUpdTime(new Date());
		     news_type_service.update(news_type);
	        return "redirect:/AdminController/menus6";
	}
	
	
	@RequestMapping("/update")
	public String update(int id2,String name2,String info2,int sort2,String x2) {
/*
		System.out.println("n="+id2);
		System.out.println("n="+name2);
		System.out.println("n="+info2);
		System.out.println("n="+sort2);
		System.out.println("n="+x2);*/
		   News_type news_type =  this.news_type_service.getById(id2);
	    news_type.setUpdTime(new Date());
	    news_type.setInfo(info2);
	    news_type.setName(name2);
	    news_type.setSort(sort2);
        news_type.setSupType(Integer.valueOf(x2));
        news_type.setUsers((Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login"));
	     news_type_service.update(news_type);
		   return "redirect:/AdminController/menus6";
	}
	
	 @RequestMapping(value="/boo",produces="text/html;charset=UTF-8") 
	 @ResponseBody
	public String boo(int id) {
		 //该方法判断 新闻类别有没有引用  或者本身是上级列表
		 boolean b =news_type_service.getsupType(id);
		 boolean b2=IN_News_service.getsupType(id);
		if(b||b2) { //只要有一个查询到有东西 
			return "0".toString();
		}else {
			return "1".toString();
		}
		
	
	 }
	
	
	 @RequestMapping(value="/supType",produces="text/html;charset=UTF-8") 
	 @ResponseBody
	 public  String  supType(int id)  { //异步请求上级列表
		 News_type news_type = this.news_type_service.getById(id);
		 int  supType=news_type.getSupType();
		 if(supType==0) {
	    	 return "根类别".toString();
	     }else {
	    	 return news_type_service.getById(supType).getName().toString();
	      }
	}
	 
	 
	 @RequestMapping("/list")
	 @ResponseBody
	 public List<News_type>list (){//加载所有的列表
		   List<News_type>list = news_type_service.list_News_type();
		   return  list;
	 }
	 
	 @RequestMapping("/add")
	 public String add(News_type news_type) {  //添加资讯类别
		     news_type.setAddTime(new Date());
	        news_type.setUsers((Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login"));
		 
	        
	        news_type_service.save(news_type);
		    return "redirect:/AdminController/menus6";
	 }


	 @RequestMapping("/getById")
	 @ResponseBody
	 public News_type getById(int id) {
		   System.out.println("id="+id);
		   return   this.news_type_service.getById(id);
	 }
}
