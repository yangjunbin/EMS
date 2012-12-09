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
  <link rel="stylesheet" href="stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="stylesheets/common.css" />
  <style>
  .option { margin:0 10px 0 0; }
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
    <div class="title">
      <h2>问题列表</h2>
      <a class="action btn btn-primary" href="#">创建新问题</a>
    </div>
    <div class="content">
      <table class="table table-bordered table-striped">
        <tr>
          <td>（单/多）选</td>
          <td>问题</td>
        </tr>
        <c:forEach var="questionAndAnswer" items="${questionAndAnswers}">
          <tr>
            <td>${questionAndAnswer.question.type}(单选还是多选)</td>
            <td>
              <p>${questionAndAnswer.question.name}</p>
              <p>
                <c:forEach var="answer" items="${questionAndAnswer.answers}">
                  <span class="option">${answer.context}</span>
                </c:forEach>
              </p>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</body>
</html>