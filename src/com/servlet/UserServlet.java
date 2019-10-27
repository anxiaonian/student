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
 * �������Ա��¼ҵ��
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
			//��ȡ�û�����
			String username =request.getParameter("username");
			String password=request.getParameter("password");
			String autologin=request.getParameter("auto_login");//checkbox ѡ�з���  on��δѡ�з���  null
			System.out.println(username+" "+password);
			
		
			 //�ж��û����Ƿ�Ϊ��
			 if(username==null||username.length()==0){
		            out.println("<script language='javascript'>alert('�û�������Ϊ�գ�');</script>");
		            out.println("<script language='javascript'>window.location.href='login.jsp';</script>");
		            out.flush();
	                  out.close();
	                  return;//��ִ������Ĵ���
			 		}
			//��װBean
			Admin admin=new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			//�������ݿ�
			UserDao dao =new UserDaoImpl();
			Admin user = dao.checkedCount(admin);
			
			//�û�����
			if (user != null) {
				if ("on".equals(autologin)) {
					
					// ��������Ϊauto_login��cookie������cookie���ͻ���	
					Cookie cookie = new Cookie("auto_login", username + "#" + password);
					cookie.setMaxAge(5*60);// 5���ӣ�һ����Ч��7��7*24*60*60
					cookie.setPath("/student01");// ��ǰ��Ŀ��Ч��cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
				}
					// ��¼�ɹ�������session,�������
				request.getSession().setAttribute("user", user);
				response.sendRedirect("index.jsp");
			} else {
				//�û���������
			  out.println("<script language='javascript'>alert('�û������������');</script>");
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
