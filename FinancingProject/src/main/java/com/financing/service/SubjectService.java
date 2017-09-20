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
import com.financing.bean.Subject_file;
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
	//��ѯ��ʾ��Ĺ����¼
	public List<Subject_bbin_purchase_record> listsubjectrecord(int id){
		return subjectdao.listsubjectrecord(id);
	}
	
	//ǰ̨��ѯ
	public List<Subject> subject(Map map){
		return subjectdao.listSubject(map);
	}
}
