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
  <meta name=viewport content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
  <title>隐患整改表</title>
  <link rel="stylesheet" href="frontend/HKrepairs/css/select2.min.css">
  <link rel=stylesheet href=https://res.wx.qq.com/t/wx_fed/weui-source/res/2.5.0/weui.min.css>
  <link rel="stylesheet" href="frontend/HKrepairs/css/reset.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/public.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/form-v2.css">
  <style>
    body, html {
      height: 100%;
      /* background-color: var(--weui-BG); */
      color:var(--weui-FG)
    }

    body {
      font-family:-apple-system-font, Helvetica Neue, Helvetica, sans-serif
    }

    .item {
      padding:10px 0
    }

    .item__title {
      margin-bottom: 5px;
      padding-left: 15px;
      padding-right: 15px;
      color: #999;
      font-weight: 400;
      font-size:14px
    }

    .item__ctn {
      padding:0 15px
    }

    .page_feedback {
      padding: 15px;
      overflow: auto;
      background-color:var(--weui-BG)
    }

    label > * {
      pointer-events: none
    }

    .weui-btn_default{
      color: #5b5b5b !important;
    }
  </style>
</head>
<body ontouchstart data-weui-theme="light">
<!-- 1. 头部 -->
<header>
  <div class="container">
    <a href="javascript:history.back(-1)">
      <img src="frontend/HKrepairs/img/back-icon.png" alt="">
    </a>
    <span>隐患整改表</span>
  </div>
</header>

<!-- 2. 内容 -->
<div class="form">
  <%--form表单是根据name属性提交表单--%>
  <form action="frontend/mobile/editFinish" name="Form" id="Form" method="post" enctype="multipart/form-data">
    <input name="RECTIFY_ID" type="hidden" value="${pd.RECTIFY_ID}">


    <input id="ORG_ID" name="ORG_ID" type="hidden" value="${pd.ORG_ID}">
    <!-- 公司名称 -->
    <div class="banner">
      <img class="bn-img" src="frontend/HKrepairs/img/form-banner.png" alt="">
      <div class="company-name">
        <div class="name">
          <img src="frontend/HKrepairs/img/icon1.png" alt="">
        </div>
        <ul id="company-name" style="color: #ffffff">
          ${org.ORG_NAME}
        </ul>
      </div>
    </div>

    <!-- 文件编号 -->
    <label for="FILE_CODE" class="weui-cell weui-cell_active">
      <div class="weui-cell__hd">
        <span class="weui-label">文件编号</span>
      </div>
      <div class="weui-cell__bd weui-flex">
        <input readonly  name="FILE_CODE" id="FILE_CODE" class="weui-input" type="text" placeholder="无" value="${pd.FILE_CODE}" >
      </div>
    </label>

    <!-- 项目名称 -->
    <label for="PROJECT_NAME" class="weui-cell weui-cell_active">
      <div class="weui-cell__hd">
        <span class="weui-label">项目名称</span>
      </div>
      <div class="weui-cell__bd weui-flex">
        <input readonly name="PROJECT_NAME" id="PROJECT_NAME" class="weui-input" type="text" placeholder="无" value="${pd.PROJECT_NAME}">
      </div>
    </label>

    <!-- 负责人 -->
    <label for="PERSON_RESPONSIBLE" class="weui-cell weui-cell_active">
      <div class="weui-cell__hd">
        <span class="weui-label">负责人</span>
      </div>
      <div class="weui-cell__bd weui-flex">
        <input readonly name="PERSON_RESPONSIBLE" id="PERSON_RESPONSIBLE" class="weui-input" type="text" placeholder="无" value="${pd.PERSON_RESPONSIBLE}">
      </div>
    </label>

    <div class="detail">
      <%--<div class="detail-content">--%>
      <!-- 隐患情况 -->
      <div class="danger-text">
        <div class="title">
          <img src="frontend/HKrepairs/img/icon2.png" alt="">
          <span>隐患情况</span>
        </div>
        <textarea readonly name="HIDDEN_DANGER_INFO" id="textarea1" cols="30" rows="10" placeholder="无" type="text">${pd.HIDDEN_DANGER_INFO}</textarea>
      </div>

      <!-- 故障图片 -->
      <div class="danger-photo">
        <div class="weui-cells weui-cells_form" id="uploader">
          <div class="weui-cell">
            <div class="weui-cell__bd">
              <div class="weui-uploader">
                <div class="weui-uploader__hd">
                  <img class="photo-icon" src="frontend/HKrepairs/img/icon4.png" alt="">
                  <p class="weui-uploader__title">故障图片</p>
                  <div class="weui-uploader__info">
                    <span id="uploadCount">0</span>/5
                  </div>
                </div>
                <div class="weui-uploader__bd">
                  <!--在weui-uploader__files加载图片-->
                  <ul class="weui-uploader__files" id="uploaderFiles">
                    <c:forEach items="${pd.IMG_ARR}" var="map" varStatus="vs">
                      <li class="weui-uploader__file" data-id="${10000+vs.index}" role="img"  style="background-image: url('<%=basePath%>${map}')"></li>
                    </c:forEach>
                  </ul><%--
                  <div class="weui-uploader__input-box">
                    <input name="tp" id="uploaderInput" class="weui-uploader__input" type="file" accept="image/*" capture="camera" multiple="">
                  </div>--%>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- 整改措施 -->
      <div class="measure">
        <div class="title">
          <img src="frontend/HKrepairs/img/icon3.png" alt="">
          <span>整改措施</span>
        </div>
        <textarea id="textarea2" name="RECTIFY_MEASURES" cols="30" rows="10" placeholder="无" >${pd.RECTIFY_MEASURES}</textarea>
      </div>


      <!-- 隐患类别 -->
      <input  type="hidden" name="HIDDEN_DANGER_CLASSIFY" id="HIDDEN_DANGER_CLASSIFY" value="${pd.HIDDEN_DANGER_CLASSIFY}">
      <div class="category-box">
        <p>隐患类别</p>
        <%--如果不为空则改变字体且显示内容--%>
          <span  class="weui-btn weui-btn_default" style="color: #222">
            <c:forEach items="${classifyMap}" var="map" varStatus="vs">
              <c:if test="${map.key == pd.HIDDEN_DANGER_CLASSIFY}">${map.value}
              </c:if>
            </c:forEach>
          </span>
      </div>

      <!-- 隐患级别 -->
      <input  type="hidden" name="HIDDEN_DANGER_LEVEL" id="HIDDEN_DANGER_LEVEL" value="${pd.HIDDEN_DANGER_LEVEL}">
      <div class="level-box">
        <p>隐患级别</p>
          <span class="weui-btn weui-btn_default" style="color: #222">
            <c:forEach items="${levelMap}" var="map" varStatus="vs">
              <c:if test="${map.key == pd.HIDDEN_DANGER_LEVEL}">${map.value}
              </c:if>
            </c:forEach>
          </span>
      </div>

      <!-- 隐患因素 -->
      <input  type="hidden" name="HIDDEN_DANGER_FACTOR" id="HIDDEN_DANGER_FACTOR" value="${pd.HIDDEN_DANGER_FACTOR}">
      <div class="factor-box">
        <p>隐患因素</p>
          <span class="weui-btn weui-btn_default" style="color: #222">
            <c:forEach items="${factorMap}" var="map" varStatus="vs">
              <c:if test="${map.key == pd.HIDDEN_DANGER_FACTOR}">${map.value}
              </c:if>
            </c:forEach>
          </span>
      </div>

      <input type="hidden" id="PLAN_COMPLETE_TIME" name="PLAN_COMPLETE_TIME" value="${pd.PLAN_COMPLETE_TIME}">
      <div class="finish-time">
        <p>计划完成时间</p>
          <span  class="weui-btn weui-btn_default">${pd.PLAN_COMPLETE_TIME}</span>
      </div>

        <label for="RECTIFY_INVESTMENT" class="weui-cell weui-cell_active">
          <div class="weui-cell__hd">
            <span class="weui-label">整改投入</span>
          </div>
          <div class="weui-cell__bd weui-flex">
            <input name="RECTIFY_INVESTMENT" id="RECTIFY_INVESTMENT" class="weui-input" type="text" placeholder="请输入整改投入(元)" value="${pd.RECTIFY_INVESTMENT}">
          </div>
        </label>

        <div class="measure">
          <div class="title">
            <img src="frontend/HKrepairs/img/icon3.png" alt="">
            <span>备注</span>
          </div>
          <textarea id="REMARK" name="REMARK" cols="30" rows="10" placeholder="请输入备注" >${pd.REMARK}</textarea>
        </div>


      <%--</div>--%>

      <!-- 保存、下一步 -->
      <div class="btn">
        <input type="hidden" id="IS_COMPLETE" name="IS_COMPLETE" value="">
        <input  id="uploadForm" class="next-btn" type="button" onclick="submitForm('1')" value="立即提交">
      </div>
      <textarea id="saveImg" name="saveImg" value=""></textarea>
  </form>
</div>

<%--如果要在js中使用传入jsp的后端数据，需要在jsp中先声明变量--%>
<script type="text/javascript">
  /*设置默认时间*/
  var time = '${pd.COMPLETE_TIME}';
  /*设置隐患种类、隐患级别、隐患因素需要的json对象*/
  var category = '${classifyJsonList}';
  var level = '${levelJsonList}';
  var factor = '${factorJsonList}';
  var IMG_ARR = '${arrP}';
  var b = '${arrP}';
</script>

<script src="frontend/HKrepairs/js/jquery-3.1.1.min.js?v=1.0.1"></script>
<script src="frontend/HKrepairs/js/select2.min.js?v=1.0.1"></script>
<script src="frontend/HKrepairs/js/select.js?v=1.0.1"></script>
<script type="text/javascript" src="static/js/jquery.tips.js"></script>
<%--<script src="frontend/HKrepairs/js/companySelect.js"></script>--%>
<%--<script src="https://res.wx.qq.com/t/wx_fed/cdn_libs/res/weui/1.2.8/weui.min.js"></script>--%>
<script src="frontend/HKrepairs/js/getPickerData.js?v=1.0.1"></script>

<script>
  var companyList = [];
  $(function (){
    document.getElementById("saveImg").style.display="none";

  })
</script>

<script>
  function submitForm(IS_COMPLETE){
    if($("#textarea2").val()==""){
      $("#textarea2").tips({
        side:3,
        msg:'请输入整改措施',
        bg:'#AE81FF',
        time:2
      });
      $("#ORG_CODE").focus();
      return false;
    }
    $("#IS_COMPLETE").val(IS_COMPLETE)
    $("#Form").submit();
  }

</script>
<script>
  var opt={
    startY:1990, //开始时间
    endY:2050, //结束事件
    mPickerType:1,
    separator:'/' //日期分割符
  }
  /*$('#pickDater').mPickDater(opt);*/

</script>
</body>
</html>