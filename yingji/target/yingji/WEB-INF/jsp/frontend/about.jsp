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
		<meta charset="utf-8">
		<title>777</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="renderer" content="webkit"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="6666" />
		<meta name="Keywords" content="三亚旅游,旅游调解,旅游调解委员会"/>
      
	</head>
	<body>
	<div style="text-align: center; vertical-align: center">
<iframe src="<%=basePath%>frontend/about2.html" width="100%" height="1200px" frameborder="1" marginwidth="0" marginheight="0" scrolling="no">
</iframe>
</div>
	
    </body>
</html>
