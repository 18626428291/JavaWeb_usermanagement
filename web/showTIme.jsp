<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%--
  Created by IntelliJ IDEA.
  User: xujiajun
  Date: 2020-10-26
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showTime</title>
</head>
<body>
<%
    //1.获取cookie
    Cookie[] cookies = request.getCookies();
    //false表示没有cookie
    boolean flag = false;
    //遍历
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            //获取名称
            String name = cookie.getName();
            //判断是不是lastname
            if ("lastname".equals(name)) {
                flag = true;
                //有cookie,不是第一次访问
                //设置value
                //获取当前时间的字符串
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String format = sdf.format(date);
                //url编码
                format = URLEncoder.encode(format, "utf-8");
                //
                cookie.setValue(format);
                //持久化
                cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
                response.addCookie(cookie);
                //响应
                String value = cookie.getValue();
                //url解码
                value = URLDecoder.decode(format, "utf-8");

%>
                <h1>欢迎回来，您上次访问的时间为:<%= value %>></h1>
<%
                break;
            }
        }
    }
    if (cookies == null || cookies.length == 0 || flag == false) {
        //第一次访问
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//不编码空格报错
        String format = sdf.format(date);
        //url编码
        format = URLEncoder.encode(format, "utf-8");
        Cookie cookie = new Cookie("lastname", format);
        //持久化
        cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
        response.addCookie(cookie);


%>

        <h1>你好，欢迎首次登录</h1>

<% } %>

</body>
</html>
