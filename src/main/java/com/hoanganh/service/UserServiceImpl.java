package com.hoanganh.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganh.dao.UserDao;
import com.hoanganh.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * Method decode MD5
	 */
	private String pwdMD5(String pwd) {
		return DigestUtils.md5Hex(pwd);
	}

	/**
	 * Method get List User
	 */
	@Transactional
	public List<User> getListUser() {
		return userDao.getListUser();
	}

	/**
	 * Method check user login
	 */
	public boolean check_login(String user_name, String password) {
		// TODO Auto-generated method stub
		User user = this.getUserByUserName(user_name);
		if (user != null) {
			String user_real_password = user.getPassword();
			String user_input_password = this.pwdMD5(password);
			if(user_real_password.equals(user_input_password)) {
				return true;
			}else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Method get User By User Name
	 */
	private User getUserByUserName(String user_name) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserName(user_name);
	}
}
