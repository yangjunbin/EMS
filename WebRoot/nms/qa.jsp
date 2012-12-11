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
  #content { width:640px; height:10em; }
  .questions ul { margin:0 0 10px; list-style:none; border:1px solid #e2e2e2; height:500px; overflow:auto; }
  .questions li { padding:10px; border-bottom:1px solid #e9e9e9; background:#f8f8f8; }
  .questions li.checked .c_q { float:right; color:green; }
  .questions li.hover { background:rgba(255,255,255,0.3); }
  .choosed_questions label { margin:5px 10px; }
  .choosed_questions li { overflow:hidden; border-bottom:1px solid #e9e9e9; margin:10px 0; }
  .container form { margin-bottom:150px; }

  .preview { width:320px; height:514px; margin-left:-160px; border:1px solid #000; font-size:17px; line-height:1.5em; font-size:Arial; border-radius:0; -webkit-border-radius:0; -moz-border-radius:0; }
  .wrapper { width:320px; height:460px; overflow:auto; padding:0 0 20px; }
  .preview .header img { width:100%; height:90px; background:#acacac; }
  .preview .info { text-indent:1.4em; margin:10px 12px; }
  .preview ul { margin:10px 12px; padding:0; }
  .preview li { list-style:none; border-bottom:1px dotted #e2e2e2; padding-top:10px; }
  .preview li:last-child { border:none; }
  .preview label span { margin:0 0 0 5px; word-break:break-all; }
  .preview .title { height: 34px; line-height:34px; padding:0 10px; margin:0; border-bottom:1px solid #efefef; }
  .qa-submit { text-align:center; }
  </style>
</head>
<body>
  <%@include file="../main_nav.jsp"%>

  <div class="container">
    <form action=“EmsTemplateServlet?type=addQa” enctype="multipart/form-data" method="post">
      <fieldset>
        <legend>创建问答模板</legend>
        <div class="control-group">
          <label class="control-label">名称</label>
          <div class="controls">
            <input type="text" name="text" placeholder="输入模板名称">
          </div>
        </div>
        <div class="control-group">
          <label class="control-label">上传头图</label>
          <div class="controls">
            <input type="file" name="image">
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="content">专题介绍</label>
          <div class="controls">
            <textarea id="content" name="context"></textarea>
          </div>
        </div>
      </fieldset>
      <fieldset>
        <legend>选择问题</legend>
        <div class="container-fluid">
          <div class="row-fluid">
            <div class="span6">
              <div class="questions">
                <p class="title">题库</p>
                <ul>
                  <c:forEach var="questionAndAnswer" items="${questionAndAnswers}">
                    <li data-id="${questionAndAnswer.question.id}" data-options='<c:forEach var="answer" varStatus="i" items="${questionAndAnswer.answers}">${i.index}. ${answer.context}</c:forEach>'><span class="q_text">${questionAndAnswer.question.name}</span></li>
                  </c:forEach>
                </ul>
              </div>
            </div>
            <div class="span6">
              <div class="choosed_questions">
                <p class="title">已选择</p>
                <ul></ul>
              </div>
            </div>
          </div>
        </div>

        <div class="control-group action-group">
          <div class="controls">
            <input type="hidden" id="questions_val" name="questions" value="">
            <button type="submit" class="btn btn-primary">创建</button>
            <a class="btn preview-btn" href="#" data-toggle="modal" data-target="#preview">预览</a>
          </div>
        </div>
      </fieldset>
    </form>
  </div>

  <div class="preview modal hide fade" id="preview">
    <div class="title">
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
      预览
    </div>
    <div class="wrapper">
      <div class="header">
        <img src="%src%" />
      </div>
      <div class="content">
        <p class="info"></p>
        <ul></ul>
        <div class="controls-group qa-submit">
          <button class="btn btn-primary">提交问卷</button>
        </div>
      </div>
    </div>
  </div>

  <xmp id="qa-preview-tpl" class="hide">
    <li>
      <p class="q">%q%</p>
      <p>%options%</p>
    </li>
  </xmp>

  <xmp id="qa-tpl" class="hide">
    <li class="choosed_q" data-id="%id%" id="q_%id%">
      <p class="q">%q%</p>
      <p>%options%</p>
    </li>
  </xmp>

  <script src="javascripts/jquery.min.js"></script>
  <script src="javascripts/bootstrap.min.js"></script>
  <script>
  $(document).ready(function() {
    var choosed_questions = [];
    $('.questions li').click(function() {
      var me = $(this);
      if(me.hasClass("checked")) {
        me.removeClass("checked").find(".c_q").remove();
      } else {
        me.addClass("checked").append("<span class='c_q'>✔</span>");
      }
      add_or_remove_q(me);
    }).hover(function() {
      var me = $(this);
      me.addClass('hover');
    }, function() {
      var me = $(this);
      me.removeClass('hover');
    });

    function add_or_remove_q(ele) {
      var options = ele.data("options").split(";"), q = ele.find(".q_text").text(), options_str = "", qid = ele.data("id");
      $(options).each(function(i,o) {
        options_str += "<p><label>" + o + "</label></p>"
      });
      var obj = {
        q: q,
        id: qid,
        options: options_str
      }
      if($('#q_' + qid).length) {
        $('#q_' + qid).remove();
      } else {
        $('.choosed_questions ul').append($("#qa-tpl").html().replace(/%([^%]+)%/g, function(s,a) { return obj[a]; }));
      }
    }

    $('.preview-btn').click(function() {
      var preview = $('#preview'), options_str = "";
      preview.find(".info").html($("#content").val() || "这是模板介绍");
      preview.find("ul").html($(".choosed_questions ul").html());
    });

    $('form').submit(function() {
      var val = [];
      $('.choosed_q').each(function(i,o) {
        val.push($(o).data("id"));
      })
      $('#questions_val').val(val.join(","));
    });
  })
  </script>
</body>
</html>
