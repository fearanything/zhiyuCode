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
  <title>预览</title>
  <link rel="stylesheet" href="frontend/HKrepairs/css/reset.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/public.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/preview.css">
  <link rel=stylesheet href=https://res.wx.qq.com/t/wx_fed/weui-source/res/2.5.0/weui.min.css>
</head>
<body>
<!-- 1. 头部 -->
<header>
  <div class="container">
    <a href="javascript:history.back(-1)">
      <img src="frontend/HKrepairs/img/back-icon.png" alt="">
    </a>
    <span>预览</span>
  </div>
</header>

<!-- 2. 内容 -->
<div class="preview">
  <div class="banner"></div>

  <!-- 公司名 -->
  <div class="company">
    <div class="logo">
      <img src="frontend/HKrepairs/img/img2.png" alt="">
    </div>
    <span>${constPd.ORG_NAME}</span>
  </div>

  <!-- 具体信息 -->
  <div class="detail">
    <!-- 隐患情况 -->
    <div class="danger-text">
      <div class="title">
        <img src="frontend/HKrepairs/img/icon6.png" alt="">
        <span>隐患情况</span>
      </div>
      <div class="text">
        <p>${pd.HIDDEN_DANGER_INFO}</p>
      </div>
    </div>

    <!-- 隐患图片 -->
    <div class="danger-photo">
      <div class="title">
        <img src="frontend/HKrepairs/img/icon7.png" alt="">
        <span>隐患图片</span>
      </div>
      <div class="img">
        <c:forEach items="${pd.IMG_ARR}" var="map" varStatus="vs">
          <img src=" <%=basePath%>${map}" alt="">
        </c:forEach>
      </div>
    </div>

    <!-- 整改措施 -->
    <div class="measure">
      <div class="title">
        <img src="frontend/HKrepairs/img/icon8.png" alt="">
        <span>整改措施</span>
      </div>
      <div class="text">
        <p>${pd.RECTIFY_MEASURES}</p>
      </div>
    </div>

    <!-- 备注 -->
    <div class="measure">
      <div class="title">
        <img src="frontend/HKrepairs/img/icon8.png" alt="">
        <span>备注</span>
      </div>
      <div class="text">
        <p>${pd.REMARK}</p>
      </div>
    </div>


    <!-- 隐患类别 -->
    <div class="category">
      <span>隐患类别</span>
      <i  value=""><c:forEach items="${classifyMap}" var="map" varStatus="vs"><c:if test="${map.key == pd.HIDDEN_DANGER_CLASSIFY}">${map.value}</c:if></c:forEach></i>
      <%--<i>其他类</i>--%>
    </div>
    <!-- 隐患级别 -->
    <div class="level">
      <span>隐患级别</span>
      <i  value=""><c:forEach items="${levelMap}" var="map" varStatus="vs"><c:if test="${map.key == pd.HIDDEN_DANGER_LEVEL}">${map.value}</c:if></c:forEach></i>
    </div>
    <!-- 隐患因素 -->
    <div class="factor">
      <span>隐患因素</span>
      <i  value=""><c:forEach items="${factorMap}" var="map" varStatus="vs"><c:if test="${map.key == pd.HIDDEN_DANGER_FACTOR}">${map.value}</c:if></c:forEach></i>
    </div>
    <!-- 是否完成 -->
    <div class="isFinish">
      <span>是否完成</span>
      <c:if test="${pd.IS_COMPLETE == '1'}"><i>是</i></c:if>
      <c:if test="${pd.IS_COMPLETE == '0'}"><i>否</i></c:if>
    </div>
    <!-- 完成时间 -->
    <div class="finish-time">
      <span>完成时间</span>
      <i>${pd.COMPLETE_TIME}</i>
    </div>
    <!-- 整改投入 -->
    <div class="finish-time">
      <span>整改投入</span>
      <i>${pd.RECTIFY_INVESTMENT}(元)</i>
    </div>


    <!-- 提交、修改按钮 -->
    <%--<div class="btn">
      <c:if test="${pd.IS_SUBMITE == '0'}"><input class="submit-btn" type="button" onclick="perviewSubmit('${pd.RECTIFY_ID}')" value="立即提交">
      <input class="change-btn" type="button"  onclick="goEdit('${pd.RECTIFY_ID}')" value="修改">
      </c:if>
    </div>--%>
  </div>
</div>

<script src="frontend/HKrepairs/js/jquery-3.1.1.min.js?v=1.0.1"></script>
<script src="https://res.wx.qq.com/t/wx_fed/cdn_libs/res/weui/1.2.8/weui.min.js"></script>
<script>
  function perviewSubmit(RECTIFY_ID){
    weui.confirm('是否提交', function () {
      window.location.href="<%=basePath%>frontend/mobile/perviewSubmit?RECTIFY_ID="+RECTIFY_ID;
    }, function () {
    });

  }
  function goEdit(RECTIFY_ID){
    weui.confirm('是否修改', function () {
      window.location.href="<%=basePath%>frontend/mobile/goEdit?RECTIFY_ID="+RECTIFY_ID;
    }, function () {
    });

  }
</script>
</body>
</html>