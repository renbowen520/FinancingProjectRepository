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
</head>
<body>
<h3>>>公告管理</h3>
<hr>


<center>
<form  name="f1"  id="f1"    class="form-horizontal" role="form"  action=""  method="post">    
<table  width="90%" >
<tr>
  <td >
  <label for="firstname" class="col-sm-2 control-label">标题</label >
              <input type="text" class="form-control" id="q1"  name="q1" 
        value="${q1 }"        placeholder="请输入标题"   style="width: 200px">
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
<form name="f2" id="f2"  method="post">
 <table class="table table-striped  table-hover" >
       <tr>
        <th>序号</th>
        <th>类别</th>
        <th>公告标题</th>
         <th>添加时间</th>
         <th>修改时间</th>
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
                  <td>
                   <c:if  test="${ s.status == 0}">
                       <font color="blue">发布中</font>
                   </c:if>
                       <c:if  test="${ s.status == 1}" >
                      <font color="red">已下架</font>
                   </c:if>
                 </td>
                 
                  <td>
                   
                  <button type="button" class="btn btn-primary"   onclick="fun2(${s.id})"  >
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
	//点击时模糊查询
	$("#se").click(function(){
		$("#f1").attr("action","/FinancingProject/AdminController/menus17");
		$("#f1").submit();
		
	});
	$("#reset").click(function(){  //重置按钮
	      $("#q1").val("");
	  	  $("#f1").attr("action","/FinancingProject/AdminController/menus17");
		  $("#f1").submit();
	});

	 //删除
	 function fun(id){
		    $("#f2").attr("action","/FinancingProject/Push_notice_controller/delete/"+id);
			$("#f2").submit();
		 
	 }

		
		

	
</script>
</body>
</html>