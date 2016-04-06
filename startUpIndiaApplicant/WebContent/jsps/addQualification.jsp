<%@page import="com.startUp.model.Course"%>
<%@page import="com.startUp.model.Institute"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@include file="resourceBundleInitialization.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

<title>Insert title here</title>


    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/agency.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>


		

</head>
<body  id="page-top" class="index">
<%@include file="navbarUserBegin.jsp" %>
<%
	ArrayList<Course> courseList=(ArrayList<Course>)session.getAttribute("courseList");

ArrayList<String> instituteList=(ArrayList<String>)session.getAttribute("instituteList");
Iterator<String>itr=instituteList.iterator();
%>
		<section id="qualificationDetails" style="padding-top:120px;">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h3 class="section-heading">Qualification Details</h3>
						<div class="form-group">
							<form action="qualificationAction" method="post">
								<select name="qualificationField"  class="form-control" >
									<option value="-1"><%=bundle.getString("qualificationName") %></option>
									<%
									for(int i=0;i<courseList.size();i++)
									{
									%>
									<option value="<%=courseList.get(i).getCourseId()%>"><%=courseList.get(i).getCoursename() %></option>	
									<%}
									%>
								</select><br>
								<select name="instituteName"  class="form-control" >
									<option value="-1"><%=bundle.getString("instituteName")%></option>
									<%while(itr.hasNext()){ %>
									<option><%=itr.next() %></option>
									<%} %>
								</select><br>
					
								<input type="text" class="form-control" name="yearOfPassing" placeholder="<%=bundle.getString("yop")%>"><br>
								<input type="text" class="form-control"  name="percentage" plcaeholder="<%=bundle.getString("percentage")%>"><br>
								<center><button class="btn btn-xl">Save</button></center>
								<input type="checkbox" name="acceptCheckbox" id="acceptCheckbox">Do you want to add any Certifications?
							</form>
						</div>
					</div>
					<div class="col-md-6" >
					
					<div id="certificationForm" style="display:none;">
					<h3 class="section-heading">Certification Details</h3>
						<form action="certifyAction" method="post">
							 <input type="text" name="certificationNo" placeholder="<%=bundle.getString("certificationNum")%>" class="form-control"><br>
							 <input type="text" name="certificationName" placeholder="<%=bundle.getString("certificationName")%>" class="form-control"><br>
						     <input type="text" name="doi" class="form-control"  placeholder="Date Of Issue" onfocus="this.type='date'" onblur="this.type='text'"/><br>
					 		 <input type="text" name="doe" class="form-control"   placeholder="Date Of Expiry" onfocus="this.type='date'" onblur="this.type='text'"/><br>
							 <input type="text" name="issuingAuthority" placeholder=" <%=bundle.getString("issuingAuthority")%>" class="form-control"><br>
							 <center><button class="btn btn-xl">Save</button></center>
					</form>
					</div>
					</div>
				</div>
			</div>
		</section>

    <!-- jQuery -->
    <script src="../js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="../js/classie.js"></script>
    <script src="../js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="../js/jqBootstrapValidation.js"></script>
    <script src="../js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/agency.js"></script>
    
    <script type="text/javascript" src="../ValidationScripts/displayCerificationForm.js"></script>



</body>
</html>