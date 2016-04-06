document.getElementById("acceptCheckbox").onclick = function() {
	if (document.getElementById("acceptCheckbox").checked == true) {
		document.getElementById("certificationForm").style.display = "block";
	}
	if (document.getElementById("acceptCheckbox").checked == false) {
		document.getElementById("certificationForm").style.display = "none";
	}
};
