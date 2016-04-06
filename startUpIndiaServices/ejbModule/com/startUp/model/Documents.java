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

@Entity
@Table(name = "startUp_documents")
public class Documents implements Serializable {
	@Id
	@GeneratedValue(generator = "documentIdGenerator")
	@SequenceGenerator(name = "documentIdGenerator", sequenceName = "startUp_document_id_sequence", initialValue = 1100000001)
	@Column(name = "documents_id")
	private long documentsId;
	@Column(name = "uid_proof_status", columnDefinition = "varchar2(100) default 'required'")
	private String uidProofStatus;
	@Column(name = "address_proof_status", columnDefinition = "varchar2(100) default 'required'")
	private String addressProofStatus;
	@Column(name = "pan_card_status", columnDefinition = "varchar2(100) default 'required'")
	private String panCardStatus;
	@Column(name = "photograph_status", columnDefinition = "varchar2(100) default 'required'")
	private String photographStatus;
	@Column(name = "passport_status", columnDefinition = "varchar2(100) default 'notrequired'")
	private String passportStatus;
	@Column(name = "location_registry_status", columnDefinition = "varchar2(100) default 'notrequired'")
	private String locationRegistryStatus;
	@Column(name = "miscellaneous1_status", columnDefinition = "varchar2(100) default 'notrequired'")
	private String miscellaneous1Status;
	@Column(name = "miscellaneous2_status", columnDefinition = "varchar2(100) default 'notrequired'")
	private String miscellaneous2Status;
	@Column(name = "miscellaneous3_status", columnDefinition = "varchar2(100) default 'notrequired'")
	private String miscellaneous3Status;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_no", unique = true)
	private Account account;

	public Documents() {
		// TODO Auto-generated constructor stub
	}

	public long getDocumentsId() {
		return documentsId;
	}

	public void setDocumentsId(long documentsId) {
		this.documentsId = documentsId;
	}

	public String getUidProofStatus() {
		return uidProofStatus;
	}

	public void setUidProofStatus(String uidProofStatus) {
		this.uidProofStatus = uidProofStatus;
	}

	public String getAddressProofStatus() {
		return addressProofStatus;
	}

	public void setAddressProofStatus(String addressProofStatus) {
		this.addressProofStatus = addressProofStatus;
	}

	public String getPanCardStatus() {
		return panCardStatus;
	}

	public void setPanCardStatus(String panCardStatus) {
		this.panCardStatus = panCardStatus;
	}

	public String getPhotographStatus() {
		return photographStatus;
	}

	public void setPhotographStatus(String photographStatus) {
		this.photographStatus = photographStatus;
	}

	public String getPassportStatus() {
		return passportStatus;
	}

	public void setPassportStatus(String passportStatus) {
		this.passportStatus = passportStatus;
	}

	public String getLocationRegistryStatus() {
		return locationRegistryStatus;
	}

	public void setLocationRegistryStatus(String locationRegistryStatus) {
		this.locationRegistryStatus = locationRegistryStatus;
	}

	public String getMiscellaneous1Status() {
		return miscellaneous1Status;
	}

	public void setMiscellaneous1Status(String miscellaneous1Status) {
		this.miscellaneous1Status = miscellaneous1Status;
	}

	public String getMiscellaneous2Status() {
		return miscellaneous2Status;
	}

	public void setMiscellaneous2Status(String miscellaneous2Status) {
		this.miscellaneous2Status = miscellaneous2Status;
	}

	public String getMiscellaneous3Status() {
		return miscellaneous3Status;
	}

	public void setMiscellaneous3Status(String miscellaneous3Status) {
		this.miscellaneous3Status = miscellaneous3Status;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
