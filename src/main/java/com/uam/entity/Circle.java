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
	@NamedQuery(name = "Circle.findCircleByLobId", query = " from Circle c where c.status  ='A' and c.lobMaster.id = :id")
	
})


@Entity
@Table(name="CIRCLE_MSTR")
public class Circle extends Domain<Integer> implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CIRCLE_MSTR_ID")
	private Integer id ;//circleMstrId;
	
	@Column(name="CIRCLE_ID")
	private Integer circleId;
	
	@Column(name="CIRCLE_NAME")
	private String circleName;
	
	@Column(name="STATUS")
	private char status;
	
	@ManyToOne
    @JoinColumn(name="LOB_ID" )
	private ProductLobMaster lobMaster;
	
	
	@OneToMany(mappedBy="circles" ,fetch = FetchType.LAZY)
	private List<ZoneMstr> zoneMstrs; 
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCircleId() {
		return circleId;
	}

	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public ProductLobMaster getLobMaster() {
		return lobMaster;
	}

	public void setLobMaster(ProductLobMaster lobMaster) {
		this.lobMaster = lobMaster;
	}

	/*public List<ZoneMstr> getZoneMstrs() {
		return zoneMstrs;
	}*/

	public void setZoneMstrs(List<ZoneMstr> zoneMstrs) {
		this.zoneMstrs = zoneMstrs;
	}
	
	
	
	
}
