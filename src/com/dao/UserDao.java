package com.dao;

import com.entity.Admin;

public interface UserDao {
	/**
	 * �ж��Ƿ��и��û�
	 * @return
	 * @throws Exception
	 */
	
		Admin checkedCount(Admin admin)throws Exception;
}
