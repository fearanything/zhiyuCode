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
  <title>海南控股安全隐患管理信息化平台系统-待办</title>
  <link rel="stylesheet" href="frontend/HKrepairs/css/jquery-confirm.css">
  <link rel=stylesheet href=https://res.wx.qq.com/t/wx_fed/weui-source/res/2.5.0/weui.min.css>
  <link rel="stylesheet" href="frontend/HKrepairs/css/reset.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/public.css">
  <link rel="stylesheet" href="frontend/HKrepairs/css/backlog.css">
</head>
    <title>Title</title>
</head>
<body>
<!-- 1. 头部 -->
<header>
  <div class="container">
    <span>海南控股安全隐患管理信息化平台系统</span>
  </div>
</header>

<!-- 2. 内容 -->
<div class="main-content">
  <div class="program-tab">
    <div id="uncommit-tab" class="active" onclick="tab('NO_SUBMITE',this)">
      <img src="frontend/HKrepairs/img/uncommittedBox.png" alt="">
      <p id="num1">${pd.NOT_SUBMITE}</p>
      <span id="text1">未提交</span>
    </div>
    <div id="unfinish-tab" onclick="tab('NO_COMPLETE',this)">
      <img src="frontend/HKrepairs/img/unfinishBox.png" alt="">
      <p id="num2">${pd.NOT_COMPLETE}</p>
      <span id="text2">未完成</span>
    </div>
    <div id="overdue-tab" onclick="tab('OVER_TIME',this)">
      <img src="frontend/HKrepairs/img/overdueBox.png" alt="">
      <p id="num3">${pd.OVER_TIME}</p>
      <span id="text3">已逾期</span>
    </div>
  </div>
  <div class="program-menu">
    <div id="uncommit-list" class="program-list active">

    </div>
  </div>
</div>


<!-- 3. 底部 -->
<footer>
  <%@ include file="foot.jsp"%>
</footer>

<script src="frontend/HKrepairs/js/jquery-3.1.1.min.js?v=1.0.1"></script>
<script src="https://res.wx.qq.com/t/wx_fed/cdn_libs/res/weui/1.2.8/weui.min.js"></script>
<%--<script src="frontend/HKrepairs/js/jquery-confirm.js"></script>--%>
<script src="frontend/HKrepairs/js/wow.min.js?v=1.0.1"></script>
<script src="frontend/HKrepairs/js/public.js?v=1.0.1"></script>
<script src="frontend/HKrepairs/js/select.js?v=1.0.1"></script>
<script>
  $(function () {//第一次进入页面时展示未提交列表
    tab("NO_SUBMITE")
  })

  var currentPage = 0;
  var totalPage = 1;
  var sign;
  function tab(listType,thiss){
    $(thiss).siblings().removeClass('active'); // 所有兄弟节点
    $(thiss).addClass('active');
    if(sign != listType && listType != null && listType != ''){
      currentPage = 0;
      sign = listType;
      $("#uncommit-list").find("*").remove();//每次点击按钮清除数据，因为列表数据是拼接上去的
    }
    if(currentPage < totalPage){
      currentPage += 1;
      $.ajax({//请求列表
        url: "<%=basePath%>frontend/mobile/list",
        type: "GET",
        data:{TYPE:sign,"currentPage": currentPage, "showCount": 10},
        dataType: "json",
        cache: false,
        success: function(res){
          if(res.totalPage >=1){
            totalPage  = res.totalPage;
          }
          for(var i = 0; i < res.list.length; i++){//拼接列表内容
            var listHtml = '';
            listHtml += '<div class="item">';
            listHtml += '<div class="content">';
            listHtml += '<img src="<%=basePath%>';
            listHtml += res.list[i].IMG_1;
            listHtml += '"alt="">';
            listHtml += '<p>'+res.list[i].HIDDEN_DANGER_INFO+'</p>';
            listHtml += '</div>';
            listHtml += '<div class="bottom">';
            listHtml += '<div class="time">';
            listHtml += '<img src="frontend/HKrepairs/img/time-icon.png" alt="">'; //转义符号区分引号
            listHtml += '<span>' + res.list[i].COMMIT_TIME + '</span>';
            listHtml += '</div>';
            listHtml += '<div class="edit-btn">';
            if(res.list[i].IS_SUBMITE == "0"){
              listHtml += '<a onclick="edit(\''+ res.list[i].RECTIFY_ID +'\');" id="edit">'; //转义符号区分引号
              listHtml += '<img src="frontend/HKrepairs/img/bianji-icon.png" alt="">';
              listHtml += '<span>编辑</span></a>';
              listHtml += '<a onclick="del(\''+ res.list[i].RECTIFY_ID +'\');" id="delet">';
              listHtml += '<img src="frontend/HKrepairs/img/shanchu-icon.png" alt="">';
              listHtml += '<span>删除</span></a>';
              listHtml += ' </div> </div> </div>';
            }
            else{
              listHtml += '<a onclick="finish(\''+ res.list[i].RECTIFY_ID +'\');" id="finish">';
              listHtml += '<img src="frontend/HKrepairs/img/wancheng-icon.png" alt="">';
              listHtml += '<span>完成</span></a>';
              listHtml += ' </div> </div> </div>';
            }
            $("#uncommit-list").append(listHtml);
          }
        }
      })
    }

  }

  //修改点击的整改内容
  function edit(RECTIFY_ID){
    window.location.href="<%=basePath%>frontend/mobile/goEdit?RECTIFY_ID="+RECTIFY_ID;
  }

  //删除点击的整改内容
  function del(RECTIFY_ID){
    weui.confirm('是否删除', function () {
      window.location.href="<%=basePath%>frontend/mobile/delete?RECTIFY_ID="+RECTIFY_ID;
    }, function () {
    });

  }

  //修改已完成的界面
  function finish(RECTIFY_ID){
    window.location.href="<%=basePath%>frontend/mobile/goFinish?RECTIFY_ID="+RECTIFY_ID;
  }



</script>
</body>
</html>
