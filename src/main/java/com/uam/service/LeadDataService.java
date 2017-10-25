package com.uam.service;

import java.util.List;

import com.uam.dto.LeadDTO;
import com.uam.entity.LeadData;
import com.uam.entity.LeadDataCustomer;
import com.uam.entity.LeadDataProspect;

public interface LeadDataService {

	String leadUpdateAndSave(LeadData leadData);
	Long leadDataProspectSave(LeadDataProspect leadDataProspect);
	Integer leadDataCustomerSave(LeadDataCustomer leadDataCustomer);
	List<LeadData> retrievedLeadData(String leadId ,String mobile);
	LeadDataCustomer findByMobile(String mobile);
	Long fetchLeadSequenceId(String mobile);
	String updateLeadData(LeadDTO leadDTO);
	
}
