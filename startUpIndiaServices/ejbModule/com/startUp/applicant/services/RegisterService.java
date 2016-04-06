package com.startUp.applicant.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.startUp.model.Account;
import com.startUp.model.City;
import com.startUp.model.ContactDetails;
import com.startUp.model.State;

/**
 * Session Bean implementation class RegisterService
 */
@Stateless
public class RegisterService implements RegisterServiceRemote,
		RegisterServiceLocal {

	/**
	 * Default constructor.
	 */
	public RegisterService() {

	}

	@PersistenceContext(unitName = "startUpIndiaUnit")
	EntityManager em;

	public boolean registerApplicant(Account account) {
		try {
			em.persist(account);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean checkUsername(String username) {
		Query query = em.createQuery("select a from Account a where a.userId='"
				+ username + "'");
		if (query.getResultList().size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
