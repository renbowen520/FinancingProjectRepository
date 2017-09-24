package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import com.financing.bean.News_type;

public interface IN_News_type_service {
	 List<News_type>list_News_type(Map  map);
	 News_type getById(int id);
	 void save(News_type news_type);
	 void update(News_type news_type);
	  List<News_type>list_News_type();
	  boolean  getsupType(int id);
}
