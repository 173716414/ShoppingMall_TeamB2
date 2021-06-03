package com.entity;

public class ServiceAssessment {

	public int customerId;
	public int Id;
	public String serviceAssessment;
	public String assessmentTime;
	
	public String getAssessmentTime() {
		return assessmentTime;
	}
	public int getCustomerId() {
		return customerId;
	}
	public int getId() {
		return Id;
	}
	public String getServiceAssessment() {
		return serviceAssessment;
	}
	public void setAssessmentTime(String assessmentTime) {
		this.assessmentTime = assessmentTime;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setId(int Id) {
		this.Id =Id;
	}
	public void setServiceAssessment(String serviceAssessment) {
		this.serviceAssessment = serviceAssessment;
	}
	
}
