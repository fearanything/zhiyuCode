// 水球图
(function(){
    var liqiudList = new Array()
    var liqiud = $('div.liqiud')
    for(var i = 0; i < liqiud.length; i++){
        var liqiudId = liqiud.eq(i).attr("id")
        var liqiudList = liqiudList.concat(liqiudId)
    }
    console.log(liqiudList);

    for(var j = 0; j < liqiudList.length; j++){
        var myChart = echarts.init(document.querySelector(`#${liqiudList[j]}`))
        option = {
            series: [{
                type: 'liquidFill',
                name: 'Liquid Fill',
                radius: '70%',
                itemStyle: {
                    opacity: 0.55,
                },
                data: [{
                    name: 'score',
                    direction: 'right',
                    value: .8,
                    itemStyle: {
                        // opacity: 0.55,
                        normal: {
                            color: '#02CDF6',
                        }
                    },
                },
                    {
                        name: 'scores',
                        direction: 'right',
                        value: 0.69,
                        itemStyle: {
                            opacity: 0.55,
                            normal: {
                                color: '#134892'
                            }
                        }
                    },
                    {
                        name: 'scorex',
                        direction: 'right',
                        value: 0.45,
                        itemStyle: {
                            opacity: 0.55,
                            normal: {
                                // color: 'red'
                            }
                        }
                    }],
                backgroundStyle: {   // 设置水球图内部背景色
                    // borderColor: '#4348EC',
                    // borderWidth: 10,
                    color: "transparent",//水球图内部背景色
                },
                itemStyle: {
                    opacity: 0.55,
                    // shadowBlur: 50,
                    // shadowColor: 'rgba(0, 0, 0, 0.4)',
                },
                label: {   // 设置百分比展示
                    color: '#02CDF6',
                    normal: {
                        textStyle: {
                            fontSize: 20,
                        },
                        formatter: function (param) {
                            return param.value * 100 + '%';
                        }
                    }
                },
                // outline: { // 是否显示外圈
                //   show: false
                // }
            }],
        }
        // 3. 把配置项给实例对象
        myChart.setOption(option)
        // 4.跟随屏幕自适应
        window.addEventListener("resize", function() {
            myChart.resize({animation: {duration:1000}});
        })
    }
})();