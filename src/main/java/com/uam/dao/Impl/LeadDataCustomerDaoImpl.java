package com.uam.dao.Impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uam.dao.GenericDao;
import com.uam.dao.LeadDataCustomerDao;
import com.uam.entity.LeadDataCustomer;

@Component
public class LeadDataCustomerDaoImpl extends GenericDao<Integer, LeadDataCustomer> implements LeadDataCustomerDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@Override
	@Transactional
	public Integer leadDataCustomerSave(LeadDataCustomer leadDataCustomer) {

		
		try {
			//LeadDataCustomer leadDataCustomer2  = findByMobile(leadDataCustomer.getCustomerMobile());// findById(leadDataCustomer.getId(), LeadDataCustomer.class);
			//System.out.println(leadDataCustomer+"==================leadDataCustomer2=="+leadDataCustomer.getId());
			if(leadDataCustomer !=null && leadDataCustomer.getId() !=null && leadDataCustomer.getId() >0) {
				System.out.println("kjhakjshdkjsahdskj");
				merge(leadDataCustomer);
				return leadDataCustomer.getId();
			}else {
				//Integer integer  = (Integer)findSequence("LMS2.SEQ_PROSPECTS_ID");
				//System.out.println(integer);
				//leadDataCustomer.setId(integer);
				persist(leadDataCustomer);
				return  -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public LeadDataCustomer findByMobile(String mobile) {
		
		try {
			String hqlQuery   = "SELECT  lc from LeadDataCustomer lc where lc.customerMobile ='"+mobile+"'";
			return (LeadDataCustomer) findLatestData(hqlQuery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
	}

}
