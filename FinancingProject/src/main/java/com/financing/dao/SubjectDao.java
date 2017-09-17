package com.financing.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Subject_dao;
import com.financing.bean.Oversea_config_subscribe;
import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;

@Component
public class SubjectDao implements IN_Subject_dao {
	
	
	@Resource
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
		Session session=getSession();
		hql=listDataHql(map, hql);
		List<Subject> listSubject=session.createQuery(hql).list();
		return listSubject;
	}
	
	//ģ����ѯ
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
	//�鿴��¼
	//��ѯ��ʾ
	public List<Subject_bbin_purchase_record> listsubjectrecord(int id){
		String hql="from Subject_bbin_purchase_record where subject_id="+id;
		Session session=getSession();
		List<Subject_bbin_purchase_record> listsubjectrecord=session.createQuery(hql).list();
		return listsubjectrecord;
	}
}
