<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
</head>
<body>
<!--这里写资讯分类  -->
<h3>>>资讯分类</h3>
<center>
<hr>

<div  style="width: 95%;text-align:right;margin-bottom:1px;">
<button type="button" class="btn btn-primary" data-toggle="modal" 
   data-target="#my">
  新增
</button>
</div>
<br>

<div style="width: 95%">
 <table class="table table-striped  table-hover" >
       <tr>
        <th>序号</th>
        <th>名称</th>
        <th>上级类别</th>
        <th>简介</th>
         <th>排序</th>
         <th>添加时间</th>
          <th>操作</th>
       </tr>
       <c:forEach  items="${news_type }" var="s"   varStatus="va">
           <tr>
                 <td>${va.index+1 }</td>
                 <td>${s.name }</td>
                 <td>
                 <script type="text/javascript">
                  var id='${s.id}';
				   $.ajaxSetup({  
					    async : false  
					}); 
				  var news=""; 
				 $.post("/FinancingProject/News_type_Controller/supType",{id:id},function(data){
					 news=data;
				  });
				   document.write(news);
				
				 </script>
                 </td>
                 <td>${s.info }</td>
                  <td>${s.sort }</td>
                  <td>${s.addTime }</td>
                  <td>
                  <button type="button" class="btn btn-primary"  data-toggle="modal"        onclick="edit(${s.id});">
                   编辑
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
            <h4 class="modal-title" id="myModalLabel"> 新增 资讯分类  </h4>
         </div>
         
       <form  name="f1"  id="f1"    class="form-horizontal" role="form"  action="/FinancingProject/News_type_Controller/add"  method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">名称</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="name"  name="name"
                 placeholder="请输入名称" required="required">
               </div>
          </div>
   <div class="form-group">
         <label for="lastname" class="col-sm-2 control-label">上级目录</label>
           <div class="col-sm-10">
              <select  name="supType"  id="xiala" class="form-control">
            </select> 
         </div>
   </div>
   
    <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">简介</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="info"  name="info"
                 placeholder="请输入简介"  required="required">
               </div>
          </div>
   
       <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">排序</label>
               <div class="col-sm-10">
               <input type="number" class="form-control"  id="sort"  name="sort"
                value="1"    min="1"  required="required" >
               </div>
          </div>
   
          
   </div>
         
         <div class="modal-footer">
         
           <div id="yc" style="margin-bottom:1px;color: red;display: none">请填写完整信息</div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
              
              <button type="reset" id="resetBtn" class="btn btn-danger">重置</button> 
               
            <button  id="ok"   type="button" class="btn btn-primary"  onclick="fun();">
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 
 

 
  
 <div class="modal fade" id="ed" tabindex="-1" role="dialog" 
    aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 编辑 资讯分类  </h4>
         </div>
         
       <form  name="f2"  id="f2"    class="form-horizontal" role="form"  action="/FinancingProject/News_type_Controller/update"  method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">名称</label>
               <div class="col-sm-10">
               <input type="hidden" id="id2" name="id" >
            
               <input type="text" class="form-control" id="name2"  name="name"
                 placeholder="请输入名称" required="required">
               </div>
          </div>
   <div class="form-group">
         <label for="lastname" class="col-sm-2 control-label">上级目录</label>
         <div class="col-sm-10">
              <select  name="supType"  id="x2" class="form-control">
             </select> 
         </div>
   </div>
   
    <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">简介</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="info2"  name="info"
                 placeholder="请输入简介"  required="required">
               </div>
          </div>
   
       <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">排序</label>
               <div class="col-sm-10">
               <input type="number" class="form-control"  id="sort2"  name="sort"
                value="1"    min="1"  required="required" >
               </div>
          </div>
   
          
   </div>
         
         <div class="modal-footer">
           <div id="yc2" style="margin-bottom:1px;color: red;display: none">请填写完整信息</div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
              
              <button type="reset" id="resetBtn" class="btn btn-danger">重置</button> 
               
            <button  id="ok"   type="button" class="btn btn-primary"  onclick="fun2();">
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  ed  -->
 
 
 
 <script type="text/javascript">
 function fun2(){  //提交
	  var name=  $("#name2").val();
	  var  info=  $("#info2").val();
	  var  sort =  $("#sort2").val();
	  
	  if(name==null  || name==""){
		   $("#yc2").show();//表示display:block, 
		   return ;
	  }
	  if(info==null  || info==""){
		   $("#yc2").show();//表示display:block, 
		   return ;
	  }
	  if(sort==null  || sort==""){
		   $("#yc2").show();//表示display:block, 
		   return ;
	  }
	   $("#yc2").hide()   ;//表示display:none; 
	   document.getElementById("f2").submit();
	   
 }
 
 
 
 
 function edit(id){ //显示编辑框
	    $('#ed').modal('show');
 // 异步请求内容
	    $.post("/FinancingProject/News_type_Controller/getById",{id:id},
	    function(msg){
	    	    $("#id2").val(msg.id);
	    	    $("#name2").val(msg.name);
	    	    $("#info2").val(msg.info);
	    	    $("#sort2").val(msg.sort);
	    	    $("#x2  option[value='"+msg.supType+"']").attr("selected", true);    //设置Select的Text值为jQuery的项选中
	    	    $("#x2  option[value='"+msg.id+"']").remove();   //删除Select中Value=自己的Option
	    });
 }
 
 //这个是当窗口打开时的事件 异步请求下拉列表
 $('#ed').on('show.bs.modal', function () {
	        $.ajaxSetup({async : false}); 
var s ;
var s2="根类别";
$.post("/FinancingProject/News_type_Controller/list",function(msg){
$("#x2").append("<option value="+0+">"+s2+"</option>");
 for(var i=0;i<msg.length;i++){
	      s=msg[i];
	      $("#x2").append("<option value="+s.id+">"+s.name+"</option>");
  }
});
	
}); 
 
 
 
 
  function fun(){  //提交
	  var name=  $("#name").val();
	  var  info=  $("#info").val();
	  var  sort =  $("#sort").val();
	  if(name==null  || name==""){
		   $("#yc").show();//表示display:block, 
		   return ;
	  }
	  if(info==null  || info==""){
		   $("#yc").show();//表示display:block, 
		   return ;
	  }
	  if(sort==null  || sort==""){
		   $("#yc").show();//表示display:block, 
		   return ;
	  }
	   $("#yc").hide()   ;//表示display:none; 
	   document.getElementById("f1").submit();
	   
  }
    
 
 
 
	    //这个是当窗口打开时的事件 异步请求下拉列表
	   $('#my').on('show.bs.modal', function () {
		        $.ajaxSetup({  
			         async : false  
			   }); 
var s ;
var s2="根类别";
$.post("/FinancingProject/News_type_Controller/list",function(msg){
    $("#xiala").append("<option value="+0+">"+s2+"</option>");
	   for(var i=0;i<msg.length;i++){
		      s=msg[i];
		      $("#xiala").append("<option value="+s.id+">"+s.name+"</option>");
	    }
  });
		
	    }); 
	     

 </script>
</body>
</html>