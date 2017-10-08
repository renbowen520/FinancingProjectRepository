package com.financing.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.financing.Interface_service.IN_Subject_bbin_purchase_record_service;
import com.financing.Interface_service.IN_Subject_purchase_record_service;
import com.financing.Interface_service.IN_Subject_service;
import com.financing.bean.Subject;
import com.financing.bean.Subject_bbin_purchase_record;
import com.financing.bean.Subject_file;
import com.financing.bean.Subject_purchase_record;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private IN_Subject_service subjectService;

	@Autowired
	private IN_Subject_bbin_purchase_record_service isbprs;
	@Autowired
	private IN_Subject_purchase_record_service isprs;

	//跳到新增页面
	@RequestMapping("/addfixget")
	public String addfixget(){
		return "admin/addfixget";
	}
	
	//查询固收类
	@RequestMapping("/menus1")
	public String menus1(Model model,@RequestParam(required=false)String sname,@RequestParam(required=false)String stype,@RequestParam(required=false)String status) {
		Map map=new HashMap();
		map.put("sname",sname);
		map.put("stype", stype);
		map.put("status", status);
		List<Subject> listSubject=this.subjectService.listSubject(map);
		model.addAttribute("sname",sname);
		model.addAttribute("stype", stype);
		model.addAttribute("status", status);
		model.addAttribute("listSubject", listSubject);
		return "admin/menus1";
	}
	
	//保存固收类
	@RequestMapping("/save")
	public String save(Subject subject,Model model,@RequestParam("file")MultipartFile file_name,
			HttpServletRequest request,HttpSession session,Subject_file subject_file) throws IOException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssssss");	
		subject.setCreate_date(new Date());
		subject.setUpdate_date(new Date());
		subject.setRaise_start(new Date());
		subject.setRaise_end(new Date());
		subjectService.save(subject);
		System.out.println("文件名:"+file_name.getOriginalFilename());
		session.setAttribute("filename", file_name.getOriginalFilename());
		String type=file_name.getOriginalFilename().substring(file_name.getOriginalFilename().indexOf("."));
		Date date=new Date();
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
		String filenametime=sdf.format(date)+type;
		String path=request.getRealPath("/upload/");
		File newfile=new File(path, filenametime);
		if(!newfile.exists()){
			newfile.createNewFile();
		}
		file_name.transferTo(newfile);
		session.setAttribute("filenametime", filenametime);
		session.setAttribute("path", path);
		subject_file.setFile_name(filenametime);
		subject_file.setPath(path+sdf2.format(date));
		subject_file.setCreate_date(new Date());
		subjectService.savefile(subject_file);
		return "redirect:/subject/menus1";
	}
	@RequestMapping("/bfupdate/{id}")
	//修改之前的查询
	public String bfupdate(@PathVariable("id")int id,Model model){
	    Subject subject=subjectService.getById(id);
		model.addAttribute("subject", subject);
		return "admin/updatefixget";
	}
	//修改固收类
	@RequestMapping("/update")
	public String update(Subject subject){
		subject.setCreate_date(new Date());
		subject.setUpdate_date(new Date());
		subject.setRaise_start(new Date());
		subject.setRaise_end(new Date());
		this.subjectService.update(subject);
		return "redirect:/subject/menus1";
	}
	
	//显示标的购买记录
	@RequestMapping("/listsubjectrecord/{id}")
	public String listsubjectrecord(@PathVariable("id")int id,Model model){
		List<Subject_bbin_purchase_record> listsubjectrecord=this.subjectService.listsubjectrecord(id);
		model.addAttribute("listsubjectrecord", listsubjectrecord);
		return "admin/subjectrecord";
	}
	
	
	//计算总的金额
	@RequestMapping("/getTotalMoney")
	@ResponseBody
	public double getTotalMoney(int id){
		System.out.println("id="+id);
		Subject subject=this.subjectService.getById(id);
		double num=0;
		Set<Subject_purchase_record> set=subject.getSubject_purchase_record();
		if(set.size()!=0){
			Iterator<Subject_purchase_record> records=set.iterator();
			while(records.hasNext()){
				Subject_purchase_record record=records.next();
				num+=record.getAmount();
			}
		}
		System.out.println("num:"+num);
		return num;
	}
	
	@RequestMapping("/menus11")//付息计划
	public String menus11(Model model,@ModelAttribute("namem")String namem,@ModelAttribute("statusm")String statusm,@ModelAttribute("typem")String typem) {//付息计划
		System.out.println("6666");
		Map map=new HashMap<>();
		map.put("namem", namem);
		System.out.println("namem:"+namem);
		map.put("typem", typem);
		System.out.println("typem:"+typem);
		map.put("statusm", statusm);
		System.out.println("statusm:"+statusm);
		
		List<Subject>listSubject=subjectService.listSubject(map);
		model.addAttribute("listSubject", listSubject);
		
		return "admin/menus11";
	}
	@RequestMapping("/menus112")//付息计划
	@ResponseBody
	//计算已投金额
	public String menus112(Model model,@ModelAttribute("id")int id, HttpServletRequest request){
		List<Subject_purchase_record> getSubject_purchase_record=isprs.getSubject_purchase_record(id);
		Double double1=0d;
		for (int i = 0; i < getSubject_purchase_record.size(); i++) {
			Double  d1=getSubject_purchase_record.get(i).getAmount();
			Double  d2=getSubject_purchase_record.get(i).getSubject().getYear_rate();
			double1=d1*(1+d1/100);
		}
		return String.valueOf(double1);
	}
	
	
	
	@RequestMapping("/menus24/{id}")
	public String menus24(Model model,@ModelAttribute("id")int id){
		List<Subject_bbin_purchase_record> listSubject_bbin_purchase_record=isbprs.listSubject_bbin_purchase_record(id);
		System.out.println(listSubject_bbin_purchase_record.size());
		model.addAttribute("listSubject_bbin_purchase_record", listSubject_bbin_purchase_record);
		return "admin/menus24";
	}
	
}
