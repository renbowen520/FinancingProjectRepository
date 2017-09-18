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
	<form action="/FinancingProject/oversea/update" method="post">
	<input type="hidden" name="id" value="${oversea_config.id }"/>
	名字:<input type="text" name="title" value="${oversea_config.title}"><br>
	子标题:<input type="text" name="child_title" value="${oversea_config.child_title }"><br>
	描述:<input type="text" name="description" value="${oversea_config.description }"><br>
	用户群体:<input type="text" name="user_type" value="${oversea_config.user_type }"><br>
	排序值:<input type="text" name="sortColum" value="${oversea_config.sortColum }"><br>
	状态:<select name="status" id="status">
	<option value="0">未募集</option>
	<option value="1">募集中</option>
	<option value="2">已结束</option>
	</select><br>

	开始时间:<input type="date" name="start_date" value="${oversea_config.addTime}"><br>
	结束时间:<input type="date" name="end_date" value="${oversea_config.updTime}"><br>
	 
   	 <script id="editor" type="text/plain" style="width:auto;height:auto;">
		${oversea_config.context}
	</script> 
   
 	<input type="submit" value="提交">
</form>


	<script type="text/javascript">
   		 var ue = UE.getEditor('editor');
   </script>
   
</body>
</html>