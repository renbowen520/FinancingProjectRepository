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
	
	//���������
	public void save(Subject subject){
		this.subjectdao.save(subject);
	}
	//��������ļ�
	public void savefile(Subject_file subject_file){
		this.subjectdao.savefile(subject_file);
	}
	//�޸Ĺ�����
	public void update(Subject subject){
		this.subjectdao.update(subject);
	}
	//��ѯ��ʾ���й�����
	public List<Subject> listSubject(Map map){
		return subjectdao.ListFixGet(map);
	}
	//�޸�ǰ�Ĳ�ѯ
	public Subject getById(int id){
		return this.subjectdao.getById(id);
	}


	

	//��Ϣ�ƻ�ģ����ѯ������ʾ����
	public List<Subject> listSubjectm(Map map){
		return subjectdao.listsubject(map);
	}
	//ǰ̨��ѯ
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
	
	//��ѯ��ʾ��Ĺ����¼
	@Override
	 public List<Subject_purchase_record> listsubjectrecord(int id) {
	 	 // TODO Auto-generated method stub
		  return subjectdao.listsubjectrecord(id);
	}
}
