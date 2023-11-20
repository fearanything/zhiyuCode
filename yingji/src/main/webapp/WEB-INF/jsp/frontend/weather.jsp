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
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=yes,shrink-to-fit=no">
    <meta http-equiv="Page-Enter" content="blendTrans(Duration=0.5)" /> 
    <meta http-equiv="Page-Exit" content="blendTrans(Duration=0.5)" />
    <title>气象信息</title>
    <link rel="stylesheet" href="<%=basePath%>frontend/css/base.css">
</head>
<body id="main">
    <!-- 1.头部header开始 -->
    <%@ include file="top.jsp"%>
    <!-- 1.头部header结束 -->


    <!-- 2.中部内容开始 -->
    <div class="content">
        <div class="top" style="margin-bottom:7rem ;">
            <h2>常态信息</h2>
        </div>
        <div class="weatherMsg">
            <div class="left">
                <div class="times" style="height: 50px; line-height: 50px; font-size: 18pt; color: #fff; text-align: center;"></div>
                <a href="<%=basePath%>frontend/yingji.html" class="xiangYinglevel">
                    <div class="company">
                        <img src="<%=basePath%>frontend/images/HKlogo.png" alt="" style="height: 2rem;">
                        <h3 style="font-size:4rem; color: #fff; line-height: 6rem; width: 150px; height: 149px;">海南控股</h3>
                    </div>
                    <div class="level">
                        <p style="font-size:4.5rem ; color: #0096ff;">应急响应</p>
                        <h3 style="width:18rem ;height: 7rem;line-height: 7rem; font-size: 6.5rem; text-align: center; background-color: #ffb400; border-radius: 1rem;">${answer.ANSWER_LEVEL} 级</h3>
                    </div>
                </a>
                <div class="temp-msg">
                    <div class="title">今日气温</div>
                    <div class="weatherBox" style="display:flex ;">
                        <h4 style="width: 90px;line-height: 100px;font-size:1.8rem ; color: #fff; font-weight: 400; text-align: center;">今日</h4>
                        <div class="wendu" style="margin-left: 30px;">
                            <p style="font-size: 16pt; width:380px; padding-top:20px;">${weatherStr}</p>
                        </div>
                    </div>
                    <a target="_blank" href="http://hi.cma.gov.cn" class="guanwangBox" style="display: flex;justify-content: space-between;padding:1rem ;">
                        <img src="<%=basePath%>frontend/images/qixianglogo.png" alt="" style="width:4rem ; margin-top: .5rem;">
                        <p style="font-size: 24pt; color: #fff; line-height: 70px;">海南气象局</p>
                        <p style="color:#fff ; font-size: 20pt; line-height: 70px;">详细了解更多 ></p>
                    </a>
                </div>
               
            </div>
            <div class="right">
                <div class="topbtn">
                    <button id="meteo"><img src="<%=basePath%>frontend/images/shikuangicon.png" alt="">台风实况</button>
                </div>
               
                <div class="taifengLink">
                    <iframe id="ifr_live" class="map_frame" frameborder="no" border="0" scrolling="no" src="https://tf.istrongcloud.com/" width="836" height="447" style="display:block; margin:20px auto;"></iframe>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- 2.中部内容结束 -->


    <script src="<%=basePath%>frontend/js/jquery.js"></script>
    <script src="<%=basePath%>frontend/js/scale.js"></script>
    <script src="<%=basePath%>frontend/js/time.js"></script>
    <script>
        let meteo = document.getElementById('meteo')
        let typhoon = document.getElementById('typhoon')
        let live = document.getElementById('ifr_live')
        let map = document.getElementById('ifr_map')
        typhoon.addEventListener('click',function(){
            live.style.display = 'none'
            map.style.display = 'block'
        })
        meteo.addEventListener('click',function(){
            map.style.display = 'none'
            live.style.display = 'block'
        })
    </script>

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
        background: url(<%=basePath%>frontend/images/background.png) no-repeat;
        background-size: 100% 100%;
        /* transform: scale(1,1);
        -ms-transform: scale(1,1); 
        -webkit-transform: scale(0.8,0.8);  */
        zoom: 1;
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
    .head ul::after{
        content: '';
        position: absolute;
        bottom: 0;
        left: 25.5%;
        width: 50%;
        height: .5rem;
        background-image: url(<%=basePath%>frontend/images/nav-after.png);
        background-size: 100% 100%;
    }

    .head ul a{
        float: left;
        width: 8rem;
        text-align: center;
        font-size:1.2rem;
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

    .content{
        position: relative;
        margin: 2rem auto;
        width: 90%;
        height: 900px;
        background-image: url(<%=basePath%>frontend/images/subPage-bg.png);
        background-size: 100% 100%;
        
    }

    .content .top{
        display: flex;
        justify-content: space-between;
        position: absolute;
        top: -1%;
        left: 42%;
        padding: 0.125rem 0.9375rem;
        background-image: url(<%=basePath%>frontend/images/qiXiangXinXi-title.png);
        background-size: 100% 100%;
        background-repeat: no-repeat;
        font-size: 0.375rem;
        box-sizing: border-box;
    }

    .content h2{
        width:13rem ; 
        height: 2.5rem; 
        line-height: 2.5rem;
        font-size: 22pt;
        text-align: center;
        color: #fff;
    }

    .content .top p{
        color: #fff;
        padding-right: 1rem;
        line-height: 2.5rem;
    }

    .weatherMsg{
        padding-top: 100px;
        display: flex;
        justify-content: center;
    }

    .weatherMsg .left{
        display: flex;
        flex-direction: column;
        margin-right: 40px;
        width: 584px;
        height: 545px;
    }

    .weatherMsg .left .xiangYinglevel{
        padding: 20px;
        display: flex;
        justify-content: center;
        margin: 10px 0 20px 0;
        background-color: #0a56c8;
        box-sizing: border-box;
        border-radius: 12px;
    }

    .temp-msg{
        background-image: url(<%=basePath%>frontend/images/index-levelBox-bg.png);
        background-size: 100% 100%;
    }
    .temp-msg .title{
        margin-bottom: 20px;
        padding-left: 15px;
        font-size: 18pt;
        color: #fff;
        background-image: url(<%=basePath%>frontend/images/title-bg3.png);
        background-size: 100% 100%;
    }

    .weatherMsg .left .xiangYinglevel:hover{
        transition: all 1s;
        transform: scale(1.2);
    }

    .xiangYinglevel .company{
        margin-right: 15px;
    }

    .taifengList{
        padding: 1rem;
        width: 39.1rem;
        height: 28.28rem;
        background-image: url(<%=basePath%>frontend/images/taifengList.png);
        background-size: cover;
    }

    .taifengList li{
        margin-top: 1rem;
    }

    .weatherMsg .left .weatherBox{
        padding: 20px 0;
        margin: 0 auto;
        width: 500px;
        height: 101.5px;
        background-image: url(<%=basePath%>frontend/images/weather.png);
        background-size: cover;
    }

    .weatherMsg .left .guanwangBox{
        margin: 20px auto;
        width: 505px;
        height: 102px;
        background-image: url(<%=basePath%>frontend/images/index-levelBox.png);
        background-size: 100% 100%;
    }

    .weatherMsg .left .guanwangBox:hover{
        transition: all 1s;
        transform: scale(1.2);
    }

    .weatherMsg .right{
        width: 865px;
        height: 545px;
        background-image: url(<%=basePath%>frontend/images/qixiangRightbox.png);
        background-size: cover;
    }

    #meteo,#typhoon{
        width: 120px;
        height: 50px;
        font-size: 16pt;
        color: #fff;
        background-color: #002386;
        border: 1px solid #20bcfc;
        cursor: pointer;
    }

    </style>
</body>
</html>