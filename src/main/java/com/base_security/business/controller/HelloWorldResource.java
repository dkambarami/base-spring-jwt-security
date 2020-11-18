package com.base_security.business.controller;

import com.base_security.business.model.User;
import com.base_security.business.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping
public class HelloWorldResource {

	@Autowired
	private UserService userService;

	@GetMapping("/profile/hello")
	public String firstPage() {
		return "Hello World";
	}

	@PostMapping("/profile/create")
	public void createUser(@RequestBody User user) {

		this.userService.createOneUser(user);
	}


	@PutMapping("/profile/update")
	public void updateUser(@RequestBody User user) {
		this.userService.updateUser(user.getUsername(), user);
	}

}
