package com.entity;

import java.io.Serializable;

/**
 * 
 */
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8427428986193438479L;
	private int id; 
	private int role; 
	private String userName; 
	private String userPwd; 
	
	public UserInfo() {
	}
	public UserInfo(String userName,String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}
	
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
		public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
