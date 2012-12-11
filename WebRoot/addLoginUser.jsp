<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <link rel="stylesheet" href="stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="stylesheets/common.css" />
  <style>
  #content { width:640px; height:10em; }
  </style>
</head>
<body>
  <%@include file="main_nav.jsp"%>

  <!--内容-->
  <div class="container nms">
    <div class="content">
      <form class="form-horizontal" action="LoginUserServlet" method="post">
        <fieldset>
          <legend>创建管理员</legend>
          <div class="control-group">
            <label class="control-label" for="username">用户名</label>
            <div class="controls">
              <input type="text" id="username" name="user" placeholder="输入用户名"> ${msg}
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="password">密码</label>
            <div class="controls">
              <input type="password" name="pwd" id="password">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="name">姓名</label>
            <div class="controls">
              <input type="text" name="name" id="name">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="sex">性别</label>
            <div class="controls">
              <label class="radio">
                <input type="radio" name="sex" id="optionsRadios1" value="1" checked>
                男
              </label>
              <label class="radio">
                <input type="radio" name="sex" id="optionsRadios2" value="2">
                女
              </label>
            </div>
          </div>
          <div class="control-group">
            <div class="controls">
              <input type="hidden" value="add" id="type" name="type"/>
              <button type="submit" class="btn">创建</button>
            </div>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</body>
</html>
