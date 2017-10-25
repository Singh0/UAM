package com.uam.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
import com.uam.service.MasterService;
import com.uam.util.CustomMessage;
import com.uam.util.RestURIConstants;

@RestController

@RequestMapping("NAS")
@CrossOrigin(origins = "http://localhost:4200")
public class LeadController {
	
	
	@Autowired
	MasterService masterService;
	
	@Autowired
	LeadDataService leadDataService;
	
	/**
	 * {

"name":"beeru",
"mobile":"8768768",
"product":"product",
"source":"source"
}
	 * @param lead
	 * @param ucBuilder
	 * @return
	 */
	 @RequestMapping(value = RestURIConstants.CREATE_LEAD_URL , method = RequestMethod.POST) //, UriComponentsBuilder ucBuilder , method = RequestMethod.POST
	 public ResponseEntity<CustomMessage> createLead(@Validated @RequestBody LeadDTO lead) {
		 
		  LeadData leadData  = new LeadData();
		  LeadDataCustomer leadDataCustomer =  leadDataService.findByMobile(lead.getMobile());
		 // System.out.println(leadDataCustomer+"===========================");
		  if(leadDataCustomer ==null) {
			  leadDataCustomer  = new  LeadDataCustomer();
		  }
		leadDataCustomer.setCustomerName(lead.getName());
		leadDataCustomer.setCustomerMobile(lead.getMobile());
		leadDataCustomer.setEmail(lead.getEmail());
		leadDataCustomer.setAltContactNo(lead.getAlternateNo());
		leadDataCustomer.setLandLineNo(lead.getLandlineNo());
		leadDataCustomer.setPrimaryLanguage(lead.getPreferredLanguage());
		//leadDataCustomer.setId(9548707);
		 leadDataService.leadDataCustomerSave(leadDataCustomer);
		
		
		 //leadDataProspect.set
		
		 ProductMSTR mstr  = new ProductMSTR();
		 mstr.setId(Integer.valueOf(lead.getProduct()));
		 
		 LeadStatus leadStatus  = new LeadStatus();
		 leadStatus.setId(200);
			 
		// LeadData leadData  = new LeadData();
		 leadData.setProductMSTR(mstr);
		 leadData.setLeadStatus(leadStatus);
		 String mobile  = lead.getMobile();
		 
		 leadData.setId(leadDataService.fetchLeadSequenceId(mobile));
		 leadData.setRequesttype(4);
		 
		 CityZoneMstr cityZoneMstr  = new CityZoneMstr();
		 cityZoneMstr.setCityZoneCode(lead.getCityzone());
		 LeadDataProspect leadDataProspect  = new LeadDataProspect();
		 
		 Circle circle  = masterService.findCirclebyId(Integer.valueOf(lead.getCircle()));
		 leadDataProspect.setCircleId((circle !=null)?circle.getCircleId():-1);
		 leadDataProspect.setLobId(Integer.valueOf(lead.getLob()));
		 leadDataProspect.setCity(lead.getCity());
		 leadDataProspect.setCityZone(cityZoneMstr);
		 leadDataProspect.setZone(lead.getZone());
		 leadDataProspect.setLeadId(leadData.getId());
		 leadDataProspect.setProspectId(leadDataCustomer.getId());
		 leadDataProspect.setAddress1(lead.getAddressFirst());
		 leadDataProspect.setAddress2(lead.getAddressSecond());
		 //leadDataProspect.setPincode(lead.getPincode());
		 leadDataService.leadDataProspectSave(leadDataProspect);
		 leadData.setLeadDataProspect(leadDataProspect);
		leadData.setCustomer(leadDataCustomer);
		leadData.setCreatedAt(new Date()); 
		leadData.setSource(8);
		leadData.setSubsource("8");
		leadData.setRemarks(lead.getRemark());
		String leadId =  leadDataService.leadUpdateAndSave(leadData);
		 System.out.println("-------------------"+leadId);
		 System.out.println("-----------mobile--------"+lead.getMobile());
		// HttpHeaders headers = new HttpHeaders();
		 CustomMessage customMessage  = new CustomMessage();
		 String leadMess = "Lead Created Successfully with Lead Id : "+leadData.getId();
		 customMessage.setResponceMessage(leadMess);
	       // headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(lead.getLeadId()).toUri());
		 return new ResponseEntity<CustomMessage>(customMessage, HttpStatus.CREATED);//ResponseEntity<String>(headers, HttpStatus.CREATED);
		 
	 }

	 @RequestMapping(value = RestURIConstants.RETRIEVED_LEADDATA_URL, method = RequestMethod.GET)
	 public List<LeadDTO> retreivedLead(@PathVariable("lead") String leadId,@PathVariable("mobile") String mobile){
		 
		 List<LeadData> leadDatas   =  leadDataService.retrievedLeadData(leadId, mobile);
		 List<LeadDTO> leadDTOs  = new ArrayList<LeadDTO>();
		 if(leadDatas.size()<=0 || leadDatas==null || leadDatas.get(0)==null) {
			 return leadDTOs;
		 }
		 System.out.println(leadDatas+"===="+leadId);
		 for(int i=0; i<leadDatas.size(); i++) {
		 LeadData leadData =leadDatas.get(i);
		 /*if(leadData ==null || leadData.getId()==null) {
			 return leadDTOs;
		 }*/
		// System.out.println(leadData);
		 LeadDTO leadDTO  = new LeadDTO();
		 leadDTO.setLeadId(""+leadData.getId());
		 LeadDataCustomer customer  = leadData.getCustomer();
		 leadDTO.setName(customer.getCustomerName());
		 leadDTO.setEmail(customer.getEmail());
		 leadDTO.setMobile(customer.getCustomerMobile());
		 leadDTO.setPreferredLanguage(customer.getPrimaryLanguage());
		 leadDTO.setAlternateNo(customer.getAltContactNo());
		 leadDTO.setLandlineNo(customer.getLandLineNo());
		
		 LeadDataProspect leadDataProspect  = leadData.getLeadDataProspect();
		 leadDTO.setCircleId(""+leadDataProspect.getCircleId());
		 leadDTO.setAddressFirst(leadDataProspect.getAddress1());
		 leadDTO.setAddressSecond(leadDataProspect.getAddress2());
		 LeadStatus leadStatus  = leadData.getLeadStatus();
		 leadDTO.setLeadStatus(leadStatus.getLeadStatusName());
		 
		 ProductMSTR productMSTR  = leadData.getProductMSTR(); 
		 leadDTO.setProduct(productMSTR.getProductName());
		 leadDTO.setProductId(""+productMSTR.getId());
		 
		 ProductLobMaster productLobMaster  = productMSTR.getLobMaster();
		 leadDTO.setLob(productLobMaster.getProductLobName());
		 leadDTO.setLobId(""+productLobMaster.getId());
		
		 CityZoneMstr cityZoneMstr  = leadDataProspect.getCityZone();
		 if(cityZoneMstr !=null) {
		 leadDTO.setCityzone(cityZoneMstr.getCityZoneCode());
		 leadDTO.setCityZoneName(cityZoneMstr.getCityZoneName());
		 CityMstr cityMstr   =  cityZoneMstr.getCityMstrs();
		 leadDTO.setCityName(cityMstr.getCityName());
		 leadDTO.setCity(cityMstr.getCityCode());
		  
		 ZoneMstr zoneMstr  = cityMstr.getZones();
		 leadDTO.setZoneName(zoneMstr.getZoneName());
		 leadDTO.setZone(zoneMstr.getZoneCode());
		 Circle circle  = zoneMstr.getCircles();
		 leadDTO.setCircle(circle.getCircleName());
		 leadDTO.setCircleMstrId(""+circle.getId());
		 }
		 leadDTOs.add(leadDTO);
		 }
		 return leadDTOs;
	 }

	 @RequestMapping(value = RestURIConstants.UPDATE_LEAD_DATA_URL)
	 public String  leadDataUpdate(@Validated @RequestBody LeadDTO lead) {
		 if(lead.getCircleMstrId() !=null && lead.getCircleMstrId().length() >0) {
		 Circle circle  = masterService.findCirclebyId(Integer.parseInt(lead.getCircleMstrId()));
		 lead.setCircleId(""+circle.getCircleId());
		 }
		return leadDataService.updateLeadData(lead);
	 }
}
