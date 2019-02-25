
function validate(){
	
	var tel = document.f.tel.value;
	if(tel.length!=10){
		alert("Telephone number should contain 10 digits")
		return false;
	}
	
	return true;
}

