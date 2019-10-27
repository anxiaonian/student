package com.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dao.UserDao;
import com.entity.Admin;
import com.util.DBUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public Admin checkedCount(Admin admin) throws Exception {
		QueryRunner runner =new QueryRunner(DBUtils.getDataSource());
		//��ѯ�Ƿ��и��û������
		return  runner.query("select * from admin where username= ? and password = ?",
				new BeanHandler<Admin>(Admin.class),admin.getUsername(),admin.getPassword());
	}


}
