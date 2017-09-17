package com.financing.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.Interface_dao.IN_Finance_product_funds_dao;
import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;


@Component
public class Finance_product_funds_Dao  implements IN_Finance_product_funds_dao {
	@Resource
	private SessionFactory sf;
	
	public Session getSession() {
		return this.sf.getCurrentSession();
	}
	
	//ģ����ѯ
	public String listDataHql(Map map,String hql){
		String sname=(String)map.get("sname");
		String status=(String)map.get("status");
		String type=(String)map.get("type");
		if(sname!=null&&!sname.equals("")){
			hql+=" and name like '%"+sname+"%'";
		}
		if(status!=null&&!status.equals("")){
			hql+=" and status like '%"+status+"%'";
		}
		if(type!=null&&!type.equals("")){
			hql+=" and type like '%"+type+"%'";
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
		String hql = "from Finance_product_subscribe where product_id="+id+" order by create_date desc";
		Session session=getSession();
		List<Finance_product_subscribe> listfinanceSubcribe=session.createQuery(hql).list();
		return listfinanceSubcribe;
	}
	
	
	//����˽ļǩ���ͬ
	public void savesubscribe(Finance_product_subscribe finance_product_subscribe){
		Session session=getSession();
		session.save(finance_product_subscribe);
	}
	
	//��ѯǩԼ����Ϣ
	public Finance_product_subscribe getSubscribeById(int id){
		Session session=getSession();
		Finance_product_subscribe sub=(Finance_product_subscribe)session.get(Finance_product_subscribe.class, id);
		return sub;
	}


	
}
