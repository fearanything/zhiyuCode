var bodyStyle = document.createElement('style')
var docWidth, docHeight;
var designWidth, designHeight;

// 屏幕缩放实现
function refreshScale() {
    bodyStyle.innerHTML = `body{width:${designWidth}px; height:${designHeight}px!important;}`
    document.documentElement.firstElementChild.appendChild(bodyStyle)
    document.getElementById('main').style = 'display:flex'


    var widthRatio = docWidth / designWidth,
        heightRatio = docHeight / designHeight;
    document.body.style = `transform:scale(${widthRatio},${heightRatio});transform-origin:left top;`;
    // 应对浏览器全屏切换前后窗口因短暂滚动条问题出现未占满情况
    setTimeout(function () {
        var lateWidth = document.documentElement.clientWidth,
            lateHeight = document.documentElement.clientHeight;
        if (lateWidth === docWidth) return;

        widthRatio = lateWidth / designWidth
        heightRatio = lateHeight / designHeight
        document.body.style = "transform:scale(" + widthRatio + "," + heightRatio + ");transform-origin:0 0;"
    }, 0)
}



// 清除scale
function clearScale() {
    // 清除pc样式
    bodyStyle.innerHTML = ``
    document.documentElement.firstElementChild.appendChild(bodyStyle)
    document.body.style = "transform:none;transform-origin:none"
}

// 初始化
function init() {
    // 获取当前屏幕可视区域大小
    docWidth = document.documentElement.clientWidth;
    docHeight = document.documentElement.clientHeight;
    
        let mainClass = document.getElementById('main').classList;
        if (docWidth == 2140 || docWidth == 3000) { // 模拟大屏
            designWidth = docWidth;
            designHeight = docWidth / 28 * 9;
            mainClass.add('large');
            mainClass.remove('pc');
            largePage();
        } else {  // pc
            designWidth = 1920;
            designHeight = 1080;
            mainClass.add('pc');
            mainClass.remove('large');
            refreshScale()
        }
    
}

// 大屏设置 rem 函数
function setRem(designSize) {
    // 基准大小
    baseSize = 100;
    let basePc = baseSize / designSize; // 表示1680的设计图,使用100PX的默认值
    let vW = window.innerWidth; // 当前窗口的宽度

    let rem = vW * basePc; // 以默认比例值乘以当前窗口宽度,得到该宽度下的相应font-size值
    document.documentElement.style.fontSize = rem + "px";
}

// 大屏页面
function largePage() {
    clearScale();
    document.getElementById('main').style = 'display:flex'
    document.getElementsByClassName('mobile')[0].style = 'display:none'
    // 大屏 设置 rem 函数
    let designSize = 2140;
    setRem(designSize);
}


// 初始化
init();

// 监听前进/后退以及load事件触发
window.addEventListener("pageshow", function (e) {
    if (e.persisted) { // 浏览器后退的时候重新计算
        init()
    }
}, false);

// 监听屏幕缩放
window.addEventListener("resize", function () {
    init()
}, false);