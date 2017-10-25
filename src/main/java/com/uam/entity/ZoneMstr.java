package com.uam.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@NamedQueries({ 
	@NamedQuery(name = "ZoneMstr.findByCircleMstrId", query = " from ZoneMstr z where z.status  ='A' and z.circles.id = :id")
	
})


@Entity
@Table(name="ZONE_MSTR")
public class ZoneMstr extends Domain<Integer> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ZONE_ID")
	private Integer id ;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ZONE_CODE")
	private String zoneCode;
	
	@Column(name="ZONE_NAME")
	private String zoneName;
	
	@Column(name="STATUS")
	private char status;
	
	@OneToMany(mappedBy="zones" ,fetch = FetchType.LAZY)
	private List<CityMstr> cityMstrs; 
	
	
	
	@ManyToOne
    @JoinColumn(name="CIRCLE_MSTR_ID")
	private Circle circles;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	

	/*public List<CityMstr> getCityMstrs() {
		return cityMstrs;
	}*/

	public void setCityMstrs(List<CityMstr> cityMstrs) {
		this.cityMstrs = cityMstrs;
	}

	public Circle getCircles() {
		return circles;
	}

	public void setCircles(Circle circles) {
		this.circles = circles;
	}

	

}
