package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Delete;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_push_notice_dao;
import com.financing.bean.News;
import com.financing.bean.Push_notice;

@Component
public class Push_notice_dao implements IN_push_notice_dao {

	@Resource
	private SessionFactory sf;
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	
	//查询最新的5条公告
	public  List<Push_notice>  list_5(){
		     String sql="SELECT * from push_notice order by create_date desc  limit     0,5   ";
		     Session session = this.getSession();
		     Query query = session.createSQLQuery(sql).addEntity(Push_notice.class);
		      List<Push_notice>list =query.list();
		      return list;
	}
	
	
	public Push_notice getById(int id) {
		Session session = this.getSession();
		Push_notice push_notice = (Push_notice) session.get(Push_notice.class, id);
          return push_notice;
	}
	
	
	public void  delete(Push_notice push_notice) {
		Session session = this.getSession();
	     session.update(push_notice);
	}
	
	
	@Override
	public List<Push_notice> list(Map map) {
		  String hql="from  Push_notice  p   where  0=0    ";
		  Session session = this.getSession();
		    hql=  this.gethql(hql, map);
		   List<Push_notice>list = session.createQuery(hql).list();
		   return list;
	}

	
	public String gethql(String hql,Map map) {
		 String q1 = (String) map.get("push_q1");
		 String q2 = (String) map.get("push_q2");
		   if(!q1.equals("")&&q1!=null) {
			     hql+="    and  p.title like '%"+q1+"%'";
		   }
      if(!q2.equals("")&&q2!=null) {
    	       hql+="    and  p.users.user_name  like '%"+q2+"%'";
		   }
        
		   hql+="    order by status asc,create_date  desc";
		   return hql;
	}

	@Override
	public void save(Push_notice push_notice) {
	  	 Session session = this.getSession();
	     session.save(push_notice);
		
	}
	
	
}
