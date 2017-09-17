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
    public String update(@RequestParam("file1")MultipartFile file1,
    		HttpServletRequest request,String zd,News news,String typeId) throws IOException {
    	News news2 = news_service.getById(news.getId()); //数据库中原来的
    	  news2.setTitle(news.getTitle());
    	  news2.setText(news.getText());
    	  news2.setSort(news.getSort());
    	  news2.setInfo(news.getInfo());
    	  news2.setNews_type(news_type_service.getById(Integer.valueOf(typeId)));
	         if(zd!=null &&!zd.equals("")) {
	        	  news2.setPlacTop(0);//置顶
	         }else {
	        	  news2.setPlacTop(1); //不置顶
	         }
	         String filename=file1.getOriginalFilename();
	         if(!file1.equals("")&&file1!=null) {//有文件上传
	    	       news2.setcPhoto(filename);
	      		   String path=request.getRealPath("/upload/");
	         	   File newFile=new File(path,filename);
	   		      if(!newFile.exists()){
	   			        newFile.createNewFile();
	   		        }
	   	  	         file1.transferTo(newFile);      //把上传的文件内容传送给新创建的文件
	         }else {//没有
	        	   
	         }
    	    news2.setUpdTime(new Date());//更新时间
    	   news_service.update(news2);
    	    return"redirect:/AdminController/menus7";
    }
	
	
	//编辑前的查询
	@RequestMapping("/update1/{id}")
	public String update1(@PathVariable("id")String id,Model model,HttpServletRequest request) {
	//	 System.out.println("id="+id);
		 News news = news_service.getById(Integer.valueOf(id));
		   String path=request.getRealPath("/upload/");
		   System.out.println(news.getcPhoto());
		//  String path2=path+"\\"+news.getcPhoto();
		   model.addAttribute("news_bean", news);
		//   System.out.println(path2);
		//   model.addAttribute("news_c", path2);
		 return "admin/news_update";
	}
	
	
	
	@RequestMapping("/add1")
	public String add1() {
	   return "admin/News_add";
	}
	
    @RequestMapping("/add2")  
    public String save(@RequestParam("file1")MultipartFile file1,
    		HttpServletRequest request,String zd,News news,String typeId) throws IOException {  
    	//获取上传的文件名称
    	   //    System.out.println("标题"+news.getTitle());
    	    //   System.out.println("内容"+news.getText());
    	    //   System.out.println("排序"+news.getSort());
    	     //  System.out.println("简介"+news.getInfo());
    	       news.setAddTime(new Date());
    	    System.out.println("分类"+typeId);
    	   //     System.out.println("添加时间"+news.getAddTime());
    	         news.setNews_type(news_type_service.getById(Integer.valueOf(typeId)));
    	         if(zd!=null &&!zd.equals("")) {
    	        	 news.setPlacTop(0);//置顶
    	         }else {
    	        	 news.setPlacTop(1);
    	         }
    		  	 String filename=file1.getOriginalFilename();
    		     news.setcPhoto(filename);
   		  String path=request.getRealPath("/upload/");
          System.out.println("path="+path);
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
	public String delete(String did) {
		System.out.println("did="+did);
		news_service.delete(Integer.valueOf(did));
		return"redirect:/AdminController/menus7";
	}
	
	
}
