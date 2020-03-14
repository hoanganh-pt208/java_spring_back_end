package com.hoanganh.service;

import java.util.List;

import com.hoanganh.model.User;

public interface UserService {
	
	/**
	 * Method get List User
	 */
	public List<User> getListUser();
	
	/**
	 * Method check user login
	 */
	public boolean check_login(String username, String password);
}
