<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
<meta name="Keywords" content="孔明理财，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="孔明理财——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">


<title>孔明理财</title>
	<link href="/FinancingProject/images/timg.jpg" type="image/x-icon" rel="shortcut icon">
	<script src="/FinancingProject/index_files/hm.js"></script>
	<script src="/FinancingProject/index_files/hm(1).js"></script>
	<link href="/FinancingProject/index_files/common" rel="stylesheet">
	<link href="/FinancingProject/index_files/jw.less" rel="stylesheet">
	<script src="/FinancingProject/index_files/jquery"></script>
	<script src="/FinancingProject/index_files/bootstrap"></script>
<script src="/FinancingProject/index_files/video.js"></script>
   <script src="/FinancingProject/index_files/echarts.js"></script>
    <link rel="stylesheet" href="/FinancingProject/index_files/layer.css" id="layui_layer_skinlayercss">
<link href="/FinancingProject/index_files/jw.css" rel="stylesheet">
<link href="/FinancingProject/index_files/iconfont.css" rel="stylesheet" type="text/css">
<link href="/FinancingProject/index_files/common.css" rel="stylesheet">

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

	
    <div style=" width:1002px; height:94px; margin:0 auto;">
        <iframe src="/FinancingProject/index_files/iframetop.jsp" scrolling="no" frameborder="0" width="1002" height="94"></iframe>
    </div>
    
    
        <div style="background-color: ; width:100%px; height:40px; margin:0 auto;">
        <iframe src="/FinancingProject/index_files/daohang.jsp" scrolling="no" frameborder="0"  width="100%"></iframe>
    </div>
    
 
 
	<div class="main">
<div class="indexBanner">
<div id="homebanner" class="carousel slide" data-ride="carousel">




   <div class="carousel-inner" role="listbox">
                <div class=" item active">
                    <img src="/FinancingProject/index_files/lc.jpg" alt="[]">
                </div>
    </div> 

    
    
    <!--登陆 注册 div    -->
    <c:if test="${empty  member_login}">
</div>
    <div class="login-box">
        <div class="block backdrop"></div>
        <div class="block" style=" height:280px;">
            <p style="margin-top:20px; line-height:50px; font-size:20px; text-align:center; color:#fff;"><span style="color:#917739;">欢迎</span>盈主到来</p>
            <p style="margin-bottom:15px; line-height:50px; font-size:20px; text-align:center; color:#fff;">现在开始<span style="color:#917739;">您的财富</span> 之旅吧</p>
            <a style="float:none; margin:0 auto; margin-left:15px;    display: inline-block;margin-bottom: 10px;" href="/FinancingProject/IndexController/login"><img src="/FinancingProject/index_files/ying_index_login_btn.png"></a>
            <a style="float:none; margin:0 auto; margin-left:15px; margin-top:10px;" href="/FinancingProject/IndexController/register"><img src="/FinancingProject/index_files/ying_index_reg_btn.png"></a>
        </div>
    </div>
</div>
</c:if>

 <div class="container index"  > 
    <div class="row">
   
        <!-- -----------------公告------------------------------------------- -->
<table width="100%"  border="0"  style="background-color: #F5F5F5" >
   <tr height="30px">
     <td  width="20%" align="center"> <i class="fa fa-volume-up fa-2"></i>&nbsp;最新公告</td>
     <td>
     <div class="swiper_wrap">
		<ul class="font_inner" style="height: 120px; top: -60px;">
		<c:forEach items="${push_notice }" var="s">
		  <li>
		  <a href="">${s.title }</a>
		  </li>
		 
		</c:forEach>

			
			</ul>
			
		<a href="javascript:void(0)" class="lt">&lt;</a>
		<a href="javascript:void(0)" class="gt">&gt;</a>
	</div>
     
     
     
     </td>
     <td  width="15%"   class="aaa"> 
        <a href="/FinancingProject/IndexController/news"  >
       查看更多 &gt;&gt;
       </a>
      </td>
   </tr>
</table>



    

	<style type="text/css">
		div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,blockquote,p{padding:0; margin:0;}
		ol,ul {list-style:none;}
		li{list-style-type:none;}
	
		h1,h2,h3,h4,h5,h6{font-size:inherit; font-weight:normal;}
		address,cite,code,em,th,i{font-weight:normal; font-style:normal;}
		.clearfix{*zoom:1;}
		.clearfix:after{display:block; overflow:hidden; clear:both; height:0; visibility:hidden; content:"";}
		a:link,a:visited
		{
			color:#000;
			text-decoration: none;
		}
		input
		{
			outline: 0;
		}

		 .swiper_wrap{
			position: relative;
			width: 695px;
			height: 30px;
			margin: 0 auto;
			overflow: hidden;
		}
		.swiper_wrap  ul{
			position: relative;
			top: 0;
			left: 0;
			width: 695px;
			float: right;
		  	color: #444;
		 	font-size: 14px;
		 	margin-top: 1px;
		}
		.swiper_wrap	 ul li{
			line-height: 30px;
			padding-left: 24px;
		}
		 .lt{
			position: absolute;
			left: -1px;
			top: 7px;
			font-family: "宋体";
			font-weight: bold;
			color: #AAAAAA;
		}
		 .gt{
			position: absolute;
			right: 26px;
			top: 7px;
			font-family: "宋体";
			font-weight: bold;
			color: #AAAAAA;
		}
		 .swiper_wrap .font_inner a{
			color: #444;
		}
				 .swiper_wrap  a:hover{
			color: #FA9101;
	}
		
		
		 .aaa  a:hover{
			color: #FA9101;
	}
	</style>



     
	  <script type="text/javascript">
		$(function(){
			//1文字轮播(2-5页中间)开始



		$(".font_inner li:eq(0)").clone(true).appendTo($(".font_inner"));//克隆第一个放到最后(实现无缝滚动)
		var liHeight = $(".swiper_wrap").height();//一个li的高度
		//获取li的总高度再减去一个li的高度(再减一个Li是因为克隆了多出了一个Li的高度)
		var totalHeight = ($(".font_inner li").length *  $(".font_inner li").eq(0).height()) -liHeight;
		$(".font_inner").height(totalHeight);//给ul赋值高度
		var index = 0;
		var autoTimer = 0;//全局变量目的实现左右点击同步
		var clickEndFlag = true; //设置每张走完才能再点击

		function tab(){
			$(".font_inner").stop().animate({
				top: -index * liHeight
			},400,function(){
				clickEndFlag = true;//图片走完才会true
				if(index == $(".font_inner li").length -1) {
					$(".font_inner").css({top:0});
					index = 0;
				}
			})
		}

		function next() {
			index++;
			if(index > $(".font_inner li").length - 1) {//判断index为最后一个Li时index为0
				index = 0;
			}
			tab();
		}
		function prev() {
			index--;
			if(index < 0) {
				index = $(".font_inner li").size() - 2;//因为index的0 == 第一个Li，减二是因为一开始就克隆了一个LI在尾部也就是多出了一个Li，减二也就是_index = Li的长度减二
				$(".font_inner").css("top",- ($(".font_inner li").size() -1) * liHeight);//当_index为-1时执行这条，也就是走到li的最后一个
			}
			tab();
		}
		//切换到下一张
		$(".swiper_wrap .gt").on("click",function() {
			if(clickEndFlag) {
				next();
				clickEndFlag = false;
			}
		});
		//切换到上一张
		$(".swiper_wrap .lt").on("click",function() {
			if(clickEndFlag) {
				prev();
				clickEndFlag = false;
			}
		});
		//自动轮播
		autoTimer = setInterval(next,3000);
		$(".font_inner a").hover(function(){
			clearInterval(autoTimer);
		},function() {
			autoTimer = setInterval(next,3000);
		})

		//鼠标放到左右方向时关闭定时器
		$(".swiper_wrap .lt,.swiper_wrap .gt").hover(function(){
			clearInterval(autoTimer);
		},function(){
			autoTimer = setInterval(next,3000);
		})
		//1文字轮播(2-5页中间)结束
		})
		</script>
  
   
         <div class="gjList clearfix"  >
      <c:forEach items="${subject }"   var="s">
        	<ul>
                    <li >
                     
                            <h2 class="tit"><span>固</span>${s.name }</h2>
                            <span class="fenl">
                            <c:if test="${s.type==0 }">固收</c:if>
                             <c:if test="${s.type==1 }">车贷</c:if>
                             <c:if test="${s.type==2 }">房贷</c:if>
                            </span>
                            <div class="count">
                                <span class="s1"><b> ${ s.year_rate}</b>%</span>
                                <span class="s2"><b>${s.bought}</b>人</span>
                                <span class="s3">年化收益</span>
                                <span class="s4">已购人数</span>
                                <span class="s5">/</span>
                            </div>
                            <p class="safe">
                                起购金额：￥${s.floor_amount }<br>
                            </p>
                            <p class="txt" style="height: 72px;">
								管理人：襄阳孔明投资管理有限公司
                            </p>
                          
                          
                            <p class="abox">
                            <a    href="/FinancingProject/IndexController/buyproduct?id=${s.id }">
                            <span class="abtn">
                          立即购买
                            </span>
                            </a>
                            </p>
                    
                    </li>
            </ul>
     </c:forEach> 
        </div>
      
      
      
        <div class=" download apply">
            <div class="title">
                <img src="/FinancingProject/index_files/applyLeft.png">合作商风采<img src="/FinancingProject/index_files/applyRight.png">
            </div>
            <div id="introMarquee">
                <div id="marqueeContainer">
                    <ul id="articleImgs" class="unstyled" style="  background-color: #917739;padding-top: 10px;">
                        <li>
                            <img src="/FinancingProject/index_files/hezuo1.jpg" name="hezuo1Big.jpg">
                        </li>
                        <li>
                            <img src="/FinancingProject/index_files/hezuo2.jpg" name="hezuo2Big.jpg">
                        </li>
                        <li>
                            <img src="/FinancingProject/index_files/hezuo3.jpg" name="hezuo3Big.jpg">
                        </li>
                        <li>
                            <img src="/FinancingProject/index_files/hezuo4.jpg" name="hezuo4Big.jpg">
                        </li>
                        <li>
                            <img src="/FinancingProject/index_files/hezuo5.jpg" name="hezuo5Big.jpg">
                        </li>
                        <li>
                            <img src="/FinancingProject/index_files/hezuo6.jpg" name="hezuo6Big.jpg">
                        </li>
                    </ul>
                    
                   <ul id="articleImgs2" class="unstyled" style="background-color: #917739; padding-top: 10px;margin-left: -5px;">
                          <li>
                            <img src="/FinancingProject/index_files/hezuo1.jpg" name="hezuo1Big.jpg">
                        </li>
                        <li>
                            <img src="/FinancingProject/index_files/hezuo2.jpg" name="hezuo2Big.jpg">
                        </li>
                        <li>
                            <img src="/FinancingProject/index_files/hezuo3.jpg" name="hezuo3Big.jpg">
                        </li>
                        <li>
                            <img src="/FinancingProject/index_files/hezuo4.jpg" name="hezuo4Big.jpg">
                        </li>
                        <li>
                            <img src="/FinancingProject/index_files/hezuo5.jpg" name="hezuo5Big.jpg">
                        </li>
                        <li>
                            <img src="/FinancingProject/index_files/hezuo6.jpg" name="hezuo6Big.jpg">
                        </li>
                    </ul> 
                </div>
            </div>
        </div>

    </div>
</div>


<div class="modal fade myModal" id="bigImg" role="dialog">
    <div class="modal-dialog modal-sm" style="width: 1200px;">
        <div class="modal-content">
            <div class="modal-header" style="padding-top:10px;padding-bottom:10px;">
                <span>合作商风采</span>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
            </div>
            <div class="modal-body" style="text-align: center;">
                <img id="theBigImg" src="">
            </div>
        </div>
    </div>
</div>


            <script src="/FinancingProject/index_files/knockout-3.2.0.js"></script>
            <script>


   (function () {
        var raf = window.requestAnimationFrame || function _raf(f) { return setTimeout(f, 16.6); }
        var caf = window.cancelAnimationFrame || function _caf(f) { return clearTimeout(f); }
        var tick = function () {
            var ticks = {};
            var _tick = function _tick(name, newTick) {
                if (!ticks[name] || !newTick) {
                    ticks[name] = newTick;
                }
                lastTick = ticks[name];
                ticks[name] = newTick;
                return newTick - lastTick;
            };
            return _tick;
        }();

        var speed = 33.333333;
        var tab = document.getElementById("introMarquee");
        var tab1 = document.getElementById("articleImgs");
        var tab2 = document.getElementById("articleImgs2");
        tab2.innerHTML = tab1.innerHTML;
     /*    $("#articleImgs2 img").click(function () {
            var bigImg = $(this).attr("name");
            var url = "/Content/images/jw/" + bigImg;
            $("#bigImg #theBigImg").attr("src", url);
            $("#bigImg").modal();
        }); */
        var offsetWidth1 = tab1.offsetWidth;
        var offsetLeft2 = tab2.offsetLeft;
        var scrollLeft = 0;
        var MyMar;
        function Marquee(time) {
            t = tick("introMarquee", time || new Date());
            MyMar = raf(Marquee);

            if (scrollLeft >= offsetLeft2) {
                scrollLeft = scrollLeft % offsetLeft2;
            }
            scrollLeft += (1 / speed) * t;
            tab.scrollLeft = scrollLeft;
        }
        var MyMar = raf(Marquee, speed);
        tab.onmouseover = function () { caf(MyMar); tick("introMarquee", null); };
        tab.onmouseout = function () { MyMar = raf(Marquee, speed); };
        var currentLeft = 0;
        
    })(); 


</script>
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

    <style type="text/css">
        .hzhb_box {float:left;  width:610px; margin-top:32px;}
        .hzhb_item {float:left;margin:5px;  border: solid 1px #aaa;border-radius:3px;}
        .hzhb_item img { width:120px; height:40px;}

        
        .ft_item{ float: left; width: 239px; }
        .ft_item_tit{ height: 28px; line-height: 28px; font-size: 20px; color: #ccc;padding-left:40px;}
        .ft_links_list{ margin-top: 10px;}
        .ft_links_list .ft_link{ height: 30px; line-height: 30px;}
        .ft_item_sns{ float:right;width: 340px;}
        .ft_sns_list{ margin-left:40px;}
        .ft_sns_list li{ float: left; width: 74px; margin: 5px;}
        .ft_sns_list a{ display: block; width: 74px;}
        .ft_sns_list .txt{ display: block; line-height: 32px; text-align: center; color:#ccc;}
        .ft_sns_list .ico_sns{ display: block; width: 62px; height: 62px; margin: 0 auto; background: url(/images/ft_sns.png) no-repeat;}
        .ft_sns_list .ico_weixin{ background-position: 0 0;}
        .ft_sns_list .ico_sinawb{ background-position: -63px 0;}
        .ft_sns_list .ico_txwb{ background-position: -126px 0;}
        .ft_sns_list a:hover .ico_sinawb{ background-position: -63px -63px;}
        .ft_sns_list a:hover .ico_txwb{ background-position: -126px -63px;}
        .ft_sns_list a:hover .txt{color:#3D9FE1}
        .ft_sns_list .wx_tips{ cursor: pointer; position: relative;}
        .ft_sns_list .wx_tips .tips_hd{}
        .ft_sns_list .wx_tips .tips_bd{ display: none; position: absolute; left: 90px; top: -10px;}
        .ft_sns_list .wx_tips .tips_bd .arrow{ width: 0; height: 0; overflow: hidden; border-color:transparent #fff transparent transparent;border-width:8px 8px 8px 8px;border-style:dashed solid dashed none; position: absolute; top: : -8px;}
        .ft_sns_list .wx_tips .tips_bd img{ width: 180px; height: 180px;}
        .ft_sns_list .wx_tips .tips_bd .txt{ font-size: 14px; line-height: 32px;  color: #3D9FE1;}
        .ft_sns_list .wx_tips:hover .ico_weixin{ background-position: 0 -63px;}
        .ft_sns_list .wx_tips:hover .txt{ color: #3D9FE1;}
        .ft_sns_list .wx_tips:hover .tips_bd{ display: block;}

    </style>

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
    <div class="foot3">
		<div class="container">
			<div class="row">
				Copyright © 2017  All Rights Reserverd 襄阳孔明投资管理有限公司 版权所有<br>
			</div>
		</div>
	</div>


	<script>
		$("#aFloatTools_Show").click(function () {
			$('#divFloatToolsView').animate({ width: 'show', opacity: 'show' }, 100, function () { $('#divFloatToolsView').show(); });
			$('#aFloatTools_Show').hide();
			$('#aFloatTools_Hide').show();
		});
		$("#aFloatTools_Hide").click(function () {
			$('#divFloatToolsView').animate({ width: 'hide', opacity: 'hide' }, 100, function () { $('#divFloatToolsView').hide(); });
			$('#aFloatTools_Show').show();
			$('#aFloatTools_Hide').hide();
		});
		$('*[data-toggle="tooltip"]').tooltip();
		$(document).ready(function () {
			var href = window.location.href.toLowerCase();

			if (href.indexOf("/account/") >= 0) {
				$(".topNav li:eq(7)").addClass("active");

			} else if (href.indexOf("/home/help") >= 0) {

				$(".topNav li:eq(5)").addClass("active");

			} else if (href.indexOf("/home/kcenter") >= 0) {

				$(".topNav li:eq(1)").addClass("active");

			} else if (href.indexOf("/home/newscenter") >= 0 || href.indexOf("/news/") >= 0) {

				$(".topNav li:eq(3)").addClass("active");

			} else if (href.indexOf("/home/rule") >= 0) {

				$(".topNav li:eq(3)").addClass("active");

			} else if (href.indexOf("/tradingsoftware") >= 0) {

				$(".topNav li:eq(6)").addClass("active");

			} else if (href.indexOf("/gzpeizi") >= 0) {

				$(".topNav li:eq(2)").addClass("active");

			}
			else if (href.indexOf("jiameng") >= 0) {

				$(".topNav li:eq(4)").addClass("active");

			} else {

				$(".topNav li:eq(0)").addClass("active");
			}


		});

		var kefu = function (num) {
			var url = "";
			switch (num) {
				case 1:
					url = "tencent://message/?uin=3044901756&Menu=yes";
					break;
				case 2:
					url = "tencent://message/?uin=773031422&Menu=yes";
					break;
				default:
					url = "tencent://message/?uin=2093717869&Menu=yes";
			}
			window.open(url, '在线客服', 'height=405,width=500,top=200,left=200,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
		}


		var gotoTop = function () {
			$("html,body").animate({ scrollTop: 0 }, 1000);
		}

	</script>
</body>
</html>