package com.financing.dao;


import java.util.Date;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import com.financing.Interface_dao.IN_Subject_dao;
import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;
import com.financing.bean.Subject_file;

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
	
	//��������ļ�
	public void savefile(Subject_file subject_file){
		Session session=getSession();
		session.save(subject_file);
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
	
	
	//ǰ̨ģ����ѯ 
	public String listHql(Map map,String hql){
		String type=(String)map.get("type");
		String year_rate=(String)map.get("year_rate");
		String status=(String)map.get("status");
	    String period_start=(String)map.get("period_start");
	    String period_end=(String)map.get("period_end");
		String flag=(String)map.get("flag");
		   if(status!=null&&!status.equals("")){
			   if(status.equals("-1")){
				   
			   }else{
				   hql+=" and status="+Integer.valueOf(status);
			   }
			    
		   }
		   if((period_start!=null&&!period_start.equals(""))&&(period_end!=null&&!period_end.equals(""))){
			      if(period_end.equals("-1")){
			    	  hql+=" and period >="+Integer.valueOf(period_start);
			      }else{
				    hql+=" and period between "+Integer.valueOf(period_start)+ " and "+Integer.valueOf(period_end);
			      }
		   }
		   if(year_rate!=null&&!year_rate.equals("")){
			   if("0".equals(flag)){
				   hql+="and year_rate="+Double.valueOf(year_rate);
			   }else if("1".equals(flag)){
				   hql+="and year_rate>"+Double.valueOf(year_rate);
			   }
		   }
		   System.out.println("hql="+hql);
		  return hql;
	}
	
	//��ʾ����ǰ̨
	public List<Subject> listSubject(Map map){
		String hql="from Subject where 0=0";
		Session session=getSession();
		hql=listHql(map, hql);
		List<Subject> listSubject=session.createQuery(hql).list();
		return listSubject;
	}
	
	//��ѯ������
	//��ʾ���к�̨
	public List<Subject> ListFixGet(Map map){
		String hql="from Subject where 0=0";
		Session session=getSession();
		hql=listDataHql(map, hql);
		List<Subject> listSubject=session.createQuery(hql).list();
		return listSubject;
	}
	
	//ģ����ѯ��̨
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
	
	//��Ϣ�ƻ���ʾ������Ϣ
	public List<Subject> listsubject(Map map){
		System.err.println("123");
		String hql="from Subject where 0=0";
		Session session=getSession();
		hql=listsubjectM(map, hql);
		List<Subject> listsubject=session.createQuery(hql).list();
		return listsubject;
	}
	//��Ϣ�ƻ�ģ����ѯ
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
