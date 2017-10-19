<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Zhuce.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	
  	<%
  		String result = (String) session.getAttribute("注册结果");
		if(result != null){
		
		%>
			<%=result %>
		<%
			session.removeAttribute("注册结果");
		}  	 
  	 	
  	 %>
    <form action="ServletRegister" method="post">
    	用户名：<input type="text" name="name"/><br/>
    	密码：<input type="password" name="pwd"/><br/>
    	重置密码：<input type="password" name="repwd"/><br/>
    	<input type="submit"> <input type="reset">
    </form>
  </body>
</html>
