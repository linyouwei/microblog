 $(function () {
	 	
      //对省份添加option
        addProvinceOption();
        
       //对城市添加option
        addCityOption();
 
        //对省份按钮绑定事件
        bindProvinceButton();
        
        $('#birth_time').datetimepicker({
            language: 'zh-CN',
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            autoclose: 1//选择后自动关闭
        });
        
        //上传图片
        $("#photo").change(function () {
             ajaxFileUpload();
        });
        //提交基础设置资料
        $("#submit").click(function () {
        	submitFormData();
        });
        
         
    }) 
    


   function ajaxFileUpload(){
        	//异步上传图片
             $.ajaxFileUpload
            (
                {
                    url: '/microblog/homePage/addPhoto.form', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: 'photo', //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
                    success: function (data, status)  //服务器成功响应处理函数
                    {
                        console.log(data.data.imgUrl);
                        $("#avatar").attr("src", data.data.imgUrl);
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


//提交基础设置资料
 function submitFormData(){
	var param= {
	         'nickname': $("#nickname").val(),
	         'birth_time': $("#birth_time").val(),
	         'province': $("#province").val(),
	         'city': $("#city").val(),
	         'marriage': $("#marriage").val(),
	         'gender': $('input:radio:checked').val()
//	     $("input[type='radio']:checked").val();
	     };
	console.log(param);
	 $.ajax({
         dataType: "JSON",
         contentType:'application/json;charset=UTF-8',//关键是要加上这行
         traditional:true,//这使json格式的字符不会被转码
         data: JSON.stringify(param),
         type: "POST", 
         timeout: 20000,
         url: basePath+'/homePage/settingBasic.form',
         success : function (data) {
     		console.log(data);
     		if(data.data.status==200){
     			layer.tips('保存成功', '#submit');
     			window.location.href='/microblog/homePage/setting.form';
     		}else{
     			 layer.tips('保存失败', '#submit');
     		}
         },
         error : function (data){    
         }
     });

 }
 
 

 function addProvinceOption(){

 	$.getJSON(basePath+"/scripts/common/json/province.json", function (data) {
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
 }
 function addCityOption(){
 	$.getJSON(basePath+"/scripts/common/json/city.json", function (data) {
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
 }
  
 function bindProvinceButton(){
 	$("#province").change(function () {
         $("#city").children().remove();
         var select_val = $(this).children('option:selected').val();
         if (select_val == '0') {
             $("#city").html("<option value='0'>请选择</option>");
         }
         $.getJSON(basePath+"/scripts/common/json/city.json", function (data) {
             var cities = data;
             //遍历city.json，选择省份的code的数据，添加到city中
             $.each(cities, function (index, city) {
                 if (city.provinceCode == select_val) {
                     $("#city").append("<option value='" + city.code + "'>" + city.name + "</option>");
                 }
             })
         })

     })
 	
 }
  
  $(function () {
         
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
//              window.location.href = '/myblog/searchDaily/?searchVal='+ $("#search-data").val()+'&type=user';
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