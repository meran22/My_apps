package com.bkt.addr.forms;

public class AddAddressForm {

	private long addrSeq;
	private String login;
	private String dept;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String phoneNo;
	private int pincode;
	private String fax;
	private String email;
	private String city;
	private String state;
	private long countrySeq;

	public AddAddressForm() {
	}

	public AddAddressForm(long addrSeq, String login, String dept,
			String address1, String address2, String address3, String address4,
			String phoneNo, int pincode, String fax, String email, String city,
			String state, long countrySeq) {
		this.addrSeq = addrSeq;
		this.login = login;
		this.dept = dept;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.phoneNo = phoneNo;
		this.pincode = pincode;
		this.fax = fax;
		this.email = email;
		this.city = city;
		this.state = state;
		this.countrySeq = countrySeq;
	}

	public long getAddrSeq() {
		return addrSeq;
	}

	public void setAddrSeq(long addrSeq) {
		this.addrSeq = addrSeq;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	@Override
	public String toString() {
		return "AddUserForm [addrSeq=" + addrSeq + ", login=" + login
				+ ", dept=" + dept + ", address1=" + address1 + ", address2="
				+ address2 + ", address3=" + address3 + ", address4="
				+ address4 + ", phoneNo=" + phoneNo + ", pincode=" + pincode
				+ ", fax=" + fax + ", email=" + email + ", city=" + city
				+ ", state=" + state + ", countrySeq=" + countrySeq + "]";
	}

}
