package com.entity;

import java.io.Serializable;

/**
 * 
 */
public class OrderGoodsInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8779136994885013146L;
	private int orderId; 
	private int goodsId; 
	private int quantity; 
	public int getGoodsId() {
		return goodsId;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
