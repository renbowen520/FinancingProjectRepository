package com.financing.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.bean.Finance_product_funds;
import com.financing.bean.Finance_product_subscribe;
import com.financing.bean.Oversea_config;
import com.financing.bean.Oversea_config_subscribe;
import com.financing.service.Finance_product_funds_Service;
import com.financing.service.Oversea_config_Service;

@Controller
@RequestMapping("/finance")
public class Finance_product_funds_Controller {
	@Autowired
	private Finance_product_funds_Service finance_product_funds_Service;
	
	@RequestMapping("/menus2")
	//查询私募
	public String menus2(Model model){
		List<Finance_product_funds> listfinance=this.finance_product_funds_Service.listfinance();
		model.addAttribute("listfinance", listfinance);
		return "admin/menus2";
	}
	
	//保存私募
	@RequestMapping("/save")
	public String save(Finance_product_funds finance_product_funds,Model model){
		finance_product_funds.setCreate_date(new Date());
		finance_product_funds.setUpdate_date(new Date());;
		finance_product_funds_Service.save(finance_product_funds);
		return "redirect:/finance/menus2";
	}
	
	//跳转到新增私募页面
	@RequestMapping("/addfinance")
	public String addoversea(){
		return "admin/addfinance";
	}
	
	//修改之前的查询
	@RequestMapping("/bfupdate/{id}")
	public String bfupdate(@PathVariable("id")int id,Model model,Finance_product_funds finance_product_funds){
		finance_product_funds.setCreate_date(new Date());
		finance_product_funds.setUpdate_date(new Date());;
		finance_product_funds=finance_product_funds_Service.getById(id);
		model.addAttribute("finance_product_funds", finance_product_funds);
		return "admin/updatefinance";
	}
	
	//修改私募
	@RequestMapping("/update")
	public String update(Finance_product_funds finance_product_funds,Model model){
		finance_product_funds.setCreate_date(new Date());
		finance_product_funds.setUpdate_date(new Date());;
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
}
