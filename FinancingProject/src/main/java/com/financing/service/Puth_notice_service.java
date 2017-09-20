package com.financing.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_push_notice_dao;
import com.financing.Interface_service.IN_push_notice_service;
import com.financing.bean.Push_notice;


@Service
@Transactional
public class Puth_notice_service  implements IN_push_notice_service{

	@Autowired
	private IN_push_notice_dao IN_push_notice_dao;
	
	@Override
	public List<Push_notice> list(Map map) {
		// TODO Auto-generated method stub
		return IN_push_notice_dao.list(map);
	}

	@Override
	public void delete(Push_notice push_notice) {
	IN_push_notice_dao.delete(push_notice);
		
	}

	@Override
	public Push_notice getById(int id) {
		// TODO Auto-generated method stub
		return IN_push_notice_dao.getById(id);
	}

}
