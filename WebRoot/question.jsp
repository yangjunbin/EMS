<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>My JSP 'question.jsp' starting page</title>

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
  		总记录数:${size}<br>
        	<table style="text-align: left; width: 100%;" border="1">
		<tr>
			<td>uuid</td>
			<td>name</td>
			<td>createTime</td>
			<td>type</td>
			<td>答案(uuid)</td>
		</tr>
		<c:forEach var="questionAndAnswer" items="${questionAndAnswers}">
			<tr>
				<td>${questionAndAnswer.question.uuid}</td>
				<td>${questionAndAnswer.question.name}</td>
				<td>${questionAndAnswer.question.createTime}</td>
				<td>${questionAndAnswer.question.type}(单选还是多选)</td>
				<td>
				<c:forEach var="answer" items="${questionAndAnswer.answers}">
					${answer.context}(${answer.uuid }),
				</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>


<html>
<head>
  <link rel="stylesheet" href="assets/stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="assets/stylesheets/common.css" />
  <style>
  #content { width:640px; height:10em; }
  .choose_template { overflow:hidden; }
  .choose_template li { float:left; list-style:none; width:200px; margin:0 10px; }
  .preview { width:200px; height:240px; border:1px solid #e2e2e2; background:#efefef; }
  .template_name, .action { text-align:center; }
  #step-two { margin:10px 0 30px; overflow:hidden; }
  #step-two .control-group { margin:20px 0; }
  </style>
</head>
<body>
  <!--导航-->
  <div class="navbar">
    <div class="navbar-inner container">
      <a class="brand" href="#">网信平台</a>
      <ul class="nav">
        <li><a href="#">首页</a></li>
        <li class="active"><a href="#">网信管理</a></li>
        <li><a href="#">模板</a></li>
        <li><a href="#">联系人</a></li>
        <li><a href="#">管理员</a></li>
      </ul>
    </div>
  </div>

  <div class="container">

  </div>
</body>
</html>