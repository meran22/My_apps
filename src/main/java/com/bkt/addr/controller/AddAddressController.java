package com.bkt.addr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkt.addr.dto.CountryDto;
import com.bkt.addr.forms.AddAddressForm;
import com.bkt.addr.service.AddressBookService;
import com.bkt.addr.validator.AddressFormValidator;

@Controller
public class AddAddressController {

	@Autowired
	AddressFormValidator addressFormValidator;

	@Autowired
	AddressBookService bookService;

	@RequestMapping(value = "viewAddAddrForm.htm")
	public String viewAddAddresForm(Model model) {

		model.addAttribute("addForm", new AddAddressForm());

		return "addAddress";
	}

	@ModelAttribute("countriesList")
	public List<CountryDto> populateCountries(HttpServletRequest request) {

		return bookService.getCountries();
	}

	@PostMapping(value="/addAddr.htm")
	public String addAddress(
			@ModelAttribute("addForm") AddAddressForm addressForm,
			BindingResult result, Model model, HttpSession httpSession) {

		String loginUser = null;

		addressFormValidator.validate(addressForm, result);

		if (result.hasErrors()) {
			return "addAddress";
		}

		loginUser = (String) httpSession.getAttribute("loggedInUser");
		addressForm.setLogin(loginUser);

		int seq = bookService.addAddress(addressForm);

		if (seq > 0) {
			model.addAttribute("addForm", new AddAddressForm());
			model.addAttribute("status", "Address added sucessfully.");
		}

		return "addAddress";
	}

}
