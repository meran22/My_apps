package com.bkt.addr.forms;

public class ChangePassWordForm {

	private String oldPassword;
	private String newPassword;
	private String confirmPassword;

	public ChangePassWordForm() {
		super();
	}

	public ChangePassWordForm(String oldPassword, String newPassword,
			String confirmPassword) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "ChangePassWordForm [oldPassword=" + oldPassword
				+ ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + "]";
	}

}
