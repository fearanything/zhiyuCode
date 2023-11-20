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
    <title>值班信息-地图</title>
    <link rel="stylesheet" href="<%=basePath%>frontend/css/base.css">
    <script src="<%=basePath%>frontend/js/echarts.min.js"></script>
</head>
<body id="main">
    <!-- 1.头部header开始 -->
    <div class="head">
        <h1>海南控股应急门户平台</h1>
        <ul>
            <li>
                <a href="<%=basePath%>yjfhmFrontend/weather.html">气象信息</a>
            </li>
            <li class="nav" style="position:relative;">
                <a href="" class="active" id="xiala">应急值班</a>
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


    <!-- 2.中部信息盒子开始 -->
    <div class="yingji">
        <div class="yingjiMsgTitle" style="display:flex ;">
            <h3 style="width: 13rem; height: 2.5rem;line-height:2.5rem ;background-image: url(<%=basePath%>frontend/images/Tabbox2.png); background-size: cover; font-size: 22pt; padding-left: 1rem;">值班信息</h3>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji_shuiba.html">水库大坝</a>
            </h4>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji_gongcheng.html">在建项目</a>
            </h4>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji_map.html" class="tabActive">地图分布</a>
            </h4>
        </div>
        <div id="chart2" style="width: 1200px; height: 850px; left: 150px;"></div>
    </div>
    <!-- 2.中部信息盒子结束 -->


    <script src="<%=basePath%>frontend/js/jquery.js"></script>
    <script src="<%=basePath%>frontend/js/scale.js"></script>
    <script src="<%=basePath%>frontend/js/hainan.json"></script>
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
    //省份数据 直接加就行
    const province = [${PROJECT_STR}];

    //市级数据  每加一条需要再geoCordMap添加对应市区坐标
    var data = [
        {
            name: "海口",
            value: 10,
        },
        {
            name: "三亚",
            value: 0,
        },
        {
            name: "五指山",
            value: 0,
        },
        {
            name: "琼海",
            value: 0,
        },
        {
            name: "儋州",
            value: 0,
        },
        {
            name: "文昌",
            value: 0,
        },
        {
            name: "万宁",
            value: 0,
        },
        {
            name: "东方",
            value: 0,
        },
        {
            name: "定安",
            value: 0,
        },
        {
            name: "屯昌",
            value: 0,
        },
        {
            name: "澄迈",
            value: 0,
        },
        {
            name: "临高",
            value: 0,
        },
        {
            name: "白沙",
            value: 7,
        },
        {
            name: "昌江",
            value: 0,
        },
        {
            name: "乐东",
            value: 0,
        },
        {
            name: "陵水",
            value: 0,
        },
        {
            name: "保亭",
            value: 0,
        },
        {
            name: "琼中",
            value: 0,
        },
    ];

    //市区坐标
    var geoCoordMap = {
        三亚: [109.508268, 18.247872],
        海口: [110.33119, 20.031971],
        儋州: [109.576782, 19.517486],
        五指山: [109.516662, 18.776921],
        琼海: [110.466785, 19.246011],
        文昌: [110.753975, 19.612986],
        万宁: [110.388793, 18.796216],
        东方: [108.653789, 19.10198],
        定安: [110.349235, 19.684966],
        屯昌: [110.102773, 19.362916],
        澄迈: [110.007147, 19.737095],
        临高: [109.687697, 19.908293],
        白沙: [109.452606, 19.224584],
        昌江: [109.053351, 19.260968],
        乐东: [109.175444, 18.74758],
        陵水: [110.037218, 18.505006],
        保亭: [109.70245, 18.636371],
        琼中: [109.839996, 19.03557],
    };

    var convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];
            if (geoCoord) {
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value),
            });
            }
        }
        return res;
        };

        let chart2 = echarts.init(document.getElementById("chart2"));
        echarts.registerMap("hn", geoJson);
        chart2.setOption({
        tooltip: {
            trigger: "item",
        },


        geo: {
            map: "hn",
            show: true,

            zoom: 1.2,
            center: [109.67853099950622, 19.185641999478833],
            label: {
            show: true,
            formatter: (e) => {
                for (let i in province) {
                if (province[i].name == e.name) {
                    return e.name + "\n" + province[i].value;
                }
                }
            },
            color: "#fff",
            fontSize:22
            },
            tooltip: {
                trigger: "item",
                triggerOn: "click",
                showContent: true,
                enterable: true,
                alwaysShowContent: true,
                backgroundColor: "rgba(0,0,0,0.4)", // 提示框浮层的背景颜色。
                axisPointer: {
                // 坐标轴指示器配置项。
                type: "shadow", // 'line' 直线指示器  'shadow' 阴影指示器  'none' 无指示器  'cross' 十字准星指示器。
                axis: "auto", // 指示器的坐标轴。
                snap: true, // 坐标轴指示器是否自动吸附到点上
            },
            textStyle: {
                // 提示框浮层的文本样式。
                color: "#41feff",
                fontStyle: "normal",
                fontWeight: "normal",
                fontFamily: "sans-serif",
                fontSize: 14,
            },
            padding: 0, // 提示框浮层内边距，
            formatter: function (e) {
                let n = e.name;
                let ud = [];
                for (let i in province) {
                if (province[i].name == n) {
                    ud = province[i];
                }
                }
                console.log(ud);
                let str = ""; 
                 for (let i in ud.item){
                    str = str +' <p  style="line-height: 40px; font-size:22px;white-space:normal;">'+ ud.item[i] +'</p >';
                }
                 
                    return '<div style="width:400px;max-height:400px;overflow-y:scroll;">' +
                            '<p  style="width:100%;height:40px; background: linear-gradient(#2caaab, #136692);  text-align: center;line-height: 40px;font-size:28px; color:#f3ee53e1;">'+ ud.name + ud.value+ '</p >' +
                            str+
                            '</div>'
                    ;
            },
            //   <p  style="line-height: 40px; text-indent: 10px; font-size:28px;">${ud.value}</p>
            enterable: true,//滚动条
            // extraCssText: "max-width:60%;max-height:83%; overflow-y: auto; ",//滚动条
            // position: ["80%", "60%"],
            // position: 'inside',
            position: function (point, params, dom, rect, size) {
    // 鼠标坐标和提示框位置的参考坐标系是：以外层div的左上角那一点为原点，x轴向右，y轴向下
    // 提示框位置
    var x = 0; // x坐标位置
    var y = 0; // y坐标位置
    
    // 当前鼠标位置
    var pointX = point[0];
    var pointY = point[1];
    
    // 外层div大小
    // var viewWidth = size.viewSize[0];
    // var viewHeight = size.viewSize[1];
    
    // 提示框大小
    var boxWidth = size.contentSize[0];
    var boxHeight = size.contentSize[1];
    
    // boxWidth > pointX 说明鼠标左边放不下提示框
    if (boxWidth > pointX) {
        x = 5;
    } else { // 左边放的下
        x = pointX - boxWidth;
    }
    
    // boxHeight > pointY 说明鼠标上边放不下提示框
    if (boxHeight > pointY) {
        y = 5;
    } else { // 上边放得下
        y = pointY - boxHeight;
    }
    
    return [x, y];
    }
        },
        emphasis: {
            label: {
                show: true,
            },
            itemStyle: {
                // areaColor: "#005b96",
                borderColor: "#fff",
            },
            },
            itemStyle: {
            areaColor: "#005b96",
            borderColor: "yellow",
            },
        },

        series: [
            // {
            //   symbolSize: 8,
            //   label: {
            //     show: false,
            //     position: "right",
            //     formatter(e) {
            //       return e.data.name;
            //     },
            //   },
            //   itemStyle: {
            //     color: "#ddb926",
            //   },
            //   name: "light",
            //   type: "scatter",
            //   coordinateSystem: "geo",
            //   data: convertData(data),
            //   encode: {
            //     value: 2,
            //   },
            // },
            // {
            //   name: "Top 5",
            //   symbolSize(e) {
            //     console.log(e);
            //     return e[2];
            //   },
            //   label: {
            //     formatter: "{b}",
            //     position: "right",
            //     show: true,
            //   },
            //   itemStyle: {
            //     color: "#ddb926",
            //   },
            //   encode: {
            //     value: 2,
            //   },
            //   name: "项目数量",
            //   type: "effectScatter",
            //   coordinateSystem: "geo",
            //   data: convertData(
            //     data
            //       .sort(function (a, b) {
            //         return b.value - a.value;
            //       })
            //       .slice(0, 6)
            //   ),
            // },
            {
            type: "map",
            map: "hn",
            geoIndex: 0,
            name: "项目数量",
            data: province,
            },
        ],
        });

        window.onresize = function () {
        chart2.resize();
        };
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
            width: 95px;
            height: 35px;
            background-image: url(<%=basePath%>frontend/images/yingjiHeadTab.png);
            background-size: cover;
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


</body>
</html>