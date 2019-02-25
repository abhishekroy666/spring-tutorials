
function validate(){
	
	var dob = document.f.dob.value;
	
	var tel = document.f.tel.value;
	if(tel.length!=10){
		alert("Telephone number should contain 10 digits")
		return false;
	}
	
	var pass = document.f.pass.value;
	if(pass.length<8){
		alert("Password should contain more than 8 characters");
		return false;
	}
	
	var cpass = document.f.cpass.value;
	if(pass!=cpass){
		alert("Please confirm password");
		return false;
	}
	
	return true;
	//alert("hi");
}