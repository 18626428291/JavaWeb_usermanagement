<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: xujiajun
  Date: 2020-10-27
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">${i}${s.index}${s.count}<br></c:forEach>
<hr>
<%
    List list = new ArrayList();
    list.add("add");
    list.add("123");
    list.add("sac");
    request.setAttribute("list",list);

%>
<c:forEach items="${list}" var="str" varStatus="s">
${s.index}${s.count}${str}<br>
</c:forEach>
</body>
</html>
