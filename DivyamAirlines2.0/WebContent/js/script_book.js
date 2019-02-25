
function validate1(){
	
	var fromLocation = document.f.fromLocation.value;
	var toLocation = document.f.toLocation.value;
	
	if(fromLocation == toLocation){
		alert("Source and Destination must be different");
		return false;
	}
	
	var departureDate = document.f.flightDeparturedate.value;
	if(new Date(departureDate).getTime() < new Date().getTime()){
		alert("Departure date must be greater than or equal to current date");
		return false;
	}
	return true;
}