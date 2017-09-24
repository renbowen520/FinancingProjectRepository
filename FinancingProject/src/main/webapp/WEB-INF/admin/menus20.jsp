<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

<link href="/FinancingProject/css/jquery.treetable.css" rel="stylesheet" type="text/css" /> 
<script src="/FinancingProject/js/jquery.treetable.js"></script>

</head>
<body>
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>角色管理</b>
</h3>
<hr>


<div   style="width: 95%;text-align: right;">
   <button type="button" class="btn btn-primary"     data-toggle="modal"       onclick="fun()"  >
                  新增
    </button>
</div>



<center>
<br>
<div   style="width: 95%">
 <table class="table table-striped  table-hover" >
       <tr>
        <th>序号</th>
        <th>角色名</th>
         <th>角色描述</th>
          <th>状态</th>
         <th>创建时间</th>
         <th>更新时间</th>
          <th>操作</th>
       </tr>
       
       <c:forEach  items="${list_user_role }" var="s"   varStatus="va">
           <tr>
                  <td>${va.index+1 }</td>
                  <td>${s.cname}</td>
                  <td>${s.remark }</td>
                   <td>
                  <c:if test="${s.delFlag==0 }">
                   <font color="blue">   正常</font>
                  </c:if>
                     <c:if test="${s.delFlag==1 }">
                   <font color="red"> 已删除</font>
                  </c:if>
                  </td>
                  <td>${s.create_date }</td>
                  <td>${s.update_date }</td>
                
             
                
                  <td>
                  <button type="button" class="btn btn-primary"     data-toggle="modal"       onclick="fun2(${s.id})"  >
                    权限配置
                   </button>
                   &nbsp; &nbsp;
                   <button type="button" class="btn btn-danger"     data-toggle="modal"       onclick="fun3(${s.id})"  >
                    删除
                   </button>
                       
                  </td>
          </tr>
        </c:forEach>
 </table>
 </div>
 </center>
 

<!--  编辑的div层-->
<div class="modal fade" id="my2" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel"> 权限配置  </h4>
         </div>
         
       <form  action="/FinancingProject/"     name="f2"  id="f2"    class="form-horizontal" role="form"    method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">角色名</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="a1"  name="a1"
                 placeholder="请输入角色名" required="required">
               </div>
          </div>
         <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">角色描述</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id=""  name=""
                 placeholder="请输入角色描述" required="required">
               </div>
          </div>
   
   </div>
         
         <div class="modal-footer">
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
              <button type="button"       id="but2" class="btn btn-danger">重置</button> 
            <button  type="submit" class="btn btn-primary"  >
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->
 



<!--  编辑的div层-->
<div class="modal fade" id="my" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
      
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">  &times;</button>
            <h4 class="modal-title" id="myModalLabel">新增角色  </h4>
         </div>
         
       <form  action="/FinancingProject/"     name="f1"  id="f1"    class="form-horizontal" role="form"    method="post">    
         <div class="modal-body">
           <div class="form-group">
           <label for="firstname" class="col-sm-2 control-label">用户名</label>
               <div class="col-sm-10">
               <input type="text" class="form-control" id="a1"  name="a1"
                 placeholder="请输入用户名" required="required">
               </div>
          </div>

   
   </div>
         
         <div class="modal-footer">
           <div id="yc" style="margin-bottom:1px;color: red;display: none"></div>
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭</button>
              <button type="button"       id="but2" class="btn btn-danger">重置</button> 
            <button  type="submit" class="btn btn-primary"  >
               提交</button>
         </div>
   </form>   
   
            
      </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!--最外的div  my  -->




<script type="text/javascript">
function fun(){   //新增
   // alert("新增");
	 $(location).attr('href', '/FinancingProject/UsersController/show_add');

//    $('#my').modal('show'); //显示
}


   function fun2(id){//编辑
	     alert("角色id="+id);
	     $('#my2').modal('show'); //显示
   }
   
   function fun3(id){//删除
	     alert("删除id="+id);
	   
 }
</script>

</body>
</html>