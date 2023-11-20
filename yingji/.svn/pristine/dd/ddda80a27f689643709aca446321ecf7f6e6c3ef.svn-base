<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
 %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=yes,shrink-to-fit=no">
    <meta http-equiv="Page-Enter" content="blendTrans(Duration=0.5)" /> 
    <meta http-equiv="Page-Exit" content="blendTrans(Duration=0.5)" />
    <title>海南控股应急门户平台-应急响应信息</title>
    <link rel="stylesheet" href="<%=basePath%>frontend/css/base.css">
   
</head>
<body id="main">
    <!-- 1.头部header开始 -->
    <%@ include file="top.jsp"%>
    <!-- 1.头部header结束 -->

    
    <!-- 2.中部信息盒子开始 -->
    <div class="yingji" style="background-image: url(<%=basePath%>frontend/images/yingjigongchengBox.png); background-size: cover; width: 111rem; height: 56rem; margin: 2rem auto;" >
        <div class="yingjiMsgTitle" style="display:flex ;">
            <h3 style="width: 13rem; height: 2.5rem;line-height:2.5rem ;background-image: url(<%=basePath%>frontend/images/yingjiRedBox.png); background-size: cover; font-size: 20pt; padding-left: 1rem;">应急响应信息</h3>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji.html" class="tabActive">响应级别</a>
            </h4>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji_tufa.html" >突发情况记录</a>
            </h4>
            <h4>
                <a href="<%=basePath%>yjfhmFrontend/yingji_fangxun.html">防汛风险情况</a>
            </h4>
        </div>
        
        <div class="yingjiMsg">
            <div class="msgBox" style="overflow-y:auto; height:700px;">
               
                <div class="xiangyingLevel" style="margin-left:10rem;">
                    <div style="position:relative;">
	                    <h3 style="font-size:20pt ;">响应级别:</h3>
	                    <span style="position:absolute; left:500px; color:#fff;font-size:26px;">（实时响应）</span></div>
	                    
                    <div class="haiK" style="display: flex;">
                        <h4 style="font-size: 20pt;">海南控股</h4>
                        <h5 style="width: 64px; height: 25px; line-height: 25px;background-color: #ffb400; text-align: center; font-size: 18pt; border-radius: 6px; margin: 6px 0 0 20px;">${answer.ANSWER_LEVEL}级</h5>
                    </div>
                   <div class="tableAll" style="display:flex;">
                        <div class="table1">
                            <h4 id="level1" style="height: 30px;text-align:center; border-radius: 6px 0 0 0; font-size: 16pt;">Ⅰ级</h4>
                            <c:forEach var="i" begin="0" end="30">
                            <c:choose>
						       <c:when test="${not empty answerList1[i]}"> 
						              <p>${answerList1[i].ANSWER_COMPANY }</p>
						       </c:when>
						       <c:otherwise>
						           <p></p>
						       </c:otherwise>
						       </c:choose>
                            </c:forEach>
                        </div>
                        <div class="table2">
                            <h4 id="level2" style="height: 30px;text-align:center; font-size: 16pt;">Ⅱ级</h4>
                             <c:forEach var="i" begin="0" end="30">
                              <c:choose>
						       <c:when test="${not empty answerList2[i]}"> 
						              <p>${answerList2[i].ANSWER_COMPANY }</p>
						       </c:when>
						       <c:otherwise>
						           <p></p>
						       </c:otherwise>
						       </c:choose>
                            </c:forEach>
                        </div>
                        <div class="table3">
                            <h4 id="level3" style="height: 30px;text-align:center; font-size: 16pt;">Ⅲ级</h4>
                             <c:forEach var="i" begin="0" end="30">
                              <c:choose>
						       <c:when test="${not empty answerList3[i]}"> 
						              <p>${answerList3[i].ANSWER_COMPANY }</p>
						       </c:when>
						       <c:otherwise>
						           <p></p>
						       </c:otherwise>
						       </c:choose>
                            </c:forEach>
                        </div>
                        <div class="table4">
                            <h4 id="level4" style="height: 30px;text-align:center; border-radius: 0 6px 0 0 ; font-size: 16pt;">Ⅳ级</h4>
                            <c:forEach var="i" begin="0" end="30">
                              <c:choose>
						       <c:when test="${not empty answerList4[i]}"> 
						              <p>${answerList4[i].ANSWER_COMPANY }</p>
						       </c:when>
						       <c:otherwise>
						           <p></p>
						       </c:otherwise>
						       </c:choose>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    <!-- 2.中部信息盒子结束 -->


    <script src="<%=basePath%>frontend/js/scale.js"></script>
    <script src="<%=basePath%>frontend/js/"></script>
    <script src="<%=basePath%>frontend/js/date.js"></script>
    <script src="<%=basePath%>frontend/js/time.js"></script>

    <script>
        let nav = document.querySelector('.nav')
        let xiala = document.querySelector('.nav ul')
        nav.addEventListener('mouseenter',function(){
            xiala.style.display = 'block'
        })
        nav.addEventListener('mouseleave',function(){
            xiala.style.display = 'none'
        })
    </script>

    

    <style>

        html {
        width: 100%;
        height: 100%;
    }
.table1,.table2,.table3,.table4{
    width: 350px;
}

.table1 p,.table2 p,.table3 p,.table4 p{
    padding: 2px;
    height: 30px;
    font-size: 14pt;
    text-align: center;
    border: 1px solid #0196ff;
}
    body {
        width: 1920px;
        height: 1080px;
        display: flex;
        flex-direction: column;
        margin: 0px;
        background: url(<%=basePath%>frontend/images/bgc2.jpg) no-repeat;
        background-size: 100% 100%;

    }
    
    .active{
        width: 8rem;
        height: 1.8rem;
        background-color: #002386;
        border: solid .1rem #20bcfc;;
        border-radius: 6px;
    }

    .head{
        height: 7rem;
        background-image: url(<%=basePath%>frontend/images/topheadNew.png);
        display: flex;
        flex-direction: column;
    }

    .head h1{
        margin-top: 1rem;
        margin-bottom: 4px;
        display: flex;
        justify-content: center;
        color: #fff;
        font-size: 28pt;
    }

    .head ul{
        
        display: flex;
        justify-content: center;
        margin: 0;
        
    }

    .head ul a{
        float: left;
        width: 8rem;
        text-align: center;
        font-size: 1.2rem;
        color: #fff;
    }

    .head ul a:hover{
        color: #20bcfc;
    }

    .head .nav ul{
        width: 8rem;
        height: 7.5rem;
        background-color: rgba(255, 255, 255, 0);
        border-radius:6px;
    }

    .head .nav ul li a{
        margin-top: 15px;
        padding-bottom: 15px;
        height: 30px;
        line-height: 30px;
        background-color: #002386;
        border: 1px solid #20bcfc;
        border-radius:6px;
    }

    .yingji{
        display: flex;
        flex-direction: column;
    }

    .yingjiMsg{
        overflow-y: auto;
    }

    .yingjiMsg::-webkit-scrollbar{
        -webkit-appearance: none;
    }

    .yingjiMsg::-webkit-scrollbar-thumb{
        background-color: #006cff;
    }

    .yingjiMsg::-webkit-scrollbar-track{
        border: 1px solid #006cff;
        background-color: #062d82;
    }

    .yingjiMsgTitle h4 a{
        width: 10rem;
        display: inline-block;
        margin-left: 6rem;
        line-height: 2.5rem;
        font-size: 1.2rem;
        font-weight: 400;
        color: #fff;
        text-align: center;
        box-sizing: border-box;
        border: 1px solid transparent;
    }

    .tabActive{
        width: 11.8rem!important;
        background-image: url(<%=basePath%>frontend/images/yingjiHeadTab.png);
        background-size: cover;
        border: none;
    }

    .yingjiMsgTitle h4 a:hover{
        width: 10rem;
        background-size: cover;
        border-radius: 5px;
        color: #006cff;
        cursor: pointer;
    }

    .yingjiMsgTitle h4 a{
        color: #fff;
    }

    .selectDate{
        display: flex;
        justify-content: space-between;
        width: 111rem;
        height: 4rem;
        /* line-height: .75rem; */
        background-image: url(<%=basePath%>frontend/images/yingjiDateTab.png);
        background-size: cover;
    }

.selectDate .left{
  display: flex;
}

.selectDate form{
  display: flex;
  justify-content: space-around;
  margin-top: .5rem;
  margin-left: .5rem;
  width: 24rem;
  height: 3rem;
  line-height: 3rem;
  background-color: #002796;
  border: solid 1px #20bcfc;
  border-radius: 19px;
}

.selectDate form select{
  background-color: rgba(255, 255, 255, 0);
  border: none;
  font-size: 16pt;
  color: #fff;
}

.search .searchBox{
    width: 18rem;
    line-height: 1rem;
    border: none;
    outline: none;
    color: #fff;
    background-color: rgba(255, 255, 255, 0);
}

.search .searchBox::placeholder{
  color: #fff;
}

.msgBox::-webkit-scrollbar{
        -webkit-appearance: none;
    }

.msgBox::-webkit-scrollbar-thumb{
        background-color: #006cff;
    }

.msgBox::-webkit-scrollbar-track{
        border: 1px solid #006cff;
        background-color: #062d82;
    }

.searchBtn{
  margin-top: .1125rem;
  width: .25rem;
  height: .25rem;
  background-image: url(<%=basePath%>frontend/images/searchicon.png);
  background-color: rgba(255, 255, 255, 0);
  border: none;
  cursor: pointer;
}

/* .addMsg{
  display: none;
  position: fixed;
  top: 20%;
  left: 50%;
  width: 48rem;
  height: 36rem;
  z-index: 999;
  background-color: #fff;
  border-radius: 11px;
}

.addMsg .top h3{
  font-weight: 400;
  font-size: 1rem;
  color: #222;
}

.addMsg form{
  margin-bottom: 1rem;
}

.addMsg #addName{
  width: 25rem;
  height: 2rem;
  border-radius: 6px;
  background-color: #e8e8e8;
  border: none;
}

.addMsg #addDate,#addYushui,#addShuiwei,#addKurong{
  width: 12rem;
  height: 2rem;
  border-radius: 6px;
  background-color: #e8e8e8;
  border: none;
}

.addMsg #addDetail{
  display: flex;
  flex-direction: column;
  width: 45rem;
  height: 11rem;
  margin-bottom: .1875rem;
}

#addDetail h4{
  padding-left: .125rem;
  height: 2rem;
  line-height: 2rem;
  font-size: 1rem;
  font-weight: 400;
  color: #222;
  background-color: #e8e8e8;
  border-radius: .075rem .075rem 0 0;
}

#addDetail textarea{
  padding: 1rem;
  border: 1px solid #e8e8e8;
  font-size: 1rem;
}

#addHKsign h4{
  margin-right: 1rem;
  color: #222;
  font-size: 1rem;
  font-weight: 400;
}

#addHKsign input{
  margin-right: 1rem;
  margin-top: .5rem;
  width: 1rem;
  height: 1rem;
} */
#level1{
  color: #fff;
  background-color: #c72300;
}

#level2{
  color: #fff;
  background-color: #ffb400;
}

#level3{
  color: #fff;
  background-color: #fff000;
}

#level4{
  color: #fff;
  background-color: #0b57e2;
}


/* .addMsg .bottom h4{
  margin-bottom: .5rem;
  font-size: 1rem;
  font-weight: 400;
  color: #222;
}

.addMsg .bottom input{
  margin-bottom: .5rem;
  width: 40rem;
  height:2rem;
  border: none;
  border-radius: 9px;
  background-color: #f8f8f8;
}

.addMsg .bottom select{
  width: 5rem;
  height: 2rem;
  text-align: center;
  border-radius: 12px;
} */



.yingjiMsg .msgBox{
    display: flex;
    padding: 15px;
    width: 1700px;
    height: 500px;
    background-image: url(<%=basePath%>frontend/images/msgBox.png);
    background-size: cover;
    margin-top: 2rem;
    margin-left: 1rem;
}

.msgName{
    margin-right: 2rem;
}

.yingjiMsg .msgBox .msgName h4{
    width: 30rem;
    color: #fff;
    font-size: 16pt;
    overflow: hidden;
    text-overflow: ellipsis;

}

.yingjiMsg .msgBox .msgName h4 img{
    margin-bottom: .2rem;
    margin-right: 1rem;
    width: 1.4rem;
    height: .8rem;
}

.yingjiMsg .msgBox .msgName ul{
    margin-top: 1rem;
}

.yingjiMsg .msgBox .msgName ul li{
    margin-top: .4rem;
    color: #fff;
}

.msgBox .detail{
    color: #fff;
}

.msgBox .detail p{
    margin-top: .4rem;
    width: 17rem;
    height: 7rem;
}  

    .yingjiMsg .xiangyingLevel table th{
        width: 210px;
        height: 23px;
        border: 1px solid #0196ff;
    }

    .yingjiMsg .xiangyingLevel table td{
        width: 210px;
        height: 23px;
        border: 1px solid #0196ff;
    }

    /* .yingjiMsg .msgBox .xiangyingLevel .company h3{
        color: #fff;
        font-size: 2rem;
    }

    .yingjiMsg .msgBox .xiangyingLevel .level p{
        margin-bottom: .4rem;
        font-size: 2rem;
        color: #0096ff;
    }   

    .yingjiMsg .msgBox .xiangyingLevel .level h3{
        width: 10rem;
        height: 4rem;
        text-align: center;
        line-height: 4rem;
        color: #fff;
        background-color: #ffb400;
        border: 1px solid #dc8c01;
        border-radius: 1rem;
        font-size: 3rem;
        font-family: STSongti-SC-Black;
        letter-spacing: 1rem;
    }

    .yingjiMsg .msgBox .related{
        margin-left: 1rem;
        width: 44rem;
    }

    .yingjiMsg .msgBox .related .top{
        display: flex;
        justify-content: space-between;
    }

    .yingjiMsg .msgBox .related h4{
        font-size: 1rem;
        color: #fff;
    }
    .yingjiMsg .msgBox .related .top a{
        display: inline-block;
        width: 5rem;
        height: 2rem;
        line-height: 2rem;
        text-align: center;
        color: #fff;
        background-image: url(<%=basePath%>frontend/images/xiangqing.png);
        background-size: cover;
    }

    .yingjiMsg .msgBox .related .danwei{
        display: flex;
        width: 44rem;
        height: 8rem;
        border: 1px solid #0096ff;
        border-radius: 1rem 1rem 0 0;
    }

    .yingjiMsg .msgBox .related .danwei .lv{
        width: 11rem;
        height: 2rem;
    }

    .yingjiMsg .msgBox .related .danwei .lv h4{
        
        text-align: center;
    }

    .yingjiMsg .msgBox .related .danwei .danweiDetail{
        width: 10.8rem;
        height: 6.4rem;
        line-height: 1.5rem;
        color: #fff;
        text-align: center;
        background-image: url(<%=basePath%>frontend/images/table.png);
        background-size: cover;
        border-bottom: 1px solid #009cff;
    } 
    
    */
    </style>
</body>
</html>