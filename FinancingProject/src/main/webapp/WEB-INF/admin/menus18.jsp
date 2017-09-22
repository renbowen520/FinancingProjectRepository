<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
 <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.config.js"></script>
 <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.all.js"> </script>
 <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/lang/zh-cn/zh-cn.js"></script>

</head>
<body>
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>意见反馈</b>
</h3>
<hr>


<center>
<form  name="f1"  id="f1"    class="form-horizontal" role="form"  action=""  method="post">    
<table  width="90%" >
<tr>
  <td >
  <label for="firstname" class="col-sm-2 control-label">标题</label >
              <input type="text" class="form-control" id="feedback_q1"  name="feedback_q1" 
           value="${feedback_q1 }"        placeholder="请输入标题"   style="width: 200px">
  </td>
 <td >
 <label for="firstname" class="col-sm-3 control-label">会员姓名</label >
               <input type="text" class="form-control"   id="feedback_q2"  name="feedback_q2"
            placeholder="请输入姓名"        value="${feedback_q2 }"     style="width: 200px"> 
              
 
 </td>
  <td>
       <button type="button" class="btn btn-primary"  name="se"  id="se" >
          查询
       </button>
 </td>
 <td>
         <button id="reset"      type="button" class="btn btn-danger"  >  重置 </button>
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
        <th>标题</th>
        <th>会员姓名</th>
        <th>手机号</th>
        <th>反馈时间</th>
        <th>操作</th>
       </tr>
       
       <c:forEach  items="${feedback }" var="s"   varStatus="va">
           <tr>
                 <td>${va.index+1 }</td>
                 <td>${s.title }</td>
                 <td> ${s.member.member_name}</td>
                  <td>${s.member.mobile_Phone}</td>
                  <td>${s.create_date }</td>
                  <td>
                  <button   onclick="fun55('${s.title}','${s.content }' );"         type="button" class="btn btn-primary"  data-toggle="modal" >
                    查看内容
                  </button>
                  </td>
          </tr>
       </c:forEach>
 </table>
 </div>
 </center>


<div class="modal fade" id="my" tabindex="-1" role="dialog" 
    aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 查看内容  </h4>
         </div>
         
       <form  name="f1"  id="f1"    class="form-horizontal" role="form"  action=""  method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">标题</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="t1"  name="t1"
             readonly="readonly"    required="required">
               </div>
          </div>

   
    <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">内容</label>
               <div class="col-sm-10">
              <!--  <input type="text" class="form-control" id="info"  name="info"
                 placeholder="请输入简介"  required="required"> -->
       <script   name="t2"   id="t2" type="text/plain"   style="height:250px;">

     </script>
                 
               </div>
          </div>
   
      
   
          
   </div>
         
         <div class="modal-footer">
         
           <div id="yc" style="margin-bottom:1px;color: red;display: none">请填写完整信息</div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
              
          
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 
 


<script type="text/javascript">
var ue = UE.getEditor('t2');


function fun55(title,content){
   $("#t1").val(title);
   ue.setContent(content);
   $('#my').modal('show');
   ue.setDisabled('fullscreen');
   disableBtn("enable");
}



$("#reset").click(function(){  //重置按钮
     $("#feedback_q1").val("");
    $("#feedback_q2").val("");
	 $("#f1").attr("action","/FinancingProject/AdminController/menus18");
	 $("#f1").submit();
	  
});

//点击时模糊查询
$("#se").click(function(){
	$("#f1").attr("action","/FinancingProject/AdminController/menus18");
	$("#f1").submit();
	
});

</script>
</body>
</html>