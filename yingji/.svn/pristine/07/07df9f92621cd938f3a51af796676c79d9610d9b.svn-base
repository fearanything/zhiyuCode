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
	<title>海南控股应急门户平台-主页</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="<%=basePath%>frontend/css/base.css">
     <script src="https://open.ys7.com/sdk/js/1.1/ezuikit.js"></script>
</head>
<body>
    <!-- 1.头部header开始 -->
    <div class="head">
        <h1>海南控股应急门户平台</h1>
        <ul>
            <li>
                <a href="<%=basePath%>yjfhmFrontend/weather.html">气象信息</a>
            </li>
            <li class="nav" style="position:relative;">
                <a href="" id="xiala">应急值班</a>
                <ul style="position:absolute ; top: 25px; display: none;">
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
    <!-- 1.头部header结束 -->
    <div class="viewpoint" id="main">

        <!-- Bi内容开始 -->
        <div class="bi" style="height: 1080px;transform:scale(0.8) translate(-50%,-50%); transform-origin: 0 0; position: absolute; left: 50%; top: 60%;">
           <div class="otherWeb">
                <p><img src="<%=basePath%>frontend/images/lianjieIcon.png" alt="" style="width: 22px; margin-right: 4px;">第三方平台</p>
                <ul class="companyLink">
                    <li><a href="https://mn2n1ka6.adfs.authing-inc.co:18200/apps/6372fd2af67bbe5f22789542">海控能源电站平台集控平台</a></li>
                    <li><a href="https://v9n3hbty.adfs.authing-inc.co:18200/apps/637dfa500b7042c085342f02">综合安防管理平台</a></li>
                    <li><a href="https://dfjn552b.adfs.authing-inc.co:18200/apps/6372fb39030064a8a4994281">海控重大水利项目工程系统</a></li>
                    
                </ul>
            </div>
            <!-- 2.左边气象开始 -->
            <div class="weather">
               
                <a href="yingji1920.html" class="level" style="display:flex ;">
                    <div class="levelName" style="margin-top:.6rem ;">
                        <img src="<%=basePath%>frontend/images/HKlogo.png" alt="" style="width:7.5rem ;">
                        <h2 style="font-size: 3rem; color: #fff; width: 6rem;">海南控股</h2>
                    </div>
                    <div class="levelPoint">
                        <h2 style="font-size: 3.5rem; color: #0096ff;">应急响应</h2>
                        <p style="width: 12.5rem; height: 5.2rem;line-height: 5.2rem ;background-color:#ffb400; font-size: 4rem; text-align: center; border-radius: 1rem; color: #fff;"><i>${answer.ANSWER_LEVEL}</i>级</p>
                    </div>
                </a>
                <div class="taifeng" style="margin-top:1rem ; margin-bottom: .6rem;">
                    <div style="display:flex; justify-content:space-between;">
                    	<h3 style="margin-top:50px ; margin-bottom: 20px; padding-left: 1.5rem; font-weight: 400; background-image: url(<%=basePath%>frontend/images/TabBox.png);background-size: cover;width: 12.7rem;height: 2.5rem;line-height: 2.5rem ;font-size: 1.8rem;">台风气象</h3>
                    	<a href="<%=basePath%>yjfhmFrontend/weather.html" style="margin-right: 15px;margin-top:50px;width: 6.8rem; height: 2.4rem;line-height: 2.4rem; background-image: url(<%=basePath%>frontend/images/xiangqing.png); background-size: cover;;color: #fff; text-align: center; font-size: 1.5rem;">进入详细</a>
                    </div>
                    <a target="_blank" href="http://hi.cma.gov.cn/" class="video" style="cursor: pointer;">
                        <iframe id="ifr_map" class="map_frame" frameborder="no" border="0" scrolling="no" src="https://tf.istrongcloud.com/" width="500" height="450" style="margin-left: 30px; margin-top: 20px;"></iframe>
                    </a>
                </div>
                <div class="qixiang" >
                    <div class="title" style="margin-top:20px ;">
                        <h3 style="padding-left: 1rem;background-image: url(<%=basePath%>frontend/images/TabBox.png);background-size: cover;width: 12.7rem;height: 2.5rem;line-height: 2.5rem ;font-size: 1.8rem; font-weight: 400;">气象信息</h3>
                        <p style="font-size:1.5rem;width: 320px ;overflow: hidden; text-overflow: ellipsis;-webkit-line-clamp:3;-webkit-box-orient:vertical;">
                            ${weatherStr}
                        </p>
                    </div>
                </div>

                
            </div>
            <!-- 2.左边气象结束 -->


            <!-- 3.tab栏开始 -->
            <div class="tab">
                <div class="typhoonName" style="position: absolute; top: -50px; left: 480px; font-size: 32px; color: #fff;">
                    当前事件：${typhoon.TYPHOON_NAME}
                    
                </div>
                <a href="<%=basePath%>main/index" style="position: absolute; top: -60px; right: -560px; font-size: 24px; color: #fff; border: 1px solid #006cff;padding: 4px; border-radius: 10px;background-color: #002f86;">后台管理</a>
                <div class="support" style="position: absolute; bottom: -100px; left: 440px; font-size: 24px; color: #fff;">
                    <p>技术支持: 智宇科技有限公司</p >
                    <p>联系电话: 15501859297</p >
                </div>
                <button id="videoBtn">
                    <img src="<%=basePath%>frontend/images/jianshiqi.png" alt="">监控点
                </button>
                <div class="centerVideo">
                	<div class="otherbox" style="position: absolute; top: 20px; left: 20px; z-index: 1000; width: 1160px; height: 900px;  display: none;" id="otherbox1">
                        <iframe id="iframeMax" class="map_frame" frameborder="no" border="0" scrolling="no" src="<%=basePath%>yjfhmFrontend/playMax.html?MONITOR_ID=${MONITOR_ID1}" width="100%" height="100%" style=" margin:0 auto;"></iframe>
                        <button id="otrboxClose" style="position: absolute; top: 2px; right: 2px; background-color: red; color: #fff; border: 1px solid #0096ff; font-size: 18px; border-radius: 8px;">关闭</button>
                    </div>
                    <ul id="video" style="padding-top: .6rem; padding-left: .4rem;">
<%--                        <li>--%>
<%--                            <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe1" height="280px" src="${MONITOR_ID1}"></iframe>--%>
<%--                            <input type="radio" name="movie" id="movie1" value="iframe1">--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe2" height="280px" src="${MONITOR_ID2}"></iframe>--%>
<%--                            <input type="radio" name="movie" id="movie2" value="iframe2">--%>
<%--                        </li>--%>
<%--                        <li>--%>

<%--                            <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe3" height="280px" src="${MONITOR_ID3}"></iframe>--%>
<%--                            <input type="radio" name="movie" id="movie3" value="iframe3">--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe4" height="280px" src="${MONITOR_ID4}"></iframe>--%>
<%--                            <input type="radio" name="movie" id="movie4" value="iframe4">--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe5" height="280px" src="${MONITOR_ID5}"></iframe>--%>
<%--                            <input type="radio" name="movie" id="movie5" value="iframe5">--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe6" height="280px" src="${MONITOR_ID6}"></iframe>--%>
<%--                            <input type="radio" name="movie" id="movie6" value="iframe6">--%>
<%--                        </li>--%>

<%--                        <div id="playWind" style="width: 390px;height:280px"></div>--%>
                        <li>
                            <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe1" height="280px" src="<%=basePath%>yjfhmFrontend/play.html?MONITOR_ID=${MONITOR_ID1}"></iframe>
                            <input type="radio" name="movie" id="movie1" value="iframe1">
                        </li>
                        <li>
                            <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe2" height="280px" src="<%=basePath%>yjfhmFrontend/play.html?MONITOR_ID=${MONITOR_ID2}"></iframe>
                             <input type="radio" name="movie" id="movie2" value="iframe2">
                        </li>
                        <li>

                              <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe3" height="280px" src="<%=basePath%>yjfhmFrontend/play.html?MONITOR_ID=${MONITOR_ID3}"></iframe>
                             <input type="radio" name="movie" id="movie3" value="iframe3">
                        </li>
                        <li>
                             <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe4" height="280px" src="<%=basePath%>yjfhmFrontend/play.html?MONITOR_ID=${MONITOR_ID4}"></iframe>
                             <input type="radio" name="movie" id="movie4" value="iframe4">
                        </li>
                        <li>
                             <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe5" height="280px" src="<%=basePath%>yjfhmFrontend/play.html?MONITOR_ID=${MONITOR_ID5}"></iframe>
                             <input type="radio" name="movie" id="movie5" value="iframe5">
                        </li>
                        <li>
                             <iframe frameborder="no" scrolling="no" border="0" width="390px" id="iframe6" height="280px" src="<%=basePath%>yjfhmFrontend/play.html?MONITOR_ID=${MONITOR_ID6}"></iframe>
                             <input type="radio" name="movie" id="movie6" value="iframe6">
                        </li>
                    </ul>
                    <div class="menulist" style="padding-right:.6rem ; display: none;">
                        <ul class="menu_list">
                         <c:forEach items="${monitorsMap}" var="item" varStatus="v">
                             <li>
                                <dl class="menu_head">${item.MONITORTYPE_NAME } <span>共${item.MONITOR_LIST.size()}个</span></dl>
                                <dt class="menu_body">
                                 <c:forEach items="${item.MONITOR_LIST}" var="monitor" varStatus="v">
                                    <a href="#" onclick="vidoURL('${monitor.MONITOR_ID}');">${monitor.MONITOR_NAME }</a>
                                  </c:forEach>
                                </dt>
                            </li>
                        </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="gongGaoMsg">
                    <div style="display:flex; justify-content:space-between;">
                    	<h3 style="font-size:1.8rem; margin-bottom: 1.5rem;"><i><img src="<%=basePath%>frontend/images/xiaolaba.png" alt="" style="width: 1rem;"></i> 消息公告</h3>
                    	<a href="<%=basePath%>yjfhmFrontend/changtaiMsg.html" style="margin-right: 15px;width: 6.8rem; height: 2.4rem;line-height: 2.4rem; background-image: url(<%=basePath%>frontend/images/xiangqing.png); background-size: cover;;color: #fff; text-align: center; font-size: 1.5rem;">进入详细</a>
                    </div>
                    <div class="scrollNews" style="overflow:hidden;height:16rem;width:68rem;padding: 0 .8rem;">
                        <ul>
                        <c:forEach items="${noticeList}" var="item" varStatus="v">
                          <li><a href="<%=basePath%>yjfhmFrontend/detail.html?NOTICE_ID=${item.NOTICE_ID }"  class="tooltip"  >${item.NOTICE_DATETIME } ${item.NOTICE_TITLE }</a></li>
                        </c:forEach>
                            
                        </ul>
                    </div>
                    
                </div>
            </div>
            <!-- 3.tab栏结束 -->



            <!-- 4.右边值班信息开始 -->
            <div class="zhiban">
               <div class="title" style="display: flex;justify-content: space-between;margin-bottom: 30px;">
                    <h3 style="background-image: url(<%=basePath%>frontend/images/Tabbox2.png); background-size: cover;width: 12.7rem;height: 2.5rem;line-height: 2.5rem ;font-size: 1.8rem; padding-left: 1rem; font-weight:400 ;">值班信息</h3>
                    <a href="<%=basePath%>yjfhmFrontend/zhibanMsg.html" style="margin-right: 15px;width: 6.8rem; height: 2.4rem;line-height: 2.4rem; background-image: url(<%=basePath%>frontend/images/xiangqing.png); background-size: cover;;color: #fff; text-align: center; font-size: 1.5rem;">进入详细</a>
                </div>
                <div class="zhibanMsg" style="display:flex; justify-content: space-between; padding: .4rem;">
                    
                    <div class="zhibanRight" style="flex:2 ; font-size: 1.6rem;padding-top: .4rem;">
                        <ul style="display: flex; justify-content: space-around;">
                         <c:forEach items="${dutyList}" var="item" varStatus="v">
                            <li>
                                <p id="zhibanName">${item.DUTY_NAME }</p>
                                <p id="duty">${item.DUTY_JOB }</p>
                                <p id="phone">${item.DUTY_TEL }</p>
                            </li>
                        </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="waterData">
                    <div class="dataTitle" style="display:flex ; justify-content: space-between; background-image: url(<%=basePath%>frontend/images/data.png); padding: 0 1rem; margin-left: .2rem; margin-top: 30px;width: 34.5rem;">
                        <h3 style="font-weight: 400; font-size: 1.8rem;">近期水情数据</h3>
                        <a href="<%=basePath%>yjfhmFrontend/yingji_shuiba.html" style="background-image: url(<%=basePath%>frontend/images/xiangqing.png); width: 6.8rem;background-size: cover; ;height: 2.4rem; line-height: 2.4rem;font-size: 1.5rem; text-align: center; color: #fff;">进入详细</a>
                    </div>
                    <div class="lineChart" style="padding: 1rem;width: 528px; height: 300px;">
                        <div id="lChart" style="width: 500px; height: 290px; margin-left: 20px;"></div>
                    </div>
                </div>
                <div class="xiangmuList">
                    <div class="xiangmuTitle" style="margin-bottom:.4rem ; margin-top: 30px;display: flex;justify-content:space-between;">
                        <h3 style=" background-image: url(<%=basePath%>frontend/images/xiangmuTab.png); background-size: cover; width: 13.9rem;height: 2.5rem;line-height: 2.5rem; padding-left: 1rem; font-weight: 400; font-size: 1.8rem;">项目列表</h3>
                        <a href="<%=basePath%>yjfhmFrontend/yingji_gongcheng.html" style="margin-right: 15px;width: 6.8rem; height: 2.4rem;line-height: 2.4rem; background-image: url(<%=basePath%>frontend/images/xiangqing.png); background-size: cover;;color: #fff; text-align: center; font-size: 1.5rem;">进入详细</a>
                    </div>
                    <div class="pieMsg" style="display: flex; padding: 1rem;">
                        <div class="column1" >
                            <div class="left" style="width: 330px; height: 300px;">
                                <div class="lefttop" style="margin-top:6px ;">
                                    <p style="color:#FFFFFF;font-size:16pt;margin-left: 1.4rem;">海控项目汇总</p>
                                </div>
                                <div class="leftmid" id="chart" style="width:500px; height: 290px;">
                                </div>
                            </div>
                    
                        </div>
                        <div class="column2" style="height:200px;color: #fff;">
                    
                            <div class="right" id="box">
                                <ul id="rightul" class="scrollbar" style="height:200px ; overflow-y: hidden; font-size: 14px;">
                                </ul>
                            </div>
                    
                        </div>
                    </div>
                </div>
            </div>
            <!-- 4.右边值班信息结束 -->
        </div>
    </div>

    <script src="<%=basePath%>frontend/js/ezuikit.js">
    </script>

    <%--萤石云js--%>
    <script src="<%=basePath%>frontend/js/jquery.js"></script>
    <script src="<%=basePath%>frontend/js/echarts.min.js"></script>
    <script src="<%=basePath%>frontend/AmazeUI-2/assets/js/amazeui.js"></script>
    <script src="<%=basePath%>frontend/js/scale.js"></script>
    <script src="<%=basePath%>frontend/js/gundong.js"></script>
    <script src="<%=basePath%>frontend/js/time.js"></script>
    <script src="<%=basePath%>frontend/js/zhedieTab.js"></script>
    <script src="<%=basePath%>static/jquery/jquery-3.1.1.min.js"></script>


<%--    <script>--%>
<%--        $(function (){--%>
<%--            var player = new EZUIKit.EZUIKitPlayer({--%>
<%--                id: 'playWind', // 视频容器ID--%>
<%--                accessToken: 'at.2llpaog7dqti3jzy8t5tgwho084t3xtd-4qqw9szs4l-1vt5wnq-ojutmjiya',--%>
<%--                url: 'ezopen://open.ys7.com/G58879265/1.hd.live',--%>
<%--                width: 390,--%>
<%--                height: 280,--%>
<%--            });--%>
<%--            player.play();--%>
<%--        })--%>

<%--    </script>--%>
   
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
    var option = {
    	    
    	    tooltip: {
    	        trigger: 'item'
    	    },
    	    legend: {
    	        show: true,
    	        bottom: 10,
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
    	            data: [
    	                { value: 10, name: '海控能源项目', itemStyle: { color: '#c11010' } },
    	                { value: 14, name: '海控置业项目', itemStyle: { color: '#5959e2' } },
    	                { value: 4, name: '水电集团项目', itemStyle: { color: '#0092ff' } }
    	            ],
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
        if(!window.localStorage.getItem('storge')){
        window.location.url = 'zhibanMsg.html';
        window.localStorage.setItem('storge','true')
        }
    </script>

    <script>
        let videobtn = document.getElementById('videoBtn')
        let menulist = document.querySelector('.menulist')
        let table = document.getElementById('video')
        let num = 0
        videobtn.addEventListener('click',function(){
            if(num == 0){
                menulist.style.display = 'block'
                num = 1
                
            }else{
                menulist.style.display = 'none'
                num = 0
                
            }
        })
    </script>
    
    <script>
        let videoli = document.querySelectorAll('#video li')
        for(let i = 0; i < videoli.length; i++){
            videoli[i].addEventListener('click',function(){
                for(let j = 0; j < videoli.length; j++){
                    videoli[j].classList.remove('redhover')
                }
                this.classList.add('redhover')
            })
        }
    </script>

    <script>
          function vidoURL(MONITOR_ID){
        	  
        	  var val=$('input:radio[name="movie"]:checked').val();
        	  if(val!=null){
        		  var url1="<%=basePath%>yjfhmFrontend/play.html?MONITOR_ID="+MONITOR_ID+"&IFRAME_ID="+val;
        		  $("#"+val).attr('src', url1);
        	  }   
          }
          $('#otrboxClose').click(function(){
              $('.otherbox').slideUp(100)
          })
          $(':radio').dblclick(function(){
              var checkValue = $(this).val(); 
              var URL_SRC=$("#"+checkValue).attr("src");
           	  URL_SRC=URL_SRC.replace("play.html","playMax.html");
           	  $("#iframeMax").attr('src', URL_SRC);
           	  $('.otherbox').slideDown(100);
          });
          
    </script>
     
     <script>
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
                	 fontSize:10,
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
        
        $('.otherWeb').mouseenter(function(){
            $('.companyLink').stop()
            $('.companyLink').fadeIn()
        })
        $('.otherWeb').mouseleave(function(){
            $('.companyLink').stop()
            $('.companyLink').fadeOut()
        })
    </script>
    <style>
        html {
        width: 100%;
        height: 100%;
        
    }
    .redhover{
        border: 2px solid yellow;
        transition: all .5s;
    }
    #video li{
    	position:relative
    }
    #video input{
        position: absolute;
        top: 10px;
        right: 0px;
        width: 20px;
        height: 20px;
    }
    body {
        min-width: 1024px;
        max-width: 3066px;
        height: 1080px;
        display: flex;
        flex-direction: column;
        margin: 0px;
        background: url(<%=basePath%>frontend/images/background.png) no-repeat;
        background-size: 100% 100%;
        zoom: 1;

    }


    .active{
        width: 8rem;
        height: 1.6rem;
        background-color: #002386;
        border: solid .1rem #20bcfc;;
        border-radius: 6px;
    }

    .head{
        position:relative;
        width: 100%;
        height: 7rem;
        background-image: url(<%=basePath%>frontend/images/topheadNew.png);
        display: flex;
        flex-direction: column;
    }

    .head h1{
        margin-top: 1rem;
        display: flex;
        justify-content: center;
        font-size: 28pt;
        color: #fff;
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
        z-index: 999;
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

    .bi{
    	position:relative;
        display: flex;
        justify-content: center;
        margin-top: -30px;
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

    .weather{
        width: 35rem;
        height: 63.1rem;
        background-image: url(<%=basePath%>frontend/images/box1.png);
        background-size: cover;
    }

    .level{
        margin: 0 auto;
        margin-top: 5rem;
        display: flex;
        justify-content: space-around;
        width: 26rem;
        height: 11.3rem;
        background-image: url(<%=basePath%>frontend/images/levelBox.png);
        background-size: cover;
    }

    .level:hover{
        transition: all 1s;
        transform: scale(1.2);
    }

    #levelDetail{
        margin-top: 1rem;
        margin-bottom: .4rem;
        margin-right: 1rem;
        display: block;
        float: right;
        width: 6.8rem;
        height: 2.4rem;
        line-height: 2.4rem;
        text-align: center;
        font-size: 1.5rem;
        color: #fff;
        background-image: url(<%=basePath%>frontend/images/xiangqing.png);
        background-size: cover;
    }

    .qixiang .title{
        display: flex;
        justify-content: space-between;
        background-image: url(<%=basePath%>frontend/images/qixiangBgc.png);
        color: #fff;
    }

    .weatherMsg{
        display: flex;
        margin-top: 30px;
        color: #fff;
    }

    .weatherMsg .leftBox{
        display: flex;
        width: 170px;
        height: 65px;
        border: 1px solid #0096ff;
        border-radius: 8px;
    }

    .tab{
        position: relative;
        display: flex;
        flex-direction: column;
        margin: 0 1rem;
        width: 75rem;
        height: 63.1rem;
        background-image: url(<%=basePath%>frontend/images/vedioBox.png);
        background-size: cover;
    }

    #videoBtn{
        position: absolute;
        top: -36px;
        right: 0;
        width: 120px;
        font-size: 16pt;
        color: #fff;
        background-color: #002386;
        border: 1px solid #0096ff;
        border-radius: 6px 6px 0 0;
    }

    #video{
        display: flex;
        justify-content: flex-start;
        flex-wrap: wrap;
        width: 75rem;
    }
    
    #video li{
    	position:relative;
    }

    #video img{
        width: 24.3rem;
        height: 17.5rem;
    }

    .centerVideo{
        position: relative;
        width: 70rem;
        height: 29.7rem;
    }


    .centerVideo ul li{
        margin-left: 6px;
        margin-top: 2px;
    }

    .menulist{
        position: absolute;
        top: 6px;
        right: -90px;
        /* flex: 1; */
        color: #fff;
        /* width: 9rem; */
        z-index: 999;!important
        animation: menu .2s;
    }

    @keyframes menu{
        0%{
            opacity: 0;
        }
        50%{
            opacity: 0.5;
        }
        75%{
            opacity: .75;
        }
        100%{
            opacity: 1;
        }
    }

    .centerVideo .menulist #videoMenu dl{
        display: none;
    }

    .tab .centerVideo .menulist .menu_body a{
        padding-left: .4rem;
        display: block;
        overflow: hidden;
        height: 0;
        color: #fff;
        background-color: #006cff;
        opacity:.9;
        font-size: 16pt;
        transition: all .3s;
    }  

    .tab .centerVideo .menulist .menu_head{
    	display:flex;
    	justify-content:space-between;
        padding-left: .5rem;
        height: 4rem;
        line-height: 4rem;
        border:1px solid #006cff;
        background-color:#062d82;
        border-radius:8px;
        font-size: 16pt;
        cursor: pointer;
        color: #fff;

    }
    
    .tab .centerVideo .menulist .menu_head span{
    	color:yellow;
    	margin-right:20px;
    }
    
    .centerVideo .menulist .menu_body a:hover{
        color: #0096ff;
    }

    .gongGaoMsg{
        margin-top: 120px;
        padding: 1rem;
        width: 75rem;
        height: 25rem;
        color: #fff;
    }
    

    .gongGaoMsg li{
        display: flex;
        flex-direction: column;    
    }

    .gongGaoMsg li a{
        line-height: 4rem;
        font-size: 22pt;
        color: #fff;
    }

    .gongGaoMsg li a:hover{
        color: #0096ff;
    }

    .zhiban{
        width: 35rem;
        height: 63.1rem;
        background-image: url(<%=basePath%>frontend/images/box1.png);
        background-size: cover;
    }

    .zhibanLeft:hover{
        transition: all 1s;
        transform: scale(1.2);
    }

    #duty{
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }

    .zhibanRight li{
        margin-left: .6rem;
        cursor: pointer;
    }

    .zhibanRight li:hover{
        transition: all 1s;
        transform: scale(1.2);
    }

    .listMsg a{
        margin-top: .4rem;
        font-size: 1.2rem;
        color: #fff;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }

    .listMsg a:hover{
        color: #0096ff;
        cursor: pointer;
    }
    .companyLink a{
        margin-right: 30px;
        color: #fff;
        font-size: 24px;
    }

    .companyLink a:hover{
        color: #0096ff;
        cursor: pointer;
    }
    .menu_body{
        max-height: 600px;
        overflow-y: auto;
    }

    .menu_body::-webkit-scrollbar{
        appearance: none;
    }

    .menu_body::-webkit-scrollbar-thumb{
        background-color: #006cff;
    }

    .menu_body::-webkit-scrollbar-track{
        border: 1px solid #006cff;
        background-color: #062d82;
    }
    .otherWeb{
        position: absolute;
        left: 0px;
        top:-35px;
        width: 140px;
        height: 35px;
        font-size: 16pt;
        color: #fff;
        cursor: pointer;
        background-color: #002386;
        border-radius: 6px 6px 0 0;
        border: 1px solid #0096ff;
    }

    .companyLink{
        display: none;
        position: absolute;
        left: 4px;
        top:35px; 
        padding: 10px;
        background-color: #002f86; 
        z-index: 999;
        border-radius: 0 0 6px 6px;
    }
    .companyLink li{
        margin-bottom: 6px;
        border-bottom: 1px solid #20bcfc;
    }
    .companyLink li a{
    	white-space:nowrap;
        padding:10px;
        text-align: center;
        color: #fff;
        font-size: 20px;
    }
    
    </style>
</body>
</html>