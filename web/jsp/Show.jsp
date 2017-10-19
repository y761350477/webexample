<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Show.jsp' starting page</title>
    
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
    <form>
    	<table border="1" bordercolor="blue">
    		<tr>
    			<th>商品名称</th>
    			<th>商品价格/元</th>
    			<th>选择</th>
    		</tr>
    		
    		<tr>
    			<td>英语资料</td>
    			<td>50</td>
    			<td><input type="checkbox"></td>
    		</tr>
    		
    		<tr>
    			<td>Java编程思想</td>
    			<td>78</td>
    			<td><input type="checkbox"></td>
    		</tr>
    		
    		<tr>
    			<td>课外读物</td>
    			<td>16</td>
    			<td><input type="checkbox"></td>
    		</tr>
    		
    		<tr>
    			<td colspan="3"><input type="submit"></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
