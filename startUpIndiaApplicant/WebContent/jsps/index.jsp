<%@page import="java.util.ArrayList"%>
<%@page import="com.startUp.model.Account"%>
<%@page
	import="com.startUp.applicant.services.UploadDocumentsServiceRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p style="text-align: right;"><a href="getLogoutAction">LOGOUT</a></p>
	<%
		Account account = (Account) session.getAttribute("account");
		if (account != null) {
	%>
	<a href="addDetailsAction">Add Details</a><br/>
		<a href="addContactDetailsAction">Add Contact Details</a><br/>
	<a href="assetDetailsAction">Add Asset Details</a><br/>
	<a href="businessDetailAction">Add Business Details</a><br/>
	<a href="qualifyAction">Add Qualification</a><br/>

	<%
		InitialContext ic = new InitialContext();
			UploadDocumentsServiceRemote uploadRemote = (UploadDocumentsServiceRemote) ic
					.lookup("UploadDocumentsService/remote");
			ArrayList<String> documentList = uploadRemote
					.getRequiredDocumentList(account.getAccountNo());
			if (documentList.size() > 0) {
				session.setAttribute("documentList", documentList);
	%>
	<a href="getUploadDocuments">Upload Documents</a>
	<%
			}
		} else {
			response.sendRedirect("getLoginAction");
		}
	%>
</body>
</html>