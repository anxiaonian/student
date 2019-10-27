package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Student;
import com.service.StudentService;
import com.service.Impl.StudentServiceImpl;

/**
 * 处理添加学生请求
 */
@WebServlet("/AddStuServlet")
public class AddStuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		try {
			//获取客户端数据
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String class_id = request.getParameter("class_id");
			String birthday = request.getParameter("birthday");
			//System.out.println(sno+sname+age+gender+class_id+birthday);
			//日期格式转换String--->date
			Date date =new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			//送入学生对象
			Student student =new Student(sno, sname,  age,  gender, class_id, date);
			
			//添加到数据库
			StudentService service =new StudentServiceImpl();
			service.insert(student);
			//跳转页面
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
