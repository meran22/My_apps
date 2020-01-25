package com.bkt.addr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bkt.addr.dto.UserDto;
import com.bkt.addr.forms.LoginForm;
import com.bkt.addr.service.AddressBookService;
import com.bkt.addr.validator.LoginFormValidator;

@Controller
public class LoginController {

	@Autowired
	AddressBookService bookService;

	@Autowired
	LoginFormValidator formValidator;

	@RequestMapping(value = "/ViewLogin.htm", method = RequestMethod.GET)
	public String viewLoginPage(Model model) 
	{
		model.addAttribute("login", new LoginForm());
		return "login";
	}

	@PostMapping(value="/loginSubmit.htm")
	public String loginSubmit(@ModelAttribute("login") LoginForm loginForm,
			BindingResult result, Model model, HttpSession session) {

		UserDto userDto = null;

		formValidator.validate(loginForm, result);

		if (result.hasErrors()) {
			return "login";
		}

		userDto = bookService.validateUser(loginForm);

		if (userDto == null) {
			model.addAttribute("login", new LoginForm());
			model.addAttribute("userMessage", "Invalid user/password.");

			return "login";
		}

		session.setAttribute("loggedInUser", loginForm.getLoginId());
		model.addAttribute("user", userDto);

		return "home";
	}

}
