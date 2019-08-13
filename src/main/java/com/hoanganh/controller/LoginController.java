package com.hoanganh.controller;

import com.hoanganh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@Autowired
    private UserService userService;
	
	/*
	 * Method login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestParam("user_name") String user_name,@RequestParam("password") String password) {
		boolean result = userService.check_login(user_name, password);
		if (result) {
			return ResponseEntity.ok().body("{\"Code\" : \"200\", \"Message\" : \"Success\"}");
		} else {
			return ResponseEntity.ok().body("{\"Code\" : \"400\", \"Message\" : \"Fail\"}");
		}
	}
}
