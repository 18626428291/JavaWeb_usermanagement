<%--
  Created by IntelliJ IDEA.
  User: xujiajun
  Date: 2020-10-26
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        window.onload = function () {
            var img = document.getElementById("checkcode");
            //时间戳
            img.onclick = function () {
                var date = new Date().getTime();
                img.src = "/javaWeb/checkcode?time=" + date;
            }
            var alink = document.getElementById("change");
            alink.onclick = function () {
                var date = new Date().getTime();
                img.src = "/javaWeb/checkcode?time=" + date;
            }
        }
    </script>
    <style>
        div {
            color: red;
        }
    </style>
</head>
<body>
<form action="/javaWeb/sessionservlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkcode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="checkcode" src="/javaWeb/checkcode" alt=""></td>
            <td><a id="change" href="javascript:void(0);">看不清？换一张</a></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
<div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
<div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%></div>


</body>
</html>
