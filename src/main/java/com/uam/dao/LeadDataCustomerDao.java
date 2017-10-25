package com.uam.dao;

import com.uam.entity.LeadDataCustomer;

public interface LeadDataCustomerDao {

	Integer leadDataCustomerSave(LeadDataCustomer leadDataCustomer);
	LeadDataCustomer findByMobile(String mobile);
}
