
getFormList()

function getFormList(){
    //获取form选项框中的值
    $.ajax({
        type: "GET",
        url: "frontend/HKrepairs/json/form.json",
        dataType: "json",
        async: false,
        success: function (res) {
            var category = res.category
            var company = res.company
            var level = res.level
            var factor = res.factor
            // 公司名称
            $.each(company, function (index, value) { 
                $("#company-name").append(`
                <li>
                    <input name="ORG_ID" id="ORG_ID" type="button" value="${value}">
                </li>
                `)
            });
            // 隐患类别
            $.each(category, function (index, value) { 
                $(".category-box .sle-box").append(`
                <option value="${value}">${value}</option>
                `)
            });
            // 隐患级别
            $.each(level, function (index, value) { 
                $(".level-box .sle-box").append(`
                <option value="${value}">${value}</option>
                `)
            });
            // 隐患因素
            $.each(factor, function (index, value) { 
                $(".factor-box .sle-box").append(`
                <option value="${value}">${value}</option>
                `)
            });
        }
    });
}