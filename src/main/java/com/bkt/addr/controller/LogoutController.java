package com.bkt.addr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logOut.htm")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:ViewLogin.htm";
	}

}
