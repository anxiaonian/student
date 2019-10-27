package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.StudentService;
import com.service.Impl.StudentServiceImpl;

/**
 * ����ɾ��ѧ��ҵ������
 */
@WebServlet("/DeleteStuServlet")
public class DeleteStuServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		try {
			//��ȡid
			int sid =Integer.parseInt(request.getParameter("sid"));
			//ɾ��
			StudentService service =new StudentServiceImpl();
			service.delete(sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//��תҳ��
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
