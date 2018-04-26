<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <jsp:include page="../common/head.jsp"/>
</head>

<body>
<div style="width:600px;margin-left:auto;margin-right:auto;margin-top: 10%">
    <div class="text-center title">222</div>
    <div class="text-center status-box">
        <i class="icon-success-font c-green"></i>文章发布成功
    </div>
    <p class="text-center zhaiyao">文章摘要由系统生成</p>
    <div class="opt-box text-center">
        <a href="{% url 'myblog:publishEdit' %}">写新文章</a>
        <a  href="{% url 'myblog:publish' %}">管理博文</a>
        <a href="{% url 'myblog:sign_up' %}">查看文章</a>
    </div>
</div>
<jsp:include page="../common/bottom.jsp"/>
</body>
</html>