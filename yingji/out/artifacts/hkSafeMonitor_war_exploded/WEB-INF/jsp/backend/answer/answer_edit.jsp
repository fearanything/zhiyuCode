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
					
					<form action="answer/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="ANSWER_ID" id="ANSWER_ID" value="${pd.ANSWER_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">事件名称:</td>
								<td>	
								   <select class="chosen-select form-control" name="TYPHOON_ID" id="TYPHOON_ID" data-placeholder="请选择事件" style="vertical-align:top;width: 98%;">
										<c:forEach items="${typhoonMap}" var="data" varStatus="vs">
											<option value="${data.TYPHOON_ID }" <c:if test="${data.TYPHOON_ID == pd.TYPHOON_ID }">selected</c:if> >${data.TYPHOON_NAME}</option>
										</c:forEach>
								  	</select>
								  </td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">响应级别:</td>
								<td>
									<select class="chosen-select form-control" name="ANSWER_LEVEL" id="ANSWER_LEVEL" data-placeholder="响应级别" style="vertical-align:top;width: 98%;">
										<option value=""></option>
										<c:forEach items="${answerlevelMap}" var="data" varStatus="vs">
											<option value="${data.key }" <c:if test="${data.key == pd.ANSWER_LEVEL }">selected</c:if> >${data.value}</option>
										</c:forEach>
								  	</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">响应单位:</td>
								<td><input type="text" name="ANSWER_COMPANY" id="ANSWER_COMPANY" value="${pd.ANSWER_COMPANY}" maxlength="255" placeholder="这里输入应急响应单位" title="应急响应单位" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">开始时间:</td>
								<td>
								<input name="START_DATETIME" id="START_DATETIME" value="${pd.START_DATETIME}" type="text" class="date-timepicker form-control" autocomplete="off"  placeholder="情时间" title="情时间"/>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">结束时间:</td>
								<td>
								<input name="END_DATETIME" id="END_DATETIME" value="${pd.END_DATETIME}" type="text" class="date-timepicker form-control" autocomplete="off"  placeholder="情时间" title="情时间"/>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注:</td>
								<td>
								<textarea rows="4" name="ANSWER_REMARK" id="ANSWER_REMARK" title="备注" style="width:98%;">${pd.ANSWER_REMARK}</textarea>
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
	<script src="static/ace/js/date-time/moment.js"></script>
<script src="static/ace/js/date-time/bootstrap-datetimepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			
			if($("#TYPHOON_ID").val()==""){
				$("#TYPHOON_ID").tips({
					side:3,
		            msg:'请输入台风ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TYPHOON_ID").focus();
			return false;
			}
			if($("#ANSWER_LEVEL").val()==""){
				$("#ANSWER_LEVEL").tips({
					side:3,
		            msg:'请输入应急响应级别',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#ANSWER_LEVEL").focus();
			return false;
			}
			if($("#ANSWER_COMPANY").val()==""){
				$("#ANSWER_COMPANY").tips({
					side:3,
		            msg:'请输入应急响应单位',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#ANSWER_COMPANY").focus();
			return false;
			}
			
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			//$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
			// 日期时间框
			   $('.date-timepicker').datetimepicker({
			    format: "YYYY-MM-DD HH:00:00",
			    language: 'zh-CN'
			   });
		});
		</script>
</body>
</html>