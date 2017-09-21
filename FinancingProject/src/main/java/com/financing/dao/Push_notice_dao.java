package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
		  String hql="from  Push_notice   where  0=0    ";
		  Session session = this.getSession();
		    hql=  this.gethql(hql, map);
		   List<Push_notice>list = session.createQuery(hql).list();
		   return list;
	}

	
	public String gethql(String hql,Map map) {
		 String q1 = (String) map.get("q1");
		// String q2 = (String) map.get("q2");
		   if(!q1.equals("")&&q1!=null) {
			     hql+="    and  title like '%"+q1+"%'";
		   }
    /*      if(!q2.equals("")&&q2!=null) {
          	  hql+="    and  typeId = "+q2;
		   }
          hql+="       order by  sort  asc";*/
		   hql+="    order by status asc";
		   return hql;
	}

	@Override
	public void save(Push_notice push_notice) {
	  	 Session session = this.getSession();
	     session.save(push_notice);
		
	}
	
	
}
