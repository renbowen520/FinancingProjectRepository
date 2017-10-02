package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.Feedback;

public interface IN_feedback_dao {
List<Feedback>list(Map  map);
Session getSession();
Feedback getById(int  id);
void save_feedback(Feedback feedback);
}
