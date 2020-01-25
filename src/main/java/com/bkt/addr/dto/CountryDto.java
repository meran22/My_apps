package com.bkt.addr.dto;

public class CountryDto {
	private long countrySeq;
	private String countryCode;
	private String countryName;

	public CountryDto() {
	}

	public CountryDto(long countrySeq, String countryCode, String countryName) {
		this.countrySeq = countrySeq;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public long getCountrySeq() {
		return countrySeq;
	}

	public void setCountrySeq(long countrySeq) {
		this.countrySeq = countrySeq;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "CountryDto [countrySeq=" + countrySeq + ", countryCode="
				+ countryCode + ", countryName=" + countryName + "]";
	}

}
