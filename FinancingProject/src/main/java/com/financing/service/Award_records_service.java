package com.financing.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_award_records_dao;
import com.financing.Interface_service.IN_award_records_service;
import com.financing.bean.Award_records;


@Service
@Transactional
public class Award_records_service implements IN_award_records_service {

	@Autowired
	private IN_award_records_dao IN_award_records_dao;
	
	@Override
	public void save(Award_records award_records) {
		 IN_award_records_dao.save(award_records);
	}
	

	//邀请奖励显示以及模糊查询
	public List<Award_records> listAward_records(Map map) {
		// TODO Auto-generated method stub
		return IN_award_records_dao.listaward_records(map);
	}
	
	//邀请记录表
	public List<Award_records> getAward_records(int id){
		return IN_award_records_dao.getAward_records(id);
	}
}
