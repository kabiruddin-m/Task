package com.test.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.test.vo.Address;

public interface AddressDAO {
	public Address getAddress(Address address, SqlMapClient sqlmapClient);
}
