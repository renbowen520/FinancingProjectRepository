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

<title>新闻中心</title>
	<style>
		* {
			margin: 0;
			padding: 0;
			list-style: none;
		}

		img {
			border: 0;
		}

		.rides-cs {
			font-size: 12px;
			background: #29a7e2;
			position: fixed;
			top: 250px;
			right: 0px;
			_position: absolute;
			z-index: 1500;
			border-radius: 6px 0px 0 6px;
		}

			.rides-cs a {
				color: #00A0E9;
			}

				.rides-cs a:hover {
					color: #ff8100;
					text-decoration: none;
				}

			.rides-cs .floatL {
				width: 36px;
				float: left;
				position: relative;
				z-index: 1;
				margin-top: 21px;
				height: 181px;
			}

				.rides-cs .floatL a {
					font-size: 0;
					text-indent: -999em;
					display: block;
				}

			.rides-cs .floatR {
				width: 130px;
				float: left;
				padding: 5px;
				overflow: hidden;
			}

				.rides-cs .floatR .cn {
					background: #F7F7F7;
					border-radius: 6px;
					margin-top: 4px;
				}

			.rides-cs .cn .titZx {
				font-size: 14px;
				color: #333;
				font-weight: 600;
				line-height: 24px;
				padding: 5px;
				text-align: center;
			}

			.rides-cs .cn ul {
				padding: 0px;
			}

				.rides-cs .cn ul li {
					line-height: 38px;
					height: 38px;
					border-bottom: solid 1px #E6E4E4;
					overflow: hidden;
					text-align: center;
				}

					.rides-cs .cn ul li span {
						color:#333;
					}

					.rides-cs .cn ul li a {
						color: #777;
					}

					.rides-cs .cn ul li img {
						vertical-align: middle;
					}

			.rides-cs .btnOpen, .rides-cs .btnCtn {
				position: relative;
				z-index: 9;
				top: 25px;
				left: 0;
				background-image: url(/Content/images/jw/qqkefu.png);
				background-repeat: no-repeat;
				display: block;
				height: 146px;
				padding: 8px;
			}

			.rides-cs .btnOpen {
				background-position: 0 0;
			}

			.rides-cs .btnCtn {
				background-position: -37px 0;
			}

			.rides-cs ul li.top {
				border-bottom: solid #ACE5F9 1px;
			}

			.rides-cs ul li.bot {
				border-bottom: none;
			}

        .topNav {
            padding: 0;
            margin: 0;
        }
	li {
		margin: 0;
		padding: 8px 0;
	}

	li.active {
		/*background: #323030;*/
        background:none;
	}

	li.active a {
		color: white;
	}
	</style>
</head>
<body>
<!--   1  导入顶部  -->
     <div style=" width:1002px; height:94px; margin:0 auto;">
        <iframe src="/FinancingProject/index_files/iframetop.jsp" scrolling="no" frameborder="0" width="1002" height="94"></iframe>
    </div>
    
    <!--   2   导入菜单栏  -->
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

<div class="container helpCenter">
    <div class="row">
        <div class="left">
            <div class="item first active" name="reports" id="reportsTab">
                平台公告
            </div>
            <div class="item" name="lastest" id="lastestTab">
                市场动态
            </div>
	        <div class="item" name="strategy" id="strategyTab">
		        趣味理财
	        </div>
			
            <div class="item" name="topNews" id="topNewsTab">
                新闻头条
            </div>
            <div class="blank" style="height:532px;">

            </div>
        </div>
        <div class="right">
            <div class="content" id="reports" style="display: block;">
                <div class="title">
                    平台公告
                </div>
                <ul class="newsList">
                    
	<li>
		2017年春节放假安排<span class="time">2017-01-23</span>
	</li>
	<li>
		重磅推出阳光私募基金-吉威量化套利稳健1号<span class="time">2016-04-14</span>
	</li>
	<li>
		关于盈+理财平台安全卡管理通告<span class="time">2016-01-13</span>
	</li>
	<li>
		盈+全球首映<span class="time">2015-07-13</span>
	</li>

	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>

<li>
	<a onclick="pagation(0)">上一页</a> | <a onclick="pagation(2)">下一页</a>
</li>

                </ul>
            </div>
            <div id="strategy" class="content" style="display: none;">
                <div class="title">
                    趣味理财
                </div>
                <ul class="newsList">
                    
	<li>
		【私募知识】私募基金的五大误区<span class="time">2016-04-15</span>
	</li>
	<li>
		秒杀盖茨和巴老 这哥们财富增长了14658%<span class="time">2015-09-17</span>
	</li>
	<li>
		会买衣服怎么可能不会投资？教你从买衣服中学投资！<span class="time">2015-09-17</span>
	</li>
	<li>
		他赚了75亿美金, 却要在2016年之前散尽家产<span class="time">2015-09-16</span>
	</li>
	<li>
		美团估值为何骤降了？“烧钱模式”惹的祸!<span class="time">2015-09-16</span>
	</li>
	<li>
		滴滴投资人王刚：滴滴发展过程跌宕起伏堪比韩剧<span class="time">2015-09-15</span>
	</li>
	<li>
		张泉灵离职央视：生命的后半段，我想重来一次！<span class="time">2015-09-14</span>
	</li>
	<li>
		美国“9.11”事件3700余名救援人员确诊患癌<span class="time">2015-09-14</span>
	</li>
	<li>
		触控笔、微软站台还有爱马仕，苹果简直能把乔帮主气活了！<span class="time">2015-09-11</span>
	</li>
	<li>
		股权众筹第一案焦点：平台是受托人还是居间人<span class="time">2015-09-07</span>
	</li>


<li>
	<a onclick="pagation(0)">上一页</a> | <a onclick="pagation(2)">下一页</a>
</li>

                </ul>
            </div>
	        <div id="lastest" class="content" style="display: none;">
		        <div class="title">
			        市场动态
		        </div>
		        <ul class="newsList">
			        
	<li>
		私募巨头贝莱德掌门人：负利率或导致“危险”后果<span class="time">2016-04-15</span>
	</li>
	<li>
		美联储告诉全世界：紧盯中国！<span class="time">2015-09-21</span>
	</li>
	<li>
		央行马骏：中国经济前景将明显好于那些悲观的市场预<span class="time">2015-09-17</span>
	</li>
	<li>
		股权众筹第一案判决 平台人人投胜出<span class="time">2015-09-17</span>
	</li>
	<li>
		海通证券姜超：三理由告诉你不要那么悲观 市场已经不算贵<span class="time">2015-09-16</span>
	</li>
	<li>
		告别“钱荒” 步入“资产配置荒”时代<span class="time">2015-09-15</span>
	</li>
	<li>
		美元，别人的货币，我们的问题<span class="time">2015-09-15</span>
	</li>
	<li>
		经济下行压力明显增大 继高盛之后中金下调中国GDP预期<span class="time">2015-09-15</span>
	</li>
	<li>
		你真的理解什么是O2O吗？它的三大特点和两大难题<span class="time">2015-09-14</span>
	</li>
	<li>
		李曙军欲开“一人公募” 首现自然人公募基金<span class="time">2015-09-14</span>
	</li>


<li>
	<a onclick="pagation(0)">上一页</a> | <a onclick="pagation(2)">下一页</a>
</li>

		        </ul>
	        </div>
			<div id="topNews" class="content" style="display: none;">
				<div class="title">
					新闻头条
				</div>
				<ul class="newsList">
					
	<li>
		【投资策略】一文看懂量化对冲<span class="time">2016-04-15</span>
	</li>
	<li>
		十年后的中国远超你想象（深度！）<span class="time">2016-02-02</span>
	</li>
	<li>
		唐彬：互联网金融的哲学思考<span class="time">2016-02-02</span>
	</li>
	<li>
		哈佛76年研究结果：只要遇到真爱，人生繁盛的几率就会显著提升<span class="time">2016-02-02</span>
	</li>
	<li>
		私人财富重配 波澜壮阔的大牛市或在路上<span class="time">2016-02-02</span>
	</li>

	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>

<li>
	<a onclick="pagation(0)">上一页</a> | <a onclick="pagation(2)">下一页</a>
</li>

				</ul>
			</div>
			<div id="zuixins" class="content" style="display: none;">
				<div class="title">
					最新动态
				</div>
				<ul class="newsList">
					

	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>
	<li>&nbsp;</li>

<li>
	<a onclick="pagation(0)">上一页</a> | <a onclick="pagation(2)">下一页</a>
</li>

				</ul>
			</div>
        </div>
    </div>
</div>
<script>

    var cid = "B8C8DD38-0805-4EF4-BFF6-17B835FCA8AA";
    var container = "#reports";

   

    $(document).ready(function () {
        var url = window.location.href.toLowerCase();
        if (url.indexOf("strategy") >= 0) {
          
            $("#strategyTab").click();
        } else if (url.indexOf("reports") >= 0) {
         
            $("#reportsTab").click();
        } else if (url.indexOf("lastest") >= 0) {
        
            $("#lastestTab").click();
        }
        else if (url.indexOf("zuixin") >= 0) {

        	$("#zuixinsTab").click();
        }
        else if (url.indexOf("topNews") >= 0) {

        	$("#topNewsTab").click();
        }
    });

    function pagation(pageIndex) {
        $.get("/allnews/" + cid + "/10/" + pageIndex, function (rel) {
            $(container).find("ul.newsList").html(rel);
        });
    }


    $(".helpCenter .left").on("click", ".item", function () {

        var className = $(this).attr("class");
        if (className.indexOf("active") >= 0) {
            return;
        } else {
            var idName = $(this).attr("name");
            $(".helpCenter .left .item").removeClass("active");
            $(this).addClass("active");
            $(".content").hide();
            var height = "";
            switch (idName) {
                case "strategy":
                    $("#strategy").show();
                    cid = "60573482-BDDC-445B-8557-3EF264552977";
                    container = "#strategy";
                    height = $("#strategy").css("height");
                    break;
                case "reports":
                    $("#reports").show();
                    cid = "B8C8DD38-0805-4EF4-BFF6-17B835FCA8AA";
                    container = "#reports";
                    height = $("#reports").css("height");
                    break;
                case "lastest":
                    $("#lastest").show();
                    cid = "DEF1B712-29AE-42E5-9A35-A5D163D6F384";
                    container = "#lastest";
                    height = $("#lastest").css("height");
                    break;
            	case "topNews":
            		$("#topNews").show();
            		cid = "C121BC77-2E19-4419-8B47-F4D568A3B34C";
            		container = "#topNews";
            		height = $("#topNews").css("height");
            		break;
            	case "zuixins":
            		$("#zuixins").show();
            		cid = "EE2E7057-881C-46B5-92AC-E9CE5D2E0FF8";
            		container = "#zuixins";
            		height = $("#zuixins").css("height");
            		break;
                default:
                    break;
            }

            height = height.split("px")[0];
            var blankHeight = (height - 120) + "px";
            $(".blank").css("height", blankHeight);

        }
    });
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
</html>