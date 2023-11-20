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
  <title>Document</title>
  <link rel="stylesheet" href="frontend/HKrepairs/css/reset.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/public.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/myself.css">
</head>
<body>
<!-- 1. 头部 -->
<header>
  <div class="container">
    <a href="<%=basePath%>frontend/mobile/myself">
      <img src="frontend/HKrepairs/img/back-icon.png" alt="">
    </a>
    <span>已完成</span>
  </div>
</header>

<!-- 2. 内容 -->
<div name="list-box" id="list-box" class="list-box">

</div>

<!-- 3. 底部 -->
<footer>
  <%@ include file="foot.jsp"%>
</footer>

<script src="frontend/HKrepairs/js/jquery-3.1.1.min.js"></script>
<script>
  $(function(){
    tab()
  })

  var currentPage = 0;
  var totalPage = 1;
  function tab(){
    if(currentPage < totalPage) {
      currentPage += 1;
      $.ajax({
        type: "GET",
        data:{"currentPage": currentPage, "showCount": 10},
        url: "<%=basePath%>frontend/mobile/getFinishList",
        dataType: "json",
        async: false,
        success: function (res) {
          if(res.totalPage >=1){
            totalPage  = res.totalPage;
          }
          for(var i = 0; i < res.list.length; i++){
            var listHtml = '';
            listHtml += '<a onclick="goPreview(\''+ res.list[i].RECTIFY_ID +'\');" class="item">';
            listHtml += '<div class="content">';
            listHtml += '<img src="';
            listHtml += res.list[i].IMG_1;
            listHtml += '" alt="">';
            listHtml += '<div class="text">';
            listHtml += '<p>'+res.list[i].HIDDEN_DANGER_INFO+'</p>';
            listHtml += '<div class="time">';
            listHtml += '<img src="frontend/HKrepairs/img/time-icon.png" alt="">';
            listHtml += '<span>'+ res.list[i].COMMIT_TIME + '</span>';
            listHtml += '</div> </div> </div> </a>';
            $("#list-box").append(listHtml);
          }
        }
      });
    }

  }

  function goPreview(RECTIFY_ID){
    window.location.href = "<%=basePath%>frontend/mobile/goPreview?RECTIFY_ID=" + RECTIFY_ID;
  }
</script>
</body>
</html>