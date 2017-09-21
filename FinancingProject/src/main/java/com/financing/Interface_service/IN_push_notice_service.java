package com.financing.Interface_service;

import java.util.List;
import java.util.Map;

import com.financing.bean.Push_notice;

public interface IN_push_notice_service {
 List<Push_notice>list(Map map);
 void  delete(Push_notice push_notice);
 Push_notice getById(int id);
 void save(Push_notice push_notice);
}
