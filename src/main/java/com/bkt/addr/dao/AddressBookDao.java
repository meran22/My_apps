package com.bkt.addr.dao;

import java.util.List;

import com.bkt.addr.bo.AddressBo;
import com.bkt.addr.bo.UserBo;
import com.bkt.addr.dto.CountryDto;

public interface AddressBookDao {

	public boolean doesUserExisted(String loginId, String password);

	public UserBo getUserInfo(String loginId);

	public List<AddressBo> getAddressSearch(String loginId, String addr1,
			String phoneNo, int pincode, String email, String city,
			String state, long countySeq);

	public List<CountryDto> getCountries();

	public int addAddress(AddressBo addressBo);
	public AddressBo getAddressBySeq(long addrSeq);
	
	public int updateAddress(AddressBo addressBo);
	
	public int updatePassword(String userName,String password);
}
