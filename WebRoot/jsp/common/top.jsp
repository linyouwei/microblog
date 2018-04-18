<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/taglib.jsp"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="org.uclbrt.entity.*" %>

<header class="am-topbar">
   <h1 class="am-topbar-brand"><a  class="am-active" href="#">微书</a></h1>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav">
            <li class="am-active"><a href="#">发现</a></li>
            <li  class="am-active"><a href="#">关注</a></li>
            <li  class="am-active"><a href="#">消息</a></li>
        </ul>

        <form method="get" action="{% url 'myblog:searchDaily' %}" class="am-topbar-form am-topbar-left am-form-inline" role="search">
            <div class="am-form-group">
                <input type="text" class="am-form-field am-input-sm"id="search-data" name="searchVal">
                <input type="submit" class="search-btn" id="search-btn" value="搜索">
                <input type="hidden" name="type" value="note">
            </div>
        </form>

        <div class="am-topbar-right">
        	<% UserLogin user=(UserLogin)session.getAttribute("user"); 
        	boolean loginFlag ;
        	if(user!=null) loginFlag = true;   
        	else loginFlag = false; 
        	%> 
        	<c:choose>   
	        	<c:when test="<%=loginFlag%>">	
		            <div class="am-dropdown" data-am-dropdown="{boundary: '.am-topbar'}">
		                <button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm am-dropdown-toggle"
		                        data-am-dropdown-toggle> ${user.userName}  <span class="am-icon-caret-down"></span></button>
		                <ul class="am-dropdown-content">
		                    <li><a href="${pageContext.request.contextPath}/homePage/publish.form">发布</a></li>
		                    <li><a href="${pageContext.request.contextPath}/homePage/setting.form">设置</a></li>
		                    <li><a href="${pageContext.request.contextPath}/webUser/sign_out.form">退出</a></li>
		                </ul>
		            </div>
	            </c:when>
	            <c:otherwise>
		            <div class="am-topbar-right">
		                <a href="/myblog/register" class="am-btn am-btn-primary am-topbar-btn am-btn-sm color">注册</a>
		            </div>
		            <div class="am-topbar-right">
		                <a href="/myblog/login" class="am-btn am-btn-primary am-topbar-btn am-btn-sm">登录</a>
		            </div>
	            </c:otherwise>
           </c:choose>
        </div>
    </div>
</header>
    