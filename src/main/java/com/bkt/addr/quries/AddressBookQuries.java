package com.bkt.addr.quries;

public class AddressBookQuries {

	public static String validateUserQuery() {
		StringBuilder localSb = new StringBuilder();

		localSb.append(" SELECT 1 ");
		localSb.append(" FROM   LOGIN ");
		localSb.append(" WHERE  LOGIN = ? ");
		localSb.append("        AND PASSWORD = ? ");

		return localSb.toString();
	}

	public static String getUserInfoQueryByLogin(String login) {
		StringBuilder localSb = new StringBuilder();
		localSb.append(" SELECT LOGIN, ");
		localSb.append("        NAME, ");
		localSb.append("        EMAIL, ");
		localSb.append("        PHONE_NO, ");
		localSb.append("        DEPARTMENT_CD ,PASSWORD ");
		localSb.append(" FROM   LOGIN ");
		localSb.append(" WHERE  LOGIN = ? ");

		return localSb.toString();
	}

	public static StringBuilder getSerachQuery() {
		StringBuilder localSb = new StringBuilder();
		localSb.append(" SELECT a.ADDR_SEQ, ");
		localSb.append("        a.LOGIN, ");
		localSb.append("        a.DEPARTMENT, ");
		localSb.append("        a.ADDRESS1, ");
		localSb.append("        a.ADDRESS2, ");
		localSb.append("        a.ADDRESS3, ");
		localSb.append("        a.ADDRESS4, ");
		localSb.append("        a.PHONE, ");
		localSb.append("        a.PINCODE, ");
		localSb.append("        a.FAX, ");
		localSb.append("        a.EMAIL, ");
		localSb.append("        a.CITY, ");
		localSb.append("        a.STATE, ");
		localSb.append("        a.COUNTRY_SEQ couSeq, C.COUNTRY_NAME ");
		localSb.append(" FROM   ADDRESS A, COUNTRIES C");

		return localSb;
	}

	public static String getAddAddressQuery() {
		StringBuilder localSb = new StringBuilder();
		localSb.append(" INSERT INTO address ");
		localSb.append("             (addr_seq, ");
		localSb.append("              login, ");
		localSb.append("              department, ");
		localSb.append("              address1, ");
		localSb.append("              address2, ");
		localSb.append("              address3, ");
		localSb.append("              address4, ");
		localSb.append("              phone, ");
		localSb.append("              pincode, ");
		localSb.append("              fax, ");
		localSb.append("              email, ");
		localSb.append("              city, ");
		localSb.append("              state, ");
		localSb.append("              country_seq) ");
		localSb.append(" VALUES     (address_seq.NEXTVAL, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?, ");
		localSb.append("             ?) ");

		return localSb.toString();
	}

	public static StringBuilder getAddresQueryBySeq() {
		StringBuilder localSb = new StringBuilder();
		localSb.append(" SELECT  ");
		localSb.append("        a.LOGIN, ");
		localSb.append("        a.DEPARTMENT, ");
		localSb.append("        a.ADDRESS1, ");
		localSb.append("        a.ADDRESS2, ");
		localSb.append("        a.ADDRESS3, ");
		localSb.append("        a.ADDRESS4, ");
		localSb.append("        a.PHONE, ");
		localSb.append("        a.PINCODE, ");
		localSb.append("        a.FAX, ");
		localSb.append("        a.EMAIL, ");
		localSb.append("        a.CITY, ");
		localSb.append("        a.STATE, ");
		localSb.append("        a.ADDR_SEQ, ");
		localSb.append("        a.COUNTRY_SEQ , C.COUNTRY_NAME,a.ADDR_SEQ ");
		localSb.append(" FROM   ADDRESS A, COUNTRIES C where a.ADDR_SEQ=? and a.COUNTRY_SEQ=c.COUNTRY_SEQ");

		return localSb;
	}

	public static String updateAddressQuery() {
		StringBuilder localSb = new StringBuilder();
		localSb.append(" UPDATE address ");
		localSb.append(" SET    department = ?, ");
		localSb.append("        address1 = ?, ");
		localSb.append("        address2 = ?, ");
		localSb.append("        address3 = ?, ");
		localSb.append("        address4 = ?, ");
		localSb.append("        phone = ?, ");
		localSb.append("        pincode = ?, ");
		localSb.append("        fax = ?, ");
		localSb.append("        email = ?, ");
		localSb.append("        city = ?, ");
		localSb.append("        state = ?, ");
		localSb.append("        country_seq = ? ");
		localSb.append(" WHERE  addr_seq = ? and LOGIN=?");

		return localSb.toString();
	}

}
