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
					
					<form action="typhoon/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="TYPHOON_ID" id="TYPHOON_ID" value="${pd.TYPHOON_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							
							<tr>
								<td style="width:100px;text-align: right;padding-top: 13px;">事件年份:</td>
								<td><input type="text" name="TYPHOON_YEAR" id="TYPHOON_YEAR" value="${pd.TYPHOON_YEAR}" maxlength="255" placeholder="这里输入台风年份" title="台风年份" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">事件号:</td>
								<td><input type="text" name="TYPHOON_NO" id="TYPHOON_NO" value="${pd.TYPHOON_NO}" maxlength="255" placeholder="这里输入台风号" title="台风号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">事件名称:</td>
								<td><input type="text" name="TYPHOON_NAME" id="TYPHOON_NAME" value="${pd.TYPHOON_NAME}" maxlength="255" placeholder="这里输入台风名称" title="台风名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">是否当前:</td>
								<td>
									<select class="chosen-select form-control" name="IS_NOW" id="IS_NOW" data-placeholder="是否当前" style="vertical-align:top;width: 98%;">
										<option value=""></option>
										<c:forEach items="${staticMap}" var="data" varStatus="vs">
											<option value="${data.key }" <c:if test="${data.key == pd.IS_NOW }">selected</c:if> >${data.value}</option>
										</c:forEach>
								  	</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">值班内容:</td>
								<td>
								<textarea rows="4" name="TYPHOON_DUTY" id="TYPHOON_DUTY" title="值班内容" style="width:98%;">${pd.TYPHOON_DUTY}</textarea>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">值班公共电话:</td>
								<td>
								<textarea rows="4" name="TYPHOON_TEL" id="TYPHOON_TEL" title="值班公共电话" style="width:98%;">${pd.TYPHOON_TEL}</textarea>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">台风描述:</td>
								<td>
								<textarea rows="4" name="TYPHOON_REMARK" id="TYPHOON_REMARK" title="台风描述" style="width:98%;">${pd.TYPHOON_REMARK}</textarea>
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
			
			
			if($("#TYPHOON_NAME").val()==""){
				$("#TYPHOON_NAME").tips({
					side:3,
		            msg:'请输入事件(台风)名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TYPHOON_NAME").focus();
			return false;
			}
			if($("#IS_NOW").val()==""){
				$("#IS_NOW").tips({
					side:3,
		            msg:'请选择是否当前',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#IS_NOW").focus();
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