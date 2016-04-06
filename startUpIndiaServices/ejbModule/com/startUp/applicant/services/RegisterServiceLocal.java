package com.startUp.applicant.services;

import javax.ejb.Local;

import com.startUp.model.Account;

@Local
public interface RegisterServiceLocal {
	public boolean registerApplicant(Account account);

	public boolean checkUsername(String username);
}
