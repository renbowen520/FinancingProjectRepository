package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import com.financing.bean.Push_notice;



public interface IN_push_notice_dao {
	   List<Push_notice>list(Map map);
	   Push_notice getById(int id);
	   void  delete(Push_notice push_notice);
	   
}
