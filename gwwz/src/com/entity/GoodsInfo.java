package com.entity;

import java.io.Serializable;

/**
 * 
 */
public class GoodsInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8136745346533515865L;
	private int goodsId; 
	private String typeDetailInfo;
	private String goodsName; 
	private double price; 
	private float discount; 
	private int isNew; 
	private int isRecommend; 
	private int status; 
	private String photo; 
	private String remark;
	private int countRequire;
	private String createdate;
	private String userid;
	private int isCooled;
	private int count;

	
	
public String getUserid() {
		return userid;
	}	
public void setUserid(String userid) {
		this.userid = userid;
	}	
	
public int getIsCooled() {
		return isCooled;
	}
	public void setIsCooled(int isCooled) {
		this.isCooled = isCooled;
	}
	
	public int getCount() {
		return count;
	}

	public int getCountRequire() {
		return countRequire;
	}
	
	
	public String getCreatedate() {
		return createdate;
	}

	public float getDiscount() {
		return discount;
	}
	
	/**
	 * 
	 */
	public double getDiscountPrice() {
		double price = this.price*(this.discount/10.0);
		return price;
	}

	public int getGoodsId() {
		return goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}

	public int getIsNew() {
		return isNew;
	}

	public int getIsRecommend() {
		return isRecommend;
	}

	public String getPhoto() {
		return photo;
	}

	public double getPrice() {
		return price;
	}

	public String getRemark() {
		return remark;
	}

	public int getStatus() {
		return status;
	}

	public String getTypeDetailInfo() {
		return typeDetailInfo;
	}

	public void mySetCount(int count) {
		this.count = count;
	}

	public void setCountRequire(int countRequire) {
		this.countRequire = countRequire;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}

	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	public void setStatus(int status) {
		this.status = status;
	}

	public void setTypeDetailInfo(String typeDetailInfo) {
		this.typeDetailInfo = typeDetailInfo;
	}

}
