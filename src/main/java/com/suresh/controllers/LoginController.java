package com.suresh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.bindings.LoginRequest;
import com.suresh.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return service.login(request);
	}
	



}
