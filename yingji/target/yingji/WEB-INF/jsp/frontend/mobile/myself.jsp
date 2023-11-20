<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <base href="<%=basePath%>">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>我的</title>
  <link rel=stylesheet href=https://res.wx.qq.com/t/wx_fed/weui-source/res/2.5.0/weui.min.css>
  <link rel="stylesheet" href="frontend/HKrepairs/css/reset.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/public.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/myself.css">
</head>
<body>
<!-- 1. 头部 -->
<header>
  <div class="container">
    <span>我的</span>
  </div>
</header>

<div class="finish">
  <div class="banner">
    <img src="frontend/HKrepairs/img/form-banner.png" alt="">
  </div>

  <div class="finish-list">
    <a href="<%=basePath%>frontend/mobile/itemList" class="list-item">
      <img src="frontend/HKrepairs/img/quanlingyuguimo.png" alt="">
      <span>所有隐患</span>
    </a>
    <a href="<%=basePath%>frontend/mobile/finishList" class="list-item">
      <img src="frontend/HKrepairs/img/wendang.png" alt="">
      <span>已完成</span>
    </a>
  </div>

  <div class="log-out">
    <a href="javascript:;" id="confirmBtn" class="weui-btn weui-btn_default">退出登录</a>
  </div>
</div>

<!-- 3. 底部 -->
<footer>
  <%@ include file="foot.jsp"%>
</footer>

<script src="frontend/HKrepairs/js/jquery-3.1.1.min.js?v=1.0.1"></script>
<script src="https://res.wx.qq.com/t/wx_fed/cdn_libs/res/weui/1.2.8/weui.min.js"></script>
<script>
  document.querySelector('#confirmBtn').addEventListener('click', function () {
    weui.confirm('是否退出登录', function () {
      window.location.href = "<%=basePath%>frontend/mobile/myselfToLogin"
    }, function () {
    });
  });
</script>
</body>
</html>