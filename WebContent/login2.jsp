<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录界面</title>
</head>
<script type="text/javascript">
	function ajaxFunction() {
		var xmlHttp;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}

		return xmlHttp;
	}

	function checkUserName() {
		//输入框获取数据
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
	
		//创建AJAX对象
		var request = ajaxFunction();
		//2. 发送请求
		request.open("POST"  ,"/student01/UserServlet" , true );

		//注册状态改变监听，获取服务器传送过来的数据
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				//alert(request.responseText);
				var data = request.responseText;
				if (data == 1) {
					location.href = "index.jsp?username="+username;
					alert("登录成功");
				} else {
					alert("用户名或密码错误！");
					location.href = "login.jsp";
				}
			}
		}

		request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//发送数据
		request.send("username=" + username + "&" + "password=" + password );

	}
</script>
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
			<input type="button" name="button" value="登录" onclick="checkUserName()"> 
				<input type="reset" name="reset" value="重置" ></td>
				</tr>
			</table>
			</form>
	</center>
</body>
</html>