package com.uam.service;

import java.util.List;

import com.uam.entity.Circle;
import com.uam.entity.CityMstr;
import com.uam.entity.CityZoneMstr;
import com.uam.entity.LeadStatus;
import com.uam.entity.ProductLobMaster;
import com.uam.entity.ProductMSTR;
import com.uam.entity.ZoneMstr;

public interface MasterService {

	List<ProductLobMaster> fetchAllProductLob();
	List<ProductMSTR> fetchAllProduct();
	List<ProductMSTR> fetchProductByLOB(int lobId);
	List<Circle> fetchCircleByLOB(int lobId);
	List<ZoneMstr> fetchZoneByCircleMstrId(int circleMstrId);
	List<CityMstr> findCityByZoneCode(String zoneCode);
	List<CityZoneMstr> findCityZoneByCityCode(String cityCode);
	LeadStatus findById(Integer statusId);
    Circle findCirclebyId(int circleMstrId);
}

