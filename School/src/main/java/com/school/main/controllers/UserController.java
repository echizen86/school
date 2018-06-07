package com.school.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.main.domain.User;
import com.school.main.service.SecurityService;
import com.school.main.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

//	@Autowired
//	private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public User registration(@RequestBody User userForm) {
//		public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
//		userValidator.validate(userForm, bindingResult);

//		if (bindingResult.hasErrors()) {
//			return "registration";
//		}

//		userService.save(userForm);

//		securityService.autologin(userForm.getUserName(), userForm.getConfirmPassword());

//		return "redirect:/welcome";
		
		if(userForm.getPassword().equals(userForm.getConfirmPassword())) {
			return userService.save(userForm);
		}
		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}
}
