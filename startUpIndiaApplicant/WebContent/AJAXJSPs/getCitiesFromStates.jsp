<%@page import="com.startUp.model.City"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.startUp.applicant.services.RegionServiceRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%
System.out.println("Hello I ama here ");
	try
{
	InitialContext ic=new InitialContext();
	RegionServiceRemote remote=(RegionServiceRemote)ic.lookup("RegionService/remote");
	ArrayList<City>	cityList=remote.getCitiesByStateId(Integer.parseInt(request.getParameter("stateId")));
	response.setContentType("text/html");
	String buffer="<select name='cityField'><option value='-1'>Select</option>"; 
	for(int i=0;i<cityList.size();i++)
	{
		buffer+="<option value='"+cityList.get(i).getCityId()+"'>"+cityList.get(i).getCityName()+"</option>";
	}
	buffer+="</select>";
	out.println(buffer);
}
catch(Exception e)
{
	e.printStackTrace();
}
%>