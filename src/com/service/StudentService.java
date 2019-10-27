package com.service;

import java.sql.SQLException;
import java.util.List;

import com.entity.PageBean;
import com.entity.Student;
/**
 * 学生业务处理规范
 * @author ASUS
 *
 */
public interface StudentService {
	/**
	 * 查询所有学生
	 * @return
	 * @throws SQLException
	 */
	List<Student> findAll()  throws SQLException ;
	/**
	 * 添加一个学生
	 * @param student
	 * @throws SQLException
	 */
	void insert(Student student)throws SQLException ;
	/**
	 * 删除一个学生
	 * @param id
	 * @throws SQLException
	 */
	void delete(int id) throws SQLException ;
	/**
	 * 更新一个学生
	 * @param student
	 * @throws SQLException
	 */
	void update (Student student )throws SQLException ;
	/**
	 * 按ID查询一个学生
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	Student findStudentById(int sid)throws SQLException ;
	/**
	 * 根据姓名或者年龄做模糊查询
	 * @param name
	 * @param gender
	 * @return
	 * @throws SQLException
	 */
	List<Student> searchStudent(String name ,String gender) throws SQLException ;
	/**
	 * 分页查询
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	PageBean FindStudentByPage(int currentPage)throws SQLException ;
}

