package com.bkt.addr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.bkt.addr.bo.AddressBo;
import com.bkt.addr.bo.UserBo;
import com.bkt.addr.dto.CountryDto;
import com.bkt.addr.quries.AddressBookQuries;

@Repository
public class AddressBookDaoImpl implements AddressBookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean doesUserExisted(final String loginId, final String password) {
		boolean flag = false;
		flag = jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement statement = null;
				statement = con.prepareStatement(AddressBookQuries
						.validateUserQuery());
				statement.setString(1, loginId);
				statement.setString(2, password);
				return statement;
			}
		}, new ResultSetExtractor<Boolean>() {

			@Override
			public Boolean extractData(ResultSet rs) throws SQLException,
					DataAccessException {

				while (rs.next()) {
					return true;
				}
				return false;
			}
		});

		return flag;
	}

	@Override
	public UserBo getUserInfo(String loginId) {
		UserBo userBo = null;

		userBo = jdbcTemplate.query(
				AddressBookQuries.getUserInfoQueryByLogin(loginId),
				new String[] { loginId }, new ResultSetExtractor<UserBo>() {

					@Override
					public UserBo extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						UserBo userBo = null;

						while (rs.next()) {
							userBo = new UserBo();
							userBo.setLoginId(rs.getString("login"));
							userBo.setName(rs.getString("name"));
							userBo.setEmail(rs.getString("email"));
							userBo.setPhoneNo(rs.getString("phone_no"));
							userBo.setDept(rs.getString("DEPARTMENT_CD"));
							userBo.setPassword(rs.getString("PASSWORD"));
						}
						return userBo;
					}

				});

		return userBo;
	}

	@Override
	public List<AddressBo> getAddressSearch(final String loginId,
			final String addr1, final String phoneNo, final int pincode,
			final String email, final String city, final String state,
			final long countySeq) {
		List<AddressBo> localBo = null;

		localBo = jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				boolean addr1Flag = false;
				boolean phoneNoFlag = false;
				boolean pincodeFlag = false;
				boolean emailFlag = false;
				boolean cityFlag = false;
				boolean stateFlag = false;
				boolean countySeqFlag = false;

				StringBuilder selectQry = null;
				PreparedStatement statement = null;
				selectQry = AddressBookQuries.getSerachQuery();
				if (loginId != null && loginId.trim().length() > 0) {
					selectQry.append(" where a.LOGIN=? ");
				}
				if (addr1 != null && addr1.trim().length() > 0) {
					selectQry.append(" And a.ADDRESS1=? ");
					addr1Flag = true;
				}
				if (phoneNo != null && phoneNo.trim().length() > 0) {
					selectQry.append(" And a.PHONE=? ");
					phoneNoFlag = true;
				}
				if (pincode != 0) {
					selectQry.append(" And a.PINCODE=? ");
					pincodeFlag = true;
				}
				if (email != null && email.trim().length() > 0) {
					selectQry.append(" And a.EMAIL=? ");
					emailFlag = true;
				}
				if (city != null && city.trim().length() > 0) {
					selectQry.append(" And a.CITY=? ");
					cityFlag = true;
				}
				if (state != null && state.trim().length() > 0) {
					selectQry.append(" And a.STATE=? ");
					stateFlag = true;
				}
				if (countySeq != 0) {
					selectQry.append(" And c.country_seq=? ");
					countySeqFlag = true;
				}
				selectQry.append(" and c.country_seq=a.country_seq ");
				
				int count = 1;
				statement = con.prepareStatement(selectQry.toString());
				statement.setString(count++, loginId);
				if (addr1Flag) {
					statement.setString(count++, addr1);
				}
				if (phoneNoFlag) {
					statement.setString(count++, phoneNo);
				}
				if (pincodeFlag) {
					statement.setLong(count++, pincode);
				}
				if (emailFlag) {
					statement.setString(count++, email);
				}
				if (cityFlag) {
					statement.setString(count++, city);
				}
				if (stateFlag) {
					statement.setString(count++, state);
				}
				if (countySeqFlag) {
					statement.setLong(count++, countySeq);
				}

				return statement;
			}
		}, new ResultSetExtractor<List<AddressBo>>() {

			@Override
			public List<AddressBo> extractData(ResultSet rs)
					throws SQLException, DataAccessException {

				AddressBo addressBo = null;
				List<AddressBo> addressBos = null;

				addressBos = new ArrayList<AddressBo>();

				while (rs.next()) {
					addressBo = new AddressBo();
					addressBo.setLogin(rs.getString("login"));
					addressBo.setAddrSeq(rs.getString("ADDR_SEQ"));
					addressBo.setDept(rs.getString("DEPARTMENT"));
					addressBo.setAddr1(rs.getString("ADDRESS1"));
					addressBo.setAddr2(rs.getString("ADDRESS2"));
					addressBo.setAddr3(rs.getString("ADDRESS3"));
					addressBo.setAddr4(rs.getString("ADDRESS4"));
					addressBo.setPhone(rs.getString("phone"));
					addressBo.setEmail(rs.getString("email"));
					addressBo.setFax(rs.getString("fax"));
					addressBo.setPincode(rs.getInt("pincode"));
					addressBo.setCity(rs.getString("city"));
					addressBo.setState(rs.getString("state"));
					addressBo.setCountryName(rs.getString("COUNTRY_NAME"));
					addressBo.setCountrySeq(rs.getString("couSeq"));
					addressBos.add(addressBo);

				}

				return addressBos;
			}
		});
		return localBo;
	}

	@Override
	public List<CountryDto> getCountries() {

		List<CountryDto> countryDtos = null;

		countryDtos = jdbcTemplate.query(
				"select COUNTRY_SEQ,COUNTRY_NAME from countries",
				new ResultSetExtractor<List<CountryDto>>() {

					@Override
					public List<CountryDto> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<CountryDto> countryList = null;
						CountryDto countryDto = null;

						countryList = new ArrayList<CountryDto>();
						countryList.add(new CountryDto());
						while (rs.next()) {
							countryDto = new CountryDto();
							countryDto.setCountrySeq(rs.getLong("COUNTRY_SEQ"));
							countryDto.setCountryName(rs
									.getString("COUNTRY_NAME"));
							countryList.add(countryDto);
						}
						return countryList;
					}

				});

		return countryDtos;
	}

	@Override
	public int addAddress(final AddressBo addressBo) {

		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {

				PreparedStatement statement = null;

				statement = con.prepareStatement(
						AddressBookQuries.getAddAddressQuery(),
						new String[] { "ADDR_SEQ" });

				statement.setString(1, addressBo.getLogin());
				statement.setString(2, addressBo.getDept());
				statement.setString(3, addressBo.getAddr1());
				statement.setString(4, addressBo.getAddr2());
				statement.setString(5, addressBo.getAddr3());
				statement.setString(6, addressBo.getAddr4());
				statement.setString(7, addressBo.getPhone());
				statement.setInt(8, addressBo.getPincode());
				statement.setString(9, addressBo.getFax());
				statement.setString(10, addressBo.getEmail());
				statement.setString(11, addressBo.getCity());
				statement.setString(12, addressBo.getState());
				statement.setString(13, addressBo.getCountrySeq());

				return statement;
			}
		}, holder);

		return holder.getKey().intValue();
	}

	@Override
	public AddressBo getAddressBySeq(final long addrSeq) {

		AddressBo bo = null;

		bo = jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {

				PreparedStatement statement = null;

				statement = con.prepareStatement(AddressBookQuries
						.getAddresQueryBySeq().toString());

				statement.setLong(1, addrSeq);

				return statement;
			}
		}, new ResultSetExtractor<AddressBo>() {

			@Override
			public AddressBo extractData(ResultSet rs) throws SQLException,
					DataAccessException {

				AddressBo addressBo = null;
				while (rs.next()) {
					addressBo = new AddressBo();
					addressBo.setLogin(rs.getString("login"));
					addressBo.setAddrSeq(rs.getString("ADDR_SEQ"));
					addressBo.setDept(rs.getString("DEPARTMENT"));
					addressBo.setAddr1(rs.getString("ADDRESS1"));
					addressBo.setAddr2(rs.getString("ADDRESS2"));
					addressBo.setAddr3(rs.getString("ADDRESS3"));
					addressBo.setAddr4(rs.getString("ADDRESS4"));
					addressBo.setPhone(rs.getString("phone"));
					addressBo.setEmail(rs.getString("email"));
					addressBo.setFax(rs.getString("fax"));
					addressBo.setPincode(rs.getInt("pincode"));
					addressBo.setCity(rs.getString("city"));
					addressBo.setState(rs.getString("state"));
					addressBo.setCountryName(rs.getString("COUNTRY_NAME"));
					addressBo.setCountrySeq(rs.getString("COUNTRY_SEQ"));
					addressBo.setAddrSeq(rs.getString("ADDR_SEQ"));
				}
				return addressBo;
			}
		});

		return bo;
	}

	@Override
	public int updateAddress(final AddressBo addressBo) {
		int num = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {

				PreparedStatement statement = null;

				statement = con.prepareStatement(AddressBookQuries
						.updateAddressQuery());

				statement.setString(1, addressBo.getDept());
				statement.setString(2, addressBo.getAddr1());
				statement.setString(3, addressBo.getAddr2());
				statement.setString(4, addressBo.getAddr3());
				statement.setString(5, addressBo.getAddr4());
				statement.setString(6, addressBo.getPhone());
				statement.setInt(7, addressBo.getPincode());
				statement.setString(8, addressBo.getFax());
				statement.setString(9, addressBo.getEmail());
				statement.setString(10, addressBo.getCity());
				statement.setString(11, addressBo.getState());
				statement.setString(12, addressBo.getCountrySeq());
				statement.setString(13, addressBo.getAddrSeq());
				statement.setString(14, addressBo.getLogin());

				return statement;
			}
		});

		return num;
	}

	@Override
	public int updatePassword(String userName, String password) {
		return jdbcTemplate.update("update login set PASSWORD ='" + password
				+ "' where login='" + userName + "'");
	}
}