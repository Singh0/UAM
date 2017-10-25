package com.uam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedQueries({ 
	//@NamedQuery(name = "ProductMSTR.findByLobId", query = "  from ProductMSTR a where a.status  ='A' and a.lobMaster.id = :id"),
	@NamedQuery(name = "LeadData.findByMobile", query = " from LeadData l where  l.customer.customerMobile = :customerMobile")
	
})

@Entity
@Table(name="LEAD_DATA")
public class LeadData extends Domain<Long> implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LEAD_ID")
	private Long id;
	
	@Column(name ="REQUEST_TYPE")
	private Integer requesttype;
	
	@Column(name ="SOURCE")
	private Integer source;
	
	@Column(name ="SUB_SOURCE")
	private String subsource;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME")
	private Date createdAt;
	
	@Column(name="REMARKS")
	private String remarks;
	//private 
	@OneToOne //(cascade = CascadeType.MERGE)
    @JoinColumn(name="LEAD_STATUS_ID" , unique= true, nullable=true, insertable=true, updatable=true) 
	private LeadStatus leadStatus;
	
	@OneToOne //(cascade = CascadeType.MERGE)
    @JoinColumn(name="PRODUCT_ID" , unique= true, nullable=true, insertable=true, updatable=true) 
	private ProductMSTR productMSTR;
	
	@OneToOne //(cascade = CascadeType.MERGE)
    @JoinColumn(name="LEAD_PROSPECT_ID" ,  unique= true,insertable=true, updatable=true) 
	private LeadDataProspect leadDataProspect;
	
	@ManyToOne//(cascade = CascadeType.MERGE)
    @JoinColumn(name="PROSPECT_ID")
	private LeadDataCustomer customer;

	public Integer getRequesttype() {
		return requesttype;
	}

	public void setRequesttype(Integer requesttype) {
		this.requesttype = requesttype;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductMSTR getProductMSTR() {
		return productMSTR;
	}

	public void setProductMSTR(ProductMSTR productMSTR) {
		this.productMSTR = productMSTR;
	}

	public LeadStatus getLeadStatus() {
		return leadStatus;
	}

	public void setLeadStatus(LeadStatus leadStatus) {
		this.leadStatus = leadStatus;
	}

	public LeadDataProspect getLeadDataProspect() {
		return leadDataProspect;
	}

	public void setLeadDataProspect(LeadDataProspect leadDataProspect) {
		this.leadDataProspect = leadDataProspect;
	}

	public LeadDataCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(LeadDataCustomer customer) {
		this.customer = customer;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getSubsource() {
		return subsource;
	}

	public void setSubsource(String subsource) {
		this.subsource = subsource;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	
	
	
}
