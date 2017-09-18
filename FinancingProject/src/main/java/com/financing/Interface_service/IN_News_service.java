package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import com.financing.bean.News;

public interface IN_News_service {
	void update(News news) ;
	News getById(int id) ;
	 void  save(News news);
	 void delete(int id);
	 List<News>list(Map map);
	 

}
