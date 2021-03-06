package com.financing.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.financing.Interface_service.IN_Finance_produce_funds_service;
import com.financing.Interface_service.IN_Member_bankcards_service;
import com.financing.Interface_service.IN_Member_deposit_record_service;
import com.financing.Interface_service.IN_Member_service;
import com.financing.Interface_service.IN_Member_withdraw_record_service;
import com.financing.Interface_service.IN_News_service;
import com.financing.Interface_service.IN_News_type_service;
import com.financing.Interface_service.IN_Oversea_config_service;
import com.financing.Interface_service.IN_Subject_service;
import com.financing.Interface_service.IN_Users_service;
import com.financing.Interface_service.IN_award_records_service;
import com.financing.Interface_service.IN_feedback_service;
import com.financing.Interface_service.IN_push_notice_service;
import com.financing.Interface_service.IN_user_role_service;
import com.financing.bean.Award_records;
import com.financing.bean.Feedback;
import com.financing.bean.Finance_product_funds;
import com.financing.bean.Member;
import com.financing.bean.Member_bankcards;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.News;
import com.financing.bean.News_type;
import com.financing.bean.Oversea_config;
import com.financing.bean.Push_notice;
import com.financing.bean.Subject;
import com.financing.bean.User_role;
import com.financing.bean.Users;



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
	private IN_award_records_service IN_award_records_service;
	
@Autowired
private  IN_feedback_service IN_feedback_service;
	

@Autowired
private IN_Users_service IN_Users_service;

@Autowired
private IN_user_role_service IN_user_role_service;


	 //显示后台
     @RequiresAuthentication
	@RequestMapping("/admin")
	public String admin() {
		 return "admin/admin";
	}
	 

	
	//显示后台首页图片
	@RequestMapping("/show")
	public String main1() {
		return "admin/show";
	} 
	
	
	//查询固收类
	@RequestMapping("/menus1")
	@RequiresPermissions(value="固收类/P2P")
	public String menus1(Model model,@ModelAttribute("sname")String sname,
			@ModelAttribute("stype")String stype,@ModelAttribute("status")String status
	) {
		
	System.out.println("接受的查询参数:"+sname+"   "+stype+"   "+status);
		Map map=new HashMap();
		map.put("sname",sname);
		map.put("stype", stype);
		map.put("status", status);
		List<Subject> listSubject=	subjectService.ListFixGet(map);
		model.addAttribute("sname",sname);
		model.addAttribute("stype", stype);
		model.addAttribute("status", status);
		model.addAttribute("listSubject", listSubject);
	    return "admin/menus1";
	}
	

//私募基金
	 @RequestMapping("/menus2")
	 @RequiresPermissions(value="私募基金")
	 public String menus2(Model model,@ModelAttribute("name")String name,
			@ModelAttribute("type")String type,@ModelAttribute("status")String status
	) {
		
//	System.out.println("接受的查询参数:"+name+"   "+type+"   "+status);
		Map map=new HashMap();
		map.put("name",name);
		map.put("type", type);
		map.put("status", status);
	List<Finance_product_funds>list = finance_product_funds_Service.listfinance(map);
		model.addAttribute("name",name);
		model.addAttribute("type", type);
		model.addAttribute("status", status);
		model.addAttribute("listfinance", list);
	    return "admin/menus2";
	}
	
	
	
	
	
	
	@RequiresPermissions(value="股权基金")
	@RequestMapping("/menus3")
	public String menus3() {
		return "admin/menus3";
	}
	//查询海外配置
	@RequestMapping("/menus4")
	@RequiresPermissions(value="海外配置")
	public String menus4(Model model){
		List<Oversea_config> listOversea=this.oversea_config_service.listOversea();
		model.addAttribute("listOversea", listOversea);
		return "admin/menus4";
	}
	
	
	
	
	@RequiresPermissions(value="缴费记录")
	@RequestMapping("/menus5")
	public String menus5() {
		return "admin/menus5";
	}
	
	@RequiresPermissions(value="资讯分类")
	@RequestMapping("/menus6")//资讯分类
	public String menus6(Model model,@ModelAttribute("news_type_q1")String news_type_q1,@ModelAttribute("news_type_q2")String news_type_q2) {
		Map map = new HashMap<>();
	    map.put("news_type_q1", news_type_q1);
	    map.put("news_type_q2", news_type_q2);
		List<News_type>list = news_type_service.list_News_type( map);//查询所有
		  model.addAttribute("news_type", list) ;
		return "admin/menus6";
	}
	
	
	@RequiresPermissions(value="资讯管理")
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
	
	
	
	@RequiresPermissions(value="账号管理")
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
	
	
	
	@RequiresPermissions(value="理财师审核")
	@RequestMapping("/menus9")
	public String menus9() {
		return "admin/menus9";
	}
	
	
	@RequiresPermissions(value="绑卡管理")
	@RequestMapping("/menus10")//绑卡管理
	public String menus10(Model model,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("member_namem")String member_namem,@ModelAttribute("card_nom")String card_nom,@ModelAttribute("create_datem")String create_datem) {
		Map map=new HashMap<>();
		map.put("mobile_Phonem", mobile_Phonem);
		map.put("member_namem", member_namem);
		map.put("card_nom", card_nom);
		map.put("create_datem", create_datem);
		List<Member_bankcards> listMember_bankcards=this.mbs.listMember_bankcards(map);
		model.addAttribute("listMember_bankcards", listMember_bankcards);
		
		return "admin/menus10";
	}
	
	
	
	@RequiresPermissions(value="付息计划")
	@RequestMapping("/menus11")//付息计划
	public String menus11(Model model,@ModelAttribute("namem")String namem,@ModelAttribute("statusm")String statusm,@ModelAttribute("typem")String typem) {//付息计划
		Map map=new HashMap<>();
		map.put("namem", namem);
		map.put("statusm", statusm);
		map.put("typem", typem);
		List<Subject>listSubject=subjectService.ListFixGet2(map);
		model.addAttribute("listSubject", listSubject);
		return "admin/menus11";
	}
	
	
	
	@RequiresPermissions(value="充值管理")
	@RequestMapping("/menus12")//充值管理
	public String menus12(Model model,@ModelAttribute("serial_numberm")String serial_numberm,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("statusm")String statusm,@ModelAttribute("pay_channel_namem")String pay_channel_namem,@ModelAttribute("create_datem")String create_datem) {
		Map map=new HashMap<>();
		map.put("serial_numberm", serial_numberm);
		map.put("mobile_Phonem", mobile_Phonem);
		map.put("statusm", statusm);
		map.put("pay_channel_namem", pay_channel_namem);
		map.put("create_datem", create_datem);
		List<Member_deposit_record> listMember_deposit_record=this.mdrs.listMember_deposit_record(map);
		model.addAttribute("listMember_deposit_record", listMember_deposit_record);
		return "admin/menus12";
	}
	
	
	@RequiresPermissions(value="提现管理")
	@RequestMapping("/menus13")//提现管理
	public String menus13(Model model,@ModelAttribute("member_namem")String member_namem,@ModelAttribute("mobile_Phonem")String mobile_Phonem,@ModelAttribute("bank_cardm")String bank_cardm,@ModelAttribute("create_datem")String create_datem) {
		Map map=new HashMap<>();
		map.put("member_namem", member_namem);
		map.put("mobile_Phonem", mobile_Phonem);
		map.put("bank_cardm", bank_cardm);
		map.put("create_datem", create_datem);
		
		List<Member_withdraw_record> listMember_withdraw_record=this.member_withdraw_record_service.listMember_withdraw_record(map);
		List<Member> listmember=this.member_withdraw_record_service.listMember();
		model.addAttribute("listMember_withdraw_record", listMember_withdraw_record);
		model.addAttribute("listmember", listmember);
		return "admin/menus13";
	}
	
	
	
	@RequiresPermissions(value="邀请奖励")
	@RequestMapping("/menus14")//邀请奖励
	public String menus14(Model model,
			@ModelAttribute("member_namem")String member_namem,
			@ModelAttribute("mobile_Phonem")String mobile_Phonem,
			@ModelAttribute("invitationCodem")String invitationCodem,
			@ModelAttribute("invitedCodem")String invitedCodem,
			@ModelAttribute("typem")String typem,
			@ModelAttribute("isAwardm")String isAwardm) {
		Map map=new HashMap<>();
		map.put("member_namem", member_namem);
		map.put("mobile_Phonem", mobile_Phonem);
		map.put("invitationCodem", invitationCodem);
		map.put("invitedCodem", invitedCodem);
		map.put("typem", typem);
		map.put("isAwardm", isAwardm);
		List<Award_records> listaward_records=this.IN_award_records_service.listAward_records(map);
		model.addAttribute("listaward_records", listaward_records);
		return "admin/menus14";
	}
	
	
	
	@RequiresPermissions(value="财务统计")
	@RequestMapping("/menus15")
	public String menus15() {
		return "admin/menus15";
	}
	
	
	@RequiresPermissions(value="用户综合统计")
	@RequestMapping("/menus16")
	public String menus16() {
		return "admin/menus16";
	}
	
	
	@RequiresPermissions(value="发布公告")
	@RequestMapping("/menus17")//公告
	public String menus17(Model model,@ModelAttribute("push_q1")String q1,@ModelAttribute("push_q2")String q2) {//公告
		Map map = new HashMap<>();
	    map.put("push_q1",q1);
	    map.put("push_q2", q2);
	    List<Push_notice>list=IN_push_notice_service.list(map);
	    model.addAttribute("push", list);
	    model.addAttribute("push_q1",q1);
	    model.addAttribute("push_q2",q2);
		return "admin/menus17";
	}
	
	@RequiresPermissions(value="建议反馈")
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
	

	
	@RequestMapping("/get_user_role")
	@ResponseBody
	public List<User_role>get_user_role() {
		List<User_role>list = IN_user_role_service.list_user_role_All();
		return   list;
	}
	
	
	  //用户管理
	@RequiresPermissions(value="用户管理")
	@RequestMapping("/menus19")
	public String menus19(Model model,@ModelAttribute("users_q1")String users_q1,@ModelAttribute("users_q2")String users_q2) {
		Map map = new HashMap<>();
	    map.put("users_q1", users_q1);
	    map.put("users_q2", users_q2); 
	    List<Users>list =IN_Users_service.list_Users(map);
	    model.addAttribute("users_list", list);
	    model.addAttribute("users_q1",users_q1);
	    model.addAttribute("users_q2", users_q2);
		return "admin/menus19";
	}
	
	
	//角色管理
	@RequestMapping("/menus20")
	public String menus20(Model model) {
		
		List<User_role>list= IN_user_role_service.list_user_role();
		model.addAttribute("list_user_role", list);
		return "admin/menus20";
	}
	
	@RequiresPermissions(value="修改密码")
	@RequestMapping("/menus21")
	public String menus21() {
		return "admin/menus21";
	}

}
