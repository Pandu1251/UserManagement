package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import model.User;
import services.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService userservice;

	@GetMapping("/home")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcomepage";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@RequestMapping("/save-user")
	public String saveUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userservice.saveUser(user);
		request.setAttribute("users", userservice.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}

	@GetMapping("/show-users")
	public String listUsers(HttpServletRequest request) {
		request.setAttribute("users", userservice.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}

	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userservice.deleteUser(id);
		request.setAttribute("users", userservice.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";

	}

	@GetMapping("/edit-user")
	public String showEditForm(@RequestParam int id, HttpServletRequest request) {
		User user = userservice.findUserById(id);
		if (user != null) {
			request.setAttribute("user", user);
			request.setAttribute("mode", "MODE_UPDATE");
			return "welcomepage";
		} else {
			// Handle case where user with given ID is not found
			return "error-page"; // Create an error page or handle accordingly
		}
	}

	@RequestMapping("/edit-user")
	public String updateUser(@ModelAttribute User user, HttpServletRequest request) {
		userservice.updateUser(user);
		request.setAttribute("users", userservice.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "redirect:show-users";
	}

	@RequestMapping("/login")
	public String loginhome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}

	@RequestMapping("/login-user")
	public String loginuser(@ModelAttribute User user, HttpServletRequest request) {

		if (userservice.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			return "homepage";

		} else {

			request.setAttribute("error", "invalid username or password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}

}
