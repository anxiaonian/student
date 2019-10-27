package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * ģ����ѯѧ����Ϣ
 * Servlet implementation class SearchStudnetServlet
 */
@WebServlet("/SearchStudnetServlet")
public class SearchStudnetServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			try {
				//���ձ�����
				String name=request.getParameter("sname");
				String gender=request.getParameter("gender");
				//System.out.println(name);
				//ģ����ѯ
				StudentService service=new StudentServiceImpl();
				List<Student> list =service.searchStudent(name, gender);
				
				//��������
				request.setAttribute("list", list);
				//ҳ��ת��
				request.getRequestDispatcher("Stulist.jsp").forward(request, response);
			} catch (SQLException e) {
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
