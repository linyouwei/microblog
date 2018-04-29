
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<! DOCTYPE html>
<html lang="zh-CN">
<head>
 	<jsp:include page="../common/head.jsp"/>
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/login.css" />
 	
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
                <a class="active" href="${pageContext.request.contextPath}/webUser/login.form">登录</a>
                <b></b>
                <a id="js-sign-up-btn" href="${pageContext.request.contextPath}/webUser/register.form">注册</a>
            </div>
        </h4>
        <form action="/microblog//webUser/checklogin.form" method="post" class="am-form">
            <fieldset class="am-form-set">
                <div class="input-prepend restyle">
                    <input placeholder="你的昵称" type="text" value="" name="userName" id="userName">
                    <i class="am-icon-user"></i>
                </div>
                <div class="input-prepend restyle">
                    <input placeholder="密码" type="text" value="" name="password" id="password">
                    <i class="am-icon-user"></i>
                </div>
                <div class="remember-btn">
                    <input type="checkbox"  value="true" checked="checked" name="session[remember_me]"
                           id="session_remember_me"><span>记住我</span>
                </div>
            </fieldset>
            <div>
                <input id="sign-in"  type="submit" "commit" value="登录" class="sign-up-button" data-disable-with="登录">
            </div>
        </form>
    </div>
</div>
</body>
<!-- 框架JS -->
<jsp:include page="../common/bottom.jsp"/>

<!-- 页面事件处理JS -->
<script type="text/javascript" src="/microblog/scripts/login.js"></script>
</html>
