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

@NamedQueries({ 
	@NamedQuery(name = "ProductMSTR.findByLobId", query = "  from ProductMSTR a where a.status  ='A' and a.lobMaster.id = :id"),
	@NamedQuery(name = "ProductMSTR.findByName", query = "Select a.id ,a.productName from ProductMSTR a where a.status  ='A' and a.productName = :productName")
	
})

@Entity
@Table(name="product_mstr")
public class ProductMSTR extends Domain<Integer> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private Integer id;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="STATUS")
	private char status;
	
	@ManyToOne
    @JoinColumn(name="PRODUCT_LOB_ID" )
	private ProductLobMaster lobMaster;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
	
	

}
