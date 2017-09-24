package com.financing.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financing.Interface_dao.IN_News_type_dao;
import com.financing.Interface_service.IN_News_type_service;
import com.financing.bean.News_type;
import com.financing.dao.News_type_dao;

@Service
@Transactional
public class News_type_service implements IN_News_type_service {
  //资讯分类的service
	
	@Autowired
	private IN_News_type_dao  news_type_dao;
	
	
	public List<News_type>list_News_type(Map map){
		 return news_type_dao.list_News_type(map);
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

	@Override
	public List<News_type> list_News_type() {
		// TODO Auto-generated method stub
		return news_type_dao.list_News_type();
	}

	@Override
	public boolean getsupType(int id) {
		// TODO Auto-generated method stub
		return news_type_dao.getsupType(id);
	}


}
