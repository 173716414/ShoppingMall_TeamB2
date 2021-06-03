package com.entity;

/**
 * 
 */
public class SalesGoods implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4857361815892640071L;
	private int quantity; 
	private int goodsId; 
	
	public int getGoodsId() {
		return goodsId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
