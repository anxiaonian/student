package com.service.Impl;
import java.sql.SQLException;
import java.util.List;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.entity.PageBean;
import com.entity.Student;
import com.service.StudentService;
/**
 * ѧ��ҵ���߼�ʵ��
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
		//��װPageBean 
		PageBean<Student> pageBean =new PageBean<Student>();
		
		pageBean.setCurrentPage(currentPage);//���õ�ǰҳ
		
		int pageSize=StudentDao.PAGE_SIZE;
		
		pageBean.setPageSize(pageSize);//����ÿһҳ��ʾѧ����¼��
		
		StudentDao dao = new StudentDaoImpl();
		int count= dao.findCount();
		List<Student> list= dao.FindStudentByPage(currentPage);
		//������ҳ��
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1);
		pageBean.setTotalSize(count);//�����ܼ�¼��
		pageBean.setList(list);//������һҳ��ʾ����ѧ����¼
		return pageBean;
	}

}
