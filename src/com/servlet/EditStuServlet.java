package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Student;
import com.service.StudentService;
import com.service.Impl.StudentServiceImpl;

/**
 * Servlet implementation class EditStuServlet
 */
@WebServlet("/EditStuServlet")
public class EditStuServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		try {
			//获取选中的ID
			int sid = Integer.parseInt(request.getParameter("sid"));
			//2. 查询学生数据
			StudentService service = new StudentServiceImpl();
			Student student = service.findStudentById(sid);
			//保存
			request.setAttribute("student", student);
			
			System.out.println(student.getGender());
			
			//跳转
			request.getRequestDispatcher("editStudent.jsp").forward(request, response);
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
