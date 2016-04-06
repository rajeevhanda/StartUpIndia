package com.startUp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "startup_address_details")
public class AddressDetails implements Serializable {

	@Id
	@Column(name = "address_id",columnDefinition="number(12)")
	@GeneratedValue(generator="addressIdGenerator")
	@SequenceGenerator(name="addressIdGenerator",sequenceName="startUp_address_id_sequence",initialValue=1100000001)
	private long addressDetailId;
	@Column(name = "street1", length = 50)
	private String street1;
	@Column(name = "street2", length = 50)
	private String street2;
	@Column(name = "zip_code", columnDefinition = "Number(6)", nullable = false)
	private int zipCode;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_no", nullable = false)
	private Account account;

	public AddressDetails() {
	}

	public long getAddressDetailId() {
		return addressDetailId;
	}

	public void setAddressDetailId(long addressDetailId) {
		this.addressDetailId = addressDetailId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
