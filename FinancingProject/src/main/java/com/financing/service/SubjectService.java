package com.financing.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;
import com.financing.dao.SubjectDao;



@Service
@Transactional
public class SubjectService {
	
	@Autowired
	private SubjectDao subjectdao;
	
	//保存固收类
	public void save(Subject subject){
		this.subjectdao.save(subject);
	}
	//修改固收类
	public void update(Subject subject){
		this.subjectdao.update(subject);
	}
	//查询显示所有固收类
	
	public List<Subject> listSubject(Map map){
		return subjectdao.ListFixGet(map);
	}
	//修改前的查询
	public Subject getById(int id){
		return this.subjectdao.getById(id);
	}
	//查询显示标的购买记录
	public List<Subject_bbin_purchase_record> listsubjectrecord(int id){
		return subjectdao.listsubjectrecord(id);
	}
}
