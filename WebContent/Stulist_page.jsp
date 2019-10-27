<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息列表</title>
</head>

<script type="text/javascript">

	function doDelete(sid) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			//window.location.href="DeleteServlet?sid="+sid;
			location.href="DeleteStuServlet?sid="+sid;
		}
	}
</script>

<body>
<form action="SearchStudnetServlet" method="post">
<table border="1" width="700px">
	<tr> <td colspan="8">
	按姓名查询：<input type="text" name="sname" >&nbsp;
按性别查询： <select name="gender">
	<option value="">--请选择--</option>
	<option value="男">男</option>
	<option value="女">女</option>
	</select>
	&nbsp;&nbsp;
	<input type="submit" value="查询">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="addStudent.jsp">添加</a></td> </tr>
	
  <tr align="center">
	<td>序号</td>
	<td>学号</td>
	<td>姓名</td>
	<td>年龄</td>
	<td>性别</td>
	<td>所在班级</td>
	<td>出生日期</td>
	
	<td>操作</td>
  </tr>
 <c:forEach items="${pageBean.list}" var="student">
  <tr align="center">
	<td>${student.sid }</td>
	<td>${student.sno }</td>
	<td>${student.sname }</td>
	<td>${student.age }</td>
	<td>${student.gender }</td>
	<td>${student.class_id }</td>
	<td>${student.birthday }</td>
	<td><a href="EditStuServlet?sid=${student.sid }">更新</a> <a href="#" onclick="doDelete(${student.sid})">删除</a></td>
  </tr>
  </c:forEach>
<tr> 
	<td colspan="8">
	第${pageBean.currentPage} /${pageBean.totalPage}&nbsp;&nbsp;
	每页显示${pageBean.pageSize}条 &nbsp;&nbsp;
	总记录${pageBean.totalSize}条 &nbsp;&nbsp;
	<c:if test="${ pageBean.currentPage !=1}">
		<a href="StudentListPageServlet?currentPage=1">首页</a> |
		<a href="StudentListPageServlet?currentPage=${pageBean.currentPage-1}">上一页</a>
	</c:if>
	<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
	<c:if test="${pageBean.currentPage==i }">${i }</c:if>
	<c:if test="${pageBean.currentPage!=i }">
	<a href="StudentListPageServlet?currentPage=${i}">${i }</a>
	</c:if>
	
	</c:forEach>
		<c:if test="${ pageBean.currentPage !=pageBean.totalPage}">
		 <a href="StudentListPageServlet?currentPage=${pageBean.currentPage+1}">下一页</a>|
		  <a href="StudentListPageServlet?currentPage=${pageBean.totalPage}">尾页</a>
	</c:if>
	</td>
</tr>
  </table>
  </form>
</body>
</html>