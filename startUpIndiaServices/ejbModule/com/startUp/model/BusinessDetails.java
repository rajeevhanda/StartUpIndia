package com.startUp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.faces.el.FacesCompositeELResolver;

@Entity
@Table(name = "startup_business_details")
public class BusinessDetails implements Serializable {

	@Id
	@GeneratedValue(generator = "startUpBusinessNoGenerator")
	@SequenceGenerator(name = "startUpBusinessNoGenerator", sequenceName = "startUp_Business_Sequence", initialValue = 1100000001)
	@Column(name = "business_id")
	private long businessId;
	@Column(name = "Business_Idea_name")
	private String businessIdeaName;
	@Column(name = "Business_Description", columnDefinition = "varchar2(512)")
	private String businessDescription;
	@Column(name = "target_audience", nullable = false)
	private String targetAudience;
	@Column(name = "proposed_budget", nullable = false)
	private long proposedBudget;
	@Column(name = "estimated_earning", nullable = false)
	private long estimatedEarning;
	@Column(name = "growth_perspective", nullable = false)
	private String growthPerspective;
	@Column(name = "location_address", nullable = false)
	private String locationAddress;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "business_id")
	private Business business;

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_no", nullable = false)
	private Account account;

	public BusinessDetails() {

	}

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

	public String getBusinessIdeaName() {
		return businessIdeaName;
	}

	public void setBusinessIdeaName(String businessIdeaName) {
		this.businessIdeaName = businessIdeaName;
	}

	public String getBusinessDescription() {
		return businessDescription;
	}

	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}

	public String getTargetAudience() {
		return targetAudience;
	}

	public void setTargetAudience(String targetAudience) {
		this.targetAudience = targetAudience;
	}

	public long getProposedBudget() {
		return proposedBudget;
	}

	public void setProposedBudget(long proposedBudget) {
		this.proposedBudget = proposedBudget;
	}

	public long getEstimatedEarning() {
		return estimatedEarning;
	}

	public void setEstimatedEarning(long estimatedEarning) {
		this.estimatedEarning = estimatedEarning;
	}

	public String getGrowthPerspective() {
		return growthPerspective;
	}

	public void setGrowthPerspective(String growthPerspective) {
		this.growthPerspective = growthPerspective;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
