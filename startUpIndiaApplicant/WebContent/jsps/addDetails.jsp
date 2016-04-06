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
	<p style="text-align: right;">
		<a href="getLogoutAction">LOGOUT</a>
	</p>

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
	<section id="login" style="padding-top:70px;">
	<div class="container">
		<div class="row" text-center>
			<div class="col-md-6"></div>
			<div class="col-md-6">
				<h2 class="section-heading">Personal Details</h2>
				<form action="addPersonalDetailsAction" method="post">
					<div class="form-group">
						<input type="text" name="firstName" class="form-control"
							placeholder="<%=bundle.getString("firstNameLabel")%>"
							required="required" pattern="[a-zA-Z]*" /><br /> <input
							type="text" name="middleName" class="form-control"
							placeholder="<%=bundle.getString("middleNameLabel")%>"
							pattern="[a-zA-Z]*" /><br /> <input type="text"
							class="form-control"
							placeholder="<%=bundle.getString("lastNameLabel")%>"
							name="lastName" pattern="[a-zA-Z]*" /> <br /> <input
							type="text" name="fatherName" class="form-control"
							placeholder="<%=bundle.getString("fatherNameLabel")%>"
							required="required" pattern="[a-zA-Z]*" /> <br /> <input
							type="text" name="motherName" class="form-control"
							placeholder="<%=bundle.getString("motherNameLabel")%>"
							required="required" pattern="[a-zA-Z]*" /> <br /> <input name="dob"
							type="text" id="datepicker1" class="form-control"
							placeholder="<%=bundle.getString("dobLabel")%>" onblur="(this.type='text')" onfocus="(this.type='date')"> <span
							id="invalidDOB"></span> <br /> <select
							class="form-control" name="nationalityField">
							<option value="-1"><%=bundle.getString("nationalityLabel")%></option>
							<%
								for (int i = 0; i < nationalitiesList.size(); i++) {
							%>
							<option value="<%=nationalitiesList.get(i).getNationalityId()%>"><%=nationalitiesList.get(i).getNationalityName()%></option>
							<%
								}
							%>
						</select><br /> 
						<%=bundle.getString("genderLabel")%>
						<div class="radio-inline"><input type="radio" name="gender" value="Male">Male</div>
						 <div class="radio-inline"><input type="radio" name="gender" value="Female">Female</div>
						 <div class="radio-inline"> <input type="radio"
							name="gender" value="Other">Other</div><br />
						<center>
							<button type="submit" class="btn btn-xl">Save</button>
						</center>
					
				</form>

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