<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改固收类</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript">
$(document).ready(function(){
	  $("#safeGuard_way").val(${subject.safeGuard_way}); 
});
$(document).ready(function(){
	  $("#exper_status").val(${subject.exper_status}); 
});
$(document).ready(function(){
	  $("#status").val(${subject.status}); 
});
$(document).ready(function(){
	  $("#type").val(${subject.type}); 
});
</script>
<body>
<center>
<form method="post" role="form"  action="/FinancingProject/subject/update"> 
<input type="hidden" name="id" value="${subject.id}"/>
<table border="0" cellspacing="0" width="400">
<tr height="60">
<td>名称:</td>
<td><input type="text" size="30" name="name" class="form-control" value="${subject.name}" ></td>
</tr>
<tr height="60">
<td>合同编号:</td>
<td><input type="text" size="30" name="serial_no" class="form-control" value="${subject.serial_no}" ></td>
</tr>
<tr height="60">
<td>起投金额(元):</td>
<td><input type="text" name="floor_amount" class="form-control" value="${subject.floor_amount}"></td>
</tr>
<tr height="60">
<td>年化收益(%):</td>
<td><input type="text" name="year_rate" class="form-control" value="${subject.year_rate}"></td>
</tr>
<tr height="60">
<td>状态:</td>
<td>	<select name="status" id="status">
		<option value="0">未发布</option>
		<option value="1">募集中</option>
		<option value="2">回款中</option>
		<option value="3">回款完成</option>
		</select>
</td>
</tr>
<tr height="60">
<td>投资期限:</td>
<td><input type="text" name="period" class="form-control" value="${subject.period}"></td>
</tr>	
<tr height="60">
<td>借款人姓名:</td>
<td><input type="text" name="borrowername" class="form-control" value="${subject.borrowername}"></td>
</tr>
<tr height="60">
<td>类型:</td>
<td><select name="type" id="type">
		<option value="0">固收类</option>
		<option value="1">P2P车贷</option>
		<option value="2">P2P房贷</option>
		</select>
</td>
</tr>
<tr height="60">
<td>借款用途:</td>
<td><input type="text" name="purpose" class="form-control" value="${subject.purpose}"></td>
</tr>
<tr height="60">
<td>保障方式:</td>
<td><select name="safeGuard_way" id="safeGuard_way">
		<option value="0">企业担保</option>
		<option value="1">银行监管</option>
		</select>
</td>
</tr>
<tr height="60">
<td>可使用体验金:</td>
<td><select name="exper_status" id="exper_status">
		<option value="0">否</option>
		<option value="1">是</option>
		</select>
</td>
</tr>
<tr height="60">
<td>已购人数:</td>
<td><input type="text" name="bought" class="form-control" value="${subject.bought}"></td>
</tr>	
<tr>
<td colspan="2"><input type="submit" value="保存"></td>
</tr>	
</table>
</form>
</center>
</body>
</html>