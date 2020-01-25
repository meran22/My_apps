package com.bkt.addr.forms;

public class SearchForm {
	private String address1;
	private String phoneNo;
	private int pincode;
	private String email;
	private String city;
	private String state;
	private long countrySeq;
	private String loggedInUser;

	public SearchForm() {
	}

	public SearchForm(String address1, String phoneNo, int pincode,
			String email, String city, String state, long countrySeq) {
		super();
		this.address1 = address1;
		this.phoneNo = phoneNo;
		this.pincode = pincode;
		this.email = email;
		this.city = city;
		this.state = state;
		this.countrySeq = countrySeq;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getCountrySeq() {
		return countrySeq;
	}

	public void setCountrySeq(long countrySeq) {
		this.countrySeq = countrySeq;
	}

	public String getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	@Override
	public String toString() {
		return "SearchForm [address1=" + address1 + ", phoneNo=" + phoneNo
				+ ", pincode=" + pincode + ", email=" + email + ", city="
				+ city + ", state=" + state + ", countrySeq=" + countrySeq
				+ "]";
	}

}
