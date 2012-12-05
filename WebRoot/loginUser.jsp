<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'loginUser.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table style="text-align: left; width: 100%;" border="1">
		<tr>
			<td>用户名</td>
			<td>姓名</td>
			<td>性别</td>
			<td>状态</td>
			<td>注册时间</td>
			<td>登陆时间</td>
			<td>错误登陆次数</td>
			<td colspan="3">操作</td>
		</tr>
		<c:forEach var="loginUser" items="${loginUsers}">
			<tr>
				<td>${loginUser.user}</td>
				<td>${loginUser.name}</td>
				<td>${loginUser.sex}</td>
				<td>${loginUser.status}</td>
				<td>${loginUser.regTime}</td>
				<td>${loginUser.loginTime}</td>
				<td>${loginUser.errorCount}</td>
				<td><a href="addLoginUser.jsp">新增</a></td>
				<td><a href="editLoginUser.jsp?user=${loginUser.user}&name=${loginUser.name}&sex=${loginUser.sex}&pwd=${loginUser.pwd}&uuid=${loginUser.uuid}">修改</a></td>
				<td><a href="LoginUserServlet?type=del&uuid=${loginUser.uuid}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
