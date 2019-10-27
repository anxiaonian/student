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
 * ����һ��ѧ��ҵ������
 */
@WebServlet("/updateStuServlet")
public class updateStuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			try {
				//��ȡ�ͻ�������
				int sid = Integer.parseInt(request.getParameter("sid"));
				
				String sno = request.getParameter("sno");
				String sname = request.getParameter("sname");
				String age = request.getParameter("age");
				String gender = request.getParameter("gender");
				String class_id = request.getParameter("class_id");
				String birthday = request.getParameter("birthday");
				
				//���ڸ�ʽת��String--->date
				Date date =new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
				//����ѧ������
				Student student =new Student(sid,sno, sname,  age,  gender, class_id,date);
				
				//��ӵ����ݿ�
				StudentService service =new StudentServiceImpl();
				service.update(student);
				//��תҳ��
				request.getRequestDispatcher("StudentListServlet").forward(request, response);
				}catch (Exception e) {
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
