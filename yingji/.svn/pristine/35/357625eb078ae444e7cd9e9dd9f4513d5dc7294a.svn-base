
// 获取picker数据
const getPickerData = () => {
    var categoryList = []
    var levelList = []
    var factorList = []

    categoryJson=JSON.parse(category);//将接收到的json字符串转为json对象
    levelJson=JSON.parse(level);
    factorJson=JSON.parse(factor);
    // 遍历category
    $.each(categoryJson, function (index, item) {
        categoryList.push(
            {
                label: item.nAME,
                disabled: false,
                value: item.bIANMA
            }
        )
    });
    $.each(levelJson, function (index, item) {
        levelList.push(
            {
                label: item.nAME,
                disabled: false,
                value: item.bIANMA
            }
        )
    });
    $.each(factorJson, function (index, item) {
        factorList.push(
            {
                label: item.nAME,
                disabled: false,
                value: item.bIANMA
            }
        )
    });

    /!* category-picker *!/
    $('#category-picker').on('click', function () {
        weui.picker(
            categoryList,
            {
                defaultValue: [0],
                className: 'custom-classname',
                confirmText: '选择',
                closeText: 'close',
                onChange: function (result) {

                },
                //点击选择的时候才会触发onConfirm
                onConfirm: function (result) {
                    $("#HIDDEN_DANGER_CLASSIFY").val(result[0].value);
                    $("#category-picker").text(result[0].label).css("color", "#222")
                },
                id: 'picker',
                title: '隐患类别',
                desc: '选择隐患类别',
                showClose: true,
            });
    });

    /!* level-picker *!/
    $('#level-picker').on('click', function () {
        weui.picker(
            levelList,
            {
                defaultValue: [0],
                className: 'custom-classname',
                confirmText: '选择',
                closeText: 'close',
                onChange: function (result) {

                },
                onConfirm: function (result) {
                    $("#HIDDEN_DANGER_LEVEL").val(result[0].value);
                    $("#level-picker").text(result[0].label).css("color", "#222")
                },
                id: 'picker',
                title: '隐患级别',
                desc: '选择隐患级别',
                showClose: true,
            });
    });

    /!* factor-picker *!/
    $('#factor-picker').on('click', function () {
        weui.picker(
            factorList,
            {
                defaultValue: [0],
                className: 'custom-classname',
                confirmText: '选择',
                closeText: 'close',
                onChange: function (result) {


                },
                onConfirm: function (result) {
                    $("#HIDDEN_DANGER_FACTOR").val(result[0].value);
                    $("#factor-picker").text(result[0].label).css("color", "#222")
                },
                id: 'picker',
                title: '隐患因素',
                desc: '选择隐患因素',
                showClose: true,
            });
    });
}
// 获取日期picker数据
const getDatePicker = () => {
    //设置默认时间的数组，可以在后端获取当前日期然后传过来
    var timeList = ["2023","07","07"];
    if(time != null && time != ''){
        timeList = time.split("-");
    }
    $('#datePickerBtn').on('click', function(res){
        var str = $("#COMPLETE_TIME").val();
        weui.datePicker({
            start: '1990-12-29',
            end: '2030-12-29',
            /**
             * https://zh.wikipedia.org/wiki/Cron
             * cron 表达式后三位
             * 示例：
             *  * * *                每天
             *  5 * *                每个月的5日
             *  1-10 * *             每个月的前10日
             *  1,5,10 * *           每个月的1号、5号、10号
             *  *\/2 * *             每个月的 1、3、5、7...日，注意写的时候斜杠“/”前面没有反斜杠“\”，这是因为是注释所以需要转义
             *  * 2 0                2月的每个周日
             *  * * 0,6              每个周末
             *  * * 3                每周三
             */
            cron: '* * *',
            defaultValue: [timeList[0], timeList[1], timeList[2]],
            onChange: function (result) {
            },
            onConfirm: function (result) {
                var year = result[0].value
                var month = result[1].value
                var day = result[2].value
                if (month < 10) {
                    month = "0" + month;
                }
                if (day < 10) {
                    day = "0" + day;
                }
                $("#PLAN_COMPLETE_TIME").val(year+"-"+month+"-"+day)
                $("#datePickerBtn").text(`${year}-${month}-${day}`).css("color", "#222")
            },
            id: 'datePicker',
            title: '日期选择器'
        });
    });
}

getPickerData()
getDatePicker()
