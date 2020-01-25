package com.bkt.addr.bo;

public class UserBo {
	private String loginId;
	private String name;
	private String email;
	private String phoneNo;
	private String dept;
	private String password;

	public UserBo() {
	}

	public UserBo(String loginId, String name, String email, String phoneNo,
			String dept) {
		this.loginId = loginId;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dept = dept;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [loginId=" + loginId + ", name=" + name + ", email="
				+ email + ", phoneNo=" + phoneNo + ", dept=" + dept + "]";
	}

}
