package com.uam.dao;

import java.util.List;

import com.uam.entity.CityMstr;

public interface CityMstrDao {
	
	List<CityMstr> findCityByZoneCode(String zoneCode);
}
