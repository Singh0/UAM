package com.uam.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uam.dao.CircleDao;
import com.uam.dao.CityMstrDao;
import com.uam.dao.CityZoneMstrDao;
import com.uam.dao.LeadStatusDao;
import com.uam.dao.MasterDao;
import com.uam.dao.ProductDao;
import com.uam.dao.ZoneMstrDao;
import com.uam.entity.Circle;
import com.uam.entity.CityMstr;
import com.uam.entity.CityZoneMstr;
import com.uam.entity.LeadStatus;
import com.uam.entity.ProductLobMaster;
import com.uam.entity.ProductMSTR;
import com.uam.entity.ZoneMstr;
import com.uam.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService{
	
	@Autowired
	private MasterDao masterDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CircleDao circleDao;
	
	@Autowired
	private ZoneMstrDao zoneMstrdao;
	
	@Autowired
	private CityMstrDao cityMstrDao;
	
	@Autowired
	private CityZoneMstrDao cityZoneMstrdao;
	
	@Autowired
	private LeadStatusDao leadStatusDao;
	
	

	/*MasterService(){
		System.out.println("MasterService............");
	}*/
	
	@Override
	public List<ProductLobMaster> fetchAllProductLob() {
		return masterDao.fetchAllProductLob();
	}

	@Override
	public List<ProductMSTR> fetchAllProduct() {
		return productDao.fetchAllProduct();
	}

	@Override
	public List<ProductMSTR> fetchProductByLOB(int lobId) {
		return productDao.fetchProductByLOB(lobId);
	}

	@Override
	public List<Circle> fetchCircleByLOB(int lobId) {
		// TODO Auto-generated method stub
		return circleDao.fetchCircleByLOB(lobId);
	}

	@Override
	public List<ZoneMstr> fetchZoneByCircleMstrId(int circleMstrId) {
		
		return zoneMstrdao.fetchZoneByCircleMstrId(circleMstrId);
	}

	@Override
	public List<CityMstr> findCityByZoneCode(String zoneCode) {
		
		return cityMstrDao.findCityByZoneCode(zoneCode);
	}

	@Override
	public List<CityZoneMstr> findCityZoneByCityCode(String cityCode) {
		
		return cityZoneMstrdao.findCityZoneByCityCode(cityCode);
	}

	@Override
	public LeadStatus findById(Integer statusId) {
		return leadStatusDao.findById(statusId);
	}

	@Override
	public Circle findCirclebyId(int circleMstrId) {
		// TODO Auto-generated method stub
		return circleDao.findCirclebyId(circleMstrId);
	}

}
