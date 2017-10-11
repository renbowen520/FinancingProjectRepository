package com.financing.Interface_service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;
import com.financing.bean.Subject_file;
import com.financing.bean.Subject_purchase_record;

public interface IN_Subject_service {
	void save(Subject subject);
	void savefile(Subject_file subject_file);
	 void update(Subject subject);
	 List<Subject> listSubject(Map map);
	 Subject getById(int id);
	 List<Subject_purchase_record> listsubjectrecord(int id);
	 List<Subject> subject(Map map);//«∞Ã®≤È—Ø
	 List<Subject>list_Subject_4();
	 List<Subject> ListFixGet(Map map);
	 BigInteger  get_count(int  id);
	 List<Subject> ListFixGet2(Map map);
}
