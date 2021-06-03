package com.entity;

import java.io.Serializable;

/**
 * 
 */
public class CustomerDetailInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1999250658277492011L;
	private int customerId; 
	private String name; 
	private String telphone;	
	private String movePhone;	
	private String address;	
	
	public String getAddress() {
		return address==null?"":address;
	}
	public int getCustomerId() {
		return customerId;
	}
	public String getMovePhone() {
		return movePhone==null?"":movePhone;
	}
	public String getName() {
		return name==null?"":name;
	}
	public String getTelphone() {
		return telphone==null?"":telphone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setMovePhone(String movePhone) {
		this.movePhone = movePhone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	
}
