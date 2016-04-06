
	<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.startUp.applicant.services.RegisterServiceRemote"%>
<%@page import="javax.naming.InitialContext"%>
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
<%
	System.out.print(request.getParameter("stateId"));
	try
	{
		InitialContext ic=new InitialContext();
		RegisterServiceRemote remote=(RegisterServiceRemote)ic.lookup("RegisterService/remote");
		if(remote.checkUsername(request.getParameter("userName")))
		{	
			out.print("Yes");
			/* out.println("<span style='color:red;'>");
			out.print(bundle.getString("acceptedUserNameValidation"));
			out.print("</span>"); */
		}
		else
		{
			out.println("No");/* 
			out.print("<img src='../images/checkIcon.png'/ height='25px' width='25px''>"); */
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	%>
