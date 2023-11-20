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
					
					<form action="duty/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="DUTY_ID" id="DUTY_ID" value="${pd.DUTY_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							
							<tr>
								<td style="width:100px;text-align: right;padding-top: 13px;">事件名称:</td>
								<td>
									<select class="chosen-select form-control" name="TYPHOON_ID" id="TYPHOON_ID" data-placeholder="请选择事件" style="vertical-align:top;width: 98%;">
										<c:forEach items="${typhoonMap}" var="data" varStatus="vs">
											<option value="${data.TYPHOON_ID }" <c:if test="${data.TYPHOON_ID == pd.TYPHOON_ID }">selected</c:if> >${data.TYPHOON_NAME}</option>
										</c:forEach>
								  	</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">单位名称:</td>
								<td><input type="text" name="DUTY_CORP" id="DUTY_CORP" value="${pd.DUTY_CORP}" maxlength="255" placeholder="这里输入单位名称" title="单位名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">值班员姓名:</td>
								<td><input type="text" name="DUTY_NAME" id="DUTY_NAME" value="${pd.DUTY_NAME}" maxlength="255" placeholder="这里输入值班员姓名" title="值班员姓名" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">联系方式:</td>
								<td><input type="text" name="DUTY_TEL" id="DUTY_TEL" value="${pd.DUTY_TEL}" maxlength="255" placeholder="这里输入联系方式" title="联系方式" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">开始时间:</td>
								<td>
								<input name="START_DATE" id="START_DATE" value="${pd.START_DATE}" type="text" class="date-timepicker form-control" autocomplete="off"  placeholder="情时间" title="情时间"/>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">结束时间:</td>
								<td>
								<input name="END_DATE" id="END_DATE" value="${pd.END_DATE}" type="text" class="date-timepicker form-control" autocomplete="off"  placeholder="情时间" title="情时间"/>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">职位:</td>
								<td><input type="text" name="DUTY_JOB" id="DUTY_JOB" value="${pd.DUTY_JOB}" maxlength="255" placeholder="这里输入职位" title="职位" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注:</td>
								<td><textarea rows="4" name="DUTY_REMARK" id="DUTY_REMARK" title="备注" style="width:98%;">${pd.DUTY_REMARK}</textarea></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">排序:</td>
								<td><input type="text" name="SORT" id="SORT" value="${pd.SORT}" maxlength="255" placeholder="这里输入排序" title="排序" style="width:98%;"/></td>
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
		            msg:'请输入台风',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TYPHOON_ID").focus();
			return false;
			}
			if($("#DUTY_CORP").val()==""){
				$("#DUTY_CORP").tips({
					side:3,
		            msg:'请输入单位名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DUTY_CORP").focus();
			return false;
			}
			if($("#DUTY_NAME").val()==""){
				$("#DUTY_NAME").tips({
					side:3,
		            msg:'请输入值班员姓名',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DUTY_NAME").focus();
			return false;
			}
			if($("#DUTY_TEL").val()==""){
				$("#DUTY_TEL").tips({
					side:3,
		            msg:'请输入联系方式',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DUTY_TEL").focus();
			return false;
			}
			if($("#DUTY_JOB").val()==""){
				$("#DUTY_JOB").tips({
					side:3,
		            msg:'请输入职位',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DUTY_JOB").focus();
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