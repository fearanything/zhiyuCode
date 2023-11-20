var chartDom = document.getElementById('lChart');
        var myChart = echarts.init(chartDom);
        var option;
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
                    offset: 0, color: 'red' // 0% 处的颜色
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
                data: ["${WATER_DATETIME_STR}"],
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
                min:0,
                max:50,
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
                data: ["${WATER_DATA_STR}"],
                type: 'line',
                areaStyle: {}
                }
            ]
            };
            myChart.setOption(option);