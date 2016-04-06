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
@Table(name = "startup_qualification_details")
public class QualificationDetails implements Serializable {

	@Id
	@GeneratedValue(generator = "startUpQualIdGen")
	@SequenceGenerator(name = "startUpQualIdGen", sequenceName = "startUp_Qual_Id_Sequence", initialValue = 1100000001)
	@Column(name = "Qualification_Id", columnDefinition = "Number(12)")
	private long qualificationId;
	@Column(name = "yearOfPassing", nullable = false)
	private int yearOfPassing;
	@Column(name = "percentage", nullable = false)
	private double percentage;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institute_id", nullable = false)
	private Institute institute;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_no", nullable = false)
	private Account account;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	public QualificationDetails() {
		// TODO Auto-generated constructor stub
	}

	public long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

}
