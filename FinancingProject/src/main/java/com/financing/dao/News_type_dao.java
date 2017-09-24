package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
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
	
	public  List<News_type>list_News_type(Map map){  //查询所有的资讯类别
		  String hql="from  News_type  n  where     n.status = 0  ";
		  Session session = this.getSession();
		    hql=  this.gethql(hql, map);
		  List<News_type>list = session.createQuery(hql).list();
		  return list;
	}
	
	

	public String gethql(String hql,Map map) {
		 String q1 = (String) map.get("news_type_q1");
		 String q2 = (String) map.get("news_type_q2");
		   if(!q1.equals("")&&q1!=null) {
			     hql+="    and  n.name  like '%"+q1+"%'";
		   }
           if(!q2.equals("")&&q2!=null) {
        	   hql+="    and  n.users.user_name  like '%"+q2+"%'";
		   }
           hql+="       order by  sort  asc";
		   return hql;
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

	@Override
	public List<News_type> list_News_type() {
		  String hql="from  News_type  n  where   n.status = 0  ";
		  Session session = this.getSession();
		  List<News_type>list = session.createQuery(hql).list();
		  return list;
	}
	
	public  boolean  getsupType(int id) {
		  Session session = this.getSession();
		  Query query = session.createQuery("from News_type  where  supType=:id");
		  query.setInteger("id", id);
		  List<News_type>list = query.list();

		  if(list.size()>0) {
			    return true;  
		  }else {
				 return false;   
				
		  }
	
	}
	
}
