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
    <title>应急响应</title>
    <link rel="stylesheet" href="<%=basePath%>frontend/css/base.css">
</head>
<body id="main">
    <!-- 1.头部header开始 -->
    <%@ include file="top.jsp"%>
    <!-- 1.头部header结束 -->


    <!-- 2.中部信息盒子开始 -->
    <div class="content">
        <div class="tabhead">
            <h3 style="font-size: 20pt;">应急响应信息</h3>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji.html">响应级别</a>
            </h4>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji_tufa.html">突发情况记录</a>
            </h4>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji_fangxun.html" class="tabActive">防汛风险情况</a>
            </h4>
        </div>
        <div class="pc" id="main">
            <div class="table">
                <table style="width: 1600px;border-collapse: collapse; color:#fff; margin: 30px auto;">
                    <thead>
                        <tr>
                            <th>风险点名称</th>
                            <th>风险点情况</th>
                        </tr>
                    </thead>
                    <tbody>
                     <c:forEach items="${riskList}" var="item" varStatus="v">
                      <tr>
                        <td >${item.RISK_NAME }</td>
                        <td>${item.RISK_INFO }</td>
                        
                      </tr> 
                    </c:forEach>
                      
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- 2.中部信息盒子结束 -->

    <script src="<%=basePath%>/frontend/js/jquery.js"></script>
    <script src="<%=basePath%>/frontend/js/scale.js"></script>
 <script src="<%=basePath%>frontend/js/time.js"></script>


<style>
    @media screen and (min-width:3000px) and (max-width:9999px){
        html{
            width: 1920px;
            margin: 0 auto;
        }
    }
	#box {

    overflow: auto;
    float: left;

    border: none;
    }

    .scrollbar li ul{
        display: none;
    }

    .scrollbar {

    height: 300px;
    margin: 10px auto;
    }

    .hide{
        display: none;
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
        background: url(./images/bgc2.jpg) no-repeat;
        background-size: 100% 100%;

    }


    .slrLi ul::-webkit-scrollbar {
        display: none;
}

    body::-webkit-scrollbar-thumb {
        background-color: #006cff!important;
}

    body::-webkit-scrollbar-track {
        border: 1px solid #006cff;
        background-color: #062d82;
}

    .head{
        
        height: 7rem;
        background-image: url(./images/topheadNew.png);
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
        background-image: url(./images/yingjigongchengBox.png);
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
        background-image: url(./images/yingjiHeadTab.png);
        background-size: cover;
        border: none;
    }

    .tabhead{
        display: flex;
    }

    .tabhead h3{
        background-image: url(./images/yingjiRedBox.png);
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

    .table{
        margin-top: 10px;
        table-layout: fixed;
        width: 100%;
        height: 820px;
        overflow-y: auto;
    }

    .table thead tr th{
        position:sticky;
        top:-2px;
    }

    .table::-webkit-scrollbar{
        -webkit-appearance: none;
    }

    .table::-webkit-scrollbar-thumb{
        background-color: #006cff;
    }

    .table::-webkit-scrollbar-track{
        border: 1px solid #006cff;
        background-color: #062d82;
    }

    table th {
        padding: 10px;
        background-image: linear-gradient(0deg, 
            #1d7add 0%, 
            #0f34e9 100%);
        border: 1px solid #20bcfc;
        font-size: 20px;
        font-weight: 700;
    }
    td,th {
        border:1px solid #20bcfc;
    }
    td {
        padding:10px;
        color:#fff;
        text-align: center;
        font-size: 16pt;
    }
    
</style>
</body>
</html>