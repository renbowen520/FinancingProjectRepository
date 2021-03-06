package com.financing.Interface_dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;
import com.financing.bean.Subject_file;
import com.financing.bean.Subject_purchase_record;

public interface IN_Subject_dao {
	 Session getSession();
	 void save(Subject subject);
	 void savefile(Subject_file subject_file);
	 Subject getById(int id);
	 void update(Subject subject);
	 List<Subject> ListFixGet(Map map);
	 String listDataHql(Map map,String hql);
	 List<Subject_purchase_record> listsubjectrecord(int id);
	 List<Subject> listsubject(Map map);


	 List<Subject> listSubject(Map map);
	 String listHql(Map map,String hql);
	 List<Subject>list_Subject_4();
	 List<Subject> ListFixGet2(Map map);
	 BigInteger  get_count(int  id);
}
