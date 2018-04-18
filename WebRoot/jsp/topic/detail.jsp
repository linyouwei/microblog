<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.uclbrt.entity.*" %>
<%@ page language="java" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
 	<jsp:include page="../common/head.jsp"/>
 	<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/detail.css" />
</head>

<body>
<%@ include file="../common/top.jsp" %>
<div class="am-g am-g-fixed blog-g-fixed">
    <div class="am-u-md-8">
        <article class="blog-main">
            <h3 class="am-article-title blog-title">
                <a href="#">${daily.title }</a>
            </h3>
            <h4 class="am-article-meta blog-meta">by <a href="">${daily.userInfo.userName }</a> post
                on ${daily.createdTime } </h4>
            <div class="am-g blog-content">
                <div class="am-u-lg-7">
                </div>
                <p>${ daily.body }</p>
            </div>
            <div class="am-g">
                <div class="am-u-sm-12">
                </div>
            </div>
        </article>
        <hr class="am-article-divider blog-hr">
        <hr class="am-article-divider blog-hr">
        <ul class="am-pagination blog-pagination">
            <li class="am-pagination-prev"><a href="/myblog/daily/?dailyid={{ daily.id | add:-1}}">&laquo; 上一页</a></li>
            <li class="am-pagination-next"><a href="/myblog/daily/?dailyid={{ daily.id | add:1}}">下一页 &raquo;</a></li>
        </ul>
    </div>
</div>
<c:choose>
	<c:when test="<%=loginFlag%>">
	<div class="am-g am-g-fixed blog-g-fixed">
    <div class="am-u-md-8">
        <form class="am-form">
            <fieldset>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">姓名</label>
                    <input type="text" disabled value="<%=user.getUserName() %>">
                </div>
                <div class="am-form-group">
                    <label for="doc-ta-1">评论</label>
                    <textarea class="text" rows="5" id="comment-content" value=""></textarea>
                    <input type="hidden" value="${daily.id}" name='dailyId' id="dailyId">
                </div>
                <input type="button" class="am-btn am-btn-primary" id="btn-submit" value="发表">
            </fieldset>
        </form>
    </div>
</div>
	</c:when>
	<c:otherwise>
		<div class="am-g am-g-fixed blog-g-fixed">
	    <div class="am-u-md-8">
	       	 注册用户登录后才能发表评论，请
		        <a href="/myblog/login">登录</a>
		        <a href="/myblog/register">注册</a>
		        <a href="/myblog/index">访问</a>网站首页
	    </div>
		</div>
	</c:otherwise>
</c:choose>

<% 
       List<Comment> commentList = (List<Comment>)request.getAttribute("commentList");
       boolean commentFlag;
       if(commentList==null || commentList.size()==0) commentFlag = false;
       else commentFlag = true;
%>
<%--评论列表 --%>
<div class="am-g am-g-fixed blog-g-fixed">
    <div class="am-u-md-8">
        <ul class="am-comments-list" id="ul-list">
			<c:choose>
				<c:when test="<%=commentFlag%>">
					<c:forEach items="${requestScope.commentList}" var="u">
			 			<li class="am-comment">
			                <article class="am-comment"> <!-- 评论容器 -->
			                    <a href="">
			                        <img class="am-comment-avatar"
			                             src="http://www.gravatar.com/avatar/1ecedeede84abbf371b9d8d656bb4265?d=mm&s=96"
			                             alt=""/>
			                        <!-- 评论者头像 -->
			                    </a>
			                    <div class="am-comment-main"> <!-- 评论内容容器 -->
			                        <header class="am-comment-hd">
			                            <!--<h3 class="am-comment-title">评论标题</h3>-->
			                            <div class="am-comment-meta"> <!-- 评论元数据 -->
			                                <a href="#link-to-user" class="am-comment-author">${u.userInfo.userName }</a>
			                                <!-- 评论者 -->
			                                		评论于
			                                <time datetime="">${u.createdTime }</time>
			                            </div>
			                        </header>
			                        <div class="am-comment-bd">${u.content }</div> <!-- 评论内容 -->
			                    </div>
			                </article>
			            </li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<p>暂无评论</p>
				</c:otherwise>
			</c:choose>
        </ul>
    </div>
</div>


<div id="comment-template">
<li class="am-comment">
                <article class="am-comment"> <!-- 评论容器 -->
                    <a href="">
                        <img class="am-comment-avatar"
                             src="http://www.gravatar.com/avatar/1ecedeede84abbf371b9d8d656bb4265?d=mm&s=96"
                             alt=""/>
                        <!-- 评论者头像 -->
                    </a>
                    <div class="am-comment-main"> <!-- 评论内容容器 -->
                        <header class="am-comment-hd">
                            <!--<h3 class="am-comment-title">评论标题</h3>-->
                            <div class="am-comment-meta"> <!-- 评论元数据 -->
                                <a href="#link-to-user" class="am-comment-author">{{ comment.name }}</a>
                                <!-- 评论者 -->
                                评论于
                                <time datetime="">{{ comment.create_time|date:"Y-m-d H:i:s" }}</time>
                            </div>
                        </header>
                        <div class="am-comment-bd">{{ comment.content }}</div> <!-- 评论内容 -->
                    </div>
                </article>
            </li>
    </div>
<script>
    $(function () {
        $("#comment-template").hide();
        $("#btn-submit").click(function () {
            $.post('/myblog/comment/', {
                    'dailyid': $("#dailyid").val(),
                    'content': $("#comment-content").val()
                }, function (data) {
//                console.log(data);
                   setCommentList(data);
                }
            )
        })
        function setCommentList(data) {
            var row = $($("#comment-template").clone().html());
             row.find("header div a").text(data.user_name);
            row.find("header div time").text(data.create_time);
           row.find("div header").siblings().text(data.content)
            row.appendTo("#ul-list");
        }
    })
</script>

</body>
</html>
