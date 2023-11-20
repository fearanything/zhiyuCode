
clickSelect()
saveForm()
deletItem() 



// 选择下拉内容
function clickSelect(){
    $("#sel_menu").click(function () {
    })
    // 单位名称
    /*$(".company-name").click(function(){
        $(".company-name ul").stop().slideToggle()
        $(".company-name input").click(function(res){
            console.log(res)
            $(".company-name span").text($(this).val())
        }) 
        
    })*/
}



// 保存草稿、提交
function saveForm(){
    // 保存草稿
    $("#saveForm").click(function(){
        var companyVal = $(".company-name .name span").text()
        var categoryVal = $("#category-picker").text()
        var levelVal = $("#level-picker").text()
        var factorVal = $("#factor-picker").text()
        var finishVal = $(".finish-box input:radio:checked").val()
        var finish_timeVal = $(".finish-time #datePickerBtn").text()
        var danger_text = $("#textarea1").val()
        var measure = $("#textarea2").val()

        // location.href = "backlog.html"
    })

    // 提交
    $("#uploadForm").click(function(){

    })
}

// 删除
function deletItem(){
    $(".program-menu").on('click', '#delet', function (e) {
        $.confirm({
            title: "删除",
            content: "是否确认删除此表？",
            type: "blue",
            buttons: {
                ok: {
                    text: "确认",
                    btnClass: "btn-primary",
                    action: function(){
                        console.log("确认删除");
                    }
                },
                cancel: {
                    text: "取消",
                    btnClass: "btn-primary",
                }
            }
        })
    });
}

// 上传照片
function UploadFunction (name) {
    this.name = name;
    this.init();
    };
    UploadFunction.prototype = {
    // 初始化
    init: function () {
        this.clickUpload();
        this.imgPreview();
        this.delImage();
    },
    flag: 0,
    filesList: [],
    // 点击上传
    clickUpload: function () {
        var that = this;
        var filesList = this.filesList;
        $('.btn').on('click', function() {
        that.flag = 0;
        if (filesList.length > 0) {
        for (var i = 0; i < filesList.length; i++) {
        that.upLoadMethod(filesList[i]);
                }
            };
        }) 
    },
    imgPreview: function () {
        var that = this;
        $('.upload-header').on('change', '#upload', function(e) {
        var files = e.target.files;
        console.log(files);
        if (files.length > 0) {
        for (var i = 0; i < files.length; i++) {
        var reader = new FileReader();
        reader.onload = function () {
        var text = `
        <div class="img-list">
            <img src="${this.result}" >
            <div class="del-img">删除</div>
        </div>
        `
    $('.img-box').append(text);
    };
        reader.readAsDataURL(files[i]);
            reader.onloadend = function (e) {
                $(".img-box").css('background',"url("+e.target.result+")");
                console.log("url:",e.target.result)
                //e.target.result就是最后的路径地址
            }
        that.filesList.push(files[i]);
                };
            };
        })
    },
    // upLoadMethod: function (file) {
    //     var that = this;
    //     var formData = new FormData();
    //     formData.append('file', file);
    //     $.ajax({
    //     type: "post",
    //     url: '这里使用上传的地址/upload',
    //     data: formData,
    //     mimeType: "multipart/form-data",
    //     dataType: "json",
    //     async: false,
    //     cache: false, //上传文件不需要缓存
    //     contentType: false, //需设置为false。因为是FormData对象，且已经声明了属性enctype="multipart/form-data"
    //     processData: false, //需设置为false。因为data值是FormData对象，不需要对数据做处理
    //     success: function (response) {
    //     that.flag += 1;
    //     if (that.flag === that.filesList.length) {
    //     console.log('我上传完成了');
    //     };
    //     },
    //     error: function (err) {
    //     console.log('上传失败');
    //     }
    //     });
    //     },
        delImage: function () {
        var that = this;
        //img-box是整体展示图片的部分
        //点击删除事件
        $('.img-box').on('click', '.del-img', function () {
        var delStatus = confirm('确认这张图片删除吗？');
        if (delStatus) {
        //parent()获取点击元素的直接父元素，index()获取当前元素相对于父元素的索引值
        var index = $(this).parent().index();
        $(this).parent().remove();
        that.filesList.splice(index, 1);
        };
        });
    }
    }
    var UploadFunction = new UploadFunction('小明删照片');
