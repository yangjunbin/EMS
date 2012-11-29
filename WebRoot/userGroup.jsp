<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'UserGroup.jsp' starting page</title>

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
  <a href="fileUpload.jsp">上传</a>
  <a href="DownloadTemplate?filename=userMsgs.xlsx">模板下载</a>
	<table style="text-align: left; width: 100%;" border="1">
		<tr>
			<td>分组</td>
		</tr>
		<c:forEach var="userGroup" items="${userGroups}">
			<tr>
				<td><a href="UserMsgServlet?groupId=${userGroup.id}">${userGroup.name}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
