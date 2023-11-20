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

                        <form action="morg/${msg}.do" name="Form" id="Form" method="post">
                            <input type="hidden" name="ORG_ID" id="ORG_ID" value="${pd.ORG_ID}"/>
                            <input type="hidden" name="ISORG" id="ISORG" value="${pd.ISORG}"/>
                            <input type="hidden" name="ORG_LEVEL" id="ORG_LEVEL" value="${pd.ORG_LEVEL}"/>
                            <input type="hidden" name="PARENT_ID" id="PARENT_ID" value="${null == pds.ORG_ID ? 0:pds.ORG_ID}"/>
                            <div id="zhongxin" style="padding-top: 13px;">
                                <table id="table_report" class="table table-striped table-bordered table-hover">
                                    <tr>
                                        <td style="width:79px;text-align: right;padding-top: 13px;">上级:</td>
                                        <td>
                                            <div class="col-xs-4 label label-lg label-light arrowed-in arrowed-right">
                                                <b>${null == pds.ORG_NAME ?'(无) 此为顶级':pds.ORG_NAME}</b>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="width:75px;text-align: right;padding-top: 13px;">项目名称:</td>
                                        <td><input type="text" name="ORG_NAME" id="ORG_NAME" value="${pd.ORG_NAME}" maxlength="100" placeholder="这里输入项目名称" title="项目名称" style="width:98%;"/></td>
                                    </tr>
                                    <tr>
                                        <td style="width:75px;text-align: right;padding-top: 13px;">项目简称:</td>
                                        <td><input type="text" name="ORG_NAME_SHORT" id="ORG_NAME_SHORT" value="${pd.ORG_NAME_SHORT}" maxlength="100" placeholder="这里输入项目简称" title="项目简称" style="width:98%;"/></td>
                                    </tr>
                                    <tr>
                                        <td style="width:75px;text-align: right;padding-top: 13px;">项目编码:</td>
                                        <td><textarea type="text" name="ORG_CODE" id="ORG_CODE" maxlength="65535" cols="30" rows="5" placeholder="这里输入项目编码" title="项目编码" style="width:98%;">${pd.ORG_CODE}</textarea></td>
                                    </tr>
                                    <tr>
                                        <td style="width:75px;text-align: right;padding-top: 13px;">项目简称:</td>
                                        <td><textarea type="text" name="REMARK" id="REMARK" maxlength="65535" cols="30" rows="5" placeholder="这里输入备注" title="备注" style="width:98%;">${pd.REMARK}</textarea></td>
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
        if($("#ORG_NAME").val()==""){
            $("#ORG_NAME").tips({
                side:3,
                msg:'请输入项目',
                bg:'#AE81FF',
                time:2
            });
            $("#ORG_NAME").focus();
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
        if($("#ORG_NAME_SHORT").val()==""){
            $("#ORG_NAME_SHORT").tips({
                side:3,
                msg:'请输入项目简称',
                bg:'#AE81FF',
                time:2
            });
            $("#ORG_NAME_SHORT").focus();
            return false;
        }

        $("#Form").submit();
        $("#zhongxin").hide();
        $("#zhongxin2").show();

        <%--//判断是否重复--%>
        <%--var localSign;--%>
        <%--$.ajax({--%>
        <%--    type: "POST",--%>
        <%--    url: "<%=basePath%>morg/duplicate.go",--%>
        <%--    data: { "ORG_CODE": $("#ORG_CODE").val(),--%>
        <%--        "ORG_ID": $("#ORG_ID").val()--%>
        <%--    },--%>
        <%--    dataType:'json',--%>
        <%--    async : false,--%>
        <%--    success: function(data){--%>
        <%--        localSign = data.sign;--%>
        <%--    },--%>
        <%--    error : function(){--%>
        <%--        return false;--%>
        <%--    }--%>
        <%--});--%>

        <%--console.log("localSign",localSign)--%>
        <%--//如果没有相同ORG_ID，就允许上传--%>
        <%--if(localSign == "true"){--%>
        <%--    $("#Form").submit();--%>
        <%--    $("#zhongxin").hide();--%>
        <%--    $("#zhongxin2").show();--%>
        <%--}--%>
        <%--else if(localSign == "Same" && '${msg}' == "edit"){--%>
        <%--    $("#Form").submit();--%>
        <%--    $("#zhongxin").hide();--%>
        <%--    $("#zhongxin2").show();--%>
        <%--}--%>
    }

    $(function() {
        //日期框
        $('.date-picker').datepicker({autoclose: true,todayHighlight: true});
    });



</script>
</body>
</html>