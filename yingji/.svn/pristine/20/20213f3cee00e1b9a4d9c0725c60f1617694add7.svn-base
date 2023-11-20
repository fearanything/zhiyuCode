$(document).ready(function () {
    barCharts()
    lineChart()
    

    

    // 柱状图
    function barCharts(){
        // 1. 实例化对象
        var myChart = echarts.init(document.querySelector('#barChart'))
        // 2. 指定配置项和数据
        option = {
            //你的代码
            backgroundColor: "#061d6e84",
            color: ['#FFE5B9', '#33CCCC', '#1EC5EA', '#1EC5EA', '#1EC5EA'],
            tooltip: {
               //鼠标悬浮提示
               trigger: 'item',
               axisPointer: {
                  type: 'shadow'
               },
               // formatter: '{b}:{c}', //显示的内容
               backgroundColor: 'rgba(21, 45, 85, 0.6)', //背景颜色（此时为默认色）
               textStyle: {
                  color: '#fff'
               }
            },
            grid: {
               //图例位置
               left: '0%',
               right: '2%',
               top: '15%',
               bottom: '8%',
               containLabel: true
            },
            xAxis: [
               {
                  type: 'category',
                  data: [
                     '物理打击',
                     '车辆伤害',
                     '机械伤害',
                     '起重伤害',
                     '触电',
                  ],
                  axisTick: {
                     alignWithLabel: true
                  },
                  axisLine: {
                     show: true //隐藏y轴
                  },
                  axisTick: {
                     show: true //刻度线
                  },
                  // x轴的字体样式
                  axisLabel: {
                     show: true,
                     margin: 14, //边距
                     textStyle: {
                        color: '#fff',
                        fontSize: '12',
                        fontWeight: '400',
                        fontFamily: 'Microsoft YaHei'
                     },
                     interval: 0 //x轴文字不隐藏
                  }
               }
            ],
            yAxis: {
               splitLine: {
                  show: true,
                  lineStyle: {
                     color: '#979797',
                     type: [10, 15],
                     dashOffset: 0
                  },
               },
               axisLabel: {
                  textStyle: {
                     color: '#F5F5F5',  //更改坐标轴文字颜色
                     fontSize: 12     //更改坐标轴文字大小
                  }
               }
            },
            series: [
               {
                  name: '',
                  type: 'pictorialBar', //pictorialBar 象形柱图
                  symbolSize: [46, 12], //调整截面形状
                  symbolOffset: [0, 0],
                  z: 12,
                  itemStyle: {
                     normal: {
                        color: function (params) {
                           let barTopColor = ['rgba(255, 229, 185, .5)', 'rgba(41, 220, 192, 1)', 'rgba(30, 197, 234, 1)','rgba(30, 197, 234, 1)','rgba(30, 197, 234, 1)']
                           console.log(params, 555)
                           return barTopColor[params.dataIndex];
                        },
                     },
                  },
                  // 实现数字展示在柱状图
                  label: {
                     show: true,
                     position: 'top',
                     fontSize: 20,
                     color: '#F5F5F5',
                     fontWeight: 'bold',
                     offset: [0, -10],
                     formatter: '{c}' //添加单位
                  },
                  data: [626, 2708, 4567, 222, 233,]
               },
               {
                  name: '',
                  type: 'bar', //bar 柱状图
                  barWidth: 46,
                  barGap: '0%',
                  itemStyle: {
                     normal: {
                        color: function (params) {
         
                           let barMidColor = ['rgba(240, 194, 126, 1)', 'rgba(51, 204, 167, 1)', 'rgba(28, 171, 232, 1)', 'rgba(30, 197, 234, 1)', 'rgba(30, 197, 234, 1)']
                           console.log(params, 555)
                           return barMidColor[params.dataIndex];
                        },
                     },
                  },
                  data: [626, 2708, 4567, 222, 233,]
               },
               {
                  name: '',
                  type: 'pictorialBar', //pictorialBar 象形柱图
                  symbolSize: [46, 12], //调整截面形状
                  symbolOffset: [0, -8],
                  z: 12,
                  symbolPosition: 'end', //图形的位置 'start'：图形边缘与柱子开始的地方内切。'end'：图形边缘与柱子结束的地方内切。'center'：图形在柱子里居中。
                  itemStyle: {
                     normal: {
                        color: function (params) {
                           let barBottomColor = ['rgba(255, 229, 185, 1)', 'rgba(41, 220, 192, 1)', 'rgba(30, 197, 234, 1)', 'rgba(30, 197, 234, 1)', 'rgba(30, 197, 234, 1)']
                           console.log(params, 555)
                           return barBottomColor[params.dataIndex];
                        },
                     },
                  },
                  data: [626, 2708, 4567, 222, 233,]
               },
               {
                name: '',
                type: 'pictorialBar', //pictorialBar 象形柱图
                symbolSize: [46, 12], //调整截面形状
                symbolOffset: [0, -8],
                z: 12,
                symbolPosition: 'end', //图形的位置 'start'：图形边缘与柱子开始的地方内切。'end'：图形边缘与柱子结束的地方内切。'center'：图形在柱子里居中。
                itemStyle: {
                   normal: {
                      color: function (params) {
                         let barBottomColor = ['rgba(255, 229, 185, 1)', 'rgba(41, 220, 192, 1)', 'rgba(30, 197, 234, 1)', 'rgba(30, 197, 234, 1)', 'rgba(30, 197, 234, 1)']
                         console.log(params, 555)
                         return barBottomColor[params.dataIndex];
                      },
                   },
                },
                data: [626, 2708, 4567, 222, 233,]
             },
             {
                name: '',
                type: 'pictorialBar', //pictorialBar 象形柱图
                symbolSize: [46, 12], //调整截面形状
                symbolOffset: [0, -8],
                z: 12,
                symbolPosition: 'end', //图形的位置 'start'：图形边缘与柱子开始的地方内切。'end'：图形边缘与柱子结束的地方内切。'center'：图形在柱子里居中。
                itemStyle: {
                   normal: {
                      color: function (params) {
                         let barBottomColor = ['rgba(255, 229, 185, 1)', 'rgba(41, 220, 192, 1)', 'rgba(30, 197, 234, 1)', 'rgba(30, 197, 234, 1)', 'rgba(30, 197, 234, 1)']
                         console.log(params, 555)
                         return barBottomColor[params.dataIndex];
                      },
                   },
                },
                data: [626, 2708, 4567, 222, 233,]
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
    // function barCharts(){
    //     // 1. 实例化对象
    //         var myChart = echarts.init(document.querySelector('#barChart'))
    //         // 2. 指定配置项和数据
    //         let datas = [{
    //             name: "科技财险",
    //             value: 6500
    //         },
    //         {
    //             name: "数字化转型",
    //             value: 5501
    //         },
    //         {
    //             name: "健康险",
    //             value: 4502
    //         },
    //         {
    //             name: "车险改革",
    //             value: 4503
    //         },
    //         {
    //             name: "非车险",
    //             value: 4504
    //         },
    //         {
    //             name: "公司治理",
    //             value: 3505
    //         },
    //         {
    //             name: "保险科技",
    //             value: 8
    //         },
    //         {
    //             name: "云计算",
    //             value: 9
    //         },
    //         {
    //             name: "大数据",
    //             value: 10
    //         },
    //         {
    //             name: "人工智能",
    //             value: 11
    //         },
    //         {
    //             name: "区块链",
    //             value: 12
    //         },
    //         {
    //             name: "数字原生代",
    //             value: 13
    //         },
    //         {
    //             name: "共享经济",
    //             value: 14
    //         },
    //         {
    //             name: "成本效益",
    //             value: 15
    //         },
    //         {
    //             name: "云计算",
    //             value: 16
    //         },
    //         {
    //             name: "大数据",
    //             value: 17
    //         },
    //         {
    //             name: "人工智能",
    //             value: 18
    //         },
    //         {
    //             name: "物联网",
    //             value: 19
    //         },
    //         {
    //             name: "区块链",
    //             value: 20
    //         },
    //         {
    //             name: "虚拟现实",
    //             value: 21
    //         },
    //         {
    //             name: "基因技术",
    //             value: 22
    //         },
    //         {
    //             name: "电子化",
    //             value: 23
    //         },
    //         {
    //             name: "自动理赔",
    //             value: 24
    //         },
    //         {
    //             name: "保单服务",
    //             value: 25
    //         },
    //         {
    //             name: "动态定价",
    //             value: 26
    //         },
    //         {
    //             name: "承保",
    //             value: 27
    //         },
    //         {
    //             name: "评估风险",
    //             value: 28
    //         },
    //         {
    //             name: "承保价格",
    //             value: 29
    //         },
    //         {
    //             name: "测算风险",
    //             value: 30
    //         },
    //         {
    //             name: "智能风控",
    //             value: 31
    //         },
    //         {
    //             name: "风险管控",
    //             value: 32
    //         },
    //         {
    //             name: "业务风险",
    //             value: 33
    //         },
    //         {
    //             name: "财务风险",
    //             value: 34
    //         },
    //         {
    //             name: "资金运用风险",
    //             value: 35
    //         },
    //         {
    //             name: "保险欺诈",
    //             value: 36
    //         },
    //         {
    //             name: "孤岛式运营",
    //             value: 37
    //         },
    //         {
    //             name: "风控成本",
    //             value: 38
    //         },
    //         {
    //             name: "风险筛查",
    //             value: 39
    //         },
    //         {
    //             name: "风险预警",
    //             value: 40
    //         },
    //         {
    //             name: "机器学习",
    //             value: 41
    //         },
    //         {
    //             name: "服务体验",
    //             value: 42
    //         },
    //         {
    //             name: "客户黏度",
    //             value: 43
    //         },
    //         {
    //             name: "保险产品",
    //             value: 44
    //         },
    //         {
    //             name: "保险投保",
    //             value: 45
    //         },
    //         {
    //             name: "保证保险",
    //             value: 46
    //         },
    //         {
    //             name: "保险费",
    //             value: 47
    //         },
    //         {
    //             name: "保险金额",
    //             value: 48
    //         },
    //         {
    //             name: "保险承运人",
    //             value: 49
    //         },
    //         {
    //             name: "保险公司",
    //             value: 50
    //         },
    //         {
    //             name: "保险人",
    //             value: 51
    //         },
    //         {
    //             name: "保险经纪人",
    //             value: 52
    //         },
    //         {
    //             name: "保险承保人",
    //             value: 53
    //         },
    //         {
    //             name: "投保人",
    //             value: 54
    //         },
    //         {
    //             name: "被保险人",
    //             value: 55
    //         },
    //         {
    //             name: "受保人",
    //             value: 56
    //         },
    //         {
    //             name: "投保",
    //             value: 57
    //         },
    //         {
    //             name: "保险范围",
    //             value: 58
    //         },
    //         {
    //             name: "投保单",
    //             value: 59
    //         },
    //         {
    //             name: "保险金额",
    //             value: 60
    //         },
    //         {
    //             name: "保险",
    //             value: 61
    //         },
    //         {
    //             name: "保险条款",
    //             value: 62
    //         },
    //         {
    //             name: "投保通知",
    //             value: 63
    //         },
    //         {
    //             name: "保险企业",
    //             value: 64
    //         },
    //         {
    //             name: "保险条件",
    //             value: 65
    //         },
    //         {
    //             name: "险项",
    //             value: 66
    //         },
    //         {
    //             name: "险别",
    //             value: 67
    //         },
    //         {
    //             name: "保险费率表",
    //             value: 68
    //         },
    //         {
    //             name: "保险金",
    //             value: 69
    //         },
    //         {
    //             name: "保险收入",
    //             value: 70
    //         },
    //         {
    //             name: "销售误导",
    //             value: 71
    //         },
    //         {
    //             name: "理赔纠纷",
    //             value: 72
    //         },
    //         {
    //             name: "客户投诉",
    //             value: 73
    //         },
    //         {
    //             name: "移动互联",
    //             value: 74
    //         },
    //         {
    //             name: "大数据",
    //             value: 75
    //         },
    //         {
    //             name: "人工智能",
    //             value: 76
    //         },
    //         {
    //             name: "保险科技",
    //             value: 77
    //         },
    //         {
    //             name: "保险消费",
    //             value: 78
    //         },
    //         {
    //             name: "保单自助服务",
    //             value: 79
    //         },
    //         {
    //             name: "智能客服",
    //             value: 80
    //         },
    //         {
    //             name: "服务时效",
    //             value: 81
    //         },
    //         {
    //             name: "保险业生态",
    //             value: 82
    //         },
    //         {
    //             name: "保险科技",
    //             value: 83
    //         },
    //         {
    //             name: "保险业",
    //             value: 84
    //         },
    //         {
    //             name: "保险生态系统",
    //             value: 85
    //         },
    //         {
    //             name: "监管机构",
    //             value: 86
    //         },
    //         {
    //             name: "商业服务",
    //             value: 87
    //         },
    //         {
    //             name: "理赔合作伙伴",
    //             value: 88
    //         },
    //         {
    //             name: "欺诈检测",
    //             value: 89
    //         },
    //         {
    //             name: "IT服务提供商",
    //             value: 90
    //         },
    //         {
    //             name: "外部机构",
    //             value: 91
    //         },
    //         {
    //             name: "产品开发",
    //             value: 92
    //         },
    //         {
    //             name: "承保",
    //             value: 93
    //         },
    //         {
    //             name: "保费收取",
    //             value: 94
    //         },
    //         {
    //             name: "分销管理",
    //             value: 95
    //         },
    //         {
    //             name: "保单保全",
    //             value: 96
    //         },
    //         {
    //             name: "理赔",
    //             value: 97
    //         },
    //         {
    //             name: "资产管理",
    //             value: 98
    //         },
    //         {
    //             name: "经营业务",
    //             value: 99
    //         },
    //         {
    //             name: "商业模式",
    //             value: 100
    //         },
    //         {
    //             name: "服务型保险",
    //             value: 101
    //         },
    //         {
    //             name: "直接保险",
    //             value: 102
    //         },
    //         {
    //             name: "原保险人",
    //             value: 103
    //         },
    //         {
    //             name: "再保险",
    //             value: 104
    //         },
    //         {
    //             name: "分销渠道",
    //             value: 105
    //         },
    //         {
    //             name: "重塑",
    //             value: 106
    //         },
    //         {
    //             name: "云市场平台",
    //             value: 107
    //         },
    //         {
    //             name: "云应用服务",
    //             value: 108
    //         },
    //         {
    //             name: "保险业生态",
    //             value: 109
    //         },
    //         {
    //             name: "保险业务运营",
    //             value: 110
    //         },
    //         {
    //             name: "大数据分析",
    //             value: 111
    //         },
    //         {
    //             name: "区块链",
    //             value: 112
    //         },
    //         {
    //             name: "物联网",
    //             value: 113
    //         },
    //         {
    //             name: "技术服务",
    //             value: 114
    //         },
    //         {
    //             name: "商业服务",
    //             value: 115
    //         },
    //         {
    //             name: "机器人顾问",
    //             value: 118
    //         },
    //         {
    //             name: "交叉销售",
    //             value: 119
    //         },
    //         {
    //             name: "新型渠道",
    //             value: 120
    //         },
    //         {
    //             name: "电子支付",
    //             value: 121
    //         },
    //         {
    //             name: "保险科技",
    //             value: 122
    //         },
    //         {
    //             name: "云计算",
    //             value: 123
    //         },
    //         {
    //             name: "大数据",
    //             value: 124
    //         },
    //         {
    //             name: "物联网",
    //             value: 125
    //         },
    //         {
    //             name: "人工智能",
    //             value: 126
    //         },
    //         {
    //             name: "区块链",
    //             value: 127
    //         },
    //         {
    //             name: "车联网",
    //             value: 128
    //         },
    //         {
    //             name: "互联网",
    //             value: 129
    //         },
    //         {
    //             name: "移动技术",
    //             value: 130
    //         },
    //         {
    //             name: "无人驾驶汽车",
    //             value: 131
    //         },
    //         {
    //             name: "无人机",
    //             value: 132
    //         },
    //         {
    //             name: "虚拟现实",
    //             value: 133
    //         },
    //         {
    //             name: "基因技术",
    //             value: 134
    //         },
    //         {
    //             name: "可穿戴设备",
    //             value: 135
    //         },
    //         {
    //             name: "数字化转型",
    //             value: 136
    //         },
    //         {
    //             name: "产品分销",
    //             value: 137
    //         },
    //         {
    //             name: "核保",
    //             value: 138
    //         },
    //         {
    //             name: "风险定价",
    //             value: 139
    //         },
    //         {
    //             name: "产品设计",
    //             value: 140
    //         },
    //         {
    //             name: "理赔",
    //             value: 141
    //         },
    //         {
    //             name: "保险价值链",
    //             value: 142
    //         },
    //         {
    //             name: "投资组合",
    //             value: 143
    //         },
    //         {
    //             name: "客户服务",
    //             value: 144
    //         },
    //         {
    //             name: "补短板",
    //             value: 145
    //         },
    //         {
    //             name: "医疗数据",
    //             value: 152
    //         },
    //         {
    //             name: "精细化运营",
    //             value: 153
    //         },
    //         {
    //             name: "服务链条",
    //             value: 154
    //         },
    //         {
    //             name: "业务链条",
    //             value: 155
    //         },
    //         {
    //             name: "数据链条",
    //             value: 156
    //         },
    //         {
    //             name: "准备金",
    //             value: 185
    //         },
    //         {
    //             name: "责任保险",
    //             value: 186
    //         },
    //         {
    //             name: "展业",
    //             value: 187
    //         },
    //         {
    //             name: "财产保险",
    //             value: 188
    //         },
    //         {
    //             name: "企业财产保险",
    //             value: 189
    //         },
    //         {
    //             name: "家庭财产保险",
    //             value: 190
    //         },
    //         {
    //             name: "责任保险",
    //             value: 191
    //         },
    //         {
    //             name: "信用保险",
    //             value: 192
    //         },
    //         {
    //             name: "意外伤害险",
    //             value: 193
    //         },
    //         {
    //             name: "健康险",
    //             value: 194
    //         },
    //         {
    //             name: "银保通系统",
    //             value: 251
    //         },
    //         {
    //             name: "见费出单",
    //             value: 252
    //         },
    //         {
    //             name: "多渠道触达",
    //             value: 267
    //         },
    //         {
    //             name: "数据中台",
    //             value: 268
    //         },
    //         {
    //             name: "信息管理",
    //             value: 269
    //         },
    //         {
    //             name: "精准营销",
    //             value: 270
    //         },
    //         {
    //             name: "公有云",
    //             value: 272
    //         },
    //         {
    //             name: "私有云",
    //             value: 273
    //         },
    //         {
    //             name: "市场竞争",
    //             value: 274
    //         },
    //         {
    //             name: "企业认知",
    //             value: 275
    //         },
    //     ]
        
        
        
    //     option = {
            
    //         tooltip: {
    //             show: true,
    //             position: 'top',
    //             textStyle: {
    //                 fontSize: 30
    //             }
    //         },
    //         series: [{
    //             type: "wordCloud",
    //             // 网格大小，各项之间间距
    //             gridSize: 5,
    //             // 形状 circle 圆，cardioid  心， diamond 菱形，
    //             // triangle-forward 、triangle 三角，star五角星
    //             shape: 'circle',
    //             // 字体大小范围
    //             sizeRange: [20, 60],
    //             // 文字旋转角度范围
    //             rotationRange: [-45, 0, 45, 90],
    //             // 旋转步值
    //             rotationStep: 45,
    //             // 自定义图形
    //             // maskImage: maskImage,
    //             left: 'center',
    //             top: 'center',
    //             right: null,
    //             bottom: null,
    //             // 画布宽
    //             width: '90%',
    //             // 画布高
    //             height: '80%',
    //             //自定义图
    //             //   maskImage: maskImage,
    //             // 是否渲染超出画布的文字
    //             drawOutOfBound: false,
    //             textStyle: {
    //                 normal: {
    //                     color: function(params) {
    //                         var index_color = params.name;
    //                         if (index_color == "数字化转型") {
    //                             return '#FFFF00';
    //                         }
    //                         if (index_color == "科技财险") {
    //                             return '#FF7F00';
    //                         }
    //                         if (index_color == "健康险") {
    //                             return '#8B00FF';
    //                         }
    //                         if (index_color == "车险改革") {
    //                             return '#00FF00';
    //                         }
    //                         if (index_color == "非车险") {
    //                             return '#00FFFF';
    //                         }
    //                         if (index_color == "公司治理") {
    //                             return '#0000FF';
    //                         }
    //                         return 'rgb(' + [
    //                             Math.round(Math.random() * 200 + 55),
    //                             Math.round(Math.random() * 200 + 55),
    //                             Math.round(Math.random() * 200 + 55)
    //                         ].join(',') + ')';
    //                     }
    //                 },
    //                 emphasis: {
    //                     shadowBlur: 10,
    //                     shadowColor: '#2ac'
    //                 }
    //             },
    //             data: datas
    //         }]
    //     };
    //         // 3. 把配置项给实例对象
    //     myChart.setOption(option);
    //     // 4.跟随屏幕自适应
    //     window.addEventListener("resize", function() {
    //         myChart.resize({animation: {duration:1000}});
    //     });
    // }

    // 饼状图


    // 折线图
    function lineChart(){
        // 1. 实例化对象
        var myChart = echarts.init(document.querySelector('#lineChart'))
        // 2. 指定配置项和数据
        const data = new Array(12).fill(null).map(item => {
            return {
               value: Math.ceil(Math.random() * 600) + 100
            }
         })
         option = {
            backgroundColor:'#061d6e84',
            color: ['rgba(250, 109, 62, 1)'],
            tooltip: {
              trigger: 'axis',
              axisPointer: {
                // 坐标轴指示器，坐标轴触发有效
                type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
              }
            },
            grid: {
                top: '12%',
              left: '3%',
              right: '4%',
              bottom: '3%',
              containLabel: true
            },
            xAxis: [
              {
                type: 'category',
                data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                boundaryGap: false,
                axisTick:{
                  show:false // 不显示坐标轴刻度线
                },
                splitLine: {
                  show: false,
                },
                axisLine:{
                  show: false,
                },
                axisLabel: {
                  color: "rgba(230, 247, 255, 0.50)",
                  fontSize:14
                }
              }
            ],
            yAxis: [
              {
                type: 'value',
                //y右侧文字
                axisLabel: {
                  color: 'rgba(230, 247, 255, 0.50)',
                  fontSize:16
                },
                // y轴的分割线
                splitLine: {
                  show: true,
                  lineStyle: {
                    type:'dashed',
                    color:'rgba(230, 247, 255, 0.20)',
                   
                  }
                }
              }
            ],
            series: [
              {
                name: '风险总数',
                type: 'line',
                smooth: true,
                symbol: 'none', // 不显示连接点
                tooltip: {
                  trigger: 'axis',
                  axisPointer: {
                    // 坐标轴指示器，坐标轴触发有效
                    type: 'line' // 默认为直线，可选为：'line' | 'shadow'
                  }
                },
                lineStyle: {
                  width: 3,
                  shadowColor: "rgba(250, 109, 62, 1)",
                  shadowBlur: 20
                },
                areaStyle: {
                  opacity: 1,
                  //右下左上
                  color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                    {
                      offset: 0,
                      color: 'rgba(250, 109, 62, 1)'
                    },
                    {
                      offset: 0.3,
                      color: 'rgba(250, 109, 62, 0.5)'
                    },
                    {
                      offset: 1,
                      color: 'rgba(250, 109, 62, 0.35)'
                    }
                  ])
                },
                data: data
              }
            ]
          }
          // 3. 把配置项给实例对象
        myChart.setOption(option);
        // 4.跟随屏幕自适应
        window.addEventListener("resize", function() {
            myChart.resize({animation: {duration:1000}});
        });
    }
    
    // 地图
    function mapChart(){

        var myChart = echarts.init(document.getElementById('map'));

        var allData = [
            {
                name: "海口市",
                area: {
                    longhua: {
                        zd: "121",
                        jd: "221",
                        yb: "321",
                        dd: "421"
                    },
                    xiuying: {
                        zd: "121",
                        jd: "221",
                        yb: "321",
                        dd: "421"
                    },
                    qiongshan: {
                        zd: "121",
                        jd: "221",
                        yb: "321",
                        dd: "421"
                    },
                    meilan: {
                        zd: "121",
                        jd: "221",
                        yb: "321",
                        dd: "421"
                    },
                }
            },
            {
                name: "文昌市",
                value1: '1000',
                value2: '2000'
            }
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
                    position: [10, 90],
                    // 鼠标是否可以进入悬浮框
                    enterable: true,
                    // 触发方式 mousemove, click, none, mousemove|click
                    triggerOn: 'click', 
                    // item 图形触发， axis 坐标轴触发， none 不触发
                    trigger: 'item', 
                    // 浮层隐藏的延迟
                    hideDelay: 100,
                    // 背景色
                    backgroundColor: 'rgba(0,60,255,.7)',
                    formatter: function (params) {
                        console.log(params);
                        
                        for(var i = 0;i<allData.length;i++){
                            if(params.name==allData[i].name && params.name=='海口市'){
                                return `
                                        <div class="tooltip-box">
                                            <div class="title">
                                                <div class="location">${allData[i].name}</div>
                                                <div class="total">风险统计<span>8</span>个</div>
                                            </div>
                                            <div class="detail">
                                                <div class="tab-container" id="typhoonContainer">
                                                    <div class="tab tabActive" data-tab="area1">
                                                        <span>龙华区</span>
                                                    </div>
                                                    <div class="tab" data-tab="area2">
                                                        <span>秀英区</span>
                                                    </div>
                                                    <div class="tab" data-tab="area3">
                                                        <span>琼山区</span>
                                                    </div>
                                                    <div class="tab" data-tab="area4">
                                                        <span>美兰区</span>
                                                    </div>
                                                </div>
                                                <div class="tab-content" id="typhoonContent">
                                                    <div class="content active" id="area1">
                                                        <div class="list">
                                                        <div class="item">
                                                            <p>风险等级</p>
                                                            <div class="point">
                                                                <div class="fengxian">
                                                                    <img src="./images/great-icon.png" alt="">
                                                                    <div class="num">
                                                                        <p onclick="window.location.href='detail.html'">重大风险</p>
                                                                        <div id="zd">${allData[i].area.longhua.zd}个</div>
                                                                    </div>
                                                                </div>
                                                                <div class="fengxian">
                                                                    <img src="./images/larger-icon.png" alt="">
                                                                    <div class="num">
                                                                        <p onclick="window.location.href='detail.html'">较大风险</p>
                                                                        <div id="jd">${allData[i].area.longhua.jd}个</div>
                                                                    </div>
                                                                </div>
                                                                <div class="fengxian">
                                                                    <img src="./images/common-icon.png" alt="">
                                                                    <div class="num">
                                                                        <p onclick="window.location.href='detail.html'">一般风险</p>
                                                                        <div id="yb">${allData[i].area.longhua.yb}个</div>
                                                                    </div>
                                                                </div>
                                                                <div class="fengxian">
                                                                    <img src="./images/low-icon.png" alt="">
                                                                    <div class="num">
                                                                        <p onclick="window.location.href='detail.html'">低风险</p>
                                                                        <div id="dd">${allData[i].area.longhua.dd}个</div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="content" id="area2">
                                                    <div class="item">
                                                    <p onclick="window.location.href='detail.html'">风险等级</p>
                                                    <div class="point">
                                                        <div class="fengxian">
                                                            <img src="./images/great-icon.png" alt="">
                                                            <div class="num">
                                                                <p>重大风险</p>
                                                                <div id="zd">${allData[i].area.longhua.zd}个</div>
                                                            </div>
                                                        </div>
                                                        <div class="fengxian">
                                                            <img src="./images/larger-icon.png" alt="">
                                                            <div class="num">
                                                                <p>较大风险</p>
                                                                <div id="jd">${allData[i].area.longhua.jd}个</div>
                                                            </div>
                                                        </div>
                                                        <div class="fengxian">
                                                            <img src="./images/common-icon.png" alt="">
                                                            <div class="num">
                                                                <p>一般风险</p>
                                                                <div id="yb">${allData[i].area.longhua.yb}个</div>
                                                            </div>
                                                        </div>
                                                        <div class="fengxian">
                                                            <img src="./images/low-icon.png" alt="">
                                                            <div class="num">
                                                                <p>低风险</p>
                                                                <div id="dd">${allData[i].area.longhua.dd}个</div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                </div>
                                                <div class="content" id="area3">
                                                <div class="item">
                                                <p onclick="window.location.href='detail.html'">风险等级</p>
                                                <div class="point">
                                                    <div class="fengxian">
                                                        <img src="./images/great-icon.png" alt="">
                                                        <div class="num">
                                                            <p>重大风险</p>
                                                            <div id="zd">${allData[i].area.longhua.zd}个</div>
                                                        </div>
                                                    </div>
                                                    <div class="fengxian">
                                                        <img src="./images/larger-icon.png" alt="">
                                                        <div class="num">
                                                            <p>较大风险</p>
                                                            <div id="jd">${allData[i].area.longhua.jd}个</div>
                                                        </div>
                                                    </div>
                                                    <div class="fengxian">
                                                        <img src="./images/common-icon.png" alt="">
                                                        <div class="num">
                                                            <p>一般风险</p>
                                                            <div id="yb">${allData[i].area.longhua.yb}个</div>
                                                        </div>
                                                    </div>
                                                    <div class="fengxian">
                                                        <img src="./images/low-icon.png" alt="">
                                                        <div class="num">
                                                            <p>低风险</p>
                                                            <div id="dd">${allData[i].area.longhua.dd}个</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                                </div>
                                                <div class="content" id="area4">
                                                <div class="item">
                                                <p onclick="window.location.href='detail.html'">风险等级</p>
                                                <div class="point">
                                                    <div class="fengxian">
                                                        <img src="./images/great-icon.png" alt="">
                                                        <div class="num">
                                                            <p>重大风险</p>
                                                            <div id="zd">${allData[i].area.longhua.zd}个</div>
                                                        </div>
                                                    </div>
                                                    <div class="fengxian">
                                                        <img src="./images/larger-icon.png" alt="">
                                                        <div class="num">
                                                            <p>较大风险</p>
                                                            <div id="jd">${allData[i].area.longhua.jd}个</div>
                                                        </div>
                                                    </div>
                                                    <div class="fengxian">
                                                        <img src="./images/common-icon.png" alt="">
                                                        <div class="num">
                                                            <p>一般风险</p>
                                                            <div id="yb">${allData[i].area.longhua.yb}个</div>
                                                        </div>
                                                    </div>
                                                    <div class="fengxian">
                                                        <img src="./images/low-icon.png" alt="">
                                                        <div class="num">
                                                            <p>低风险</p>
                                                            <div id="dd">${allData[i].area.longhua.dd}个</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                                </div>
                                            </div>
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
                        zoom: 1,
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
                                borderColor: "#000be2",
                                areaColor: "#000a91", //背景颜色
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
    
    // 风险人数
    var fengxianAll = 0 // 当前报道人数
    var zhongda = 0 //男生人数
    var jiaoda = 0 //女生人数

    // 更新风险数函数
    function updateCounter() {
        $.ajax({
            url: 'data.json',
            method: "GET",
            dataType: "json",
            success: function(data) {
                console.log(data);
            // 获取报道人数
            var all = data.fengxianAll;
            var zd = data.zhongdaAll;
            var jd = data.jiaodaAll;
            

            // 判断是否需要过渡动画
            if (all > fengxianAll || zd > zhongda || jd > jiaoda) {
                // 动画效果过渡到新的人数
                $({ Counter: fengxianAll }).animate(
                { Counter: all },
                {
                    duration: 2000, // 动画持续时间，单位为毫秒
                    easing: "swing", // 缓动函数，可以根据需要修改
                    step: function() {
                    $("#counter").text(Math.ceil(this.Counter));
                    }
                }
                );
                // 动画效果过渡到新的人数
                $({ Zhongda: zhongda }).animate(
                    { Zhongda: zd },
                    {
                        duration: 2000, // 动画持续时间，单位为毫秒
                        easing: "swing", // 缓动函数，可以根据需要修改
                        step: function() {
                        $("#zhongda").text(Math.ceil(this.Zhongda));
                        }
                    }
                    );
                    // 动画效果过渡到新的人数
                $({ Jiaoda: jiaoda }).animate(
                    { Jiaoda: jd },
                    {
                        duration: 2000, // 动画持续时间，单位为毫秒
                        easing: "swing", // 缓动函数，可以根据需要修改
                        step: function() {
                        $("#jiaoda").text(Math.ceil(this.Jiaoda));
                        }
                    }
                    );
            } else {
                // 直接更新人数显示
                $("#counter").text(all);
                $("#zhongda").text(zd);
                $("#jiaoda").text(jd);
            }
    
            // 更新当前报道人数
            fengxianAll = all;
            zhongda = zd;
            jiaoda = jd;
            },
            error: function(xhr, status, error) {
            console.log("Ajax请求失败: " + error);
            }
        });
    }
    
    // 页面加载完成后立即更新风险数
    updateCounter();
    
    // 每隔5秒钟更新一次风险数
    setInterval(function() {
        updateCounter();
    }, 600000);

    
});