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
	
	//���������
	public void save(Subject subject){
		this.subjectdao.save(subject);
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
}
