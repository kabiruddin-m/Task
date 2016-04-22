package com.test.action;

import java.io.Reader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.test.dao.AddressDAO;
import com.test.dao.AddressDAOImpl;
import com.test.form.AddressForm;
import com.test.vo.Address;

public class AddressAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AddressForm addressForm = (AddressForm) form;
		Reader reader = Resources.getResourceAsReader("sql-maps-config.xml");
		SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		AddressDAO addressDao = new AddressDAOImpl();
		Address address = new Address();
		address.setAddressTypeCd(null == request.getParameter("type") ?  "D" : request.getParameter("type"));

		try {
			addressDao.getAddress(address, sqlmapClient);
		} catch (Exception e) {
			e.printStackTrace();
			addressForm.setMessage("Failure --" + e.getMessage());
			mapping.findForward("failure");
		}

		addressForm.setMessage("Address Type is --" + address.getAddressTypeName());
		return mapping.findForward("success");
	}
}
