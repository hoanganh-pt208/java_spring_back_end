package com.hoanganh.dao;

import java.util.List;

import com.hoanganh.model.User;

public interface UserDao {
	
	/**
	 * Method get List User
	 */
	public List<User> getListUser();
	
	/**
	 * Method get User By User Name
	 */
	public User getUserByUserName(String username);
}
