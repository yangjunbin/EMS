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
  <%@include file="main_nav.jsp"%>

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
