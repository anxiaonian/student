<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生页面</title>
</head>
<body>
<h3>添加学生页面</h3>
<form method="post" action="AddStuServlet">
<table border="1" width="500">
 <tr>
	<td>学号</td>
	<td><input type="text" name="sno"></td>
 </tr>
 <tr>
	<td>姓名</td>
	<td><input type="text" name="sname"></td>
 </tr>
 <tr>
	<td>年龄</td>
	<td><input type="text" name="age"></td>
 </tr>
 <tr>
	<td>性别</td>
	<td><input type="radio" name="gender" value="男">男 
	<input type="radio" name="gender" value="女">女</td>
 </tr>
 <tr>
	<td>所在班级</td>
	<td><input type="text" name="class_id" value=""></td>
 </tr>
 <tr>
	<td>出生日期</td>
	<td><input type="text" name="birthday" value=""></td>
 </tr>
 <tr>
	<td colspan="2"><input type="submit" value="添加"> <input type="reset"></td>
 </tr>
 </table>
</form>
	
</body>
</html>