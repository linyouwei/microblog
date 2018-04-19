<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%  
    String ctxPath = request.getContextPath();  
    request.setAttribute("ctxPath", ctxPath);  
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()  
            + ctxPath + "/";  
    request.setAttribute("basePath", basePath);  
%>  
<!doctype html>
<html>
<head>
	<jsp:include page="../common/head.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/common/kindeditor/themes/default/default.css"/>
   	<link rel="stylesheet href="${pageContext.request.contextPath}/styles/setting.css"/>
</head>

<body id="blog">
<br><%@ include file="../common/top.jsp" %>

<div class="am-g am-g-fixed" id="dataListDiv">
    <div class="am-u-md-3 am-u-sm-12">
        <div class="am-g am-g-fixed">
            <ul class="am-nav">
                <li id="basic-set"><a href="#">文章管理</a></li>
                <li id="user-data"><a href="#">专栏管理</a></li>
                <li id="comment-manage"><a href="#">评论管理</a></li>
                <li id="category-manage"><a href="#">个人分类管理</a></li>
            </ul>
        </div>
    </div>
    <div class="am-u-md-9 am-u-sm-12" id="user-list">
        <input type="text" id="txtTitle" maxlength="100" placeholder="输入文章标题" style="margin-bottom: 20px;">
        <textarea id="mul_input" name="content"
                  style="width:700px;height:200px;visibility:hidden;display: block;"></textarea>
        <br>
        <div id="moreDiv">
            <div class="pos-box">
                <div>
                    <div class="div-float"><label class="labTitle col-form-label">文章标签：</label></div>
                    <div id="InputsWrapper" class="div-float">
                    </div>
                    <div class="div-float">
                        <button id="addTag">添加标签</button>
                    </div>
                    <div class="div-clear-float"></div>

                </div>
                <div>
                    <div class="div-float"><label class="labTitle col-form-label">个人分类：</label></div>
                    <div id="categoryWrapper" class="div-float">
                    </div>
                    <div class="div-float">
                        <button id="addCategory">添加新分类</button>
                    </div>
                    <div class="div-clear-float"></div>
                    <c:forEach items="${requestScope.existUserCategory}" var="u">
	                     <input type="checkbox" value="${u.id}" name="existUserCategory">
	                    <span>${u.category_name }</span>
                    </c:forEach>
                   
                    <!--
                    {% if existUserCategory %}
                        {% for category in existUserCategory %}
                        <input type="checkbox" value="{{category.id}}" name="existUserCategory">
                        <span>{{category.name}}</span>
                        {% endfor %}
                    {% endif %}
               		 -->
                
                </div>
                <div class="form-group row form-control-sm">
                    <label class="labTitle col-form-label">博客分类：</label>
                    <div style="display: inline-block">
                        <select  id="blogCategory" name="blogCategory">'
                            <option value="0">选择分类</option>
                            <c:forEach items="${requestScope.categoryList}" var="u">
                                 <option value="${u.id }" name="category">${u.category_name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="opt-box row unfull">
                    <label class="labTitle col-form-label"></label>
                    <div class="txt-box">
                        <input id="btnPublish" type="button" class="btn btn-outline-danger" value="发布博客" title="发布博客">
                        <input id="btnDraft" type="button" class="btn btn-outline-danger ml-24 btn-baocun" value="保存草稿"
                               title="保存文章并留在当前页">
                        <input id="btnCancel" type="button" class="btn btn-outline-secondary ml-24 btn-shanchu"
                               title="返回列表页" value="返回">
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>
<jsp:include page="../common/bottom.jsp"/>
<script charset="utf-8" src="${pageContext.request.contextPath}/scripts/common/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/scripts/common/kindeditor/lang/zh_CN.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/publish.js"></script>


</body>
</html>