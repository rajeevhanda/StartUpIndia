package com.startUp.applicant.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.startUp.model.AddressDetails;
import com.startUp.model.AssetDetails;
import com.startUp.model.BusinessDetails;
import com.startUp.model.CertificationDetails;
import com.startUp.model.ContactDetails;
import com.startUp.model.PersonalDetails;
import com.startUp.model.QualificationDetails;

/**
 * Session Bean implementation class AddDetailsService
 */
@Stateless
public class AddDetailsService implements AddDetailsServiceRemote,
		AddDetailsServiceLocal {

	public AddDetailsService() {

	}

	@PersistenceContext(unitName = "startUpIndiaUnit")
	EntityManager em;

	public boolean addPersonalDetails(PersonalDetails personalDetails) {
		try {
			em.persist(personalDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addAddressDetails(AddressDetails addressDetails) {
		try {
			em.persist(addressDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addCertificationDetails(
			CertificationDetails certificationDetails) {
		try {
			em.persist(certificationDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addQualificationDetails(
			QualificationDetails qualificationDetails) {
		try {
			em.persist(qualificationDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addContactDetails(ContactDetails contactDetails) {
		try {
			em.persist(contactDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addBusinessDetails(BusinessDetails businessDetails) {
		try {
			em.persist(businessDetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addAssetDetails(AssetDetails assetDetails) {
		try {
			em.persist(assetDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
