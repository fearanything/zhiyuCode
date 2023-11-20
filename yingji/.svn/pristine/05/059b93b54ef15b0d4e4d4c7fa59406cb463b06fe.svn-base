<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="head">
  <h1>应急响应管理模块</h1>
  <ul>
    <li>
      <a href="<%=basePath%>yjfhmFrontend/weather.html">气象信息</a>
    </li>
    <li class="nav" style="position:relative;">
      <a href="" id="xiala">应急值班</a>
      <ul style="position:absolute ; top: 25px; display: none; z-index:999; ">
        <li style="display:flex ; flex-direction: column;">
          <a href="<%=basePath%>yjfhmFrontend/zhibanMsg.html">值班名单</a>
          <a href="<%=basePath%>yjfhmFrontend/yingji_shuiba.html">值班信息</a>
        </li>
      </ul>
    </li>
    <li>
      <a href="<%=basePath%>yjfhmFrontend/index.html">主页</a>
    </li>
    <li>
      <a href="<%=basePath%>yjfhmFrontend/yingji.html">应急响应</a>
    </li>
    <li>
      <a href="<%=basePath%>yjfhmFrontend/changtaiMsg.html">存储中心</a>
    </li>
  </ul>
  <p class="times" style="position: absolute; top: 65px; right: 20px; font-size: 18pt;"></p>
</div>

<script src="<%=basePath%>frontend/js/scale.js"></script>
<script src="<%=basePath%>frontend/js/"></script>
<script src="<%=basePath%>frontend/js/date.js"></script>
<script src="<%=basePath%>frontend/js/time.js"></script>

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

  .yingji{
    margin: 2rem auto;
    width: 1770px;
    height: 894px;
    display: flex;
    flex-direction: column;
    background-image: url(<%=basePath%>frontend/images/boxbgc.png);
    background-size: cover;
  }

  .times{
    margin-left: 120px;
    margin-top: 20px;
    font-size: 20pt;
    color: #fff;
  }

  .yingjiMsgTitle h4 a{
    width: 10rem;
    display: inline-block;
    margin-left: 6rem;
    line-height: 2.2rem;
    font-size: 18pt;
    font-weight: 400;
    color: #fff;
    text-align: center;
    box-sizing: border-box;
    border: 1px solid transparent;
  }

  .tabActive{
    border: none;
  }

  .yingjiMsgTitle h4 a:hover{
    width: 10rem;
    background-size: cover;
    border-radius: 5px;
    color: #006cff;
    cursor: pointer;
  }

  .yingjiMsgTitle h4 a{
    color: #fff;
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

