package com.startUp.applicant.services;

import javax.ejb.Remote;

import com.startUp.model.Account;

@Remote
public interface LoginServiceRemote {
	public Account validateLogin(Account account); 
}
