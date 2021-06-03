package com.entity;
import java.io.Serializable;
public class GoodsTypeDetail {

	private int typeId;
	private int id;
	private String typeDetailInfo;
	
	public int getId() {
		return id;
	}
	public String getTypeDetailInfo() {
		return typeDetailInfo;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTypeDetailInfo(String typeDetailInfo) {
		this.typeDetailInfo = typeDetailInfo;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	
}
