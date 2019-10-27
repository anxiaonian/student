<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--  <jsp:useBean id="Admin" class="com.entity.Admin" scope="page"/>
    <jsp:setProperty name="Admin" property="*"/> --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<c:if test="${not empty user}">
尊敬的【${user.username}】,欢迎您！
<center>
<h3><a href="StudentListServlet">查询所有学生列表</a></h3><br>
<h3><a href="StudentListPageServlet?currentPage=1">分页显示学生</a></h3>
</center>
</c:if>
<c:if test="${ empty user}">
您好，请先<a href="login.jsp">登录</a>...
</c:if>

<%-- 尊敬的【${Admin.username}】,欢迎您！ --%>

</body>
</html>