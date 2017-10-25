package com.uam.dao;

import java.util.List;

import com.uam.entity.CityZoneMstr;

public interface CityZoneMstrDao {

	List<CityZoneMstr> findCityZoneByCityCode(String cityCode);
}
