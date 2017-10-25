package com.uam.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LeadDTO {

	
	
	@NotNull
	@NotBlank(message = "user name can't empty!")
	private String name;
	
	@NotNull
	@NotBlank(message = "mobile can't empty!")
	@Size(min=10, max=10 ,message = "Length should be 10.")
	private String mobile;
	private String lob;
	private String lobId;
	private String product;
	private String productId;
	private String circle;
	private String circleId;
	private String circleMstrId;
	private String pincode;
	private String rsucode;
	private String zone;
	private String zoneName;
	private String city;
	private String CityName;
	private String cityzone;
	private String cityZoneName;
	private String addressFirst;
	private String addressSecond;
	private String email;
	private String landlineNo;
	private String alternateNo;
	private String preferredLanguage;
	private String  source ;
	private String subSource;
	private String leadPriority;
	private String requestType;
	private String remark;
	private String leadStatus;
	private String leadStatusId;
	
	private String leadId;
	
	
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getLob() {
		return lob;
	}
	public void setLob(String lob) {
		this.lob = lob;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public String getCityZoneName() {
		return cityZoneName;
	}
	public void setCityZoneName(String cityZoneName) {
		this.cityZoneName = cityZoneName;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getRsucode() {
		return rsucode;
	}
	public void setRsucode(String rsucode) {
		this.rsucode = rsucode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityzone() {
		return cityzone;
	}
	public void setCityzone(String cityzone) {
		this.cityzone = cityzone;
	}
	public String getAddressFirst() {
		return addressFirst;
	}
	public void setAddressFirst(String addressFirst) {
		this.addressFirst = addressFirst;
	}
	public String getAddressSecond() {
		return addressSecond;
	}
	public void setAddressSecond(String addressSecond) {
		this.addressSecond = addressSecond;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLandlineNo() {
		return landlineNo;
	}
	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}
	public String getAlternateNo() {
		return alternateNo;
	}
	public void setAlternateNo(String alternateNo) {
		this.alternateNo = alternateNo;
	}
	public String getPreferredLanguage() {
		return preferredLanguage;
	}
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}
	public String getLeadPriority() {
		return leadPriority;
	}
	public void setLeadPriority(String leadPriority) {
		this.leadPriority = leadPriority;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLeadStatus() {
		return leadStatus;
	}
	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}
	public String getSubSource() {
		return subSource;
	}
	public void setSubSource(String subSource) {
		this.subSource = subSource;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getLobId() {
		return lobId;
	}
	public void setLobId(String lobId) {
		this.lobId = lobId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCircleMstrId() {
		return circleMstrId;
	}
	public void setCircleMstrId(String circleMstrId) {
		this.circleMstrId = circleMstrId;
	}
	public String getLeadStatusId() {
		return leadStatusId;
	}
	public void setLeadStatusId(String leadStatusId) {
		this.leadStatusId = leadStatusId;
	}
	
	
	
}
