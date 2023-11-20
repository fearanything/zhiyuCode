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
    