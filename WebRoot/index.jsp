<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(!"success".equals(request.getSession().getAttribute("status")))
{
	request.setAttribute("errorMsg", "请先登陆");
	request.getRequestDispatcher("/error.jsp").forward(request, response);
}
%>
<html>
<head>
  <link rel="stylesheet" href="stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="stylesheets/common.css" />
  <style>
  .container .inner { width:940px; }
  .title { position:relative; }
  .title h2 { font-size:20px; font-weight:normal; border-bottom:1px solid #efefef; margin-bottom:15px; }
  .title .action { position:absolute; right:0; top:5px; }
  </style>
</head>
<body>
  <%@include file="main_nav.jsp"%>

  <!--内容-->
  <div class="container users">
    <div class="title">
      <h2>联系人</h2>
    </div>
    <div class="content">
      共有1923个联系人，12个联系人分组
    </div>
  </div>

  <div class="container nms">
    <div class="title">
      <h2>网信</h2>
      <a class="action btn btn-primary" href="/nms/new.jsp">创建新网信</a>
    </div>
    <div class="content">
      <table class="table table-bordered table-striped">
        <thead>
          <tr>
            <th>序号</th>
            <th>名称</th>
            <th>内容</th>
            <th>时间</th>
            <th>状态</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>zzz</td>
            <td>xxx</td>
            <td>vvv</td>
            <td>bbb</td>
          </tr>
          <tr>
            <td>2</td>
            <td>zzz</td>
            <td>xxx</td>
            <td>vvv</td>
            <td>bbb</td>
          </tr>
          <tr>
            <td>3</td>
            <td>zzz</td>
            <td>xxx</td>
            <td>vvv</td>
            <td>bbb</td>
          </tr>
          <tr>
            <td>4</td>
            <td>zzz</td>
            <td>xxx</td>
            <td>vvv</td>
            <td>bbb</td>
          </tr>
          <tr>
            <td>5</td>
            <td>zzz</td>
            <td>xxx</td>
            <td>vvv</td>
            <td>bbb</td>
          </tr>
        </tbody>
      </table>
      <!--分页-->
      <div class="pagination">
        <ul>
          <li class="disabled"><span>上一页</span></li>
          <li class="active"><span>1</span></li>
          <li><span>2</span></li>
          <li><span>3</span></li>
          <li><span>4</span></li>
          <li><span>下一页</span></li>
        </ul>
      </div>
    </div>
  </div>
</body>
</html>
