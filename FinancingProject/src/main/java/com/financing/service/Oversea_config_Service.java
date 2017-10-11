package com.financing.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financing.Interface_dao.IN_Oversea_config_dao;
import com.financing.Interface_service.IN_Oversea_config_service;
import com.financing.bean.Oversea_config;
import com.financing.bean.Oversea_config_subscribe;
import com.financing.dao.Oversea_config_Dao;

@Service
@Transactional
public class Oversea_config_Service implements IN_Oversea_config_service {
	@Autowired
	private IN_Oversea_config_dao oversea_config_Dao;
	
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
	
	//��ѯ��ʾ�������� ����
	public List<Oversea_config_subscribe> listConfig(int id){
		return this.oversea_config_Dao.listConfig(id);
	}

}	
