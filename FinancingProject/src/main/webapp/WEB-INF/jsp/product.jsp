<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<title>产品中心</title>
</head>
<body>
<!--   1  导入顶部  -->
     <div style=" width:1002px; height:94px; margin:0 auto;">
        <iframe src="/FinancingProject/index_files/iframetop.html" scrolling="no" frameborder="0" width="1002" height="94"></iframe>
    </div>
    
    <!--   2   导入菜单栏  -->
    <div class="jwNav">
		<div class="container">
			<div class="row">
				<ul class="topNav">
					<li class="active">
						<a class="item first" href="http://127.0.0.1:8080/FinancingProject/index.jsp">
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

    


  <div class="proMain">
    	<div class="hwpzNav">
    		<ul>
    			<li class="first"><a class="active" href="/subject">固收类理财</a></li>
    			<li class="second"><a href="/jsp/finance">私募基金</a></li>
    			<li class="three"><a href="/oversea">海外配置</a></li>
    		</ul>
    	</div>
        <div class="sdShaix">
        	<ul>
            	<li class="first">标的类型：</li>
               		<li><a href="/subject?cid=11&type=11&yearRate=21&period=31&status=41" id="11">全部</a></li>
               		<li><a href="/subject?cid=12&type=11&yearRate=21&period=31&status=41" id="12">固收类理财</a></li>
               		<li><a href="/subject?cid=13&type=11&yearRate=21&period=31&status=41" id="13">车盈宝</a></li>
            </ul>
        	<ul>
            	<li class="first">年化收益：</li>
               		<li><a href="/subject?cid=21&type=11&yearRate=21&period=31&status=41" id="21">全部</a></li>
               		<li><a href="/subject?cid=22&type=11&yearRate=21&period=31&status=41" id="22">6.0%</a></li>
               		<li><a href="/subject?cid=23&type=11&yearRate=21&period=31&status=41" id="23">7.0%</a></li>
               		<li><a href="/subject?cid=24&type=11&yearRate=21&period=31&status=41" id="24">7.5%</a></li>
               		<li><a href="/subject?cid=25&type=11&yearRate=21&period=31&status=41" id="25">8.0%</a></li>
               		<li><a href="/subject?cid=25&type=11&yearRate=21&period=31&status=41" id="25">8.0%以上</a></li>
            </ul>
        	<ul>
            	<li class="first">项目期限：</li>
               		<li><a href="/subject?cid=31&type=11&yearRate=21&period=31&status=41" id="31">全部</a></li>
               		<li><a href="/subject?cid=32&type=11&yearRate=21&period=31&status=41" id="32">15天以下</a></li>
               		<li><a href="/subject?cid=33&type=11&yearRate=21&period=31&status=41" id="33">15-30天</a></li>
               		<li><a href="/subject?cid=34&type=11&yearRate=21&period=31&status=41" id="34">30-180天</a></li>
               		<li><a href="/subject?cid=35&type=11&yearRate=21&period=31&status=41" id="35">180-365天</a></li>
               		<li><a href="/subject?cid=36&type=11&yearRate=21&period=31&status=41" id="36">一年以上</a></li>
            </ul>
        	<ul>
            	<li class="first">标的状态：</li>
               		<li><a href="/subject?cid=41&type=11&yearRate=21&period=31&status=41" id="41">全部</a></li>
               		<li><a href="/subject?cid=42&type=11&yearRate=21&period=31&status=41" id="42">投标中</a></li>
               		<li><a href="/subject?cid=43&type=11&yearRate=21&period=31&status=41" id="43">还款中</a></li>
               		<li><a href="/subject?cid=44&type=11&yearRate=21&period=31&status=41" id="44">已完成</a></li>
            </ul>
        </div>


<div class="ajaxContainer">
	<!-- 异步内容开始 -->
					<ul class="tbList">
						<li class="first">
									<span class="ico zq"></span>
							<h2><em>投</em>稳盈宝新手标</h2>
							<i></i>
						</li>
						<li class="second">					
							
							<div class="txt1">
								<h2>5.0<span style="font-size:18px;">+1.0%</span></h2>
								<p>年化收益</p>
							</div>
							
							<div class="txt2">
								<h2>￥100.00</h2>
								<p>起购金额(元)</p>
							</div>
							
							<div class="txt2">
								<h2>5天</h2>
								<p>投资期限</p>
							</div>
						</li>
						<li class="three">
								<a href="#1">企业担保</a><span>中国人保财险承保</span>
								<p>计息日期：当天投资，立即计息<br>已购人数：689人</p>
						</li>
						<li class="four">
								
						</li>
						<li class="five">
							<a class="abtn" href="/subject/subjectContent/1612">购买</a>
						</li>
					</ul>
					<ul class="tbList">
						<li class="first">
									<span class="ico zq"></span>
							<h2><em>投</em>稳盈宝起步标</h2>
							<i></i>
						</li>
						<li class="second">					
							
							<div class="txt1">
								<h2>5.5<span style="font-size:18px;">+1.0%</span></h2>
								<p>年化收益</p>
							</div>
							
							<div class="txt2">
								<h2>￥100.00</h2>
								<p>起购金额(元)</p>
							</div>
							
							<div class="txt2">
								<h2>15天</h2>
								<p>投资期限</p>
							</div>
						</li>
						<li class="three">
								<a href="#1">企业担保</a><span>中国人保财险承保</span>
								<p>计息日期：当天投资，立即计息<br>已购人数：382人</p>
						</li>
						<li class="four">
								
						</li>
						<li class="five">
							<a class="abtn" href="/subject/subjectContent/1611">购买</a>
						</li>
					</ul>
					<ul class="tbList">
						<li class="first">
									<span class="ico zq"></span>
							<h2><em>投</em>稳盈宝整月标</h2>
							<i></i>
						</li>
						<li class="second">					
							
							<div class="txt1">
								<h2>6.0<span style="font-size:18px;">+1.0%</span></h2>
								<p>年化收益</p>
							</div>
							
							<div class="txt2">
								<h2>￥100.00</h2>
								<p>起购金额(元)</p>
							</div>
							
							<div class="txt2">
								<h2>30天</h2>
								<p>投资期限</p>
							</div>
						</li>
						<li class="three">
								<a href="#1">企业担保</a><span>中国人保财险承保</span>
								<p>计息日期：当天投资，立即计息<br>已购人数：354人</p>
						</li>
						<li class="four">
								
						</li>
						<li class="five">
							<a class="abtn" href="/subject/subjectContent/1610">购买</a>
						</li>
					</ul>
					<ul class="tbList">
						<li class="first">
									<span class="ico zq"></span>
							<h2><em>投</em>稳盈宝幸福标</h2>
							<i></i>
						</li>
						<li class="second">					
							
							<div class="txt1">
								<h2>7.0<span style="font-size:18px;">+1.0%</span></h2>
								<p>年化收益</p>
							</div>
							
							<div class="txt2">
								<h2>￥100.00</h2>
								<p>起购金额(元)</p>
							</div>
							
							<div class="txt2">
								<h2>50天</h2>
								<p>投资期限</p>
							</div>
						</li>
						<li class="three">
								<a href="#1">企业担保</a><span>中国人保财险承保</span>
								<p>计息日期：当天投资，立即计息<br>已购人数：475人</p>
						</li>
						<li class="four">
								
						</li>
						<li class="five">
							<a class="abtn" href="/subject/subjectContent/1609">购买</a>
						</li>
					</ul>
	<!-- 异步内容结束 -->
					<div class="llpage">
							<div class="in">
								
									<a class="prev_page">上页</a>
								
								
										<a class="now" >1</a>
								
								
									<a class="next_page" rel="next">下页</a>
							</div>
						</div>
					</div>


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