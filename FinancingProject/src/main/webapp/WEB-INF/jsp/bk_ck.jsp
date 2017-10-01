<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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

    <!--图标样式  -->
	 <link rel="stylesheet" type="text/css" href="/FinancingProject/css/font-awesome.css">
    <link rel="stylesheet" href="/FinancingProject/build/css/app.css" media="all">
    <link rel="stylesheet" href="/FinancingProject/build/css/themes/blue.css" media="all">


<link rel="stylesheet"  href="/FinancingProject/css/bootstrapValidator.css"  >
<script type="text/javascript"  src="/FinancingProject/js/bootstrapValidator.js"></script>

<title>个人中心</title>
</head>
<body>

<!--   1  导入顶部  -->
     <div style=" width:1002px; height:94px; margin:0 auto;">
        <iframe src="/FinancingProject/index_files/iframetop.jsp" scrolling="no" frameborder="0" width="1002" height="94"></iframe>
    </div>
  
  
   <!--   2   导入菜单栏  -->  
  <!--   
 
    <div class="jwNav">
		<div class="container">
			<div class="row">
				<ul class="topNav">
					<li class="active">
						<a class="item first" href="http://127.0.0.1:8080/FinancingProject/IndexController/index">
							首页
						</a>
					</li>
					<li>
						<a class="item" href="/FinancingProject/IndexController/Online_experience_center">
							网上体验中心
						</a>
					</li>
					<li>
						<a class="item" href="/FinancingProject/IndexController/product">
							产品中心
						</a>
					</li>
					<li>
						<a class="item" href="/FinancingProject/IndexController/news">
							新闻中心
						</a>
					</li>
					<li>
                        <a class="item" href="/FinancingProject/IndexController/download">
                            下载中心
                        </a>
					</li>
					<li>
                        <a class="item " href="/FinancingProject/IndexController/help">
                          孔明商学院
                        </a>
					</li>
					<li>
                        <a class="item" href="/FinancingProject/IndexController/investment_research">
                            投研中心
                        </a>
					</li>
					<li>
						<a class="item last" href="/FinancingProject/IndexController/personal_center">
							个人中心
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
 -->
 
  <!-- ============================================================= -->  
       <div style="background-color: ; width:100%px; height:40px; margin:0 auto;">
        <iframe src="/FinancingProject/index_files/daohang.jsp" scrolling="no" frameborder="0"  width="100%"></iframe>
    </div>
<br>
 



<table height="160" class="peopleInfo" width="970" border="0" cellspacing="0" cellpadding="0">
    <tbody>
    <tr>
        <td width="200px;">
            	<div  >
            	   <img src="/FinancingProject/images/0.jpg"    style="border-radius:50%;height: 150px;width: 150px;">
            </div>
            	</td>
            	<td  align="left" valign="middle" class="info" >
                <h2>${member_login.name }，<span>您好!</span></h2>
        </td>
        <td align="right">
            <a  onclick="return confirm('确定退出?')"    href="/FinancingProject/LoginController/out"   class="loginOut"><i class="fa fa-hand-o-right"></i>&nbsp;安全退出</a>
        </td>
    </tr>
</tbody>
</table>


<div class="countBox">
    <ul>
        <li><h2>0</h2><p>账户可用余额(元)<a href="javascript:;" class="iconfont"><span>账户可用余额</span><i></i></a></p></li>
        <li><h2>0</h2><p>账户总资产(元)<a href="javascript:;" class="iconfont"><span>可用余额+投资金额+累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">0</h2><p>投资金额(元)<a href="javascript:;" class="iconfont"><span>投资中资金</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">0</h2><p>累计收益(元)<a href="javascript:;" class="iconfont"><span>累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">0</h2><p>冻结金额(元)<a href="javascript:;" class="iconfont"><span>提现冻结金额</span><i></i></a></p></li>
    </ul>
    <a href="/FinancingProject/MemberController/cz" class="cz">充值</a>
    <a href="" class="tk">提款</a>
</div>    <div class="proMain clearfix">
<div class="adminLeft">
    <h2>我的投资</h2>
    
    <ul >
         <li > <a id="" href="" >投资记录</a></li>
        <li><a id="" href=""   >收益记录</a></li>
        <li><a id="" href="">充值记录</a></li>
        <li><a id="" href="">提款记录</a></li>
        <li><a id="" href="">体验金记录</a></li>
    </ul>
    <h2>我的账户</h2>
    <ul>  
        <li><a id="" href="#">账户充值</a></li>
        <li><a id="" href="/FinancingProject/IndexController/personal_center">安全中心</a></li>
        <li><a id="" href="">我要提款</a></li>
        <li><a id="" href="">我是理财师</a></li>
    </ul>
</div>



        <div class="admin-right">
        	<div class="tbConBox">
                <div class="tab">
                    <a class="select" href="">银行卡管理</a>
                </div>
                <div id="conBox">
                 
                 <div></div>
                   <div >        &nbsp;</div>
                    <div style="margin-left: 58px;"><font size="+1" color="#867530">真实姓名:</font>
                  <font color="red"  size="+2">  ${member_login.member_name }</font>
                    </div>
                     
                     <div style="margin-left: 40px;"><font size="+1" color="#867530">身份证号码:</font>
                            <font color="red"  size="+2"> 
                             <script type="text/javascript">
                                var s ="  ${member_login.identity }";
                               var ss = s.substring(0,16);
                              ss=ss+"****";
                              document.write(ss);
                              </script>
                              </font>
                     
                     </div>
                      <div  style="width: 350px;height: 223px;background-image:url('/FinancingProject/images/ka.jpg') ;margin-left: 40px;margin-top: 40px;">
                    <c:forEach items="${member_bankcards_bk }"  var="b" >
                   
                    <div style="padding-top: 98px;padding-left: 28px;font-family:'幼圆' ;"><font color="#FFFFFF" size=""><b>${b.bank.bname }</b></font></div>
                    <div style="margin-top:20px;padding-left: 28px;font-family:'幼圆' ;"><font color="#FFFFFF" size=""><b>${b.cardaddress }</b></font></div>
                    <div style="margin-top:10px;padding-left: 28px;font-family:'幼圆' ;"><font color="#FFFFFF" size="+2"><b>
                
                       <script type="text/javascript">
                                var s ="${b.card_no }";
                                var d= s.length;
                              var ss = s.substring(0,d-4);
                            ss=ss+"****";
                            document.write(ss);
                             </script>
                    
                    </b></font></div>
              </c:forEach>
                    </div>               
	     
	     <br><br>
                 <center>
                    <button type="button" class="btn btn-default"  onclick="javascript:history.back(-1);">返回</button>
          </center>
          <br>
            </div>
        </div>
    </div>
<!-- ========================================= -->

<!--  ==============================================================-->
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