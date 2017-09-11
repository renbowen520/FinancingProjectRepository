<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加海外配置信息</title>

     <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/lang/zh-cn/zh-cn.js"></script>


</head>
<body>
<form action="/FinancingProject/oversea/save" method="post">
	名字:<input type="text" name="title"><br>
	子标题:<input type="text" name="child_title"><br>
	描述:<input type="text" name="description"><br>
	用户群体:<input type="text" name="user_type"><br>
	排序值:<input type="text" name="sortColum"><br>
	状态:<select name="status">
	<option value="1">未发布</option>
	<option value="2">募集中</option>
	<option value="3">已结束</option>
	</select><br>
	<!-- 开始时间:<input type="date" name="start_date"><br>
	结束时间:<input type="date" name="end_date"><br>
	 -->
	 图标:<br>
	 
	 	<input type="submit" value="提交">
	 
	       <style type="text/css">
        #dd{
            width:80%;
            height: 100px;
        }
    </style>
	 
	  <div id="dd">
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
   </div>
   
   <script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
   </script>
	 

</form>
</body>
</html>