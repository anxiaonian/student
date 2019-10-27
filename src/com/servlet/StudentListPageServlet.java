package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.PageBean;
import com.service.StudentService;
import com.service.Impl.StudentServiceImpl;

/**
 * 分页显示学生列表
 * Servlet implementation class StudentListPageServlet
 */
@WebServlet("/StudentListPageServlet")
public class StudentListPageServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			//显示当前页码数
			int currentPage=Integer.parseInt(request.getParameter("currentPage"));
			//根据页数，查出该页的数据
			StudentService service= new StudentServiceImpl();
			PageBean pageBean = service.FindStudentByPage(currentPage);
			//保存数据
			request.setAttribute("pageBean", pageBean);
			//跳转Stulist.jsp
			request.getRequestDispatcher("Stulist_page.jsp").forward(request, response);
			
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
