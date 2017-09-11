package com.financing.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Subject;

@Component
public class SubjectDao {
	
	
	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	//���������
	public void save(Subject subject){
		Session session=getSession();
		session.save(subject);
	}
	
	//�޸�֮ǰ�Ĳ�ѯ
	public Subject getById(int id){
		Session session=getSession();
		Subject subject=(Subject)session.get(Subject.class, id);
		return subject;
	}
	
	//�޸Ĺ�����
	public void update(Subject subject){
		Session session=getSession();
		session.update(subject);
	}
	
	//��ѯ������
	//��ʾ����
	public List<Subject> ListFixGet(Map map){
		String hql="from Subject where 0=0";
		hql=listDataHql(map, hql);
		Session session=getSession();
		List<Subject> listSubject=session.createQuery(hql).list();
		return listSubject;
	}
	
	//ģ����ѯ
	public String listDataHql(Map map,String hql){
		String sname=(String)map.get("name");
		if(sname!=null&&!sname.equals("")){
			hql+=" and name like '%"+sname+"%'";
		}
		return hql;
	}
	
	
}
