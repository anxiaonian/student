package com.service.Impl;
import java.sql.SQLException;
import java.util.List;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.entity.PageBean;
import com.entity.Student;
import com.service.StudentService;
/**
 * 学生业务逻辑实现
 * @author ASUS
 *
 */
public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> findAll() throws SQLException {
		
			StudentDao Dao = new StudentDaoImpl();
			return Dao.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {
			StudentDao dao = new StudentDaoImpl();
			dao.insert(student);
	}

	@Override
	public void delete(int id) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(id);
	}

	@Override
	public void update(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.update(student);
		
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	@Override
	public List<Student> searchStudent(String name, String gender) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.searchStudent(name, gender);
	}

	@Override
	public PageBean FindStudentByPage(int currentPage) throws SQLException {
		//封装PageBean 
		PageBean<Student> pageBean =new PageBean<Student>();
		
		pageBean.setCurrentPage(currentPage);//设置当前页
		
		int pageSize=StudentDao.PAGE_SIZE;
		
		pageBean.setPageSize(pageSize);//设置每一页显示学生记录数
		
		StudentDao dao = new StudentDaoImpl();
		int count= dao.findCount();
		List<Student> list= dao.FindStudentByPage(currentPage);
		//设置总页数
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1);
		pageBean.setTotalSize(count);//设置总记录数
		pageBean.setList(list);//设置这一页显示多少学生记录
		return pageBean;
	}

}
