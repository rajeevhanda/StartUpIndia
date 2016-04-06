package com.startUp.applicant.actions;

import java.util.ArrayList;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.startUp.applicant.services.RegionServiceRemote;
import com.startUp.model.Business;
import com.startUp.model.City;
import com.startUp.model.Course;
import com.startUp.model.Institute;
import com.startUp.model.Nationality;
import com.startUp.model.State;

public class PopulateDetailsAction extends ActionSupport implements
		ServletRequestAware {
	ArrayList<Nationality> nationalitiesList;
	ArrayList<City> citiesList;
	ArrayList<State> statesList;
	ArrayList<String> instituteList;

	HttpServletRequest request;

	public String execute() {
		populateNationalities();
		populateCities();
		populateStates();
		return SUCCESS;
	}

	public void populateCourses()
	{
		ArrayList<Course> courseList=new ArrayList<Course>();
		try
		{
			InitialContext ic=new InitialContext();
			RegionServiceRemote remote=(RegionServiceRemote)ic.lookup("RegionService/remote");
			courseList=remote.getCourses();
			request.getSession().setAttribute("courseList",courseList);
			System.out.println(courseList.get(0).getCoursename()+"----------------------------------");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String populateBusinesses()
	{
		ArrayList<Business> businessList=new ArrayList<Business>();
		try
		{
			InitialContext ic=new InitialContext();
			RegionServiceRemote remote=(RegionServiceRemote)ic.lookup("RegionService/remote");
			businessList=remote.getBusinesses();
			request.getSession().setAttribute("businessList",businessList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String populateInstitutes() {
			
		ArrayList<Institute> institutel = new ArrayList<Institute>();
		try {
			InitialContext ic = new InitialContext();
			RegionServiceRemote remote = (RegionServiceRemote) ic
					.lookup("RegionService/remote");
			institutel = remote.getInstitutes();
			instituteList = new ArrayList<>();
			for (Institute obj : institutel) {
				instituteList.add(obj.getInstituteName().toUpperCase());
			}
			request.getSession().setAttribute("instituteList", instituteList);
			populateCourses();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public String populateCities() {
		try {
			InitialContext ic = new InitialContext();
			RegionServiceRemote remote = (RegionServiceRemote) ic
					.lookup("RegionService/remote");
			citiesList = remote.getCities();
			request.getSession().setAttribute("citiesList", citiesList);
		} catch (Exception e) {

		}
		return SUCCESS;
	}

	public String populateStates() {
		try {
			InitialContext ic = new InitialContext();
			RegionServiceRemote remote = (RegionServiceRemote) ic
					.lookup("RegionService/remote");
			statesList = remote.getStates();
			String regex = "[a-z]";
			for (int i = 0; i < statesList.size(); i++) {
				Character replacement = (char) (statesList.get(i)
						.getStateName().charAt(0) - 32);
				statesList.get(i).setStateName(
						statesList.get(i).getStateName()
								.replaceFirst(regex, replacement.toString()));
				request.getSession().setAttribute("statesList", statesList);
			}
		} catch (Exception e) {

		}
		return SUCCESS;
	}

	public String populateNationalities() {
		try {
			InitialContext ic = new InitialContext();
			RegionServiceRemote remote = (RegionServiceRemote) ic
					.lookup("RegionService/remote");
			nationalitiesList = remote.getNationalitites();
			String regex = "[a-z]";
			for (int i = 0; i < nationalitiesList.size(); i++) {
				Character replacement = (char) (nationalitiesList.get(i)
						.getNationalityName().charAt(0) - 32);
				nationalitiesList.get(i).setNationalityName(
						nationalitiesList.get(i).getNationalityName()
								.replaceFirst(regex, replacement.toString()));
				request.getSession().setAttribute("nationalitiesList",
						nationalitiesList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public ArrayList<Nationality> getNationalitiesList() {
		return nationalitiesList;
	}

	public void setNationalitiesList(ArrayList<Nationality> nationalitiesList) {
		this.nationalitiesList = nationalitiesList;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	public ArrayList<City> getCitiesList() {
		return citiesList;
	}

	public void setCitiesList(ArrayList<City> citiesList) {
		this.citiesList = citiesList;
	}

	public ArrayList<State> getStatesList() {
		return statesList;
	}

	public void setStatesList(ArrayList<State> statesList) {
		this.statesList = statesList;
	}

	public ArrayList<String> getInstituteList() {
		return instituteList;
	}

	public void setInstituteList(ArrayList<String> instituteList) {
		this.instituteList = instituteList;
	}

}
