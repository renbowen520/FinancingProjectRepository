package com.financing.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;

@Component
public class SubjectDao {
	
	
	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	//保存固收类
	public void save(Subject subject){
		Session session=getSession();
		session.save(subject);
	}
	
	//修改之前的查询
	public Subject getById(int id){
		Session session=getSession();
		Subject subject=(Subject)session.get(Subject.class, id);
		return subject;
	}
	
	//修改固收类
	public void update(Subject subject){
		Session session=getSession();
		session.update(subject);
	}
	
	//查询固收类
	//显示所有
	public List<Subject> ListFixGet(Map map){
		String hql="from Subject where 0=0";
		Session session=getSession();
		hql=listDataHql(map, hql);
		List<Subject> listSubject=session.createQuery(hql).list();
		return listSubject;
	}
	
	//模糊查询
	public String listDataHql(Map map,String hql){
		String sname=(String)map.get("sname");
		String stype=(String)map.get("stype");
		String status=(String)map.get("status");
		if(sname!=null&&!sname.equals("")){
			hql+=" and name like '%"+sname+"%'";
		}
		if(stype!=null&&!stype.equals("")){
			hql+=" and type like '%"+stype+"%'";
		}
		if(status!=null&&!status.equals("")){
			hql+=" and status like '%"+status+"%'";
		}
		return hql;
	}
	//查看记录
	//查询显示
	public List<Subject_bbin_purchase_record> listsubjectrecord(int id){
		String hql="from Subject_bbin_purchase_record";
		Session session=getSession();
		List<Subject_bbin_purchase_record> listsubjectrecord=session.createQuery(hql).list();
		return listsubjectrecord;
	}
	
	//付息计划显示所有信息
	public List<Subject> listsubject(Map map){
		System.err.println("123");
		String hql="from Subject where 0=0";
		Session session=getSession();
		hql=listsubjectM(map, hql);
		List<Subject> listsubject=session.createQuery(hql).list();
		return listsubject;
	}
	//付息计划模糊查询
	public String listsubjectM(Map map,String hql){
		String namem=(String)map.get("namem");
		String typem=(String)map.get("typem");
		String statusm=(String)map.get("statusm");
		if (namem!=null && !namem.equals("")) {
			hql+="and name like '%"+namem+"%' ";
		}
		if (typem!=null && !typem.equals("")) {
			hql+="and type like '%"+typem+"%'";
		}
		if (statusm!=null && !statusm.equals("")) {
			hql+="and status like '%"+statusm+"%'";
		}
		return hql;
	}
}
