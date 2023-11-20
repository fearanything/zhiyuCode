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
					
					<form action="reservoir/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="RESERVOIR_ID" id="RESERVOIR_ID" value="${pd.RESERVOIR_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							
							<tr>
								<td style="width:100px;text-align: right;padding-top: 13px;">水库名称:</td>
								<td><input type="text" name="RESERVOIR_NAME" id="RESERVOIR_NAME" value="${pd.RESERVOIR_NAME}" maxlength="255" placeholder="这里输入水库名称" title="水库名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">水库位置:</td>
								<td><input type="text" name="RESERVOIR_ADDRESS" id="RESERVOIR_ADDRESS" value="${pd.RESERVOIR_ADDRESS}" maxlength="255" placeholder="这里输入水库位置" title="水库位置" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">警戒水位(米):</td>
								<td><input type="number" name="WATER_LEVEL" id="WATER_LEVEL" value="${pd.WATER_LEVEL}" maxlength="32" placeholder="这里输入警戒水位(米)" title="警戒水位(米)" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">水库介绍:</td>
								<td>
								<textarea rows="8" name="RESERVOIR_INFO" id="RESERVOIR_INFO" title="内容" style="width:98%;">${pd.RESERVOIR_INFO}</textarea>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">排序:</td>
								<td><input type="number" name="SORT" id="SORT" value="${pd.SORT}" maxlength="32" placeholder="这里输入排序" title="排序" style="width:98%;"/></td>
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
			
			if($("#RESERVOIR_NAME").val()==""){
				$("#RESERVOIR_NAME").tips({
					side:3,
		            msg:'请输入水库名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RESERVOIR_NAME").focus();
			return false;
			}
			if($("#RESERVOIR_ADDRESS").val()==""){
				$("#RESERVOIR_ADDRESS").tips({
					side:3,
		            msg:'请输入水库位置',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RESERVOIR_ADDRESS").focus();
			return false;
			}
			if($("#WATER_LEVEL").val()==""){
				$("#WATER_LEVEL").tips({
					side:3,
		            msg:'请输入警戒水位(米)',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#WATER_LEVEL").focus();
			return false;
			}
			if($("#RESERVOIR_INFO").val()==""){
				$("#RESERVOIR_INFO").tips({
					side:3,
		            msg:'请输入水库介绍',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RESERVOIR_INFO").focus();
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