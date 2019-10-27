package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.entity.Student;

public interface StudentDao {
	int PAGE_SIZE=5;
	/**
	 * ��ѯ����ѧ��
	 * @return
	 * @throws SQLException
	 */
	List<Student> findAll()  throws SQLException ;
	/**
	 * ���һ��ѧ��
	 * @param student
	 * @throws SQLException
	 */
	void insert(Student student)throws SQLException ;
	
	/**
	 * ɾ��һ��ѧ��
	 * @param id
	 * @throws SQLException
	 */
	void delete(int sid) throws SQLException ;
	/**
	 * ����һ��ѧ��
	 * @param student
	 * @throws SQLException
	 */
	void update (Student student )throws SQLException ;
	/**
	 * ��ID��ѯһ��ѧ��
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	Student findStudentById(int sid)throws SQLException ;

	/**
	 * ������������������ģ����ѯ
	 * @param name
	 * @param gender
	 * @return
	 * @throws SQLException
	 */
	List<Student> searchStudent(String name ,String gender) throws SQLException ;
	/**
	 * ��ҳ��ѯ
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<Student> FindStudentByPage(int currentPage)throws SQLException ;
	
	int findCount()throws SQLException ;
}
