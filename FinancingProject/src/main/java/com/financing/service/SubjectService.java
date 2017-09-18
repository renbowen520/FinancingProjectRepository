package com.financing.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financing.Interface_dao.IN_Subject_dao;
import com.financing.Interface_service.IN_Subject_service;
import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;
import com.financing.dao.SubjectDao;



@Service
@Transactional
public class SubjectService  implements IN_Subject_service {
	
	@Autowired
	private IN_Subject_dao subjectdao;
	
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
	
	//付息计划模糊查询及其显示所有
	public List<Subject> listSubjectm(Map map){
		return subjectdao.listsubject(map);
	}
}
