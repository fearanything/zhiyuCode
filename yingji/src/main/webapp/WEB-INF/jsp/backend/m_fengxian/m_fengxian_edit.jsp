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
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<!-- 树形下拉框start -->
		<script type="text/javascript" src="plugins/selectZtree/selectTree.js"></script>
		<script type="text/javascript" src="plugins/selectZtree/framework.js"></script>
		<link rel="stylesheet" type="text/css" href="plugins/selectZtree/import_fh.css"/>
		<script type="text/javascript" src="plugins/selectZtree/ztree/ztree.js"></script>
		<link type="text/css" rel="stylesheet" href="plugins/selectZtree/ztree/ztree.css"></link>
	<!-- 下拉框 -->
	<link rel="stylesheet" href="static/ace/css/chosen.css" />
	<!-- jsp文件头和头部 -->
	<%@ include file="../../system/index/top.jsp"%>
	<!-- 日期框 -->
	<link rel="stylesheet" href="static/ace/css/datepicker.css" />

	<style>
		.select-editable{
			position: relative;
		}
		.select-editable select {
			position:absolute;
			top:0px;
			left:0px;
			font-size:14px;
			border:none;
			margin:0;

		}
		.select-editable input {
			position:absolute;
			top:0px;
			left:0px;
			padding:1px;
			font-size:12px;
			border:none;
			z-index: 500;
			height: 30px;
		}
	</style>
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
					
					<form action="fengxian/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="FENGXIAN_ID" id="FENGXIAN_ID" value="${pd.FENGXIAN_ID}"/>
						<input name="FENGXIAN_ACCIDENT_TYPE" id="FENGXIAN_ACCIDENT_TYPE" type="hidden" value="${pd.FENGXIAN_ACCIDENT_TYPE}">
						<input type="hidden" name="FENGXIAN_AREA" id="FENGXIAN_AREA" value="${pd.FENGXIAN_AREA}"/>
						<input type="hidden" name="FENGXIAN_NUMBER" id="FENGXIAN_NUMBER" value="${pd.FENGXIAN_NUMBER}"/>
						<div id="zhongxin" style="padding-top: 13px">
							<table id="table_report" class="table table-striped table-bordered table-hover">
									<tr>
										<td style="width:110px;text-align: right;padding-top: 13px;">二级公司:</td>
										<td>
											<select class="chosen-select form-control" name="SECOND_UNIT" id="SECOND_UNIT" data-placeholder="这里选择二级公司" style="vertical-align:top;width: 98%;">
												<option value=""  > </option>
												<c:forEach items="${secondUnit}" var="map" varStatus="vs">
													<option value="${map.ORG_ID}" <c:if test="${map.ORG_ID == pd.SECOND_UNIT}">selected</c:if> >${map.ORG_NAME}</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<td style="width:110px;text-align: right;padding-top: 13px;">三级机构:</td>
										<td>
											<select class="chosen-select form-control" name="THIRD_UNIT" id="THIRD_UNIT" data-placeholder="这里选择三级机构" style="vertical-align:top;width: 98%;">
												<option value=""  > </option>
												<c:forEach items="${thirdUnit}" var="map" varStatus="vs">
													<option value="${map.ORG_ID}" <c:if test="${map.ORG_ID == pd.THIRD_UNIT}">selected</c:if> >${map.ORG_NAME}</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<td style="width:75px;text-align: right;padding-top: 13px;">地址:</td>
										<td><input type="text" name="FENGXIAN_ADDRESS" id="FENGXIAN_ADDRESS" value="${pd.FENGXIAN_ADDRESS}" maxlength="255" placeholder="这里输入地址" title="地址" style="width:98%;"/></td>
									</tr>

									<tr>
										<td style="width:110px;text-align: right;padding-top: 13px;">区域:</td>
										<td>
											<div class="selectTree" id="selectTree"></div>
										</td>
									</tr>

									<tr>
										<td  style="width:75px;text-align: right;padding-top: 13px;">危险源:</td>
										<td>

											<div id="selectCInput1" class="select-editable">
												<select class="chosen-select form-control" onchange="changeHazard()" style="width:98%;">
														<option value=""  > </option>
													<c:forEach items="${hazardList}" var="map" varStatus="vs">
														<option value="${map.FENGXIAN_HAZARD}" <c:if test="${map.FENGXIAN_HAZARD == pd.FENGXIAN_HAZARD}">selected</c:if>  >${map.FENGXIAN_HAZARD}</option>
													</c:forEach>
												</select>
												<input type="text" name="FENGXIAN_HAZARD" id="FENGXIAN_HAZARD" value="${pd.FENGXIAN_HAZARD}"  maxlength="255" placeholder="这里输入危险源" title="危险源" style="width:80%; height: 25px; top: 2px; left: 2px; "/>
											</div>

										</td>
									</tr>

									<tr>
										<td style="text-align: right;padding-top: 13px;">选择事故类型:</td>
										<td>
											<a class="btn btn-mini btn-success" onclick="selectAccidentType('${pd.FENGXIAN_ID}');">选择</a>
											<div id="ACCIDENT_TYPE_NAME">${accidentTypeName}</div>
										</td>
									</tr>

									<tr>
										<td style="width:110px;text-align: right;padding-top: 13px;"><span style="color: red;">*</span>风险等级:</td>
										<td>
											<select  class="chosen-select form-control" name="FENGXIAN_LEVEL" id="FENGXIAN_LEVEL" data-placeholder="请选择风险等级" style="vertical-align:top;width: 98%;">
												<option value=""  > </option>
												<c:forEach items="${riskLevelMap}" var="map" varStatus="vs">
													<option value="${map.bIANMA}" <c:if test="${map.bIANMA == pd.FENGXIAN_LEVEL}">selected</c:if> >${map.nAME}</option>
												</c:forEach>
											</select>
										</td>
									</tr>


									<tr>
										<td style="width:75px;text-align: right;padding-top: 13px;">控制措施:</td>
										<td>
											<textarea name="CONTROL_MEASURE" id="CONTROL_MEASURE" style="width:98%;" rows="6">${pd.CONTROL_MEASURE}</textarea>
										</td>
									</tr>
									<tr>
										<td style="width:75px;text-align: right;padding-top: 13px;">应急措施:</td>
										<td>
											<textarea name="EMERGENCY_MEASURE" id="EMERGENCY_MEASURE" style="width:98%;" rows="6">${pd.EMERGENCY_MEASURE}</textarea>
										</td>
									</tr>
									<tr>
										<td style="width:75px;text-align: right;padding-top: 13px;">危险源持续时间:</td>

										<td>
											<div id="selectCInput2" class="select-editable">
												<select onchange="changeHazard2()" style="width:98%;">
													<option value=""  ></option>
													<c:forEach items="${hazardDurationList}" var="map" varStatus="vs">
														<option value="${map.HAZARD_DURATION}" <c:if test="${map.HAZARD_DURATION == pd.HAZARD_DURATION}">selected</c:if> >${map.HAZARD_DURATION}</option>
													</c:forEach>
												</select>
												<input  type="text" name="HAZARD_DURATION" id="HAZARD_DURATION" value="${pd.HAZARD_DURATION}"  maxlength="255" placeholder="这里输入危险源持续时间" title="危险源持续时间" style="width:80%;"/>
											</div>
										</td>
									</tr>

									<tr>
										<td style="width:110px;text-align: right;padding-top: 13px;">管理层级:</td>
										<td>
											<select class="chosen-select form-control" name="MANAGEMENT_LEVEL" id="MANAGEMENT_LEVEL" data-placeholder="请选择管理层级" style="vertical-align:top;width: 98%;">
												<option value=""> </option>
												<option value="集团总部" <c:if test="${'集团总部' == pd.MANAGEMENT_LEVEL}">selected</c:if> >集团总部</option>
												<option value="二级单位" <c:if test="${'二级单位' == pd.MANAGEMENT_LEVEL}">selected</c:if> >二级单位</option>
												<option value="三级公司(项目)" <c:if test="${'三级公司(项目)' == pd.MANAGEMENT_LEVEL}">selected</c:if> >三级公司(项目)</option>
											</select>
									</tr>

									<tr>
										<td style="width:110px;text-align: right;padding-top: 13px;">责任单位:</td>
										<td>
											<select class="chosen-select form-control" name="RESPONSIBILITY_UNIT" id="RESPONSIBILITY_UNIT" data-placeholder="请选择责任单位" style="vertical-align:top;width: 98%;">
												<option value=""  > </option>
												<c:forEach items="${responsibilityList}" var="map" varStatus="vs">
													<option value="${map.ORG_ID}" <c:if test="${map.ORG_ID == pd.RESPONSIBILITY_UNIT}">selected</c:if> >${map.ORG_NAME}</option>
												</c:forEach>
											</select>
										</td>
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
										<td>
											<input class="date-picker" name="RECOGNITION_TIME" id="RECOGNITION_TIME" value="${pd.RECOGNITION_TIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:98%;" placeholder="请选择识别时间" title="识别时间"/>
										</td>

									</tr>
									<tr>
										<td style="width:75px;text-align: right;padding-top: 13px;">起始时间:</td>
										<td>
											<input class="date-picker" name="START_TIME" id="START_TIME" value="${pd.START_TIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:45%;" placeholder="请选择开始时间" title="开始时间"/>
											<input class="date-picker" name="END_TIME" id="END_TIME" value="${pd.END_TIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:45%;" placeholder="请选择结束时间" title="结束时间"/>
											<input type="button" onclick="longTrem()" style="width:5%" value="长期" />
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
			// if($("#FENGXIAN_HAZARD").val()==""){
			// 	$("#FENGXIAN_HAZARD").tips({
			// 		side:3,
		    //         msg:'请输入危险源',
		    //         bg:'#AE81FF',
		    //         time:2
		    //     });
			// 	$("#FENGXIAN_HAZARD").focus();
			// return false;
			// }
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
			// if($("#CONTROL_MEASURE").val()==""){
			// 	$("#CONTROL_MEASURE").tips({
			// 		side:3,
		    //         msg:'请输入控制措施',
		    //         bg:'#AE81FF',
		    //         time:2
		    //     });
			// 	$("#CONTROL_MEASURE").focus();
			// return false;
			// }
			// if($("#EMERGENCY_MEASURE").val()==""){
			// 	$("#EMERGENCY_MEASURE").tips({
			// 		side:3,
		    //         msg:'请输入应急措施',
		    //         bg:'#AE81FF',
		    //         time:2
		    //     });
			// 	$("#EMERGENCY_MEASURE").focus();
			// return false;
			// }
			// if($("#HAZARD_DURATION").val()==""){
			// 	$("#HAZARD_DURATION").tips({
			// 		side:3,
		    //         msg:'请输入危险源持续时间',
		    //         bg:'#AE81FF',
		    //         time:2
		    //     });
			// 	$("#HAZARD_DURATION").focus();
			// return false;
			// }
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
			// if($("#START_TIME").val()==""){
			// 	$("#START_TIME").tips({
			// 		side:3,
		    //         msg:'请输入开始时间',
		    //         bg:'#AE81FF',
		    //         time:2
		    //     });
			// 	$("#START_TIME").focus();
			// return false;
			// }
			// if($("#END_TIME").val()==""){
			// 	$("#END_TIME").tips({
			// 		side:3,
			// 		msg:'请输入结束时间',
			// 		bg:'#AE81FF',
			// 		time:2
			// 	});
			// 	$("#END_TIME").focus();
			// 	return false;
			// }
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}

		var defaultNodes = {"treeNodes":${zTreeNodes}};
		function initComplete(){
			//绑定change事件
			$("#selectTree").bind("change",function(){
				if(!$(this).attr("relValue")){
					//  top.Dialog.alert("没有选择节点");
				}else{
					//alert("选中节点文本："+$(this).attr("relText")+"<br/>选中节点值："+$(this).attr("relValue"));
					$("#FENGXIAN_AREA").val($(this).attr("relValue"));
				}
			});
			//赋给data属性
			$("#selectTree").data("data",defaultNodes);
			$("#selectTree").render();
			$("#selectTree2_input").val("${null==pd.AREA_NAME?'所属区域':pd.AREA_NAME}");
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

				/* 上传图片组件 */
				$('#id-input-file-3').ace_file_input({
					style:'well',
					btn_choose:'拖拽图片到这里上传',
					btn_change:null,
					no_icon:'ace-icon fa fa-cloud-upload',
					droppable:true,
					thumbnail:'small'//large | fit

					,
					preview_error : function(filename, error_code) {
						//name of the file that failed
						//error_code values
						//1 = 'FILE_LOAD_FAILED',
						//2 = 'IMAGE_LOAD_FAILED',
						//3 = 'THUMBNAIL_FAILED'
						//alert(error_code);
					}

				}).on('change', function(){
					//console.log($(this).data('ace_input_files'));
					//console.log($(this).data('ace_input_method'));
				});
			}

		});

		function selectAccidentType(FENGXIAN_ID) {
			/*$("#zhongxin").hide();*/

			var diag1 = new top.Dialog();
			diag1.Drag=true;
			diag1.Title ="选择事故类型";
			diag1.URL = '<%=basePath%>fengxian/goSelect?FENGXIAN_ID='+FENGXIAN_ID;
			diag1.Width = 1200;
			diag1.Height = 1000;
			diag1.Modal = true;				//有无遮罩窗口
			diag1. ShowMaxButton = true;	//最大化按钮
			diag1.ShowMinButton = true;		//最小化按钮
			diag1.CancelEvent = function(){ //关闭事件
				if(diag1.innerFrame.contentWindow.document.getElementById('zhongxin3').style.display == 'none'){
					//获取选中的供应商
					$("#FENGXIAN_ACCIDENT_TYPE").val(diag1.innerFrame.contentWindow.document.getElementById('ACCIDENT_TYPE_ID').value)	//从选择供应商页面获取到的供应商ID
					$("#ACCIDENT_TYPE_NAME").text(diag1.innerFrame.contentWindow.document.getElementById('ACCIDENT_TYPE_NAME').value)
					diag1.close();
				}
				diag1.close();
			};
			diag1.show();
		}
		</script>

<script>
	function longTrem(){
		$('#START_TIME').val('长期');
		$('#END_TIME').val('长期');

		console.log($('#START_TIME').val());
		console.log($('#END_TIME').val());
	}

	function changeHazard(){
		console.log($('#selectCInput1 select').val())
		$('#selectCInput1 input').val($('#selectCInput1 select').val());

	}

	function changeHazard2(){
		console.log($('#selectCInput2 select').val())
		$('#selectCInput2 input').val($('#selectCInput2 select').val());

	}

</script>
</body>
</html>