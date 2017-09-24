<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
 <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.config.js"></script>
 <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.all.js"> </script>
 <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/lang/zh-cn/zh-cn.js"></script>


<link rel="stylesheet"  href="/FinancingProject/css/bootstrapValidator.css"  >
<script type="text/javascript"  src="/FinancingProject/js/bootstrapValidator.js"></script>

</head>
<body>
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>修改密码</b>
</h3>
<hr>
<center>
<br>

<div style="width: 50%">
  <form  name="f88"  id="f88"    action=""  method="post">
     <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">原密码:</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd"  name="pwd"
               placeholder="请输入原密码"          required="required"> 
               </div>
          </div>
    &nbsp;
   <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">新密码:</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd2"  name="pwd2"
               placeholder="请输入新密码"          required="required"> 
               </div>
          </div>
         &nbsp;   
          <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">确认密码:</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="pwd3"  name="pwd3"
                 placeholder="请输入确认密码"          required="required"> 
               </div>
          </div>   
           &nbsp; 
           <div class="form-group">
               <div class="col-sm-10">
                 <button     id="ok"  type="button" class="btn btn-primary" >提交</button>
               </div>
          </div>   
          
</form>   
</div>
</center>


<!--  新增的div层-->
<div class="modal fade" id="my" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> <b>消息提示</b>  </h4>
         </div>
         
         <div class="modal-body">
          
        <font    size="+1" color="blue"> <b>密码修改成功!</b></font>
     
     </div>
         
         <div class="modal-footer">
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
        
         </div>   
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 




<script type="text/javascript">
   $("#ok").click(function(){
	      //验证成功后异步请求
	       $('#f88').data('bootstrapValidator').validate();
	     var pwd=$("#pwd2").val();
	      $.post("/FinancingProject/UsersController/up_admin_pwd",{pwd:pwd},
      		    function(msg){
      		    	    if(msg){
      		    	    	//返回true
      		    	    	   $('#my').modal('show'); //显示
      		    	    }else{
      		    	    	  alert("修改密码失败!");
      		    	    }
      		    }); 
      		    
      		
   });


   $(function(){
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
	                    	  url: '/FinancingProject/UsersController/pwd',//验证地址
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
	      });
 
   });

</script>
</body>
</html>