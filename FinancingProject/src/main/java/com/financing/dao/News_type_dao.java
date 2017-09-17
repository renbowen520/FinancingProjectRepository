package com.financing.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_News_type_dao;
import com.financing.bean.News_type;

@Component
public class News_type_dao implements IN_News_type_dao {

	//资讯分类的dao
	@Resource
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	public  List<News_type>list_News_type(){  //查询所有的资讯类别
		  String hql="from  News_type  order by  sort  asc";
		  Session session = this.getSession();
		  List<News_type>list = session.createQuery(hql).list();
		  return list;
	}
	
	public News_type getById(int id) {  //根据id获取实体类
		  Session session = this.getSession();
		  News_type news_type=  (News_type) session.get(News_type.class, id);
		  return news_type;
	}
	
	public void  save(News_type news_type) {//保存
		    Session session = this.getSession();
		    session.save(news_type);
	}
	
	public void  update(News_type news_type) {//修改
	    Session session = this.getSession();
	    session.update(news_type);
}
}
