package com.bkt.addr.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bkt.addr.forms.ChangePassWordForm;

@Component
public class ChangePasswordFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ChangePassWordForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ChangePassWordForm form = null;

		form = (ChangePassWordForm) target;

		if (form.getOldPassword() == null
				|| form.getOldPassword().length() == 0) {
			errors.rejectValue("oldPassword", "oldPassword.required",
					"Please enter old password.");

		}
		if (form.getNewPassword() == null
				|| form.getNewPassword().length() == 0) {
			errors.rejectValue("newPassword", "newPassword.required",
					"Please enter New password.");

		}
		if (form.getConfirmPassword() == null
				|| form.getConfirmPassword().length() == 0) {
			errors.rejectValue("confirmPassword", "confirmPassword.required",
					"Please enter confirm password.");
		}

		// if (form.getOldPassword().equals(form.getNewPassword())) {
		// errors.reject("errorcode",
		// "Old password and New password must be different.");
		// }
		//
		// if (!form.getNewPassword().equals(form.getConfirmPassword())) {
		// errors.reject("errorcode",
		// "New password and Confirm password must be same.");
		// }
	}

}
