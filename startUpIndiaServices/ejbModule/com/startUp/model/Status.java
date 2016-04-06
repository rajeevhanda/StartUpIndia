package com.startUp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "startUp_status")
public class Status {
	@Id
	@GeneratedValue(generator = "startUpStatusGenerator")
	@SequenceGenerator(name = "startUpStatusGenerator", sequenceName = "startUp_status_id_sequence", initialValue = 1100000001)
	@Column(name = "status_id")
	private long statusId;
	@Column(name = "idea_status")
	private String ideaStatus;
	@Column(name = "document_status")
	private String documentStatus;
	@Column(name = "site_visit_status")
	private String siteVisitStatus;
	@Column(name = "bank_mapping_status")
	private String bankMappingStatus;
	@Column(name = "business_started_Date")
	private Date businessStartedDate;
	@Column(name = "last_vist_Date")
	private Date lastVisitDate;
	@Column(name = "next_visit_date")
	private Date nextVisitDate;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_no")
	private Account account;

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getIdeaStatus() {
		return ideaStatus;
	}

	public void setIdeaStatus(String ideaStatus) {
		this.ideaStatus = ideaStatus;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public Date getBusinessStartedDate() {
		return businessStartedDate;
	}

	public void setBusinessStartedDate(Date businessStartedDate) {
		this.businessStartedDate = businessStartedDate;
	}

	public Date getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public Date getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getSiteVisitStatus() {
		return siteVisitStatus;
	}

	public void setSiteVisitStatus(String siteVisitStatus) {
		this.siteVisitStatus = siteVisitStatus;
	}

	public String getBankMappingStatus() {
		return bankMappingStatus;
	}

	public void setBankMappingStatus(String bankMappingStatus) {
		this.bankMappingStatus = bankMappingStatus;
	}

}
