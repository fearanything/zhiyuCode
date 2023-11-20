$(document).ready(function () {
    // 水情数据折线图
    trend()
    function trend(){
        // 1. 实例化对象
        var myChart = echarts.init(document.querySelector('#lineChart'))
        var dataDate = ['2022/12/13', '2023/1/13', '2023/2/13', '2023/3/13', '2023/4/13', '2023/5/13', '2023/6/13']
        // 2. 指定配置项和数据
        var option = {
            tooltip: {
                trigger: "axis",
                axisPointer: {
                    lineStyle: {
                        color: "#dddc6b"
                    }
                }
            },
            legend: {
                top: "top",
                textStyle: {
                    color: "rgba(255,255,255,.5)",
                    fontSize: "12"
                }
            },
            grid: {
                left: "10",
                top: "30",
                right: "40",
                bottom: "0",
                containLabel: true
            },

            xAxis: [
                {
                    type: "category",
                    boundaryGap: false,
                    axisLabel: {
                        textStyle: {
                            color: "rgba(255,255,255,.6)",
                            fontSize: 12
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            color: "rgba(255,255,255,.2)"
                        }
                    },

                    data: dataDate
                },
                {
                    axisPointer: { show: false },
                    axisLine: { show: false },
                    position: "bottom",
                    offset: 20
                }
            ],

            yAxis: [
                {
                    type: "value",
                    axisTick: { show: false },
                    axisLine: {
                        lineStyle: {
                            color: "rgba(255,255,255,.1)"
                        }
                    },
                    axisLabel: {
                        textStyle: {
                            color: "rgba(255,255,255,.6)",
                            fontSize: 12
                        }
                    },

                    splitLine: {
                        lineStyle: {
                            color: "rgba(255,255,255,.1)"
                        }
                    }
                }
            ],
            series: [
                {
                    name: "已处理",
                    type: "line",
                    smooth: true,
                    symbol: "circle",
                    symbolSize: 5,
                    showSymbol: false,
                    lineStyle: {
                        normal: {
                            color: "#0184d5",
                            width: 2
                        }
                    },
                    areaStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                0,
                                0,
                                0,
                                1,
                                [
                                    {
                                        offset: 0,
                                        color: "rgba(1, 132, 213, 0.4)"
                                    },
                                    {
                                        offset: 0.8,
                                        color: "rgba(1, 132, 213, 0.1)"
                                    }
                                ],
                                false
                            ),
                            shadowColor: "rgba(0, 0, 0, 0.1)"
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: "#0184d5",
                            borderColor: "rgba(221, 220, 107, .1)",
                            borderWidth: 12
                        }
                    },
                    data: ["30", "40", "30", "40", "30", "40", "30"]
                },
                {
                    name: "未处理",
                    type: "line",
                    smooth: true,
                    symbol: "circle",
                    symbolSize: 5,
                    showSymbol: false,
                    lineStyle: {
                        normal: {
                            color: "#00d887",
                            width: 2
                        }
                    },
                    areaStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                0,
                                0,
                                0,
                                1,
                                [
                                    {
                                        offset: 0,
                                        color: "rgba(0, 216, 135, 0.4)"
                                    },
                                    {
                                        offset: 0.8,
                                        color: "rgba(0, 216, 135, 0.1)"
                                    }
                                ],
                                false
                            ),
                            shadowColor: "rgba(0, 0, 0, 0.1)"
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: "#00d887",
                            borderColor: "rgba(221, 220, 107, .1)",
                            borderWidth: 12
                        }
                    },
                    data: ["30", "40", "30", "40", "30", "40", "30"]
                }
            ]
        };
        // for(i = 0; i < data.processed.length; i++){
        //   option.series[0].data.push(data.processed[i])
        //   option.series[1].data.push(data.untreated[i])
        // }
        // 3. 把配置项给实例对象
        myChart.setOption(option);
        // 4.跟随屏幕自适应
        window.addEventListener("resize", function() {
            myChart.resize({animation: {duration:1000}});
        });
    }
});

$(document).ready(function () {
    // 项目列表饼图
    project()
    function project(){
        // 1. 实例化对象
        var myChart = echarts.init(document.querySelector('#barChart'));
        // 2. 指定配置项和数据
        var option = {
            tooltip: {
                trigger: 'item'
            },
            legend: {
                bottom: '0%',
                left: 'center',
                textStyle: {
                    color: "#fff"
                }
            },
            // color: ['#229739', '#730b00', '#2026a8'],
            series: [
                {
                    type: 'pie',
                    radius: ['40%', '80%'],
                    avoidLabelOverlap: false,
                    label: {
                        show: false,
                        position: 'center',
                        color: '#fff'
                    },
                    emphasis: {
                        label: {
                            show: true,
                            fontSize: 40,
                            fontWeight: 'bold'
                        }
                    },
                    labelLine: {
                        show: false
                    },
                    data: [
                        { value: 735, name: '在建项目', itemStyle: { color: new echarts.graphic.LinearGradient(0, 0, 1, 1, [
                                    { offset: 0, color: '#46b555' },
                                    { offset: 1, color: '#229739' }
                                ]) } },
                        { value: 1048, name: '停工项目', itemStyle: { color: new echarts.graphic.LinearGradient(0, 0, 1, 1, [
                                    { offset: 0, color: '#b97100' },
                                    { offset: 1, color: '#730b00' }
                                ]) } },
                        { value: 580, name: '海控能源项目', itemStyle: { color: new echarts.graphic.LinearGradient(0, 0, 1, 1, [
                                    { offset: 0, color: '#3e82ee' },
                                    { offset: 1, color: '#2026a8' }
                                ]) } },
                    ]
                }
            ]
        };
        // 3. 把配置项给实例对象
        myChart.setOption(option);
        // 4.跟随屏幕自适应
        window.addEventListener("resize", function() {
            myChart.resize({animation: {duration:1000}});
        });
    }
});

$(document).ready(function () {
    mapChart()
    // 地图
    function mapChart(){

        var myChart = echarts.init(document.getElementById('map'));

        var allData = [
            {
                name: "海口市",
                list: [
                    "测试项目1",
                    "测试项目2",
                    "测试项目3",
                    "测试项目4",
                    "测试项目5",
                ]
            },
            {
                name: "文昌市",
                list: [
                    "测试项目1",
                    "测试项目2",
                    "测试项目3",
                    "测试项目4",
                    "测试项目5",
                ]
            },
            {
                name: "三亚市",
                list: [
                    "测试项目1",
                    "测试项目2",
                    "测试项目3",
                    "测试项目4",
                    "测试项目5",
                ]
            },
            {
                name: "文昌市",
                list: [
                    "测试项目1",
                    "测试项目2",
                    "测试项目3",
                    "测试项目4",
                    "测试项目5",
                ]
            },
        ]

        // 使用异步请求获取海南省的地图数据
        $.get('hainan.json', function (hainanJson) {
            // 注册地图数据
            echarts.registerMap('hainan', hainanJson);

            // 设置地图的配置项和数据
            var option = {
                title: {
                    text: '',
                    left: 'center'
                },
                // 悬浮框
                tooltip: {
                    padding: 0,

                    // 鼠标是否可以进入悬浮框
                    enterable: true,
                    // 触发方式 mousemove, click, none, mousemove|click
                    triggerOn: 'mousemove',
                    // item 图形触发， axis 坐标轴触发， none 不触发
                    trigger: 'item',
                    // 浮层隐藏的延迟
                    hideDelay: 100,
                    // 背景色
                    backgroundColor: 'rgba(0,60,255,.7)',
                    formatter: function (params) {
                        console.log(params);

                        for(var i = 0;i<allData.length;i++){
                            if(params.name==allData[i].name){
                                var nameList = '';
                                for (var j = 0; j < allData[i].list.length; j++) {
                                    nameList += `<div class="name">${allData[i].list[j]}</div>`;
                                }
                                return `
                                    <div class="tooltip">
                                        <div class="title">${allData[i].name}</div>
                                        <div class="list">
                                            <div class="name">${nameList}</div>
                                        </div>
                                    </div>
                                `
                            }
                        }

                    },
                },

                series: [
                    {
                        name: '海南省',
                        type: 'map',
                        map: 'hainan',
                        zoom: 1.1,
                        roam: false,
                        label: {
                            show: true,
                            fontSize: 12,
                            color: '#fff'
                        },
                        // itemStyle: {
                        //     areaColor: {
                        //         type: 'linear',
                        //         x: 0,
                        //         y: 0,
                        //         x2: 0,
                        //         y2: 1,
                        //         colorStops: [
                        //             {
                        //             offset: 0,
                        //             color: '#000a89' // 渐变起始颜色
                        //             },
                        //             {
                        //             offset: 1,
                        //             color: '#000a90' // 渐变结束颜色
                        //             }
                        //         ]
                        //     },
                        //     borderColor: '#0011f2'
                        // },
                        itemStyle: {
                            normal: {//未对地图作任何操作时的样式，加载想默认展示的样式
                                borderWidth: 4, //边框大小
                                borderColor: "#4294ef",
                                areaColor: "#2e8ece", //背景颜色
                                label: {
                                    show: true,
                                    color: '#fff',
                                    // formatter: function (params) {
                                    //     return `{pic|${
                                    //         params.value.toString() == "NaN" ? 0 : params.value}}\n{fline|${params.name}}`;
                                    // },
                                    position: "top",
                                    rich: {
                                        pic: {
                                            padding: [2, 5],
                                            width: "auto",
                                            height: 15,
                                            align: "center",
                                            color: "#FFFFFF",
                                            fontSize: "10px",
                                            borderRadius: 5,
                                        },
                                        fline: {
                                            color: "#FFFFFF",
                                            align: "center",
                                            fontSize: "12px",
                                        },
                                    },
                                },
                            },
                            // 高亮区域样式
                            emphasis: {
                                // 高亮区域背景色
                                areaColor: "#01ADF2",
                            },

                            //     emphasis: {
                            //         borderWidth:2,
                            //         borderColor:'red',
                            //         label: {
                            //             show: true,
                            //             textStyle: {
                            //                 color: '#fff',
                            //             }
                            //         },
                            //         areaColor: '#0726ff',
                            //         itemStyle: {
                            //             areaColor: '#0726ff',
                            //         },

                            // }

                            emphasis: {// 这个是鼠标移上去就会选中的样式，鼠标mouseover
                                borderWidth:1,
                                borderColor:'#00c6fe',
                                areaColor:"#0726ff",
                            },
                            //重点下面，与点击事件不同，虽然也是点击选中，但是事件不一样
                            selectedMode:"single", //选择模式，单选，只能选中一个地市
                            select:{//这个就是鼠标点击后，地图想要展示的配置
                                disabled:true,//可以被选中
                                itemStyle:{//相关配置项很多，可以参考echarts官网

                                }
                            },


                        }
                    },

                ],
            };

            // 使用刚指定的配置项和数据显示图表
            myChart.setOption(option);


            // 注册 tab 切换事件
            $(document).on('click', '.tab', function () {
                var tabId = $(this).data('tab');
                $(this).addClass('tabActive').siblings().removeClass('tabActive');
                $('#' + tabId).addClass('active').siblings().removeClass('active');
            });
            // 4.跟随屏幕自适应
            window.addEventListener("resize", function() {
                myChart.resize({animation: {duration:1000}});
            });
        });
    }
});