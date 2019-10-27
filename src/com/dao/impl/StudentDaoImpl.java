package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.StudentDao;
import com.entity.Student;
import com.util.DBUtils;
import com.util.TextUtils;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
		return runner.query("select * from student", new BeanListHandler<Student>(Student.class));
	}

	@Override
	public void insert(Student student) throws SQLException {
			QueryRunner runner=new QueryRunner(DBUtils.getDataSource());
			runner.update("insert into student values(null,?,?,?,?,?,?)",
					student.getSno(),
					student.getSname(),
					student.getAge(),
					student.getGender(),
					student.getClass_id(),
					student.getBirthday()
					);
	}

	@Override
	public void delete(int sid) throws SQLException {
			QueryRunner runner=new QueryRunner(DBUtils.getDataSource());
			runner .update("delete from student where sid=?", sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
		return runner.query("select * from student where sid=?", new BeanHandler<Student>(Student.class), sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
		runner.update("update student set sno=? ,sname=? , age=?, gender=? ,class_id=?, birthday=? where sid = ?", 
				student.getSno(),
				student.getSname(),
				student.getAge(),
				student.getGender(),
				student.getClass_id(),
				student.getBirthday(),
				student.getSid());
				
	}

	@Override
	public List<Student> searchStudent(String name, String gender) throws SQLException {
		System.out.println(name);
		QueryRunner runner=new QueryRunner(DBUtils.getDataSource());
		
		String sql = "select * from student where 1=1 ";
		List<String>list=new ArrayList<String>();
		//�ж������Ƿ�Ϊ��
		if(!TextUtils.isEmpty(name)) {
			sql=sql +" and sname like ?";
			list.add("%"+name+"%");
		}
		//�ж��Ա��Ƿ�Ϊ��
		if(!TextUtils.isEmpty(gender)) {
			sql=sql +" and gender = ?";
			list.add(gender);
		}
		return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
	}

	@Override
	public List<Student> FindStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner=new QueryRunner(DBUtils.getDataSource());
		//��һ����������ʾһҳ���ض������ݣ��ڶ�������ʾ����ǰ����ټ�¼
		//6,0 ;��һҳ��1-1��*6
		//6,6 ;�ڶ�ҳ��2-1��*6
		//6,12 ;����ҳ��3-1��*6
		return runner.query("select * from student limit ? offset ?",new BeanListHandler<Student>(Student.class),
				PAGE_SIZE,(currentPage-1)*PAGE_SIZE );
		
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner=new QueryRunner(DBUtils.getDataSource());
		//new ScalarHandler(),���ڴ����ѯƽ���������� �Ⱥ���SQL���
		Long count=(Long) runner.query("select count(*) from student ",new ScalarHandler());
		return count.intValue();//���ת��int ����
	}

}
