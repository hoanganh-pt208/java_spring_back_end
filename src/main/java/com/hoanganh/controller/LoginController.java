package com.hoanganh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.response.ResponseModel;
import com.hoanganh.service.UserService;

@RestController
public class LoginController {
	@Autowired
    private UserService userService;
	
	/**
	 * Method login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseModel login(@RequestParam("username") String username,@RequestParam("password") String password) {
		System.out.println("User Name : "+username);
		boolean result = userService.check_login(username, password);
		ResponseModel responseModel = new ResponseModel();
		try {
			if (result) {
				responseModel.setStatus("success");
				return responseModel;
			} else {
				responseModel.setStatus("fail");
				return responseModel;
			}
		} catch (Exception e) {
			// TODO: handle exception
			responseModel.setStatus("fail");
			return responseModel;
		}
		
	}
}
