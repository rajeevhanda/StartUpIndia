package com.startUp.applicant.actions;

import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.startUp.applicant.services.LoginServiceRemote;
import com.startUp.applicant.services.RegionServiceRemote;
import com.startUp.model.Account;

public class LoginAction extends ActionSupport implements ModelDriven<Account>,SessionAware {
	Account account;
	Map<String,Object> sessionMap;
	public String execute() {
		account.setType("applicant");
		try {
			InitialContext ic = new InitialContext();
			LoginServiceRemote loginRemote = (LoginServiceRemote) ic.lookup("LoginService/remote");
			Account a = loginRemote.validateLogin(account);
			if(a != null) {
				sessionMap.put("account", a);
				RegionServiceRemote regionRemote = (RegionServiceRemote) ic.lookup("RegionService/remote");
				regionRemote.getNationalitites();
				return SUCCESS;
			} else {
				sessionMap.put("loginError","Invalid Login Credentials");
				return INPUT;
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	@Override
	public Account getModel() {
		account = new Account();
		return account;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}

}
