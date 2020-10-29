<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: xujiajun
  Date: 2020-10-27
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add(new User("zhangsan", 23, new Date()));
    list.add(new User("asfadaf", 12, new Date()));
    list.add(new User("vrvrvr", 32, new Date()));
    request.setAttribute("list", list);
%>
<table border="1" width="500px" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count % 2 == 0}">
            <tr bgcolor="red">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>
         <c:if test="${s.count % 2 != 0}">
            <tr bgcolor="green">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>


    </c:forEach>



</table>
</body>
</html>
