package com.startUp.applicant.actions;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.startUp.applicant.services.AddDetailsServiceRemote;
import com.startUp.model.Account;
import com.startUp.model.Business;
import com.startUp.model.BusinessDetails;

public class AddBusinessDetailsAction extends ActionSupport implements
		ServletRequestAware, ModelDriven<BusinessDetails> {

	HttpServletRequest request;
	BusinessDetails businessDetails;
	int businessField;
	

	

	public String execute() {
		ArrayList<Business> businessList=(ArrayList<Business>) request.getSession().getAttribute("businessList");
		for(int i=0;i<businessList.size();i++)
		{
			System.out.println(businessList.get(i).getBusinessName());
			if(businessList.get(i).getBusinessId()==businessField)
			{
				Business business=new Business();
				business.setBusinessName(businessList.get(i).getBusinessName());
				business.setBusinessId(businessList.get(i).getBusinessId());
				businessDetails.setBusiness(business);
				break;
			}
		}
		try {
			InitialContext ic = new InitialContext();
			AddDetailsServiceRemote remote = (AddDetailsServiceRemote) ic
					.lookup("AddDetailsService/remote");
			businessDetails.setAccount((Account)request.getSession().getAttribute("account"));
			System.out.println(businessDetails.getBusinessIdeaName());
			System.out.println(businessDetails.getBusinessDescription());
			System.out.println(businessDetails.getEstimatedEarning());
			System.out.println(businessDetails.getGrowthPerspective());
			System.out.println(businessField);
			System.out.println(businessDetails.getProposedBudget());
			System.out.println(businessDetails.getTargetAudience());
			if (remote.addBusinessDetails(businessDetails)) {
				return SUCCESS;
			} else {
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	public BusinessDetails getBusinessDetails() {
		return businessDetails;
	}

	public void setBusinessDetails(BusinessDetails businessDetails) {
		this.businessDetails = businessDetails;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	@Override
	public BusinessDetails getModel() {
		businessDetails = new BusinessDetails();
		return businessDetails;
	}
	public int getBusinessField() {
		return businessField;
	}

	public void setBusinessField(int businessField) {
		this.businessField = businessField;
	}
}
