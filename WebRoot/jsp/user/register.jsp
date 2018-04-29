
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<! DOCTYPE html>
<html lang="zh-CN">
<head>
 	<jsp:include page="../common/head.jsp"/>
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/register.css" />
</head>
<body>
<div class="sign">
    <div class="header">
        <div class="am-g">
            <h1>Simple Blog</h1>
        </div>
        <hr/>
    </div>
    <div class="main">
        <h4 class="title">
            <div class="normal-title">
                <a  href="${pageContext.request.contextPath}/webUser/login.form">登录</a>
                <b></b>
                <a id="js-sign-up-btn" class="active" href="${pageContext.request.contextPath}/webUser/register.form">注册</a>
            </div>
        </h4>
       <form post="" class="am-form">
				<fieldset class="am-form-set">
					<div class="input-prepend restyle">
						<input placeholder="你的昵称" type="text" value=""
							name="user_nickname" id="user_nickname"> <i
							class="am-icon-user"></i>
					</div>
					<div class="input-prepend restyle">
						<input placeholder="设置密码" type="text" value=""
							name="user_password" id="user_password"> <i
							class="am-icon-user"></i>
					</div>

				</fieldset>
				<div>
					<input id="sign-up" name="commit" value="注册" class="sign-up-button"
						data-disable-with="注册">
				</div>
			</form>
    </div>
</div>
</body>
<!-- 框架JS -->
<jsp:include page="../common/bottom.jsp"/>
<!-- 页面事件处理JS -->
<script>
	basePath = "${pageContext.request.contextPath}";
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/register.js"></script>
</html>
