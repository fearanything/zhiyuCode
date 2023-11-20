<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<!-- 下拉框 -->
	<link rel="stylesheet" href="static/ace/css/chosen.css" />
	<!-- jsp文件头和头部 -->
	<%@ include file="../../system/index/top.jsp"%>
	<!-- 日期框 -->
	<link rel="stylesheet" href="static/ace/css/datepicker.css" />
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
					
					<form action="monitor/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="MONITOR_ID" id="MONITOR_ID" value="${pd.MONITOR_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							
							<tr>
								<td style="width:100px;text-align: right;padding-top: 13px;">监控点分类:</td>
								<td><select class="chosen-select form-control" name="MONITORTYPE_ID" id="MONITORTYPE_ID" data-placeholder="请选择监控点分类" style="vertical-align:top;width: 98%;">
										<c:forEach items="${monitortypeMap}" var="data" varStatus="vs">
											<option value="${data.MONITORTYPE_ID }" <c:if test="${data.MONITORTYPE_ID == pd.MONITORTYPE_ID }">selected</c:if> >${data.MONITORTYPE_NAME}</option>
										</c:forEach>
								  	</select>
								 </td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监控点名称:</td>
								<td><input type="text" name="MONITOR_NAME" id="MONITOR_NAME" value="${pd.MONITOR_NAME}" maxlength="255" placeholder="这里输入监控点名称" title="监控点名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">设备编号:</td>
								<td><input type="text" name="MONITOR_CODE" id="MONITOR_CODE" value="${pd.MONITOR_CODE}" maxlength="255" placeholder="这里输入设备编号" title="设备编号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监控点URL:</td>
								<td><input type="text" name="MONITOR_URL" id="MONITOR_URL" value="${pd.MONITOR_URL}" maxlength="255" placeholder="这里输入监控点URL" title="监控点URL" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监控点IP:</td>
								<td><input type="text" name="MONITOR_IP" id="MONITOR_IP" value="${pd.MONITOR_IP}" maxlength="255" placeholder="这里输入监控点IP" title="监控点IP" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">排序:</td>
								<td><input type="number" name="SORT" id="SORT" value="${pd.SORT}" maxlength="32" placeholder="这里输入排序" title="排序" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">是否默认:</td>
								<td>
									<select class="chosen-select form-control" name="IS_DEFAULT" id="IS_DEFAULT" data-placeholder="是否默认" style="vertical-align:top;width: 98%;">
										<option value=""></option>
										<c:forEach items="${defaultMap}" var="data" varStatus="vs">
											<option value="${data.key }" <c:if test="${data.key == pd.IS_DEFAULT }">selected</c:if> >${data.value}</option>
										</c:forEach>
								  	</select>
								</td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
						</div>
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
					</form>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			
			if($("#MONITORTYPE_ID").val()==""){
				$("#MONITORTYPE_ID").tips({
					side:3,
		            msg:'请输入监控点分类ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MONITORTYPE_ID").focus();
			return false;
			}
			if($("#MONITOR_NAME").val()==""){
				$("#MONITOR_NAME").tips({
					side:3,
		            msg:'请输入监控点名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MONITOR_NAME").focus();
			return false;
			}
			
			
			if($("#SORT").val()==""){
				$("#SORT").tips({
					side:3,
		            msg:'请输入排序',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#SORT").focus();
			return false;
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>