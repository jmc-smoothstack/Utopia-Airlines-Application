import java.time.*;
import java.util.*;
public class flightRoute{


	String depAirport, arrAirport, depDate, arrDate="", day, month, year, hour, min, depTime, arrTime;
	int flightID, firstClass = 12, businessClass = 20, economyClass = 40; //temp holders 
	Vector<flight> tickets = new Vector<flight>(); 
	flightRoute(){}
	flightRoute(int flightID, String depAirport, String arrAirport, int month, int day, int year)
	{
		this.depAirport = depAirport;
		this.arrAirport = arrAirport;
		this.flightID = flightID; 
		this.day = Integer.toString(day);
		this.month = Integer.toString(month);
		this.year = Integer.toString(year);
		depDate = month + "/" + day + "/" + year;

		//sets number of available seats on flight 
	}

	public void setDepartureLocation(String airport){
		depAirport = airport;
	}

	public void setArrivalLocation(String airport){
		arrAirport = airport;

	}
	public void setFlightID(int id){
		flightID = id;
	}
	public String setDeparturTime(int hour, int min, int afternoon){ //AM = 0 and PM = 1
		
		String abrv = ""; //abrv = abreviation 
		switch(afternoon){
			case 0:
			abrv = "AM";
			case 1:
			abrv = "PM";
			default:
			//send error for abbreviation not recognized 
		}

		String sHour = Integer.toString(hour);
		String sMin = Integer.toString(min);

		depTime = sHour+":"+sMin+abrv;

		setArrivalTime(hour,min,afternoon);

		return depTime;
	}

	public void setArrivalTime(int hour, int min, int afternoon){

		//Add travle time to depTime. If the travel time exceeds time left in the day, for each time it does, increment day by correct number 
	}

	public void setSeatCount(){ //seat allocation 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of first class seats on this flight");
		firstClass = sc.nextInt();
		System.out.println("Enter number of business class seats on this flight");
		businessClass = sc.nextInt();
		System.out.println("Enter number of economy class seats on this flight");
		economyClass = sc.nextInt();
	}

	public void updateFlightTable(){
		Scanner sc = new Scanner(System.in);
		System.out.printf("You have chosen to view the Flight with Flight Id: %d and Flight Origin: %s and Flight Destination: %s.%n", flightID, depAirport, arrAirport); 
		System.out.println("Enter ‘quit’ at any prompt to cancel operation.\n");
		System.out.println("Please enter new Origin Airport and City or enter N/A for no change:");
		String input = sc.nextLine();
		System.out.println(input);
		if(input == "quit"){
			System.out.println("...quitting...");
		}else{
			depAirport = input;
			System.out.println("Please enter new Destination Airport and City or enter N/A for no change:");
			input = sc.nextLine();
			if(input == "quit"){
				System.out.println("...quitting...");
			}else{
				arrAirport = input; 
				System.out.println("Please enter new Departure Date {mm/dd/yyyy} or enter N/A for no change:");
				input = sc.nextLine();
				if(input == "quit"){
					System.out.println("...quitting...");
				}else{
					depDate = input; 
					System.out.println("Please enter new Departure Time {HH:MMPM or HH:MMAM} or enter N/A for no change");
					input = sc.nextLine();
					if(input == "quit"){
						System.out.println("...quitting...");
					}else{
						depTime = input;
						System.out.println("Please enter new Arrival Date or enter N/A for no change");
						input = sc.nextLine();
						if(input == "quit"){
							System.out.println("...quitting...");
						}else{
							arrDate = input;
							System.out.println("Please enter new Arrival Time or enter N/A for no change:");
							input = sc.nextLine();
							if(input == "quit"){
								System.out.println("...quitting...");
							}else{
								arrTime = input; 
							}
						}
					}
				}
			}
		}
		sc.close();
	}


	public void showDetails(){
		System.out.printf("You have chosen to view the Flight with Flight Id: %d and Departure Airport: %s and Arrival Airport: %s.%n", flightID, depAirport, arrAirport); 
		System.out.printf("Departure Airport: %s | Arrival Airport: %s | \nDeparture Date: %s | Departure Time: %s | \nArrival Date: E | Arrival Time: F %n", depAirport, arrAirport, depDate, depTime);
		System.out.printf("\nAvailable Seats by Class: \n1) First → %d \n2) Business → %d \n3) Economy → %d%n", firstClass, businessClass, economyClass);
	}

	public void editSeats(int i)
	{
		Scanner sc = new Scanner(System.in);
		int n;

		switch(i)
		{
			case 1:
			System.out.printf("First Class - Existing number of seats: %d \nEnter new number of seats", firstClass);
			firstClass = sc.nextInt();
			case 2:
			System.out.printf("Business Class - Existing number of seats: %d \nEnter new number of seats", businessClass);
			businessClass = sc.nextInt();
			case 3:
			System.out.printf("Economy Class - Existing number of seats: %d \nEnter new number of seats", economyClass);
			economyClass = sc.nextInt(); 
		}
	}

	public void addEntry(int membership, int flightClass){
		flightRoute copy = new flightRoute();
		copy.flightID = flightID;
		copy.depAirport = depAirport;
		copy.arrAirport = arrAirport;
		copy.depTime = depTime;
		copy.arrTime = arrTime;		
		tickets.add(new flight(copy, membership, flightClass));
	}

	public void removeEntry(int membership, int flightClass){
		int index = 0;

		for (flight entry : tickets)
		{
			if(entry.membershipID == membership)
			{
				if(entry.flightClass == flightClass)
				{
					tickets.remove(index); 
					System.out.println("ticket succesfully removed");
					return true; //break from for loop 
				}
			}
			index+=1; 
		}
		return false;
	}


	public static void main(String args[]){

		flightRoute fr = new flightRoute(1020,"PHL, Philadelphia","BWI, Baltimore",8,3,2021);

		fr.setDeparturTime(3,40,0);
		//System.out.println(fr.depTime);
		

	}
}