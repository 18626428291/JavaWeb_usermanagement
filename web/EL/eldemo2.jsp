<%--
  Created by IntelliJ IDEA.
  User: xujiajun
  Date: 2020-10-26
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中数</title>
</head>
<body>
<%
    //域中存储数据
    request.setAttribute("name", "zhangsan");
    session.setAttribute("age", "23");
%>
<h3>el获取域中数</h3>
${requestScope.name}
${sessionScope.age}





</body>
</html>
