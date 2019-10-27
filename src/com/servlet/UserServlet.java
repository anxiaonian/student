package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.OnClose;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.Admin;

/**
 * 处理管理员登录业务
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8"); 
	        response.setCharacterEncoding("utf-8");
	   	
	        PrintWriter out = response.getWriter();
		try {
			//获取用户数据
			String username =request.getParameter("username");
			String password=request.getParameter("password");
			String autologin=request.getParameter("auto_login");//checkbox 选中返回  on，未选中返回  null
			System.out.println(username+" "+password);
			
		
			 //判断用户名是否为空
			 if(username==null||username.length()==0){
		            out.println("<script language='javascript'>alert('用户名不能为空！');</script>");
		            out.println("<script language='javascript'>window.location.href='login.jsp';</script>");
		            out.flush();
	                  out.close();
	                  return;//不执行下面的代码
			 		}
			//封装Bean
			Admin admin=new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			//访问数据库
			UserDao dao =new UserDaoImpl();
			Admin user = dao.checkedCount(admin);
			
			//用户存在
			if (user != null) {
				if ("on".equals(autologin)) {
					
					// 创建名字为auto_login的cookie，发送cookie给客户端	
					Cookie cookie = new Cookie("auto_login", username + "#" + password);
					cookie.setMaxAge(5*60);// 5分钟，一般有效期7天7*24*60*60
					cookie.setPath("/student01");// 当前项目有效，cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
				}
					// 登录成功，设置session,进入界面
				request.getSession().setAttribute("user", user);
				response.sendRedirect("index.jsp");
			} else {
				//用户名不存在
			  out.println("<script language='javascript'>alert('用户名或密码错误！');</script>");
	          out.println("<script language='javascript'>window.location.href='login.jsp';</script>");
				//request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
