

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.uclbrt.entity.*" %>
<%@ page language="java" import="java.util.*"%>

<!doctype html>
<html>
<head>
 	<jsp:include page="../common/head.jsp"/>
</head>
<body id="blog">
 	<%@ include file="../common/top.jsp" %>
 	<div class="am-g am-g-fixed" id="dataListDiv">
    <div class="am-u-md-9 am-u-sm-12" id="myDailyList">
    <% 
        String path = request.getContextPath(); 
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
        String name = request.getParameter("name");//用request得到 
        System.out.println(name);
%> 
        <c:forEach items="${requestScope.dailyList}" var="u">
        <div class="am-u-lg-12 am-u-md-12 am-u-sm-12 ">
            <h1><a href="<%=request.getContextPath()%>/homePage/dailyDetail.form?dailyId=${u.id }">${u.title }</a>
            </h1>
            <p>${u.body}</p>
            <p>${u.userInfo.userName} 发布于 ${u.createdTime}</p>
        </div>
        </c:forEach>
    </div>
    <div class="am-u-md-3 am-u-sm-12">
        <div class="am-g am-g-fixed">
            <h3 class="">最新文章</h3>
            <ul>
            	<% 
            	List<Daily> list = (List<Daily>)request.getAttribute("recentDailyList");
            	boolean dailyflag;
            	if(list==null || list.size()==0) dailyflag = false;
            	else dailyflag = true;

            	%>
            	<c:choose>
            	<c:when test="<%=dailyflag%>">
	                <c:forEach items="${requestScope.recentDailyList}" var="u">
	                <li>
	                    <a href="">${u.title }</a>
	                </li>
	                </c:forEach>        
                </c:when>
                <c:otherwise>
               		 <p>暂无文章！</p>
                </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <div class="am-g am-g-fixed">
            <h3 class="">归档</h3>
            <ul>
            <% 
            	List<Map> archivesList = (List<Map>)request.getAttribute("archivesList");
            	boolean archivesflag;
            	if(archivesList==null ||archivesList.size()==0) archivesflag = false;
            	else archivesflag = true;
            	%>
            <c:choose>
            	<c:when test="<%=archivesflag%>">
	                <c:forEach items="${requestScope.archivesList}" var="u">
	                <li>
                    <a href="{% url 'myblog:archives' daily.year daily.month %}">${u["created_time"] }</a> <span style="color:#0e90d2">${u["count"] }篇</span>
               		 </li>
	                </c:forEach>        
                </c:when>
                <c:otherwise>
               		 <p>暂无归档！</p>
                </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <div class="am-g am-g-fixed">
            <h3 class="">分类</h3>
           
            <ul>
           
            <c:choose>
             <%--  若没登录，显示系统的分类 --%>
            	<c:when test="<%=!loginFlag%>">
            	<% 
	            	List<Map> categoryList = (List<Map>)request.getAttribute("categoryList");
	            	boolean categoryflag;
	            	if(categoryList==null||categoryList.size()==0) categoryflag = false;
	            	else categoryflag = true;	
            	%>
	            	<c:choose>
			            	<c:when test="<%=categoryflag%>">
				                <c:forEach items="${requestScope.categoryList}" var="u">
					                 <li>
				                   		 <a href="">${u["category_name"] }</a>
				                	</li>
				                </c:forEach>        
			                </c:when>
			                <c:otherwise>
			               		 <p> 暂无分类！</p>
			                </c:otherwise>
	             	</c:choose>
            	</c:when>
            	 <%-- 登录则显示个人分类--%>
            	<c:otherwise>
		            <% 
			            List<Map> userCategoryList = (List<Map>)request.getAttribute("userCategoryList");
			            boolean usercategoryflag;
			            if(userCategoryList==null||userCategoryList.size()==0) usercategoryflag = false;
		            	else usercategoryflag = true;
		            %>
	           		<c:choose>
		            	<c:when test="<%=usercategoryflag%>">
			                <c:forEach items="${requestScope.userCategoryList}" var="u">
				                 <li>
			                   		 <a href="{% url 'myblog:category' category.id %}">${u["category_name"] }</a>
			                	</li>
			                </c:forEach>        
		                </c:when>
		                <c:otherwise>
		               		 <p>  暂无分类！</p>
		                </c:otherwise>
             		</c:choose>
            	</c:otherwise>
            </c:choose>
            
            </ul>
        </div>
    </div>
</div>
<div class="am-g am-g-fixed blog-fixed" id="search">
    <div class="am-u-md-8 am-u-sm-12" id="search_data">
    </div>
</div>


<script type="text/html" id="js_template">
    <div class="am-u-lg-12 am-u-md-12 am-u-sm-12 blog-entry-text blog-text-center" id="div_search">
        <h1><a href=""> </a></h1>
        <p></p>
        <p></p>
    </div>
</script>

<jsp:include page="../common/footer.jsp"/>
<jsp:include page="../common/bottom.jsp"/>


 </body>
</html>