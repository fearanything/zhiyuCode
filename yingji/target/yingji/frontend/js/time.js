// 取消1秒空白 先调用函数
getTime()
// 开启计时器 间隙函数
setInterval(getTime,1000)

function getTime(){
// 实例化对象
let date = new Date()
let year = date.getFullYear()
let month = date.getMonth() + 1
let day = date.getDate()
let hour = date.getHours()
let min = date.getMinutes()
let sec = date.getSeconds()
let times = document.querySelector('.times')
if(day >= 1 && day <= 9){
	day = '0' + day
}
if(hour >= 0 && hour <= 9){
	hour = '0' + hour
}
if(min >= 0 && min <= 9){
	min = '0' + min
}
if(sec >= 0 && sec <= 9){
	sec = '0' + sec
}
times.innerHTML = `
时间: ${year}-${month}-${day} ${hour}:${min}:${sec}
`
}