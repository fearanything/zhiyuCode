
  getData()

  function getData(){
    // 隐患总数
    $.ajax({
    url: "frontend/HK-safe/json/dangerAll.json",
    type: "GET",
    dataType: "json",
    async: false,
    success: function(res){
        console.log("dangerAll:",res);
        // $(".danger-all").append(`<p id="dangerAll">${res.dangerAll[1].data}</p>`)
        $("#dangerNum").html(res.dangerAll[0].data)
        $("#finishNum").html(res.dangerAll[1].data)
        $("#untreatedNum").html(res.dangerAll[2].data)
        $("#overdueNum").html(res.dangerAll[3].data)
        $("#danger-Y").html(res.dangerYQM[0].data)
        $("#danger-Q").html(res.dangerYQM[1].data)
        $("#danger-M").html(res.dangerYQM[2].data)
        $("#danger-great").html(res.dangerLevel[0].data)
        $("#danger-common").html(res.dangerLevel[1].data)
      },
    })

    // 隐患整改
    $.ajax({
      url: "frontend/HK-safe/json/rectify.json",
      type: "GET",
      dataType: "json",
      async: false,
      success: (res) => {
        console.log("rectify:",res);

        rectify(res);
      }
    })

    // 隐患类别
    $.ajax({
      url: "frontend/HK-safe/json/category.json",
      type: "GET",
      dataType: "json",
      async: false,
      success: (res) => {
        console.log("category:",res);
        category(res)
      }
    })

    // 二级隐患总数
    $.ajax({
      url: "frontend/HK-safe/json/rectifyAll.json",
      type: "GET",
      dataType: "json",
      async: false,
      success: (res) => {
        console.log("rectifyAll:",res);
        rectifyAll(res)
      }
    })

    // 二级整整改率
    $.ajax({
      url: "frontend/HK-safe/json/rectification.json",
      type: "GET",
      dataType: "json",
      async: false,
      success: (res) => {
        console.log("rectification:",res);
        rectification(res)
      }
    })

    // 各隐患统计
    $.ajax({
      url: "frontend/HK-safe/json/factor.json",
      type: "GET",
      dataType: "json",
      async: false,
      success: (res) => {
        console.log("factor:",res);
        factor(res)
      }
    })
    
    // 隐患数量趋势
    $.ajax({
      url: "frontend/HK-safe/json/trend.json",
      type: "GET",
      dataType: "json",
      async: false,
      success: (res) => {
        console.log("trend:",res);
        trend(res)
      }
    })
}

// 隐患整改柱状图
function rectify(data){
  // 1. 实例化对象
  var myChart = echarts.init(document.querySelector('.rectify-chart'))
  var app = {}
      const posList = [
      'left',
      'right',
      'top',
      'bottom',
      'inside',
      'insideTop',
      'insideLeft',
      'insideRight',
      'insideBottom',
      'insideTopLeft',
      'insideTopRight',
      'insideBottomLeft',
      'insideBottomRight'
  ];
  app.configParameters = {
      rotate: {
          min: -90,
          max: 90
      },
      align: {
          options: {
              left: 'left',
              center: 'center',
              right: 'right'
          }
      },
      verticalAlign: {
          options: {
              top: 'top',
              middle: 'middle',
              bottom: 'bottom'
          }
      },
      position: {
          options: posList.reduce(function (map, pos) {
              map[pos] = pos;
              return map;
          }, {})
      },
      distance: {
          min: 0,
          max: 100
      }
  };
      app.config = {
          rotate: 0,
          align: 'cennter',
          verticalAlign: 'top',
          position: 'top',
          distance: 20,
      onhange: function () {
          const labelOption = {
              rotate: app.config.rotate,
              align: app.config.align,
              verticalAlign: app.config.verticalAlign,
              position: app.config.position,
              distance: app.config.distance
        };
        myChart.setOption({
          series: [
            {
              label: labelOption
            },
            {
              label: labelOption
            },
            {
              label: labelOption
            },
            {
              label: labelOption
            }
          ]
        });
      }
    };
    const labelOption = {
      show: false,
      position: app.config.position,
      distance: app.config.distance,
      align: app.config.align,
      verticalAlign: app.config.verticalAlign,
      rotate: app.config.rotate,
      
      fontSize: 12,
      color: '#fff',
      rich: {
        name: {}
      }
    };

  // 2. 指定配置项和数据
  var option =  {
            color: ["#a0eb7d", "#eb7d7d", "#ebca7d"],
            tooltip: {
              trigger: 'axis',
              axisPointer: {
                type: 'shadow'
              }
            },
            // 修改图标大小
            grid: {
                left: '0',
                top: '15%',
                right: '10%',    
                bottom: '0',    
                containLabel: true  
            },
            legend: {
              barBorderRadius: [10, 10, 0, 0],
              data: [
                {
                    name: '已处理',
                    textStyle:{
                        color: '#fff'
                    }
                }, 
                {
                    name: '未处理',
                    textStyle:{
                        color: '#fff'
                    }
                }, 
                {
                    name: '逾期',
                    textStyle:{
                        color: '#fff'
                    }
                }, 
            ]
            },
            toolbox: {
              show: true,
              orient: 'vertical',
              left: 'right',
              top: 'center',
              feature: {
                mark: { show: true },
                dataView: { show: true, readOnly: false },
                magicType: { show: true, type: ['line', 'bar', 'stack'] },
                restore: { show: true },
                saveAsImage: { show: true }
              }
            },
            xAxis: [
              {
                type: 'category',
                axisTick: { show: false },
                data: ['周一', '周二', '周三', '周四', '周五'],
                axisLine:{
                    lineStyle:{
                        color: '#fff'
                    }
                },
              },
            ],
            yAxis: [
              {
                type: 'value',
                axisLine:{
                    lineStyle:{
                        color: '#fff'
                    }
                },
                // 修改y轴分割线的颜色
              splitLine: {
                lineStyle: {
                  color: "#012f4a"
                    }
                }
              }
            ],
            series: [
              {
                name: '已处理',
                type: 'bar',
                label: labelOption,
                emphasis: {
                  focus: 'series'
                },
                data: [],
                itemStyle: {
                  barBorderRadius: [5, 5, 0, 0]
                }
              },
              {
                name: '未处理',
                type: 'bar',
                label: labelOption,
                emphasis: {
                  focus: 'series'
                },
                data: [],
                itemStyle: {
                  barBorderRadius: [5, 5, 0, 0]
                }
              },
              {
                name: '逾期',
                type: 'bar',
                label: labelOption,
                emphasis: {
                  focus: 'series'
                },
                data: [],
                itemStyle: {
                  barBorderRadius: [5, 5, 0, 0]
                }
              }
            ]
          };
          for(var i = 0; i < data.finish.length; i++){
            option.series[0].data.push(data.finish[i].value)
          };
          for(var i = 0; i < data.unfinish.length; i++){
            option.series[1].data.push(data.unfinish[i].value)
          };
          for(var i = 0; i < data.overdue.length; i++){
            option.series[2].data.push(data.overdue[i].value)
          };
  // 3. 把配置项给实例对象
  myChart.setOption(option)
  // 4.跟随屏幕自适应
  window.addEventListener("resize", function() {
      myChart.resize({animation: {duration:1000}});
  })
}

// 隐患排名饼图
function category(data){
  // 1. 实例化对象
  var myChart = echarts.init(document.querySelector('.category .category-chart'))

  // 2. 指定配置项和数据
  option = {
    title: {
      left: 'center'
    },
    tooltip: {
      trigger: 'item'
    },
    legend: {
      show: false,
      orient: 'horizontal',
      top: '0',
      textStyle: {
        color: '#fff'
      }
    },
    series: [
      {
        name: '各隐患类别排名',
        type: 'pie',
        radius: '60%',
        center: ['50%', '50%'],
        label: {
          normal : {
            formatter: '{b}: ({d}%)',
            textStyle:{
              fontWeight : 'normal',
              fontSize : 10,
              color: '#fff',
            }
            }
        },
        data: [],
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
    ]
  };
  for(var i = 0; i < data.length; i++){
    option.series[0].data.push(data[i])
  }
  // 3. 把配置项给实例对象
  myChart.setOption(option)
  // 4.跟随屏幕自适应
  window.addEventListener("resize", function() {
      myChart.resize({animation: {duration:1000}});
  })
}


// 二级隐患总数柱状图
function rectifyAll(data){
  // 1. 实例化对象
  var myChart = echarts.init(document.querySelector('.rectifyAll .rectifyAll-chart'))

  
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
      top: '1%',
      left: '1%',
      right: '10%',
      bottom: '0',
      containLabel: true
    },
    xAxis: {
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
      data: [],
      inverse: "true",
      axisLabel: {
        textStyle: {
          color: "rgba(255,255,255,.6)",
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
              color: '#ff884d'
            }, 
            {
              offset: 0,
              color: '#ffc080'
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
  for(var i = 0; i < data.length; i++){
    option.yAxis.data.push(data[i].name)
    option.series[0].data.push(data[i].value)
  }
  // 3. 把配置项给实例对象
  myChart.setOption(option)
  // 4.跟随屏幕自适应
  window.addEventListener("resize", function() {
      myChart.resize({animation: {duration:1000}});
  })
}

// 二级整改率柱状图
function rectification(data){
  // 1. 实例化对象
  var myChart = echarts.init(document.querySelector('.rectification .rectification-chart'))
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
      top: '1%',
      left: '1%',
      right: '10%',
      bottom: '0',
      containLabel: true
    },
    xAxis: {
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
      data: [],
      inverse: "true",
      axisLabel: {
        textStyle: {
          color: "rgba(255,255,255,.6)",
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
              color: '#4d76ff'
            }, 
            {
              offset: 0,
              color: '#80aaff'
            }
          ]),
          barBorderRadius: [10, 10, 10, 10]
          }
        },
        label: {
          normal: {
            show: true,
            position: "outside",
            formatter: "{c}%",
            textStyle: {
              color: '#fff',
            }
          }
        }
      },
    ]
  };

  for(i = 0; i < data.length; i++){
    option.yAxis.data.push(data[i].name)
    option.series[0].data.push(data[i].value)
  }
  // 3. 把配置项给实例对象
  myChart.setOption(option)
  // 4.跟随屏幕自适应
  window.addEventListener("resize", function() {
      myChart.resize({animation: {duration:1000}});
  })
}


// 隐患因素饼图
function factor(data){
  // 1. 实例化对象
  var myChart = echarts.init(document.querySelector('.factor .factor-chart'))
  // 2. 指定配置项和数据
  option = {
  tooltip: {
    trigger: 'item',
  },
  legend: {
    top: '0%',
    left: 'center',
    textStyle: {
      color: '#fff',
    }
  },
  series: [
    {
      name: '各隐患隐患因素统计',
      type: 'pie',
      center: ['50%', '60%'],
      radius: ['40%', '80%'],
      avoidLabelOverlap: false,
      itemStyle: {
        borderRadius: 10,
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
      data: []
    }
  ]
};
for(i = 0; i < data.length; i++){
  option.series[0].data.push(data[i])
}
  // 3. 把配置项给实例对象
  myChart.setOption(option)
  // 4.跟随屏幕自适应
  window.addEventListener("resize", function() {
      myChart.resize({animation: {duration:1000}});
  })
}

// 隐患趋势折线图
function trend(data){
  // 1. 实例化对象
  var myChart = echarts.init(document.querySelector('.trend .trend-chart'))
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
  for(i = 0; i < data.processed.length; i++){
    option.series[0].data.push(data.processed[i])
    option.series[1].data.push(data.untreated[i])
  }
  // 3. 把配置项给实例对象
  myChart.setOption(option);
  // 4.跟随屏幕自适应
  window.addEventListener("resize", function() {
      myChart.resize({animation: {duration:1000}});
  });
}
