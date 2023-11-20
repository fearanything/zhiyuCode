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
  <title>登录</title>
  <link rel="stylesheet" href="frontend/HKrepairs/css/reset.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/login.css">
  <script src="frontend/HKrepairs/js/jquery-3.1.1.min.js"></script>
</head>
<body>
<!-- 1. 头部 -->
<header>
  <div class="container">
    <span>海南控股</span>
  </div>
</header>

<!-- 2. 登录 -->
<div class="login">
  <div class="system-name">
    <div class="container">
      <img src="frontend/HKrepairs/img/hk-logo2.png" alt="">
      <span style="text-align: center;line-height: 30px;">海南控股安全隐患管理</br>信息化平台系统</span>
    </div>
  </div>
  <form id="login-form">
    <div class="account">
      <img src="frontend/HKrepairs/img/user.png" alt="">
      <input type="text" id="username" name="username" placeholder="请输入用户名">
    </div>
    <div class="password">
      <img src="frontend/HKrepairs/img/shenfenshibierenzheng.png" alt="">
      <div class="box">
        <input type="password" id="userpassword" name="userpassword" placeholder="请输入密码">
        <img onclick="display()" id="eye" src="frontend/HKrepairs/img/browse.png" alt="">
      </div>
    </div>
    <div class="submit">
        <button type="button" id="login-btn" name="login-btn" onclick="severCheck();">登录</button>
    </div>
  </form>
</div>

<!-- 3. 底部技术支持 -->
<!-- <footer>
  <div class="container">
    <img src="frontend/HKrepairs/img/HkZyLogo.png" alt="">
    <span>智宇科技技术支持</span>
  </div>
</footer> -->

<script src="frontend/HKrepairs/js/jquery-3.1.1.min.js"></script>
<script src="frontend/HKrepairs/js/flexible.js?v=1.0.1"></script>
<script type="text/javascript">
  //服务器校验
  function severCheck(){

    if(check()){
      var username = $("#username").val();
      var userpassword = $("#userpassword").val();
      var code = "qq313596790fh"+username+",fh,"+userpassword+"QQ978336446fh"+",fh,";
      $.ajax({
        type: "POST",
        url: '<%=basePath%>/frontend/mobile/login_login',
        data: {KEYDATA:code,tm:new Date().getTime()},
        dataType:'json',
        cache: false,
        success: function(data) {
          if ("success" == data.result) {
            saveCookie();
            window.location.href = "<%=basePath%>frontend/mobile/backlog";
          } else if ("usererror" == data.result) {
            alert("登录系统密码或用户名错误");
          }
        }});
    }
  }

  //客户端校验
  function check() {

    if ($("#username").val() == "") {
      alert("用户名不得为空");
      return false;
    }
    if ($("#userpassword").val() == "") {
      alert("密码不得为空");
      return false;
    }

    return true;
  }

  function saveCookie() {
    if ($("#saveid").attr("checked")) {
      $.cookie('loginname', $("#loginname").val(), {
        expires : 7
      });
      $.cookie('password', $("#password").val(), {
        expires : 7
      });
    }
  }

  function display(){
    if($('#userpassword').attr('type') =="password"){
      $('#userpassword').attr('type' ,'text');
    }
    else{
      $('#userpassword').attr('type' ,'password');
    }

  }
</script>
</body>
</html>