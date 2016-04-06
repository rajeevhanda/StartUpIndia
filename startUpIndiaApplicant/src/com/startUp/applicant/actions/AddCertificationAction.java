package com.startUp.applicant.actions;

import java.text.SimpleDateFormat;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.startUp.applicant.services.AddDetailsServiceRemote;
import com.startUp.model.Account;
import com.startUp.model.CertificationDetails;

public class AddCertificationAction implements
		ModelDriven<CertificationDetails>,ServletRequestAware {

	CertificationDetails certificationDetails;
	String doi;
	String doe;

	public String addCertification() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		

			Account accObj=(Account) request.getSession().getAttribute("account");
			java.sql.Date dateOfIssue = new java.sql.Date(sdf.parse(doi).getTime());
			java.sql.Date dateOfExpiry = new java.sql.Date(sdf.parse(doe).getTime());

			certificationDetails.setDateOfExpiry(dateOfExpiry);
			certificationDetails.setDateOfIssue(dateOfIssue);
			certificationDetails.setAccount(accObj);
			System.out.println(certificationDetails);
			
	

			try {
				InitialContext ic = new InitialContext();

				AddDetailsServiceRemote addDetailsServiceRemote = (AddDetailsServiceRemote) ic
						.lookup("AddDetailsService/remote");
				
				boolean status=addDetailsServiceRemote.addCertificationDetails(certificationDetails);
				if(status==true)
				return "success";

			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			//e.printStackTrace();
		}
		
		

		return "fail";
	}

	@Override
	public CertificationDetails getModel() {
		certificationDetails = new CertificationDetails();
		return certificationDetails;
	}

	public CertificationDetails getCertificationDetails() {
		return certificationDetails;
	}

	public void setCertificationDetails(CertificationDetails certificationDetails) {
		this.certificationDetails = certificationDetails;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getDoe() {
		return doe;
	}

	public void setDoe(String doe) {
		this.doe = doe;
	}

	HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request=arg0;
		
	}

}
