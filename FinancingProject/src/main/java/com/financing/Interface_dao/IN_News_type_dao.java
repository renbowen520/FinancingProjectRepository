package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.News_type;

public interface IN_News_type_dao {
	Session getSession();
	List<News_type>list_News_type(Map map);
	 News_type getById(int id);
	 void  save(News_type news_type);
	 void  update(News_type news_type);
	 List<News_type>list_News_type();
	  boolean  getsupType(int id);
}
