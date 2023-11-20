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
	<!-- 树形下拉框end -->
	
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
						<input type="hidden" name="IS_COMPLETE_OLD" id="IS_COMPLETE_OLD" value="${pd.IS_COMPLETE}"/>
						<input type="hidden" name="IMG_URL" id="IMG_URL" value="${pd.IMG_URL}"/>
						<%--<input type="hidden" name="ORG_ID" id="ORG_ID" value="${pd.ORG_ID}"/>--%>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover" style="width: 1000px;margin: 0 auto;">
							<tr>
								<td style="width:110px;text-align: right;padding-top: 13px;"><span style="color: red;">*</span>组织机构:</td>
								<td>
									<select class="chosen-select form-control" name="ORG_ID" id="ORG_ID" data-placeholder="隐患类别" style="vertical-align:top;width: 98%;">
										<c:forEach items="${orgList}" var="map" varStatus="vs">
											<option value="${map.ORG_ID}" <c:if test="${map.ORG_ID == pd.ORG_ID}">selected</c:if> >${map.ORG_NAME}</option>
										</c:forEach>
									</select>
								</td>

							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;">文件编号:</td>
								<td><input type="text" name="FILE_CODE" id="FILE_CODE" value="${pd.FILE_CODE}" maxlength="100" placeholder="这里输入文件编号" title="文件编号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;">项目名称:</td>
								<td><input type="text" name="PROJECT_NAME" id="PROJECT_NAME" value="${pd.PROJECT_NAME}" maxlength="100" placeholder="这里输入项目名称" title="项目名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>隐患情况:</td>
								<td>
									<textarea name="HIDDEN_DANGER_INFO" id="HIDDEN_DANGER_INFO" style="width:98%;" rows="6">${pd.HIDDEN_DANGER_INFO}</textarea>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;">隐患图片:</td>
								<td>
									<%-- <textarea name="HIDDEN_DANGER_INFO" id="HIDDEN_DANGER_INFO" style="width:98%;" rows="6">${pd.HIDDEN_DANGER_INFO}</textarea> --%>
									<input multiple="" class="fileInput" type="file" id="id-input-file-3" name="id-input-file-3" accept="image/png, image/jpeg, image/jpg, image/gif"/>
								</td>
							</tr>
							<%-- <tr>
								<td colspan="10">
									<c:if test="${not empty pd.IMG_ARR}">
										<c:forEach items="${pd.IMG_ARR}" var="img" varStatus="vs">
											<img alt="" src="${img}" style="width: 100px;vertical-align: top;">
										</c:forEach>
									</c:if>
								</td>
							</tr> --%>
							<tr>
								<td style="text-align: right;padding-top: 13px;">整改措施:</td>
								<td>
									<textarea name="RECTIFY_MEASURES" id="RECTIFY_MEASURES" style="width:98%;" rows="6">${pd.RECTIFY_MEASURES}</textarea>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>隐患类别:</td>
								<td>
									<select class="chosen-select form-control" name="HIDDEN_DANGER_CLASSIFY" id="HIDDEN_DANGER_CLASSIFY" data-placeholder="隐患类别" style="vertical-align:top;width: 98%;">
										<c:forEach items="${classifyMap}" var="map" varStatus="vs">
											<option value="${map.key}" <c:if test="${map.key == pd.HIDDEN_DANGER_CLASSIFY}">selected</c:if> >${map.value}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>隐患级别:</td>
								<td>
									<select class="chosen-select form-control" name="HIDDEN_DANGER_LEVEL" id="HIDDEN_DANGER_LEVEL" data-placeholder="隐患级别" style="vertical-align:top;width: 98%;">
										<c:forEach items="${levelMap}" var="map" varStatus="vs">
											<option value="${map.key}" <c:if test="${map.key == pd.HIDDEN_DANGER_LEVEL}">selected</c:if> >${map.value}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>隐患因素:</td>
								<td>
									<select class="chosen-select form-control" name="HIDDEN_DANGER_FACTOR" id="HIDDEN_DANGER_FACTOR" data-placeholder="隐患因素" style="vertical-align:top;width: 98%;">
										<c:forEach items="${factorMap}" var="map" varStatus="vs">
											<option value="${map.key}" <c:if test="${map.key == pd.HIDDEN_DANGER_FACTOR}">selected</c:if> >${map.value}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>责任人:</td>
								<td><input type="text" name="PERSON_RESPONSIBLE" id="PERSON_RESPONSIBLE" value="${pd.PERSON_RESPONSIBLE}" maxlength="100" placeholder="这里输入责任人" title="责任人" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>计划完成时间:</td>
								<td>
									<input class="span10 date-picker" name="PLAN_COMPLETE_TIME" id="PLAN_COMPLETE_TIME" value="${pd.PLAN_COMPLETE_TIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:98%;" placeholder="计划完成时间" title="计划完成时间"/>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;padding-top: 13px;"><span style="color: red;">*</span>是否完成:</td>
								<td>
									<select class="chosen-select form-control" name="IS_COMPLETE" id="IS_COMPLETE" data-placeholder="是否完成" style="vertical-align:top;width: 98%;">
										<c:forEach items="${YesNoMap}" var="map" varStatus="vs">
											<option value="${map.key}" <c:if test="${map.key == pd.IS_COMPLETE}">selected</c:if> >${map.value}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<c:if test="${pd.IS_COMPLETE == '1'}">
								<tr>
									<td style="text-align: right;padding-top: 13px;">完成时间:</td>
									<td>
										<input type="hidden" name="COMPLETE_TIME" id="COMPLETE_TIME" value="${pd.COMPLETE_TIME}" />
										${pd.COMPLETE_TIME}
									</td>
								</tr>
							</c:if>
							<tr>
								<td style="text-align: right;padding-top: 13px;">整改投入(元):</td>
								<td><input type="text" name="RECTIFY_INVESTMENT" id="RECTIFY_INVESTMENT" value="${pd.RECTIFY_INVESTMENT}" maxlength="100" placeholder="这里输入整改投入（元）" title="整改投入（元）" style="width:98%;"/></td>
							</tr>
							<c:if test="${msg == 'edit'}">
								<tr>
									<td style="text-align: right;padding-top: 13px;">上报时间:</td>
									<td>
										<input type="hidden" name="COMMIT_TIME" id="COMMIT_TIME" value="${pd.COMMIT_TIME}" />
										${pd.COMMIT_TIME}
									</td>
								</tr>
							</c:if>
							
							<tr>
								<td style="text-align: right;padding-top: 13px;">备注:</td>
								<td>
									<textarea name="REMARK" id="REMARK" style="width:98%;" rows="6">${pd.REMARK}</textarea>
								</td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									
									<a class="btn btn-mini btn-primary" onclick="fromExcel();" title="从EXCEL导入" style="margin-left: 20px;">从EXCEL导入</a>
									<!-- <a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a> -->
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
			if($("#ORG_ID").val()==""){
				$("#selectTree").tips({
					side:3,
		            msg:'请输入组织机构',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FILE_CODE").focus();
			return false;
			}
			/*if($("#FILE_CODE").val()==""){
				$("#FILE_CODE").tips({
					side:3,
		            msg:'请输入文件编号',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FILE_CODE").focus();
			return false;
			}*/
			/* if($("#PROJECT_NAME").val()==""){
				$("#PROJECT_NAME").tips({
					side:3,
		            msg:'请输入项目名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PROJECT_NAME").focus();
			return false;
			} */
			if($("#HIDDEN_DANGER_INFO").val()==""){
				$("#HIDDEN_DANGER_INFO").tips({
					side:3,
		            msg:'请输入隐患情况',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#HIDDEN_DANGER_INFO").focus();
			return false;
			}
			/* if($("#RECTIFY_MEASURES").val()==""){
				$("#RECTIFY_MEASURES").tips({
					side:3,
		            msg:'请输入整改措施',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RECTIFY_MEASURES").focus();
			return false;
			} */
			if($("#HIDDEN_DANGER_CLASSIFY").val()==""){
				$("#HIDDEN_DANGER_CLASSIFY").tips({
					side:3,
		            msg:'请输入隐患类别',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#HIDDEN_DANGER_CLASSIFY").focus();
			return false;
			}
			if($("#HIDDEN_DANGER_LEVEL").val()==""){
				$("#HIDDEN_DANGER_LEVEL").tips({
					side:3,
		            msg:'请输入隐患级别',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#HIDDEN_DANGER_LEVEL").focus();
			return false;
			}
			if($("#HIDDEN_DANGER_FACTOR").val()==""){
				$("#HIDDEN_DANGER_FACTOR").tips({
					side:3,
		            msg:'请输入隐患因素',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#HIDDEN_DANGER_FACTOR").focus();
			return false;
			}
			if($("#PERSON_RESPONSIBLE").val()==""){
				$("#PERSON_RESPONSIBLE").tips({
					side:3,
		            msg:'请输入责任人',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PERSON_RESPONSIBLE").focus();
			return false;
			}
			if($("#PLAN_COMPLETE_TIME").val()==""){
				$("#PLAN_COMPLETE_TIME").tips({
					side:3,
		            msg:'请输入计划完成时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PLAN_COMPLETE_TIME").focus();
			return false;
			}
			if($("#IS_COMPLETE").val()==""){
				$("#IS_COMPLETE").tips({
					side:3,
		            msg:'请输入是否完成',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#IS_COMPLETE").focus();
			return false;
			}
			
			uploadFile();
		}
		
		function submit() {
			var form = document.querySelector("#Form");
			var formDate = new FormData(form);
			
			$.ajax({
				url : "rectifyinfo/saveByAjax.do",    //请求的url地址
				dataType : "json",   //返回格式为json
				async : true,//请求是否异步，默认为异步，这也是ajax重要特性
				data : {
					"ORG_ID": $("#ORG_ID").val(),
					"FILE_CODE": $("#FILE_CODE").val(),
					"PROJECT_NAME": $("#PROJECT_NAME").val(),
					"IMG_URL": $("#IMG_URL").val(),
					"HIDDEN_DANGER_INFO": $("#HIDDEN_DANGER_INFO").val(),
					"RECTIFY_MEASURES": $("#RECTIFY_MEASURES").val(),
					"HIDDEN_DANGER_CLASSIFY": $("#HIDDEN_DANGER_CLASSIFY").val(),
					"HIDDEN_DANGER_LEVEL": $("#HIDDEN_DANGER_LEVEL").val(),
					"HIDDEN_DANGER_FACTOR": $("#HIDDEN_DANGER_FACTOR").val(),
					"IS_SUBMITE": $("#IS_SUBMITE").val(),
					"IS_COMPLETE": $("#IS_COMPLETE").val(),
					"COMPLETE_TIME": $("#COMPLETE_TIME").val(),
					"PERSON_RESPONSIBLE": $("#PERSON_RESPONSIBLE").val(),
					"RECTIFY_INVESTMENT": $("#RECTIFY_INVESTMENT").val(),
					"PLAN_COMPLETE_TIME": $("#PLAN_COMPLETE_TIME").val(),
					"COMMIT_TIME": $("#COMMIT_TIME").val(),
					"REMARK": $("#REMARK").val(),
					"IS_COMPLETE_OLD": $("#IS_COMPLETE_OLD").val()
				},    //参数值
				type : "POST",   //请求方式 get 或者post
				beforeSend : function(){
					//请求前的处理
					$("#zhongxin").hide();
					$("#zhongxin2").show();
				},
				success : function(req){
					//请求成功时处理
					var sign = req.sign;
					$("#zhongxin").show();
					$("#zhongxin2").hide();
					$("#FILE_CODE").focus();
					if (sign == 'yes') {
						bootbox.confirm("保存成功", function(result) {
							document.location.reload();
						});
					} else {
						bootbox.confirm("保存失败", function(result) {
							
						});
					}
				},
				complete : function(){
					//请求完成的处理
					$("#zhongxin").show();
					$("#zhongxin2").hide();
				},
				error : function(){
					//请求出错处理
				}
			});

		}
		
		// 上传文件
		function uploadFile() {
			// 先移除可能出现的进度条元素
			$(".progress-bar").remove();
			
			// 获取需要上传的文件数量
			var needUpload = 0;
			$('.fileInput').each(function(){
				if ($(this).val() != "") {
					needUpload ++;
				}
			});
			if (0 == needUpload) {
				// 没有需要上传的文件，直接提交表单
				submit();
				return;
			}
			// 已经上传的文件数量
			var isUpload = 0;
			
			var xhrOnProgress = function (fun) {
				xhrOnProgress.onprogress = fun; //绑定监听
				//使用闭包实现监听绑
				return function () {
					//通过$.ajaxSettings.xhr();获得XMLHttpRequest对象
					var xhr = $.ajaxSettings.xhr();
					//判断监听函数是否为函数
					if (typeof xhrOnProgress.onprogress !== 'function')
						return xhr;
					//如果有监听函数并且xhr对象支持绑定时就把监听函数绑定上去
					if (xhrOnProgress.onprogress && xhr.upload) {
						xhr.upload.onprogress = xhrOnProgress.onprogress;
					}
					return xhr;
				}
			}
			
			var form = document.querySelector("#Form");
			var formDate = new FormData(form);
			$('.fileInput').each(function(){
				if ($(this).val() == "") {
					return;
				}
				var COLUMN_CODE = $(this).attr("id");
				var thisOb = $(this);
				// html添加进度条组件
				var barHtml = '<div class="progress" style="width: 250px;position: relative;">' +
					'<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"' +
						'aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">' +
					'</div>' +
					'<div class="uploadInfo" style="position: absolute;right: 0;"></div>' +
				'</div>'; 
				thisOb.parent().parent().append(barHtml);
				if ($(this).next().val() == "") {
					formDate.set("file_file",formDate.get(COLUMN_CODE));
					var ot = new Date().getTime(); //设置上传开始时间
					var oloaded = 0; //设置上传开始时，以上传的文件大小为0
					$.ajax({
						url: "<%=basePath%>rectifyinfo/uploadFile.do",
						type: "POST",
						data: formDate,
						processData: false,
						contentType: false,
						cache: false,
						//async : false,
						xhr: xhrOnProgress(function (e) {
							var percent = e.loaded / e.total;
							thisOb.parent().siblings(".progress").children(".progress-bar").css("width", (percent * 400));
							var time = document.getElementById("time");
							//上传速度计算
							var nt = new Date().getTime();//获取当前时间
							var pertime = (nt-ot)/1000; //计算出上次调用该方法时到现在的时间差，单位为s
							ot = new Date().getTime(); //重新赋值时间，用于下次计算
							
							var perload = e.loaded - oloaded; //计算该分段上传的文件大小，单位b       
							oloaded = e.loaded;//重新赋值已上传文件大小，用以下次计算
							
							var speed = perload/pertime;//单位b/s
							var bspeed = speed;
							var units = 'b/s';//单位名称
							if(speed/1024>1){
								speed = speed/1024;
								units = 'k/s';
							}
							if(speed/1024>1){
								speed = speed/1024;
								units = 'M/s';
							}
							speed = speed.toFixed(1);
							//剩余时间
							var resttime = ((e.total-e.loaded)/bspeed).toFixed(1);
							thisOb.siblings(".progress").children(".uploadInfo").text('速度：'+speed+units+'， 剩余时间：'+resttime+'s');
							//time.innerHTML = '，速度：'+speed+units+'，剩余时间：'+resttime+'s';
						}),
						success: function (req) {
							var sign = req.sign;
							if (sign == "yes") {
								// thisOb.next().val(req.FILE_PATH);
								$("#IMG_URL").val(req.FILE_PATH);
								console.log("上传结果" + req.FILE_PATH);
								console.log("上传结果元素" + thisOb.next());
							}
							// 上传的文件数量和需要上传的文件数量相等时提交表单
							isUpload ++;
							if (isUpload == needUpload) {
								submit();
							}
						},
						erro: function () {
							showMsg("上传文件失败");
							return false;
						}
					});
				}
			});
		}
		
		function showMsg(msg) {
			bootbox.dialog({
				message: "<span class='bigger-110'>"+ msg + "</span>",
				buttons: 			
				{ "button":{ "label":"确定", "className":"btn-sm btn-success"}}
			});
		}
		
		//打开上传excel页面
		function fromExcel(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="EXCEL 导入到数据库";
			 diag.URL = '<%=basePath%>rectifyinfo/goUploadExcel.do';
			 diag.Width = 300;
			 diag.Height = 150;
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					 document.location.reload();
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//下拉树
		/*var defaultNodes = {"treeNodes":${zTreeNodes}};
		function initComplete(){
			//绑定change事件
			$("#selectTree").bind("change",function(){
				if(!$(this).attr("relValue")){
			      //  top.Dialog.alert("没有选择节点");
			    }else{
					//alert("选中节点文本："+$(this).attr("relText")+"<br/>选中节点值："+$(this).attr("relValue"));
					$("#ORG_ID").val($(this).attr("relValue"));
			    }
			});
			//赋给data属性
			$("#selectTree").data("data",defaultNodes);  
			$("#selectTree").render();
			$("#selectTree2_input").val("${null==pd.ORG_NAME?'组织结构':pd.ORG_NAME}");
		}*/
		
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
	</script>
</body>
</html>