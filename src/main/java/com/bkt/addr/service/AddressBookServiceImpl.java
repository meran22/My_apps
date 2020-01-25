package com.bkt.addr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkt.addr.bo.AddressBo;
import com.bkt.addr.bo.UserBo;
import com.bkt.addr.dao.AddressBookDao;
import com.bkt.addr.dto.CountryDto;
import com.bkt.addr.dto.UserDto;
import com.bkt.addr.forms.AddAddressForm;
import com.bkt.addr.forms.LoginForm;
import com.bkt.addr.forms.SearchForm;

@Service
public class AddressBookServiceImpl implements AddressBookService {

	@Autowired
	AddressBookDao bookDao;

	@Override
	public boolean doesUserExisted(String loginId, String password) {

		return bookDao.doesUserExisted(loginId, password);
	}

	@Override
	public UserDto getUserInfo(String loginId) {

		UserBo userBo = null;
		UserDto userDto = null;

		userBo = bookDao.getUserInfo(loginId);

		userDto = new UserDto(userBo.getLoginId(), userBo.getName(),
				userBo.getEmail(), userBo.getPhoneNo(), userBo.getDept());
		userDto.setPassowrd(userBo.getPassword());

		return userDto;
	}

	@Override
	public UserDto validateUser(LoginForm form) {

		UserDto userDto = null;
		boolean isUserExisted = false;

		isUserExisted = doesUserExisted(form.getLoginId(), form.getPassword());

		if (isUserExisted) 
		{
			userDto = getUserInfo(form.getLoginId());
		}

		return userDto;
	}

	@Override
	public List<AddressBo> searchAddresses(SearchForm searchForm) {
		List<AddressBo> userBos = null;
		userBos = bookDao.getAddressSearch(searchForm.getLoggedInUser(),
				searchForm.getAddress1(), searchForm.getPhoneNo(),
				searchForm.getPincode(), searchForm.getEmail(),
				searchForm.getCity(), searchForm.getState(),
				searchForm.getCountrySeq());
		return userBos;
	}

	@Override
	public List<CountryDto> getCountries() {
		return bookDao.getCountries();
	}

	@Override
	public int addAddress(AddAddressForm addAddrForm) {

		AddressBo addressBo = new AddressBo();
		addressBo.setDept(addAddrForm.getDept());
		addressBo.setAddr1(addAddrForm.getAddress1());
		addressBo.setAddr2(addAddrForm.getAddress2());
		addressBo.setAddr3(addAddrForm.getAddress3());
		addressBo.setAddr4(addAddrForm.getAddress4());
		addressBo.setPhone(addAddrForm.getPhoneNo());
		addressBo.setPincode(addAddrForm.getPincode());
		addressBo.setFax(addAddrForm.getFax());
		addressBo.setEmail(addAddrForm.getEmail());
		addressBo.setCity(addAddrForm.getCity());
		addressBo.setState(addAddrForm.getState());
		addressBo.setLogin(addAddrForm.getLogin());
		addressBo.setCountrySeq(String.valueOf(addAddrForm.getCountrySeq()));

		return bookDao.addAddress(addressBo);
	}

	@Override
	public int updateAddress(AddAddressForm addAddrForm) {
		AddressBo addressBo = new AddressBo();
		addressBo.setDept(addAddrForm.getDept());
		addressBo.setAddr1(addAddrForm.getAddress1());
		addressBo.setAddr2(addAddrForm.getAddress2());
		addressBo.setAddr3(addAddrForm.getAddress3());
		addressBo.setAddr4(addAddrForm.getAddress4());
		addressBo.setPhone(addAddrForm.getPhoneNo());
		addressBo.setPincode(addAddrForm.getPincode());
		addressBo.setFax(addAddrForm.getFax());
		addressBo.setEmail(addAddrForm.getEmail());
		addressBo.setCity(addAddrForm.getCity());
		addressBo.setState(addAddrForm.getState());
		addressBo.setLogin(addAddrForm.getLogin());
		addressBo.setCountrySeq(String.valueOf(addAddrForm.getCountrySeq()));
		addressBo.setAddrSeq(String.valueOf(addAddrForm.getAddrSeq()));

		return bookDao.updateAddress(addressBo);
	}

	@Override
	public AddressBo getAddressBySeq(long addrSeq) {
		return bookDao.getAddressBySeq(addrSeq);
	}

	@Override
	public int updatePassword(String userName, String password) {
		return bookDao.updatePassword(userName, password);
	}
}
