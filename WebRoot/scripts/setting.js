 $(function () {
        $("#photo").change(function () {
             ajaxFileUpload();
        })
         function ajaxFileUpload(){
             $.ajaxFileUpload
            (
                {
                    url: '/microblog/homePage/addPet.form', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: 'photo', //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
                    success: function (data, status)  //服务器成功响应处理函数
                    {
                        console.log(data.url);
                        $("#avatar").attr("src", data.url);
                        $("#photo").change(function () {
                                ajaxFileUpload();
                        })
                    },
                    error: function (data, status, e)//服务器响应失败处理函数
                    {
                        alert(e);
                    }
                }
            )
            return false;
         }
    }) 


$(function () {
        $("#submit").click(function () {
            $.post('/myblog/setting_basic/', {
                    'nickname': $("#nickname").val(),
                    'birth_time': $("#birth_time").val(),
                    'province': $("#province").val(),
                    'city': $("#city").val(),
                    'marriage': $("#marriage").val(),
                    'gender': $('input:radio:checked').val()
//                $("input[type='radio']:checked").val();
                }, function (data) {
                    console.log(data.status);
                    if (data.status == 200) {
                        layer.tips('保存成功', '#submit');
                    } else {
                        layer.tips('保存失败', '#submit');

                    }

                }
            )
        })
        $("#basic-set").click(function () {
            $.get('/myblog/basic-set', {}, function (data) {
                    $("#daily-list").hide()
                    $('#user-list').children().empty();
                    $.each(data, function (i, n) {
                        $("#user-list").children().html("<li>" + n.username + "</li>");
                    })
                }
            )
        })
        $("#note").click(function () {
//             window.location.href = '/myblog/searchDaily/?searchVal='+ $("#search-data").val()+'&type=user';
            $.get('/myblog/searchDaily', {
                    'type': 'note',
                    'searchVal': $("#search-data").val()
                }, function (data) {
                    $("#daily-list").show()
                    $('#user-list').children().empty()
                }
            )
        })
    })
    
    
$(function () {
        //对省份添加option
        $.getJSON("/static/json/province.json", function (data) {
            p_id = $("#province").val();
            var china = data;
            for (var i = 0; i < china.length; i++) {
                if (china[i].code != p_id) {
                    $("#province").append("<option value='" + china[i].code + "'>" + china[i].name + "</option>");
                } else {
                    continue;
                }
            }
        })
        $.getJSON("/static/json/city.json", function (data) {
            var cities = data;
            //遍历city.json，选择省份的code的数据，添加到city中
            $.each(cities, function (index, city) {
                if (city.provinceCode == $("#province").val()) {
                    if (city.code != $("#city").val()) {
                        $("#city").append("<option value='" + city.code + "'>" + city.name + "</option>");
                    }
                }
            })
        })
        //对省份按钮绑定事件
        $("#province").change(function () {
            $("#city").children().remove();
            var select_val = $(this).children('option:selected').val();
            if (select_val == '0') {
                $("#city").html("<option value='0'>请选择</option>");
            }
            $.getJSON("/static/json/city.json", function (data) {
                var cities = data;
                //遍历city.json，选择省份的code的数据，添加到city中
                $.each(cities, function (index, city) {
                    if (city.provinceCode == select_val) {
                        $("#city").append("<option value='" + city.code + "'>" + city.name + "</option>");
                    }
                })
            })

        })
        $('#birth_time').datetimepicker({
            language: 'zh-CN',
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            autoclose: 1//选择后自动关闭
        });
    });