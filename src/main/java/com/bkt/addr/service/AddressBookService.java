package com.bkt.addr.service;

import java.util.List;

import com.bkt.addr.bo.AddressBo;
import com.bkt.addr.dto.CountryDto;
import com.bkt.addr.dto.UserDto;
import com.bkt.addr.forms.AddAddressForm;
import com.bkt.addr.forms.LoginForm;
import com.bkt.addr.forms.SearchForm;

public interface AddressBookService {

	public boolean doesUserExisted(String loginId, String password);

	public UserDto getUserInfo(String loginId);

	public UserDto validateUser(LoginForm form);
	
	public List<AddressBo> searchAddresses(SearchForm searchForm);
	
	public List<CountryDto> getCountries();
	
	public int addAddress(AddAddressForm addAddressForm);
	
	public AddressBo getAddressBySeq(long addrSeq);
	
	public int updateAddress(AddAddressForm addAddressForm);
	
	public int updatePassword(String userName,String password);

}
