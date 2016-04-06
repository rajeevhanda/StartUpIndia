function getCitiesFromStates() {
	var stateId = document.addressForm.stateField.value;
	var urls = "../AJAXJSPs/getCitiesFromStates.jsp?stateId=" + stateId;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	removeall();
	xmlhttp.onreadystatechange = function() {

		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var text = xmlhttp.responseText;
			document.getElementById("cityField").innerHTML=text;
		} 
	};
	xmlhttp.open("GET", urls, true);
	xmlhttp.send();
}
function removeall()
{

    var ct=document.addressForm.cityField.length;
    for(var i=ct; i>=0; i--)    {    
        document.addressForm.cityField.options[i]=null;
         }
}