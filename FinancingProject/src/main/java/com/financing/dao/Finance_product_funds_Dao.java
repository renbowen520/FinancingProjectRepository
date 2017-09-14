package com.financing.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;


@Component
public class Finance_product_funds_Dao {
	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	//ģ����ѯ
	public String listDataHql(Map map,String hql){
		String sname=(String)map.get("sname");
		if(sname!=null&&!sname.equals("")){
			hql+=" and name like '%"+sname+"%'";
		}
		return hql;
	}
	//��ѯ��ʾ
	public List<Finance_product_funds> listfinance(Map map){
		String hql="from Finance_product_funds where 0=0";
		Session session=getSession();
		hql=listDataHql(map, hql);
		List<Finance_product_funds> listfinance=session.createQuery(hql).list();
		return listfinance;
	}
	
	
	
	//����
	public void save(Finance_product_funds finance_product_funds){
		Session session=getSession();
		session.save(finance_product_funds);
	}
	
	//�޸�֮ǰ�Ĳ�ѯ
	public Finance_product_funds getById(int id){
		Session session=getSession();
		Finance_product_funds finance_product_funds=(Finance_product_funds)session.get(Finance_product_funds.class, id);
		return finance_product_funds;
	}
	
	//�޸�
	public void update(Finance_product_funds finance_product_funds){
		Session session=getSession();
		session.update(finance_product_funds);
	}
	
	//�鿴ԤԼ 
	//��ѯ��ʾ
	public List<Finance_product_subscribe> listfinanceSubscribe(int id){
		String hql="from Finance_product_subscribe";
		Session session=getSession();
		List<Finance_product_subscribe> listfinanceSubcribe=session.createQuery(hql).list();
		return listfinanceSubcribe;
	}
	
}