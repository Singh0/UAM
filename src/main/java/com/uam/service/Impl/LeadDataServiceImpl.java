package com.uam.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uam.dao.GenericDao;
import com.uam.dao.LeadDataCustomerDao;
import com.uam.dao.LeadDataDao;
import com.uam.dao.LeadDataProspectDao;
import com.uam.dto.LeadDTO;
import com.uam.entity.Circle;
import com.uam.entity.CityMstr;
import com.uam.entity.CityZoneMstr;
import com.uam.entity.LeadData;
import com.uam.entity.LeadDataCustomer;
import com.uam.entity.LeadDataProspect;
import com.uam.entity.LeadStatus;
import com.uam.entity.ProductLobMaster;
import com.uam.entity.ProductMSTR;
import com.uam.entity.ZoneMstr;
import com.uam.service.LeadDataService;

@Service
public class LeadDataServiceImpl extends GenericDao<Integer, LeadData> implements LeadDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private LeadDataDao leadDataDao;

	@Autowired
	private LeadDataProspectDao leadDataProspectDao;
	
	
	@Autowired
	private LeadDataCustomerDao leadDataCustomerDao;
	
	@Override
	public String leadUpdateAndSave(LeadData leadData) {

	try {
		return leadDataDao.leadUpdateAndSave(leadData);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}

	
	@Override
	public Long leadDataProspectSave(LeadDataProspect leadDataProspect) {
		return leadDataProspectDao.leadDataProspectSave(leadDataProspect);
		//return null;
	}

	@Override
	public Integer leadDataCustomerSave(LeadDataCustomer leadDataCustomer) {
		// TODO Auto-generated method stub
		return leadDataCustomerDao.leadDataCustomerSave(leadDataCustomer);
	}


	@Override
	public List<LeadData> retrievedLeadData(String leadId, String mobile) {
		// TODO Auto-generated method stub
		return leadDataDao.retrievedLeadData(leadId, mobile);
	}


	@Override
	public LeadDataCustomer findByMobile(String mobile) {
		// TODO Auto-generated method stub
		return leadDataCustomerDao.findByMobile(mobile);
	}


	@Override
	public Long fetchLeadSequenceId(String mobile) {
		// TODO Auto-generated method stub
		return leadDataDao.fetchLeadSequenceId(mobile);
	}


	@Override
	public String updateLeadData(LeadDTO leadDTO) {
		try {
			
			if(leadDTO.getLeadId() == null && leadDTO.getLeadId().length() !=14) {
				return "Lead Details can not be update for leadId : "+leadDTO.getLeadId();
			}
			LeadData leadData  = leadDataDao.findById(Long.parseLong(leadDTO.getLeadId()));
			 
			if(leadDTO.getSource() !=null) {
			leadData.setSource(Integer.valueOf(leadDTO.getSource()));
			leadData.setSubsource(leadDTO.getSubSource());
			leadData.setRequesttype(Integer.valueOf(leadDTO.getRequestType()));
			}
			leadData.setRemarks(leadDTO.getRemark());
			
			LeadDataCustomer customer  = leadData.getCustomer();
			customer.setAltContactNo(leadDTO.getAlternateNo());
			customer.setCustomerMobile(leadDTO.getMobile());
			customer.setCustomerName(leadDTO.getName());
			customer.setEmail(leadDTO.getEmail());
			customer.setPrimaryLanguage(leadDTO.getPreferredLanguage());
			customer.setLandLineNo(leadDTO.getLandlineNo());
			
			LeadDataProspect leadDataProspect  = leadData.getLeadDataProspect();
			leadDataProspect.setCircleId(Integer.valueOf(leadDTO.getCircleId()));
			//leadDataProspect.setLeadId(Long.valueOf(leadDTO.getLeadId()));
			leadDataProspect.setLobId(Integer.valueOf(leadDTO.getLob()));
			leadDataProspect.setCity(leadDTO.getCity());
			leadDataProspect.setZone(leadDTO.getZone());
			leadDataProspect.setPincode(123);
			leadDataProspect.setAddress1(leadDTO.getAddressFirst());
			leadDataProspect.setAddress2(leadDTO.getAddressSecond());
			//leadDataProspect.setProspectId(leadDataProspect.getProspectId());
			CityZoneMstr cityZoneMstr  = new CityZoneMstr();// leadDataProspect.getCityZone();
			
			cityZoneMstr.setCityZoneCode(leadDTO.getCityzone());
			leadDataProspect.setCityZone(cityZoneMstr);
			
			LeadStatus leadStatus  = new LeadStatus();//.getLeadStatus();
			leadStatus.setId(Integer.valueOf(leadDTO.getLeadStatusId()));
			
			ProductMSTR productMSTR  = leadData.getProductMSTR();
			productMSTR.setId(Integer.valueOf(leadDTO.getProductId()));
			
			leadData.setLeadStatus(leadStatus);
			leadData.setProductMSTR(productMSTR);
			leadData.setCustomer(customer);
			leadData.setLeadDataProspect(leadDataProspect);
			leadDataDao.leadUpdateAndSave(leadData);
			return "Lead Update Successfully";// leadDataDao.leadUpdateAndSave(leadData);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Lead Details can not be update for leadId :"+leadDTO.getLeadId();
		}
		//return "Success";
	}

}
