package com.startUp.applicant.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.startUp.model.Business;
import com.startUp.model.City;
import com.startUp.model.Course;
import com.startUp.model.Institute;
import com.startUp.model.Nationality;
import com.startUp.model.State;

@Remote
public interface RegionServiceRemote {
	public ArrayList<Nationality> getNationalitites();

	public ArrayList<State> getStates();

	public ArrayList<City> getCities();

	public ArrayList<Institute> getInstitutes();

	public ArrayList<City> getCitiesByStateId(int stateId);

	public ArrayList<Business> getBusinesses();

	public ArrayList<Course> getCourses();
}
