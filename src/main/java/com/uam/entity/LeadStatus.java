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
	@NamedQuery(name = "LeadStatus.findStatus", query = "Select s.id ,s.leadStatus ,s.leadStatusName ,s.leadStatusDisplay from LeadStatus s where s.id = :id")
	
})


@Entity
@Table(name="LEAD_STATUS")
public class LeadStatus extends Domain<Integer> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LEAD_STATUS_ID")
	private Integer id;
	
	@Column(name="LEAD_STATUS")
	private String leadStatus;
	
	@Column(name="LEAD_STATUS_NAME")
	private String leadStatusName;
	
	@Column(name="LEAD_STATUS_DISPLAY")
	private String leadStatusDisplay;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeadStatus() {
		return leadStatus;
	}
	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}
	public String getLeadStatusName() {
		return leadStatusName;
	}
	public void setLeadStatusName(String leadStatusName) {
		this.leadStatusName = leadStatusName;
	}
	public String getLeadStatusDisplay() {
		return leadStatusDisplay;
	}
	public void setLeadStatusDisplay(String leadStatusDisplay) {
		this.leadStatusDisplay = leadStatusDisplay;
	}
	

}
