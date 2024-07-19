package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import model.User;
import services.UserService;

@RestController
public class RestControllerCls{

	@Autowired
	UserService userservice;

	@GetMapping("/")
	public String hello() {
		return "This is Home Page";
	}

	@GetMapping("/save")
	public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam int age, @RequestParam String password) {
		User user = new User(username, firstname, lastname, age, password);
		userservice.saveUser(user);
		return "User saved successfully";
	}

}
