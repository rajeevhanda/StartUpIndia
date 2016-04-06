package com.startUp.applicant.services;

import javax.ejb.Remote;

import com.startUp.model.Account;

@Remote
public interface RegisterServiceRemote {
	public boolean registerApplicant(Account account);
	
	public boolean checkUsername(String username);
}
