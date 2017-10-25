package com.uam.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uam.dao.CityZoneMstrDao;
import com.uam.dao.GenericDao;
import com.uam.entity.CityZoneMstr;


@Component
public class CityZoneMstrDaoImpl extends GenericDao<Integer, CityZoneMstr> implements CityZoneMstrDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<CityZoneMstr> findCityZoneByCityCode(String cityCode) {
		try {
			return findByNamedQuery("CityZoneMstr.findCityZoneCodeByCitycode", "cityCode", cityCode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
