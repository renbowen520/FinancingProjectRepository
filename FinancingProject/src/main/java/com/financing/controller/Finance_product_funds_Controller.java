package com.financing.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;
import com.financing.bean.Member;
import com.financing.bean.Subject;
import com.financing.bean.Subject_purchase_record;
import com.financing.service.Finance_product_funds_Service;
import com.financing.service.Oversea_config_Service;

@Controller
@RequestMapping("/finance")
public class Finance_product_funds_Controller {
	@Autowired
	private Finance_product_funds_Service finance_product_funds_Service;
	
	@RequestMapping("/menus2")
	//查询私募
	public String menus2(Model model,@RequestParam(required=false)String sname,@RequestParam(required=false)String type,@RequestParam(required=false)String status){
		Map map=new HashMap();
		map.put("sname",sname);
		map.put("type", type);
		map.put("status", status);
		List<Finance_product_funds> listfinance=this.finance_product_funds_Service.listfinance(map);
		model.addAttribute("sname",sname);
		model.addAttribute("type", type);
		model.addAttribute("status", status);
		model.addAttribute("listfinance", listfinance);
		return "admin/menus2";
	}
	
	//保存私募
	@RequestMapping("/save")
	public String save(Finance_product_funds finance_product_funds,Model model){
		finance_product_funds.setCreate_date(new Date());
		finance_product_funds.setUpdate_date(new Date());;
		finance_product_funds.setInvest_points("");
		//finance_product_funds.setRatio(0);
		System.out.println(finance_product_funds.getRatio()             );
		finance_product_funds_Service.save(finance_product_funds);
		return "redirect:/finance/menus2";
	}
	
	//跳转到新增私募页面
	@RequestMapping("/addfinance")
	public String addfinance(){
		return "admin/addfinance";
	}
	
	//修改之前的查询
	@RequestMapping("/bfupdate/{id}")
	public String bfupdate(@PathVariable("id")int id,Model model){
		System.out.println("id="+id);
		Finance_product_funds finance_product_funds=this.finance_product_funds_Service.getById(id);
		model.addAttribute("finance_product_funds", finance_product_funds);
		return "admin/updatefinance";
	}
	
	//修改私募
	@RequestMapping("/update")
	public String update(Finance_product_funds finance_product_funds,Model model){
		finance_product_funds.setCreate_date(new Date());
		finance_product_funds.setUpdate_date(new Date());;
		finance_product_funds.setInvest_points("");
		this.finance_product_funds_Service.update(finance_product_funds);
		return "redirect:/finance/menus2";
	}
	//查看私募订阅
	@RequestMapping("/subscribe/{id}")
	public String listfinanceSubscribe(Model model,@PathVariable("id")int id){
		List<Finance_product_subscribe> listfinanceSubscribe=this.finance_product_funds_Service.listfinanceSubscribe(id);
		model.addAttribute("listfinanceSubscribe", listfinanceSubscribe);
		return "admin/financeSubscribe";
	}
	//跳转到签署私募合同页面
	@RequestMapping("/addsubscribe")
	public String addsubscribe(){
		return "admin/successfinance";
	}
	
	
	//签署失败
	@RequestMapping("/lose/{id}/{pid}")
	public String lose(@PathVariable("id")int id,@PathVariable("pid")int pid){
		this.finance_product_funds_Service.losesubscribe(id);
		return "redirect:/finance/subscribe/"+pid;
	}
	
	//保存签署私募
	@RequestMapping("/savesubscribe/{pid}")
	public String savesubscribe(int id,Model model,@PathVariable("pid")int pid){
//		finance_product_subscribe.setCreate_date(new Date());
//		finance_product_subscribe.setUpdate_date(new Date());;
//		finance_product_funds_Service.savesubscribe(finance_product_subscribe);
		Finance_product_subscribe sub=this.finance_product_funds_Service.getsubscribe(id);
		sub.setStatus(1);
		this.finance_product_funds_Service.updatesubscribe(sub);
		return "redirect:/finance/subscribe/"+pid;
	}
	
	
	
	//签署合约之前的查询
	@RequestMapping("/bfsubscribe/{id}")
	public String bfsubscribe(@PathVariable("id")int id,Model model){
		System.out.println("id="+id);
		Finance_product_subscribe subscribe=this.finance_product_funds_Service.getSubscribeById(id);
		model.addAttribute("subscribe", subscribe);
		return "admin/successfinance";
	}
}
