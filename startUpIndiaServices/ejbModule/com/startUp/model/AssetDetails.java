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
@Table(name = "startUp_asset_details")
public class AssetDetails implements Serializable {
	@Id
	@Column(name = "asset_id", columnDefinition = "Number(12)")
	@GeneratedValue(generator = "assetDetailIdGenerator")
	@SequenceGenerator(name = "assetDetailIdGenerator", sequenceName = "asset_detail_id_sequence", initialValue = 1100000001)
	private long assetDetailId;
	@Column(name = "movables_value")
	private long movablesValue;
	@Column(name = "immovables_value")
	private long immovablesValue;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "business_id")
	private Business business;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_no")
	private Account account;

	public AssetDetails() {
	}

	public long getAssetDetailId() {
		return assetDetailId;
	}

	public void setAssetDetailId(long assetDetailId) {
		this.assetDetailId = assetDetailId;
	}

	public long getMovablesValue() {
		return movablesValue;
	}

	public void setMovablesValue(long movablesValue) {
		this.movablesValue = movablesValue;
	}

	public long getImmovablesValue() {
		return immovablesValue;
	}

	public void setImmovablesValue(long immovablesValue) {
		this.immovablesValue = immovablesValue;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}
}
