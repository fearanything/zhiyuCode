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
    <title>值班信息</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    
    <link rel="stylesheet" href="<%=basePath%>frontend/css/base.css">

</head>
<body id="main">
    <!-- 1.头部header开始 -->
    <%@ include file="top.jsp"%>
    <!-- 1.头部header结束 -->


    <!-- 2.值班信息开始 -->
    <div class="content" style="font-size:1rem ;">
        <div class="zhibanMsg">
            <div class="top">
                <h3 style="font-size: 22pt;">值班人员</h3>
            </div>
            <div class="table">
                <table style="width: 1600px;border-collapse: collapse; color:#fff; margin: 20px auto;">
                    <thead>
                      <tr>
                        <th style="width:20%;">企业单位</th>
                        <th style="width:10%;">姓名</th>
                        <th style="width:10%;">职位</th>
                        <th style="width:10%;">电话</th>
                        <th style="width:20%;">开始时间</th>
                        <th style="width:20%;">结束时间</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${dutyList}" var="item" varStatus="v">
                      <tr>
                        <td >${item.DUTY_CORP }</td>
                        <td>${item.DUTY_NAME }</td>
                        <td>${item.DUTY_JOB }</td>
                        <td>${item.DUTY_TEL }</td>
                        <td>${item.START_DATE }</td>
                        <td>${item.END_DATE }</td>
                      </tr> 
                    </c:forEach>
                       
                      
                    </tbody>
                    
                </table>
            </div>
            
        </div>
       
    </div>
    <!-- 2.值班信息结束 -->


    <script src="<%=basePath%>frontend/js/scale.js"></script>
    <script src="<%=basePath%>frontend/js/jquery.js"></script>
    <script src="<%=basePath%>frontend/js/date.js"></script>
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
        /* width: 1920px;
        height: 1080px; */
        display: flex;
        flex-direction: column;
        margin: 0px;
        background: url(<%=basePath%>frontend/images/background.png) no-repeat;
        background-size: 100% 100%;
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
        width: 100%;
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


    .head ul li a{
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
        margin-top: 10px;
        padding-bottom: 15px;
        height: 30px;
        line-height:30px;
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

    .content{
        padding: 60px 0;
        position: relative;
        margin: 2rem auto;
        width: 111rem;
        height: 56.2rem;
        background-image: url(<%=basePath%>frontend/images/subPage-bg.png);
        background-size: 100% 100%;
        box-sizing: border-box;
    }

    .table{
        table-layout: fixed;
        width: 100%;
        height: 820px;
        overflow-y: auto;
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

    .table thead tr th{
        position:sticky;
	    top:-0.8px;
    }

    table th {
        padding: 10px;
        background-image: linear-gradient(0deg, 
            #000d67 0%, 
            #002aff 100%);
        border: 1px solid #20bcfc;
        font-size: 20px;
        font-weight: 400;
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

    .zhibanMsg{
        margin-right: 2rem;
        display: flex;
        flex-direction: column;
        width: 1770px;
        height: 900px;
        background-image: url(<%=basePath%>frontend/images/changtaiMsgBox.png);
    }
    .zhibanMsg .top{
        position: absolute;
        top: -1%;
        left: 42%;
        padding: 0.125rem 0.9375rem;
        background-image: url(<%=basePath%>frontend/images/qiXiangXinXi-title.png);
        background-size: 100% 100%;
        background-repeat: no-repeat;
        box-sizing: border-box;
        z-index: 1;
    }

    .zhibanMsg .top h3{
        width: 13rem;
        height: 2.5rem;
        line-height: 2.5rem;
        font-size: 22pt;
        text-align: center;
        color: #fff;
    }

    /* .bottom{
        padding-left: .8rem;
        margin-top: 4rem;
    }

    .bottom img{
        margin-bottom: .2rem;
        margin-right: .8rem;
    } */

    .zhibanBox{
        margin-top: .4rem;
        width: 79rem;
        height: 17rem;
        background-image: url(<%=basePath%>frontend/images/zhibanrenBox.png);
        background-size: cover;
    }

    .zhibanBox .th{
        width: 78.9rem;
        height: 2.3rem;
        line-height: 2.3rem;
        text-align: center;
        color: #fff;
        display: flex;
        background-image: url(<%=basePath%>frontend/images/zhibanTab.png);
    }

    .zhibanBox .th p{
        width: 12rem;
    }

    /* .bottomMsg{
        display: flex;
        justify-content: space-between;
        height: 15rem;
        overflow-y: auto;
    }

    .td_name,.td_danwei,.td_zhiwei,.td_phone,.td_zhuangtai{
        color: #fff;
        width:10rem ;
        text-align: center;
    }

    .td_name p,.td_danwei p,.td_zhiwei p, .td_zhuangtai p{
        width: 10rem;
    }

    .beforeMsg{
        display: flex;
        flex-direction: column;
        width: 30rem;
        height: 56rem;
        background-image: url(./images/beforeBox.png);
        background-size: cover;
    }

    .beforeMsg .top{
        height: 2.4rem;
        line-height: 2.4rem;
        color: #fff;
        display: flex;
    }

    .beforeMsg .top h3{
        padding-left: 1rem;
        width: 9.7rem;
        height: 2.4rem;
        background-image: url(<%=basePath%>frontend/images/beforeTab.png);
    }

    .beforeMsg .middle{
        margin: 1rem auto;
        padding-left: 2rem;
        padding-right: 2rem;
        width: 27rem;
        height: 51rem;
        color: #fff;
        background-image: url(<%=basePath%>frontend/images/beforeContent.png);
        background-size: cover;
    }

    .beforeMsg .middle h4{
        height: 2rem;
        line-height: 2rem;
    }

    .waterData p{
        margin-bottom: .5rem;
    } */
   </style>
</body>
</html>