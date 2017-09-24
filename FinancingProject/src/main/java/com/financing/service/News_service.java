package com.financing.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financing.Interface_dao.IN_News_dao;
import com.financing.Interface_service.IN_News_service;
import com.financing.bean.News;
import com.financing.dao.News_dao;

@Service
@Transactional
public class News_service implements IN_News_service  {
      
	  @Autowired
	   private IN_News_dao news_dao;
	  
	  public void update(News news) {
		 news_dao.update(news);
	  }
	  
	  public News getById(int id) {
		    return news_dao.getById(id);
	  }
	  
	  public void  save(News news) {
		  news_dao.save(news);
	  }
	  
	  
	  public void delete(int id) {
		  news_dao.delete(id);
	  }
	  
	  
	  public List<News>list(Map map){
		  return  news_dao.list(map);
	  }

	@Override
	public boolean getsupType(int id) {
		// TODO Auto-generated method stub
		return news_dao.getsupType(id);
	}
	  
}
