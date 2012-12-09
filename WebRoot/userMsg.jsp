<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
.container .inner {
	width: 940px;
}

.title {
	position: relative;
}

.title h2 {
	font-size: 20px;
	font-weight: normal;
	border-bottom: 1px solid #efefef;
	margin-bottom: 15px;
}

.title .action {
	position: absolute;
	right: 0;
	top: 5px;
}

.table .action {
	width: 140px;
}
</style>
</head>
<body>
	<!--导航-->
	<div class="navbar">
		<div class="navbar-inner container">
			<a class="brand" href="#">网信平台</a>
			<ul class="nav">
				<li><a href="#">首页</a>
				</li>
				<li><a href="#">网信管理</a>
				</li>
				<li><a href="#">模板</a>
				</li>
				<li class="active"><a href="#">联系人</a>
				</li>
				<li><a href="#">管理员</a>
				</li>
			</ul>
		</div>
	</div>

	<!--内容-->
	<div class="container nms">
		<div class="title">
			<h2>联系人</h2>
			<div class="action">
				<a class="btn btn-primary" href="#">创建新联系人</a> <a
					class="btn btn-inverse" href="#">批量导入</a>
			</div>
		</div>
		<div class="content">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>名称</th>
						<th>电话</th>
						<th class="action">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="userMsg" items="${userMsgs}">
						<tr>
							<td>${userMsg.name}</td>
							<td>${userMsg.phoneNumber}</td>
							<td><a href="UserMsgServlet?type=del&id=${userMsg.id}"
								class="btn">删除</a> <a
								href="UserMsgServlet?type=edit&username=${userMsg.name}&tel=userMsg.phoneNumber&id=${userMsg.id}"
								class="btn">修改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!--分页-->
			<div class="pagination">
				<ul>
					<li class="disabled"><span>上一页</span>
					</li>
					<li class="active"><span>1</span>
					</li>
					<li><a href="#"><span>2</span>
					</a>
					</li>
					<li><a href="#"><span>3</span>
					</a>
					</li>
					<li><a href="#"><span>4</span>
					</a>
					</li>
					<li><span>下一页</span>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
