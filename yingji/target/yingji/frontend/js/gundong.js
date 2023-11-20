/*新闻滚动*/  
$(function(){  
        //将$(".scrollNews")对象作为参数传递给scollNews()函数的参数  
        var $this = $(".scrollNews");  
        //滚动定时器变量  
        var scrollTimer;  
        //hover()方法的含义是鼠标滑入滑出，它对应着两个事件，即mouseenter和mouseleave，因此可通过trigger("mouseleave")来触发hover事件的第二个函数  
        $this.hover(  
                function(){  
                        clearInterval(scrollTimer);  
                },  
                function(){  
                        scrollTimer = setInterval(function(){  
                                scrollNews( $this );//每3秒执行一次scrollNews函数  
                        }, 3000 );  
                }  
        ).trigger("mouseleave");//当用户进入页面后就会触发hover事件的第二个函数，从而使内容滚动起来  

});  
function scrollNews(obj){  
var $self = obj.find("ul:first"); //找到第一个ul元素  
var lineHeight = $self.find("li:first").height(); //获取第一个li元素的行高  
$self.animate({ "marginTop" : -lineHeight +"px" }, 600 , function(){  
        //alert($self.css({marginTop:0}).find("li:first").text());//逐条获取  
        //把所有匹配的元素追加到$self元素的后面,所以才出现这种周而复始滚动的效果  
        $self.css({marginTop:0}).find("li:first").appendTo($self); //appendTo能直接移动元素  
})  
}