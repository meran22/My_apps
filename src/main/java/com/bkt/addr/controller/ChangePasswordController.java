package com.bkt.addr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkt.addr.dto.UserDto;
import com.bkt.addr.forms.ChangePassWordForm;
import com.bkt.addr.service.AddressBookService;
import com.bkt.addr.validator.ChangePasswordFormValidator;

@Controller
public class ChangePasswordController {

	@Autowired
	AddressBookService bookService;

	@Autowired
	ChangePasswordFormValidator formValidator;

	@RequestMapping(value = "/viewChangePassword.htm")
	public String viewChangePassword(Model model) {

		model.addAttribute("changePassord", new ChangePassWordForm());

		return "changePassord";
	}

	@PostMapping(value = "/changePassword.htm")
	public String changePasswordSubmit(
			@ModelAttribute("changePassord") ChangePassWordForm form,
			BindingResult result, Model model, HttpSession httpSession) {

		String loggedInUser = null;
		UserDto userDto = null;

		formValidator.validate(form, result);

		if (result.hasFieldErrors()) {
			return "changePassord";
		}

		if (form.getOldPassword().equals(form.getNewPassword())) {
			result.reject("errorcode",
					"Old password and New password must be different.");
		}

		if (result.hasErrors()) {
			return "changePassord";
		}

		if (!form.getNewPassword().equals(form.getConfirmPassword())) {
			result.reject("errorcode",
					"New password and Confirm password must be same.");
		}

		if (result.hasErrors()) {
			return "changePassord";
		}

		loggedInUser = (String) httpSession.getAttribute("loggedInUser");
		userDto = bookService.getUserInfo(loggedInUser);

		if (!userDto.getPassowrd().equals(form.getOldPassword())) {
			result.reject("errorcode", "Invalid old password.");
		}

		if (result.hasErrors()) {
			return "changePassord";
		}

		int cout = bookService.updatePassword(loggedInUser,
				form.getConfirmPassword());

		if (cout > 0) {
			model.addAttribute("status", "Password updated sucussfully.");
			model.addAttribute("changePassord", new ChangePassWordForm());
		} else {
			model.addAttribute("status",
					"Something going wrong password not updated sucussfully.");
		}

		return "changePassord";
	}

}
