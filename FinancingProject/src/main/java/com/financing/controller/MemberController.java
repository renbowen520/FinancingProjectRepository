package com.financing.controller;

import java.io.UnsupportedEncodingException;
import java.security.acl.Group;
import java.text.SimpleDateFormat;
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
import com.financing.Interface_service.IN_Member_account_service;
import com.financing.Interface_service.IN_Member_bankcards_service;
import com.financing.Interface_service.IN_Member_deposit_record_service;
import com.financing.Interface_service.IN_Member_service;
import com.financing.Interface_service.IN_Subject_service;
import com.financing.Interface_service.IN_Users_service;
import com.financing.Interface_service.IN_feedback_service;
import com.financing.Interface_service.IN_member_trade_record_service;
import com.financing.alipay.AlipayConfig;
import com.financing.bean.Bank;
import com.financing.bean.Feedback;
import com.financing.bean.Member;
import com.financing.bean.Member_account;
import com.financing.bean.Member_bankcards;
import com.financing.bean.Member_deposit_record;
import com.financing.bean.Member_profit_record;
import com.financing.bean.Member_tally;
import com.financing.bean.Member_trade_record;
import com.financing.bean.Member_withdraw_record;
import com.financing.bean.Subject;
import com.financing.bean.Subject_order_record;
import com.financing.bean.Subject_purchase_record;
import com.financing.bean.Sys_region;
import com.financing.bean.Users;
import com.financing.service.Member_deposit_record_service;
import com.financing.service.SubjectService;

import antlr.collections.impl.IntRange;

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
	
	@Autowired
	private IN_feedback_service IN_feedback_service;
	
	
	@Autowired
	private IN_Member_account_service  account;
	
	@Autowired
	private IN_Subject_service  IN_Subject_service;
	
	@Autowired
	private IN_Users_service  IN_Users_service;
	//�����Ʒ
	@RequestMapping("gou")
	public  String  gou(int  subject_id,double qian,HttpSession session ,HttpServletRequest request) {
	//	 System.out.println("aa=="+subject_id);
		// System.out.println("bb==="+qian);
		   Member member = (Member) session.getAttribute("member_login");	
		   if(member!=null) {
			   
			 Subject subject =  IN_Subject_service.getById(subject_id);
			     Date currentTime = new Date();
			   SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			   SimpleDateFormat format2 = new SimpleDateFormat("yyyy");
			   SimpleDateFormat format3 = new SimpleDateFormat("MM");
			   SimpleDateFormat format4 = new SimpleDateFormat("dd");
			   
			   String dateString = formatter.format(currentTime);
			//   System.out.println("��ʽ�����ʱ��:"+dateString);
			   
	
			   
				//subject_order_record(��Ķ�����)  
				Subject_order_record  s1= new Subject_order_record();
				s1.setSerial_number(dateString+currentTime.getTime());//��ˮ��
				s1.setAmount(qian);//�������
				s1.setStatus(1);//״̬  1���
				s1.setMember(member);//�û�
				s1.setSubject(subject);//���id
				s1.setCreate_date(currentTime);
				

				
				 //��������subject_purchase_record
				Subject_purchase_record s2 = new Subject_purchase_record();
				s2.setSerial_number(dateString+currentTime.getTime());//��ˮ��
				s2.setAmount(qian);//�������
				//����ip
				s2.setDeal_ip(IN_Users_service.getIpAddr(request));
				s2.setMember(member);//�û�
				s2.setSubject(subject);//���id
				s2.setDelflag(0);//����
				s2.setCreate_date(currentTime);//���ʱ��
				s2.setIspayment(0);//û�л���
				s2.setPay_interest_times(1);//����1��
			      java.util.Calendar rightNow = java.util.Calendar.getInstance();
			        //�õ���ǰʱ�䣬
			        rightNow.add(java.util.Calendar.DAY_OF_MONTH, subject.getPeriod());   
			        //����ʱ��ת��
			        String d = formatter.format(rightNow.getTime()); 
			     	s2.setLast_profit_day(d);//����Ϣ��
			     	double num = qian*(subject.getYear_rate()/100)/365*subject.getPeriod();
                    java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
			        s2.setInterest( Double.valueOf(df.format(num)));//��Ϣ
			
			        
			//	member_trade_record(���׼�¼��)
			 Member_trade_record    s3= new Member_trade_record();    
			s3.setMember_id(member);//�û�id
			s3.setTrade_no(dateString+currentTime.getTime());//���׺�
			 s3.setTrade_name("����:"+subject.getName()+";�ֽ���:"+qian);//��������       
			 s3.setAmount(qian);//���׽�� 
			 s3.setTrade_type("�˻����");//����
			 s3.setFund_flow(0);//�ʽ�����
			 s3.setTrade_status(1);//�������
			 s3.setCreate_date(currentTime);//���ʱ��
	
			 
				//   member_tally(���˱�)	 
			Member_tally    s4= new Member_tally();
			 s4.setMember(member);//�û�id
			 s4.setAmount(qian);//���
			 s4.setType_name("����:"+subject.getName()+";�ֽ���:"+qian);//��������       
			s4.setPay_date(currentTime);//֧��ʱ��
			s4.setCreate_date(currentTime);//����ʱ��
	  
			
				//member_account(��Ա�˻���)   
			Member_account  s5=account.getById(member.getId());
		   double  q=s5.getUseable_balance();
			s5.setUseable_balance(q-qian); //�˻���ǮҪ����
			s5.setUpdate_date(currentTime);//�޸�ʱ��
	    double  invest=		s5.getInvest_amount();//Ͷ���ܽ��
	      s5.setInvest_amount(invest+qian);//Ͷ���ܽ������
	   
				// member_profit_record(��Ա�����¼��)
				Member_profit_record  s6= new Member_profit_record();
				s6.setSerial_number(dateString+currentTime.getTime());//��ˮ��
				s6.setAmount(Double.valueOf(df.format(num)));//��Ϣ
				s6.setMember(member);//�û�
				s6.setDelflag(0);//����
				s6.setSubject(subject);//���id
				s6.setCreate_date(currentTime);//����ʱ��
				s6.setProfit_year(Integer.valueOf(format2.format(currentTime)));//��Ϣ��
                s6.setProfit_month(Integer.valueOf(format3.format(currentTime)));
                s6.setProfit_day(Integer.valueOf(format4.format(currentTime)));
			   s6.setComment("����:"+subject.getName()+";�ֽ���:"+qian);//
                
                //�������
		  	member_service.save_goumai(s1, s2, s3, s4, s5, s6);
		 	//  return "redirect:/IndexController/personal_center";
		  	return "";
		       }else {
		    	   return "redirect:/IndexController/index";     
		       }
	}
	
	

	/*//�첽�����˻����
	@RequestMapping("/useable_balance")
	@ResponseBody
	public  Member_account  useable_balance(HttpSession session) {
		System.out.println("����");
		   Member member = (Member) session.getAttribute("member_login");
		   System.out.println("aaaaaa="+member.getId());
		   return  account.getById(member.getId());
	}*/
	
	
	@RequestMapping("/yj")
	public String  yj(Feedback feedback,HttpSession session) {//�������
		   Member member = (Member) session.getAttribute("member_login");
		//	System.out.println(feedback.getTitle());
		//	System.out.println(feedback.getContent());
		   if(member!=null) {
	    	feedback.setCreate_date(new Date());
	    	feedback.setMember(member);
	    	IN_feedback_service.save_feedback(feedback);
	    	  return "redirect:/IndexController/personal_center";
	       }else {
	    	   return "redirect:/IndexController/index";     
	       }
	}
	
	
	
	
	@RequestMapping("/ok")   //����ok
	public String  ok(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
	    		//��ȡ֧����GET����������Ϣ
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
	    			//����������δ����ڳ�������ʱʹ��
	    			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
	    			params.put(name, valueStr);
	    		}
	    		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //����SDK��֤ǩ�� 
	    		if(signVerified) {
	    	   //�̻�������
	   		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
	   		//֧�������׺�
	   		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
	   		//������
	   		String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
	    	System.out.println(out_trade_no); 
	   		System.out.println(trade_no);
	   		System.out.println(total_amount);
	   		  
	   		//֧���ɹ��� ���ȸ��ݶ����� ��ѯ��ֵ��¼��
	   	Member_deposit_record m=IN_Member_deposit_record_service.get_deposit(out_trade_no);
	   		 if(m!=null) {
	   			//  System.out.println(m.getMember_id().getName());
	   			 // System.out.println(m.getPay_channel_order_no());
	   			 //���ĳ�ֵ��¼���״̬
	   			 //��ӽ��׼�¼��
	   			m.setStatus(1);//�������
	   			m.setUpdate_date(new Date());//�޸�ʱ��
	   			Member_trade_record mt=new Member_trade_record();
	   			mt.setMember_id(m.getMember_id());//�û�id
	   			mt.setTrade_no(out_trade_no);//������
	   			//��������
	   			mt.setTrade_name("֧����-�˻���ֵ:"+total_amount);
	   			mt.setAmount(Double.valueOf(total_amount));//Ǯ
	   			mt.setTrade_type("֧����");
	   			mt.setFund_flow(1);//�ʽ�����
	   			 mt.setTrade_status(1);//�������
	   			 mt.setCreate_date(new Date());
	   			 //���²�ѯ��Ա
	       Member mmm= 			member_service.getById(m.getMember_id().getId());
	    
	       //����
	       IN_Member_deposit_record_service.update(m,mt);
	     
	       //�˺���ӽ�Ǯ
	       mmm.getMember_account().setUseable_balance(mmm.getMember_account().getUseable_balance()+Double.valueOf(total_amount));
	      mmm.getMember_account().setUpdate_date(new Date());
	       //����
	      member_service.save(mmm);
	      //��ѯ
	       Member m222= 			member_service.getById(mmm.getId());
	       session.setAttribute("member_login",m222);	
	      //���°��ص���������
	      return "redirect:/IndexController/personal_center";    
	   		
	   		 } else {
	   		   return "redirect:/IndexController/dagou404";    
	   		 }
	   		
	   	
	    		}else {  //��֤ǩ��ʧ��
	    			   return "redirect:/IndexController/NewFile";   
	    		}
	    //	   return "/alipay/alipay.trade.page.pay.jsp";
	 //  }else {
	      //     return "redirect:/IndexController/index";   
	  //     }
	}
	
	
	
	@RequestMapping("/fk")   //֧��������
	public String  fk(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException {
		   Member member = (Member) session.getAttribute("member_login");
	       if(member!=null) {
	    	   //��Ҫ���ֵ��¼�����һ�� δ����״̬
	    	    String WIDout_trade_no=    request.getParameter("WIDout_trade_no");
	    	    String WIDsubject=    request.getParameter("WIDsubject");
	    	    String WIDtotal_amount=    request.getParameter("WIDtotal_amount");
	    	     Member_deposit_record  deposit_record = new Member_deposit_record();
	    	   //��ˮ��
	    	     deposit_record.setSerial_number(new Date().getTime()+"");
	    	  //״̬
	    	     deposit_record.setStatus(0);
	    	   //�û�id
	    	     deposit_record.setMember_id(member);
	    	   //���
	    	     deposit_record.setAmount(Double.valueOf(WIDtotal_amount));
	    	    //����
	    	     deposit_record.setPay_channel_name("֧����");
	    	     //������
	    	     deposit_record.setPay_channel_order_no(WIDout_trade_no);
	    	     //ɾ��״̬0
	    	     deposit_record.setDelFlag(0);
	    	     //����ʱ��
	    	     deposit_record.setCreate_date(new Date());
	    	     
	    	    IN_Member_deposit_record_service.save(deposit_record);
	    	     
	    	   return "/alipay/alipay.trade.page.pay";
	       }else {
	    		  return "redirect:/IndexController/index";   
	       }
	}
	
	
	@RequestMapping("/bk_ck")   //�󿨲鿴
	public String  bk_ck(HttpSession session) {
		   Member member = (Member) session.getAttribute("member_login");
	       if(member!=null) {
	    	   return "/jsp/bk_ck";
	    	   
	       }else {
	    		  return "redirect:/IndexController/index";   
	       }
		
		
	}
	
	

	@RequestMapping("/bk_ok")   //���ύ
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
	    	     System.out.println("������"+zh);
	    	     System.out.println("���֤:"+m22.getIdentity());
	    	     System.out.println("����:"+m22.getMember_name());
	    	     System.out.println("��+"+member_bankcards.getCard_no());*/
	    	
	    	    //��������id��ѯ
	    	     Bank bank = member_service.get_bank_id(bank_id);
	    	     member_bankcards.setBank(bank);
	    	     member_bankcards.setDelflag(0);//����
	    	     member_bankcards.setCreate_date(new Date());
	    	     String s=s111_111+"-"+s222_222+"-"+s333_333+"-"+zh;
	    	     member_bankcards.setCardaddress(s);
	    	 //�����û���
	    	     member.setMember_name(m22.getMember_name());
	    	     member.setIdentity(m22.getIdentity());
	    	     member.setUpdate_date(new Date());
	    	     member_bankcards.setMember_id(member);
	    	//�������ݿ�
	    	     member_service.update(member);
	    	     IN_Member_bankcards_service.save(member_bankcards);
	    	     //����session�д洢��
	    	     List<Member_bankcards>list=	IN_Member_bankcards_service.getById(member.getId());
	    		 //��ѯ�󶨵����п�
	    		   session.setAttribute("member_bankcards_bk", list);
	    	       session.setAttribute("member_login",member_service.getById(member.getId())); 
	    	       return "redirect:/IndexController/personal_center";
	     }else {
	    	  return "redirect:/IndexController/index"; 
	     }
		
		
		
	}
	
	
	
	
	
	
	@RequestMapping("/get_s333")  //����ʡ�������б�
	@ResponseBody
	public List<Sys_region> get_s333(int rid,int pid ) {
		//System.out.println("=============="+rid+"===="+pid);
		      List<Sys_region>list =member_service.get_s333(rid, pid);
		      return list;
	}
	

	@RequestMapping("/get_bank")  //���������б�
	@ResponseBody
	public List<Bank> get_bank() {
		   List<Bank>list =member_service.get_bank();
		   return list;
	}
	
	
	@RequestMapping("/yz_ka")  //��֤���п�Ψһ��
	@ResponseBody
	public  String   yz_ka(@RequestParam String card_no) {
	//	System.out.println("���п�"+card_no);
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
	
	
	
	
	
	
	@RequestMapping("/yz")  //��֤���֤Ψһ��
	@ResponseBody
	public  String   yz(@RequestParam String identity) {
	//	System.out.println("���֤"+identity);
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
	
	
	
	
	
	@RequestMapping("/bk")   //��
	public String bk(HttpSession session) {
	    Member member = (Member) session.getAttribute("member_login");
	     if(member!=null) {
	    	return "jsp/bk";
	     }else {
	    	  return "redirect:/IndexController/index"; 
	     }
	}
	
	
	@RequestMapping("cz")  //��ֵ
	public String cz(HttpSession session) {
	    Member member = (Member) session.getAttribute("member_login");
     if(member!=null) {
    	    //����id��ѯ�ǲ��ǰ��� 
    	 List<Member_bankcards>list = IN_Member_bankcards_service.getById(member.getId());
            if(!list.isEmpty()) {  //����  Ҫ����֧������ֵ����
            	return "alipay/index";
            }else {  //û�а�
            	  return "redirect:/MemberController/bk"; 
            }
     }else {
    	  return "redirect:/IndexController/index"; 
     }
    
	}
	
	
	
	
	@RequestMapping("/pwd2")   //�޸��������ʱ��֤ԭ����
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
	//	System.out.println("����ȡ������=="+pwd222);
		//�޸��������
		
		Member member = (Member) session.getAttribute("member_login");
	
		if(member!=null) {
		
		//���ݵ�½��id ��ѯʵ����
		Member member2 = member_service.getById(member.getId());
		//�õ�������
	     String y = member_service.getma(10);
       String p1=   new Md5Hash(pwd222,y).toString();
       //����ʱ�䣬�Σ�����
       member2.setWithdraw_password(p1);
       member2.setSalt2(y);
       member2.setUpdate_date(new Date());
       member_service.update(member2);
      //����session�д洢��
       session.setAttribute("member_login", member2);
       //��������
	    return "redirect:/IndexController/personal_center";
	    
		}else {
			  return "redirect:/IndexController/index"; 
		}
	}
	
	
	
	
	@RequestMapping("/withdraw_password")
	public String  withdraw_password(String  pwd7,HttpSession session) {
	//	System.out.println("����ȡ������=="+pwd7);
		//�����������
		Member member = (Member) session.getAttribute("member_login");
	
		if(member!=null) {
		
		//���ݵ�½��id ��ѯʵ����
		Member member2 = member_service.getById(member.getId());
		//�õ�������
	     String y = member_service.getma(10);
       String p1=   new Md5Hash(pwd7,y).toString();
       //����ʱ�䣬�Σ�����
       member2.setWithdraw_password(p1);
       member2.setSalt2(y);
       member2.setUpdate_date(new Date());
       member_service.update(member2);
      //����session�д洢��
       session.setAttribute("member_login", member2);
       //��������
	    return "redirect:/IndexController/personal_center";
	    
		}else {
			  return "redirect:/IndexController/index"; 
		}
	}
	
	
	
	@RequestMapping("/up_pwd")
	public String  up_pwd(String pwd,HttpSession session) {  //�޸�����
		Member member = (Member) session.getAttribute("member_login");
	
		if(member!=null) {	
		
		//���ݵ�½��id ��ѯʵ����
		Member member2 = member_service.getById(member.getId());
		//�õ�������
	     String y = member_service.getma(10);
        String p1=   new Md5Hash(pwd,y).toString();
       //����ʱ�䣬�Σ�����
        member2.setPassword(p1);
        member2.setSalt(y);
        member2.setUpdate_date(new Date());
        member_service.update(member2);
       //����session�д洢��
        session.setAttribute("member_login", member2);
        //��������
	    return "redirect:/IndexController/personal_center";
	    
		}else {
	    	  return "redirect:/IndexController/index"; 
	
	    }
	}
	
	
	 @RequestMapping("/pwd")   //�޸�����ʱ��֤ԭ����
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
		List<Member> listmemberByid=this.member_service.getMemberByid(id);//�˺���Ϣ
		System.out.println(listmemberByid.size());
		List<Member_account> member_account =this.member_service.getMember_accountByid(id);//�ʽ���Ϣ
		List<Subject_purchase_record> subject_purchase_record =this.member_service.getSubject_purchase_record(id);//Ͷ�ʼ�¼
		List<Member_withdraw_record> member_withdraw_record = this.member_service.getMember_withdraw_recordByid(id);//���ּ�¼
		List<Member_deposit_record> member_deposit_record = this.member_service.getMember_deposit_recordByid(id);//��ֵ��¼
		model.addAttribute("listmemberByid", listmemberByid.get(0));
		model.addAttribute("member_account", member_account.get(0));
		model.addAttribute("member_withdraw_record", member_withdraw_record);
		model.addAttribute("member_deposit_record", member_deposit_record);
		model.addAttribute("subject_purchase_record", subject_purchase_record);
		return"admin/menus25";
	}
}
