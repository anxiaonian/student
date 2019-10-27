<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生信息页面</title>
</head>
<body>

<h3>更新学生信息页面</h3>

<form method="post" action="updateStuServlet">

<input type="hidden" name="sid" value="${student.sid }">
<table border="1" width="500">
 <tr>
	<td>学号</td>
	<td><input type="text" name="sno" value="${student.sno }"></td>
 </tr>
 <tr>
	<td>姓名</td>
	<td><input type="text" name="sname" value="${student.sname }"></td>
 </tr>
 <tr>
	<td>年龄</td>
	<td><input type="text" name="age" value="${student.age }"></td>
 </tr>
 <tr>
	<td>性别</td>
	<td>
	<!-- 如果性别是男的，  可以在男的性别 input标签里面， 出现checked ,
		如果性别是男的，  可以在女的性别 input标签里面，出现checked -->
		<input type="radio" name="gender" value="男" <c:if test="${student.gender == '男'}">checked</c:if>>男
		<input type="radio" name="gender" value="女" <c:if test="${student.gender == '女'}">checked</c:if>>女	
	</td>
 </tr>
 <tr>
	<td>所在班级</td>
	<td><input type="text" name="class_id" value="${student.class_id }"></td>
 </tr>
 <tr>
	<td>出生日期</td>
	<td><input type="text" name="birthday" value="${student.birthday }"></td>
 </tr>
 <tr>
	<td colspan="2"><input type="submit" value="更新"></td>
 </tr>
 </table>
</form>
</body>
</html>