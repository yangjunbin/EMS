<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <link rel="stylesheet" href="stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="stylesheets/common.css" />
  <style>
  .container .inner { width:940px; }
  .title { position:relative; }
  .title h2 { font-size:20px; font-weight:normal; border-bottom:1px solid #efefef; margin-bottom:15px; }
  .title .action { position:absolute; right:0; top:5px; }
  .container { width:600px; }
  </style>
</head>
<body>
  <!--导航-->
  <div class="navbar">
    <div class="navbar-inner container">
      <a class="brand" href="/login.jsp">网信平台</a>
    </div>
  </div>

  <div class="container">
    <form class="form-inline" action="LoginServlet" method="post">
      <legend>登入</legend>
      <input type="text" class="input-middle" name="user" value="${user}" placeholder="用户名">
      <input type="password" class="input-middle" name="pwd" placeholder="密码">
      <button type="submit" class="btn btn-primary">登入</button>
      <button id="reset" type="reset" class="btn">取消</button>
      <br/>
      <label>${msg}</label>
    </form>
  </div>
</body>
</html>
