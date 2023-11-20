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
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=yes,shrink-to-fit=no">
    <meta http-equiv="Page-Enter" content="blendTrans(Duration=0.5)" /> 
    <meta http-equiv="Page-Exit" content="blendTrans(Duration=0.5)" />
    <title>信息详情</title>
    <link rel="stylesheet" href="<%=basePath%>frontend/css/base.css">
</head>
<body id="main">
    <!-- 1.头部header开始 -->
    <%@ include file="top.jsp"%>
    <!-- 1.头部header结束 -->

    <!-- 2.内容开始 -->
    <div class="content">
        <div class="top">
            <h2>信息库</h2>
            <p class="times"></p>
        </div>
        <div class="detail">
            <h3 style="margin-bottom: 20px;font-size: 26pt;">${notice.NOTICE_TITLE }</h3>
            <div class="detailTime">
                <i style="font-size: 18pt; color: #fff;">时间：${notice.NOTICE_DATETIME }</i>
            </div>
            <p>
               ${notice.NOTICE_CONTENT }
            </p>
        </div>
    </div>
    <!-- 2.内容结束 -->



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
        margin: 2rem auto;
        width: 111rem;
        height: 56rem;
        background-image: url(<%=basePath%>frontend/images/changtaiMsgBox.png);
        background-size: cover;
    }

    .content .top{
        display: flex;
        justify-content: space-between;
    }

    .content h2{
        padding-left: 1rem;
        width:13rem ; 
        height: 2.5rem; 
        line-height: 2.5rem;
        font-size: 22pt;
        background-image: url(<%=basePath%>frontend/images/Tabbox.png); 
        background-size: cover; 
        color: #fff;
    }

    .content .top p{
        font-size: 16pt;
        color: #fff;
        padding-right: 1rem;
        line-height: 2.5rem;
    }

    .content .detail{
        padding: 30px 60px;
        margin: 30px auto;
        background-image: url(<%=basePath%>frontend/images/detailBox.png);
        background-size: cover;
        width: 1200px;
        height: 794px;
    }

    .content .detail p{
        padding-top: 15px;
        margin-top: 20px;
        text-indent: 2em;
        height: 570px;
        font-size: 16pt;
        letter-spacing: 4px;
        overflow-y: auto;
        border-top: 1px solid #007eff;
    }

    .detailTime{
        margin-bottom: 30px;
        width: 299px;
        height: 39px;
        text-align: center;
        background-color: #002796;
        border: 1px solid #20bcfc;
        border-radius: 19px;
    }

    .content .detail p::-webkit-scrollbar{
        -webkit-appearance: none;
    }

    .content .detail p::-webkit-scrollbar-thumb{
        background-color: #006cff;
    }

    .content .detail p::-webkit-scrollbar-track{
        border: 1px solid #006cff;
        background-color: #062d82;
    }

    
    </style>
</body>
</html>