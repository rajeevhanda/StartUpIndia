<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%
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