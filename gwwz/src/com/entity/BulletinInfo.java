package com.entity;

import java.io.Serializable;

public class BulletinInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7070681429262877608L;
	private int id;	
	private String title;	
	private String content;	
	private int userId;	
	private String createTime;
	public String getContent() {
		return content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public int getUserId() {
		return userId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
