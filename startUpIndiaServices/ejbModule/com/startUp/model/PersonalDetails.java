package com.startUp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Startup_Personal_Details")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonalDetails implements Serializable {
	@Id
	@Column(name = "personal_detail_id", columnDefinition = "Number(12)")
	@GeneratedValue(generator = "personalGenerator")
	@SequenceGenerator(name = "personalGenerator", sequenceName = "startUp_personal_id_sequence")
	private long personalDetailId;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "father_name")
	private String fatherName;
	@Column(name = "mother_name")
	private String motherName;
	@Column(name = "date_of_birth", nullable = false)
	private Date dateOfBirth;
	@Column(name = "gender", nullable = false)
	private String gender;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nationality_id", nullable = false)
	Nationality nationality;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_no", nullable = false)
	private Account account;

	public PersonalDetails() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getPersonalDetailId() {
		return personalDetailId;
	}

	public void setPersonalDetailId(long personalDetailId) {
		this.personalDetailId = personalDetailId;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
