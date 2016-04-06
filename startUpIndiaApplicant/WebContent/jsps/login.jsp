<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StartUp India Client LogIn</title>
</head>
<body>
	<%
		String var = request.getParameter("request_locale");
		var = "en";
		ResourceBundle bundle = ResourceBundle
				.getBundle("com.startUp.applicant.resource.MessageBundle_"
						+ var);
	%>
	<%
		if (session.getAttribute("account") == null) {
	%>
	<div align="center">
		<h3>LogIn</h3>
		<form action="loginAction" method="post">
			<%=bundle.getString("loginIdLabel")%><input type="text" name="userId"
				key="loginIdLabel" /><br /> <br />
			<%=bundle.getString("passwordLabel")%><input type="password"
				name="password" key="passwordLabel" /><br /> <br />
			<%
				if (session.getAttribute("loginError") != null) {
			%>
			<%=bundle.getString("validateLoginErr")%><br/><br/>
			<%
				session.removeAttribute("loginError");
					}
			%>
			<input type="submit" value="LogIn" align="center" /> / <a
				href="getRegisterAction">Register for StartUp</a>
		</form>
	</div>
	<%
		} else {
			request.getRequestDispatcher("index.jsp").forward(request,
					response);
		}
	%>
</body>
</html>