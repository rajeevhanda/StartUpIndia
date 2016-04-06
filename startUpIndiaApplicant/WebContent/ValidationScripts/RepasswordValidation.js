function validateRepassword()
{
	
	var password=document.getElementById("password").value;
	var confirmPassword=document.getElementById("confirmPassword").value;
	if(password==confirmPassword)
		{
			document.getElementById("passwordLocation").style.color="green";
			document.getElementById("passwordLocation").innerHTML="Password Matched";
		}
	else
		{
		document.getElementById("passwordLocation").style.color="red";
			document.getElementById("passwordLocation").innerHTML="Confirm Password does not match Password";
		status=false;
		}
	return status;
}