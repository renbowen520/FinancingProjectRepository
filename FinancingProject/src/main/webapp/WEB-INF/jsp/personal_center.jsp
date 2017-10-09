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
  
       <div style="background-color: ; width:100%px; height:40px; margin:0 auto;">
        <iframe src="/FinancingProject/index_files/daohang.jsp" scrolling="no" frameborder="0"  width="100%"></iframe>
    </div>
  <!-- ============================================================= -->  

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
        <li><h2>${member_account.useable_balance }</h2><p>账户可用余额(元)<a href="javascript:;" class="iconfont"><span>账户可用余额 </span></a></p></li>
        <li><h2>${sum }</h2><p>账户总资产(元)<a href="javascript:;" class="iconfont"><span>可用余额+投资金额+累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">${touzi }</h2><p>投资金额(元)<a href="javascript:;" class="iconfont"><span>投资中资金</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">${lixi }</h2><p>累计收益(元)<a href="javascript:;" class="iconfont"><span>累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">${member_account.imuseale_balance}</h2><p>冻结金额(元)<a href="javascript:;" class="iconfont"><span>提现冻结金额</span><i></i></a></p></li>
    </ul>
    <a href="/FinancingProject/MemberController/cz" class="cz">充值</a>
    <a href="#" class="tk"   onclick="javaScript:alert('暂未开放,敬请期待!')" >提款</a>
</div>    <div class="proMain clearfix">
<div class="adminLeft">
    <h2>我的投资</h2>
    
    <ul >
         <li > <a id="" href="/FinancingProject/MemberController/touzi" >投资记录</a></li>
        <li><a id="" href="/FinancingProject/MemberController/lixi"   >收益记录</a></li>
        <li><a id="" href="/FinancingProject/MemberController/chongzhi">充值记录</a></li>
        <li><a id="" href="#"   onclick="javaScript:alert('暂未开放,敬请期待!')">提款记录</a></li>
        <li><a id="" href="#">体验金记录</a></li>
    </ul>
    <h2>我的账户</h2>
    <ul>  
        <li><a id="" href="/FinancingProject/IndexController/personal_center">安全中心</a></li>
        <li><a id="" href="#"    onclick="javaScript:alert('暂未开放,敬请期待!')">我是理财师</a></li>
          <li><a id="" href="/FinancingProject/IndexController/feedback">建议反馈</a></li>
    </ul>
</div>



        <div class="admin-right">
        	<div class="tbConBox">
                <div class="tab">
                    <a class="select" href="">安全中心</a>
                </div>
                <div id="conBox">
                    <div class="box" style="display:block">
							&nbsp;&nbsp;&nbsp;							                         
                         
	                            <table class="safeTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tbody>
                  <tr>
								     <td ><i class="fa fa-credit-card-alt"></i></td>
								     <c:if test="${empty member_bankcards_bk }">
									<td><p style="color:#ff503f">绑卡认证</p></td>
									<td><font color="red">未绑定</font></td>
									<td><p style="color:#888">保障账户安全，完成实名绑卡认证才能充值提款</p></td>
									<td><a href="/FinancingProject/MemberController/bk" class="renzheng">认证</a></td>
									</c:if>
								
									  <c:if test="${!empty member_bankcards_bk }">
									<td><p style="color:#ff503f">绑卡认证</p></td>
									<td><font color="blue">已绑定</font></td>
									<td><p style="color:#888">保障账户安全，完成实名绑卡认证才能充值提款</p></td>
									<td><a href="/FinancingProject/MemberController/bk_ck" class="renzheng">查看</a></td>
									</c:if>
					</tr>
                    <tr>
                           <td ><i class="fa fa-tablet"></i></td>
                            <td><p style="color:#ff503f">绑定手机</p></td>
                            <td>
                             <script type="text/javascript">
                                var s ="  ${member_login.mobile_Phone }";
                              var ss = s.substring(0,9);
                            ss=ss+"****";
                            document.write(ss);
                             </script>
                            </td>
                            <td><p style="color:#888">手机号码是您在孔明理财的重要身份凭证</p></td>
                            <td><font color="blue">绑定完成</font></td>
                  </tr>
                  <tr>
                             <td ><i class="fa fa-gears"></i></td>
                             <td><p style="color:#ff503f">登录密码</p></td>
                            <td><font color="blue">已设置</font></td>
                            <td><p style="color:#888">登录孔明理财网站时需要输入的密码</p></td>
                            <td><a  href="" class="renzheng"     data-toggle="modal"    data-target="#my">修改</a></td>
                  </tr>
                  <tr>
                                <td ><i class="fa fa-hand-pointer-o"></i></td>
 	                            <td><p style="color:#ff503f">提款密码</p></td>
	                        
	                           <c:if test="${empty member_login.withdraw_password  }">
	                            <td>
	                           <font color="red"> 未设置</font>
	                            </td>
	                            <td><p style="color:#888">保障资金安全，提款需要设置提款密码</p></td>
	                            <td><a  href="" class="renzheng"  data-toggle="modal"    data-target="#my2">设置</a></td>								
                              </c:if>
                              
                                 <c:if test="${!empty member_login.withdraw_password   }">
	                             <td>
	                         <font color="blue">   已设置</font>
	                            </td>
	                            <td><p style="color:#888">保障资金安全，提款需要设置提款密码</p></td>
	                            <td><a  href="" class="renzheng"  data-toggle="modal"    data-target="#my3">修改</a></td>								
                              </c:if>
                  </tr>
                </tbody>
                </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!-- ========================================= -->
   <form  name="f66"  id="f66"    action="/FinancingProject/MemberController/up_withdraw_password"  method="post">
<!--  div层-->
<div class="modal fade" id="my3" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 修改提款密码 <small>Update Personal Pin</small>  </h4>
         </div>
         
         <div class="modal-body">
     <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">原密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd111"  name="pwd111"
               placeholder="请输入原密码"          required="required"> 
               </div>
          </div>
    &nbsp;
   <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">新密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd222"  name="pwd222"
               placeholder="请输入新密码"          required="required"> 
               </div>
          </div>
         &nbsp;   
          <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">确认密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd333"  name="pwd333"
                 placeholder="请输入确认密码"          required="required"> 
               </div>
          </div>
             
        </div>
        <br>
         <div class="modal-footer">
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
           <button type="reset"       id="but44" class="btn btn-danger">重置</button> 
            <button  type="submit" class="btn btn-primary"  >
               提交</button>
         </div>   
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
</form>  


<!-- =========================================== -->
    <form  name="f88"  id="f88"    action="/FinancingProject/MemberController/up_pwd"  method="post">
<!--  div层-->
<div class="modal fade" id="my" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 修改密码 <small>update password</small>  </h4>
         </div>
         
         <div class="modal-body">
     <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">原密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd"  name="pwd"
               placeholder="请输入原密码"          required="required"> 
               </div>
          </div>
    &nbsp;
   <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">新密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd2"  name="pwd2"
               placeholder="请输入新密码"          required="required"> 
               </div>
          </div>
         &nbsp;   
          <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">确认密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd3"  name="pwd3"
                 placeholder="请输入确认密码"          required="required"> 
               </div>
          </div>
             
        </div>
        <br>
         <div class="modal-footer">
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
           <button type="reset"       id="but22" class="btn btn-danger">重置</button> 
            <button  type="submit" class="btn btn-primary"  >
               提交</button>
         </div>   
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
</form>   
<!--========================================  -->
   <form  name="f777"  id="f777"    action="/FinancingProject/MemberController/withdraw_password"  method="post">
<!--  div层-->
<div class="modal fade" id="my2" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 设置提款密码 <small>Personal Pin </small>  </h4>
         </div>
         
         <div class="modal-body">
   <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd7"  name="pwd7"
               placeholder="请输入提款密码"          required="required"> 
               </div>
          </div>
         &nbsp;   
          <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">确认密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd8"  name="pwd8"
                 placeholder="请确认提款密码"          required="required"> 
               </div>
          </div>   
        </div>
        <br>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
           <button type="reset"       id="but33" class="btn btn-danger">重置</button> 
            <button  type="submit" class="btn btn-primary"  >
               提交</button>
         </div>   
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
</form>   




<script type="text/javascript">

$("#but22").click(function(){   //重置按钮 f2
    $('#f88').data('bootstrapValidator').resetForm(true);
	});
$("#but33").click(function(){   //重置按钮 f2
    $('#f777').data('bootstrapValidator').resetForm(true);
	});

$("#but44").click(function(){   //重置按钮 f2
    $('#f66').data('bootstrapValidator').resetForm(true);
	});



$('#f66').bootstrapValidator({
       message: 'This value is not valid',
       feedbackIcons: {
           valid: 'glyphicon glyphicon-ok',
           invalid: 'glyphicon glyphicon-remove',
           validating: 'glyphicon glyphicon-refresh'
       },
       fields: {
     	    pwd111: {
        validators: {
            notEmpty: {
                message: '密码不能为空'
            },
           stringLength:{
			   min:6,
			   max:30,
              message: '密码长度必须在6到30之间'
			   },
				regexp: {
                 regexp: /^[a-zA-Z0-9_\.]+$/,
                 message: 'The username can only consist of alphabetical, number, dot and underscore'
             },
             threshold :6,
             remote: {
                 	  url: '/FinancingProject/MemberController/pwd2',//验证地址
                       message: '原密码输入错误!',//提示消息
                       delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                       type: 'POST'//请求方式
                   }
        }
    }, 
         pwd222: {
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
                       field: 'pwd333',
                       message: '两次密码不一致'
                   },
					 regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'The username can only consist of alphabetical, number, dot and underscore'
                    }
               }
           },
           pwd333: {
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
	                          field: 'pwd222',
	                          message: '两次密码不一致'
	                      },
	  					regexp: {
	                           regexp: /^[a-zA-Z0-9_\.]+$/,
	                           message: 'The username can only consist of alphabetical, number, dot and underscore'
	                       }
	                  }
	              }
       }//验证
   });//-------------------











$(function(){
	 $('#f777').bootstrapValidator({
         message: 'This value is not valid',
         feedbackIcons: {
             valid: 'glyphicon glyphicon-ok',
             invalid: 'glyphicon glyphicon-remove',
             validating: 'glyphicon glyphicon-refresh'
         },
         fields: {
  
           pwd7: {
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
                         field: 'pwd8',
                         message: '两次密码不一致'
                     },
 					 regexp: {
                          regexp: /^[a-zA-Z0-9_\.]+$/,
                          message: 'The username can only consist of alphabetical, number, dot and underscore'
                      }
                 }
             },
             pwd8: {
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
	                          field: 'pwd7',
	                          message: '两次密码不一致'
	                      },
	  					regexp: {
	                           regexp: /^[a-zA-Z0-9_\.]+$/,
	                           message: 'The username can only consist of alphabetical, number, dot and underscore'
	                       }
	                  }
	              }
         }//验证
     });//-------------------
	
	
	
	   $('#f88').bootstrapValidator({
	          message: 'This value is not valid',
	          feedbackIcons: {
	              valid: 'glyphicon glyphicon-ok',
	              invalid: 'glyphicon glyphicon-remove',
	              validating: 'glyphicon glyphicon-refresh'
	          },
	          fields: {
	        	    pwd: {
               validators: {
                   notEmpty: {
                       message: '密码不能为空'
                   },
                  stringLength:{
				   min:6,
				   max:30,
                     message: '密码长度必须在6到30之间'
				   },
					regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'The username can only consist of alphabetical, number, dot and underscore'
                    },
                    threshold :6,
                    remote: {
	                    	  url: '/FinancingProject/MemberController/pwd',//验证地址
	                          message: '原密码输入错误!',//提示消息
	                          delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
	                          type: 'POST'//请求方式
	                      }
               }
           }, 
	            pwd2: {
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
	                          field: 'pwd3',
	                          message: '两次密码不一致'
	                      },
	  					 regexp: {
	                           regexp: /^[a-zA-Z0-9_\.]+$/,
	                           message: 'The username can only consist of alphabetical, number, dot and underscore'
	                       }
	                  }
	              },
	              pwd3: {
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
		                          field: 'pwd2',
		                          message: '两次密码不一致'
		                      },
		  					regexp: {
		                           regexp: /^[a-zA-Z0-9_\.]+$/,
		                           message: 'The username can only consist of alphabetical, number, dot and underscore'
		                       }
		                  }
		              }
	          }//验证
	      });//-------------------
});







</script>
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