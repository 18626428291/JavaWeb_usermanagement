<%@ page import="Domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: xujiajun
  Date: 2020-10-27
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取</title>

</head>
<body>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(23);
    user.setBirthday(new Date());
    request.setAttribute("u", user);

%>
<%
    List list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add(user);
    request.setAttribute("list", list);

%>
<%
    Map map = new HashMap();
    map.put("sname", "lisi");
    map.put("gender", "男");
    map.put("user", user);
    request.setAttribute("map",map);

%>
<h3>获取对象中的数据</h3><br>
${requestScope.u.name}<br>
${u.birthday.year}<br>


${list[1]}<br>
${list[3]}<br>
${map.sname}<br>
${map[sname]}<br>
${map.user.name}<br>


<h4>empty判断</h4><br>
<%
    String str = "asd";
    request.setAttribute("str",str);

%>
<%--null true--%>
${empty list[4]}<br>
<%--!null false--%>
${empty str}<br>
<%--!null true--%>
${not empty str}<br>




</body>
</html>
