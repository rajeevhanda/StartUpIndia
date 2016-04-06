<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<p style="text-align: right;"><a href="getLogoutAction">LOGOUT</a></p>
	<%
		if (session.getAttribute("account") != null) {
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
	%>
	<fieldSet>
		<legend>Upload Documents</legend>
		<form action="uploadDocumentsAction" method="post"
			enctype="multipart/form-data">
			<%
				ArrayList<String> documentList = (ArrayList<String>) session
							.getAttribute("documentList");
					Iterator<String> documentIterator = documentList.iterator();
					while (documentIterator.hasNext()) {
						String documentName = documentIterator.next();
						System.out.println(documentName);
			%>
			<%=bundle.getString(documentName + "Label")%>
			<input type="file" name="<%=documentName%>" required="required" /><br />
			<br />
			<%
				String error = (String) session.getAttribute(documentName
								+ "Error");
						session.removeAttribute(documentName + "Error");
						if (error != null) {
							out.println(error + "<br/>");
						}

					}
			%>
			<input type="submit" value="Upload" /><br/>
			<a href="getIndexAction">Home</a>
		</form>
	</fieldSet>
	<%
		} else {
			response.sendRedirect("getLoginAction");
		}
	%>
</body>
</html>