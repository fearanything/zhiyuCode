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
    <title>应急响应信息_工程项目</title>
    <link rel="stylesheet" href="<%=basePath%>frontend/css/base.css">
    <script src="<%=basePath%>frontend/js/echarts.min.js"></script>
</head>
<body>
    <!-- 1.头部header开始 -->
    <%@ include file="top.jsp"%>
    <!-- 1.头部header结束 -->


    <!-- 2.中部信息盒子开始 -->
    <div class="content">
        <div class="tabhead">
            <h3 style="font-size: 20pt;">值班信息</h3>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji_shuiba.html">水库大坝</a>
            </h4>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji_gongcheng.html" class="tabActive">在建项目</a>
            </h4>
             <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji_map.html" >地图分布</a>
            </h4>
        </div>
        <div class="pc" id="main">
            <div class="column1" >
                <div class="left">
                    <div class="lefttop" style="margin-top:6px ; margin-bottom:40px;">
                        <p style="color:#FFFFFF;font-size:24pt;margin-left: 1.4rem;">海控2010-2022项目汇总</p>
                    </div>
                    <div class="leftmid" id="chart" style="width:550px; height: 500px; margin-left: 3rem;">
    
    
                    </div>
                    <div class="leftbtm" style="display:flex">
                        
                    </div>
                </div>
    
            </div>
            <div class="column2">
    
                <div class="right" id="box">
                    <ul id="rightul" class="scrollbar">
                    
                     <c:forEach items="${projectsMap}" var="item" varStatus="v">
                       <li class="slrLi">
                       		<h2>${item.PROJECTTYPE_NAME } 数量：${item.PROJECTTYPE_NUM }个</h2>
                       		 <ul>
                       		  <c:forEach items="${item.PROJECT_LIST}" var="project" varStatus="v">
                       			<li>${project.PROJECT_NAME }</li>
                               </c:forEach>
                             </ul>
                       </li>
                      </c:forEach>
                    	
                    </ul>
                </div>
    
            </div>

    
        </div>
    </div>
    <!-- 2.中部信息盒子结束 -->

	<script src="<%=basePath%>/frontend/js/jquery.js"></script>
    <script src="<%=basePath%>frontend/js/scale.js"></script>
 <script src="<%=basePath%>frontend/js/time.js"></script>

     <script>
     var option = {
    		    
    		    tooltip: {
    		        trigger: 'item'
    		    },
    		    legend: {
    		        show: true,
    		        bottom: 20,
    		        itemGap: 30,
    		        color:'#fff',
    		        textStyle: {
    		            color: "#fff",
    		            fontSize:18
    		            }
    		    },
    		    series: [
    		        {

    		            type: 'pie',
    		            radius: '50%',
    		            center: ["50%", "30%"],
    		            selectedMode:'single',
    		            selectedOffset:15,
    		            data: ${PROJECT_STR},
    		            labelLine: {
    		                show: false
    		            },
    		            label: {
    		                show: true,
    		                formatter: "{b|{b}}",
    		                rich: {

    		                    b: {
    		                        color: "#D3EBFF",
    		                        fontSize: 14,
    		                        lineHeight: 20,
    		                        align: 'left',
    		                    }
    		                },
    		                textStyle: {
    		                    color: "#fff",
    		                    align: "right",
    		                    fontSize: 24,
    		                },
    		            },

    		            emphasis: {
    		                itemStyle: {
    		                    shadowBlur: 10,
    		                    shadowOffsetX: 0,
    		                    scaleSize: 0,
    		                }
    		            }
    		        }
    		    ]
    		};

    		//初始化echarts实例
    		var myChart = echarts.init(document.getElementById('chart'));

    		//使用制定的配置项和数据显示图表
    		myChart.setOption(option);
    		myChart.on("click", eConsole);



    		function eConsole(param) {

    		    // alert(option.series[0].data.length);
    		    // alert(option.series[0].data[i]);
    		    //param.dataIndex 获取当前点击索引，
    		    console.log(param, '	1111')
    		    listdata(param.dataIndex)
    		}    
     </script>
     
     <script>
     
     $('.scrollbar h2').click(function () {
         $(this).next().slideDown(500)
         $(this).parent().siblings().find('ul').slideUp(500)
     })
     </script>

    <style>
        #box {

            overflow: auto;
            float: left;

            border: none;
        }

        .scrollbar {

            height: 300px;
            margin: 10px auto;
        }

        #box::-webkit-scrollbar {
            /*滚动条整体样式*/
            width: 10px;
            /*高宽分别对应横竖滚动条的尺寸*/
            height: 1px;
        }

        /*  外部容器样式*/
        .container {
            width: 300px;
            height: 20px;
            line-height: 20px;
        }


        /* 内部加载部分样式 */
        #content {
            height: 20px;

            background-color: rgb(11, 86, 172);
            text-align: center;
            line-height: 20px;
        }

        /* 内部加载部分样式 */
        #content1 {
            height: 20px;

            background-color: rgb(11, 86, 172);
            text-align: center;
            line-height: 20px;
        }

        /* 内部加载部分样式 */
        #content2 {
            height: 20px;

            background-color: rgb(11, 86, 172);
            text-align: center;
            line-height: 20px;
        }

        /* 内部加载部分样式 */
        #content3 {
            height: 20px;

            background-color: rgb(11, 86, 172);
            text-align: center;
            line-height: 20px;
        }

        /* 内部加载部分样式 */
        #content4 {
            height: 20px;

            background-color: rgb(11, 86, 172);
            text-align: center;
            line-height: 20px;
        }

        #box::-webkit-scrollbar-thumb {
            /*滚动条里面小方块*/
            /* border-radius: 10px; */
            box-shadow: inset 0 0 5px rgba(42, 203, 252, 0.2);
            background-color: #006cff;
        }

        #box::-webkit-scrollbar-track {
            /*滚动条里面轨道*/
            box-shadow: inset 0 0 5px rgba(56, 58, 180, 0.2);
            /* border-radius: 10px; */
            border: 1px solid #006cff;
            background-color: #062d82;
        }

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

        /* pc */
        /* .pc {
        width: 1920px;
        height: 1080px;
        display: flex;


        } */

        .column2 .right .slrLi{
            background: url(<%=basePath%>frontend/images/list.png) no-repeat;
            color: #FFFFFF;
            font-size: 16pt;
            margin-bottom: 20px;
            cursor:pointer;
        }

        .column2 .right .slrLi ul{
            display:none;
            padding-right:20px;
            margin-top:10px;
            overflow-y:auto;
            width:900px;
            max-height:400px;
        }

        .slrLi ul::webkit-scrollbar{
            display:none;
        }

        .column2 .right .slrLi ul li{
            padding:4px;
            margin-top:6px;
            background-color:rgba(34,158,246,0.727);
            font-size:26px;
            border-radius:10px;
        }

        img {
            margin-left: 10px;

        }

        .pc .column1 {


            /* border: 1px solid red; */
            flex: 1.3;

        }

        .left {
            /* border: 1px solid yellow; */
            width: 40rem;
            height: 45rem;
            margin: auto;
            margin-top: 6.5rem;
            background: url(<%=basePath%>frontend/images/leftimg.png) no-repeat;
            background-size: 100% 100%;
            display: flex;
            flex-direction: column;

        }

        .right {
            /* border: 1px solid yellow; */
            width: 67rem;
            height: 45rem;
            margin: auto;
            margin-top: 5.5rem;


        }

        .lefttop {
            /* border: 1px solid red; */
            flex: 1;
        }

        .leftmid {
            /* border: 1px solid blue; */
            flex: 5;
        }

        .leftbtm {
            /* border: 1px solid green; */
            flex: 5;
        }

        .pc .column2 {

            /* border: 1px solid red; */
            flex: 1.7;
        }

        .head{

            height: 7rem;
            background-image: url(<%=basePath%>frontend/images/topheadNew.png);
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

        .head ul a:hover{
            color: #20bcfc;
        }

        .content{
            margin: 2rem auto;
            width: 111rem;
            height: 56.2rem;
            background-image: url(<%=basePath%>frontend/images/yingjigongchengBox.png);
        }


        .leftbtm ul{
            margin-left: 3rem;
        }

        .active{
            width: 8rem;
            height: 1.8rem;
            background-color: #002386;
            border: solid .1rem #20bcfc;;
            border-radius: 6px;
        }

        .tabActive{
            width: 11.8rem!important;
            background-image: url(<%=basePath%>frontend/images/yingjiHeadTab.png);
            background-size: cover;
            border: none;
        }

        .tabhead{
            display: flex;
        }

        .tabhead h3{
            background-image: url(<%=basePath%>frontend/images/Tabbox2.png);
            background-size: cover;
            width: 13rem;
            height: 2.5rem;
            line-height: 2.5rem;
            color: #fff;
            padding-left: 1rem;
        }

        .tabhead a{
            margin-left: 6rem;
            width: 10rem;
            line-height: 2.5rem;
            font-size: 16pt;
            font-weight: 400;
            display: inline-block;
            color: #fff;
            text-align: center;
        }

        .tabhead a:hover{
            width: 10rem;
            background-size: cover;
            border-radius: 5px;
            color: #006cff;
            cursor: pointer;
        }


    </style>

</body>
</html>