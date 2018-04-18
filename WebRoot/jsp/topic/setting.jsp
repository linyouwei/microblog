
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<jsp:include page="../common/head.jsp"/>
	<link rel="stylesheet href="${pageContext.request.contextPath}/styles/setting.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/common/datetimepicker/css/amazeui.datetimepicker.css"/>
    
</head>

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
            <form method="POST" enctype="multipart/form-data" class="am-form">
                <fieldset>
                    <div class="am-form-group">
                        <img class="avatar " id='avatar'
                             src="{{user_img.img_path}}">
                        <a class="btn btn-hollow"><input unselectable="on" type="file" class="hide" id="photo" name="photo">更改头像</a></div>
                    <div class="am-form-group">
                        <label for="doc-ipt-email-1" class="btn-color">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label>
                        <input type="text" style="width:40%;display: inline; " class="btn-hollow" placeholder="输入昵称"
                               name="name"
                               value="${userDetail.userInfo.userName}" id="nickname">
                    </div>

                    <div class="am-form-group">
                        <label for="doc-ipt-pwd-1"
                               class="btn-color">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
                        <label for="doc-ipt-email-1" class="btn-color">男${userDetail.gender}</label>

                        <input type="radio" name="gender" value="0" {% if user_details.gender == 0 %}checked="checked" {% else %}{% endif %}>
                        <label for="doc-ipt-email-1" class="btn-color">女</label>
                        <input type="radio" name="gender" value="1" {% if user_details.gender == 1 %}checked='checked' {% else %}{% endif %}>
                    </div>

                    <div class="am-form-group">
                        <label for="doc-ipt-file-1" style="width:40%;display: inline" class="btn-color">出生日期:</label>
                        <input class="btn-hollow" type="text" value="${userDetail.birthday}"
                               class="am-form-field"
                               id="birth_time"
                               readonly required name="birth_time" style="width:40%;display: inline">
                    </div>

                    <div>
                        <label for="doc-ipt-file-1" class="btn-color">家&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乡:</label>
                        <select id="province" name="province" style="width:40%;display: inline" class="btn-hollow">
                            <option value="{{distict.p_code}}">${userDetail.province.code }</option>
                        </select>
                        <select id="city" name="city" style="width:40%;display: inline" style="display: inline"
                                class="btn-hollow">
                            <option value="{{distict.c_code}}">${userDetail.city.code }</option>

                        </select>
                    </div>
                    <div class="am-form-group">
                        <label for="marriage"
                               class="btn-color">婚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姻:</label>
                        <select id="marriage" name="marriage" style="width:40%;display: inline" class="btn-hollow">
                            <option value="0" {% if user_details.marriage == 0 %}selected="selected" {% else %}{% endif %}>单身
                            </option>
                            <option value="1" {% if user_details.marriage == 1 %}selected="selected" {% else %}{% endif %}>已婚
                            </option>
                            <option value="2" {% if user_details.marriage == 2 %}selected="selected" {% else %}{% endif %}>离异
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
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/setting.js"></script>

  
</body>
</html>