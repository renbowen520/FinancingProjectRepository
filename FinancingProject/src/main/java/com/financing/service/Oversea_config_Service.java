package com.financing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financing.bean.Oversea_config;
import com.financing.bean.Oversea_config_subscribe;
import com.financing.dao.Oversea_config_Dao;

@Service
@Transactional
public class Oversea_config_Service {
	@Autowired
	private Oversea_config_Dao oversea_config_Dao;
	
	//保存海外配置
	public void save(Oversea_config oversea_config){
		this.oversea_config_Dao.save(oversea_config);
	}
	
	//修改之前的查询
	public Oversea_config getById(int id){
		return this.oversea_config_Dao.getById(id);
	}
	
	
	//修改海外配置
	public void update(Oversea_config oversea_config){
		this.oversea_config_Dao.update(oversea_config);
	}
	
	//查询显示海外配置 
	public List<Oversea_config> listOversea(){
		return this.oversea_config_Dao.listOversea();
	}
	
	//查询显示海外配置 订阅
	public List<Oversea_config_subscribe> listConfig(int id){
		return this.oversea_config_Dao.listConfig(id);
	}

}	
