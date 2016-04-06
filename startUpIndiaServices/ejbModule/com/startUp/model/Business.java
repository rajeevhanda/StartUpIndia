package com.startUp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="startup_businesses")
public class Business implements Serializable {
	@Id
	@Column(name="business_id")
	private int businessId;
	@Column(name="business_name")
	private String businessName;
	public int getBusinessId() {
		return businessId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	
}
