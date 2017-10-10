<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
<meta name="Keywords" content="孔明理财，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="孔明理财——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">

<link href="/FinancingProject/images/timg.jpg" type="image/x-icon" rel="shortcut icon">
<link href="/FinancingProject/index_files/iconfont.css" rel="stylesheet" type="text/css">
<link href="/FinancingProject/index_files/common.css" rel="stylesheet">
<link href="/FinancingProject/index_files/jw.css" rel="stylesheet">
<link href="/FinancingProject/index_files/common" rel="stylesheet">
<link href="/FinancingProject/index_files/jw.less" rel="stylesheet">
<link rel="stylesheet" href="/FinancingProject/index_files/layer.css" id="layui_layer_skinlayercss">

<script src="/FinancingProject/index_files/jquery.js"></script>
<script type="text/javascript" src="/FinancingProject/index_files/layer.js"></script>
<script src="/FinancingProject/index_files/echarts.js"></script>
<script src="/FinancingProject/index_files/hm.js"></script>
<script src="/FinancingProject/index_files/hm(1).js"></script>	
<script src="/FinancingProject/index_files/jquery"></script>
<script src="/FinancingProject/index_files/bootstrap"></script>

<title>购买固收类理财</title>
</head>
<body>
<!--   1  导入顶部  -->
     <div style=" width:1002px; height:94px; margin:0 auto;">
        <iframe src="/FinancingProject/index_files/iframetop.jsp" scrolling="no" frameborder="0" width="1002" height="94"></iframe>
    </div>
    
    <!--   2   导入菜单栏  -->
  
       <div style="background-color: ; width:100%px; height:40px; margin:0 auto;">
        <iframe src="/FinancingProject/index_files/daohang.jsp" scrolling="no" frameborder="0"  width="100%"></iframe>
    </div>
    
<!--=====================================  -->
<!--  --=============================================-  -->

<div class="proMain">
    <div class="conTit">
        <h2><em>￥</em>${buyproduct.name }</h2>
    </div>
    <table class="conTable" width="100%" border="0" cellspacing="0" cellpadding="0">
        <tbody><tr>
            <td class="txtInfo">
                <div class="txt1">
                    <h2>
                     <script type="text/javascript">
                                  var id='${buyproduct.id}';
              				      $.ajaxSetup({  
              					    async : false  
              				 	  }); 
              				    var m;
                                $.post("/FinancingProject/IndexController/count",{id:id},
                              		    function(msg){
                              		    	m = msg;
                              		    });
                               document.write(m);
                                </script>
                    
                    
                    </h2>
                    <p>已购人数(人)</p>
                </div>
                <div class="txt2">
                    <h2>${buyproduct.year_rate }%</h2>
                    <p>年化收益</p>
                </div>
                <div class="txt1">
                    <h2>${buyproduct.period }</h2>
                    <p>投资期限(天)</p>
                </div>
            </td>
            <td width="360" rowspan="2" align="center" ;="" valign="middle" height="320">
                <div class="tbBox">
                    <input type="hidden" id="account" value="">
                    <h2>
                     <script type="text/javascript">
				  var id='${buyproduct.id}';
				  $.ajaxSetup({  
					    async : false  
					}); 
				  var num1=0;
				  $.post("/FinancingProject/MemberController/getTotalMoney",{id:id},function(data){
					 num1=data;
				  });
				  document.write(num1);
				 </script>
                    
                    
                    
                    </h2>
                    <p>已投金额(元)</p>
                    <div class="li4" style="">
                    <span id="checkmoney" style="color: red;"></span></div>
                   
                   
                    <div class="tit">
                    
                      <c:if  test="${ empty member_login  }"> 
                    	<span class="fr">
                            <a style="color:#2695d5" class="unlogin" href="/FinancingProject/IndexController/login">登录</a>后可见
						</span>
				 	</c:if> 
                        <h2>账户余额
                <c:if test="${!empty member_login }">
                &nbsp;&nbsp;
                <font color="red"> ${member_account.useable_balance }</font>
                   &nbsp;&nbsp;
                   <a  href="/FinancingProject/MemberController/cz" >充值</a>
                      </c:if> 
                        
                        </h2>
           
                    
                    </div>
                    
                    <form  method="post"  name="gou"  id="gou">
                    <input      onkeyup="fun()"     min="100"    name="qian"   id="qian" class="txt" name="qian" type="number" placeholder="起投金额100元以上">
                    <input type="hidden"  name="subject_id"    id="subject_id"  value="${buyproduct.id }"> 
                    </form>
                        <span style="float: right;margin-top: -40px;position: relative; line-height: 40px; padding: 0 10px;color: #f00;" id="addMoney"></span>
                   <!--   <p class="preBox">
                        <input type="checkbox" id="registerRule" class="registerRule" checked="checked"><span class="fl">同意<a href="http://pro.ying158.com/web/syxy" target="_black">《产品协议》</a></span>
                    </p> -->
                    
                        <div id="ccc">预期所得收益:
                        <font color="red"   id="ddd">0</font>
                        元
                        </div>
                    
                    <c:if test="${!empty member_login }">
                    <button class="submit"   id="ok"   onclick="fun2();">确认抢购</button>
                 </c:if>
                  <c:if test="${empty member_login }">
                    <button  class="submit"   id="ok"   onclick="fun3();">登陆后抢购</button>
                 </c:if>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <ul class="conInfoList">
                    <li class="info">
                        <p>计息日期：<font color="#00baff">
                        2017-09-20
                        <script type="text/javascript">
                         var myDate = new Date();
                         var a=          myDate.getFullYear();    //获取完整的年份(4位,1970-????)
                        var b=   myDate.getMonth()+1;       //获取当前月份(0-11,0代表1月)
                        var c=      myDate.getDate();        //获取当前日(1-31)
                       var d=a+"-"+b+"-"+c;
                       document.write(d);
                       </script> 
                        </font>
                        
                        
                        </p>
                        <p>还款方式：<font color="#00baff">一次性还本付息</font></p>
                        <p>资金到账日：<font color="#00baff">
                     <script type="text/javascript">
                var  tian="${buyproduct.period }";
            	    var  tian2=parseInt("${buyproduct.period }");
            	    var tian3=tian2+1;
                    var a = new Date();
                      var b = new Date();
                  a = a.valueOf();
                     b = b.valueOf();
                    a = a + tian * 24 * 60 * 60 * 1000;
                     b = b + tian3 * 24 * 60 * 60 * 1000;
                  a = new Date(a);
                     b = new Date(b);
              var a4=    a.getFullYear() + "-" + (a.getMonth() + 1) + "-" + a.getDate() ;
                  var b4=    b.getFullYear() + "-" + (b.getMonth() + 1) + "-" +b.getDate() ;

                  document.write(a4+" 至 "+b4);
                  </script>        
                        </font>
                        </p>
                    </li>
                    <li class="info">
                        <p>保障方式：
                        <font color="#00baff">
                            <c:if test="${buyproduct.safeGuard_way ==0}">
                                企业担保	
                            </c:if>
                     
						     <c:if test="${buyproduct.safeGuard_way == 1 }">
						     银行监督
						     </c:if>
                        
                    
                        </font>
                        </p>
                        <p>资金安全：<font color="#00baff">中国人保财险承保</font></p>
                        <p></p>
                    </li>
                </ul>
            </td>
        </tr>
    </tbody>
	</table>


<script type="text/javascript">
   function fun(){
	     var a = $("#qian").val();
     	 //   alert(a);
	    var n="${buyproduct.year_rate }"/100;
	    var  tian="${buyproduct.period }";
	  var   num=a*n/365*tian;
	  
	  var f = Math.round(num*100)/100; 
      var s = f.toString(); 
      var rs = s.indexOf('.'); 
      if (rs < 0) { 
        rs = s.length; 
        s += '.'; 
      } 
      while (s.length <= rs + 2) { 
        s += '0'; 
      } 
	  
	  
	    $("#ddd").text(s);
   }
 
   function fun2(){//确定购买
	   
	   var a = $("#qian").val();
	   var m ="${member_account.useable_balance }";
		if(parseFloat(m)<parseFloat(a)){
			     $("#checkmoney").text("账户余额不足,请充值!"); 
			     return ;
		}
		
		var    qi = "${buyproduct.floor_amount}";
	  if(a<qi){
		    $("#checkmoney").text("标的起投金额最低"+qi+"元!"); 
		    return ;
	  }
	
	  $("#checkmoney").text(""); 
	  $("#gou").attr("action","/FinancingProject/MemberController/gou");
	  $("#gou").submit(); 
	
   }
   
   
   function  fun3(){
	   window.location.href="/FinancingProject/IndexController/login";
	   
   }
</script>
 <!-- 4     图片广告 -->
    <div class="container index">
			<div class="row">
				<div class="security">
					<div class="item">
						<img src="/FinancingProject/index_files/indexSecurity1.png">
						<div class="detail">
							资金银行监管
							<div class="desc">
								平台资金由第三方银行监管
							</div>
						</div>
					</div>
					<div class="item">
						<img src="/FinancingProject/index_files/indexSecurity2.png">
						<div class="detail">
							交易证监会监管
							<div class="desc">
								投资交易由证监会监管
							</div>
						</div>
					</div>
					<div class="item">
						<img src="/FinancingProject/index_files/indexSecurity3.png">
						<div class="detail">
							风控监管
							<div class="desc">
							全自动风控系统为您保驾护航
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    
    <!--  5合作商  -->
    	<div class="foot">
		<div class="container">
            <div class="row">
                <div class="hzhb_box">
                    <div class="title" style=" padding-left:10px; font-weight:normal; font-size:20px; color:#ccc;">
                        主要合作机构
                    </div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.picc.com/"><img src="/FinancingProject/index_files/1_on.png "></a></div>
                     <div class="hzhb_item"><a target="_blank" href="http://www.fuioupay.com/"><img src="/FinancingProject/index_files/2_on.png "></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.nanhua.net/"><img src="/FinancingProject/index_files/3_on.png "></a></div>
                     <div class="hzhb_item"><a target="_blank" href="http://www.zttrust.com.cn/"><img src="/FinancingProject/index_files/4_on.png "></a></div>
                     <div class="hzhb_item"><a target="_blank" href="http://sc.hkex.com.hk/TuniS/www.hkex.com.hk/eng/index.htm/"><img src="/FinancingProject/index_files/5_on.png "></a></div>
                     <div class="hzhb_item"><a target="_blank" href="http://www.cmegroup.com/cn-s/"><img src="/FinancingProject/index_files/6_on.png "></a></div>
                     <div class="hzhb_item"><a target="_blank" href="http://www.sgx.com/wps/portal/sgxweb_ch/home/!ut/p/a1/04_Sj9CPykssy0xPLMnMz0vMAfGjzOKNHB1NPAycDSz9wwzMDTxD_Z2Cg8PCDANdjYEKIoEKDHAARwNC-sP1o8BK8JhQkBthkO6oqAgAzDYPQQ!!/dl5/d5/L2dBISEvZ0FBIS9nQSEh/"><img src="/FinancingProject/index_files/7_on.png "></a></div>
                     <div class="hzhb_item"><a target="_blank" href="http://www.neeq.com.cn/index/"><img src="/FinancingProject/index_files/8_on.png "></a></div>
                     <div class="hzhb_item"><a target="_blank" href="http://www.cmbchina.com/"><img src="/FinancingProject/index_files/9_on.png "></a></div>
                     <div class="hzhb_item"><a target="_blank" href="http://www.bankcomm.com/BankCommSite/default.shtml"><img src="/FinancingProject/index_files/10_on.png "></a></div>
                     <div class="hzhb_item"><a target="_blank" href="http://www.ccb.com/cn/home/index.html"><img src="/FinancingProject/index_files/11_on.png "></a></div>
                     <div class="hzhb_item"><a target="_blank" href="http://www.icbc.com.cn/icbc/"><img src="/FinancingProject/index_files/12_on.png "></a></div>
                </div>

                <div class="ft_item ft_item_sns">
                    <div class="ft_item_tit">关注我们</div>
                    <ul style=" margin-bottom:0px;" class="ft_sns_list clearfix">
                        <li>
                            <div class="wx_tips j_tips">
                                <div class="tips_hd">
                                  <img src="/FinancingProject/index_files/aabb.jpg"   height="68px"  width="68px" ></img>
                                    <!-- <em class="ico_sns ico_weixin"></em> -->
                                    <span class="txt">微信公众号</span>
                                </div>
                                <div class="tips_bd">
                                    <em class="arrow"></em>
                                     
                                    <img   src="/FinancingProject/index_files/ff.png" alt="微信公共平台">
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="" target="_blank" rel="nofollow">
                               <img src="/FinancingProject/index_files/cc.jpg"   height="68px"  width="68px" ></img>
                                <span class="txt">新浪微博</span>
                            </a>
                        </li>
                        <li>
                            <a href="" target="_blank" rel="nofollow">
                                   <img src="/FinancingProject/index_files/dd.jpg"   height="68px"  width="68px" ></img>
                                <span class="txt">腾讯微博</span>
                            </a>
                        </li>
                    </ul>

                    <div class="contactUs">
                       <div class="title" style=" padding-left:10px; font-weight:normal; font-size:20px; color:#ccc;">
                          联系我们
                        </div>
                        <div class="contactInfo" style="padding-left:30px;">
                            <a style="display:inline-block; height:50px; width:50px; text-align:center; " target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=2060142983&amp;site=qq&amp;menu=yes"><img src="/FinancingProject/index_files/qqIcon.png"></a>
                            <span class="kefu">在线客服</span>&nbsp;<span class="time">08:30 - 21:00</span>
                        </div>
                    </div>
                </div>
			</div>
		</div>
	</div>
    
    <!--6底部  -->
    <div class="foot3">
		<div class="container">
			<div class="row">
				Copyright © 2017  All Rights Reserverd 襄阳孔明投资管理有限公司 版权所有<br>
			</div>
		</div>
	</div>
    
</body>
</html>>