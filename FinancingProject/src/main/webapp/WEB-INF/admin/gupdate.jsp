<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改海外配置</title>
</head>
<body>
	<form action="/FinancingProject/oversea/update" method="post">
	<input type="hidden" name="id" value="${oversea_config.id }"/>
名字:<input type="text" name="title" value="${oversea_config.title}"><br>
	子标题:<input type="text" name="child_title" value="${oversea_config.child_title }"><br>
	描述:<input type="text" name="description" value="${oversea_config.description }"><br>
	用户群体:<input type="text" name="user_type" value="${oversea_config.user_type }"><br>
	排序值:<input type="text" name="sortColum" value="${oversea_config.sortColum }"><br>
	状态:<select name="status">
	<option>未发布</option>
	<option>募集中</option>
	<option>已结束</option>
	</select><br>
	<!-- 
	开始时间:<input type="date" name="start_date" value="${oversea_config.start_date}"><br>
	结束时间:<input type="date" name="end_date" value="${oversea_config.end_date}"><br>
	 -->
	<input type="submit" value="提交">
</form>
</body>
</html>