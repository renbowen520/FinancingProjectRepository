package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.News;

public interface IN_News_dao {
	Session getSession();
	void update(News news);
	 News getById(int id);
	 void save(News news);
	 void delete(int id) ;
	 List<News>list(Map map);
	 String gethql(String hql,Map map);
}
