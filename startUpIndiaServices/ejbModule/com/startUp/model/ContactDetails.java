package com.startUp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "startup_contact_details")
public class ContactDetails implements Serializable {
	@Id
	@Column(name = "contact_id",columnDefinition="Number(12)")
	@GeneratedValue(generator="contactIdGenerator")
	@SequenceGenerator(name="contactIdGenerator",sequenceName="startUp_contact_id_sequence",initialValue=1100000001)
	private long contactId;
	@Column(name = "phone_no", columnDefinition = "Number(13)")
	private long phoneNo;
	@Column(name = "mobile_no", columnDefinition = "Number(12)", nullable = false)
	private long mobileNo;
	@Column(name = "fax_no", columnDefinition = "Number(13)")
	private long faxNo;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_no")
	private Account account;

	public ContactDetails() {
		// TODO Auto-generated constructor stub
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(long faxNo) {
		this.faxNo = faxNo;
	}

}
