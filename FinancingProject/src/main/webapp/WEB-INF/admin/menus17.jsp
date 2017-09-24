<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告</title>
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
<b>公告管理</b>
</h3>
<hr>


<!--  编辑的div层-->
<div class="modal fade" id="my2" tabindex="888" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 编辑 公告  </h4>
         </div>
         
       <form  name="update"  id="update"    class="form-horizontal" role="form"    method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">标题</label>
               <div class="col-sm-10">
               <input type="hidden"  id="id" name="id" > 
           <!--     <input type="hidden"  id="sj"  name="sj">  -->
               <input type="text" class="form-control" id="title"  name="title"
                 placeholder="请输入标题" required="required">
               </div>
          </div>

   
    <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">内容</label>
               <div class="col-sm-10">
             <!--   <input type="text" class="form-control" id="info"  name="info"
                 placeholder="请输入简介"  required="required"> -->
                   <script   name="content"   id="content" type="text/plain"   style="height:250px;"></script>
               </div>
          </div>
   </div>
         
         <div class="modal-body"  id="div22">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">重新发布:</label>
               <div class="col-sm-10">
                  <input disabled="disabled"   type="checkbox"  name="zd" id="zd"  value="0" checked="checked" >
                <!--   <input type="hidden" name="zd"> -->
               </div>
          </div>
       </div>  
        
         
         <div class="modal-footer"  >
           <div id="yc2" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
              
               
            <button  id="ok2"   type="button" class="btn btn-primary"  >
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->






<!--  新增的div层-->
<div class="modal fade" id="my" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 新增 公告  </h4>
         </div>
         
       <form  name="add"  id="add"    class="form-horizontal" role="form"    method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">标题</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="t1"  name="t1"
                 placeholder="请输入标题" required="required">
               </div>
          </div>

   
    <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">内容</label>
               <div class="col-sm-10">
             <!--   <input type="text" class="form-control" id="info"  name="info"
                 placeholder="请输入简介"  required="required"> -->
                   <script   name="t2"   id="t2" type="text/plain"   style="height:250px;"></script>
               </div>
          </div>
   
     
   </div>
         
         <div class="modal-footer">
            
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
              
              <button type="button"    onclick="reset1();"    id="resetBtn" class="btn btn-danger">重置</button> 
               
            <button  id="ok"   type="button" class="btn btn-primary"  >
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 
 


<center>
<form  name="f1"  id="f1"    class="form-horizontal" role="form"  action=""  method="post">    
<table  width="90%"   border="1">
<tr>
  <td >
  <label for="firstname" class="col-sm-2 control-label">标题</label >
              <input type="text" class="form-control" id=" push_q1"  name="push_q1" 
        value="${push_q1 }"        placeholder="请输入标题"   style="width: 200px">
  </td>
 <td >
  <label for="firstname" class="col-sm-3 control-label">发布人</label >
              <input type="text" class="form-control" id="push_q2"  name="push_q2" 
        value="${push_q2 }"        placeholder="请输入发布人姓名"   style="width: 200px">
  </td>
 
 
  <td>
       <button type="button" class="btn btn-primary"  name="se"  id="se" >
          查询
       </button>
 </td>
 <td>
         <button id="reset"      type="button" class="btn btn-danger"   >  重置 </button>
 </td>
  <td align="right" width="10%">
      <button type="button" class="btn btn-primary" data-toggle="modal" 
      id="on_add">
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
<form name="f2" id="f2"  method="post">
 <table class="table table-striped  table-hover" >
       <tr>
        <th>序号</th>
        <th>类别</th>
        <th>公告标题</th>
         <th>添加时间</th>
         <th>修改时间</th>
         <th>发布人</th>
         <th>修改人</th>
         <th>状态</th>
          <th>操作</th>
       </tr>
       
       <c:forEach  items="${push }" var="s"   varStatus="va">
           <tr>
                 <td>${va.index+1 }</td>
                   <td>公告</td>
                 <td>${s.title }</td>
                 <td>${s.create_date}</td>
                  <td>${s.update_date}</td>
                   <td>${s.users.user_name}</td>
                     <td>${s.users2.user_name}</td>
                  <td>
                   <c:if  test="${ s.status == 0}">
                       <font color="blue">发布中</font>
                   </c:if>
                       <c:if  test="${ s.status == 1}" >
                      <font color="red">已下架</font>
                   </c:if>
                 </td>
                 
                  <td>
                   
                  <button    data-toggle="modal"       type="button" class="btn btn-primary"   onclick="fun2(${s.id})"  >
                   编辑查看
                  </button>
                   &nbsp; &nbsp;
                    <c:if  test="${ s.status == 1}">    
                   <button   disabled="disabled"      type="button" class="btn btn-danger"  data-toggle="modal"   onclick="fun(${s.id})"  >
                   删除
                  </button>
                  </c:if>
                   <c:if  test="${ s.status == 0}">    
                   <button       type="button" class="btn btn-danger"  data-toggle="modal"   onclick="fun(${s.id})"  >
                   删除
                  </button>
                  </c:if>
                  </td>
          </tr>
        </c:forEach>
 </table>
 </form>
 </div>
 </center>





<script type="text/javascript">
   var ue = UE.getEditor('t2');
   var ue2 = UE.getEditor('content');
   
   
   $("#on_add").click(function(){
	   //添加按钮打开 窗口
	    $("#t1").val("");
	    ue.setContent(""); 
	    $("#yc").hide()   ;//表示display:none; 
	    $('#my').modal('show'); //显示
   });
   
   
   function fun2(id){
	    $('#my2').modal('show');
	    $("#div22").hide();
	    $("#yc2").hide()   ;//表示display:none; 
	 // 异步请求内容
	    $.post("/FinancingProject/Push_notice_controller/getById",{id:id},
	    function(msg){
	    	  $("#title").val(msg.title);
	    	  ue2.setContent(msg.content);
	    	  $("#id").val(msg.id);
	    	  if(msg.status==1){
	    		  $("#div22").show();
	    	  }
	    });
   }
   
   
/*    function  reset2(){
	       var t1=  $("#title").val("");
	       ue2.setContent(""); 
		   $("#yc2").hide()   ;//表示display:none; 
} */
   
   function  reset1(){
	     $("#t1").val("");
	       ue.setContent(""); 
		   $("#yc").hide()   ;//表示display:none; 
   }
   
	//点击时模糊查询
	$("#se").click(function(){
		$("#f1").attr("action","/FinancingProject/AdminController/menus17");
		$("#f1").submit();
		
	});
	$("#reset").click(function(){  //重置按钮
	      $("#push_q1").val("");
	      $("#push_q2").val("");
	  	  $("#f1").attr("action","/FinancingProject/AdminController/menus17");
		  $("#f1").submit();
	});

	 //删除
	 function fun(id){
		    $("#f2").attr("action","/FinancingProject/Push_notice_controller/delete/"+id);
			$("#f2").submit();
		 
	 }

		$("#ok").click(function(){  //新增按钮  提交
			     var t1=  $("#t1").val();
			    var t2 =  ue.getContent(); 
			     if(t1==null  || t1==""){
			    	 $("#yc").text("请填写完整信息!");
					   $("#yc").show();//表示display:block, 
					   return ;
				  }
			     if(t1.length<2||t1.length>30){
			    	 $("#yc").text("标题长度2-30个字符!");
					   $("#yc").show();//表示display:block, 
					   return ;
			    	 
			     }
			     
			     
			     if(t2==null  || t2==""){
			    	   $("#yc").text("请填写完整信息!");
					   $("#yc").show();//表示display:block, 
					   return ;
				  }
			     
				   $("#yc").hide()   ;//表示display:none; 
				   $("#add").attr("action","/FinancingProject/Push_notice_controller/add");
					$("#add").submit();
		});
	 
		$("#ok2").click(function(){  //编辑按钮  提交
		     var t1=  $("#title").val();
		     var t2 =  ue2.getContent(); 
		//     var sj=  $("#sj").val();
		 //    var zd = $('input:checkbox[name="zd"]:checked').val();
           
		     if(t1==null  || t1==""){
		    	 $("#yc2").text("请填写完整信息!");
				   $("#yc2").show();//表示display:block, 
				   return ;
			  }
		     if(t1.length<2||t1.length>30){
		    	 $("#yc2").text("标题长度2-30个字符!");
				   $("#yc2").show();//表示display:block, 
				   return ;
		    	 
		     }
		     if(t2==null  || t2==""){
		    	   $("#yc2").text("请填写完整信息!");
				   $("#yc2").show();//表示display:block, 
				   return ;
			  }
		     
			   $("#yc2").hide()   ;//表示display:none; 
			   $("#update").attr("action","/FinancingProject/Push_notice_controller/update");
				$("#update").submit();
	});

</script>
</body>
</html>