 var editor; 
$(function () {
	//加载编辑器
	onloadEditor();
	//加载文章标签
	onloadArticleTag();
	//加载个人分类
	onloadUserCategroy();
	//发布
	publish();
	

	        
 }) 
function onloadEditor(){

    KindEditor.ready(function (K) {
        editor = K.create('textarea[name="content"]', {
            allowFileManager: true
        });

    });
  	
}

function onloadArticleTag(){

    var initCount = $("#InputsWrapper").length;
    var x = 1;
    var FieldCount = 0;
    $("#addTag").click(function () {
        FieldCount++;
        $("#InputsWrapper").append('<div class="div-tags"><input class="input-tags" type="text"name="tags" id="tags_' + FieldCount + '"/><a href="#" class="removeclass">×</a></div>')
    })
    $("body").on('click', '.removeclass', function () {
        $(this).parent('div').remove();
    })
	
}
function onloadUserCategroy(){

    var categoryCount = $("#categoryWrapper").length;
    var categoryCount = 0;
    $("#addCategory").click(function () {
        categoryCount++;
        $("#categoryWrapper").append('<div class="div-tags"><input class="input-tags" type="text"name="userCategory" id="category_' + categoryCount + '"/><a href="#" class="removeclass">×</a></div>')
    })
    $("body").on('click', '.removeclass', function () {
        $(this).parent('div').remove();
    })
}

function publish(){
	  $('#btnPublish').click(function (e) {
	        //标题、文章内容、博客分类是必选
	        // 文章标签、个人分类是可选
//	        if($("#txtTitle").val().length==0){
//	            alert('标题不能为空');
//	            return false;
//	        }
//	        if( editor.html().length==0){
//	             alert('内容不能为空');
//	            return false;
//	        }
	        var category = $("#blogCategory option:selected").val();
//	        console.log(category);
//	        if(category==0){
//	            alert('选择博客分类');
//	            return false;
//	        }
	        var tagsList = $("input[name='tags']");
	        var tagsArr = [];
	        for (var i = 0; i < tagsList.length; i++) {
	            tagsArr.push(tagsList.eq(i).val());
	        }
	        console.log(tagsArr);
	        var userCategoryList = $("input[name='userCategory']");
	        var userCategoryArr = [];
	        for (var i = 0; i < userCategoryList.length; i++) {
	            userCategoryArr.push(userCategoryList.eq(i).val());
	        }
	        console.log(userCategoryArr);
	        // 只需传category_id
	        var existUserCategoryList = $("input[name='existUserCategory']:checked");
	        var existUserCategoryArr = [];
	        for (var i = 0; i < existUserCategoryList.length; i++) {
	            existUserCategoryArr.push(existUserCategoryList.eq(i).val());
	        }
	        console.log(existUserCategoryArr);
	        
	        //该形式不行

//
//	        $.post("/microblog/homePage/publish.form", {
//	            'title':$("#txtTitle").val(),
//	            'content': editor.html(),
//	            'tagsArr':tagsArr,
//	            'userCategoryList':userCategoryArr,
//	            'existUserCategoryList':existUserCategoryArr,
//	            'category':category,
//	        }, function (data) {
//	            console.log(data)
//	            	/*
//	                if(data.status==200){
//	                    window.location.href='/myblog/publishSuccess'
//	                }
//	                */
//	           
//	        })
        
	        var param = {"title":$("#txtTitle").val(),
	        			"content":editor.html(),
	        			"tagsArr":tagsArr,
	        			"userCategoryArr":userCategoryArr,
	        			"existUserCategoryArr":existUserCategoryArr,
	        			"category":category};
	        $.ajax({
	            dataType: "JSON",
	            contentType:'application/json;charset=UTF-8',//关键是要加上这行
	            traditional:true,//这使json格式的字符不会被转码
	            data: JSON.stringify(param),
	            type: "POST", 
	            timeout: 20000,
	            url: "/microblog/homePage/publish.form",
	            success : function (data) {
	        		console.log(data);
	        		if(data.data.status==200){
	        			 window.location.href='/microblog/homePage/publishSuccess.form';
	        		}          
	            },
	            error : function (data){    
	            }
	        });
	    });
}
