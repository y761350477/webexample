<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 2017/7/7
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
        function zhuce(){
            window.open("jsp/Register.jsp", "_self");
        }
    </script>
  </head>
  <body>
  <%
    String name = "";
    String pwd = "";

    Cookie[] cookies = request.getCookies();//获取cookie

    if(cookies != null){
      for(Cookie c : cookies){
        if(c.getName().equals("username")){
          name=java.net.URLDecoder.decode(c.getValue(),"UTF-8");
        }if(c.getName().equals("password")){
          pwd=c.getValue();
        }
      }
    }
  %>

  <%-- <%=name %>
  <%=pwd %>	 --%>
  <form action="ServletCookie" method="post">
    用户名：<input type="text" value="<%=name %>" name="name"/><br/>
    密码：<input type="password" value="<%=pwd %>" name="pwd"/><br/>
    <input type="checkbox" name="remember">记住密码
    <a href="ServletDownload">条款</a><br>
    <input type="submit"> <input type="button" value="注册" onclick="zhuce()">
  </form>
  </body>
  </body>
</html>
