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
  <link rel="stylesheet" href="frontend/HKrepairs/css/select2.min.css?v=1.0.1">
<%--  <link rel=stylesheet href=https://res.wx.qq.com/t/wx_fed/weui-source/res/2.5.0/weui.min.css?v=1.0.1>--%>
  <link rel="stylesheet" href="frontend/HKrepairs/css/reset.css?v=1.0.1">
  <link rel="stylesheet" href="frontend/HKrepairs/css/public.css?v=1.0.1">
  <%--<link rel="stylesheet" href="frontend/HKrepairs/css/weui.css?v=1.0.1">--%>
  <link rel="stylesheet" href="frontend/HKrepairs/css/weuiTest.css?v=1.0.1">
  <link rel="stylesheet" href="frontend/HKrepairs/css/form-v2.css?v=1.0.1">
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
  <form action="frontend/mobile/${msg}" name="Form" id="Form" method="post" enctype="multipart/form-data">
    <input name="RECTIFY_ID" type="hidden" value="${pd.RECTIFY_ID}">


    <input id="ORG_ID" name="ORG_ID" type="hidden" value="${pd.ORG_ID}">
    <!-- 公司名称 -->
    <div class="banner">
      <img class="bn-img" src="frontend/HKrepairs/img/form-banner.png" alt="">
      <div class="company-name">
        <div class="name">
          <img src="frontend/HKrepairs/img/icon1.png" alt="">
          <select name="sel_menu" id="sel_menu" style="width: 80vw;" >
            <option value=""></option>
          </select>
        </div>
        <ul id="company-name">
        </ul>
      </div>
    </div>



    <div class="detail">
      <%--<div class="detail-content">--%>
        <!-- 文件编号 -->
        <div class="weui-cell">
          <div class="weui-cell__hd">
            <span class="weui-label">文件编号：</span>
          </div>
          <div class="weui-cell__bd">
            <input name="FILE_CODE" id="FILE_CODE" class="weui-input" type="text" placeholder="请输入文件编号" value="${pd.FILE_CODE}">
          </div>
        </div>

        <!-- 项目名称 -->
        <div class="weui-cell">
          <div class="weui-cell__hd">
            <span class="weui-label">项目名称：</span>
          </div>
          <div class="weui-cell__bd">
            <input name="PROJECT_NAME" id="PROJECT_NAME" class="weui-input" type="text" placeholder="请输入项目名称" value="${pd.PROJECT_NAME}">
          </div>
        </div>

        <!-- 负责人 -->
        <div class="weui-cell">
          <div class="weui-cell__hd xing">
            <span>*</span><span class="weui-label">负责人：</span>
          </div>
          <div class="weui-cell__bd">
            <input name="PERSON_RESPONSIBLE" id="PERSON_RESPONSIBLE" class="weui-input" type="text" placeholder="请输入负责人" value="${pd.PERSON_RESPONSIBLE}">
          </div>
        </div>

        <!-- 隐患情况 -->
        <div class="danger-text">
          <div class="title">
            <img src="frontend/HKrepairs/img/icon2.png" alt="">
            <span class="focus">*</span><span>隐患情况</span>
          </div>
          <textarea name="HIDDEN_DANGER_INFO" id="textarea1" cols="30" rows="10" placeholder="请描述具体隐患问题..." type="text">${pd.HIDDEN_DANGER_INFO}</textarea>
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
                    </ul>
                    <div class="weui-uploader__input-box">
                      <input name="tp" id="uploaderInput" class="weui-uploader__input" type="file" accept="image/*" multiple="multiple">
                    </div>
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
          <textarea id="textarea2" name="RECTIFY_MEASURES" cols="30" rows="10" placeholder="请描述具体隐患问题..." >${pd.RECTIFY_MEASURES}</textarea>
        </div>


        <!-- 隐患类别 -->
        <input type="hidden" name="HIDDEN_DANGER_CLASSIFY" id="HIDDEN_DANGER_CLASSIFY" value="${pd.HIDDEN_DANGER_CLASSIFY}">
        <div class="category-box">
          <span class="focus">*</span><p >隐患类别：</p>
          <c:if test="${pd.HIDDEN_DANGER_CLASSIFY == null || pd.HIDDEN_DANGER_CLASSIFY == ''}">
            <a href="javascript:;" id="category-picker" class="weui-btn weui-btn_default">请选择类别...</a>
          </c:if>
          <%--如果不为空则改变字体且显示内容--%>
          <c:if test="${pd.HIDDEN_DANGER_CLASSIFY != null && pd.HIDDEN_DANGER_CLASSIFY != ''}">
            <a href="javascript:;" id="category-picker" class="weui-btn weui-btn_default" style="color: #222">
              <c:forEach items="${classifyMap}" var="map" varStatus="vs">
                <c:if test="${map.key == pd.HIDDEN_DANGER_CLASSIFY}">${map.value}
                </c:if>
              </c:forEach>
              </a>

          </c:if>
        </div>

        <!-- 隐患级别 -->
        <input type="hidden" name="HIDDEN_DANGER_LEVEL" id="HIDDEN_DANGER_LEVEL" value="${pd.HIDDEN_DANGER_LEVEL}">
        <div class="level-box">
          <span class="focus">*</span><p>隐患级别：</p>
          <%--如果为空则不改变字体不显示内容--%>
          <c:if test="${pd.HIDDEN_DANGER_LEVEL == null || pd.HIDDEN_DANGER_LEVEL == ''}">
            <a href="javascript:;" id="level-picker" class="weui-btn weui-btn_default">请选择级别...</a>
          </c:if>
          <%--如果不为空则改变字体且显示内容--%>
          <c:if test="${pd.HIDDEN_DANGER_LEVEL != null && pd.HIDDEN_DANGER_LEVEL != ''}">
            <a href="javascript:;" id="level-picker" class="weui-btn weui-btn_default" style="color: #222">
              <c:forEach items="${levelMap}" var="map" varStatus="vs">
                <c:if test="${map.key == pd.HIDDEN_DANGER_LEVEL}">${map.value}
                </c:if>
              </c:forEach>
            </a>
          </c:if>
        </div>

        <input type="hidden" name="HIDDEN_DANGER_FACTOR" id="HIDDEN_DANGER_FACTOR" value="${pd.HIDDEN_DANGER_FACTOR}">
        <div class="factor-box">
          <span class="focus">*</span> <p>隐患因素：</p>
          <c:if test="${pd.HIDDEN_DANGER_FACTOR == null || pd.HIDDEN_DANGER_FACTOR == ''}">
            <a href="javascript:;" id="factor-picker" class="weui-btn weui-btn_default">请选择因素...</a>
          </c:if>
          <%--如果不为空则改变字体且显示内容--%>
          <c:if test="${pd.HIDDEN_DANGER_FACTOR != null && pd.HIDDEN_DANGER_FACTOR != ''}">
            <a href="javascript:;" id="factor-picker" class="weui-btn weui-btn_default" style="color: #222">
              <c:forEach items="${factorMap}" var="map" varStatus="vs">
                <c:if test="${map.key == pd.HIDDEN_DANGER_FACTOR}">${map.value}
                </c:if>
              </c:forEach>
            </a>
          </c:if>
        </div>

        <!-- 隐患因素 -->


        <div class="finish-box" id="finish-box">
          <p><span class="focus">*</span>是否完成</p>
          <div class="weui-cells weui-cells_radio">
            <label class="weui-cell weui-check__label" for="r1">
              <div class="weui-cell__bd">是</div>
              <div class="weui-cell__ft">
                <input required="" type="radio" class="weui-check" name="IS_COMPLETE" value="1" id="r1" <c:if test="${pd.IS_COMPLETE == '1'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
              </div>
            </label>
            <label class="weui-cell weui-check__label" for="r2" >
              <div class="weui-cell__bd">否</div>
              <div class="weui-cell__ft">
                <input type="radio" name="IS_COMPLETE" class="weui-check" value="0" id="r2" <c:if test="${pd.IS_COMPLETE == '0'}">checked</c:if>>
                <span class="weui-icon-checked"></span>
              </div>
            </label>
          </div>
        </div>

        <input type="hidden" id="PLAN_COMPLETE_TIME" name="PLAN_COMPLETE_TIME" value="${pd.PLAN_COMPLETE_TIME}">
        <div class="finish-time">
          <span class="focus">*</span><p id="PLAN_COMPLETE_TIME_TIP">计划完成时间：</p>
          <%--判断是否有完成时间--%>
          <c:if test="${pd.PLAN_COMPLETE_TIME != null && pd.PLAN_COMPLETE_TIME != ''}">
            <a href=javascript:; id=datePickerBtn style="color: #222" class="weui-btn weui-btn_default">${pd.PLAN_COMPLETE_TIME}</a>
          </c:if>
          <c:if test="${pd.PLAN_COMPLETE_TIME == null || pd.PLAN_COMPLETE_TIME == ''}">
            <a href=javascript:; id=datePickerBtn class="weui-btn weui-btn_default">请选择时间</a>
          </c:if>
        </div>

        <div class="weui-cell">
          <div class="weui-cell__hd">
            <span class="weui-label">整改投入(元)：</span>
          </div>
          <div class="weui-cell__bd">
            <input name="RECTIFY_INVESTMENT" id="RECTIFY_INVESTMENT" class="weui-input" type="text" placeholder="请输入整改投入" value="${pd.RECTIFY_INVESTMENT}">
          </div>
        </div>

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
          <input id="saveForm" class="save-btn" type="button" onclick="submitForm('0')" value="保存">
        <input type="hidden" id="IS_SUBMITE" name="IS_SUBMITE" value="">
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
</script>

<script src="frontend/HKrepairs/js/jquery-3.1.1.min.js?v=1.0.1"></script>
<script src="frontend/HKrepairs/js/select2.min.js?v=1.0.1"></script>
<script src="frontend/HKrepairs/js/select.js?v=1.0.1"></script>
<script type="text/javascript" src="static/js/jquery.tips.js?v=1.0.1"></script>
<%--<script src="frontend/HKrepairs/js/companySelect.js"></script>--%>
<script src="https://res.wx.qq.com/t/wx_fed/cdn_libs/res/weui/1.2.8/weui.min.js"></script>
<script src="frontend/HKrepairs/js/getPickerData.js?v=1.0.1"></script>

<script>
  var companyList = [];
  $(function (){
    document.getElementById("saveImg").style.display="none";

    //下拉框数据

    // 请求公司名数据
    $.ajax({
      type: "GET",
      url: "<%=basePath%>frontend/mobile/getOrgName",
      dataType: "json",
      async: false,
      success: function (res) {
        var companyName = res
        $.each(companyName, function (index, item) {
          companyList.push(
                  {
                    text: item.ORG_NAME,
                    id: item.ORG_ID
                  }
          )
        });
      }
    });
    initSelect2WithSearch();
  })

  /**
   * 初始化select2单选，默认带搜索功能。
   */
  function initSelect2WithSearch() {
    $("#sel_menu").select2({
      tags: true,
      placeholder: '${pd.ORG_NAME}',
      data: companyList,
      allowClear: true
    });
    //获取选中的机构的value
    $("#sel_menu").on("select2:select", function(res){
      var id = $("#sel_menu").select2("val", companyList.id)
      $("#ORG_ID").val(id);
    });
  }
</script>
<script>
  function submitForm(IS_SUBMITE){
    if($("#PERSON_RESPONSIBLE").val()==""){
      $("#PERSON_RESPONSIBLE").tips({
        side:3,
        msg:'请选择负责人',
        bg:'#074ddf',
        time:2
      });
      $("#PERSON_RESPONSIBLE").focus();
      return false;
    }
    if($("#textarea1").val()==""){
      $("#textarea1").tips({
        side:3,
        msg:'请输入隐患情况',
        bg:'#074ddf',
        time:2
      });
      $("#textarea1").focus();
      return false;
    }
    if($("#HIDDEN_DANGER_CLASSIFY").val()==""){
      $("#category-picker").tips({
        side:3,
        msg:'请输入隐患类别',
        bg:'#074ddf',
        time:2
      });
      $("#category-picker").focus();
      return false;
    }
    if($("#HIDDEN_DANGER_LEVEL").val()==""){
      $("#level-picker").tips({
        side:3,
        msg:'请输入隐患级别',
        bg:'#074ddf',
        time:2
      });
      $("#level-picker").focus();
      return false;
    }
    if($("#HIDDEN_DANGER_FACTOR").val()==""){
      $("#factor-picker").tips({
        side:3,
        msg:'请输入隐患因素',
        bg:'#074ddf',
        time:2
      });
      $("#factor-picker").focus();
      return false;
    }
    if(!$('[name="IS_COMPLETE"]').is(':checked')){
      $('#finish-box').tips({
        side:3,
        msg:'请选择是否完成',
        bg:'#074ddf',
        time:2
      });
      $('#finish-box').focus();
      return false;
    }
    if($("#PLAN_COMPLETE_TIME").val()==""){
      $("#PLAN_COMPLETE_TIME_TIP").tips({
        side:3,
        msg:'请选择计划完成时间',
        bg:'#074ddf',
        time:2
      });
      $("#PLAN_COMPLETE_TIME").focus();
      return false;
    }
    $("#IS_SUBMITE").val(IS_SUBMITE)
    $("#Form").submit();
  }

</script>
<script>
  const uploadImg = () => {
    /* 图片自动上传  AlreadyImg辅助数组记录id*/
    var uploadCount = 0, uploadList = [],AlreadyImg = [];
    var insertIndex = 0;//用于在网页时插入的图片下标
    if(IMG_ARR != null && IMG_ARR != ''){
      //插入已经有的图片地址
      data=JSON.parse(IMG_ARR);
      $.each(data, function (index, item) {
        uploadList.push(item);
      });
      // 进入edit的时候先赋值，保存已经有的图片地址
      var base64url = null;
      for(var i = 0;i<uploadList.length;i++){
        AlreadyImg.push(i+10000);
        base64url += "。"+uploadList[i];
      }
      $("#saveImg").text(base64url);
    }

    /*获取uploadCount元素*/
    var uploadCountDom = document.getElementById("uploadCount");
    weui.uploader('#uploader', {
      //自动上传图片会显示上传失败
      url: '<%=basePath%>frontend/mobile/test',
      auto: false,
      type: 'base64',
      fileVal: 'fileVal',
      compress: {
        width: 1600,
        height: 1600,
        quality: .8
      },
      //轮询文件,文件添加前的回调
      onBeforeQueued: function(files) {
        if(["image/jpg", "image/jpeg", "image/png", "image/gif"].indexOf(this.type) < 0){
          weui.alert('请上传图片');
          return false;
        }
        if(this.size > 10 * 1024 * 1024){
          weui.alert('请上传不超过10M的图片');
          return false;
        }
        if (files.length > 5) { // 防止一下子选中过多文件
          weui.alert('最多只能上传5张图片，请重新选择');
          return false;
        }
        if (uploadCount + 1 > 5) {
          weui.alert('最多只能上传5张图片');
          return false;
        }

        ++uploadCount;
        uploadCountDom.innerHTML = uploadCount;
      },
      //每个文件添加成功的回调
      onQueued: function(){

        //uploadList放入图片的base64
        insertIndex++;
        AlreadyImg.push(insertIndex);
        uploadList.push(this.base64);
        var base64url = '';
        for(var i = 0;i<uploadList.length;i++){
          base64url += "。"+uploadList[i];
        }
        $("#saveImg").text(base64url);
      },
      //文件上传前调用
      onBeforeSend: function(data, headers){
      },
      //上传进度的回调
      onProgress: function(procent){
      },
      onSuccess: function (ret) {
      },
      onError: function(err){
      }
    });

    // 缩略图预览,跟添加图片没有关系
    document.querySelector('#uploaderFiles').addEventListener('click', function(e){
      var target = e.target;

      while(!target.classList.contains('weui-uploader__file') && target){
        target = target.parentNode;
      }
      if(!target) return;

      var url = target.getAttribute('style') || '';
      var id = target.getAttribute('data-id');

      if(url){
        url = url.match(/url\((.*?)\)/)[1].replace(/"/g, '');
      }
      var gallery = weui.gallery(url, {
        className: 'custom-name',
        onDelete: function(){
          weui.confirm('确定删除该图片？', function(res){
            --uploadCount;
            uploadCountDom.innerHTML = uploadCount;

            var index = id;
            for(var i = 0;i<AlreadyImg.length;i++){
              /*console.log("index：",index,"AlreadyImg:",AlreadyImg[i])*/
              if(AlreadyImg[i] == index){
                index = i;
              }
            }
            AlreadyImg.splice(index,1);
            uploadList.splice(index,1);
            var base64url = '';
            for(var i = 0;i<uploadList.length;i++){
              base64url += "。"+uploadList[i];
            }
            $("#saveImg").text(base64url);

            for (var i = 0, len = uploadList.length; i < len; ++i) {
              var file = uploadList[i];
              if(file.id == id){

                file.stop();
                break;
              }
            }
            target.remove();
            gallery.hide();
          });
        }
      });
    });
  }

  uploadImg()
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

