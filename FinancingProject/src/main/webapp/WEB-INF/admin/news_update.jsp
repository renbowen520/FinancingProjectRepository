<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑资讯</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>
<link href="/FinancingProject/bootstrapFile/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
<script src="/FinancingProject/bootstrapFile/js/fileinput.js" type="text/javascript"></script>
 <script type="text/javascript" src="/FinancingProject/bootstrapFile/js/locales/zh.js"></script>    
 <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.config.js"></script>
 <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/ueditor.all.js"> </script>
 <script type="text/javascript" charset="utf-8" src="/FinancingProject/ueditor/lang/zh-cn/zh-cn.js"></script>
<link rel="stylesheet"  href="/FinancingProject/css/bootstrapValidator.css"  >
<script type="text/javascript"  src="/FinancingProject/js/bootstrapValidator.js"></script>

</head>
<body>
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>资讯管理\编辑资讯</b>
</h3>
<hr>

<form   action="/FinancingProject/News_Controller/update2"   class="form-horizontal"   method="post"   role="form"  id="f1" name="f1"    enctype="multipart/form-data">
    <div class="form-group">
          <label    class="col-sm-2 control-label">标题</label>
              <div class="col-sm-3">
              <input type="hidden" name="id"  id="id"   value="${news_bean.id }" >
             <input type="text" class="form-control" id="title"  name="title"
              placeholder="请输入标题" 
             required
              value="${news_bean.title }"
              >
                
           </div>
   </div>
   
        <div class="form-group">
          <label    class="col-sm-2 control-label">排序</label>
              <div class="col-sm-3">
              <input type="number" class="form-control" id="sort"  name="sort"
               min="1"  value="${news_bean.sort }"  >
           </div>
   </div>
   
   
     <div class="form-group">
      <label  class="col-sm-2 control-label">所属类别</label>
       <div class="col-sm-3">
         <select id="typeId"  name="typeId"  class="form-control" >
         
         </select>
       </div>
   </div>
   
     <div class="form-group">
          <label    class="col-sm-2 control-label">简介</label>
              <div class="col-sm-8">
             <input type="text" class="form-control" id="info"  name="info"
              placeholder="请输入简介"
              value="${news_bean.info }"
              >
           </div>
   </div>
   
 
     <div class="form-group">
          <label    class="col-sm-2 control-label">封面图片</label>
              <div class="col-sm-8">
          <!--    multiple data-min-file-count="1"  -->
   
                   <input   id="file88"   name="file88" class="form-control"   type="file" >
           </div>
   </div>
   
  

  
    <div class="form-group">
           <label    class="col-sm-2 control-label">内容</label>
              <div class="col-sm-8">
                
                    <!--     <div id="yc2"   style="display:none;" ><font size="+2"  color="red">内容长度为10-10000字符!</font></div> -->
                   <script   name="text"   id="text" type="text/plain"   style="height:300px;">
                   ${news_bean.text}
                 </script>
                 <div id="yc"   style="display:none;" ><font size="+2"  color="red">请填写内容</font></div>
           </div>
   </div>

    <div class="form-group">
          <label    class="col-sm-2 control-label">是否置顶</label>
              <div class="col-sm-5">
                  <input type="checkbox"  name="zd" id="zd"  value="0">
                  <input type="hidden" name="zd">
           </div>
   </div>
   
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
          <button  id="ok"     type="submit" class="btn btn-primary">提交</button>
            &nbsp;&nbsp;
          
          <button type="button" class="btn btn-default"  onclick="javascript:history.back(-1);">返回</button>
      </div>
   </div>
 </form>

<script type="text/javascript">
    var ue = UE.getEditor('text');
    

/*     $('#em').click(function() {
        var ue = UE.getEditor('text');
    	ue.setContent(""); 
    	 $("#yc").hide();
        $('#f1').data('bootstrapValidator').resetForm(true);
    }); */

	$("#ok").click(function(){//点击提交按钮
		   var ue = UE.getEditor('text');
	     if(!UE.getEditor('text').hasContents()){
	    	  $("#yc").show();
	    	  return ;
	     }
	     $("#yc").hide();
		$("#f1").submit();
	});
    
    
    
    
    
    
       $(function(){
            var a= '${news_bean.placTop}';
    	    if(a==0){
    	     $("[name='zd']").attr("checked",'true');//全选     
    	    } 
    	    
   		 var s;
   	  var k = '${news_bean.news_type.id}'; 
		 $.post("/FinancingProject/News_type_Controller/list",function(msg){
			   for(var i=0;i<msg.length;i++){
				      s=msg[i];
				      $("#typeId").append("<option value="+s.id+">"+s.name+"</option>");
				       if(s.id==k){
				    	   $("#typeId  option[value='"+s.id+"']").attr("selected", true);
				       }
			    }
		});    
		 
       });  //$
  
       
       
  	 
       //验证
	  $('#f1').bootstrapValidator({
         message: 'This value is not valid',
         feedbackIcons: {
             valid: 'glyphicon glyphicon-ok',
             invalid: 'glyphicon glyphicon-remove',
             validating: 'glyphicon glyphicon-refresh'
         },
         fields: {
             title: {
                 message: '',
                 validators: {
                     notEmpty: { //非空验证
                         message: '标题不能为空!'
                     },
                     stringLength: {  //长度验证
                         min: 2,
                         max: 100,
                         message: '标题长度为2-30个字符!'
                     }
                 }
             },
             sort: {
                 message: '',
                 validators: {
                     notEmpty: {
                         message: '排序不能为空!'
                     },
                     regexp: {
                         regexp: /^[1-9]+$/,
                         message: '请输入大于0的整数!'
                     }
                 }
             },
             info: {
                 message: '',
                 validators: {
                     notEmpty: {
                         message: '简介不能为空!'
                     },
                     stringLength: {
                         min: 5,
                         max: 100,
                         message: '简介长度为5-100个字符!'
                     }
                 }
             }

       
         }//验证
     });


 
       
       
       
       $("#file1").fileinput({
           //上传的地址
    //       uploadUrl:"/FinancingProject/News_Controller/add2",
        //   uploadAsync : false, //默认异步上传
          showUpload : false, //是否显示上传按钮,跟随文本框的那个
           showRemove : true, //显示移除按钮,跟随文本框的那个
           showCaption : true,//是否显示标题,就是那个文本框
           showPreview : true, //是否显示预览,不写默认为true
           dropZoneEnabled : true,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
           //minImageWidth: 50, //图片的最小宽度
           //minImageHeight: 50,//图片的最小高度
           //maxImageWidth: 1000,//图片的最大宽度
           //maxImageHeight: 1000,//图片的最大高度
           //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
       //    minFileCount: 0,
           maxFileCount : 1, //表示允许同时上传的最大文件个数
           enctype : 'multipart/form-data',
           validateInitialCount : true,
     //      previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
           msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
           allowedFileTypes : [ 'image' ,'jpg','png','gif','jpeg','bmp'],//配置允许文件上传的类型
           allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
           allowedPreviewMimeTypes : [ 'jpg', 'png', 'gif' ,'jpeg','bmp'],//控制被预览的所有mime类型
           language : 'zh'
       });
       

</script>
</body>
</html>