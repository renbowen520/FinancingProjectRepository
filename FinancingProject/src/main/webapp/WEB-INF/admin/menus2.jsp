<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>私募基金</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css"/>
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function(){
	 var a = "${status}";
	 var b = "${type}";
	    $("#status  option[value='"+a+"']").attr("selected", true);
	    $("#type  option[value='"+b+"']").attr("selected", true);
	
	
	
	$("#btn2").click(function(){ //新增按钮
		$("#form1").attr("action","/FinancingProject/finance/addfinance");
		$("#form1").submit();
	});
	$("#btn1").click(function(){ //模糊查询按钮
		$("#form1").attr("action","/FinancingProject/AdminController/menus2");
		$("#form1").submit();
	});
	
	
	$("#ree").click(function(){ //重置
	     $("#name").val("");
	     $("#status  option[value='']").attr("selected", true);
	    $("#type  option[value='']").attr("selected", true);
		$("#form1").attr("action","/FinancingProject/AdminController/menus2");
		$("#form1").submit();
			});
	
});
	


function test3(id){//签署状态
	   //alert(id);
	    $("#form1").attr("action","/FinancingProject/finance/subscribe/"+id);
		$("#form1").submit();
}
function test4(id){//编辑查看
//	alert(id);
	 $("#form1").attr("action","/FinancingProject/finance/bfupdate/"+id);
		$("#form1").submit();
}
 </script>
 
 
 
<body>
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>私募基金</b>
</h3>
<hr>

	
<form method="post" id="form1" role="form"    class="form-horizontal">


<center>
<table  width="90%"   >
<tr>
  <td >
  <label for="firstname" class="col-sm-3 control-label">名称</label >
  <input     id="name"  style="width: 160px"     type="text"  class="form-control"    placeholder="请输入名称" name="name" value="${name}">
  </td>
 <td >
 <label for="firstname" class="col-sm-3 control-label">状态</label >
                     <select style="width: 160px"     id="status"  name="status"    class="form-control"  >
							 <option value="">全部</option>
							 <option value="0">未发布</option>
				             <option value="1">募集中</option>
				            <option value="2">已结束</option>
						</select>
 </td>
 <td>
  <label for="firstname" class="col-sm-3 control-label">类型</label >
 	   <select   id="type"   name="type"  style="width: 160px"  class="form-control"  >
						
						<option value="">全部</option>
				       <option value="SIMU">私募</option>
				       <option value="GUQUAN">股权</option>
		</select>
 </td>
 
  <td>
  		<button type="button" class="btn btn-primary" id="btn1">查询</button>
 </td>
 
 <td>
	<button  id="ree" type="button" class="btn btn-danger">重置</button>
 </td>
    <td align="right" width="10%">
    <button type="button" class="btn btn-primary" id="btn2">新增</button> 
 </td>
</tr>
</table>
</center>
<br>


<center>	
<div style="width: 95%">
	  <table class="table table-striped  table-hover" >
		<tr >
		<th>序号</th>
		<th>名称</th>
		<th>类型</th>
		<th>状态</th>
		<th>年化收益(%)</th>
		<th>返佣比例(%)</th>
		<th>投资期限(天)</th>
		<th>起投金额(RMB)</th>
		<th>添加时间</th>
		<th>操作</th>
			<c:forEach items="${listfinance}" var="li" varStatus="l">
				<tr >
				<td>${l.index+1}</td>
				<td>${li.name}</td>
				<td>
				<c:if test="${li.type=='SIMU'}">私募</c:if>
				<c:if test="${li.type=='GUQUAN'}">股权</c:if>
				</td>
				<td>
				<c:if test="${li.status==0}">未发布</c:if>
				<c:if test="${li.status==1}">募集中</c:if>
				<c:if test="${li.status==2}">已结束</c:if>
				</td>
				<td>${li.year_rate}</td>
				<td>${li.ratio }</td>
				<td>${li.period}</td>
				<td>${li.floor_amount }</td>
				<td>${li.create_date }</td>
				<td>
				<button type="button" class="btn btn-primary" onclick="test3(${li.id})">签署状态</button> 
			    <button type="button" class="btn btn-primary" onclick="test4(${li.id})">编辑查看</button>
				</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	</div>
</center>	
</form>

</body>
</html>