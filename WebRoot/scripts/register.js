/**
 * 页面初始化后，绑定函数。
 */
$(function(){
	//注册
	$("#sign-up").click(function(){
		register();
	});
});
//注册
function register() { 
	var username = $("#user_nickname").val();
	var password = $("#user_password").val();
	$.post('/microblog/myblog/register.form', {
	    'username': username,
	    'password': password
		}, function (data) {
			console.log(data);
			if(data.success==true){
				layer.tips('注册成功', '#sign-up');
				location.href("/microblog/sign/login.html")
			}else{
				layer.tips('注册失败', '#sign-up');
			}

})}


