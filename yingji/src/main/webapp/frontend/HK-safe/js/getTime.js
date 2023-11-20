var t = null
// 开始运行
t = setTimeout(time,1000)

function time(){
    // 清除定时器
    clearTimeout(t)
    date = new Date()
    var year = date.getFullYear()
    var month = date.getMonth() + 1
    var day = date.getDate()
    var hour = date.getHours()
    var minute = date.getMinutes()
    var second = date.getSeconds()

    document.querySelector(".showTime").innerHTML = '当前时间：' + year + '年' + month + '月' + day + '日' + '-' + hour + '时' + minute + '分' + second + '秒'

    // 设定定时器,循环运行
    t = setTimeout(time,1000)
}