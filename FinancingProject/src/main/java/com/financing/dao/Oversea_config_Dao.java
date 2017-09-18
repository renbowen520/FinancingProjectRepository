package com.financing.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financing.bean.Oversea_config;
import com.financing.bean.Oversea_config_subscribe;

@Component
public class Oversea_config_Dao {
	
	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return this.sf.getCurrentSession();
	}
	
	//查询显示
	public List<Oversea_config> listOversea(){
		String hql="from Oversea_config where 0=0";
		Session session=getSession();
		List<Oversea_config> listOversea=session.createQuery(hql).list();
		return listOversea;
	}
	
	
	
	//新增
	public void save(Oversea_config oversea_config){
		Session session=getSession();
		session.save(oversea_config);
	}
	
	//修改之前的查询
	public Oversea_config getById(int id){
		Session session=getSession();
		Oversea_config oversea_config=(Oversea_config)session.get(Oversea_config.class, id);
		return oversea_config;
	}
	
	//修改
	public void update(Oversea_config oversea_config){
		Session session=getSession();
		session.update(oversea_config);
	}
	
	//查看预约(根据海外配置id查询预约表中的记录)
	//查询显示
	public List<Oversea_config_subscribe> listConfig(int id){
//		String hql="from Oversea_config_subscribe";
		String hql = "from Oversea_config_subscribe where oversea_id="+id+" order by create_date desc";
		Session session=getSession();
		List<Oversea_config_subscribe> listConfig=session.createQuery(hql).list();
		return listConfig;
	}
	
}
