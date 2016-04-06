package com.startUp.applicant.services;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.startUp.model.Account;
import com.startUp.model.Documents;

/**
 * Session Bean implementation class UploadDocumentsService
 */
@Stateless
public class UploadDocumentsService implements UploadDocumentsServiceRemote, UploadDocumentsServiceLocal {

	/**
	 * Default constructor.
	 */
	public UploadDocumentsService() {

	}

	@PersistenceContext
	EntityManager em;

	public ArrayList<String> getRequiredDocumentList(long accountNo) {
		ArrayList<String> documentList = new ArrayList<>();
		Query query = em.createQuery("select d from Documents d where account_no=" + accountNo);
		Iterator<Documents> documentIterator = query.getResultList().iterator();
		if (documentIterator.hasNext()) {
			Documents documents = documentIterator.next();
			if (documents.getUidProofStatus().equals("required")) {
				documentList.add("uidProof");
			}
			if (documents.getPhotographStatus().equals("required")) {
				documentList.add("photograph");
			}
			if (documents.getAddressProofStatus().equals("required")) {
				documentList.add("addressProof");
			}
			if (documents.getPanCardStatus().equals("required")) {
				documentList.add("panCard");
			}
			if (documents.getPassportStatus().equals("required")) {
				documentList.add("passport");
			}
			if (documents.getMiscellaneous1Status().equals("required")) {
				documentList.add("miscellaneous1");
			}
			if (documents.getMiscellaneous2Status().equals("required")) {
				documentList.add("miscellaneous2");
			}
			if (documents.getMiscellaneous3Status().equals("required")) {
				documentList.add("miscellaneous3");
			}
			if (documents.getLocationRegistryStatus().equals("required")) {
				documentList.add("locationRegistry");
			}
		}
		return documentList;
	}

	@Override
	public void setDocumentStatus(long accountNo) {
		Query query = em.createQuery("select d from Documents d where account_no=" + accountNo);
		Documents documents = (Documents) query.getSingleResult();
		String oldStatus = "required";
		String newStatus = "uploaded";
		if (documents.getUidProofStatus().equals(oldStatus)) {
			documents.setUidProofStatus(newStatus);
		}
		if (documents.getPanCardStatus().equals(oldStatus)) {
			documents.setPanCardStatus(newStatus);
		}
		if (documents.getPhotographStatus().equals(oldStatus)) {
			documents.setPhotographStatus(newStatus);
		}
		if(documents.getAddressProofStatus().equals(oldStatus)) {
			documents.setAddressProofStatus(newStatus);
		}
		if (documents.getPassportStatus().equals(oldStatus)) {
			documents.setPassportStatus(newStatus);
		}
		if (documents.getLocationRegistryStatus().equals(oldStatus)) {
			documents.setLocationRegistryStatus(newStatus);
		}
		if (documents.getMiscellaneous1Status().equals(oldStatus)) {
			documents.setMiscellaneous1Status(newStatus);
		}
		if (documents.getMiscellaneous2Status().equals(oldStatus)) {
			documents.setMiscellaneous2Status(newStatus);
		}
		if (documents.getMiscellaneous3Status().equals(oldStatus)) {
			documents.setMiscellaneous3Status(newStatus);
		}
	}

}
