function loadXMLDoc() {
	var k = document.getElementById("userId").value;
	var xmlhttp;
	var urls = "../AJAXJSPs/verifyUserNameDuplicacy.jsp?userName=" + k;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState != 4) {
			document.getElementById("checkUserName").innerHTML = "checking";
		} else if (xmlhttp.readyState == 4) {
			var message=xmlhttp.responseText;
			if(message.trim()=="Yes")
				{
				document.getElementById("checkUserName").style.color="red";
				document.getElementById("checkUserName").innerHTML = "UserName Already Exists";			
				}
			else
				{
				document.getElementById("checkUserName").style.color = "green";
				document.getElementById("checkUserName").innerHTML = "<center><img src='../images/checkIcon.png'/ height='25px' width='25px'>"+"Good! Username is valid</center>";
				}
		
		}
	}
	xmlhttp.open("GET", urls, true);
	xmlhttp.send();
	return xmlhttp.responseText;
}