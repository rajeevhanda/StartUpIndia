package com.startUp.applicant.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.startUp.applicant.services.UploadDocumentsServiceRemote;
import com.startUp.model.Account;
import com.startUp.model.Documents;

public class UploadDocumentsAction extends ActionSupport implements
		ModelDriven<Documents>, ServletRequestAware {

	private Documents documents;

	private File uidProof;
	private File photograph;
	private File addressProof;
	private File panCard;
	private File passport;
	private File locationRegistry;
	private File miscellaneous1;
	private File miscellaneous2;
	private File miscellaneous3;

	private String uidProofContentType;
	private String photographContentType;
	private String addressProofContentType;
	private String panCardContentType;
	private String passportContentType;
	private String locationRegistryContentType;
	private String miscellaneous1ContentType;
	private String miscellaneous2ContentType;
	private String miscellaneous3ContentType;

	private String uidProofFileName;
	private String photographFileName;
	private String addressProofFileName;
	private String panCardFileName;
	private String passportFileName;
	private String locationRegistryFileName;
	private String miscellaneous1FileName;
	private String miscellaneous2FileName;
	private String miscellaneous3FileName;

	private String destPath;

	public String execute() {
		destPath = "../startUpDocuments/";
		ArrayList<String> documentList = (ArrayList<String>) request
				.getSession().getAttribute("documentList");
		Account account = (Account) request.getSession()
				.getAttribute("account");
		Iterator<String> documentIterator = documentList.iterator();
		boolean flag = false;
		String var = request.getParameter("request_locale");
		ResourceBundle bundle = null;
		if (var == null) {
			Locale.setDefault(new Locale("en"));
			bundle = ResourceBundle
					.getBundle("com.startUp.applicant.resource.MessageBundle");
		} else {
			bundle = ResourceBundle
					.getBundle("com.startUp.applicant.resource.MessageBundle_"
							+ var);
		}
		while (documentIterator.hasNext()) {
			String document = documentIterator.next();
			if (getFile(document).length() <= 1048576
					&& verifyDocumentType(document)) {
				String destinationPath = destPath + document + "/";
				try {
					File destFile = new File(destinationPath,
							account.getAccountNo() + ".pdf");
					FileUtils.copyFile(getFile(document), destFile);
				} catch (IOException e) {
					return ERROR;
				}
			} else {
				flag = true;
				request.getSession().setAttribute(document + "Error",
						bundle.getString(document + "Error"));
			}
		}
		if (flag) {
			return INPUT;
		} else {
			try {
				InitialContext ic = new InitialContext();
				UploadDocumentsServiceRemote uploadRemote = (UploadDocumentsServiceRemote) ic
						.lookup("UploadDocumentsService/remote");
				uploadRemote.setDocumentStatus(account.getAccountNo());
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		}
	}

	private File getFile(String document) {
		if (document.equals("uidProof")) {
			return uidProof;
		} else if (document.equals("photograph")) {
			return photograph;
		} else if (document.equals("addressProof")) {
			return addressProof;
		} else if (document.equals("panCard")) {
			return panCard;
		} else if (document.equals("passport")) {
			return passport;
		} else if (document.equals("locationRegistry")) {
			return locationRegistry;
		} else if (document.equals("miscellaneous1")) {
			return miscellaneous1;
		} else if (document.equals("miscellaneous2")) {
			return miscellaneous2;
		} else if (document.equals("miscellaneous3")) {
			return miscellaneous3;
		} else {
			return null;
		}
	}

	private boolean verifyDocumentType(String document) {
		if (document.equals("uidProof")) {
			if (getUidProofContentType().equals("application/pdf")) {
				return true;
			} else {
				return false;
			}
		} else if (document.equals("photograph")) {
			if (getPhotographContentType().equals("application/pdf")) {
				return true;
			} else {
				return false;
			}
		} else if (document.equals("addressProof")) {
			if (getAddressProofContentType().equals("application/pdf")) {
				return true;
			} else {
				return false;
			}
		} else if (document.equals("panCard")) {
			if (getPanCardContentType().equals("application/pdf")) {
				return true;
			} else {
				return false;
			}
		} else if (document.equals("passport")) {
			if (getPassportContentType().equals("application/pdf")) {
				return true;
			} else {
				return false;
			}
		} else if (document.equals("locationRegistry")) {
			if (getLocationRegistryContentType().equals("application/pdf")) {
				return true;
			} else {
				return false;
			}
		} else if (document.equals("miscellaneous1")) {
			if (getMiscellaneous1ContentType().equals("application/pdf")) {
				return true;
			} else {
				return false;
			}
		} else if (document.equals("miscellaneous2")) {
			if (getMiscellaneous2ContentType().equals("application/pdf")) {
				return true;
			} else {
				return false;
			}
		} else if (document.equals("miscellaneous3")) {
			if (getMiscellaneous3ContentType().equals("application/pdf")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public File getLocationRegistry() {
		return locationRegistry;
	}

	public void setLocationRegistry(File locationRegistry) {
		this.locationRegistry = locationRegistry;
	}

	public String getLocationRegistryContentType() {
		return locationRegistryContentType;
	}

	public void setLocationRegistryContentType(
			String locationRegistryContentType) {
		this.locationRegistryContentType = locationRegistryContentType;
	}

	public String getLocationRegistryFileName() {
		return locationRegistryFileName;
	}

	public void setLocationRegistryFileName(String locationRegistryFileName) {
		this.locationRegistryFileName = locationRegistryFileName;
	}

	public Documents getDocuments() {
		return documents;
	}

	public void setDocuments(Documents documents) {
		this.documents = documents;
	}

	public File getUidProof() {
		return uidProof;
	}

	public void setUidProof(File uidProof) {
		this.uidProof = uidProof;
	}

	public File getPhotograph() {
		return photograph;
	}

	public void setPhotograph(File photograph) {
		this.photograph = photograph;
	}

	public File getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(File addressProof) {
		this.addressProof = addressProof;
	}

	public File getPanCard() {
		return panCard;
	}

	public void setPanCard(File panCard) {
		this.panCard = panCard;
	}

	public File getPassport() {
		return passport;
	}

	public void setPassport(File passport) {
		this.passport = passport;
	}

	public File getMiscellaneous1() {
		return miscellaneous1;
	}

	public void setMiscellaneous1(File miscellaneous1) {
		this.miscellaneous1 = miscellaneous1;
	}

	public File getMiscellaneous2() {
		return miscellaneous2;
	}

	public void setMiscellaneous2(File miscellaneous2) {
		this.miscellaneous2 = miscellaneous2;
	}

	public File getMiscellaneous3() {
		return miscellaneous3;
	}

	public void setMiscellaneous3(File miscellaneous3) {
		this.miscellaneous3 = miscellaneous3;
	}

	public String getUidProofContentType() {
		return uidProofContentType;
	}

	public void setUidProofContentType(String uidProofContentType) {
		this.uidProofContentType = uidProofContentType;
	}

	public String getPhotographContentType() {
		return photographContentType;
	}

	public void setPhotographContentType(String photographContentType) {
		this.photographContentType = photographContentType;
	}

	public String getAddressProofContentType() {
		return addressProofContentType;
	}

	public void setAddressProofContentType(String addressProofContentType) {
		this.addressProofContentType = addressProofContentType;
	}

	public String getPanCardContentType() {
		return panCardContentType;
	}

	public void setPanCardContentType(String panCardContentType) {
		this.panCardContentType = panCardContentType;
	}

	public String getPassportContentType() {
		return passportContentType;
	}

	public void setPassportContentType(String passportContentType) {
		this.passportContentType = passportContentType;
	}

	public String getMiscellaneous1ContentType() {
		return miscellaneous1ContentType;
	}

	public void setMiscellaneous1ContentType(String miscellaneous1ContentType) {
		this.miscellaneous1ContentType = miscellaneous1ContentType;
	}

	public String getMiscellaneous2ContentType() {
		return miscellaneous2ContentType;
	}

	public void setMiscellaneous2ContentType(String miscellaneous2ContentType) {
		this.miscellaneous2ContentType = miscellaneous2ContentType;
	}

	public String getMiscellaneous3ContentType() {
		return miscellaneous3ContentType;
	}

	public void setMiscellaneous3ContentType(String miscellaneous3ContentType) {
		this.miscellaneous3ContentType = miscellaneous3ContentType;
	}

	public String getUidProofFileName() {
		return uidProofFileName;
	}

	public void setUidProofFileName(String uidProofFileName) {
		this.uidProofFileName = uidProofFileName;
	}

	public String getPhotographFileName() {
		return photographFileName;
	}

	public void setPhotographFileName(String photographFileName) {
		this.photographFileName = photographFileName;
	}

	public String getAddressProofFileName() {
		return addressProofFileName;
	}

	public void setAddressProofFileName(String addressProofFileName) {
		this.addressProofFileName = addressProofFileName;
	}

	public String getPanCardFileName() {
		return panCardFileName;
	}

	public void setPanCardFileName(String panCardFileName) {
		this.panCardFileName = panCardFileName;
	}

	public String getPassportFileName() {
		return passportFileName;
	}

	public void setPassportFileName(String passportFileName) {
		this.passportFileName = passportFileName;
	}

	public String getMiscellaneous1FileName() {
		return miscellaneous1FileName;
	}

	public void setMiscellaneous1FileName(String miscellaneous1FileName) {
		this.miscellaneous1FileName = miscellaneous1FileName;
	}

	public String getMiscellaneous2FileName() {
		return miscellaneous2FileName;
	}

	public void setMiscellaneous2FileName(String miscellaneous2FileName) {
		this.miscellaneous2FileName = miscellaneous2FileName;
	}

	public String getMiscellaneous3FileName() {
		return miscellaneous3FileName;
	}

	public void setMiscellaneous3FileName(String miscellaneous3FileName) {
		this.miscellaneous3FileName = miscellaneous3FileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	@Override
	public Documents getModel() {
		documents = new Documents();
		return documents;
	}

	HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

}
