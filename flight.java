public class flight{

	String departureAirport, arrivalAirport, departureDate, arrivalDate, departureTime, arrivalTime;
	int flightID, membershipID, flightClass;


	flight(){	
	}


	flight(flightRoute fr, int membership, int flightClass){

		departureAirport = fr.depAirport;
		arrivalAirport = fr.arrAirport;
		departureDate = fr.depDate;
		departureTime = fr.depTime;
		arrivalDate = fr.arrTime; 
		arrivalTime = fr.arrTime; 
		flightID = fr.flightID;
		membershipID = membership;
		this.flightClass = flightClass;

	}

}