package com.startUp.applicant.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.startUp.model.Account;

@Remote
public interface UploadDocumentsServiceRemote {
	public ArrayList<String> getRequiredDocumentList(long accountNo);
	
	public void setDocumentStatus(long accountNo);
}
