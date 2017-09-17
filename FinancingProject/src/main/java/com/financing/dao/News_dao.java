package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.catalina.authenticator.SavedRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_News_dao;
import com.financing.bean.News;
import com.financing.bean.News_type;

@Component
public class News_dao  implements IN_News_dao{
  //新闻列表
	@Resource
	private SessionFactory sf;
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	public void update(News news) {
		  Session session = this.getSession();
		  session.update(news);
	}
	
	
	public News getById(int id) {
		  Session session = this.getSession();
		  News news = (News) session.get(News.class, id);
		  return  news;
	}
	
	
	public void save(News news) {
		    Session session = this.getSession();
		    session.save(news);
	}
	
	
	public  void delete(int id) {
		    Session session = this.getSession();
		    session.delete(session.get(News.class, id));
	}
	
	

	 
	public  List<News>list(Map map){  //查询所有的资讯
		  String hql="from  News   where  0=0    ";
		  Session session = this.getSession();
		    hql=  this.gethql(hql, map);
		   List<News>list = session.createQuery(hql).list();
		   return list;
	}
	
	public String gethql(String hql,Map map) {
		 String q1 = (String) map.get("q1");
		 String q2 = (String) map.get("q2");
		   if(!q1.equals("")&&q1!=null) {
			     hql+="    and  title like '%"+q1+"%'";
		   }
            if(!q2.equals("")&&q2!=null) {
            	  hql+="    and  typeId = "+q2;
		   }
            hql+="       order by  sort  asc";
		   return hql;
	}
}
