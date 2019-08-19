package com.hoanganh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.model.User;
import com.hoanganh.response.ResponseModel;
import com.hoanganh.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private UserService userService;
	
	/**
	 * Method get List User
	 */
	@RequestMapping(value = "/getListUser", method = RequestMethod.GET)
	public ResponseModel getListUser() {
		List<User> list = null;
		ResponseModel responseModel = new ResponseModel();
		try {
			list = userService.getListUser();
			responseModel.setData(list);
			responseModel.setStatus("success");
			return responseModel;
		} catch (Exception e) {
			e.printStackTrace();
			responseModel.setStatus("fail");
			return responseModel;
		}
	}
}
