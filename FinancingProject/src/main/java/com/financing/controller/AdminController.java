package com.financing.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.financing.Interface_service.IN_Finance_produce_funds_service;
import com.financing.Interface_service.IN_Member_bankcards_service;
import com.financing.Interface_service.IN_Member_deposit_record_service;
import com.financing.Interface_service.IN_Member_service;
import com.financing.Interface_service.IN_Member_withdraw_record_service;
import com.financing.Interface_service.IN_News_service;
import com.financing.Interface_service.IN_News_type_service;
import com.financing.Interface_service.IN_Oversea_config_service;
import com.financing.Interface_service.IN_Subject_service;
import com.financing.Interface_service.IN_feedback_service;
import com.financing.Interface_service.IN_push_notice_service;
import com.financing.bean.Feedback;
import com.financing.bean.Finance_product_funds;
import com.financing.bean.Member;
import com.financing.service.Finance_product_funds_Service;
import com.financing.service.Member_bankcards_service;
import com.financing.service.Member_deposit_record_service;
import com.financing.service.Member_service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financing.bean.Member;
import com.financing.bean.Member_bankcards;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.News;
import com.financing.bean.News_type;
import com.financing.bean.Oversea_config;
import com.financing.bean.Push_notice;
import com.financing.bean.Subject;
import com.financing.bean.Users;
import com.financing.service.Member_service;
import com.financing.service.Member_withdraw_record_service;
import com.financing.service.News_service;
import com.financing.service.News_type_service;
import com.financing.service.Oversea_config_Service;
import com.financing.service.SubjectService;

@Controller
@RequestMapping("/AdminController")
public class AdminController {
 
	@Autowired 
	private IN_Member_service member_service;
	@Autowired
	private IN_Subject_service subjectService;
	@Autowired
	private IN_News_type_service news_type_service;
	
	@Autowired
	private IN_Finance_produce_funds_service finance_product_funds_Service;
	@Autowired
	private IN_Oversea_config_service oversea_config_service;
	
	@Autowired
	private IN_Member_deposit_record_service mdrs;
	@Autowired
	private IN_Member_withdraw_record_service member_withdraw_record_service;
	
	@Autowired
	private IN_Member_bankcards_service mbs;
	
	@Autowired
	private IN_News_service news_service;
	
	@Autowired
	private IN_push_notice_service IN_push_notice_service;
	
@Autowired
private  IN_feedback_service IN_feedback_service;
	
	 //显示后台
	@RequestMapping("/admin")
	public String admin() {
		 return "admin/admin";
	}
	 

	
	//显示后台首页图片
	@RequestMapping("/show")
	public String main1() {
		return "admin/show";
	} 
	
	//固收类
	@RequestMapping("/menus1")
	public String menus1(Model model,@ModelAttribute("sname")String sname) {
		Map map=new HashMap();
		map.put("sname",sname);
		List<Subject> listSubject=this.subjectService.listSubject(map);
		model.addAttribute("sname",sname);
		model.addAttribute("listSubject", listSubject);
		return "admin/menus1";
	}
//私募基金
	@RequestMapping("/menus2")
	public String menus2(Model model,Finance_product_funds fpf){
		System.out.println("name:"+fpf.getName());
		Map map=new HashMap();
		map.put("sname",fpf.getName());
		map.put("status",fpf.getStatus());
		map.put("type",fpf.getType());
		List<Finance_product_funds> listfinance=this.finance_product_funds_Service.listfinance(map);
		model.addAttribute("listfinance", listfinance);
		model.addAttribute("fpf",fpf);
		return "admin/menus2";
	}
	@RequestMapping("/menus3")
	public String menus3() {
		return "admin/menus3";
	}
	//查询海外配置
	@RequestMapping("/menus4")
	public String menus4(Model model){
		List<Oversea_config> listOversea=this.oversea_config_service.listOversea();
		model.addAttribute("listOversea", listOversea);
		return "admin/menus4";
	}
	@RequestMapping("/menus5")
	public String menus5() {
		return "admin/menus5";
	}
	
	
	@RequestMapping("/menus6")//资讯分类
	public String menus6(Model model) {
		 List<News_type>list = news_type_service.list_News_type();//查询所有
		  model.addAttribute("news_type", list) ;
		return "admin/menus6";
	}
	@RequestMapping("/menus7")  //资讯管理
	public String menus7(Model model,@ModelAttribute("news_q1")String news_q1,@ModelAttribute("news_q2")String news_q2) {
		Map map = new HashMap<>();
		    map.put("q1", news_q1);
		     if(news_q2!=null &&!news_q2.equals("")) {
		       int  qq2 = Integer.valueOf(news_q2);
		           if(qq2==-1) {
		    	    map.put("q2", "");
		          }else {
		        	  map.put("q2", news_q2); 
		          }
		    }else {
		    	 map.put("q2", "");
		    }
		     
		    List<News>list =news_service.list(map);
		    model.addAttribute("news", list);
		    model.addAttribute("news_q1",news_q1);
		    model.addAttribute("news_q2", news_q2);
		    return "admin/menus7";
	}
	@RequestMapping("/menus8")//帐号管理
	public String menus8(Model model,@ModelAttribute("mname")String mname,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("member_namem")String member_namem,@ModelAttribute("invitatioinCodem")String invitatioinCodem) {
		Map map=new HashMap<>();
		map.put("mname", mname);
		map.put("mobile_Phonem", mobile_Phonem);
		map.put("member_namem", member_namem);
		map.put("invitatioinCodem", invitatioinCodem);
		List<Member> listmember=this.member_service.listMember(map);
		model.addAttribute("listmember", listmember);
		return "admin/menus8";
	}
	@RequestMapping("/menus9")
	public String menus9() {
		return "admin/menus9";
	}
	@RequestMapping("/menus10")//绑卡管理
	public String menus10(Model model) {
		List<Member_bankcards> listMember_bankcards=this.mbs.listMember_bankcards();
		model.addAttribute("listMember_bankcards", listMember_bankcards);
		return "admin/menus10";
	}
	@RequestMapping("/menus11")
	public String menus11() {
		return "admin/menus11";
	}
	@RequestMapping("/menus12")//充值管理
	public String menus12(Model model) {
		List<Member_deposit_record> listMember_deposit_record=this.mdrs.listMember_deposit_record();
		model.addAttribute("listMember_deposit_record", listMember_deposit_record);
		return "admin/menus12";
	}
	@RequestMapping("/menus13")//提现管理
	public String menus13(Model model) {
		System.out.println("11111");
		List<Member_withdraw_record> listMember_withdraw_record=this.member_withdraw_record_service.listMember_withdraw_record();
		List<Member> listmember=this.member_withdraw_record_service.listMember();
		model.addAttribute("listMember_withdraw_record", listMember_withdraw_record);
		model.addAttribute("listmember", listmember);
		return "admin/menus13";
	}
	@RequestMapping("/menus14")
	public String menus14() {
		return "admin/menus14";
	}
	@RequestMapping("/menus15")
	public String menus15() {
		return "admin/menus15";
	}
	@RequestMapping("/menus16")
	public String menus16() {
		return "admin/menus16";
	}
	@RequestMapping("/menus17")//公告
	public String menus17(Model model,@ModelAttribute("q1")String q1) {//公告
		Map map = new HashMap<>();
	    map.put("q1", q1);
	    List<Push_notice>list=IN_push_notice_service.list(map);
	    model.addAttribute("push", list);
	    model.addAttribute("q1",q1);
		return "admin/menus17";
	}
	
	
	@RequestMapping("/menus18")
	public String menus18(Model model,@ModelAttribute("feedback_q1")String feedback_q1,@ModelAttribute("feedback_q2")String feedback_q2) { //意见反馈
		Map map = new HashMap<>();
	    map.put("feedback_q1", feedback_q1);
	    map.put("feedback_q2", feedback_q2); 
	    List<Feedback>list =IN_feedback_service.list(map);
	    model.addAttribute("feedback", list);
	    model.addAttribute("feedback_q2",feedback_q2);
	    model.addAttribute("feedback_q1", feedback_q1);
		return "admin/menus18";
	}
	
/*	@RequestMapping("/getFeedback")
	@ResponseBody
	public Feedback getFeedback(int id) {
		System.out.println("id="+id);
		Feedback Feedback=IN_feedback_service.getById(id);
		return Feedback;
	}*/
	
	
	@RequestMapping("/menus19")
	public String menus19() {
		return "admin/menus19";
	}
	@RequestMapping("/menus20")
	public String menus20() {
		return "admin/menus20";
	}
	@RequestMapping("/menus21")
	public String menus21() {
		return "admin/menus21";
	}

}
