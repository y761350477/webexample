<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 2017/8/10
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%--JSP指令--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--/<%%/>和/<%!%/>的区别--%>
<%--
<%!%> jsp网页声明部分
<%%> jsp网页代码段部分
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--JSP注释，在源码中看不到--%>
    <%--jsp声明--%>
    <%! int i = 1;%>
    <%--jsp表达式--%>
    <%= i%>

    <%--JSP中使用java判断语句的两种情况:--%>

    <%--使用多个JSP标签拼接的操作--%>

    <% out.print("aaa");%>
    <% if(i == 2) {%>
    <p>nihs</p>
    <%} else { %>
    <p>nibuhs</p>
    <%}%>

    <%--使用单个JSP标签的操作-->

    <%--总结对于在JSP标签中要输出到页面的内容需要使用out.print()的方法打印，否则就要要输出到页面的内容写在JSP外面使用多个JSP标签拼接--%>
    <%--<%if(i == 1) {
        out.print("nihs");
    } else {
        out.print("nibuhs");
    }%>--%>
</body>
</html>
