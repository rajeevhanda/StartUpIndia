package com.startUp.applicant.services;

import java.util.ArrayList;

import javax.ejb.Local;

import com.startUp.model.Account;

@Local
public interface UploadDocumentsServiceLocal {
	public ArrayList<String> getRequiredDocumentList(long accountNo);

	public void setDocumentStatus(long accountNo);
}
