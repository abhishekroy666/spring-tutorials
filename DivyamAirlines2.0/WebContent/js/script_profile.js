
function validate(){
	
	var tel = document.f.tel.value;
	if(tel.length!=10){
		alert("Telephone number should contain 10 digits")
		return false;
	}
	
	var dob = document.f.dob.value;
	if(new Date(dob).getTime() < new Date().getTime()){
		alert("Please select a valid date of birth");
		return false;
	}
		
	return true;
}

