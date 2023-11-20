<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
 %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <title>水库大坝</title>
    <link rel="stylesheet" href="<%=basePath%>frontend/css/base.css">
</head>
<body id="main">
    <!-- 1.头部header开始 -->
    <%@ include file="top.jsp"%>
    <!-- 1.头部header结束 -->


    <!-- 2.中部信息盒子开始 -->
    <form action="yingji_shuiba.html" name="Form" id="Form" method="post">
    <input type="hidden" name="RESERVOIR_ID" id="RESERVOIR_ID" value="${pd.RESERVOIR_ID}"/>
     <input type="hidden" name="DATE_ID" id="DATE_ID" value="${pd.DATE_ID}"/>
    <div class="yingji">
        <div class="yingjiTitle">
            <h3 style="font-size: 22pt;">值班信息</h3>
        </div>
        <div class="yingjiMsgTitle" style="display:flex ;">
            <a href="<%=basePath%>yjfhmFrontend/yingji_shuiba.html" class="tabActive">水库大坝</a>
            <a href="<%=basePath%>yjfhmFrontend/yingji_gongcheng.html">在建项目</a>
            <a href="<%=basePath%>yjfhmFrontend/yingji_map.html" >地图分布</a>
        </div>
       
        <div class="jiankongMsg">
            <div class="left" style="width:550px; height:550px;">
                <p style="margin: 40px auto;width: 500px; height: 120px; font-size: 16pt;">
                    ${reservoir.RESERVOIR_INFO }
                </p>
            </div>
            <div class="right" style="display: flex; flex-direction: column;margin-right:80px;">
                <div>
                    <select  name="RESERVOIR_ID" id="RESERVOIR_ID" style="width:200px;height:40px; font-size:18pt;" onchange="func()" >
						<c:forEach items="${reservoirList}" var="data" varStatus="vs">
						  <option value="${data.RESERVOIR_ID }" <c:if test="${data.RESERVOIR_ID == reservoir.RESERVOIR_ID }">selected</c:if> >${data.RESERVOIR_NAME}</option>
						</c:forEach>
					</select>
					 <select  name="DATE_ID" id="DATE_ID" style="width:200px;height:40px; font-size:18pt;" onchange="func()" >
						  <option value="-0" <c:if test="${pd.DATE_ID == '-0' }">selected</c:if>>近一天</option>
						  <option value="-1" <c:if test="${pd.DATE_ID == '-1' }">selected</c:if>>近二天</option>
						  <option value="-2" <c:if test="${pd.DATE_ID == '-2' }">selected</c:if>>近三天</option>
						  <option value="-6" <c:if test="${pd.DATE_ID == '-6' }">selected</c:if>>近一周</option>
					</select>
                </div>
                
                <div class="shuiweiChart" style="margin-top: 100px;">
                    <div id="lChart" style="width: 950px;height:460px;"></div>
                </div>
            </div>
        </div>
        
    </div>
    </form>
    <!-- 2.中部信息盒子结束 -->


    <script src="<%=basePath%>frontend/js/jquery.js"></script>
    <script src="<%=basePath%>frontend/js/echarts.min.js"></script>
    <script src="<%=basePath%>frontend/js/scale.js"></script>
    <script src="<%=basePath%>frontend/js/time.js"></script>
    <script>
        let nav = document.querySelector('.nav')
        let xiala = document.querySelector('.nav ul')
        nav.addEventListener('mouseenter',function(){
            xiala.style.display = 'block'
        })
        nav.addEventListener('mouseleave',function(){
            xiala.style.display = 'none'
        })
        
        
    </script>
    <script>
		function func(){
		//获取被选中的option标签
		   var RESERVOIR_ID = $('select option:selected').val();
		   var DATE_ID = $('select option:selected').val();
		   $('RESERVOIR_ID').val(RESERVOIR_ID);
		   $('DATE_ID').val(DATE_ID);
		   $("#Form").submit();
		}
</script>
<script>
    debugger;
     var chartDom = document.getElementById('lChart');
     var myChart = echarts.init(chartDom);
     var option;
     var WATER_DATA = ${WATER_DATA_STR};
     WATER_DATA.push(${WATER_MAX});
     var WATER_DATA_max = Math.max.apply(Math, WATER_DATA);
     var WATER_DATA_min = Math.min.apply(Math, WATER_DATA);
     option = {
         title:{
             text: "${lineChartDate}",
             left: "center",
             textStyle:{
                 color:'#fff',
                 fontSize: 30
             },
         },
         legend:{
             textStyle:{
                 color: "#fff",
                 fontSize:30
             }
         },
         color:{
             type: 'linear',
             x: 0,
             y: 0,
             x2: 0,
             y2: 1,
             colorStops: [{
                 offset: 0, color: 'yellow' // 0% 处的颜色
             }, {
                 offset: 1, color: 'blue' // 100% 处的颜色
             }],
             global: false // 缺省为 false
         },
         tooltip:{
                 trigger:'axis'
             },
         xAxis: {
             type: 'category',
             boundaryGap: false,
             data: ${WATER_DATETIME_STR},
             name:'（时间）',
             nameTextStyle:{
                 fontSize:20
             },
             axisLine:{
                 show:true,
                 lineStyle:{
                     color:'#fff',
                 },
             },
             axisLabel:{
                 show:true,
                 textStyle:{
                     color:'#fff',
                     fontSize:20,
                     padding:4
                 },
                 
             }
         },
         yAxis: {
             type: 'value',
             min: function(value){
            	 return Math.floor(WATER_DATA_min) - 20
             },
             max: function(value){
            	 return Math.ceil(WATER_DATA_max)
             },
             name:'（米）',
             nameTextStyle:{
                 fontSize:20,
                 fontWeight:700
             },
             axisLine:{
                 show:true,
                 lineStyle:{
                     color:'#fff',
                 },
             },
             axisLabel:{
                 show:true,
                 textStyle:{
                     color:'#fff',
                     fontSize:20
                 }
             }
         },
         series: [
             {
             data: ${WATER_DATA_STR},
             type: 'line',
             areaStyle: {},
             markLine: {
                 data: [{
                     yAxis: ${WATER_LEVEL},
                     
                 }],
                 label:{
                	 show:true,
                	 formatter:"警戒水位",
                	 fontSize:20,
                	 color:'red'
                 },
                 silent: true,
                 animation: true,
                 animationDuration: 2000,
                 lineStyle:{
                     color:'red',
                     type: 'solid',
                     width:2
                 }
                 }
             }
         ]
         };
         myChart.setOption(option);
     </script>
    <style>
        html {
        width: 100%;
        height: 100%;
    }

    body {
        width: 1920px;
        height: 1080px;
        display: flex;
        flex-direction: column;
        margin: 0px;
        background: url(<%=basePath%>frontend/images/bgc2.jpg) no-repeat;
        background-size: 100% 100%;

    }
    
    .active{
        width: 8rem;
        height: 1.8rem;
        background-color: #002386;
        border: solid .1rem #20bcfc;;
        border-radius: 6px;
    }

    .head{
        position: relative;
        height: 7rem;
        display: flex;
        flex-direction: column;
    }

    .head h1{
        margin-top: 1rem;
        margin-bottom: 4px;
        display: flex;
        justify-content: center;
        color: #fff;
        font-size: 28pt;
        background-image: url(<%=basePath%>frontend/images/header.png);
        background-size: 100% 100%;
    }

    .head ul{
        
        display: flex;
        justify-content: center;
        margin: 0;
        
    }

    .head ul a{
        float: left;
        width: 8rem;
        text-align: center;
        font-size: 1.2rem;
        color: #fff;
    }

    .head ul a:hover{
        color: #20bcfc;
    }

    .head .nav ul{
        width: 8rem;
        height: 7.5rem;
        background-color: rgba(255, 255, 255, 0);
        border-radius:6px;
    }

    .head .nav ul li a{
        margin-top: 15px;
        padding-bottom: 15px;
        height: 30px;
        line-height: 30px;
        background-color: #002386;
        border: 1px solid #20bcfc;
        border-radius:6px;
    }
    .head ul::after{
        content: '';
        position: absolute;
        bottom: 0;
        left: 25.5%;
        width: 50%;
        height: 5px;
        background-image: url(<%=basePath%>frontend/images/nav-after.png);
        background-size: 100% 100%;
    }

    .yingji{
        padding: 60px 0;
        position: relative;
        margin: 2rem auto;
        width: 111rem;
        height: 56.2rem;
        background-image: url(<%=basePath%>frontend/images/subPage-bg.png);
        background-size: 100% 100%;
        box-sizing: border-box;
    }

    .times{
        margin-left: 120px;
        margin-top: 20px;
        font-size: 20pt;
        color: #fff;
    }
    .yingji .yingjiTitle{
        position: absolute;
        top: -1%;
        left: 42%;
        padding: 0.125rem 0.9375rem;
        background-image: url(<%=basePath%>frontend/images/qiXiangXinXi-title.png);
        background-size: 100% 100%;
        background-repeat: no-repeat;
        box-sizing: border-box;
    }
    .yingji .yingjiTitle h3{
        width: 13rem;
        height: 2.5rem;
        line-height: 2.5rem;
        font-size: 22pt;
        text-align: center;
        color: #fff;
    }

    .tabActive{
        background-color: #0079e6;
        color: #fff !important;
        border: none;
    }
    .yingjiMsgTitle{
        display: flex;
        margin: 0 auto;
        border-radius: 12px;
        overflow: hidden;
    }

    .yingjiMsgTitle a{
        padding: 0 30px;
        display: inline-block;
        line-height: 2.5rem;
        font-size: 1.2rem;
        font-weight: 400;
        color: #fff;
        text-align: center;
        box-sizing: border-box;
        border: 1px solid #006cff;
    }

    .yingjiMsgTitle a:hover{
        color: #0079e6;
        cursor: pointer;
    }


    .jiankongMsg{
        margin-top: 3rem;
        display: flex;
        justify-content: space-around;
    }

    .yingji .left{
        display: flex;
        flex-direction: column;
        width: 25%;
        height: 550px;
        background-image: url(<%=basePath%>frontend/images/shuikubox.png);
        background-size: cover;
        border-radius: 1rem;
    }

    .yingji .left .mid a{
        margin-bottom: .3rem;
        display: inline-block;
        width: 13rem;
        height: 3rem;
        line-height: 3rem;
        text-align: center;
        font-size: 1.2rem;
        color: #fff;
        background-color: #023197;
    }

    .yingji .left .bottom{
        display: flex;
        padding-left: 1.5rem;
        padding-top: 1rem;
    }


    .menu_list dl{
        padding-left: 20px;
        width: 280px;
        height: 40px;
        background-color: #002386;
        border: 1px solid #20bcfc;
        border-radius: 5px;
        color: #fff;
        font-size: 20pt;
    }
     .menu_body a{
        display: block;
        overflow: hidden;
        height: 0;
        color: #fff;
        z-index: 999;
        transition: all .3s;
    }  

    .yingji .right .top select{
        width: 280px;
        height: 40px;
        font-size: 18pt;
        color: #fff;
        background-color: #002386;
        border: 1px solid #20bcfc;
        border-radius: 5px;
    }

    .yingji .right .mid img{
        margin-left: .6rem;
        margin-top: .5rem;
        width: 17.6rem;
        height: 11rem;
    }

    .yingji .right .bottom span{
        margin-right: 2rem;
        font-size: 1.2rem;
        color: #fff;
    }
    
    </style>
</body>
</html>