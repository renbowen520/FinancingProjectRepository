package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_feedback_dao;
import com.financing.bean.Feedback;
import com.financing.bean.Push_notice;

@Component
public class Feedback_dao implements IN_feedback_dao {

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	
	public void save_feedback(Feedback feedback) {
		   Session session = this.getSession();
		   session.save(feedback);
	}
	
	public Feedback getById(int  id) {
		  Session session = this.getSession();
		  Feedback feedback = (Feedback) session.get(Feedback.class, id);
          return feedback;
	}
	
	
	@Override
	public List<Feedback> list(Map map) {
		  String hql="from   Feedback  f    where  0=0    ";
		  Session session = this.getSession();
		    hql=  this.gethql(hql, map);
		   List<Feedback>list = session.createQuery(hql).list();
		   return list;
	}

	public String gethql(String hql,Map map) {
		 String q1 = (String) map.get("feedback_q1");
		 String q2 = (String) map.get("feedback_q2");
		 if(!q1.equals("")&&q1!=null) {
			     hql+="    and  f.title like '%"+q1+"%'";
		   }
         if(!q2.equals("")&&q2!=null) {
         	  hql+="    and  f.member.member_name   like  '%"+q2+"%'";
		   }
         hql+=  "    order by create_date  desc ";
		   return hql;
	}

}
