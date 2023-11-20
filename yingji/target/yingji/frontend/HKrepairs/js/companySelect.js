//下拉框数据
var companyList = [];
// 请求公司名数据
$.ajax({
    type: "GET",
    url: "http://localhost:8080/hkSafeMonitor_war_exploded/frontend/mobile/getOrgName",
    dataType: "json",
    async: false,
    success: function (res) {
        var companyName = res
        $.each(companyName, function (index, item) {
            companyList.push(
                {
                    text: item.ORG_NAME,
                    id: item.ORG_ID
                }
            )
        });
    }
});

//初始化select2单选
initSelect2WithSearch();

/**
 * 初始化select2单选，默认带搜索功能。
 */
function initSelect2WithSearch() {
    $("#sel_menu").select2({
        tags: true,
        placeholder: '请搜索公司名称...',
        data: companyList,
        allowClear: true
    });
    //获取选中的机构的value
    $("#sel_menu").on("select2:select", function(res){
        var id = $("#sel_menu").select2("val", companyList.id)
        $("#ORG_ID").val(id);
    });
}
