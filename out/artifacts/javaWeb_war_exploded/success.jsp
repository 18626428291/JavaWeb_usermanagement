<%--
  Created by IntelliJ IDEA.
  User: xujiajun
  Date: 2020-10-26
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>
<h1><%=request.getSession().getAttribute("user")%>,欢迎您</h1>
</body>
</html>
