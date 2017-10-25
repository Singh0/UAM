package com.uam.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({ 
	//@NamedQuery(name = "ProductMSTR.findByLobId", query = "  from ProductMSTR a where a.status  ='A' and a.lobMaster.id = :id"),
	//@NamedQuery(name = "LeadDataCustomer.findByMobile", query = " from LeadDataCustomer lc where  lc.customerMobile = :customerMobile")
	
})


@Entity
@Table(name="LEAD_PROSPECT_CUSTOMER")
public class LeadDataCustomer extends Domain<Integer> implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE  ,generator="LMS2.SEQ_PROSPECTS_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LEAD_PROSPECT_CUSTOMER_seq")
	@SequenceGenerator(
		name="LEAD_PROSPECT_CUSTOMER_seq",
		sequenceName="LMS2.SEQ_PROSPECTS_ID",
		allocationSize=20
	)
	@Column(name="PROSPECT_ID")
	private Integer id;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="PROSPECT_MOBILE_NUMBER")
	private String customerMobile;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name ="ALTERNATE_CONTACT_NUMBER")
	
	private String AltContactNo;
	
	@Column(name="LANDLINE_NUMBER")
	private String landLineNo;
	
	@Column(name ="PRIMARY_LANGUAGE")
	private String primaryLanguage;
	
	/*@OneToMany(mappedBy="customer" ,fetch = FetchType.LAZY)
	private List<LeadData> leadDatas;*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAltContactNo() {
		return AltContactNo;
	}

	public void setAltContactNo(String altContactNo) {
		AltContactNo = altContactNo;
	}

	public String getLandLineNo() {
		return landLineNo;
	}

	public void setLandLineNo(String landLineNo) {
		this.landLineNo = landLineNo;
	}

	public String getPrimaryLanguage() {
		return primaryLanguage;
	}

	public void setPrimaryLanguage(String primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}

	/*public List<LeadData> getLeadDatas() {
		return leadDatas;
	}

	public void setLeadDatas(List<LeadData> leadDatas) {
		this.leadDatas = leadDatas;
	}*/

}
