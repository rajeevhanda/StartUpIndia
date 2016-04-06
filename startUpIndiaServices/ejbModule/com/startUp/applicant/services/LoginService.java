package com.startUp.applicant.services;

import java.util.Iterator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.startUp.model.Account;
import com.startUp.model.ContactDetails;

/**
 * Session Bean implementation class LoginService
 */
@Stateless
public class LoginService implements LoginServiceRemote, LoginServiceLocal {

	/**
	 * Default constructor.
	 */
	public LoginService() {

	}

	@PersistenceContext(unitName = "startUpIndiaUnit")
	EntityManager em;

	public Account validateLogin(Account account) {
		Query q = em.createQuery("select a from Account a where (userId='"
				+ account.getUserId() + "' or email='" + account.getUserId()
				+ "') and password='" + account.getPassword() + "' and type='"
				+ account.getType() + "'");
		Iterator<Account> accountIterator = q.getResultList().iterator();
		if (accountIterator.hasNext()) {
			return accountIterator.next();
		} else {
			return null;
		}
	}
	
	
}
