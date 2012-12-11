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
  .desc-text { width:480px; height:5em; }
  .product-list li { width:180px; line-height:1em; float:left; margin:10px 15px; }
  .product-list p { margin:5px 0; }
  .product-list .photo img { width:180px; height:240px; background:#efefef; }
  .product-list .desc { line-height:1.4em; color:#333; padding:5px; background:#efefef; font-size:12px; }
  .product-list .name { font-size:16px; margin:8px 0; }

  #preview { width:320px; height:514px; margin-left:-160px; font-size:17px; }
  #preview .desc { display:none; }
  .wrapper { width:320px; height:460px; overflow:auto; padding:0 0 20px; margin:-15px; }
  #preview .header img { width:100%; height:90px; background:#acacac; }
  #preview .info { text-indent:1.4em; margin:10px 12px; }
  #preview ul { margin:10px 12px; padding:0; }
  #preview li { -webkit-border-radius:5px; -webkit-box-shadow:0 1px 0 rgba(0,0,0,0.3); line-height:1.5em; margin:10px 0; padding:8px 6px 5px; border:1px solid #ccc; background:#fafafa; }
  #preview p { margin:0; }
  #preview .price { font-size:14px; }
  #preview .modal-body { max-height:432px; }
  #preview .photo { text-align:center; }
  #preview .photo img { margin:3px 0 8px; max-width:240px; min-height:100px; background:#efefef; width:240px; height:100px; }
  .modal-body { padding-bottom:0; }
  form { margin:0; }
  h3 { font-weight:normal; }
  </style>
</head>
<body>
  <%@include file="../main_nav.jsp"%>

  <div class="container">
    <form id="form-create-module" action="EmsTemplateServlet" method="post" enctype="multipart/form-data">
      <fieldset>
        <legend>创建宣传模板</legend>
        <div class="control-group">
          <label class="control-label">名称</label>
          <div class="controls">
            <input type="text" id="name" name="name" placeholder="输入模板名称">
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="inputEmail">上传头图</label>
          <div class="controls">
            <input type="file" id="inputName" name="file2">
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="content">专题介绍</label>
          <div class="controls">
            <textarea id="content" name="context" name="desc"></textarea>
          </div>
        </div>
      </fieldset>

      <fieldset>
        <legend>创建展示商品</legend>
        <div class="product-list">
          <ul class="clearfix"></ul>
        </div>
        <p class="add-continue hide"><a href="#product-tpl" role="button" data-toggle="modal" class="btn btn-create-product">继续添加</a></p>
        <p class="empty">暂时还没有商品, 现在去添加<a href="#product-tpl" role="button" class="btn-create-product"  data-toggle="modal">创建商品</a></p>
        <div class="control-group action-group">
          <div class="controls">
            <input type="hidden" name="emsMsgId" value="${emsMsgId}">
            <input type="hidden" name="type" value="addPublicity">
            <input type="hidden" name="product_ids" id="product_ids" value="">
            <button type="submit" class="btn btn-primary">创建模板</button>
            <!--<a class="btn preview-btn" href="#" data-toggle="modal" data-target="#preview">手机上可能看到</a>-->
          </div>
        </div>
      </fieldset>
    </form>
  </div>

  <!--创建商品-->
  <div id="product-tpl" class="modal hide fade">
    <form action="EmsTemplateServlet" id="form-create-product" target="create_product" method="post" enctype="multipart/form-data">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3>创建商品</h3>
      </div>
      <div class="modal-body">
        <div class="product">
          <div class="control-group">
            <label class="control-label">名称</label>
            <div class="controls">
              <input type="text" id="product-name" name="name" placeholder="输入商品名称">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">图片</label>
            <div class="controls">
              <input type="file" name="file1" placeholder="输入模板名称">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">商品介绍</label>
            <div class="controls">
              <textarea class="desc-text" id="product-desc" name="context"></textarea>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">现价</label>
            <div class="controls">
              <input type="text" id="price" name="currentPrice">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">原价</label>
            <div class="controls">
              <input type="text" id="origin_price" name="costPrice">
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <input type="hidden" name="type" id="addCommodity" value="addCommodity">
        <button type="reset" class="hide" id="reset_data">重置</button>
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <button type="submit" class="btn btn-primary">保存</button>
      </div>
    </form>
  </div>

  <!--预览-->
  <div id="preview" class="modal hide fade">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
      <h3>预览模板</h3>
    </div>
    <div class="modal-body">
      <div class="wrapper">
        <div class="header">
          <img src="%src%" />
        </div>
        <div class="content">
          <p class="info"></p>
          <ul></ul>
        </div>
      </div>
    </div>
  </div>

  <xmp id="prodcut-tpl" class="hide">
    <li data-id="%id%">
      <p class="photo"><img src="%image_url%" /></p>
      <p class="name">%name%</p>
      <p class="desc">%desc%</p>
      <p class="price">
        <span class="current-price">现价: ￥%price%</span>
        <span class="origin-price">原价: ￥%origin_price%</span>
      </p>
    </li>
  </xmp>

  <div><iframe name="create_product" class="hide"></iframe></div>

  <script src="javascripts/jquery.min.js"></script>
  <script src="javascripts/bootstrap.min.js"></script>
  <script>
    $('.preview-btn').click(function() {
      var preview = $('#preview');
      preview.find(".info").html($("#content").val() || "这是模板介绍");
      preview.find("ul").html($(".product-list ul").html());
    });

    $('.btn-create-product').click(function() {
      $('#reset_data').click();
      $('#addCommodity').val('addCommodity');
    });

    function create_product(id, image_url) {
      var obj = {
        id: id,
        image_url: image_url,
        name: $('#product-name').val(),
        desc: $('#product-desc').val(),
        price: $('#price').val(),
        origin_price: $('#origin_price').val()
      }, tpl = $("#prodcut-tpl").html();
      $(".product-list ul").append(tpl.replace(/%([^%]+)%/g, function(s,a) { return obj[a]; }));
      if($('.product-list li').length == 1) {
        $('.empty').hide();
        $('.add-continue').show();
      }
    }

    $('#form-create-module').submit(function() {
      var ids = [];
      $(".product-list li").each(function(i,o) {
        ids.push($(o).data('id'));
      });
      $('#product_ids').val(ids.join(","));
    });

    $('#form-create-product').submit(function(){
      $('#product-tpl .close').click();
    });
  </script>
</body>
</html>