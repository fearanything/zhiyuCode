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
					
					<form action="notice/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="NOTICE_ID" id="NOTICE_ID" value="${pd.NOTICE_ID}"/>
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
								<td style="width:75px;text-align: right;padding-top: 13px;">发布时间:</td>
								<td>
								<input class="span10 date-picker" name="NOTICE_DATETIME" id="NOTICE_DATETIME"  value="${pd.NOTICE_DATETIME }" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:150px;" placeholder="发布时间" title="发布时间"/>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">标题:</td>
								<td><input type="text" name="NOTICE_TITLE" id="NOTICE_TITLE" value="${pd.NOTICE_TITLE}" maxlength="255" placeholder="这里输入通知公告标题" title="通知公告标题" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">内容:</td>
								<td>
								<textarea rows="8" name="NOTICE_CONTENT" id="NOTICE_CONTENT" title="内容" style="width:98%;">${pd.NOTICE_CONTENT}</textarea>
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
			if($("#NOTICE_DATETIME").val()==""){
				$("#NOTICE_DATETIME").tips({
					side:3,
		            msg:'请输入发布时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#NOTICE_DATETIME").focus();
			return false;
			}
			if($("#NOTICE_TITLE").val()==""){
				$("#NOTICE_TITLE").tips({
					side:3,
		            msg:'请输入通知公告标题',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#NOTICE_TITLE").focus();
			return false;
			}
			if($("#NOTICE_CONTENT").val()==""){
				$("#NOTICE_CONTENT").tips({
					side:3,
		            msg:'请输入通知公告内容',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#NOTICE_CONTENT").focus();
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