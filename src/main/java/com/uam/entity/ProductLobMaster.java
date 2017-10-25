package com.uam.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@NamedQueries({ 
	@NamedQuery(name = "ProductMaster.findByLobId", query = "Select a from ProductLobMaster a where a.status  ='A' and a.id =?")
	
	
})

@NamedNativeQueries({ @NamedNativeQuery(name = "ProductMaster.findLob", 
query = "Select a.id,a.productLobName,a.status from ProductLobMaster a where a.status  ='A'") })

/**
 * The persistent class for the activity database table.
 * 
 */
@Entity
@Table(name="product_lob")
public class ProductLobMaster extends Domain<Integer> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_LOB_ID")
	private Integer id;
	
	@Column(name="PRODUCT_LOB")
	private  String productLobName;
	
	@Column(name="STATUS")
	private char status;
	
	@OneToMany(mappedBy="lobMaster" ,fetch = FetchType.LAZY)
	private List<ProductMSTR> productMSTR; 
	
	@OneToMany(mappedBy="lobMaster" ,fetch = FetchType.LAZY)
	private List<Circle> circle; 
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductLobName() {
		return productLobName;
	}
	public void setProductLobName(String productLobName) {
		this.productLobName = productLobName;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	/*public List<ProductMSTR> getProductMSTR() {
		return productMSTR;
	}*/
	public void setProductMSTR(List<ProductMSTR> productMSTR) {
		this.productMSTR = productMSTR;
	}
	/*public List<Circle> getCircle() {
		return circle;
	}*/
	public void setCircle(List<Circle> circle) {
		this.circle = circle;
	}
	
	
	
	

}
