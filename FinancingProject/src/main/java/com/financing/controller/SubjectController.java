package com.financing.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;
import com.financing.service.SubjectService;



@Controller
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	//��������ҳ��
	@RequestMapping("/addfixget")
	public String addfixget(){
		return "admin/addfixget";
	}
	
	//��ѯ������
	@RequestMapping("/menus1")
	public String menus1(Model model,@RequestParam(required=false)String sname) {
		Map map=new HashMap();
		map.put("sname",sname);
		List<Subject> listSubject=this.subjectService.listSubject(map);
		model.addAttribute("sname",sname);
		model.addAttribute("listSubject", listSubject);
		return "admin/menus1";
	}
	
	//���������
	@RequestMapping("/save")
	public String save(Subject subject,Model model){
		subject.setCreate_date(new Date());
		subject.setUpdate_date(new Date());
		subject.setRaise_start(new Date());
		subject.setRaise_end(new Date());
		subjectService.save(subject);
		return "redirect:/subject/menus1";
	}
	@RequestMapping("/bfupdate/{id}")
	//�޸�֮ǰ�Ĳ�ѯ
	public String bfupdate(@PathVariable("id")int id,Model model,Subject subject){
	    subject=subjectService.getById(id);
		model.addAttribute("subject", subject);
		return "admin/updatefixget";
	}
	//�޸Ĺ�����
	@RequestMapping("/update")
	public String update(Subject subject){
		subject.setCreate_date(new Date());
		subject.setUpdate_date(new Date());
		subject.setRaise_start(new Date());
		subject.setRaise_end(new Date());
		this.subjectService.update(subject);
		return "redirect:/subject/menus1";
	}
	
	//��ʾ��Ĺ����¼
	@RequestMapping("/listsubjectrecord/{id}")
	public String listsubjectrecord(@PathVariable("id")int id,Model model){
		List<Subject_bbin_purchase_record> listsubjectrecord=this.subjectService.listsubjectrecord(id);
		model.addAttribute("listsubjectrecord", listsubjectrecord);
		return "admin/subjectrecord";
	}
	
	
	//�����ܵĽ��
	@RequestMapping("/getTotalMoney")
	public double getTotalMoney(int id){
		System.out.println("id="+id);
		Subject subject=this.subjectService.getById(id);
		double num=0;
		
		return num;
	}
}
