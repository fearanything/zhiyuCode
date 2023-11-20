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
					
					<form action="burst/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="BURST_ID" id="BURST_ID" value="${pd.BURST_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">事件名称:</td>
								<td><select class="chosen-select form-control" name="TYPHOON_ID" id="TYPHOON_ID" data-placeholder="请选择事件" style="vertical-align:top;width: 98%;">
										<c:forEach items="${typhoonMap}" var="data" varStatus="vs">
											<option value="${data.TYPHOON_ID }" <c:if test="${data.TYPHOON_ID == pd.TYPHOON_ID }">selected</c:if> >${data.TYPHOON_NAME}</option>
										</c:forEach>
								 </select></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">突发时间:</td>
								<td>
								<input class="span10 date-picker" name="BURST_DATETIME" id="BURST_DATETIME"  value="${pd.BURST_DATETIME }" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:150px;" placeholder="突发时间" title="突发时间"/>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">突发单位:</td>
								<td><input type="text" name="BURST_COMPANY" id="BURST_COMPANY" value="${pd.BURST_COMPANY}" maxlength="255" placeholder="这里输入突发单位" title="突发单位" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">突发情况:</td>
								<td>
								<textarea rows="8" name="BURST_INFO" id="BURST_INFO" title="内容" style="width:98%;">${pd.BURST_INFO}</textarea>
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
			if($("#BURST_DATETIME").val()==""){
				$("#BURST_DATETIME").tips({
					side:3,
		            msg:'请输入突发时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#BURST_DATETIME").focus();
			return false;
			}
			if($("#BURST_COMPANY").val()==""){
				$("#BURST_COMPANY").tips({
					side:3,
		            msg:'请输入突发单位',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#BURST_COMPANY").focus();
			return false;
			}
			if($("#BURST_INFO").val()==""){
				$("#BURST_INFO").tips({
					side:3,
		            msg:'请输入突发情况',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#BURST_INFO").focus();
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