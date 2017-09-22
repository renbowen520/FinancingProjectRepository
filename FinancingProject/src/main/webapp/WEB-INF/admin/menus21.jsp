<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link rel="stylesheet" href="/FinancingProject/css/bootstrap.min.css" />
<script type="text/javascript" src="/FinancingProject/js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="/FinancingProject/js/bootstrap.min.js"></script>

</head>
<body>
<h3>
<span class=" glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
<b>修改密码</b>
</h3>
<hr>
<center>
<br>
<div   style="width: 95%" >
            <form  name="f1"  id="f1"    action=""  method="post">
                <table border="0"  width="40%">
               <tr height="50px"  align="right">
                    <td><b>原密码:</b></td>
                     <td>
                           <input   style="width: 310px;"      type="password" class="form-control" id=""  name=""
                     placeholder="请输入原密码" required="required">
                     </td>
               </tr>
                  <tr height="50px" align="right"> 
                    <td><b>新密码:</b></td>
                     <td>
                           <input   style="width: 310px;"      type="password" class="form-control" id=""  name=""
                     placeholder="请输入新密码" required="required">
                     </td>
               </tr>
                  <tr height="50px" align="right">
                    <td><b>确认密码:</b></td>
                     <td>
                           <input   style="width: 310px;"      type="password" class="form-control" id=""  name=""
                     placeholder="请输入确认密码" required="required">
                     </td>
               </tr>
               
               <tr height="90px" >
                 <td  colspan="2" align="center">
                  <button  type="submit" class="btn btn-primary"  >
                        提交
                 </button>
                 </td>
               </tr>
             </table>
            
            
               
       
            
</form>
</div>
</center>

</body>
</html>