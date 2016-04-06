package com.startUp.applicant.services;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.startUp.model.Business;
import com.startUp.model.City;
import com.startUp.model.Course;
import com.startUp.model.Institute;
import com.startUp.model.Nationality;
import com.startUp.model.State;

/**
 * Session Bean implementation class RegionService
 */
@Stateless
public class RegionService implements RegionServiceRemote, RegionServiceLocal {

	/**
	 * Default constructor.
	 */
	public RegionService() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "startUpIndiaUnit")
	EntityManager em;

	public ArrayList<Course> getCourses() {
		ArrayList<Course> courseList = new ArrayList<Course>();
		Query q = em.createQuery("select r from Course r");
		courseList = (ArrayList<Course>) q.getResultList();
		return courseList;
	}

	public ArrayList<Nationality> getNationalitites() {
		ArrayList<Nationality> nationalities = new ArrayList<>();
		Query q = em.createQuery("select n from Nationality n");
		nationalities = (ArrayList<Nationality>) q.getResultList();
		return nationalities;
	}

	public ArrayList<State> getStates() {
		ArrayList<State> states = new ArrayList<>();
		Query q = em.createQuery("select s from State s");
		states = (ArrayList<State>) q.getResultList();
		return states;
	}

	public ArrayList<City> getCities() {
		ArrayList<City> cities = new ArrayList<>();
		Query q = em.createQuery("select c from City c");
		cities = (ArrayList<City>) q.getResultList();
		return cities;
	}

	public ArrayList<Institute> getInstitutes() {
		ArrayList<Institute> institutes = new ArrayList<>();
		Query q = em.createQuery("select i from Institute i");
		institutes = (ArrayList<Institute>) q.getResultList();
		return institutes;
	}

	public ArrayList<City> getCitiesByStateId(int stateId) {
		ArrayList<City> cityList = new ArrayList<City>();
		Query q = em.createQuery("select r from City r where state_Id="
				+ stateId);
		cityList = (ArrayList<City>) q.getResultList();
		return cityList;
	}

	public ArrayList<Business> getBusinesses() {
		ArrayList<Business> businessList = new ArrayList<Business>();
		Query q = em.createQuery("select r from  Business r");
		businessList = (ArrayList<Business>) q.getResultList();
		return businessList;
	}
}
