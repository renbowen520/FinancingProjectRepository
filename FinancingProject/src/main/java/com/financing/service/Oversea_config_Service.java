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
	
	//���溣������
	public void save(Oversea_config oversea_config){
		this.oversea_config_Dao.save(oversea_config);
	}
	
	//�޸�֮ǰ�Ĳ�ѯ
	public Oversea_config getById(int id){
		return this.oversea_config_Dao.getById(id);
	}
	
	
	//�޸ĺ�������
	public void update(Oversea_config oversea_config){
		this.oversea_config_Dao.update(oversea_config);
	}
	
	//��ѯ��ʾ�������� 
	public List<Oversea_config> listOversea(){
		return this.oversea_config_Dao.listOversea();
	}
	
	//��ѯ��ʾ�������� 
	public List<Oversea_config_subscribe> listConfig(int id){
		return this.oversea_config_Dao.listConfig(id);
	}

}	