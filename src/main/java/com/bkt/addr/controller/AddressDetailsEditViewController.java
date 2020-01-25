package com.bkt.addr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkt.addr.bo.AddressBo;
import com.bkt.addr.dto.CountryDto;
import com.bkt.addr.forms.AddAddressForm;
import com.bkt.addr.service.AddressBookService;
import com.bkt.addr.validator.AddressFormValidator;

@Controller
public class AddressDetailsEditViewController {

	@Autowired
	AddressBookService addressBookService;

	@Autowired
	AddressFormValidator formValidator;

	@RequestMapping(value = "/{addSeq}/editAddDetailsForm.htm")
	public String viewEditAddrForm(@PathVariable("addSeq") long addrSeq,
			Model model) {

		AddAddressForm addrForm = null;

		AddressBo addressBo = addressBookService.getAddressBySeq(addrSeq);

		if (addressBo != null) {

			addrForm = new AddAddressForm(
					Long.parseLong(addressBo.getAddrSeq()),
					addressBo.getLogin(), addressBo.getDept(),
					addressBo.getAddr1(), addressBo.getAddr2(),
					addressBo.getAddr3(), addressBo.getAddr4(),
					addressBo.getPhone(), addressBo.getPincode(),
					addressBo.getFax(), addressBo.getEmail(),
					addressBo.getCity(), addressBo.getState(),
					Long.parseLong(addressBo.getCountrySeq()));

		}
		// httpSession.setAttribute("addrSeq", addrSeq);
		model.addAttribute("addEditForm", addrForm);

		return "editAddress";
	}

	@ModelAttribute("countriesList")
	public List<CountryDto> populateCountries(HttpServletRequest request) {

		return addressBookService.getCountries();
	}

	@PostMapping("/addrDetailsSubmit.htm")
	public String addDetailsSubmit(
			@ModelAttribute("addEditForm") AddAddressForm addressForm,
			BindingResult result, Model model, HttpSession httpSession) {

		String loginUser = null;

		formValidator.validate(addressForm, result);

		if (result.hasErrors()) {
			return "editAddress";
		}

		loginUser = (String) httpSession.getAttribute("loggedInUser");
		addressForm.setLogin(loginUser);

		int seq = addressBookService.updateAddress(addressForm);

		if (seq > 0) {
			model.addAttribute("status",
					"Address Details submited sucessfully.");
		}

		return "editAddress";
	}
}
