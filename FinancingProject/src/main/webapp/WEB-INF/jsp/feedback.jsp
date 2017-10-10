<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>意见反馈</title>
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




</head>
<body>
<!--   1  导入顶部  -->
     <div style=" width:1002px; height:94px; margin:0 auto;">
        <iframe src="/FinancingProject/index_files/iframetop.jsp" scrolling="no" frameborder="0" width="1002" height="94"></iframe>
    </div>
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
        <li><h2>${member_account.useable_balance }</h2><p>账户可用余额(元)<a href="javascript:;" class="iconfont"><span>账户可用余额 </span></a></p></li>
        <li><h2>${sum }</h2><p>账户总资产(元)<a href="javascript:;" class="iconfont"><span>可用余额+投资金额+累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">${member_account.imuseale_balance }</h2><p>投资金额(元)<a href="javascript:;" class="iconfont"><span>投资中资金</span><i></i></a></p></li>
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
                    <a class="select" href="">建议反馈</a>
                 </div>
                <div id="conBox">
          
                                 <form  id="f1" name="f1"  method="post"   action="">
               
                           <center> 
                <table width="90%" border="0">
                            <tr>
                          <td height="100px"  width="150px;" align="right"> <b> 标题:&nbsp;</b></td>
                                 <td width="350px;">
                                    <input   style="width: 350px;"   type="text" class="form-control" id="title"  name="title"
                 placeholder="请输入标题"          required="required">
                              </td>
                              <td><div id="s1"   style="color: red"></div></td>
                       </tr> 
                        <tr>
                          <td align="right"  style="vertical-align: text-top;"><b>内容:&nbsp;</b></td>
                          <td>
                        <textarea style="width: 350px;height: 200px"      required="required"   id="content"  name="content"      placeholder="请输入内容"  ></textarea>
                          
                          </td>
                    
                            <td><div id="s2"    style="color: red"></div></td>
                        </tr>
                     
                     </table>
               
                  
         
	     
	     
	             <br><br>
          <button  id="ok" type="button" class="btn btn-primary"  >提交</button>
           &nbsp;     &nbsp;          
  <button type="button" class="btn btn-default"  onclick="javascript:history.back(-1);">返回</button>
              </center>
        
          <br>
          
            </form>
            </div>
        </div>
    </div>
    
    
 <script type="text/javascript">
$("#ok").click(function(){
	var  title = $("#title").val();
	var  content = $("#content").val();
	//alert(title);
	//alert(content);

	if(title.length<1){
		$("#s1").text("标题不能为空!");
		return ;
	}
	
	if(title.length<2||title.length>30){
		$("#s1").text("标题长度2-30个字符!");
		return ;
	}
	
	if(content.length<1){
		$("#s2").text("内容不能为空!");
		return ;
	}
	
	if(content.length<2||content.length>1000){
		$("#s2").text("内容长度2-1000个字符!");
		return ;
	}
	$("#s1").text("");
	$("#s2").text("");
	
	$("#f1").attr("action","/FinancingProject/MemberController/yj");
	$("#f1").submit();
});
 
/* $(function(){
	
	   $('#f1').bootstrapValidator({
	          message: 'This value is not valid',
	          feedbackIcons: {
	              valid: 'glyphicon glyphicon-ok',
	              invalid: 'glyphicon glyphicon-remove',
	              validating: 'glyphicon glyphicon-refresh'
	          },
	          fields: {
	        	    title: {
              validators: {
              notEmpty: {
                  message: '标题不能为空'
              },
             stringLength:{
				   min:2,
				   max:30,
                message: '标题长度必须在2-30个字符之间'
				   }
             }
       },
	            content: {
	                validators: {
	                          notEmpty: {
	                          message: '内容不能为空'
	                       },
	                    stringLength:{
	  				          min:2,
	  				          max:1000,
	                          message: '内容长度必须在2-1000个字符之间'
	  				     }
	                  }
	         } 
	            
	          }//验证
	      });//-------------------

}); */

</script>
</body>
</html>