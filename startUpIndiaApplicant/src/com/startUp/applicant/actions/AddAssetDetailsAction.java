package com.startUp.applicant.actions;

import java.util.ArrayList;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.startUp.applicant.services.AddDetailsServiceRemote;
import com.startUp.applicant.services.LoginServiceRemote;
import com.startUp.applicant.services.RegionServiceRemote;
import com.startUp.model.Account;
import com.startUp.model.AssetDetails;
import com.startUp.model.Business;

public class AddAssetDetailsAction extends ActionSupport implements
		ModelDriven<AssetDetails>, SessionAware {
	AssetDetails detail;
	int businessField;

	Map<String, Object> sessionMap;

	public String execute() {
		Account acc = (Account) sessionMap.get("account");
		ArrayList<Business> businessList=(ArrayList<Business>) sessionMap.get("businessList");
		Business business = new Business();
		try {
			InitialContext ic = new InitialContext();
			AddDetailsServiceRemote add = (AddDetailsServiceRemote) ic
					.lookup("AddDetailsService/remote");
			detail.setAccount(acc);
			for(int i=0;i<businessList.size();i++)
			{
				if(businessField==businessList.get(i).getBusinessId())
				{
					
					business.setBusinessId(businessField);
					business.setBusinessName(businessList.get(i).getBusinessName());
					break;
				}
			}
			detail.setBusiness(business);
			boolean a = add.addAssetDetails(detail);
			if (a == true)
				return SUCCESS;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;

	}

	@Override
	public AssetDetails getModel() {
		detail = new AssetDetails();
		return detail;
	}

	public AssetDetails getDetail() {
		return detail;
	}

	public void setDetail(AssetDetails detail) {
		this.detail = detail;
	}

	public int getBusinessField() {
		return businessField;
	}

	public void setBusinessField(int businessField) {
		this.businessField = businessField;
	}
}
