package com.financing.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.financing.Interface_service.IN_News_service;
import com.financing.Interface_service.IN_News_type_service;
import com.financing.bean.News;
import com.financing.bean.Users;
import com.financing.service.News_service;
import com.financing.service.News_type_service;

import antlr.collections.impl.IntRange;

@Controller
@RequestMapping("/News_Controller")
public class News_Controller {

	@Autowired
	private IN_News_service news_service;
     
	@Autowired
	private IN_News_type_service news_type_service;
	
    @RequestMapping("/update2")  
    public String update(@RequestParam("file88")MultipartFile file88,
    		HttpServletRequest request,String zd,News news,int typeId) throws IOException {
    	News news2 = news_service.getById(news.getId()); //数据库中原来的
    	  news2.setTitle(news.getTitle());
    	  news2.setText(news.getText());
    	  news2.setSort(news.getSort());
    	  news2.setInfo(news.getInfo());
    	  news2.setNews_type(news_type_service.getById(typeId));
	         if(zd!=null &&!zd.equals("")) {
	        	  news2.setPlacTop(0);//置顶
	         }else {
	        	  news2.setPlacTop(1); //不置顶
	         }
	    	   news.setUsers2((Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login"));
	         news2.setUpdTime(new Date());//更新时间
	         String filename=file88.getOriginalFilename();
	         
	         if(!filename.equals("")&&filename!=null) {//有文件上传
	    	       news2.setcPhoto(filename);
	      		   String path=request.getRealPath("/upload/");
	         	   File newFile=new File(path,filename);
	   		      if(!newFile.exists()){
	   			        newFile.createNewFile();
	   		        }
	   	  	         file88.transferTo(newFile);      //把上传的文件内容传送给新创建的文件
	         }else {//没有
	        	//   System.out.println("没有文件上传");
	         }
    	
    	   news_service.update(news2);
    	    return"redirect:/AdminController/menus7";
    }
	
	
	//编辑前的查询
	@RequestMapping("/update1/{id}")
	public String update1(@PathVariable("id")int id,Model model,HttpServletRequest request) {

		  News news = news_service.getById(id);
		   model.addAttribute("news_bean", news);
		  return "admin/news_update";
	}
	
	
	
	@RequestMapping("/add1")
	public String add1() {
	   return "admin/News_add";
	}
	
    @RequestMapping("/add2")  
    public String save(@RequestParam("file1")MultipartFile file1,
    		HttpServletRequest request,String zd,News news,int typeId) throws IOException {  
    	//获取上传的文件名称
    	   //    System.out.println("标题"+news.getTitle());
    	    //   System.out.println("内容"+news.getText());
    	    //   System.out.println("排序"+news.getSort());
    	     //  System.out.println("简介"+news.getInfo());
    	       news.setAddTime(new Date());
    	      news.setNews_type(news_type_service.getById(Integer.valueOf(typeId)));
    	         if(zd!=null &&!zd.equals("")) {
    	        	 news.setPlacTop(0);//置顶
    	         }else {
    	        	 news.setPlacTop(1);//不置顶
    	         }
    	         //添加人
    	   news.setUsers((Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login"));
    		  	 String filename=file1.getOriginalFilename();
    		     news.setcPhoto(filename);
    		  //   System.out.println("filename="+filename);
   		  String path=request.getRealPath("/upload/");
   //       System.out.println("path="+path);
      	  File newFile=new File(path,filename);
		 if(!newFile.exists()){
			newFile.createNewFile();
		}
		//把上传的文件内容传送给新创建的文件
		file1.transferTo(newFile);
     	news_service.save(news);
		return"redirect:/AdminController/menus7";
    }  
	
	@RequestMapping("/delete")
	public String delete(int did) {
	     News news = news_service.getById(did);
	     news.setUpdTime(new Date());
	     news.setStatus(1);
         news.setUsers2((Users) SecurityUtils.getSubject().getSession().getAttribute("admin_login"));
         news_service.update(news);
//		news_service.delete(Integer.valueOf(did));
		return"redirect:/AdminController/menus7";
	}
	
	
}
