<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="container">
    <a href="<%=basePath%>frontend/mobile/backlog" id="icon1">
        <img src="frontend/HKrepairs/img/backlog-icon.png" alt="">
        <span>待办</span>
    </a>
    <a href="<%=basePath%>frontend/mobile/goAdd" id="icon2">
        <img src="frontend/HKrepairs/img/new-icon.png" alt="">
        <span>新建</span>
    </a>
    <a href="<%=basePath%>frontend/mobile/myself" id="icon3">
        <img src="frontend/HKrepairs/img/myself-icon.png" alt="">
        <span>我的</span>
    </a>
</div>

<script src="frontend/HKrepairs/js/jquery-3.1.1.min.js?v=1.0.1"></script>

<script>
        let timerForDebounce = null; //为了防抖添加的timer
        window.addEventListener('scroll',function () {
            //已经滚动到上面的页面高度
            if (timerForDebounce) clearTimeout(timerForDebounce);
            var scrollTop = parseFloat($(this).scrollTop()),
                //页面高度
                scrollHeight = $(document).height(),
                //浏览器窗口高度
                windowHeight = parseFloat($(this).height()),
                totalHeight = scrollTop + windowHeight;

            //此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
            if (scrollTop + windowHeight >= scrollHeight -800) {
                timerForDebounce = setTimeout(() =>{
                    tab();
                },200)
            }
        })
</script>
