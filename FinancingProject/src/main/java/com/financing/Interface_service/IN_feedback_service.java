package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.financing.bean.Feedback;


public interface IN_feedback_service {
	 Feedback getById(int  id);
	List<Feedback>list(Map map);
	void save_feedback(Feedback feedback);
}
