package com.uam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ 
	@NamedQuery(name = "LeadSubStatus.findLeadSubStatusByStatus", query = "Select s.leadSubStatusId ,s.subStatus ,s.subStatusDisplay from LeadSubStatus s where  s.lobId = :lobId and s.leadStatusId =:leadStatusId")
	
})

@Entity
@Table(name="LEAD_SUB_STATUS")
public class LeadSubStatus extends Domain<Integer> implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UNIQUE_ID")
	private Integer id;
	
	@Column(name="PRODUCT_LOB_ID")
	private Integer lobId;
	
	@Column(name="LEAD_STATUS_ID")
	private Integer leadStatusId;
	
	@Column(name="SUB_STATUS_ID")
	private Integer leadSubStatusId;
	
	@Column(name="SUB_STATUS")
	private String subStatus;
	
	@Column(name="LEAD_SUB_STATUS_DISPLAY")
	private String subStatusDisplay;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLobId() {
		return lobId;
	}
	public void setLobId(Integer lobId) {
		this.lobId = lobId;
	}
	public Integer getLeadStatusId() {
		return leadStatusId;
	}
	public void setLeadStatusId(Integer leadStatusId) {
		this.leadStatusId = leadStatusId;
	}
	public Integer getLeadSubStatusId() {
		return leadSubStatusId;
	}
	public void setLeadSubStatusId(Integer leadSubStatusId) {
		this.leadSubStatusId = leadSubStatusId;
	}
	public String getSubStatus() {
		return subStatus;
	}
	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}
	public String getSubStatusDisplay() {
		return subStatusDisplay;
	}
	public void setSubStatusDisplay(String subStatusDisplay) {
		this.subStatusDisplay = subStatusDisplay;
	}
	
	
}
