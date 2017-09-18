<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加海外配置信息</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

     <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/lang/zh-cn/zh-cn.js"></script>


</head>
<body>
<center>
<form action="/FinancingProject/oversea/save" method="post">
<table border="0" cellspacing="0" width="400">
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;标题:</td>
	<td><input type="text" name="title" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;子标题:</td>
	<td><input type="text" name="child_title" class="form-control"></td>
	</tr><tr height="60">
	<td>&nbsp;&nbsp;&nbsp;描述:</td>
	<td><input type="text" name="description" class="form-control"></td>
	</tr>
		<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;用户群体:</td>
	<td><input type="text" name="user_type" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;排序值:</td>
	<td><input type="text" name="sortColum" class="form-control"></td>
	</tr><tr height="60">
	<td>&nbsp;&nbsp;&nbsp;描述:</td>
	<td><input type="text" name="description" class="form-control"></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;&nbsp;状态:</td>
	<td><select class="form-control" name="status">
		<option value="0">未发布</option>
		<option value="1">募集中</option>
		<option value="2">回款中</option>
		<option value="3">还款完成</option>
	</select></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;图片预览 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td>
	<input type="file" name="file_name" class="form-control"/></td>
	 </tr>
	 <tr>
	 <td colspan="2"><input type="submit" value="保存"></td>
	 </tr>
</table>

</form>
</center>
</body>
</html>