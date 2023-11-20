$(document).ready(function () {
    //通过宽度自适应
    function fontSize(res){
    let docEl = document.documentElement,
        clientWidth = window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth;
        if (!clientWidth) return;
        let fontSize = 100 * (clientWidth / 1920);
        return res*fontSize;
    }

    // 项目总数数据
    var projectPre = 100;
    var projectCur = 120;
    var projectBox = $('#projectNum');
    // 安全隐患数据
    var yinhuanPre = 120;
    var yinhuanCur = 100;
    var yinhuanBox = $('#yinhuanNum');
    // 风险总数数据
    var fengxianPre = 120;
    var fengxianCur = 100;
    var fengxianBox = $('#fengxianNum');

    updateComparisonData(projectPre, projectCur, projectBox );
    updateComparisonData(yinhuanPre, yinhuanCur, yinhuanBox );
    updateComparisonData(fengxianPre, fengxianCur, fengxianBox );
    //统计数量
    function updateComparisonData(previousData, currentData, comparisonBox) {
        var numElement = comparisonBox.find('.num span');
        numElement.prop('counter', 0).animate({
            counter: previousData
        }, {
            duration: 1000, // 动画持续时间（以毫秒为单位）
            easing: 'swing', // 动画缓动函数
            step: function(now) {
            numElement.text(Math.ceil(now)); // 使用向上取整确保数字递增
            },
            complete: function() {
            var comparisonText = currentData > previousData ? '增长' : '下降';
            var percentage = Math.abs(((currentData - previousData) / previousData * 100).toFixed(2));
            var comparisonTextElement = comparisonBox.find('.comparison-text');
            comparisonTextElement.text(comparisonText);
            comparisonBox.find('.percentage').text(percentage + '%');
            if (comparisonText === '增长') {
                comparisonTextElement.addClass('increase');
            } else {
                comparisonTextElement.removeClass('increase');
            }
            }
        });
    }

    yinhuanType();
    // 隐患因素饼图
    function yinhuanType(){
        // 模拟数据
        var DATA = [
            {
                NAME: '人的不安全行为',
                VALUE: 66
            },
            {
                NAME: '物的不安全状态',
                VALUE: 26
            },
            {
                NAME: '环境的不安全因素',
                VALUE: 36
            },
            {
                NAME: '管理缺陷',
                VALUE: 96
            },
        ];
        // 1. 实例化对象
        var myChart = echarts.init(document.querySelector('#yinhuanType'))
        // 2. 指定配置项和数据
        option = {
            tooltip: {
                trigger: 'item',
                formatter(params){
                    console.log(params);
                    if(params.data.name === ''){
                        // return `${params.name + ':' + params.data.value}`
                        return '无'
                    }else{
                        return params.name + ':' + params.data.value + '个'
                    }
                }
            },
            legend: {
                left: 'left',
                top: 'center',
                width: '5%',
                textStyle: {
                    color: '#fff',
                    fontSize: fontSize(0.12)
                },
                formatter(name){
                    var total = 0
                    var samValue
                    $.each(DATA, function (index, value) { 
                        total += DATA[index].VALUE
                        if (DATA[index].NAME == name) {
                            samValue = DATA[index].VALUE
                        }
                    });
                    //计算出百分比
                    let percent = Math.round((samValue / total) * 100) + '%' 
                    return `${name}  ${percent} `
                }
                
            },
            series: [
            {
                name: '各隐患隐患因素统计',
                type: 'pie',
                center: ['70%', '50%'],
                radius: ['40%', '80%'],
                avoidLabelOverlap: false,
                itemStyle: {
                    borderRadius: 4,
                },
                label: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                label: {
                    show: true,
                    fontSize: 34,
                    fontWeight: 'bold',
                    color: '#fff',
                }
                },
                labelLine: {
                    show: false
                },
                data: [],
                color: [
                    new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {offset: 0, color: 'rgba(50, 84, 221, 1)'},
                        {offset: 1, color: 'rgba(50, 84, 221, .5)'}
                    ]),
                    new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {offset: 0, color: 'rgba(43, 142, 243, 1)'},
                        {offset: 1, color: 'rgba(43, 142, 243, .5)'}
                    ]),
                    new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {offset: 0, color: 'rgba(190, 229, 251, 1)'},
                        {offset: 1, color: 'rgba(190, 229, 251, .5)'}
                    ]),
                    new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {offset: 0, color: 'rgba(61, 188, 190, 1)'},
                        {offset: 1, color: 'rgba(61, 188, 190, .5)'}
                    ]),
                ],
            }
        ]
    };
    // for(i = 0; i < DATA.length; i++){
    //     option.series[0].data.push({
    //         name: DATA[i].NAME,
    //         value: DATA[i].VALUE
    //     })
    //     console.log(DATA[i]);
    // }
    $.each(DATA, function (index, value) { 
        option.series[0].data.push({
            name: DATA[index].NAME,
            value: DATA[index].VALUE
        })
    });
        // 3. 把配置项给实例对象
        myChart.setOption(option)
        // 4.跟随屏幕自适应
        window.addEventListener("resize", function() {
            myChart.resize({animation: {duration:1000}});
        })
    }

    yinhuanTotal()
    // 二级隐患总数柱状图
    function yinhuanTotal(){
        // 模拟数据
        var DATA = [
            {
                NAME: '海南机场',
                VALUE: 66
            },
            {
                NAME: '海南机场1',
                VALUE: 26
            },
            {
                NAME: '海南机场2',
                VALUE: 46
            },
            {
                NAME: '海南机场3',
                VALUE: 96
            },
            {
                NAME: '海南机场4',
                VALUE: 116
            },
            {
                NAME: '海南机场5',
                VALUE: 186
            },
            {
                NAME: '海南机场6',
                VALUE: 136
            },
            {
                NAME: '海南机场7',
                VALUE: 86
            },
            {
                NAME: '海南机场8',
                VALUE: 16
            },
            {
                NAME: '海南机场9',
                VALUE: 6
            }
        ]
        // 1. 实例化对象
        var myChart = echarts.init(document.querySelector('#yinhuanTotal'))
        
        // 2. 指定配置项和数据
        option = {
            color: ["#cf7f2ffc"],
            // title: {
            //   text: 'World Population'
            // },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                type: 'shadow'
                }
            },
            legend: {},
            grid: {
                top: '10%',
                left: '1%',
                right: '10%',
                bottom: '0',
                containLabel: true
            },
            xAxis: {
                show: false,
                type: 'value',
                boundaryGap: [0, 0.01],
                axisTick: {
                alignWithLabel: true
                },
                axisLabel: {
                textStyle: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: "12"
                }
                },
                axisLine: {
                show: false
                },
                splitLine: {
                    show: false,
                    lineStyle: {
                        color: "red"
                    }
                }
            },
            yAxis: {
                type: 'category',
                inverse: true,
                data: [],
                axisLabel: {
                    interval: 0,
                    textStyle: {
                        color: "rgba(255,255,255,1)",
                        fontSize: "12"
                    }
                },
                axisLine: {
                    lineStyle: {
                        color: "rgba(255,255,255,.1)"
                        // width: 1,
                        // type: "solid"
                    }
                },
                splitLine: {
                    show: false,
                    lineStyle: {
                        color: "red"
                    }
                }
            },
            series: [
                {
                type: 'bar',
                data: [],
                realtimeSort: true,
                itemStyle: {
                    normal: {
                    color: new echarts.graphic.LinearGradient(1, 0, 0, 0, [{  
                    // 四个数字分别对应 数组中颜色的开始位置，分别为 右，下，左，上。例如（1,0,0,0 ）代表从右边开始渐
                    // 变。offset取值为0~1，0代表开始时的颜色，1代表结束时的颜色，柱子表现为这两种颜色的渐变。
                        offset: 1,
                        color: '#188df0'
                    }, 
                    {
                        offset: 0,
                        color: '#83bff6'
                    }
                    ]),
                    barBorderRadius: [10, 10, 10, 10]
                    }
                },
                label: {
                    normal: {
                    show: true,
                    position: "outside",
                    textStyle: {
                        color: '#fff',
                    }
                    }
                }
                },
            ]
            };
            // for(var i = 0; i < data.length; i++){
            // option.yAxis.data.push(data[i].name)
            // option.series[0].data.push(data[i].value)
            // }
            $.each(DATA, function (index, value) { 
                option.yAxis.data.push(DATA[index].NAME)
                option.series[0].data.push(DATA[index].VALUE)
            });
            // 3. 把配置项给实例对象
            myChart.setOption(option)
            // 4.跟随屏幕自适应
            window.addEventListener("resize", function() {
                myChart.resize({animation: {duration:1000}});
            })
    }

    yinhuanTrend()
    // 隐患趋势折线图
    function yinhuanTrend(){
        // 模拟数据
        var DATA = {
            processed:[30, 40, 20, 50, 60, 10, 90],
            untreated:["50", "30", "50", "60", "10", "50", "30"]
        }
        // 1. 实例化对象
        var myChart = echarts.init(document.querySelector('#yinhuanTrend'))
        var dataDate = ['2022/12/13', '2023/1/13', '2023/2/13', '2023/3/13', '2023/4/13', '2023/5/13', '2023/6/13']
        // 2. 指定配置项和数据
        option = {
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
            data: []
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
            data: []
            }
        ]
        };
        for(i = 0; i < DATA.processed.length; i++){
            option.series[0].data.push(DATA.processed[i])
            option.series[1].data.push(DATA.untreated[i])
            console.log(option.series[0].data);
        }
        // 3. 把配置项给实例对象
        myChart.setOption(option);
        // 4.跟随屏幕自适应
        window.addEventListener("resize", function() {
            myChart.resize({animation: {duration:1000}});
        });
    }

    fengxianLevelChart()
    // 风险等级饼图
    function fengxianLevelChart(){
        // 1. 实例化对象
        var myChart = echarts.init(document.querySelector('#fengxianLevel'))
        // 2. 指定配置项和数据
        const colorList1 = [ 'rgb(255,0,0,1.000)','', 'rgb(255,192,0,1.000)','', 'rgb(255,255,0,1.000)','', 'rgb(0,176,240,1.000)',]
        const colorList2 =  [ 'rgb(255,0,0, .5)','', 'rgb(255,192,0, .5)','', 'rgb(255,255,0, .5)', '','rgb(0,176,240,.5)',]
        let total = 0
        let dataList = []
        var zd = {'data': 22}
        const moduleContent = { '重大风险': zd.data, '较大风险': 380, '一般风险': 0 ,'低风险': 70,}
        let sum = 0
        const chartdata = []
        for (const i in moduleContent) {
        chartdata.push({
            name: i,
            value: moduleContent[i] || 1
        })
        sum += Number(moduleContent[i] || 0)
        }
        total = sum
        dataList = chartdata
        const data1 = []
        chartdata.forEach((item) => {
        const _item = { ...item }
        if (!_item.value) {
            _item.value = sum / 100
        }
        data1.push(_item, {
            name: '',
            value: sum / 100,
            label: { show: false },
            itemStyle: {
                color: 'transparent'
            }
        })
        })

        let option = {
            legend: {
                left: 'left',
                top: 'center',
                width: '20%',
                textStyle:{
                    color: '#fff'
                }
            },
        backgroundColor: '#061d6e84',
        title: {
            text: total,
            left: 'center',
            top: '35%',
            itemGap: 10,
            textStyle: {
            color: '#fff',
            fontSize: '35',
            fontWeight: 500
            },
            subtext: '共计',
            subtextStyle: {
            color: 'rgba(255,255,255,0.5)',
            fontSize: '20',
            fontWeight: 600
            }
        },
        tooltip: {
            trigger: 'item',
            axisPointer: {
            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            },
            formatter(params) {
                console.log(params);
                if(params.data.name === ''){
                    // return `${params.name + ':' + params.data.value}`
                    return '无'
                }else{
                    return `${params.name + ':' + params.data.value}`
                }
            },
            // formatter: "{b}: {c} "+" | "+"{d}%",
            textStyle: {
            fontSize: 18,
            color: 'rgba(255,255,255,0.8)'
            },
            borderColor: 'rgba(255,255,255,0.9)',
            backgroundColor: 'rgba(255,255,255,0.5)',
            extraCssText: 'box-shadow: 2px 2px 4px 0px rgba(255,255,255,0.5);'
        },
        series: [
            {
            type: 'pie',
            radius: ['50%', '72%'],
            center: ['50%', '50%'],
            minAngle: 1,
            labelLine: {
                show: false
            },
            label: {
                show: false,
            },
            itemStyle: {
                normal: {
                color: function (params) {
                    return colorList1[params.dataIndex]
                }
                }
            },
            data: data1,
            z: 666
            },
            {
            type: 'pie',
            radius: ['80%', '85%'],
            center: ['50%', '50%'],
            hoverAnimation: false,
            minAngle: 1,
            emphasis: { scale: false },
            label: {
                show: false
            },
            itemStyle: {
                normal: {
                color: function (params) {
                    return colorList2[params.dataIndex]
                }
                }
            },
            data: data1,
            z: 1
            },
        ]
        }

        // 3. 把配置项给实例对象
        myChart.setOption(option);
        // 4.跟随屏幕自适应
        window.addEventListener("resize", function() {
            myChart.resize({animation: {duration:1000}});
        });
 
    }

    // 风险趋势折线图
    fengxianTrendChart()
    function fengxianTrendChart(){
        // 1. 实例化对象
        var myChart = echarts.init(document.querySelector('#fengxianTrend'))
        // 2. 指定配置项和数据
        const data = new Array(12).fill(null).map(item => {
            return {
               value: Math.ceil(Math.random() * 600) + 100
            }
         })
         option = {
            backgroundColor:'#061d6e84',
            color: ['#0184d5'],
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
                  shadowColor: "rgba(1, 132, 213, 1)",
                  shadowBlur: 20
                },
                areaStyle: {
                  opacity: 1,
                  //右下左上
                  color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                    {
                      offset: 0,
                      color: 'rgba(1, 132, 213, 0.7)'
                    },
                    {
                      offset: 0.3,
                      color: 'rgba(1, 132, 213, 0.4)'
                    },
                    {
                      offset: 1,
                      color: 'rgba(1, 132, 213, 0.1)'
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

    // 柱状图
    fengxianTypeChart()
    function fengxianTypeChart(){
        // 1. 实例化对象
        var myChart = echarts.init(document.querySelector('#fengxianType'))
        // 2. 指定配置项和数据
        
        let dataAxis = ['aaaaaa点', 'aaaaaa击', 'aaa柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
        
        let data = [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];

            option = {
                grid: {
                    left: '1%',
                    right: '1%',
                    top: '5%',
                    containLabel: true
                },
                xAxis: {
                    data: dataAxis, // x轴数据
                    axisLabel: {
                        interval: 0, // x轴标签显示间隔
                        inside: false, // x轴标签是否朝内显示
                        color: '#fff', // x轴标签颜色
                        rotate: 0 // x轴标签旋转角度
                    },
                    axisTick: {
                        show: false // x轴刻度线是否显示
                    },
                    axisLine: {
                        show: false // x轴轴线是否显示
                    },
                    splitLine: {
                        show: false, // x轴分割线是否显示
                        lineStyle: {
                        color: "red" // x轴分割线颜色
                        }
                    },
                    z: 10
                },
                yAxis: {
                axisLine: {
                    show: false // y轴轴线是否显示
                },
                axisTick: {
                    show: false // y轴刻度线是否显示
                },
                axisLabel: {
                    color: '#fff' // y轴标签颜色
                },
                splitLine: {
                    show: false, // y轴分割线是否显示
                    lineStyle: {
                    color: "red" // y轴分割线颜色
                    }
                }
                },
                dataZoom: [{
                    type: 'slider', // 设置滚动条类型为slider
                    orient: 'horizontal', // 设置滚动条方向为横向
                    start: 0, // 设置默认开始位置
                    end: 30 // 设置默认结束位置
                  }],
                series: [
                {
                    type: 'bar',
                    showBackground: true,
                    itemStyle: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        { offset: 0, color: '#83bff6' }, // 渐变色起始颜色
                        { offset: 0.5, color: '#188df0' }, // 渐变色中间颜色
                        { offset: 1, color: '#188df0' } // 渐变色结束颜色
                    ])
                    },
                    emphasis: {
                    itemStyle: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        { offset: 0, color: '#2378f7' }, // 高亮渐变色起始颜色
                        { offset: 0.7, color: '#2378f7' }, // 高亮渐变色中间颜色
                        { offset: 1, color: '#83bff6' } // 高亮渐变色结束颜色
                        ])
                    }
                    },
                    data: data // 数据
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
    
    // 地图1
    mapChart()
    function mapChart(){

        var myChart1 = echarts.init(document.getElementById('mapChart1'));

        var allData = [
            {
                name: "海口市",
                list:[
                    {
                        id: 1,
                        name: "测试1",
                    },
                    {
                        id: 2,
                        name: "测试2",
                    },
                    {
                        id: 3,
                        name: "测试3",
                    },
                ]
            },
            {
                name: "文昌市",
                list:[
                    {
                        id: 4,
                        name: "测试4",
                    },
                    {
                        id: 5,
                        name: "测试5",
                    },
                    {
                        id: 6,
                        name: "测试6",
                    },
                ]
            }
        ]

        var dataList = [
            { name: '海口市', value: 218 },
            { name: '文昌市', value: 78 },
            { name: '琼海市', value: 18 },
            { name: '临高市', value: 8 },
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
                visualMap: {
                    min: 0,
                    max: 100000,
                    left: 26,
                    bottom: 40,
                    showLabel: true,
                    textStyle: {
                        color: '#fff'
                    },
                    pieces: [{
                        gt: 1000,
                        label: "> 1000个",
                        color: "#e64b45"
                    }, {
                        gte: 500,
                        lte: 1000,
                        label: "500 - 1000个",
                        color: "#0a64b9"
                    }, {
                        gte: 100,
                        lt: 500,
                        label: "100 - 500个",
                        color: "#0a64a5"
                    }, {
                        gte: 10,
                        lt: 100,
                        label: "10 - 100个",
                        color: "#1979c0"
                    }, {
                        gte: 1,
                        lt: 10,
                        label: "1 - 10个",
                        color: "#2e8ece"
                    }],
                    show: true
                },
                // 悬浮框
                tooltip: {
                    padding: 0,
                    // position: [10, 90],
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
                            if(params.name==allData[i].name){
                                var listHtml = allData[i].list.map(function (item) {
                                    return '<div class="item">' + item.name + '</div>';
                                }).join('');
                                return `
                                    <div class="tooltip">
                                        <div class="left">
                                            <div class="area">${allData[i].name}</div>
                                            <div class="num"><span>688</span>个</div>
                                            <div class="text">项目总数</div>
                                        </div>
                                        <div class="right">
                                            <input type="text" id="searchBox" class="search-input" placeholder="请输入搜索关键字">
                                            <div class="list">
                                                ${listHtml}
                                            </div>
                                        </div>
                                    </div>
                                `
                            }
                        }

                    },

                },

                toolbox: {
                    show: true,
                    feature: {
                        dataZoom: {
                        yAxisIndex: "none"
                    },
                    dataView: {
                        readOnly: false
                    },
                    magicType: {
                        type: ["line", "bar"]
                    },
                    restore: {},
                    saveAsImage: {
                        type: "png"
                    }
                }
                },

                geo: {
                    map: "hainan",
                    // 底层添加边框
                    itemStyle: {
                        borderColor: "#4394f0",
                        borderWidth: 5,
                        shadowBlur: 20, // 阴影模糊大小
                        shadowColor: "rgba(67,148,240, 0.8)" // 阴影颜色
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
                            color: '#fff',
                            emphasis: {// 这个是鼠标移上去就会选中的样式，鼠标mouseover
                                color: '#fff'
                            },
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
                                borderWidth: 1, //边框大小
                                borderColor: "#4394f0",
                                areaColor: "#005be3", //背景颜色
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
                            borderColor:'#0060ff',
                            areaColor:"#0019d7",
                            textStyle: {
                                color: '#fff',
                            }
                        },
                        //重点下面，与点击事件不同，虽然也是点击选中，但是事件不一样
                        selectedMode:"single", //选择模式，单选，只能选中一个地市
                        select:{//这个就是鼠标点击后，地图想要展示的配置
                            disabled:true,//可以被选中
                            itemStyle:{//相关配置项很多，可以参考echarts官网
                                
                            }
                        },


                        },
                        data: dataList
                },
                    
            ],
            };

        // 使用刚指定的配置项和数据显示图表
        myChart1.setOption(option);

        // 将搜索框事件注册到window对象
        window.addEventListener('input', function(event) {
            if (event.target.id === 'searchBox') {
                var keyword = event.target.value;
                // 在这里进行搜索逻辑的处理
                console.log(event);
                $('.search-input').on('input', function() {
                    var keyword = $(this).val().trim();
                    search(keyword);
                    console.log('111');
                });
        
                function search(keyword) {
                    var items = $('.tooltip .list .item');
                    items.removeClass('hidden');
        
                    if (keyword !== '') {
                    items.each(function() {
                        var itemText = $(this).text();
                        if (!itemText.includes(keyword)) {
                        $(this).addClass('hidden');
                        }
                    });
                    }
                }
            }
        });

        // 4.跟随屏幕自适应
        window.addEventListener("resize", function() {
            myChart1.resize({animation: {duration:1000}});
        });
        });
    }

    mapChart2()
    function mapChart2(){

        var myChart1 = echarts.init(document.getElementById('mapChart2'));

        var allData = [
            {
                name: "海口市",
                list:[
                    {
                        id: 1,
                        name: "测试1",
                    },
                    {
                        id: 2,
                        name: "测试2",
                    },
                    {
                        id: 3,
                        name: "测试3",
                    },
                ]
            },
            {
                name: "文昌市",
                list:[
                    {
                        id: 4,
                        name: "测试4",
                    },
                    {
                        id: 5,
                        name: "测试5",
                    },
                    {
                        id: 6,
                        name: "测试6",
                    },
                ]
            }
        ]

        var dataList = [
            { name: '海口市', value: 218 },
            { name: '文昌市', value: 78 },
            { name: '琼海市', value: 18 },
            { name: '临高市', value: 8 },
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
                visualMap: {
                    min: 0,
                    max: 100000,
                    left: 26,
                    bottom: 40,
                    showLabel: true,
                    textStyle: {
                        color: '#fff'
                    },
                    pieces: [{
                        gt: 1000,
                        label: "> 1000个",
                        color: "#e64b45"
                    }, {
                        gte: 500,
                        lte: 1000,
                        label: "500 - 1000个",
                        color: "#0a64b9"
                    }, {
                        gte: 100,
                        lt: 500,
                        label: "100 - 500个",
                        color: "#0a64a5"
                    }, {
                        gte: 10,
                        lt: 100,
                        label: "10 - 100个",
                        color: "#1979c0"
                    }, {
                        gte: 1,
                        lt: 10,
                        label: "1 - 10个",
                        color: "#2e8ece"
                    }],
                    show: true
                },
                // 悬浮框
                tooltip: {
                    padding: 0,
                    // position: [10, 90],
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
                            if(params.name==allData[i].name){
                                var listHtml = allData[i].list.map(function (item) {
                                    return '<div class="item">' + item.name + '</div>';
                                }).join('');
                                return `
                                    <div class="tooltip">
                                        <div class="left">
                                            <div class="area">${allData[i].name}</div>
                                            <div class="num"><span>688</span>个</div>
                                            <div class="text">项目总数</div>
                                        </div>
                                        <div class="right">
                                            <input type="text" id="searchBox" class="search-input" placeholder="请输入搜索关键字">
                                            <div class="list">
                                                ${listHtml}
                                            </div>
                                        </div>
                                    </div>
                                `
                            }
                        }

                    },
                },

                toolbox: {
                    show: true,
                    feature: {
                        dataZoom: {
                        yAxisIndex: "none"
                    },
                    dataView: {
                        readOnly: false
                    },
                    magicType: {
                        type: ["line", "bar"]
                    },
                    restore: {},
                    saveAsImage: {
                        type: "png"
                    }
                }
                },

                geo: {
                    map: "hainan",
                    // 底层添加边框
                    itemStyle: {
                        borderColor: "#ff5800",
                        borderWidth: 5,
                        shadowBlur: 20, // 阴影模糊大小
                        shadowColor: "rgba(255,162,0,.8)" // 阴影颜色
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
                            color: '#fff',
                            emphasis: {// 这个是鼠标移上去就会选中的样式，鼠标mouseover
                                color: '#fff'
                            },
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
                                borderWidth: 1, //边框大小
                                borderColor: "#4394f0",
                                areaColor: "#005be3", //背景颜色
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
                            borderColor:'#ff9000',
                            areaColor:"#ff4800",
                        },
                        //重点下面，与点击事件不同，虽然也是点击选中，但是事件不一样
                        selectedMode:"single", //选择模式，单选，只能选中一个地市
                        select:{//这个就是鼠标点击后，地图想要展示的配置
                            disabled:true,//可以被选中
                            itemStyle:{//相关配置项很多，可以参考echarts官网
                                
                            }
                        },


                        },
                        data: dataList
                },
                    
            ],
            };

        // 使用刚指定的配置项和数据显示图表
        myChart1.setOption(option);

        // 将搜索框事件注册到window对象
        window.addEventListener('input', function(event) {
            if (event.target.id === 'searchBox') {
                var keyword = event.target.value;
                // 在这里进行搜索逻辑的处理
                console.log(event);
                $('.search-input').on('input', function() {
                    var keyword = $(this).val().trim();
                    search(keyword);
                    console.log('111');
                });
        
                function search(keyword) {
                    var items = $('.tooltip .list .item');
                    items.removeClass('hidden');
        
                    if (keyword !== '') {
                    items.each(function() {
                        var itemText = $(this).text();
                        if (!itemText.includes(keyword)) {
                        $(this).addClass('hidden');
                        }
                    });
                    }
                }
            }
        });

        
        // 4.跟随屏幕自适应
        window.addEventListener("resize", function() {
            myChart1.resize({animation: {duration:1000}});
        });
        });
    }

    mapChart3()
    function mapChart3(){

        var myChart1 = echarts.init(document.getElementById('mapChart3'));

        var allData = [
            {
                name: "海口市",
                list:[
                    {
                        id: 1,
                        name: "测试1",
                    },
                    {
                        id: 2,
                        name: "测试2",
                    },
                    {
                        id: 3,
                        name: "测试3",
                    },
                ]
            },
            {
                name: "文昌市",
                list:[
                    {
                        id: 4,
                        name: "测试4",
                    },
                    {
                        id: 5,
                        name: "测试5",
                    },
                    {
                        id: 6,
                        name: "测试6",
                    },
                ]
            }
        ]

        var dataList = [
            { name: '海口市', value: 218 },
            { name: '文昌市', value: 78 },
            { name: '琼海市', value: 18 },
            { name: '临高市', value: 8 },
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
                visualMap: {
                    min: 0,
                    max: 100000,
                    left: 26,
                    bottom: 40,
                    showLabel: true,
                    textStyle: {
                        color: '#fff'
                    },
                    pieces: [{
                        gt: 1000,
                        label: "> 1000个",
                        color: "#e64b45"
                    }, {
                        gte: 500,
                        lte: 1000,
                        label: "500 - 1000个",
                        color: "#0a64b9"
                    }, {
                        gte: 100,
                        lt: 500,
                        label: "100 - 500个",
                        color: "#0a64a5"
                    }, {
                        gte: 10,
                        lt: 100,
                        label: "10 - 100个",
                        color: "#1979c0"
                    }, {
                        gte: 1,
                        lt: 10,
                        label: "1 - 10个",
                        color: "#2e8ece"
                    }],
                    show: true
                },
                // 悬浮框
                tooltip: {
                    padding: 0,
                    // position: [10, 90],
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
                            if(params.name==allData[i].name){
                                var listHtml = allData[i].list.map(function (item) {
                                    return '<div class="item">' + item.name + '</div>';
                                }).join('');
                                return `
                                    <div class="tooltip">
                                        <div class="left">
                                            <div class="area">${allData[i].name}</div>
                                            <div class="num"><span>688</span>个</div>
                                            <div class="text">项目总数</div>
                                        </div>
                                        <div class="right">
                                            <input type="text" id="searchBox" class="search-input" placeholder="请输入搜索关键字">
                                            <div class="list">
                                                ${listHtml}
                                            </div>
                                        </div>
                                    </div>
                                `
                            }
                        }

                    },
                },

                toolbox: {
                    show: true,
                    feature: {
                        dataZoom: {
                        yAxisIndex: "none"
                    },
                    dataView: {
                        readOnly: false
                    },
                    magicType: {
                        type: ["line", "bar"]
                    },
                    restore: {},
                    saveAsImage: {
                        type: "png"
                    }
                }
                },

                geo: {
                    map: "hainan",
                    // 底层添加边框
                    itemStyle: {
                        borderColor: "#dd0000",
                        borderWidth: 5,
                        shadowBlur: 20, // 阴影模糊大小
                        shadowColor: "rgba(255,72,0,.8)" // 阴影颜色
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
                            color: '#fff',
                            emphasis: {// 这个是鼠标移上去就会选中的样式，鼠标mouseover
                                color: '#fff'
                            },
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
                                borderWidth: 1, //边框大小
                                borderColor: "#4394f0",
                                areaColor: "#005be3", //背景颜色
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
                            borderColor:'#ff4800',
                            areaColor:"#dd0000",
                        },
                        //重点下面，与点击事件不同，虽然也是点击选中，但是事件不一样
                        selectedMode:"single", //选择模式，单选，只能选中一个地市
                        select:{//这个就是鼠标点击后，地图想要展示的配置
                            disabled:true,//可以被选中
                            itemStyle:{//相关配置项很多，可以参考echarts官网
                                
                            }
                        },


                        },
                        data: dataList
                },
                    
            ],
            };

        // 使用刚指定的配置项和数据显示图表
        myChart1.setOption(option);

        // 将搜索框事件注册到window对象
        window.addEventListener('input', function(event) {
            if (event.target.id === 'searchBox') {
                var keyword = event.target.value;
                // 在这里进行搜索逻辑的处理
                console.log(event);
                $('.search-input').on('input', function() {
                    var keyword = $(this).val().trim();
                    search(keyword);
                    console.log('111');
                });
        
                function search(keyword) {
                    var items = $('.tooltip .list .item');
                    items.removeClass('hidden');
        
                    if (keyword !== '') {
                    items.each(function() {
                        var itemText = $(this).text();
                        if (!itemText.includes(keyword)) {
                        $(this).addClass('hidden');
                        }
                    });
                    }
                }
            }
        });

        
        // 4.跟随屏幕自适应
        window.addEventListener("resize", function() {
            myChart1.resize({animation: {duration:1000}});
        });
        });
    }


})