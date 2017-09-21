<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资讯管理</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
</head>
<body>
<h3>>>资讯管理</h3>
<hr>


<center>
<form  name="f1"  id="f1"    class="form-horizontal" role="form"  action=""  method="post">    
<table  width="90%" >
<tr>
  <td >
  <label for="firstname" class="col-sm-2 control-label">标题</label >
              <input type="text" class="form-control" id="news_q1"  name="news_q1" 
        value="${news_q1 }"        placeholder="请输入标题"   style="width: 200px">
  </td>
 <td >
 <label for="firstname" class="col-sm-3 control-label">所属类别</label >
              <%--  <input type="text" class="form-control"   id="news_q2"  name="news_q2"
               value="${news_q2 }"     style="width: 200px"> --%>
                <select   style="width: 200px"    name="news_q2"  id="news_q2" class="form-control">
              <option value="-1">请选择<span class="caret"></span> </option>
             </select>
 
 </td>
  <td>
       <button type="button" class="btn btn-primary"  name="se"  id="se" >
          查询
       </button>
 </td>
 <td>
         <button id="reset"      type="button" class="btn btn-danger"  >  重置 </button>
 </td>
  <td align="right" width="10%">
      <button type="button" class="btn btn-primary"  onclick="fun3();"
        >
           添加
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
        <th>标题</th>
        <th>所属类别</th>
        <th>排序</th>
         <th>添加时间</th>
          <th>操作</th>
       </tr>
       
       <c:forEach  items="${news }" var="s"   varStatus="va">
           <tr>
                 <td>${va.index+1 }</td>
                 <td>${s.title }</td>
                 <td>${s.news_type.name}</td>
                  <td>${s.sort }</td>
                  <td>${s.addTime }</td>
                  <td>
                  <button type="button" class="btn btn-primary"   onclick="fun2(${s.id})"  >
                   编辑查看
                  </button>
                   &nbsp; &nbsp;    
                   <button type="button" class="btn btn-danger"  data-toggle="modal"   onclick="fun(${s.id})"  >
                   删除
                  </button>
                  </td>
          </tr>
        </c:forEach>
 </table>
 </div>
 </center>
 
 
 <!-- 弹出对话框 -->
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button>
            <h3 class="modal-title" id="myModalLabel"  >
                 <font color="red">警告</font>  
                </h3>
         </div>
         
           <form method="post"  id="f2" action="" name="f2">
         <div class="modal-body">
                         <span class="glyphicon glyphicon-sign" ></span>
       
           <input type="hidden"  id="did"  name="did">
       
            <font size="+1" >  确定删除该条数据?  </font>
               </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
                 data-dismiss="modal">关闭 
           </button>
           <button type="button" class="btn btn-danger"  id="delete">
                  删除 
            </button>
            
         </div>
         </form>
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
      </div>
 
 
 
 
 
 <script type="text/javascript">
 function fun3(){  //新增
	 $(location).attr('href', '/FinancingProject/News_Controller/add1');
 }
 
 
 
function fun2(id){  //编辑
	 $(location).attr('href', '/FinancingProject/News_Controller/update1/'+id);
}
 
 
 
 function fun(id){//点击删除按钮
	    $('#myModal').modal('show');
	    $("#did").val(id);
 }


$(function(){
	 //删除
	$("#delete").click(function(){
		$("#f2").attr("action","/FinancingProject/News_Controller/delete");
		$("#f2").submit();
		
	});
	
	
	
	//点击时模糊查询
	$("#se").click(function(){
		$("#f1").attr("action","/FinancingProject/AdminController/menus7");
		$("#f1").submit();
		
	});

	$("#reset").click(function(){  //重置按钮
		  $("#news_q2  option[value='-1']").attr("selected", true);    //设置Select的Text值为jQuery的项选中  
	      $("#news_q1").val("");
	  	 $("#f1").attr("action","/FinancingProject/AdminController/menus7");
		 $("#f1").submit();
		  
	});
	
	 //异步请求下拉列表
	  var s;
	  var q2=parseInt('${news_q2}');
	 $.post("/FinancingProject/News_type_Controller/list",function(msg){
		 for(var i=0;i<msg.length;i++){
			      s=msg[i];
			      $("#news_q2").append("<option value="+s.id+">"+s.name+"</option>");
			      if(s.id==q2){
			      $("#news_q2  option[value='"+s.id+"']").attr("selected", true);    //设置Select的Text值为jQuery的项选中  
			      }
		 }
		});
});


</script>
 
 
 
</body>
</html>