package com.financing.service;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financing.Interface_dao.IN_Subject_dao;
import com.financing.Interface_service.IN_Subject_service;
import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;
import com.financing.bean.Subject_file;
import com.financing.bean.Subject_purchase_record;
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
	//保存固收文件
	public void savefile(Subject_file subject_file){
		this.subjectdao.savefile(subject_file);
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


	

	//付息计划模糊查询及其显示所有
	public List<Subject> listSubjectm(Map map){
		return subjectdao.listsubject(map);
	}
	//前台查询
	public List<Subject> subject(Map map){
		return subjectdao.listSubject(map);

	}
	@Override
	public List<Subject> list_Subject_4() {
		// TODO Auto-generated method stub
		return subjectdao.list_Subject_4();
	}
	@Override
	public BigInteger get_count(int id) {
		// TODO Auto-generated method stub
		return  subjectdao.get_count(id);
	}
	@Override
	public List<Subject> ListFixGet(Map map) {
		// TODO Auto-generated method stub
		return subjectdao.ListFixGet(map);
	}
	
	//查询显示标的购买记录
	@Override
	 public List<Subject_purchase_record> listsubjectrecord(int id) {
	 	 // TODO Auto-generated method stub
		  return subjectdao.listsubjectrecord(id);
	}
	@Override
	public List<Subject> ListFixGet2(Map map) {
		// TODO Auto-generated method stub
		return subjectdao.ListFixGet2(map);
	}
}
