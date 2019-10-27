package com.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Student;
import com.service.StudentService;
import com.service.Impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentListServlet
 */
//@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		try {
			//查出所有学生
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.findAll();
			
			//2. 先把数据存储到作用域中
			request.setAttribute("list", list);
			//跳转jsp页面显示
			request.getRequestDispatcher("Stulist.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
