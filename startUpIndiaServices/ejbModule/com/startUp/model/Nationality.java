package com.startUp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "startup_nationalities")
public class Nationality implements Serializable {
	@Id
	@GeneratedValue(generator="nationality_generator")
	@SequenceGenerator(name="nationality_generator",sequenceName="startup_nation_id_sequence",initialValue=1198)
	@Column(name = "nationality_id")
	private int nationalityId;
	@Column(name = "nationality_name",nullable=false,unique=true)
	private String nationalityName;

	public Nationality() {
	}

	public int getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getNationalityName() {
		return nationalityName;
	}

	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}
	
}
