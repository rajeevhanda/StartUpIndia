package com.startUp.applicant.actions;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.startUp.applicant.services.AddDetailsServiceRemote;
import com.startUp.model.Account;
import com.startUp.model.ContactDetails;

public class AddContactDetailsAction extends ActionSupport implements
		ModelDriven<ContactDetails>, ServletRequestAware {

	ContactDetails contactDetails;
	HttpServletRequest request;
	long mobileNoField;
	long phoneNoField;
	long faxNoField;

	public String addContactDetails()
	{
		Account account=(Account)request.getSession().getAttribute("account");
		ContactDetails contactDetails=new ContactDetails();
		contactDetails.setAccount(account);
		contactDetails.setFaxNo(faxNoField);
		contactDetails.setMobileNo(mobileNoField);
		contactDetails.setPhoneNo(phoneNoField);
		try
		{
			InitialContext ic=new InitialContext();
			AddDetailsServiceRemote remote=(AddDetailsServiceRemote)ic.lookup("AddDetailsService/remote");
			if(remote.addContactDetails(contactDetails))
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
	 
	public long getMobileNoField() {
		return mobileNoField;
	}

	public void setMobileNoField(long mobileNoField) {
		this.mobileNoField = mobileNoField;
	}

	public long getPhoneNoField() {
		return phoneNoField;
	}

	public void setPhoneNoField(long phoneNoField) {
		this.phoneNoField = phoneNoField;
	}

	public long getFaxNoField() {
		return faxNoField;
	}

	public void setFaxNoField(long faxNoField) {
		this.faxNoField = faxNoField;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;

	}

	@Override
	public ContactDetails getModel() {
		contactDetails = new ContactDetails();
		return contactDetails;
	}

}
