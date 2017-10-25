package com.uam.dao.Impl;

import org.springframework.stereotype.Component;

import com.uam.dao.GenericDao;
import com.uam.dao.LeadStatusDao;
import com.uam.entity.LeadStatus;

@Component
public class LeadStatusDaoImpl extends GenericDao<Integer, LeadStatus> implements LeadStatusDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public LeadStatus findById(Integer statusId) {
		try {
			return findById(statusId, LeadStatus.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
