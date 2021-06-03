package com.entity;

import java.io.Serializable;

/**
 * 
 */
public class OrderInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1046015297426283124L;
	private int orderId;
	private int customerId;
	private int status;	
	private String orderTime;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public int getStatus() {
		return status;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public void setStatus(int status) {
		this.status = status;
	}



}
