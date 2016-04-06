<%@page import="com.startUp.model.State"%>
<%@page import="com.startUp.model.City"%>
<%@page import="java.util.Locale"%>
<%@page import="com.startUp.model.Nationality"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ResourceBundle"%>
<%@include file="resourceBundleInitialization.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Add Details</title>



<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/agency.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<script type="text/javascript">
	function validateDOB(dob) {
		var today = new Date();
		var dateOfBirth = new Date(dob);
		var age = today.getFullYear() - dateOfBirth.getFullYear();
		if (age > 18) {

			return true;
		} else {
			document.getElementById("invalidDOB").style.color = "red"
			document.getElementById("invalidDOB").innerHTML = "You are not Eligible";
			return false;
		}
	}
</script>
</head>
<body id="page-top" class="index" style="text-align: center;">

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top"
		style="background-color:#222;border-color:transparent;">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand page-scroll" href="#page-top">StartUp
				India StandUp India</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav navbar-right">
			<li class="hidden"><a href="#page-top"></a></li>
			<li><a class="page-scroll" href="../jsps/home.jsp">Home</a></li>
			<li><a class="page-scroll" href="#login">Login/Register</a></li>
			<li><a class="page-scroll" href="#about">About</a></li>
			<li><a class="page-scroll" href="#">Messages</a></li>

			<li><a class="page-scroll" href="../jsps/logout.jsp">Logout</a>
			</li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>


	<%
		ArrayList<Nationality> nationalitiesList = (ArrayList<Nationality>) session
				.getAttribute("nationalitiesList");
		ArrayList<City> citiesList = (ArrayList<City>) session
				.getAttribute("citiesList");
		ArrayList<State> statesList = (ArrayList<State>) session
				.getAttribute("statesList");
	%>
	<%
		if (session.getAttribute("account") != null) {
	%>
	<section id="contactDetails" style="padding-top:120px;">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h2 class="section-heading">Contact Details</h2>
					<div class="form-group">
						<form action="addContactDetailsAction" method="post">
							<input placeholder="<%=bundle.getString("mobileLabel")%>" type="text"  class="form-control" maxlength="12" name="mobileNoField" required="required" /><br>
							<input type="text" placeholder="<%=bundle.getString("landlineLabel")%>" class="form-control" maxlength="13" name="phoneNoField" /><br>
							<input type="text" name="faxNoField" placeholder="<%=bundle.getString("faxLabel")%>" class="form-control" /><br>
							<center><button type="submit" class="btn btn-xl">Save</button></center>
						</form>					
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<h2 class="section-heading">Address Details</h2>
						<form action="addAddressDetailsAction" name="addressForm">
							<input type="text" placeholder="<%=bundle.getString("Street1Label")%>" class="form-control" name="street1Field" required="required" /><br />
							<input type="text" placeholder="<%=bundle.getString("Street2Label")%>" class="form-control"  name="street2Field" required="required" /><br />
							<input type="text" placeholder="<%=bundle.getString("ZipcodeLabel")%>" class="form-control"  name="zipCodeField" required="required" /><br />
							<select name="stateField" class="form-control" onchange="getCitiesFromStates()">
								<option selected="selected" value="-1">Select State</option>
								<%
									for (int i = 0; i < statesList.size(); i++) {
								%>
								<option value="<%=statesList.get(i).getStateId()%>"><%=statesList.get(i).getStateName()%></option>
								<%
								}
								%>
							</select><br /> 
							<select name="cityField" id="cityField" class="form-control">
								<option value=-1 selected="selected">Select City</option>
								<%
									for (int i = 0; i < citiesList.size(); i++) {
								%>
								<option value="<%=citiesList.get(i).getCityId()%>"><%=citiesList.get(i).getCityName()%></option>
								<%
									}
								%>
							</select><br /> 
							<center><button class="btn btn-xl" type="submit">Save</button></center>
						</form>						
					</div>
				</div>
			</div>
		</div>
	</section>
		
	<%
		} else {
			request.getRequestDispatcher("login.jsp").forward(request,
					response);
		}
	%>

	<!-- jQuery -->
	<script src="/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="../js/jqBootstrapValidation.js"></script>
	<script src="../js/contact_me.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../js/agency.js"></script>

	<!-- Validation scripts -->

	<script type="text/javascript"
		src="../ValidationScripts/getCitiesFromStates.js"></script>

	<!-- End of Validation Scripts -->
</body>
</html>