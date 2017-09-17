<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示私募签署</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
function test3(id){//签署状态
	alert(id);
	 $("#form1").attr("action","/FinancingProject/finance/bfsubscribe/"+id);
		$("#form1").submit();
}

 </script>
<body>
<div class="table table-responsive">
<form id="form1" action="" method="post" role="form">

<table class="table table-striped" width="100%">
<tr>
<th>序号</th>
<th>姓名</th>
<th>联系电话</th>
<th>地址</th>
<th>状态</th>
<th>预约时间</th>
<th>操作</th>
</tr>
<c:forEach items="${listfinanceSubscribe}" var="li" varStatus="l">
<tr>
<td>${l.index+1 }</td>
<td>${li.member.member_name}</td>
<td>${li.member.mobile_Phone}</td>
<td>${li.addr }</td>
<td>
<c:if test="${li.status==0}"><font color="red">签署拍照</font></c:if>
<c:if test="${li.status==1}"><font color="green">已签约</font></c:if>
<c:if test="${li.status==2}"><font color="red">审核中</font></c:if>
<c:if test="${li.status==3}"><font color="red">签署失败</font></c:if>
</td>
<td>${li.create_date}</td>
<td>
<c:if test="${li.status==0}">
<button type="button">签署拍照</button>
</c:if>
<c:if test="${li.status==1}">
<button type="button">已签署</button>
</c:if>
<c:if test="${li.status==2}">
<button type="button" class="btn btn-primary" onclick="test3(${li.id})">签署</button>
<button type="button" class="btn btn-danger" onclick="return confirm('是否确定签署失败？')">签署失败</button>
</c:if>
<c:if test="${li.status==3}">
<button type="button" >签署失败</button>
</c:if>
</td>
</tr>
</c:forEach>
</table>
</form>
</div>
</body>
</html>