package com.bkt.addr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkt.addr.dto.UserDto;
import com.bkt.addr.service.AddressBookService;

@Controller
public class UserInfoController {

	@Autowired
	AddressBookService bookService;

	@RequestMapping(value="/viewUserInfo.htm")
	public String viewUserInfo(HttpSession httpSession, Model model) {

		String loginId = null;
		UserDto userDto = null;

		loginId = (String) httpSession.getAttribute("loggedInUser");
		userDto = bookService.getUserInfo(loginId);
		model.addAttribute("user", userDto);

		return "home";
	}

}
