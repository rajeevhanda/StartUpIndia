package com.startUp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "startup_institutes")
public class Institute implements Serializable {
	@Id
	@Column(name = "institute_id")
	private int instituteId;
	@Column(name = "institute_name",unique=true,nullable=false)
	private String instituteName;

	public Institute() {
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

}
