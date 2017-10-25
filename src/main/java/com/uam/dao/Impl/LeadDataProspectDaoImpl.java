package com.uam.dao.Impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uam.dao.GenericDao;
import com.uam.dao.LeadDataProspectDao;
import com.uam.entity.LeadDataProspect;

@Component
public class LeadDataProspectDaoImpl  extends GenericDao<Long, LeadDataProspect> implements LeadDataProspectDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transactional
	@Override
	public Long leadDataProspectSave(LeadDataProspect leadDataProspect) {

		try {
			persist(leadDataProspect);
			/*
			LeadDataProspect dataProspect  = findById(leadDataProspect.getId(), LeadDataProspect.class);
			if(dataProspect.getId() >0) {
				merge(leadDataProspect);
				return leadDataProspect.getId();
			}else {
				
				//leadDataProspect.setId(Long.valueOf((Integer)findSequence("LMS2.SEQ_PROSPECTS_ID")));
				persist(leadDataProspect);
				return  null;
			}
		*/} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
