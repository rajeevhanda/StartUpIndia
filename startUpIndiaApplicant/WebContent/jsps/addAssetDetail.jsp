<%@page import="com.startUp.model.Business"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@include file="resourceBundleInitialization.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

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


<title>Insert title here</title>
</head>
<body id="page-top" class="index" style=" padding-top: 70px;">
<!-- Navigation --> 
    <nav class="navbar navbar-default navbar-fixed-top" style="background-color:#222;border-color:transparent;margin-bottom:50px">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">StartUp India StandUp India</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Why Startup India</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#login">Login/Register</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">About</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#team">Team</a>
                    </li>
                    
                    <li>
                        <a class="page-scroll" href="#contact">Feedback</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

	<p style="text-align: right;">
		<a href="getLogoutAction">LOGOUT</a>
	</p>

	<%
		if (session.getAttribute("account") != null) {
	%>
	<%
	ArrayList<Business> businessList=(ArrayList<Business>)session.getAttribute("businessList");
%>
<section id="asset" style="padding-top:50px;">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
	
			</div>
			<div class="col-md-6" text-center>
				<center><h2 class="section-heading">Asset Details</h2></center>
				<div class="form-group">
					<form action="addAssetDetailsAction" method="post">
						<select name="businessField" class="form-control">
							<option value="-1">Select Existing Business</option>
							<%
								for(int i=0;i<businessList.size();i++) {
							%>
								<option value="<%=businessList.get(i).getBusinessId()%>"><%=businessList.get(i).getBusinessName()%></option>
								<%}
							%>
						</select><br/>
						<input type="text" name="movablesValue" placeholder="<%=bundle.getString("movablesValuetag")%>" class="form-control"/><br/>
						<input type="text" name="immovablesValue" placeholder="<%=bundle.getString("immovablesValuetag")%>" class="form-control"/><br/>
						<center><button type="submit" class="btn btn-xl">Save</button></center>
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
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="../js/classie.js"></script>
    <script src="../js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="../js/jqBootstrapValidation.js"></script>
    <script src="../js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/agency.js"></script>
	
</body>
</html>