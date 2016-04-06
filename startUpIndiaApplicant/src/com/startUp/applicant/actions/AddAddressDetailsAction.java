package com.startUp.applicant.actions;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.startUp.applicant.services.AddDetailsServiceRemote;
import com.startUp.model.Account;
import com.startUp.model.AddressDetails;
import com.startUp.model.City;

public class AddAddressDetailsAction extends ActionSupport implements
		ServletRequestAware, ModelDriven<AddressDetails> {

	AddressDetails addressDetails;
	HttpServletRequest request;
	int cityField;
	String street1Field;
	String street2Field;
	int zipCodeField;

	public String addAddressDetails()
	{
		Account account=(Account)request.getSession().getAttribute("account");
		ArrayList<City> citiesList=(ArrayList<City>)request.getSession().getAttribute("citiesList");
		AddressDetails addressDetails=new AddressDetails();
		addressDetails.setAccount(account);
		addressDetails.setStreet1(street1Field);
		addressDetails.setStreet2(street2Field);
		addressDetails.setZipCode(zipCodeField);
		for(int i=0;i<citiesList.size();i++)
		{
			if(cityField==citiesList.get(i).getCityId())
			{
				City city=new City();
				city.setCityId(citiesList.get(i).getCityId());
				city.setCityName(citiesList.get(i).getCityName());
				city.setState(citiesList.get(i).getState());
				addressDetails.setCity(city);
				break;
			}
		}
		try
		{
			System.out.println(this);
			InitialContext ic=new InitialContext();
			AddDetailsServiceRemote remote=(AddDetailsServiceRemote)ic.lookup("AddDetailsService/remote");
			if(remote.addAddressDetails(addressDetails))
				return SUCCESS;
			else
				return INPUT;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getStreet1Field() {
		return street1Field;
	}

	public void setStreet1Field(String street1Field) {
		this.street1Field = street1Field;
	}

	public String getStreet2Field() {
		return street2Field;
	}

	public void setStreet2Field(String street2Field) {
		this.street2Field = street2Field;
	}

	public int getZipCodeField() {
		return zipCodeField;
	}

	public void setZipCodeField(int zipCodeField) {
		this.zipCodeField = zipCodeField;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	public int getCityField() {
		return cityField;
	}

	public void setCityField(int cityField) {
		this.cityField = cityField;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;

	}

	@Override
	public AddressDetails getModel() {
		addressDetails = new AddressDetails();
		return addressDetails;
	}

}
