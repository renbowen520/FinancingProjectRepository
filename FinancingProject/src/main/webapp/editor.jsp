<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/lang/zh-cn/zh-cn.js"></script>

</head>
<body>
   测试编辑器
       <style type="text/css">
        div{
            width:100%;
        }
    </style>
    
   <div>
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
   </div>
   
   <script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
   </script>
   
   
     <link rel="stylesheet" href="/FinancingProject/layui/css/layui.css"  media="all">
    <script type="text/javascript"  src="/FinancingProject/layui/layui.js"></script>
    <form class="layui-form" action="" method="post">
   <div class="layui-form-item">
    <label class="layui-form-label" >单行输入框</label>
    <div class="layui-input-block">
      <input    style="width:350px"  type="text" name="title" lay-verify="title" autocomplete="off"   placeholder="请输入标题" class="layui-input">
    </div>
  </div>
  
  </form>
</body>
</html>