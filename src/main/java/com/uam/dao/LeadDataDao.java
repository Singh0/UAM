package com.uam.dao;

import java.util.List;

import com.uam.entity.LeadData;

public interface LeadDataDao {

	String leadUpdateAndSave(LeadData leadData);
	List<LeadData> retrievedLeadData(String leadId ,String mobile);
	Long fetchLeadSequenceId(String mobile);
	LeadData findById(Long id);
}
