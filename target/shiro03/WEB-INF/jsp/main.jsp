<%--
  Created by IntelliJ IDEA.
  User: zjjt
  Date: 2020/11/24
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>这是登录成功后看到的界面</h1><br/>

<%--这是权限认证--%>
<s:hasPermission name="书本管理">
<a href="#">高级用户</a><br/>
</s:hasPermission>

<%--角色标签--%>
<s:hasRole name="管理者">
<a href="#">管理员</a>
</s:hasRole>
</body>
</html>
