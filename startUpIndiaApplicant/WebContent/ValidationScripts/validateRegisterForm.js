function validateRegisterForm() {
	
	var password = document.registerForm.password.value;
	alert(password);
	var confirmPassword = document.registerForm.confirmPassword.value;
	var email = document.getElementById("email").value;
	var confirmEmail = document.getElementById("confirmEmail").value;
	var status = false;
	//----------Making a AJAX call to verify username--------//
	
	var userName = document.getElementById("userId").value;
	var xmlhttp;
	var urls = "../AJAXJSPs/verifyUserNameDuplicacy.jsp?userName=" + userName;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		 if (xmlhttp.readyState == 4) {
			 alert(xmlhttp.responseText);
			 if(xmlhttp.responseText.trim()=="No")
				 status=true;
			 else
				 status=false;
		}
	}
	xmlhttp.open("GET", urls, true);
	xmlhttp.send();
	
	//----------End Of AJAX Call--------//
	
	if (password == confirmPassword) {
		status = true;
	} else {
		document.getElementById("passwordLocation").innerHTML = "Confirm Password does not match Password";
		status = false;
	}
	if (email == confirmEmail)
		status = true;
	else {
		document.getElementById("emailLocation").style.color = "red";
		document.getElementById("emailLocation").innerHTML = "Confirm Email does not Match";
		status = false;
	}
	return status;
}