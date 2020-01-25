package com.bkt.addr.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bkt.addr.forms.AddAddressForm;

@Component
public class AddressFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return clazz.isAssignableFrom(AddAddressForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		AddAddressForm form = null;
		form = (AddAddressForm) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dept",
				"dept.required", "Department is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1",
				"dept.required", "Address1 is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNo",
				"phoneNo.required", "Phone number is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fax",
				"fax.required", "Fax is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"email.required", "Emai is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city",
				"city.required", "City is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state",
				"state.required", "State is mandatory");

		if (form.getPincode() <= 0) {
			errors.rejectValue("pincode", "pincode.required",
					"Pin code is manatory.");
		}

		if (form.getCountrySeq() <= 0) {
			errors.rejectValue("countrySeq", "countrySeq.required",
					"Please select country.");
		}
	}
}
