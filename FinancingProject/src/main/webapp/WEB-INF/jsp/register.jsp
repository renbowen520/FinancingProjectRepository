<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
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



<link rel="stylesheet"  href="/FinancingProject/css/bootstrapValidator.css"  >
<link rel="stylesheet"  href="/FinancingProject/css/bootstrap.min.css"  >
  <script type="text/javascript"  src="/FinancingProject/js/bootstrap.min.js"></script>
  <script type="text/javascript"  src="/FinancingProject/js/bootstrapValidator.js"></script>

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




	



<br><br><br>
   <section>
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="page-header">
                        <small><h1>注册</h1></small>
                    </div>
                   <form id="defaultForm" method="post"   class="form-horizontal bv-form"  action="/FinancingProject/LoginController/register"  novalidate="novalidate">
                        <div class="form-group has-feedback has-error">
                            <label class="col-lg-3 control-label">姓名</label>
                            <div class="col-lg-5">
                                <input  value="${member_register.member_name }"      type="text"   id="member_name"      class="form-control" name="member_name" required="" data-bv-trigger="keyup" data-bv-notempty-message="姓名不能为空" placeholder="姓名,需实名注册" data-bv-field="member_name"><i class="form-control-feedback glyphicon glyphicon-remove" data-bv-icon-for="member_name" style="display: block;"></i>
                            <small class="help-block" data-bv-validator="notEmpty" data-bv-for="member_name" data-bv-result="INVALID" style="display: block;">姓名不能为空</small></div>
                        </div>

                        

                        <div class="form-group has-feedback has-success">
                            <label class="col-lg-3 control-label">手机号码</label>
                            <div class="col-lg-5">
                                <input  value="${member_register.mobile_Phone }"          type="text" class="form-control" name="mobile_Phone" data-bv-field="phone"><i class="form-control-feedback glyphicon glyphicon-ok" data-bv-icon-for="mobile_Phone" style="display: block;"></i>
                            <small class="help-block" data-bv-validator="mobile_Phone" data-bv-for="mobile_Phone" data-bv-result="VALID" style="display: none;">输入不是有效的手机号码</small></div>
                        </div>

                        <div class="form-group has-feedback has-error">
                            <label class="col-lg-3 control-label">密码</label>
                            <div class="col-lg-5">
                                <input   value="${member_register.password }"        type="password" class="form-control" name="password" data-bv-field="password"><i class="form-control-feedback glyphicon glyphicon-remove" data-bv-icon-for="password" style="display: block;"></i>
                            <small class="help-block" data-bv-validator="notEmpty" data-bv-for="password" data-bv-result="INVALID" style="display: block;">密码不能位空</small><small class="help-block" data-bv-validator="identical" data-bv-for="password" data-bv-result="VALID" style="display: none;">两次密码不一致</small><small class="help-block" data-bv-validator="different" data-bv-for="password" data-bv-result="VALID" style="display: none;">用户名和密码不能相同</small></div>
                        </div>

                        <div class="form-group has-feedback has-error">
                            <label class="col-lg-3 control-label">确认密码</label>
                            <div class="col-lg-5">
                                <input     value="${member_register.password }"        type="password" class="form-control" name="confirmPassword" data-bv-field="confirmPassword"><i class="form-control-feedback glyphicon glyphicon-remove" data-bv-icon-for="confirmPassword" style="display: block;"></i>
                            <small class="help-block" data-bv-validator="notEmpty" data-bv-for="confirmPassword" data-bv-result="INVALID" style="display: block;">密码不能为空</small><small class="help-block" data-bv-validator="identical" data-bv-for="confirmPassword" data-bv-result="VALID" style="display: none;">两次密码不一致</small><small class="help-block" data-bv-validator="different" data-bv-for="confirmPassword" data-bv-result="VALID" style="display: none;">用户名和密码不能相同</small></div>
                        </div>

                    
                     
					        <div class="form-group has-feedback has-success">
                            <label class="col-lg-3 control-label">理财师邀请码</label>
                            <div class="col-lg-5">
                                <input             type="text" class="form-control" name="ma"   id="ma" placeholder="选填,(填写理财师邀请码会有更多惊喜)" ><i ></i>
                             </div>
                        </div>

                            <div class="form-group has-feedback has-success">
                            <label class="col-lg-3 control-label">QQ号码</label>
                            <div class="col-lg-5">
                                <input    value="${member_register.qqNumber }"     type="text"     id=" qqNumber" name="qqNumber"     class="form-control"  placeholder="选填,(建议填写方便客服联系)" ><i ></i>
                             </div>
                        </div>

                        <div class="form-group has-feedback has-error">
                            <label class="col-lg-3 control-label" id="captchaOperation">16 + 55 =</label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" name="captcha" data-bv-field="captcha"><i class="form-control-feedback glyphicon glyphicon-remove" data-bv-icon-for="captcha" style="display: block;"></i>
                            <small class="help-block" data-bv-validator="callback" data-bv-for="captcha" data-bv-result="INVALID" style="display: block;">答案错误</small></div>
                        </div>

                        <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button   type="submit" class="btn btn-primary" name="signup" value="Sign up" disabled="disabled">注册</button>
                              
                                <button type="button" class="btn btn-info" id="resetBtn">重置</button>
                            <font color="red">   &nbsp;${no_phone }</font>
                            
                            </div>
                            
                        </div>
                    </form>
                </div>
            </section>
            <!-- :form -->
<script type="text/javascript">

/* function fun(){
	alert("ok");
	$("#defaultForm").attr("action","/FinancingProject/LoginController/register");
	$("#defaultForm").submit();
	
} */

$(document).ready(function() {
    // Generate a simple captcha
    function randomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    };
    $('#captchaOperation').html([randomNumber(1, 100), '+', randomNumber(1, 200), '='].join(' '));

    $('#defaultForm').bootstrapValidator({
//        live: 'disabled',
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            member_name: {
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
                    },
                    regexp: {
                        regexp: /^[\u4e00-\u9fa5]+(·[\u4e00-\u9fa5]+)*$/ ,
                        message: '请输入正确的姓名格式'
                    }
                }
            },
            mobile_Phone: {
                 message: 'The phone is not valid',
                 validators: {
                     notEmpty: {
                         message: '手机号码不能为空'
                     },
                     stringLength: {
                         min: 11,
                         max: 11,
                         message: '请输入11位手机号码'
                     },
                     regexp: {
                         regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                         message: '请输入正确的手机号码'
                     }
                 }
             },
            
             qqNumber: {
                 message: 'The phone is not valid',
                 validators: {
                   
                     stringLength: {
                         min: 5,
                         max: 12,
                         message: 'QQ号码格式不正确！'
                     },
                     regexp: {
                         regexp: /^[0-9]{5,12}$/,
                         message: '只能输入数字'
                     }
                 }
             },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                   stringLength:{
				   min:6,
				   max:30,
                      message: '密码长度必须在6到30之间'
				   },
                    identical: {
                        field: 'confirmPassword',
                        message: '两次密码不一致'
                    },
					regexp: {
                         regexp: /^[a-zA-Z0-9_\.]+$/,
                         message: 'The username can only consist of alphabetical, number, dot and underscore'
                     }
                }
            },
            confirmPassword: {
              validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                   stringLength:{
				   min:6,
				   max:30,
                      message: '密码长度必须在6到30之间'
				   },
                    identical: {
                        field: 'password',
                        message: '两次密码不一致'
                    },
					regexp: {
                         regexp: /^[a-zA-Z0-9_\.]+$/,
                         message: 'The username can only consist of alphabetical, number, dot and underscore'
                     }
                }
            },
            captcha: {
                validators: {
                    callback: {
                        message: '答案错误',
                        callback: function(value, validator) {
                            var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
                            return value == sum;
                        }
                    }
                }
            }
        }
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
    	
        $('#defaultForm').bootstrapValidator('validate');
    }); 
    
    $('#resetBtn').click(function() {
        $('#defaultForm').data('bootstrapValidator').resetForm(true);
    });
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