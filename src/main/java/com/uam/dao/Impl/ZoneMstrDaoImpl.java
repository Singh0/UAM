package com.uam.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uam.dao.GenericDao;
import com.uam.dao.ZoneMstrDao;
import com.uam.entity.ZoneMstr;


@Component
public class ZoneMstrDaoImpl extends GenericDao<Integer, ZoneMstr> implements ZoneMstrDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<ZoneMstr> fetchZoneByCircleMstrId(int circleMstrId) {
		try {
			return findByNamedQuery("ZoneMstr.findByCircleMstrId", "id", circleMstrId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
