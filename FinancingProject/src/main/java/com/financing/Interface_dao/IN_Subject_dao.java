package com.financing.Interface_dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;
import com.financing.bean.Subject_file;

public interface IN_Subject_dao {
	 Session getSession();
	 void save(Subject subject);
	 void savefile(Subject_file subject_file);
	 Subject getById(int id);
	 void update(Subject subject);
	 List<Subject> ListFixGet(Map map);
	 String listDataHql(Map map,String hql);
	 List<Subject_bbin_purchase_record> listsubjectrecord(int id);
	 String listHql(Map map,String hql);//前台模糊查询
	 List<Subject> listSubject(Map map);//前台显示所有
}
