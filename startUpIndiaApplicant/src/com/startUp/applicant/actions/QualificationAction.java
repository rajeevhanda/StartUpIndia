package com.startUp.applicant.actions;

import java.util.ArrayList;
import java.util.Map;

import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.startUp.applicant.services.AddDetailsService;
import com.startUp.applicant.services.AddDetailsServiceRemote;
import com.startUp.applicant.services.RegionServiceRemote;
import com.startUp.model.Account;
import com.startUp.model.Course;
import com.startUp.model.Institute;
import com.startUp.model.QualificationDetails;

public class QualificationAction extends ActionSupport implements
		ServletRequestAware, ModelDriven<QualificationDetails> {

	ArrayList<Institute> institutel;
	QualificationDetails qualification;
	String instituteName;
	int qualificationField;

	public QualificationAction() {
		System.out.println("QualificationAction.QualificationAction()");

		try {
			InitialContext ic = new InitialContext();
			RegionServiceRemote remote = (RegionServiceRemote) ic
					.lookup("RegionService/remote");
			institutel = remote.getInstitutes();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String setQualification() {
		ArrayList<Course> courseList=(ArrayList<Course>) request.getSession().getAttribute("courseList");
		for(int i=0;i<courseList.size();i++)
		{
			if(courseList.get(i).getCourseId()==qualificationField)
			{
				Course course=new Course();
				course.setCourseId(courseList.get(i).getCourseId());
				course.setCoursename(courseList.get(i).getCoursename());
				qualification.setCourse(course);
			}
		}
		System.out.println("QualificationAction.setQualification()");
		System.out.println(instituteName);
		Account accObj = (Account) request.getSession().getAttribute("account");
		qualification.setAccount(accObj);

		Institute instituteObj = null;

		for (Institute in : institutel) {
			if (in.getInstituteName().equals(instituteName.toLowerCase())) {
				instituteObj = in;
			}
		}

		qualification.setInstitute(instituteObj);
		System.out.println(instituteObj);
		System.out.println(qualification);
		System.out.println(instituteName);

		try {
			InitialContext i = new InitialContext();
			AddDetailsServiceRemote addDetailsServiceRemote = (AddDetailsServiceRemote) i
					.lookup("AddDetailsService/remote");
			boolean status = addDetailsServiceRemote
					.addQualificationDetails(qualification);
			System.out.println(status);

			if (status == true)
				return "success";

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "fail";

	}

	public String populate() {
		System.out.println("QualificationAction.populate()");
		return "success";
	}

	public String execute() {
		System.out.println("QualificationAction.execute()");
		return "success";
	}

	public ArrayList<Institute> getInstitutel() {
		return institutel;
	}

	public void setInstitutel(ArrayList<Institute> institutel) {
		this.institutel = institutel;
	}

	HttpServletRequest request;

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	@Override
	public QualificationDetails getModel() {
		qualification = new QualificationDetails();
		return qualification;
	}

	public QualificationDetails getQualification() {
		return qualification;
	}

	public void setQualification(QualificationDetails qualification) {
		this.qualification = qualification;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public int getQualificationField() {
		return qualificationField;
	}

	public void setQualificationField(int qualificationField) {
		this.qualificationField = qualificationField;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
