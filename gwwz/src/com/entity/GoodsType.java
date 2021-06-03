package com.entity;

import java.io.Serializable;

/**
 * 
 */
public class GoodsType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1375311480540008781L;
	private	int typeId;
	private String typeName;	
	public int getTypeId() {
		return typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}	
}
