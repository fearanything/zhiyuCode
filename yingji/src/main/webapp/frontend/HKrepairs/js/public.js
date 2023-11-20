// tab切换
function tabs(el,cont){
    $(el).click(function(){
        $(this).addClass("active").siblings().removeClass("active");
        $(cont).children().eq($(this).index()).addClass("active").siblings().removeClass("active");
    })
}

