
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>

<!doctype html>
<html>
<head>
	<jsp:include page="../common/head.jsp"/>
	 <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/setting.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/common/datetimepicker/css/amazeui.datetimepicker.css"/>
    
</head>
<%
	UserDetail userDetail = (UserDetail) request.getAttribute("userDetail");
	System.out.println("333:"+userDetail.toString());
	Date day = userDetail.getBirthday();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
	String birthday =sdf.format(day);
	request.setAttribute("birthday",birthday);
 %>
<body id="blog">
<%@ include file="../common/top.jsp" %>
<div class="am-g am-g-fixed" id="dataListDiv">
    <div class="am-u-md-3 am-u-sm-12">
        <div class="am-g am-g-fixed">
            <ul class="am-nav">
                <li id="basic-set"><a href="#">基础设置</a></li>
                <li id="user-data"><a href="#">个人资料</a></li>
                <li id="accout-manage"><a href="#">账号管理</a></li>
            </ul>
        </div>
    </div>
    <div class="am-u-md-9 am-u-sm-12" id="user-list">
        <div class="am-form-group">
        <!-- form表单提交图片 -->
        <!--
        <form action="/microblog/homePage/addPet.form" method="post" enctype="multipart/form-data">
　　			<input type="file" required="required" name="pic" id="exampleInputFile">
			<input type="submit" class="am-btn am-btn-default btn-submit" >提交</input>
		</form>
        -->
            <form method="POST" enctype="multipart/form-data" class="am-form">
                <fieldset>
                    <div class="am-form-group">
                        <img class="avatar " id='avatar'
                             src="${pageContext.request.contextPath}/${userDetail.img_path}">
                        <a class="btn btn-hollow"><input unselectable="on" type="file" class="hide" id="photo" name="photo">更改头像</a></div>
                    <div class="am-form-group">
                        <label for="doc-ipt-email-1" class="btn-color">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label>
                        <input type="text" style="width:40%;display: inline; " class="btn-hollow" placeholder="输入昵称"
                               name="name"
                               value="${userDetail.userInfo.userName}" id="nickname">
                    </div>

                    <div class="am-form-group">
                    	<c:set var="gender" value="${userDetail.gender}" scope="request"/>
                        <label for="doc-ipt-pwd-1"
                               class="btn-color">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
                        <label for="doc-ipt-email-1" class="btn-color">男</label>
						
                        <input type="radio" name="gender" value="0" <c:if test="${gender==0 }">checked="checked"</c:if>>
                        <label for="doc-ipt-email-1" class="btn-color">女</label>
                        <input type="radio" name="gender" value="1" <c:if test="${gender==1 }">checked="checked"</c:if>>
                    </div>
                    <div class="am-form-group">
                        <label for="doc-ipt-file-1" style="width:40%;display: inline" class="btn-color">出生日期:</label>
                        <input class="btn-hollow" type="text"  value="${birthday}"
                               class="am-form-field"
                               id="birth_time"
                               readonly required name="birth_time" style="width:40%;display: inline">
                    </div>
                    <div>
                        <label for="doc-ipt-file-1" class="btn-color">家&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乡:</label>
                        <select id="province" name="province" style="width:40%;display: inline" class="btn-hollow">
                            <option value="${userDetail.province.code}">${userDetail.province.name }</option>
                        </select>
                        <select id="city" name="city" style="width:40%;display: inline" style="display: inline"
                                class="btn-hollow">
                            <option value="${userDetail.city.code }">${userDetail.city.name }</option>
                        </select>
                    </div>
                    <div class="am-form-group">
                        <label for="marriage"
                               class="btn-color">婚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姻:</label>
                        <c:set var="marriage" value="${userDetail.marriage}" scope="request"/>
                        <select id="marriage" name="marriage" style="width:40%;display: inline" class="btn-hollow">
                            <option value="0" <c:if test="${marriage==0 }">selected="selected"</c:if> >单身
                            </option>
                            <option value="1" <c:if test="${marriage==1}">selected="selected"</c:if> >已婚
                            </option>
                            <option value="2" <c:if test="${marriage==2}">selected="selected"</c:if> >离异
                            </option>
                        </select>
                        <span class="am-form-caret"></span>
                    </div>
                    <p>
                        <type type="button" class="am-btn am-btn-default btn-submit" id="submit">提交</type>
                    </p>
                </fieldset>
            </form>
     
        </div>

    </div>
</div>
<div class="am-g am-g-fixed blog-fixed" id="search">
    <div class="am-u-md-8 am-u-sm-12" id="search_data">
    </div>
</div>

<jsp:include page="../common/bottom.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/common/datetimepicker/js/amazeui.datetimepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/common/datetimepicker/js/locales/amazeui.datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/common/ajax/ajaxfileupload.js" ></script>
<!-- 页面事件处理JS -->
<script>
	basePath = "${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/setting.js"></script>

  
</body>
</html>