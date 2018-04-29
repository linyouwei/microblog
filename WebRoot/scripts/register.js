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
	$.post(basePath+'/webUser/register.form', {
	    'username': username,
	    'password': password
		}, function (data) {
			console.log(data);
			if(data.data.pass==true){
				layer.tips('注册成功', '#sign-up');
				 window.location.href=basePath+'/webUser/login.form';
			}else{
				layer.tips('注册失败', '#sign-up');
			}

})}


