package com.uam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/*@NamedQueries({ 
	@NamedQuery(name = "Circle.findCircleByLobId", query = "Select c.id ,c.circleId ,c.circleName from Circle c where c.status  ='A' and c.lobMaster.id = :id")
	
})*/

@Entity
@Table(name="RSU_MSTR")
public class RsucodeMstr extends Domain<Integer> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RSU_ID")
	private Integer id ;
	
	@Column(name="RSU_CODE")
	private String rsuCode;
	
	@Column(name="STATUS")
	private char status;
	
	
	@ManyToOne
    @JoinColumn(name="CITY_ZONE_CODE")
	
	private CityZoneMstr cityZoneMstr;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRsuCode() {
		return rsuCode;
	}
	public void setRsuCode(String rsuCode) {
		this.rsuCode = rsuCode;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public CityZoneMstr getCityZoneMstr() {
		return cityZoneMstr;
	}
	public void setCityZoneMstr(CityZoneMstr cityZoneMstr) {
		this.cityZoneMstr = cityZoneMstr;
	}

	
}
