
function validate(){
	
	var fromDate = document.f.fromdate.value;
	var toDate = document.f.todate.value;
	if(new Date(fromDate).getTime() > new Date(toDate).getTime()){
		alert("End date should be greater than start date");
		return false;
	}
	return true;
}