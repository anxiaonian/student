package com.dao;

import com.entity.Admin;

public interface UserDao {
	/**
	 * 判断是否有该用户
	 * @return
	 * @throws Exception
	 */
	
		Admin checkedCount(Admin admin)throws Exception;
}
