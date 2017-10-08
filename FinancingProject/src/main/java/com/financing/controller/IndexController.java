package com.financing.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financing.Interface_service.IN_Finance_produce_funds_service;
import com.financing.Interface_service.IN_Member_bankcards_service;
import com.financing.Interface_service.IN_Oversea_config_service;
import com.financing.Interface_service.IN_Subject_service;
import com.financing.Interface_service.IN_push_notice_service;
import com.financing.bean.Finance_product_funds;
import com.financing.bean.Member;
import com.financing.bean.Oversea_config;
import com.financing.bean.Push_notice;
import com.financing.bean.Subject;

//ǰ̨��תҳ����صĿ��Ʋ�

@Controller
@RequestMapping("/IndexController")
public class IndexController {
	@Autowired
	private IN_Subject_service subjectService;
	@Autowired
	private IN_Finance_produce_funds_service finance_product_funds_Service;
	@Autowired
	private IN_Oversea_config_service oversea_config_Service;
	@Autowired
	private IN_Member_bankcards_service IN_Member_bankcards_service;

@Autowired
private IN_push_notice_service IN_push_notice_service;
	//��ҳ
	@RequestMapping("/index")
	public String Index(Model model) {  
		//��Ҫ��ѯ����
	 	 List<Push_notice>list = IN_push_notice_service.list_5();
	 	 model.addAttribute("push_notice", list);
	 	 
	 	 //��ҳ��Ҫ��ʾ4����Ʒ
	 List<Subject>list2 = subjectService.list_Subject_4();	 
	 	model.addAttribute("subject", list2); 
		 return "jsp/index";
	}
	
	//��ʾ5������
	@RequestMapping("/list_5")
	@ResponseBody
	public List<Push_notice>list_5(){
		 List<Push_notice>list = IN_push_notice_service.list_5();
		 return list;
	}
	
	
	@RequestMapping("/feedback")   //�������
	public String feedback(HttpSession session) {
		   Member member = (Member) session.getAttribute("member_login");
	       if(member!=null) {
	    		return "jsp/feedback";
	       }else {
	    		  return "redirect:/IndexController/index";   
	       }
	}
	
	
	
	@RequestMapping("/NewFile")   //��ǩʧ��
	public String NewFile() {
		return "jsp/NewFile";
		
	}
	
	
	@RequestMapping("/error")   //����
	public String error() {
		return "error/error";
		
	}

	@RequestMapping("/dagou404")   //����
	public String dagou404() {
		return "error/dagou404";
		
	}
	
	//��̨��½
	@RequestMapping("/adminLogin")
	public String adminLogin() {
		
		return "jsp/AdminLogin";
	}
	
	

	
	//������������
  @RequestMapping("/Online_experience_center")
  public String  Online_experience_center() {
	  return "jsp/Online_experience_center";
  }
 
  //��Ʒ����
	@RequestMapping("/product")
	public String  product(Model model,HttpServletRequest request) {
		Map map=new HashMap<>();
		map=initMap(request, map);
		List<Subject> subject=this.subjectService.subject(map);
		model.addAttribute("subject", subject);
		return "jsp/product";
	}
	
	
	//��ȡ��Ʒ��ѯ�Ĳ���
	public Map initMap(HttpServletRequest request,Map map){
		String  typeid=request.getParameter("typeid");
		String type=request.getParameter("type");
		String year_rate=request.getParameter("year_rate");
		String status=request.getParameter("status");
		String period_start=request.getParameter("period_start");
		String period_end=request.getParameter("period_end");
		String flag=request.getParameter("flag");
		map.put("type",type);
		map.put("year_rate", year_rate);
		map.put("status", status);
		map.put("period_start",period_start);
		map.put("period_end",period_end);
		map.put("flag", flag);
		map.put("typeid", typeid);
		if(type!=null){
			request.setAttribute("type", type);
		}
		if(year_rate!=null){
			request.setAttribute("year_rate", year_rate);
		}
		if(status!=null){
			request.setAttribute("status", status);
		}
		if(period_start!=null){
			request.setAttribute("period_start",period_start);
		}
		if(period_end!=null){
			request.setAttribute("period_end",period_end);
		}
		if(flag!=null){
			request.setAttribute("flag",flag);
		}
		if(typeid!=null) {
			request.setAttribute("typeid",typeid);
		}
		return map; 
	}
	
	//˽ļ
	@RequestMapping("/finance")
	public String  finance(Model model) {
		Map map=new HashMap();
		List<Finance_product_funds> finance=finance_product_funds_Service.finance(map);
		model.addAttribute("finance", finance);
		return "jsp/finance";
	}
	//��������
	@RequestMapping("/oversea")
	public String  oversea(Model model) {
		Map map=new HashMap();
		List<Oversea_config> oversea=this.oversea_config_Service.listOversea();
		model.addAttribute("oversea", oversea);
		return "jsp/oversea";
	}
	  //��������
		@RequestMapping("/news")
		public String  news() {
			return "jsp/news";
		}
		
		//׼���������
		@RequestMapping("/buyproduct")
		public String  buyproduct(int id,Model model) {
			//System.out.println("���id="+id);
			//Ȼ��Ҫ��ѯ���ݵ�ǰ̨��ʾ
		   Subject subject =	subjectService.getById(id);
		 	model.addAttribute("buyproduct", subject);
			return "jsp/BuySubject";
		}
		
		  //��ѧԺ
			@RequestMapping("/help")
			public String  help() {
				return "jsp/help";
			}
			
		
			  //Ͷ������
				@RequestMapping("/investment_research")
				public String  investment_research() {
					  return "jsp/investment_research";
				}
			
				 //��������  
				 @RequestMapping("/personal_center")
				 public String  personal_center(HttpSession session) {
					 Member member = (Member) session.getAttribute("member_login"); 
					if(member!=null) {
						   return "jsp/personal_center";
					}else {
						  return "jsp/login";
					}
					
				  }
				 
				 //��½
				 @RequestMapping("/login")
				 public String login() {
					 return "jsp/login";
				 }
				
				 //ע��
				 @RequestMapping("/register")
				 public String  register(HttpSession session) {
					 session.setAttribute("no_phone", "");
					 return "jsp/register";
				 }
				 
				 // ��������
				 @RequestMapping("/resetting")
				 public String   resetting() {
					 return "jsp/resetting";
				 }
				
				 // ��������
				 @RequestMapping("/download")
				 public String   download() {
					 return "jsp/download";
				 }
}
