package com.uam.util;

import javax.validation.constraints.Size;

public class UserRequest {
	
	
	private String mobile;
	
	private String  latitude;
	private String longitude;
	private String status;
	private long userId;
	
	//@Size(min=10, max=10 ,message = "Length should be 10.")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	

}
