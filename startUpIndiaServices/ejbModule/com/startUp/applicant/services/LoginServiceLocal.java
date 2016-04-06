package com.startUp.applicant.services;

import javax.ejb.Local;

import com.startUp.model.Account;

@Local
public interface LoginServiceLocal {
	public Account validateLogin(Account account);
}
