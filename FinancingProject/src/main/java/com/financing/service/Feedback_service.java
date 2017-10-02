package com.financing.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financing.Interface_dao.IN_feedback_dao;
import com.financing.Interface_service.IN_feedback_service;
import com.financing.bean.Feedback;


@Service
@Transactional
public class Feedback_service  implements IN_feedback_service {

	@Autowired
	private IN_feedback_dao IN_feedback_dao;
	
	@Override
	public List<Feedback> list(Map map) {
		// TODO Auto-generated method stub
		return IN_feedback_dao.list(map);
	}

	@Override
	public Feedback getById(int id) {
		// TODO Auto-generated method stub
		return IN_feedback_dao.getById(id);
	}

	@Override
	public void save_feedback(Feedback feedback) {
		// TODO Auto-generated method stub
		IN_feedback_dao.save_feedback(feedback);
	}

}
