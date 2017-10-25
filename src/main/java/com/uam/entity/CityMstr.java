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
	@NamedQuery(name = "CityMstr.findCityByZoneCode", query = " from CityMstr cm where cm.status  ='A' and cm.zones.zoneCode = :zoneCode ")
	
})

@Entity
@Table(name="CITY_MSTR")
public class CityMstr extends Domain<Integer> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CITY_ID")
	private Integer id ;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CITY_CODE")
	private String cityCode;
	
	@Column(name="CITY_NAME")
	private String cityName;
	
	@Column(name="STATUS")
	private char status;
	
	
	@OneToMany(mappedBy="cityMstrs" ,fetch = FetchType.LAZY)
	private List<CityZoneMstr> cityZoneMstrs ; 
	
	
	@ManyToOne
    @JoinColumn(name="ZONE_CODE")
	private ZoneMstr zones;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	/*public List<CityZoneMstr> getCityZoneMstrs() {
		return cityZoneMstrs;
	}*/
	public void setCityZoneMstrs(List<CityZoneMstr> cityZoneMstrs) {
		this.cityZoneMstrs = cityZoneMstrs;
	}
	public ZoneMstr getZones() {
		return zones;
	}
	public void setZones(ZoneMstr zones) {
		this.zones = zones;
	}

	

}
