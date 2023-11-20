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
					
					<form action="project/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="PROJECT_ID" id="PROJECT_ID" value="${pd.PROJECT_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							
							<tr>
								<td style="width:120px;text-align: right;padding-top: 13px;">项目分类:</td>
								<td> <select class="chosen-select form-control" name="PROJECTTYPE_ID" id="PROJECTTYPE_ID" data-placeholder="请选择项目分类" style="vertical-align:top;width: 98%;">
										<option value=""></option>
										<c:forEach items="${projectTypeMap}" var="data" varStatus="vs">
											<option value="${data.PROJECTTYPE_ID }" <c:if test="${data.PROJECTTYPE_ID == pd.PROJECTTYPE_ID }">selected</c:if> >${data.PROJECTTYPE_NAME}</option>
										</c:forEach>
								  	</select></td>
							</tr>
							<tr>
								<td style="width:120px;text-align: right;padding-top: 13px;">所在城市:</td>
								<td> <select class="chosen-select form-control" name="CITY_ID" id="CITY_ID" data-placeholder="请选择项目分类" style="vertical-align:top;width: 98%;">
										<option value=""></option>
										<c:forEach items="${cityMap}" var="data" varStatus="vs">
											<option value="${data.CITY_ID }" <c:if test="${data.CITY_ID == pd.CITY_ID }">selected</c:if> >${data.CITY_NAME}</option>
										</c:forEach>
								  	</select></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">工程项目名称:</td>
								<td><input type="text" name="PROJECT_NAME" id="PROJECT_NAME" value="${pd.PROJECT_NAME}" maxlength="255" placeholder="这里输入工程项目名称" title="工程项目名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">项目描述:</td>
								<td>
								<textarea rows="4" name="PROJECT_REMARK" id="PROJECT_REMARK" title="项目描述" style="width:98%;">${pd.PROJECT_REMARK}</textarea>
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
			
			if($("#PROJECTTYPE_ID").val()==""){
				$("#PROJECTTYPE_ID").tips({
					side:3,
		            msg:'请输入项目分类',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PROJECTTYPE_ID").focus();
			return false;
			}
			if($("#CITY_ID").val()==""){
				$("#CITY_ID").tips({
					side:3,
		            msg:'请输入所在城市',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CITY_ID").focus();
			return false;
			}
			if($("#PROJECT_NAME").val()==""){
				$("#PROJECT_NAME").tips({
					side:3,
		            msg:'请输入工程项目名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PROJECT_NAME").focus();
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