<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
这个页面主要是用来 测试如果有多个  视图解析器的情况<br>
http://127.0.0.1:8080/FinancingProject/Controller/aa<br>
@RequestMapping("/aa")<br>
	public String  aa() {  <br>
		  return   "jsp/aa";<br>
	}
</body>
</html>