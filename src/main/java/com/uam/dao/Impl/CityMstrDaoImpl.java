package com.uam.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uam.dao.CityMstrDao;
import com.uam.dao.GenericDao;
import com.uam.entity.CityMstr;

@Component
public class CityMstrDaoImpl extends GenericDao<Integer, CityMstr> implements CityMstrDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<CityMstr> findCityByZoneCode(String zoneCode) {
		try {
			return findByNamedQuery("CityMstr.findCityByZoneCode", "zoneCode", zoneCode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	

}
