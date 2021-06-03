package com.entity;

import java.io.Serializable;

/**
 * 
 */
public class CustomerInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5839316917618844299L;
	private int id; 
	private String email; 
	private String pwd; 
	private String registerTime; 
	private int isCooled;
	
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	public int getIsCooled() {
		return isCooled;
	}
	public String getPwd() {
		return pwd;
	}
	public String getRegisterTime() {
		return registerTime;
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
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	
}
