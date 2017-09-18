package com.financing.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;


@Component
public class Finance_product_funds_Dao {
	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	//模糊查询
	public String listDataHql(Map map,String hql){
		String sname=(String)map.get("sname");
		int status=(Integer)map.get("status");
		String type=(String)map.get("type");
		if(sname!=null&&!sname.equals("")){
			hql+=" and name like '%"+sname+"%'";
		}
		if(status!=-1){
			hql+=" and status="+status;
		}
		if(type!=null&&!type.equals("")){
			hql+=" and type='"+type+"'";
		}
		return hql;
	}
	//查询显示
	public List<Finance_product_funds> listfinance(Map map){
		String hql="from Finance_product_funds where 0=0";
		Session session=getSession();
		hql=listDataHql(map, hql);
		List<Finance_product_funds> listfinance=session.createQuery(hql).list();
		return listfinance;
	}
	
	
	
	//新增
	public void save(Finance_product_funds finance_product_funds){
		Session session=getSession();
		session.save(finance_product_funds);
	}
	
	//修改之前的查询
	public Finance_product_funds getById(int id){
		Session session=getSession();
		Finance_product_funds finance_product_funds=(Finance_product_funds)session.get(Finance_product_funds.class, id);
		return finance_product_funds;
	}
	
	//修改
	public void update(Finance_product_funds finance_product_funds){
		Session session=getSession();
		session.update(finance_product_funds);
	}
	
	
	//签署失败前查询
	public Finance_product_subscribe getsubscribe(int id){
		Session session=getSession();
		Finance_product_subscribe finance_product_subscribe=(Finance_product_subscribe)session.get(Finance_product_subscribe.class, id);
		return finance_product_subscribe;
	}
	
	//签署失败
	public void lose(int id){
		Session session=this.getSession();
		Finance_product_subscribe finance_product_subscribe=this.getsubscribe(id);
		finance_product_subscribe.setStatus(3);
		session.update(finance_product_subscribe);
	}
	
	//查看签署状态
	public List<Finance_product_subscribe> listfinanceSubscribe(int id){
		String hql = "from Finance_product_subscribe where product_id="+id+" order by create_date desc";
		Session session=getSession();
		List<Finance_product_subscribe> listfinanceSubcribe=session.createQuery(hql).list();
		return listfinanceSubcribe;
	}
	
	
	//保存私募签署合同
	public void savesubscribe(Finance_product_subscribe finance_product_subscribe){
		Session session=getSession();
		finance_product_subscribe.setStatus(1);
		session.update(finance_product_subscribe);
	}
	
	public void updatesubscribe(Finance_product_subscribe finance_product_subscribe){
		Session session=getSession();
		session.update(finance_product_subscribe);
	}
	
	//查询签约人信息
	public Finance_product_subscribe getSubscribeById(int id){
		Session session=getSession();
		Finance_product_subscribe sub=(Finance_product_subscribe)session.get(Finance_product_subscribe.class, id);
		return sub;
	}
	
	
}
