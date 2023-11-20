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
    <title>常态信息</title>
    <link rel="stylesheet" href="<%=basePath%>frontend/css/base.css">
</head>
<body id="main">
    <!-- 1.头部header开始 -->
    <%@ include file="top.jsp"%>
    <!-- 1.头部header结束 -->

    <!-- 2.内容开始 -->
    <div class="content">
        <div class="top">
            <h2>常态信息</h2>
            <p class="times"></p>
        </div>
        <div class="tongzhi" style="display:flex ; justify-content: space-around; margin-top: 2rem;">
            <div class="left">
                <div class="top">
                    <h3 style="color: #fff; font-size: 16pt;line-height: 2rem;">
                        <img src="<%=basePath%>frontend/images/xiaolaba.png" alt="" style="width:1.5rem ; margin-bottom: 6px;">通知公告
                    </h3>
                    <form action="changtaiMsg.html" name="Form2" id="Form2" method="post" style="position:relative ;">
                        <input type="search" class="searchBox" name="keywords2" id="keywords2" value="${pd.keywords2 }" placeholder="输入搜索关键字...">
                        <input type="button" name="btn2" id="btn2" class="searchBtn" onclick="tosearch2();">
                    </form>
                </div>
                <div class="dongtaiList" style="color:#fff ;">
                    <ul style="overflow-y:auto ; height: 700px;">
                        
                        <c:forEach items="${noticeList}" var="item" varStatus="v">
                            <a href="<%=basePath%>frontend/detail.html?NOTICE_ID=${item.NOTICE_ID }" style="font-size:16pt;">${item.NOTICE_DATETIME } ${item.NOTICE_TITLE }</a>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="right">
                <div class="top">
                    <h4 style="padding-left:2rem ; line-height:30px;font-size: 16pt;">存储中心</h4>
                   <form action="changtaiMsg.html" name="Form1" id="Form1" method="post">
                        <input type="search" class="searchBox" name="keywords1" id="keywords1" value="${pd.keywords1 }" placeholder="输入搜索关键字...">
                        <input type="button" name="btn1" id="btn1" class="searchBtn" onclick="tosearch1();">
                    </form>
                </div>
                <ul class="wenjianjia" style="display: flex; justify-content: space-around; padding: 15px; border-bottom: 1px solid #0068ff;">
                    
                    <c:forEach items="${filetypeList}" var="item" varStatus="v">
                      <li>
                       <a style="color: #fff;"   href="<%=basePath%>frontend/changtaiMsg.html?FILETYPE_ID=${item.FILETYPE_ID }"> <img src="<%=basePath%>frontend/images/danganBox.png" alt=""/> ${item.FILETYPE_NAME }</a>
                      </li>
                     </c:forEach>
                </ul>
                <div class="danganList">
                    <ul style="color: #fff;">
                        <c:forEach items="${fileList}" var="item" varStatus="v">
                            <li>
                               ${item.FILE_NAME }
                              <div class="btn2">
                                <button class="look"><a style="color: #fff;" title="浏览" onclick="window.location.href='<%=basePath%>${item.FILE_URL}'">预览</a></button>
                                <button class="download"><a style="color: #fff;"  title="下载" href="<%=basePath%>${item.FILE_URL}">下载</a></button>
                              </div>
                            </li>
                     </c:forEach>
                        
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- 2.内容结束 -->


	<script src="<%=basePath%>frontend/js/jquery.js"></script>
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
    <script type="text/javascript">
		
		//检索
		function tosearch1(){
			$("#Form1").submit();
		}
		//检索
		function tosearch2(){
			$("#Form2").submit();
		}
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
        background-image: url(<%=basePath%>frontend/images/Tabbox2.png); 
        background-size: cover; 
        color: #fff;
    }

    .content .top p{
        font-size: 16pt;
        color: #fff;
        padding-right: 1rem;
        line-height: 2.5rem;
    }

    .tongzhi .left{
        position: relative;
        display: flex;
        flex-direction: column;
        padding-left: 15px;
        width: 644px;
        height: 791px;
        background-image: url(<%=basePath%>frontend/images/tongzhiLeftBox.png);
        background-size: cover;
    }

    .left .searchBox{
        padding-left: 15px;
        width: 350px;
        height: 30px;
        border-radius: 16px;
        background-color: #002796;
        border: 1px solid #20bcfc;
        font-size: 13pt;
        color: #fff; 
    }

    .left .searchBox{
    	margin-top:1px;
        padding-left: 15px;
        width: 350px;
        height: 28px;
        border-radius: 16px;
        background-color: #002796;
        border: 1px solid #20bcfc;
        font-size: 13pt;
        color: #fff; 
    }

    input::placeholder{
        color: #fff;
    }

    .searchBtn{
        position: absolute;
        top: 6px;
        right: 20px;
        background-image: url(<%=basePath%>frontend/images/searchicon.png);
        background-size: cover;
        background-color: rgba(255, 255, 255, 0);
        width: 20px;
        height: 20px;
        cursor: pointer;
    }

    .tongzhi .right{
        position: relative;
        display: flex;
        flex-direction: column;
        width: 1063px;
        background-image: url(<%=basePath%>frontend/images/tongzhiRightBox.png);
        background-size: cover;
    }

    .dongtaiList a{
        display: block;
        line-height: 50px;
        font-size: 13pt;
        color: #fff;
        border-bottom: 1px solid #0068ff;
    }

    .dongtaiList ul::-webkit-scrollbar{
        -webkit-appearance: none;
    }

    .dongtaiList ul::-webkit-scrollbar-thumb{
        background-color: #006cff;
    }

    .dongtaiList ul::-webkit-scrollbar-track{
        border: 1px solid #006cff;
        background-color: #062d82;
    }

    .dongtaiList a:hover{
        color: #0068ff;
        cursor: pointer;
    }

    .btn button{
        width: 5.1rem;
        height: 1.5rem;
        margin-right: .7rem;
        border-radius: 4px;
        border: none;
        background-color: #023197;
        color: #fff;
    }

    .danganTab a{
        padding-top: .8rem;
        text-align: center;
    }

    .danganTab a:hover{
        transition: all .8s;
        transform: scale(1.3);

    }

    .right .top .searchBox{
    	margin-top:1px;
        padding-left: 15px;
        padding-right: 55px;
        width: 300px;
        height: 28px;
        font-size: 14pt;
        background: #062d82;
        color: #fff;
        border: 1px solid #006cff;
        border-radius: 16px;
    }

    .danganTab a img{
        margin-bottom: .6rem;
        width: 3rem;
        height: 3rem;
    }

    .danganActive{
        width: 5.8rem;
        height: 6.2rem;
        background-image: url(<%=basePath%>frontend/images/danganBoxHover.png);
    }

    .wenjianjia img{
        margin: 0 auto;
        margin-bottom: 10px;
        width: 44px;
    }

    .wenjianjia li{
        display: flex;
        flex-direction: column;
        padding-top: 10px;
        width: 200px;
        height: 97px;
        font-size: 16pt;
        text-align: center;
        color: #fff;
        cursor: pointer;
    }

    .danganList .wenjianjia {
        width: 44px;
        height: 49px;
    }

    .danganList ul{
        height: 590px;
        overflow-y: auto;
    }

    .danganList ul::-webkit-scrollbar{
        -webkit-appearance: none;
    }

    .danganList ul::-webkit-scrollbar-thumb{
        background-color: #006cff;
    }

    .danganList ul::-webkit-scrollbar-track{
        border: 1px solid #006cff;
        background-color: #062d82;
    }

    .danganList li{
        display: flex;
        justify-content: space-between;
        margin-bottom: .1rem;
        padding: 0 2rem;
        height: 3rem;
        line-height: 3rem;
        font-size: 15pt;
    }
    
    .wenjianjia li a{
        display: flex;
        flex-direction: column;
        
    }

    .look{
        margin-right: 1rem;
        width: 4.2rem;
        height: 1.8rem;
        border: 1px solid #fff;
        border-radius: 11px;
        font-size: 14pt;
        color: #fff;
        background-color: rgba(0,0,0,0);
        cursor: pointer;
    }

    .download{
        width: 4.2rem;
        height: 1.8rem;
        border: 1px solid #03c115;
        border-radius: 11px;
        color: #03c115;
        font-size: 14pt;
        background-color: rgba(0,0,0,0);
        cursor: pointer;
    }
    </style>
</body>
</html>