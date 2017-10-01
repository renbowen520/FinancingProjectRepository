package com.financing.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.financing.Interface_service.IN_Member_bankcards_service;
import com.financing.Interface_service.IN_Member_deposit_record_service;
import com.financing.Interface_service.IN_Member_service;
import com.financing.Interface_service.IN_member_trade_record_service;
import com.financing.alipay.AlipayConfig;
import com.financing.bean.Bank;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_bankcards;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_trade_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Subject_purchase_record;
import com.financing.bean.Sys_region;
import com.financing.bean.Users;
import com.financing.service.Member_deposit_record_service;

@Controller
@RequestMapping("/MemberController")
public class MemberController {

	
	@Autowired 
	private IN_Member_service member_service;
	
	@Autowired
	private IN_Member_bankcards_service IN_Member_bankcards_service;
	
	
	@Autowired
	private IN_Member_deposit_record_service  IN_Member_deposit_record_service;
	
	@Autowired
	private  IN_member_trade_record_service  IN_member_trade_record_service;
	
	@RequestMapping("/ok")   //付款ok
	public String  ok(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
	    		//获取支付宝GET过来反馈信息
	    		Map<String,String> params = new HashMap<String,String>();
	    		Map<String,String[]> requestParams = request.getParameterMap();
	    		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
	    			String name = (String) iter.next();
	    			String[] values = (String[]) requestParams.get(name);
	    			String valueStr = "";
	    			for (int i = 0; i < values.length; i++) {
	    				valueStr = (i == values.length - 1) ? valueStr + values[i]
	    						: valueStr + values[i] + ",";
	    			}
	    			//乱码解决，这段代码在出现乱码时使用
	    			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
	    			params.put(name, valueStr);
	    		}
	    		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名 
	    		if(signVerified) {
	    	   //商户订单号
	   		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
	   		//支付宝交易号
	   		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
	   		//付款金额
	   		String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
	    	System.out.println(out_trade_no); 
	   		System.out.println(trade_no);
	   		System.out.println(total_amount);
	   		  
	   		//支付成功后 首先根据订单号 查询充值记录表
	   	Member_deposit_record m=IN_Member_deposit_record_service.get_deposit(out_trade_no);
	   		 if(m!=null) {
	   			//  System.out.println(m.getMember_id().getName());
	   			 // System.out.println(m.getPay_channel_order_no());
	   			 //更改充值记录表的状态
	   			 //添加交易记录表
	   			m.setStatus(1);//付款完成
	   			m.setUpdate_date(new Date());//修改时间
	   			Member_trade_record mt=new Member_trade_record();
	   			mt.setMember_id(m.getMember_id());//用户id
	   			mt.setTrade_no(out_trade_no);//订单号
	   			//交易名称
	   			mt.setTrade_name("支付宝-账户充值:"+total_amount);
	   			mt.setAmount(Double.valueOf(total_amount));//钱
	   			mt.setTrade_type("支付宝");
	   			mt.setFund_flow(1);//资金流入
	   			 mt.setTrade_status(1);//付款完成
	   			 mt.setCreate_date(new Date());
	   			 //重新查询会员
	       Member mmm= 			member_service.getById(m.getMember_id().getId());
	    
	       //保存
	       IN_Member_deposit_record_service.update(m,mt);
	     
	       //账号添加金钱
	       mmm.getMember_account().setUseable_balance(mmm.getMember_account().getUseable_balance()+Double.valueOf(total_amount));
	      mmm.getMember_account().setUpdate_date(new Date());
	       //保存
	      member_service.save(mmm);
	      //查询
	       Member m222= 			member_service.getById(mmm.getId());
	       session.setAttribute("member_login",m222);	
	      //重新啊回到个人中心
	      return "redirect:/IndexController/personal_center";    
	   		
	   		 } else {
	   		   return "redirect:/IndexController/dagou404";    
	   		 }
	   		
	   	
	    		}else {  //验证签名失败
	    			   return "redirect:/IndexController/NewFile";   
	    		}
	    //	   return "/alipay/alipay.trade.page.pay.jsp";
	 //  }else {
	      //     return "redirect:/IndexController/index";   
	  //     }
	}
	
	
	
	@RequestMapping("/fk")   //支付宝付款
	public String  fk(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException {
		   Member member = (Member) session.getAttribute("member_login");
	       if(member!=null) {
	    	   //需要向充值记录表添加一个 未付款状态
	    	    String WIDout_trade_no=    request.getParameter("WIDout_trade_no");
	    	    String WIDsubject=    request.getParameter("WIDsubject");
	    	    String WIDtotal_amount=    request.getParameter("WIDtotal_amount");
	    	     Member_deposit_record  deposit_record = new Member_deposit_record();
	    	   //流水号
	    	     deposit_record.setSerial_number(new Date().getTime()+"");
	    	  //状态
	    	     deposit_record.setStatus(0);
	    	   //用户id
	    	     deposit_record.setMember_id(member);
	    	   //金额
	    	     deposit_record.setAmount(Double.valueOf(WIDtotal_amount));
	    	    //名称
	    	     deposit_record.setPay_channel_name("支付宝");
	    	     //订单号
	    	     deposit_record.setPay_channel_order_no(WIDout_trade_no);
	    	     //删除状态0
	    	     deposit_record.setDelFlag(0);
	    	     //创建时间
	    	     deposit_record.setCreate_date(new Date());
	    	     
	    	    IN_Member_deposit_record_service.save(deposit_record);
	    	     
	    	   return "/alipay/alipay.trade.page.pay";
	       }else {
	    		  return "redirect:/IndexController/index";   
	       }
	}
	
	
	@RequestMapping("/bk_ck")   //绑卡查看
	public String  bk_ck(HttpSession session) {
		   Member member = (Member) session.getAttribute("member_login");
	       if(member!=null) {
	    	   return "/jsp/bk_ck";
	    	   
	       }else {
	    		  return "redirect:/IndexController/index";   
	       }
		
		
	}
	
	

	@RequestMapping("/bk_ok")   //绑卡提交
	public String bk_ok(HttpSession session,
			String s111_111,String s222_222,String s333_333,
			Member_bankcards member_bankcards,int bank_id,
			Member m22,String zh) {
	       Member member = (Member) session.getAttribute("member_login");
	       if(member!=null) {
	    	     /*System.out.println(s111_111);
	    	     System.out.println(s222_222);
	    	     System.out.println(s333_333);
	    	     System.out.println(bank_id);
	    	     System.out.println("银行名"+zh);
	    	     System.out.println("身份证:"+m22.getIdentity());
	    	     System.out.println("姓名:"+m22.getMember_name());
	    	     System.out.println("卡+"+member_bankcards.getCard_no());*/
	    	
	    	    //根据银行id查询
	    	     Bank bank = member_service.get_bank_id(bank_id);
	    	     member_bankcards.setBank(bank);
	    	     member_bankcards.setDelflag(0);//正常
	    	     member_bankcards.setCreate_date(new Date());
	    	     String s=s111_111+"-"+s222_222+"-"+s333_333+"-"+zh;
	    	     member_bankcards.setCardaddress(s);
	    	 //更新用户表
	    	     member.setMember_name(m22.getMember_name());
	    	     member.setIdentity(m22.getIdentity());
	    	     member.setUpdate_date(new Date());
	    	     member_bankcards.setMember_id(member);
	    	//插入数据库
	    	     member_service.update(member);
	    	     IN_Member_bankcards_service.save(member_bankcards);
	    	     //更新session中存储的
	    	     List<Member_bankcards>list=	IN_Member_bankcards_service.getById(member.getId());
	    		 //查询绑定的银行卡
	    		   session.setAttribute("member_bankcards_bk", list);
	    	       session.setAttribute("member_login",member_service.getById(member.getId())); 
	    	       return "redirect:/IndexController/personal_center";
	     }else {
	    	  return "redirect:/IndexController/index"; 
	     }
		
		
		
	}
	
	
	
	
	
	
	@RequestMapping("/get_s333")  //请求省份下拉列表
	@ResponseBody
	public List<Sys_region> get_s333(int rid,int pid ) {
		//System.out.println("=============="+rid+"===="+pid);
		      List<Sys_region>list =member_service.get_s333(rid, pid);
		      return list;
	}
	

	@RequestMapping("/get_bank")  //请求下拉列表
	@ResponseBody
	public List<Bank> get_bank() {
		   List<Bank>list =member_service.get_bank();
		   return list;
	}
	
	
	@RequestMapping("/yz_ka")  //验证银行卡唯一性
	@ResponseBody
	public  String   yz_ka(@RequestParam String card_no) {
	//	System.out.println("银行卡"+card_no);
	 Member_bankcards member=IN_Member_bankcards_service.get_ka(card_no);
	 boolean b ;
	   Map<String, Boolean> map = new HashMap<>();
	   if(member!=null) {
		  b=false;
	   }else {
		  b=true;
	   }
	   map.put("valid", b);
	   ObjectMapper mapper = new ObjectMapper();
       String resultString = "";
       try {
           resultString = mapper.writeValueAsString(map);
       } catch (JsonProcessingException e) {
           e.printStackTrace();
       }
         return resultString;
	}
	
	
	
	
	
	
	@RequestMapping("/yz")  //验证身份证唯一性
	@ResponseBody
	public  String   yz(@RequestParam String identity) {
	//	System.out.println("身份证"+identity);
	 Member member=	member_service.getByIdentity(identity);
	 boolean b ;
	   Map<String, Boolean> map = new HashMap<>();
	   if(member!=null) {
		  b=false;
	   }else {
		b=true;
	   }
	   map.put("valid", b);
	   ObjectMapper mapper = new ObjectMapper();
       String resultString = "";
       try {
           resultString = mapper.writeValueAsString(map);
       } catch (JsonProcessingException e) {
           e.printStackTrace();
       }
         return resultString;
	}
	
	
	
	
	
	@RequestMapping("/bk")   //绑卡
	public String bk(HttpSession session) {
	    Member member = (Member) session.getAttribute("member_login");
	     if(member!=null) {
	    	return "jsp/bk";
	     }else {
	    	  return "redirect:/IndexController/index"; 
	     }
	}
	
	
	@RequestMapping("cz")  //充值
	public String cz(HttpSession session) {
	    Member member = (Member) session.getAttribute("member_login");
     if(member!=null) {
    	    //根据id查询是不是绑卡了 
    	 List<Member_bankcards>list = IN_Member_bankcards_service.getById(member.getId());
            if(!list.isEmpty()) {  //绑卡了  要跳到支付包充值界面
            	return "alipay/index";
            }else {  //没有绑卡
            	  return "redirect:/MemberController/bk"; 
            }
     }else {
    	  return "redirect:/IndexController/index"; 
     }
    
	}
	
	
	
	
	@RequestMapping("/pwd2")   //修改提款密码时验证原密码
	 @ResponseBody
	 public String pwd2(@RequestParam String pwd111, HttpSession session) { 
		    Member member = (Member) session.getAttribute("member_login");
	
	
		    String p = member.getWithdraw_password();
	     String p2=   new Md5Hash(pwd111,member.getSalt2()).toString();
	   /*  System.out.println("=="+pwd);
	     System.out.println("p===="+p);
	     System.out.println("p2====="+p2);*/
	     boolean b;
	     Map<String, Boolean> map = new HashMap<>();
	      if(p.equals(p2)) {
	    	  b=true;
	      }else {
	    	  b=false;
	      }
	      map.put("valid", b);
		   ObjectMapper mapper = new ObjectMapper();
	       String resultString = "";
	       try {
	           resultString = mapper.writeValueAsString(map);
	       } catch (JsonProcessingException e) {
	           e.printStackTrace();
	       }
	         return resultString;
	     
	 }
	
	
	@RequestMapping("/up_withdraw_password")
	public String  up_withdraw_password(String  pwd222,HttpSession session) {
	//	System.out.println("接受取款密码=="+pwd222);
		//修改提款密码
		
		Member member = (Member) session.getAttribute("member_login");
	
		if(member!=null) {
		
		//根据登陆的id 查询实体类
		Member member2 = member_service.getById(member.getId());
		//得到密码盐
	     String y = member_service.getma(10);
       String p1=   new Md5Hash(pwd222,y).toString();
       //更新时间，盐，密码
       member2.setWithdraw_password(p1);
       member2.setSalt2(y);
       member2.setUpdate_date(new Date());
       member_service.update(member2);
      //更新session中存储的
       session.setAttribute("member_login", member2);
       //个人中心
	    return "redirect:/IndexController/personal_center";
	    
		}else {
			  return "redirect:/IndexController/index"; 
		}
	}
	
	
	
	
	@RequestMapping("/withdraw_password")
	public String  withdraw_password(String  pwd7,HttpSession session) {
	//	System.out.println("接受取款密码=="+pwd7);
		//设置提款密码
		Member member = (Member) session.getAttribute("member_login");
	
		if(member!=null) {
		
		//根据登陆的id 查询实体类
		Member member2 = member_service.getById(member.getId());
		//得到密码盐
	     String y = member_service.getma(10);
       String p1=   new Md5Hash(pwd7,y).toString();
       //更新时间，盐，密码
       member2.setWithdraw_password(p1);
       member2.setSalt2(y);
       member2.setUpdate_date(new Date());
       member_service.update(member2);
      //更新session中存储的
       session.setAttribute("member_login", member2);
       //个人中心
	    return "redirect:/IndexController/personal_center";
	    
		}else {
			  return "redirect:/IndexController/index"; 
		}
	}
	
	
	
	@RequestMapping("/up_pwd")
	public String  up_pwd(String pwd,HttpSession session) {  //修改密码
		Member member = (Member) session.getAttribute("member_login");
	
		if(member!=null) {	
		
		//根据登陆的id 查询实体类
		Member member2 = member_service.getById(member.getId());
		//得到密码盐
	     String y = member_service.getma(10);
        String p1=   new Md5Hash(pwd,y).toString();
       //更新时间，盐，密码
        member2.setPassword(p1);
        member2.setSalt(y);
        member2.setUpdate_date(new Date());
        member_service.update(member2);
       //更新session中存储的
        session.setAttribute("member_login", member2);
        //个人中心
	    return "redirect:/IndexController/personal_center";
	    
		}else {
	    	  return "redirect:/IndexController/index"; 
	
	    }
	}
	
	
	 @RequestMapping("/pwd")   //修改密码时验证原密码
	 @ResponseBody
	 public String pwd(@RequestParam String pwd, HttpSession session) { 
		    Member member = (Member) session.getAttribute("member_login");
	     String p = member.getPassword();
	     String p2=   new Md5Hash(pwd,member.getSalt()).toString();
	   /*  System.out.println("=="+pwd);
	     System.out.println("p===="+p);
	     System.out.println("p2====="+p2);*/
	     boolean b;
	     Map<String, Boolean> map = new HashMap<>();
	      if(p.equals(p2)) {
	    	  b=true;
	      }else {
	    	  b=false;
	      }
	      map.put("valid", b);
		   ObjectMapper mapper = new ObjectMapper();
	       String resultString = "";
	       try {
	           resultString = mapper.writeValueAsString(map);
	       } catch (JsonProcessingException e) {
	           e.printStackTrace();
	       }
	         return resultString;
	     
	 }
	
	
	
	@RequestMapping("/zhanghao")
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
	
	@RequestMapping("/menus25/{id}")
	public String menus25(Model model,@ModelAttribute("id")int id){
		List<Member> listmemberByid=this.member_service.getMemberByid(id);//账号信息
		System.out.println(listmemberByid.size());
		List<Member_account> member_account =this.member_service.getMember_accountByid(id);//资金信息
		List<Subject_purchase_record> subject_purchase_record =this.member_service.getSubject_purchase_record(id);//投资记录
		List<Member_withdraw_record> member_withdraw_record = this.member_service.getMember_withdraw_recordByid(id);//提现记录
		List<Member_deposit_record> member_deposit_record = this.member_service.getMember_deposit_recordByid(id);//充值记录
		model.addAttribute("listmemberByid", listmemberByid.get(0));
		model.addAttribute("member_account", member_account.get(0));
		model.addAttribute("member_withdraw_record", member_withdraw_record);
		model.addAttribute("member_deposit_record", member_deposit_record);
		model.addAttribute("subject_purchase_record", subject_purchase_record);
		return"admin/menus25";
	}
}
