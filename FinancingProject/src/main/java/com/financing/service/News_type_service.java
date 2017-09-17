package com.financing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financing.bean.News_type;
import com.financing.dao.News_type_dao;

@Service
@Transactional
public class News_type_service {
  //资讯分类的service
	
	@Autowired
	private News_type_dao  news_type_dao;
	
	
	public List<News_type>list_News_type(){
		 return news_type_dao.list_News_type();
	}
	
	 public News_type getById(int id) {
		  return news_type_dao.getById(id);
	 }
	 
	 public void save(News_type news_type) {
		   news_type_dao.save(news_type);
	 }
	 
	 public void update(News_type news_type) {
		 news_type_dao.update(news_type);
	 }
}
