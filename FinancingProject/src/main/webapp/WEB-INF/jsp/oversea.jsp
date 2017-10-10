<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="/FinancingProject/index_files/layer.css" id="layui_layer_skinlayercss">

<script src="/FinancingProject/index_files/jquery.js"></script>
<script type="text/javascript" src="/FinancingProject/index_files/layer.js"></script>
<script src="/FinancingProject/index_files/echarts.js"></script>
<script src="/FinancingProject/index_files/hm.js"></script>
<script src="/FinancingProject/index_files/hm(1).js"></script>	
<script src="/FinancingProject/index_files/jquery"></script>
<script src="/FinancingProject/index_files/bootstrap"></script>

<title>产品中心</title>
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

<script  type="text/javascript">    
//刷新固守类理财
function fun1(){
	$("#typeid").val("");			
	$("#year_rate").val("");
	$("#flag").val("");
	$("#period_start").val("");
	$("#period_end").val("");
	$("#status").val("");
	$("#bbb1").val("11");
	$("#bbb2").val("21");
	$("#bbb3").val("31");
	$("#bbb4").val("41");
	
	
	document.forms[0].action="/FinancingProject/IndexController/product";
	document.forms[0].submit();	 
}
   
</script>

<form action="" method="post" id="f1" name="f1">

      <input type="hidden"  id="bbb1"  name="bbb1"  val="${bbb1 }">
           <input type="hidden"  id="bbb2"  name="bbb2"  val="${bbb2 }">
       <input type="hidden"  id="bbb3"  name="bbb3"  val="${bbb3 }">
        <input type="hidden"  id="bbb4"  name="bbb4"  val="${bbb4}">
            
            <input type="hidden"  name="typeid"  id="typeid"   val="${typeid }">
			<input type="hidden" name="year_rate" id="year_rate" value="${year_rate }"/>
			<input type="hidden" name="type" id="type" value="${type}"   />
			<input type="hidden" name="status" id="status" valus="${status }">
			<input type="hidden" name="flag" id="flag" value="${flag}"/>
			<input type="hidden" name="period_start" id="period_start" value="${period_start}">
			<input type="hidden" name="period_end" id="period_end" value="${period_end }">
  </form>
  
  
  <div class="proMain">
    	<div class="hwpzNav">
    		<ul>
    			<li class="first"><a class="active" href="#"  onclick="fun1();" >固收类理财</a></li>
    			<li class="second"><a href="/FinancingProject/IndexController/finance"><font color="#9D8440">私募基金</font></a></li>
    			<li class="three"><a href="/FinancingProject/IndexController/oversea""><font color="#9D8440">海外配置</font></a></li>
    		</ul>
    	</div>
  
  
  
  
<center>
<c:forEach items="${oversea}" var="o">
<a href="" >
<div   style="background-color: #F5F5F5;width: 90%;height: 110px;margin-top: 10px;" >

    <table border="0"  width="100%"  height="100%">
        <tr>
        <td rowspan="2"  width="110" align="center">
         <img src="${o.oversea_icon }" width="90px" height="90px">
     </td>
             <td><h3><b>${o.title }</b></h3></td>
             <td align="right"  style="padding-right: 5px"><font color="red">${o.description}</font></td>
        </tr>
        <tr>
          <td>${o.child_title}</td>
          <td align="right"  style="padding-right: 5px"><font color="blue">用户群体：</font>
          ${o.user_type }</td>
        </tr>
    </table>
    </div>
    </a>
</c:forEach>
</center>

	

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
</html>