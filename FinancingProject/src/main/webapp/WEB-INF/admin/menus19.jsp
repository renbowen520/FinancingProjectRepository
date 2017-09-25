<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
         <%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号管理</title>
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
<b>账号管理</b>
</h3>
<hr>

<center>
<form  name="f1"  id="f1"    class="form-horizontal" role="form"  action=""  method="post">    
<table  width="90%" >
<tr>
  <td >
  <label for="firstname" class="col-sm-2 control-label">姓名</label >
              <input type="text" class="form-control" id="users_q1"  name="users_q1" 
        value="${users_q1 }"        placeholder="请输入姓名"   style="width: 200px">
  </td>
 <td >
 <label for="firstname" class="col-sm-3 control-label">手机号码</label >
               <input type="number" class="form-control"   id="users_q2"  name="users_q2"
               value="${users_q2 }"     style="width: 200px">
 </td>
  <td>
       <button type="button" class="btn btn-primary"  name="se"  id="se"  >
          查询
       </button>
 </td>
 <td>
         <button id="reset"      type="button" class="btn btn-danger"   >  重置 </button>
 </td>
  <td align="right" width="10%">
      <button   id="add1"   type="button" class="btn btn-primary" "
        data-toggle="modal"     >
           新增
          </button>
 </td>
</tr>
</table>
</form>
</center>



<center>
<br>
<div   style="width: 95%">
 <table class="table table-striped  table-hover" >
       <tr>
        <th>序号</th>
         <th>用户名</th>
        <th>角色</th>
        <th>手机号</th>
          <th>状态</th>
         <th>创建时间</th>
         <th>更新时间</th>
          <th>操作</th>
       </tr>
       
       <c:forEach  items="${users_list }" var="s"   varStatus="va">
           <tr>
                 <td>${va.index+1 }</td>
                 <td>${s.user_name}</td>
                 <td>${s.user_role.cname }</td>
                  <td>${s.mobile_Phone }</td>
                  <td>
                  <c:if test="${s.status==0 }">
                <font color="blue">   正常</font>
                  </c:if>
                    <c:if test="${s.status==1 }">
                 已锁定
                  </c:if>
                     <c:if test="${s.status==2 }">
                <font color="red"> 已删除</font>
                  </c:if>
                  </td>
                  <td>${s.create_date }</td>
                   <td>${s.update_date }</td>
                  <td>
                  <button type="button" class="btn btn-primary"     data-toggle="modal"       onclick="fun2(${s.id})"  >
                   编辑查看
                  </button>
                   &nbsp; &nbsp;   
                        <c:if test="${s.id == admin_login.id ||s.status == 2}">
                           <button disabled="disabled"    type="button" class="btn btn-danger"  data-toggle="modal"   onclick="fun(${s.id})"  >
                            删除
                           </button>
                       </c:if>
                        <c:if test="${s.id != admin_login.id }">
                                   <c:if test="${s.status == 0 ||s.status==1 }">
                                  <button  id="de2"  type="button" class="btn btn-danger"  data-toggle="modal"   onclick="fun(${s.id})"  >
                                   删除
                                  </button>
                                   </c:if>
                       </c:if>
                  
               
             
               
                  
                
                  
                  </td>
          </tr>
        </c:forEach>
 </table>
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
            <h4 class="modal-title" id="myModalLabel"> 新增 账号  </h4>
         </div>
         
       <form  action="/FinancingProject/UsersController/add_users"     name="f2"  id="f2"    class="form-horizontal" role="form"    method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">用户名</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="a1"  name="a1"
                 placeholder="请输入用户名" required="required">
               </div>
          </div>

   
    <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="a2"  name="a2"
                 required="required"> 
               </div>
          </div>
   
       <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">确认密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="a3"  name="a3"
                 required="required"> 
               </div>
          </div>
     
        <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">手机号</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="a4"  name="a4"
                 required="required"> 
               </div>
          </div>
     
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">角色</label>
               <div class="col-sm-10">
                <select id="a5"   name="a5" class="form-control" >
                          
                </select>
               </div>
          </div>
     
   </div>
         
         <div class="modal-footer">
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
              <button type="button"       id="but2" class="btn btn-danger">重置</button> 
            <button  type="submit" class="btn btn-primary"  >
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 



<!--  div层-->
<div class="modal fade" id="my2" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h3 class="modal-title" id="myModalLabel">
           <font color="red">  警告</font>  
             </h3>
         </div>
         
         <div class="modal-body">
         确定删除该用户?
          <form  name="f3"  id="f3"    class="form-horizontal" role="form"    method="post">    
            <input  name="delete_id"   type="hidden"  id="delete_id">
            </form>  
        </div>
         <div class="modal-footer">
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
            <button  id="delete"   type="button" class="btn btn-primary"  >
               确定</button>
         </div>
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 



<!--  编辑的div层-->
<div class="modal fade" id="my4" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 编辑 账号  </h4>
         </div>
         
       <form  action="/FinancingProject/UsersController/up_users"     name="f4"  id="f4"    class="form-horizontal" role="form"    method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">用户名</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="user_name"  name="user_name"
                 placeholder="请输入用户名" required="required">
             <input type="hidden"  id="id" name="id" >
               </div>
          </div>

   
    <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">密码</label>
               <div class="col-sm-10">
               <input type="password" class="form-control" id="password"  name="password"
              > 
               <font color="red">  不填写则不修改原来的密码</font> 
               </div>
           
          </div>
   

     
        <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">手机号</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="mobile_Phone"  name="mobile_Phone"
               readonly="readonly"> 
               </div>
          </div>
     
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">角色</label>
               <div class="col-sm-10">
                <select id="role_id"   name="role_id" class="form-control" >
                </select>
               </div>
          </div>
     
           <div  id="yyy" class="form-group"  style="display:none;">
           <label for="firstname" class="col-sm-2 control-label">重新启用</label>
               <div class="col-sm-10">
                 <input disabled="disabled"   type="checkbox"  name="zd" id="zd"  value="0" checked="checked" >
               </div>
               
          </div>
     
   </div>
         
         <div class="modal-footer">
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
<!--               <button type="button"       id="but2" class="btn btn-danger">重置</button> 
 -->           
  <button  type="submit" class="btn btn-primary"  >
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 


        
<script type="text/javascript">




function fun2(id){
	//点击编辑 弹出对话框
		  $('#my4').modal('show'); //显示
	     //异步请求
		  $.post("/FinancingProject/UsersController/get_users/"+id,
		  function(msg){
	        $("#role_id  option[value='"+msg.user_role.id+"']").attr("selected", true);      //设置Select的Text值为jQuery的项选中
			 $("#user_name").val(msg.user_name);
		     $("#mobile_Phone").val(msg.mobile_Phone);
			 $("#id").val(msg.id);
			 $("#yyy").hide();
			 if(msg.status==2){
				   $("#yyy").show();
			 }
		  }); 
}



$("#but2").click(function(){   //重置按钮 f2
    $('#f2').data('bootstrapValidator').resetForm(true);
	});



$("#delete").click(function(){   //提交删除
	$("#f3").attr("action","/FinancingProject/UsersController/de");
	$("#f3").submit();
	});

/* $("#add").click(function(){   //提交添加
alert("ok");
}); */

function fun(id){//删除
	  $('#my2').modal('show'); //显示
	  $('#delete_id').val(id);
}



//点击时模糊查询
$("#se").click(function(){
	$("#f1").attr("action","/FinancingProject/AdminController/menus19");
	$("#f1").submit();
	
});
$("#reset").click(function(){  //重置按钮
      $("#users_q1").val("");
      $("#users_q2").val("");
	 $("#f1").attr("action","/FinancingProject/AdminController/menus19");
	 $("#f1").submit();
	  
});


$(function(){
	   // 异步请求内容
    var s;
    $.post("/FinancingProject/AdminController/get_user_role",
    function(msg){
    	   for(var i=0;i<msg.length;i++){
    		      s=msg[i];
    		      $("#a5").append("<option value="+s.id+">"+s.cname+"</option>");
    		      $("#role_id").append("<option value="+s.id+">"+s.cname+"</option>");
    	   }
    }); 
	
    
   //-------------------------------------------------------------
//验证
//验证
    $('#f4').bootstrapValidator({
          message: 'This value is not valid',
          feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
              invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
          },
          fields: {
             user_name: {
                  message: '',
                  validators: {
                      notEmpty: { //非空验证
                          message: '用户名不能为空!'
                      },
                      stringLength: {  //长度验证
                          min: 2,
                          max: 10,
                          message: '用户名长度为2-10个字符!'
                      }
                  }
              },
        
              password: {
                  validators: {
                     
                     stringLength:{
  				   min:6,
  				   max:30,
                        message: '密码长度必须在6到30之间'
  				   },
                    
  					regexp: {
                           regexp: /^[a-zA-Z0-9_\.]+$/,
                           message: 'The username can only consist of alphabetical, number, dot and underscore'
                       }
                  }
              }
            
             
        
          }//验证
      });
    //////////////////////
	








    $('#f2').bootstrapValidator({
          message: 'This value is not valid',
          feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
              invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
          },
          fields: {
              a1: {
                  message: '',
                  validators: {
                      notEmpty: { //非空验证
                          message: '用户名不能为空!'
                      },
                      stringLength: {  //长度验证
                          min: 2,
                          max: 10,
                          message: '用户名长度为2-10个字符!'
                      }
                  }
              },
        
              a2: {
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
                          field: 'a3',
                          message: '两次密码不一致'
                      },
  					regexp: {
                           regexp: /^[a-zA-Z0-9_\.]+$/,
                           message: 'The username can only consist of alphabetical, number, dot and underscore'
                       }
                  }
              },
              a3: {
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
                          field: 'a2',
                          message: '两次密码不一致'
                      },
  					regexp: {
                           regexp: /^[a-zA-Z0-9_\.]+$/,
                           message: 'The username can only consist of alphabetical, number, dot and underscore'
                       }
                  }
              },
              a4: {
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
                      },
                      threshold :11,
                      remote: {
                    	  url: '/FinancingProject/UsersController/yz',//验证地址
                          message: '手机号码已被注册!',//提示消息
                          delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                          type: 'POST'//请求方式
                      }
                  }
              }
        
          }//验证
      });
    //////////////////////
	
});



 $("#add1").click(function(){   //添加窗口
	  $('#my').modal('show'); //显示
	  //异步请求
	
}); 
 
 



 
</script>
</body>
</html>