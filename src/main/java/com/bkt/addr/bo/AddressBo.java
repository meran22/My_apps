package com.bkt.addr.bo;

public class AddressBo {

	private String addrSeq;
	private String login;
	private String dept;
	private String addr1;
	private String addr2;
	private String addr3;
	private String addr4;
	private String phone;
	private int pincode;
	private String fax;
	private String email;
	private String city;
	private String state;
	private String countrySeq;
	private String countryName;

	public AddressBo() {
	}

	public AddressBo(String addrSeq, String login, String dept, String addr1,
			String addr2, String addr3, String addr4, String phone,
			int pincode, String fax, String email, String city, String state,
			String countrySeq, String countryName) {
		this.addrSeq = addrSeq;
		this.login = login;
		this.dept = dept;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.addr4 = addr4;
		this.phone = phone;
		this.pincode = pincode;
		this.fax = fax;
		this.email = email;
		this.city = city;
		this.state = state;
		this.countrySeq = countrySeq;
		this.countryName = countryName;
	}

	public String getAddrSeq() {
		return addrSeq;
	}

	public void setAddrSeq(String addrSeq) {
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

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr3() {
		return addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public String getAddr4() {
		return addr4;
	}

	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getCountrySeq() {
		return countrySeq;
	}

	public void setCountrySeq(String countrySeq) {
		this.countrySeq = countrySeq;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "AddressBo [addrSeq=" + addrSeq + ", login=" + login + ", dept="
				+ dept + ", addr1=" + addr1 + ", addr2=" + addr2 + ", addr3="
				+ addr3 + ", addr4=" + addr4 + ", phone=" + phone
				+ ", pincode=" + pincode + ", fax=" + fax + ", email=" + email
				+ ", city=" + city + ", state=" + state + ", countrySeq="
				+ countrySeq + ", countryName=" + countryName + "]";
	}

}
