<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改海外配置</title>
</head>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  $("#status").val(${oversea_config.status}); 
});
</script>

<body>
<center>
	<form action="/FinancingProject/oversea/update" method="post" >
	<input type="hidden" name="id" value="${oversea_config.id }"/>
	<table border="0" cellspacing="0" width="400">
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;名字:</td>
	<td><input type="text" name="title" value="${oversea_config.title}" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;子标题:</td>
	<td><input type="text" name="child_title" value="${oversea_config.child_title }" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;描述:</td>
	<td><input type="text" name="description" value="${oversea_config.description }" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;用户群体:</td>
	<td><input type="text" name="user_type" value="${oversea_config.user_type }" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;排序值:</td>
	<td><input type="text" name="sortColum" value="${oversea_config.sortColum }" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;状态:</td>
	<td><select name="status" id="status" class="form-control">
	<option value="0">未募集</option>
	<option value="1">募集中</option>
	<option value="2">已结束</option>
	</select></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;开始时间:</td>
	<td><input type="date" name="start_date" value="${oversea_config.start_date}" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;结束时间:</td>
	<td><input type="date" name="end_date" value="${oversea_config.end_date}" class="form-control"></td>
	</tr>
<tr height="60"><td colspan="2">
<p><h3>&nbsp;&nbsp;▶内容</h3><hr>
 <script id="editor" type="text/plain" style="width:auto;height:auto;">
		${oversea_config.context}
</script> 
</td></tr>
 <tr height="60">
<td colspan="2"  align="center">
<input type="submit" value="保存" class="btn btn-primary"/>
</td>
</tr>
 	</table>
</form>
</center>

	<script type="text/javascript">
   		 var ue = UE.getEditor('editor');
   </script>
   
</body>
</html>