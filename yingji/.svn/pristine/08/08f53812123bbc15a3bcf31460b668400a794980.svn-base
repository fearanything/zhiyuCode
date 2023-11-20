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
					<form action="rectifyinfo/${msg}.do" name="Form" id="Form" method="post">
						<input type="hidden" name="RECTIFY_ID" id="RECTIFY_ID" value="${pd.RECTIFY_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:110px;text-align: right;padding-top: 13px;"><span style="color: red;">*</span>组织机构:</td>
								<td>
									${pd.ORG_NAME}
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;">文件编号:</td>
								<td>${pd.FILE_CODE}</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;">项目名称:</td>
								<td>${pd.PROJECT_NAME}</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>隐患情况:</td>
								<td>
									${pd.HIDDEN_DANGER_INFO}
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;">隐患图片:</td>
								<td colspan="10">
									<c:if test="${not empty pd.IMG_ARR}">
										<c:forEach items="${pd.IMG_ARR}" var="img" varStatus="vs">
											<img alt="" src="${img}" style="width: 100px;vertical-align: top;">
										</c:forEach>
									</c:if>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>整改措施:</td>
								<td>
									<textarea name="RECTIFY_MEASURES" id="RECTIFY_MEASURES" style="width:98%;" rows="6">${pd.RECTIFY_MEASURES}</textarea>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>隐患类别:</td>
								<td>
									<c:forEach items="${classifyMap}" var="map" varStatus="vs">
										<c:if test="${map.key == pd.HIDDEN_DANGER_CLASSIFY}">${map.value}</c:if>
									</c:forEach>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>隐患级别:</td>
								<td>
									<c:forEach items="${levelMap}" var="map" varStatus="vs">
										<c:if test="${map.key == pd.HIDDEN_DANGER_LEVEL}">${map.value}</c:if>
									</c:forEach>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>隐患因素:</td>
								<td>
									<c:forEach items="${factorMap}" var="map" varStatus="vs">
										<c:if test="${map.key == pd.HIDDEN_DANGER_FACTOR}">${map.value}</c:if>
									</c:forEach>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>责任人:</td>
								<td>${pd.PERSON_RESPONSIBLE}</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>计划完成时间:</td>
								<td>
									${pd.PLAN_COMPLETE_TIME}
								</td>
							</tr>
							<%-- <tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>是否完成:</td>
								<td>
									${pd.IS_COMPLETE }${YesNoMap}
									<c:forEach items="${YesNoMap}" var="map" varStatus="vs">
										<c:if test="${map.key == pd.IS_COMPLETE}">${map.value}</c:if>
									</c:forEach>
								</td>
							</tr>
							<c:if test="${pd.IS_COMPLETE == '1'}">
								<tr>
									<td style="text-align: right;padding-top: 13px;">完成时间:</td>
									<td>
										${pd.COMPLETE_TIME}
									</td>
								</tr>
							</c:if> --%>
							
							<tr>
								<td style="text-align: right;padding-top: 13px;">整改投入(元):</td>
								<td><input type="text" name="RECTIFY_INVESTMENT" id="RECTIFY_INVESTMENT" value="${pd.RECTIFY_INVESTMENT}" maxlength="100" placeholder="这里输入整改投入（元）" title="整改投入（元）" style="width:98%;"/></td>
							</tr>
							
							<tr>
								<td style="text-align: right;padding-top: 13px;">备注:</td>
								<td>
									<textarea name="REMARK" id="REMARK" style="width:98%;" rows="6">${pd.REMARK}</textarea>
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
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- 上传控件 -->
	<script src="static/ace/js/ace/elements.fileinput.js"></script>
	<!-- 删除时确认窗口 -->
	<script src="static/ace/js/bootbox.js"></script>
	<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			if($("#RECTIFY_MEASURES").val()==""){
				$("#RECTIFY_MEASURES").tips({
					side:3,
		            msg:'请输入整改措施',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RECTIFY_MEASURES").focus();
			return false;
			}
			
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
			
			//下拉框
			if(!ace.vars['touch']) {
				$('.chosen-select').chosen({allow_single_deselect:true}); 
				$(window)
				.off('resize.chosen')
				.on('resize.chosen', function() {
					$('.chosen-select').each(function() {
						 var $this = $(this);
						 $this.next().css({'width': $this.parent().width()});
					});
				}).trigger('resize.chosen');
				$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
					if(event_name != 'sidebar_collapsed') return;
					$('.chosen-select').each(function() {
						 var $this = $(this);
						 $this.next().css({'width': $this.parent().width()});
					});
				});
				$('#chosen-multiple-style .btn').on('click', function(e){
					var target = $(this).find('input[type=radio]');
					var which = parseInt(target.val());
					if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
					 else $('#form-field-select-4').removeClass('tag-input-style');
				});
				
			}
		});
	</script>
</body>
</html>