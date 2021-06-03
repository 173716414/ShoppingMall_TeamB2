package com.entity;

public class GoodsEvaluate {

	public int goodsId;
	public String goodsEvaluate;
	public String email;
	public String evaluateTime;
	
	public String getEmail() {
		return email;
	}
	public String getEvaluateTime() {
		return evaluateTime;
	}
	public String getGoodsEvaluate() {
		return goodsEvaluate;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEvaluateTime(String evaluateTime) {
		this.evaluateTime = evaluateTime;
	}
	public void setGoodsEvaluate(String goodsEvaluate) {
		this.goodsEvaluate = goodsEvaluate;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
}
