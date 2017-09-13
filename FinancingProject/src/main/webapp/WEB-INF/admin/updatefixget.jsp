<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改固收类</title>
</head>
<body>
<form method="post" action="/FinancingProject/subject/update"> 
		名称:<input type="text" name="name" value="${subject.name} "><br>
		合同编号:<input type="text" name="serial_no" value="${subject.serial_no}"><br>
		起投金额(元):<input type="text" name="floor_amount" value="${subject.floor_amount}"><br>
		年化收益(%):<input type="text" name="year_rate" value="${subject.year_rate}"><br>
		状态:<select name="status">
		<option value="0">未发布</option>
		<option value="1">募集中</option>
		<option value="2">回款中</option>
		<option value="3">回款完成</option>
		</select><br>
		投资期限:<input type="text" name="period" value="${subject.period}"><br>
		借款人姓名:<input type="text" name="borrowername" value="${subject.borrowername}"><br>
		类型:<select name="type">
		<option value="0">固收类</option>
		<option value="1">P2P车贷</option>
		<option value="2">P2P房贷</option>
		</select><br>
		借款用途:<input type="text" name="purpose" value="${subject.purpose}"><br>
		保障方式:<input type="text" name="safeGuard_way" value="${subject.safeGuard_way}"><br>
		可使用体验金:<select name="exper_status">
		<option value="0">否</option>
		<option value="1">是</option>
		</select><br>
		已购人数:<input type="number" name="bought" value="${subject.bought}">
		
		<br>
		<input type="submit" value="保存">
</form>
</body>
</html>