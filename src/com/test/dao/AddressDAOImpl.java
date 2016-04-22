package com.test.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.test.vo.Address;

public class AddressDAOImpl implements AddressDAO {

	public Address getAddress(Address address, SqlMapClient sqlmapClient) {
		try {
			address = (Address) sqlmapClient.queryForObject("Address.getAddressInformationID", address);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}

}
