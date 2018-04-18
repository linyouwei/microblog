/**
 * 页面初始化后，绑定函数。
 */
$(function(){

	//登录
//	$("#sign-in").click(function(){
//		login();
//	});
//		
});

//登陆
function login() {
	//验证用户名、密码不能为空
	var username = $("#username").val();
	var password = $("#password").val();
	console.log(username);
	console.log(password);
//	if(username==null&password==null){	
//		console.log("进入判断用户名、密码是否为空语句")
//		return ;
//	}else{
//		console.log("用户名,密码不为空")
//	}
//	var reg = /^\w{3,20}$/;
//	if(!reg.test(username)) {
//		alert("用户名必须是3-20位字母、数字、下划线的组合");
//		return;
//	}
	$.post(
		"/microblog/webUser/checklogin.form",
		{"username":username,"password":password},
		function(result){
	
		}
		);
	
	
}


