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
					
					<form action="m_fengxian/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="M_FENGXIAN_ID" id="M_FENGXIAN_ID" value="${pd.M_FENGXIAN_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">风险id:</td>
								<td><input type="text" name="FENGXIAN_ID" id="FENGXIAN_ID" value="${pd.FENGXIAN_ID}" maxlength="255" placeholder="这里输入风险id" title="风险id" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">是否删除1删除0未删除:</td>
								<td><input type="number" name="ISDEL" id="ISDEL" value="${pd.ISDEL}" maxlength="32" placeholder="这里输入是否删除1删除0未删除" title="是否删除1删除0未删除" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">排序:</td>
								<td><input type="number" name="SORT" id="SORT" value="${pd.SORT}" maxlength="32" placeholder="这里输入排序" title="排序" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">创建人:</td>
								<td><input type="text" name="CREATER" id="CREATER" value="${pd.CREATER}" maxlength="255" placeholder="这里输入创建人" title="创建人" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">创建时间:</td>
								<td><input type="text" name="CREATE_DATE" id="CREATE_DATE" value="${pd.CREATE_DATE}" maxlength="255" placeholder="这里输入创建时间" title="创建时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">修改人:</td>
								<td><input type="text" name="MODIFYER" id="MODIFYER" value="${pd.MODIFYER}" maxlength="255" placeholder="这里输入修改人" title="修改人" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">修改时间:</td>
								<td><input type="text" name="MODIFY_DATE" id="MODIFY_DATE" value="${pd.MODIFY_DATE}" maxlength="255" placeholder="这里输入修改时间" title="修改时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">二级公司:</td>
								<td><input type="text" name="SECOND_UNIT" id="SECOND_UNIT" value="${pd.SECOND_UNIT}" maxlength="255" placeholder="这里输入二级公司" title="二级公司" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">三级机构:</td>
								<td><input type="text" name="THIRD_UNIT" id="THIRD_UNIT" value="${pd.THIRD_UNIT}" maxlength="255" placeholder="这里输入三级机构" title="三级机构" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">地址:</td>
								<td><input type="text" name="FENGXIAN_ADDRESS" id="FENGXIAN_ADDRESS" value="${pd.FENGXIAN_ADDRESS}" maxlength="255" placeholder="这里输入地址" title="地址" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">区域:</td>
								<td><input type="text" name="FENGXIAN_AREA" id="FENGXIAN_AREA" value="${pd.FENGXIAN_AREA}" maxlength="255" placeholder="这里输入区域" title="区域" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">危险源:</td>
								<td><input type="text" name="FENGXIAN_HAZARD" id="FENGXIAN_HAZARD" value="${pd.FENGXIAN_HAZARD}" maxlength="255" placeholder="这里输入危险源" title="危险源" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">可能导致的事故类型:</td>
								<td><input type="text" name="FENGXIAN_ACCIDENT_TYPE" id="FENGXIAN_ACCIDENT_TYPE" value="${pd.FENGXIAN_ACCIDENT_TYPE}" maxlength="255" placeholder="这里输入可能导致的事故类型" title="可能导致的事故类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">风险等级:</td>
								<td><input type="text" name="FENGXIAN_LEVEL" id="FENGXIAN_LEVEL" value="${pd.FENGXIAN_LEVEL}" maxlength="255" placeholder="这里输入风险等级" title="风险等级" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">控制措施:</td>
								<td><input type="text" name="CONTROL_MEASURE" id="CONTROL_MEASURE" value="${pd.CONTROL_MEASURE}" maxlength="255" placeholder="这里输入控制措施" title="控制措施" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">应急措施:</td>
								<td><input type="text" name="EMERGENCY_MEASURE" id="EMERGENCY_MEASURE" value="${pd.EMERGENCY_MEASURE}" maxlength="255" placeholder="这里输入应急措施" title="应急措施" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">危险源持续时间:</td>
								<td><input type="text" name="HAZARD_DURATION" id="HAZARD_DURATION" value="${pd.HAZARD_DURATION}" maxlength="255" placeholder="这里输入危险源持续时间" title="危险源持续时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">管理层级:</td>
								<td><input type="text" name="MANAGEMENT_LEVEL" id="MANAGEMENT_LEVEL" value="${pd.MANAGEMENT_LEVEL}" maxlength="255" placeholder="这里输入管理层级" title="管理层级" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">责任单位(组织机构):</td>
								<td><input type="text" name="RESPONSIBILITY_UNIT" id="RESPONSIBILITY_UNIT" value="${pd.RESPONSIBILITY_UNIT}" maxlength="255" placeholder="这里输入责任单位(组织机构)" title="责任单位(组织机构)" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">责任人:</td>
								<td><input type="text" name="RESPONSIBILITY_PEOPLE" id="RESPONSIBILITY_PEOPLE" value="${pd.RESPONSIBILITY_PEOPLE}" maxlength="255" placeholder="这里输入责任人" title="责任人" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">责任人联系方式:</td>
								<td><input type="text" name="RESPONSIBILITY_PHONE" id="RESPONSIBILITY_PHONE" value="${pd.RESPONSIBILITY_PHONE}" maxlength="255" placeholder="这里输入责任人联系方式" title="责任人联系方式" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">识别时间:</td>
								<td><input type="text" name="RECOGNITION_TIME" id="RECOGNITION_TIME" value="${pd.RECOGNITION_TIME}" maxlength="255" placeholder="这里输入识别时间" title="识别时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">持续周期:</td>
								<td><input type="text" name="DURANTION_CIRCLE" id="DURANTION_CIRCLE" value="${pd.DURANTION_CIRCLE}" maxlength="255" placeholder="这里输入持续周期" title="持续周期" style="width:98%;"/></td>
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
			if($("#FENGXIAN_ID").val()==""){
				$("#FENGXIAN_ID").tips({
					side:3,
		            msg:'请输入风险id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FENGXIAN_ID").focus();
			return false;
			}
			if($("#ISDEL").val()==""){
				$("#ISDEL").tips({
					side:3,
		            msg:'请输入是否删除1删除0未删除',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#ISDEL").focus();
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
			if($("#CREATER").val()==""){
				$("#CREATER").tips({
					side:3,
		            msg:'请输入创建人',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CREATER").focus();
			return false;
			}
			if($("#CREATE_DATE").val()==""){
				$("#CREATE_DATE").tips({
					side:3,
		            msg:'请输入创建时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CREATE_DATE").focus();
			return false;
			}
			if($("#MODIFYER").val()==""){
				$("#MODIFYER").tips({
					side:3,
		            msg:'请输入修改人',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MODIFYER").focus();
			return false;
			}
			if($("#MODIFY_DATE").val()==""){
				$("#MODIFY_DATE").tips({
					side:3,
		            msg:'请输入修改时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MODIFY_DATE").focus();
			return false;
			}
			if($("#SECOND_UNIT").val()==""){
				$("#SECOND_UNIT").tips({
					side:3,
		            msg:'请输入二级公司',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#SECOND_UNIT").focus();
			return false;
			}
			if($("#THIRD_UNIT").val()==""){
				$("#THIRD_UNIT").tips({
					side:3,
		            msg:'请输入三级机构',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#THIRD_UNIT").focus();
			return false;
			}
			if($("#FENGXIAN_ADDRESS").val()==""){
				$("#FENGXIAN_ADDRESS").tips({
					side:3,
		            msg:'请输入地址',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FENGXIAN_ADDRESS").focus();
			return false;
			}
			if($("#FENGXIAN_AREA").val()==""){
				$("#FENGXIAN_AREA").tips({
					side:3,
		            msg:'请输入区域',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FENGXIAN_AREA").focus();
			return false;
			}
			if($("#FENGXIAN_HAZARD").val()==""){
				$("#FENGXIAN_HAZARD").tips({
					side:3,
		            msg:'请输入危险源',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FENGXIAN_HAZARD").focus();
			return false;
			}
			if($("#FENGXIAN_ACCIDENT_TYPE").val()==""){
				$("#FENGXIAN_ACCIDENT_TYPE").tips({
					side:3,
		            msg:'请输入可能导致的事故类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FENGXIAN_ACCIDENT_TYPE").focus();
			return false;
			}
			if($("#FENGXIAN_LEVEL").val()==""){
				$("#FENGXIAN_LEVEL").tips({
					side:3,
		            msg:'请输入风险等级',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FENGXIAN_LEVEL").focus();
			return false;
			}
			if($("#CONTROL_MEASURE").val()==""){
				$("#CONTROL_MEASURE").tips({
					side:3,
		            msg:'请输入控制措施',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CONTROL_MEASURE").focus();
			return false;
			}
			if($("#EMERGENCY_MEASURE").val()==""){
				$("#EMERGENCY_MEASURE").tips({
					side:3,
		            msg:'请输入应急措施',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#EMERGENCY_MEASURE").focus();
			return false;
			}
			if($("#HAZARD_DURATION").val()==""){
				$("#HAZARD_DURATION").tips({
					side:3,
		            msg:'请输入危险源持续时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#HAZARD_DURATION").focus();
			return false;
			}
			if($("#MANAGEMENT_LEVEL").val()==""){
				$("#MANAGEMENT_LEVEL").tips({
					side:3,
		            msg:'请输入管理层级',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MANAGEMENT_LEVEL").focus();
			return false;
			}
			if($("#RESPONSIBILITY_UNIT").val()==""){
				$("#RESPONSIBILITY_UNIT").tips({
					side:3,
		            msg:'请输入责任单位(组织机构)',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RESPONSIBILITY_UNIT").focus();
			return false;
			}
			if($("#RESPONSIBILITY_PEOPLE").val()==""){
				$("#RESPONSIBILITY_PEOPLE").tips({
					side:3,
		            msg:'请输入责任人',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RESPONSIBILITY_PEOPLE").focus();
			return false;
			}
			if($("#RESPONSIBILITY_PHONE").val()==""){
				$("#RESPONSIBILITY_PHONE").tips({
					side:3,
		            msg:'请输入责任人联系方式',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RESPONSIBILITY_PHONE").focus();
			return false;
			}
			if($("#RECOGNITION_TIME").val()==""){
				$("#RECOGNITION_TIME").tips({
					side:3,
		            msg:'请输入识别时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RECOGNITION_TIME").focus();
			return false;
			}
			if($("#DURANTION_CIRCLE").val()==""){
				$("#DURANTION_CIRCLE").tips({
					side:3,
		            msg:'请输入持续周期',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DURANTION_CIRCLE").focus();
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