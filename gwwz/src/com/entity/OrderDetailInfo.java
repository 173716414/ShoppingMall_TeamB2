package com.entity;

import java.io.Serializable;

/**
 * 
 */
public class OrderDetailInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1046015297426283124L;
	private String addtime;
	private String remark;
	private int id;//物流 ID
	private int orderid;//
	
	

//物流内容
	public String getremark() {
		return remark;
	}
	public void setremark(String remark) {
		this.remark = remark;
	}
	//物流ID
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	//物流操作时间
	public String getaddtime() {
		return addtime;
	}
	public void setaddtime(String addtime) {
		this.addtime = addtime;
	}
	//物流操作时间
	public int getOrderId() {
		return orderid;
	}
	public void setOrderId(int orderid) {
		this.orderid = orderid;
	}

}
