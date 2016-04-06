package com.startUp.applicant.actions;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.startUp.applicant.services.RegisterServiceRemote;
import com.startUp.model.Account;

public class RegisterAction extends ActionSupport implements
		ModelDriven<Account> {

	private Account account;

	public RegisterAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String execute() {
		String email = account.getEmail();
		String password = account.getPassword();
		String confirmPassword = account.getConfirmPassword();
		boolean flag = false;
		if (!confirmPassword.equals(password)) {
			addFieldError("confirmPassword", getText("confirmPasswordErr"));
			flag = true;
		}
		if (flag) {
			return INPUT;
		}
		try {
			account.setType("applicant");
			InitialContext ic = new InitialContext();
			RegisterServiceRemote registerRemote = (RegisterServiceRemote) ic.lookup("RegisterService/remote");
			if(registerRemote.registerApplicant(account)) {
				return SUCCESS;
			} else {
				addActionError("UserId or Email Address Already Registered");
				return INPUT;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public Account getModel() {
		account = new Account();
		return account;
	}
}