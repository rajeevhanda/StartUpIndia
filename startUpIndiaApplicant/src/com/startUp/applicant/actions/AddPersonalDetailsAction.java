package com.startUp.applicant.actions;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.startUp.applicant.services.AddDetailsServiceRemote;
import com.startUp.model.Account;
import com.startUp.model.Nationality;
import com.startUp.model.PersonalDetails;

public class AddPersonalDetailsAction extends ActionSupport implements
		ModelDriven<PersonalDetails>, ServletRequestAware {
	PersonalDetails personalDetails;
	int nationalityField = 0;
	HttpServletRequest request = null;
	
	String dob = null;
	

	
	public String addPersonalDetails() {
		ArrayList<Nationality> nationalitiesList = (ArrayList<Nationality>) request.getSession()
				.getAttribute("nationalitiesList");
		Nationality nationality = new Nationality();
		for (int i = 0; i < nationalitiesList.size(); i++) {
			
			if (nationalitiesList.get(i).getNationalityId() == nationalityField) {
				nationality.setNationalityId(nationalityField);
				nationality.setNationalityName(nationalitiesList.get(i)
						.getNationalityName());
			}
		}
		personalDetails.setNationality(nationality);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			personalDetails.setDateOfBirth(new Date(dateFormat.parse(dob)
					.getTime()));
			System.out.println(dateFormat.parseObject(dob));
			System.out.println(new Date(dateFormat.parse(dob)
					.getTime()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		personalDetails.setAccount((Account) request.getSession().getAttribute("account"));
		try {
			InitialContext ic = new InitialContext();
			AddDetailsServiceRemote remote = (AddDetailsServiceRemote) ic
					.lookup("AddDetailsService/remote");
			if (remote.addPersonalDetails(personalDetails))
				return SUCCESS;
			else
				return "fail";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public int getNationalityField() {
		return nationalityField;
	}

	public void setNationalityField(int nationalityField) {
		this.nationalityField = nationalityField;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	@Override
	public PersonalDetails getModel() {
		personalDetails = new PersonalDetails();
		return personalDetails;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public AddPersonalDetailsAction() {
		// TODO Auto-generated constructor stub
	}

}
