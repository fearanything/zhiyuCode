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
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
</head>
<body>
	<video id="myPlayer" style="width: 390px;height:280px;" controls playsInline webkit-playsinline autoplay src="ezopen://open.ys7.com/G58879260/1.hd.live" >
	</video>

</body>
<script src="https://open.ys7.com/sdk/js/1.1/ezuikit.js"></script>
<%--<script src="<%=basePath%>frontend/js/ezuikit.js"></script>--%>
<script type="text/javascript">
	$(function (){
		var player = new EZUIPlayer('myPlayer');
		player.play();
	})

</script>

</html>


