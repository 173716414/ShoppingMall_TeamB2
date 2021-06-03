package com.entity;

import java.io.Serializable;

/**
 * 
 */
public class ThirdInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5839316917618844299L;
	private int id; 
	private String email; 
	private String pwd; 
	private String registerTime; 
	private String phone; 
	private String address;
	private String thirdName; 
	private int isCooled;
	
	
	public String getthirdName() {
		return thirdName;
	}
	public void setthirdName(String thirdName) {
		this.thirdName = thirdName;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	public int getIsCooled() {
		return isCooled;
	}
	public String getPhone() {
		return phone;
	}
	public String getPwd() {
		return pwd;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIsCooled(int isCooled) {
		this.isCooled = isCooled;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	
}
