package com.uam.dao.Impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uam.dao.GenericDao;
import com.uam.dao.LeadDataDao;
import com.uam.dto.LeadDTO;
import com.uam.entity.LeadData;
import com.uam.entity.LeadDataProspect;

@Component
public class LeadDataDaoImpl  extends GenericDao<Long, LeadData>implements LeadDataDao {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	@Transactional
	public String leadUpdateAndSave(LeadData leadData) {
		try {
			LeadData leadData2  = findById(leadData.getId(), LeadData.class);
			if(leadData2 !=null && leadData2.getId() >0) {
				merge(leadData);
				return ""+leadData2.getId();
			}else {
				persist(leadData);
				return  null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}

	@Override
	public List<LeadData> retrievedLeadData(String leadId, String mobile) {
		// TODO Auto-generated method stub
		try {
			if(leadId !=null && leadId.length() ==14) {
				System.out.println("leadiiiii");
			LeadData leadData  = findById(Long.parseLong(leadId), LeadData.class);
			System.out.println("leadDataleadDataleadDataleadDataleadData==="+leadData);
			List<LeadData> datas  = new ArrayList<LeadData>();
			datas.add(leadData);
			return datas;
			}else if(mobile !=null && mobile.length() == 10){
				Map<String, Object> params  = new HashMap<String, Object>();
				params.put("customerMobile", mobile);
				return findByNamedQuery("LeadData.findByMobile" ,params ,0 ,3);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long fetchLeadSequenceId(String mobile) {
		// String mobile  = lead.getMobile();
		try {
			 long mobilin =  Long.parseLong(mobile);
			 BigInteger  bigInteger  = (BigInteger)findSequence("LMS2.SEQ_LEAD_ID");
			long NewleadId = Long.parseLong((mobilin/100000)+""+bigInteger.longValue());
			return NewleadId;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public LeadData findById(Long id) {
		// TODO Auto-generated method stub
		try {
			return findById(id, LeadData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}

	

}
