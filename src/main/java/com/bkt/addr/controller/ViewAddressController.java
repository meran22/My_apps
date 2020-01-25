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
import org.springframework.web.bind.annotation.RequestMethod;

import com.bkt.addr.bo.AddressBo;
import com.bkt.addr.dto.CountryDto;
import com.bkt.addr.forms.SearchForm;
import com.bkt.addr.service.AddressBookService;

@Controller
public class ViewAddressController {

	@Autowired
	AddressBookService bookService;

	@ModelAttribute("countriesList")
	public List<CountryDto> populateCountries(HttpServletRequest request) {

		return bookService.getCountries();
	}

	@RequestMapping(value = "/viewAddress.htm", method = RequestMethod.GET)
	public String viewAddresses(Model model) {
		model.addAttribute("searchForm", new SearchForm());
		return "viewAddresses";
	}

	@PostMapping(value = "viewAddresses.htm")
	public void searchAddress(
			@ModelAttribute("searchForm") SearchForm searchForm,
			BindingResult result, Model model, HttpSession httpSession) {

		String localLoggedInUser = (String) httpSession
				.getAttribute("loggedInUser");
		searchForm.setLoggedInUser(localLoggedInUser);
		List<AddressBo> addrBo = bookService.searchAddresses(searchForm);
		model.addAttribute("addrList", addrBo);

	}
}
