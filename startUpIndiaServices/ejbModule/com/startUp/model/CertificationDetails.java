package com.startUp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "startup_certification_details")
public class CertificationDetails implements Serializable {

	@Id
	@GeneratedValue(generator = "startUpCertificateIdGen")
	@SequenceGenerator(name = "startUpCertificateIdGen", sequenceName = "startUp_Certification_Sequence", initialValue = 1100000001)
	@Column(name = "certification_Id", columnDefinition = "Number(12)")
	private long certicationId;
	@Column(name = "certificationNo", unique = true, nullable = false)
	private String certificationNo;
	@Column(name = "certification_name", nullable = false)
	private String certificationName;
	@Column(name = "dateOfIssue", nullable = false)
	private Date dateOfIssue;
	@Column(name = "dateOfExpiry", nullable = false)
	private Date dateOfExpiry;
	@Column(name = "issuingAuthority", nullable = false)
	private String issuingAuthority;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_no", nullable = false)
	private Account account;

	public CertificationDetails() {
		// TODO Auto-generated constructor stub
	}

	public long getCerticationId() {
		return certicationId;
	}

	public void setCerticationId(long certicationId) {
		this.certicationId = certicationId;
	}

	public String getCertificationNo() {
		return certificationNo;
	}

	public void setCertificationNo(String certificationNo) {
		this.certificationNo = certificationNo;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getIssuingAuthority() {
		return issuingAuthority;
	}

	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
