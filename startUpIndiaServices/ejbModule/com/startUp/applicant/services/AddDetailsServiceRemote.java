package com.startUp.applicant.services;

import javax.ejb.Remote;

import com.startUp.model.AddressDetails;
import com.startUp.model.AssetDetails;
import com.startUp.model.BusinessDetails;
import com.startUp.model.CertificationDetails;
import com.startUp.model.ContactDetails;
import com.startUp.model.PersonalDetails;
import com.startUp.model.QualificationDetails;

@Remote
public interface AddDetailsServiceRemote {
	public boolean addPersonalDetails(PersonalDetails personalDetails);

	public boolean addAddressDetails(AddressDetails addressDetails);

	public boolean addCertificationDetails(
			CertificationDetails CertificationDetails);

	public boolean addQualificationDetails(
			QualificationDetails QualificationDetails);

	public boolean addContactDetails(ContactDetails contactDetails);

	public boolean addBusinessDetails(BusinessDetails businessDetails);

	public boolean addAssetDetails(AssetDetails assetDetails);

}
