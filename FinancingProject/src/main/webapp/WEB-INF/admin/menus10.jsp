<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>绑卡管理</title>
 <link href="/FinancingProject/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn1").click(function(){
			$("#form1").attr("action","/FinancingProject/Member_bankcards_Controller/bangka");
			$("#form1").submit();
		});
		
	});
</script>
</head>
<body>
<div >
	<form action="" role="form"  method="post" id="form1">
		<table class="table table-striped" width="100%">
		<br>
		<div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机号:<input type="text" name="mobile_Phonem" value="${mobile_Phonem }">&nbsp;&nbsp;
			绑卡姓名:<input type="text" name="member_namem" value="${member_namem }">&nbsp;&nbsp;
			绑卡卡号:<input type="text" name="card_nom" value="${card_nom }">&nbsp;&nbsp;&nbsp;&nbsp;
			注册时间:<input type="date" name="create_datem" value="${create_datem }">&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-primary" id="btn1">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" id="resetBtn" class="btn btn-success">重置</button> &nbsp;&nbsp;&nbsp;&nbsp;
		
		</div>
		<br>
			<tr>
				<th>序号</th>
				<th>手机号</th>
				<th>绑卡人姓名</th>
				<th>绑卡身份证</th>
				<th>绑卡类型</th>
				<th>绑卡卡号</th>
				<th>绑卡地址</th>
				<th>状态</th>
				<th>添加时间</th>
				<th>操作</th>
			</tr>
		<c:forEach items="${listMember_bankcards }" var="lmb" varStatus="stat">
			<tr>
				<td>${stat.index+1}</td>
				<td>${lmb.member_id.mobile_Phone }</td>
				<td>${lmb.member_id.member_name}</td>
				<td>${lmb.member_id.identity}</td>
				<td>${lmb.type}</td>
				<td>${lmb.card_no}</td>
				<td>${lmb.cardaddress}</td>
				<td>
					<c:if test="${lmb.delflag==0}">
						<font color="green">正常使用</font>
					</c:if>
					<c:if test="${lmb.delflag==2}">
						<font color="red">被删除</font>
					</c:if>
				</td>
				<td>${lmb.create_date}</td>
				<td></td>
			</tr>
			
		</c:forEach>
		</table>
	</form>

</div>
</body>
</html>