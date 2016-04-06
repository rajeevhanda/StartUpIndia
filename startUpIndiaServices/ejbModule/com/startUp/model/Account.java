package com.startUp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "startup_account")
public class Account implements Serializable {
	@Id
	@GeneratedValue(generator = "startUpAccountNoGenerator")
	@SequenceGenerator(name = "startUpAccountNoGenerator", sequenceName = "startUp_Account_No_Sequence",initialValue=1100000001)
	@Column(name = "account_no")
	private long accountNo;
	@Column(name = "user_id", unique = true, nullable = false)
	private String userId;
	@Column(name = "password")
	private String password;
	transient private String confirmPassword;
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	transient private String confirmEmail;
	private String type;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
