<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<!DOCTYPE html>--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">

    <!-- 1. 导入CSS的全局样式 -->
    <link href="<%=basePath%>anli4page/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="<%=basePath%>anli4page/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="<%=basePath%>anli4page/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function deleteUser(id) {

            //用户确认提示
            if (confirm("您确定要删除吗？")) {
                //访问路径
                location.href = "${pageContext.request.contextPath}/deleteuserservlet?id=" + id;
            }


        }

        window.onload = function () {
            //给删除选中添加单击事件
            document.getElementById("deleteselect").onclick = function () {
                //设置标记，判断是否选中
                var flag = false;

                    //提示信息
                    if (confirm("您确定删除选中？")) {

                        //获取所有cb
                        var cbs = document.getElementById("uid");
                        for (var i = 0; i < cbs.length; i++) {
                            if (cbs[i].checked) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag == true) {
                            //表单提交
                            document.getElementById("checkedform").submit();
                        }
                }
            };
            //获取第一个cb
            document.getElementById("firstCB").onclick = function () {
                //获取下边列表所有的cb
                var cbs = document.getElementsByName("uid");
                //遍历
                for (var i = 0; i < cbs.length ; i++) {
                    //设置这些cbs【i】的checked状态
                    cbs[i].checked = this.checked;


                }

            };
        };

    </script>
    <style type="text/css">
        td, th {

            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名：</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputAddress2">籍贯：</label>
                <input type="text" class="form-control" id="exampleInputAddress2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱：</label>
                <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right; margin: 5px">
            <a class="btn btn-primary" href="<%=basePath%>anli4page/add.jsp">添加联系人</a>
            <a class="btn btn-primary" href="javascript:void(0);" id="deleteselect">删除选中</a>
    </div>
    <form id="checkedform" action="${pageContext.request.contextPath}/deleteselectservlet" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCB"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="s" >
            <tr>
                <td><input type="checkbox" name="uid" value="${user.id}"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.eamil}</td>
                <td>
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/finduserservlet?id=${user.id}">修改</a>&nbsp;
<%--                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteuserservlet?id=${user.id}">删除</a>--%>
                    <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a>

                </td>
            </tr>
        </c:forEach>



    </table>
    </form>
<div>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">6</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px;margin-left: 5px;">
                共16条记录，共4页
            </span>
        </ul>
    </nav>
</div>
</div>
</body>
</html>
