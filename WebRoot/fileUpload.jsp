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
  .title { font-size:18px; }
  #download { border-bottom:1px solid #efefef; padding-bottom:10px; margin-bottom:20px; }
  </style>
</head>
<body>
  <!--导航-->
  <div class="navbar">
    <div class="navbar-inner container">
      <a class="brand" href="#">网信平台</a>
      <ul class="nav">
        <li><a href="../index.html">首页</a></li>
        <li><a href="../nms/new.html">网信管理</a></li>
        <li><a href="../nms/templates/index.html">模板</a></li>
        <li><a href="../nms/statistics/index.html">统计</a></li>
        <li class="active"><a href="#">联系人</a></li>
        <li><a href="#">管理员</a></li>
      </ul>
    </div>
  </div>

  <!--内容-->
  <div class="container nms">
    <div class="content">
      <form class="form-horizontal" action="FileUpLoadServlet" enctype="multipart/form-data" method="post">
        <fieldset>
          <legend>批量导入联系人</legend>
          <div class="step" id="download">
            <p class="title">1. 下载联系人模板 </p>
            <p><a href="#" class="btn">Download</a></p>
            <p>小提示：导入联系人文件不能超过1024kb</p>
          </div>
          <div class="step">
            <p class="title">2. 上传联系人模板</a>
            <p>
              <input type="file" name="file1">
              <button class="btn btn-primary" type="submit">提交</button>
            </p>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</body>
</html>
