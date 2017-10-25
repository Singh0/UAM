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
	@NamedQuery(name = "CityZoneMstr.findCityZoneCodeByCitycode", query = " from CityZoneMstr cz where cz.status  ='A' and cz.cityMstrs.cityCode = :cityCode")
	
})


@Entity
@Table(name="CITY_ZONE_MSTR")
public class CityZoneMstr extends Domain<Integer> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CITY_ZONE_ID")
	private Integer id ;
	
	@Id
	@Column(name="CITY_ZONE_CODE")
	private String cityZoneCode;
	
	@Column(name="CITY_ZONE_NAME")
	private String CityZoneName;
	
	@Column(name="STATUS")
	private char status;
	
	@OneToMany(mappedBy ="cityZoneMstr" , fetch = FetchType.LAZY)
	private List<RsucodeMstr> rsucodeMstrs;
 	

	@ManyToOne
    @JoinColumn(name="CITY_CODE")
	private CityMstr  cityMstrs;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCityZoneCode() {
		return cityZoneCode;
	}
	public void setCityZoneCode(String cityZoneCode) {
		this.cityZoneCode = cityZoneCode;
	}
	public String getCityZoneName() {
		return CityZoneName;
	}
	public void setCityZoneName(String cityZoneName) {
		CityZoneName = cityZoneName;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public CityMstr getCityMstrs() {
		return cityMstrs;
	}
	public void setCityMstrs(CityMstr cityMstrs) {
		this.cityMstrs = cityMstrs;
	}
	public List<RsucodeMstr> getRsucodeMstrs() {
		return rsucodeMstrs;
	}
	public void setRsucodeMstrs(List<RsucodeMstr> rsucodeMstrs) {
		this.rsucodeMstrs = rsucodeMstrs;
	}
	
	
	
	
	
	

}
