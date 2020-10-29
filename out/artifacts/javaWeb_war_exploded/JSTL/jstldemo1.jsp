<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>if标签</title>
</head>
<body>

<c:if test="false">sddadadwfrevrvrvrvrv</c:if>
<%
    List list = new ArrayList<>();
    list.add("aaa");
    request.setAttribute("lsit",list);
    request.setAttribute("number", 3);
%>
<c:if test="${not empty lsit}">遍历集合</c:if><br>
<c:if test="${number  % 2 != 0}">${number}为奇数</c:if><br>
<c:if test="${number  % 2 == 0}">${number}为偶数</c:if><br>



</body>
</html>
