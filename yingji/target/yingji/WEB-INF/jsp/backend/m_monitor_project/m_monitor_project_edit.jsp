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
					
					<form action="m_monitor_project/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="M_MONITOR_PROJECT_ID" id="M_MONITOR_PROJECT_ID" value="${pd.M_MONITOR_PROJECT_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监控和项目关联id:</td>
								<td><input type="text" name="M_MONITOR_PROJECT_ID" id="M_MONITOR_PROJECT_ID" value="${pd.M_MONITOR_PROJECT_ID}" maxlength="32" placeholder="这里输入监控和项目关联id" title="监控和项目关联id" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监控id:</td>
								<td><input type="text" name="MONITOR_ID" id="MONITOR_ID" value="${pd.MONITOR_ID}" maxlength="32" placeholder="这里输入监控id" title="监控id" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">项目id:</td>
								<td><input type="text" name="PROJECT_ID" id="PROJECT_ID" value="${pd.PROJECT_ID}" maxlength="32" placeholder="这里输入项目id" title="项目id" style="width:98%;"/></td>
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
			if($("#M_MONITOR_PROJECT_ID").val()==""){
				$("#M_MONITOR_PROJECT_ID").tips({
					side:3,
		            msg:'请输入监控和项目关联id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#M_MONITOR_PROJECT_ID").focus();
			return false;
			}
			if($("#MONITOR_ID").val()==""){
				$("#MONITOR_ID").tips({
					side:3,
		            msg:'请输入监控id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MONITOR_ID").focus();
			return false;
			}
			if($("#PROJECT_ID").val()==""){
				$("#PROJECT_ID").tips({
					side:3,
		            msg:'请输入项目id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PROJECT_ID").focus();
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