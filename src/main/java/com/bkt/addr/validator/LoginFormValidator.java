package com.bkt.addr.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bkt.addr.forms.LoginForm;

@Component
public class LoginFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(LoginForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		LoginForm loginForm = null;
		loginForm = (LoginForm) target;

		if (loginForm.getLoginId() == null
				|| loginForm.getLoginId().trim().length() == 0) {

			errors.rejectValue("loginId", "loginId.notempty",
					"Please enter login Id.");
		}

		if (loginForm.getPassword() == null
				|| loginForm.getPassword().length() == 0) {

			errors.rejectValue("password", "login.notempty",
					"Please enter password.");
		}
	}
}
