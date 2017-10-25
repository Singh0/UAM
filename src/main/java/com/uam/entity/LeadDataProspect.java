package com.uam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LEAD_PROSPECT_DETAIL")
public class LeadDataProspect extends Domain<Long> implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator = "SEQ_PROSPECTS_ID")
	//@GeneratedValue(strategy=GenerationType.TABLE  ,generator="LMS2.SEQ_PROSPECTS_ID")
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LeadDataProspect_SEQ")
		@SequenceGenerator(
			name="LeadDataProspect_SEQ",
			sequenceName="LMS2.SEQ_PROSPECTS_ID",
			allocationSize=20
		)
	@Column(name="LEAD_PROSPECT_ID")
	private Long id;
	
	@Column(name="LEAD_ID")
	private Long leadId;
	
	@Column(name="PRODUCT_LOB_ID")
	private Integer lobId;
	
	@Column(name="PROSPECT_ID")
	private Integer prospectId;
	
	@Column(name="CIRCLE_ID")
	private Integer circleId;
	
	@Column(name="ZONE_CODE")
	private String zone;
	
	@Column(name ="CITY_CODE")
	private String city;
	
	@OneToOne //(cascade = CascadeType.MERGE)
    @JoinColumn(name="CITY_ZONE_CODE" , unique= true, nullable=true, insertable=true, updatable=true) 
	private CityZoneMstr cityZone;
	
	@Column(name="PINCODE")
	private Integer pincode;
	
	@Column(name="RSU_CODE")
	private String ruscode;
	
	@Column(name="ADDRESS1")
	private String address1;
	
	@Column(name="ADDRESS2")
	private String address2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLeadId() {
		return leadId;
	}

	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}

	public Integer getLobId() {
		return lobId;
	}

	public void setLobId(Integer lobId) {
		this.lobId = lobId;
	}

	public Integer getCircleId() {
		return circleId;
	}

	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getRuscode() {
		return ruscode;
	}

	public void setRuscode(String ruscode) {
		this.ruscode = ruscode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public CityZoneMstr getCityZone() {
		return cityZone;
	}

	public void setCityZone(CityZoneMstr cityZone) {
		this.cityZone = cityZone;
	}

	public Integer getProspectId() {
		return prospectId;
	}

	public void setProspectId(Integer prospectId) {
		this.prospectId = prospectId;
	}
	
	

}
