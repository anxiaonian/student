<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录界面</title>

<!-- 导入JQuery的支持 -->
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
function checkUserName(){
	 var username = document.getElementById("username").value;
	 if(username == ""){
	 	//alert("请输入用户名！");
	 }
	 
	//1. 获取输入框的内容
		var username = $("#username").val();
		var password = $("#password").val();
		//2. 发送请求
		$.post("/student01/UserServlet" , {username:username,password:password} , function(data , status){
				alert("用户名或密码错误！");	
		} );
}
</script>
</head>
<body>
 <center>
 	<form action="UserServlet" method="post">
			<table border="1">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username" id="username"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" id="password"></td>
				</tr>
				<tr>
				<td colspan="2">
				<input type="checkbox" name="auto_login">记住我的登录状态
				</td>
				</tr>
				<tr>
				<td colspan="2" align="center">
				<input type="submit" name="submit" value="登录"  >
				<input type="reset" name="reset" value="重置" ></td>
				</tr>
			</table>
			</form>
	</center>
</body>
</html>