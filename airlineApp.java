import java.util.*;

public class airlineApp{

	public static void showFlightList(Vector<flightRoute> fr)
	{
		int index = 1;
		for(flightRoute route : fr)
		{
			System.out.println(index+") " + route.depAirport + " → " + route.arrAirport);
			index += 1; 
		} 
		System.out.println(index + ") " + "Quit to previous");
	}


	public static int Menu(Vector<flightRoute> fr, Vector<flightRoute> routes){

		//Displays MAIN prompt 
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you");

		System.out.println("1) Employee / Agent \n2) Administrator \n3) Traveler");

		int input = sc.nextInt();

		switch(input)
		{
			case 1:
			//EMPLOYEE - EMP1 - Dispays Employee prompt EMP1 and accept input into input2 
			System.out.println("1) Enter Flights you Manage \n2) Quit to previous");
			int cont = sc.nextInt();
			 //Show all flights EMP2
			showFlightList(fr);
			int c2Input0 = sc.nextInt();  //flightRoute index in vector 
			//EMP3 
			System.out.println("1) View more details about the flight  \n2) Update the details of the Flight \n3) Add Seats to Flight");
			int c2Input1 = sc.nextInt(); 
			switch(c2Input1)
			{
				case 1: 
				//show flightRoute details for s specific flightRoute 
				fr.get(c2Input0-1).showDetails(); 
				case 2:
				//update flight table 
				fr.get(c2Input0-1).updateFlightTable(); 
				case 3:
				//change number of seats on flight 
				System.out.println("Pick the Seat Class you want to add seats of, to your flight:");
				System.out.println("1) First \n2) Business \n3) Economy \n4) Quit");
				int c2Input2 = sc.nextInt();
				fr.get(c2Input0-1).editSeats(c2Input2); 
			}
			case 2: 
			//ADMINISTRATOR 

			case 3:
			//TRAVELER 
			System.out.println("Enter your membership number");

			int membership = sc.nextInt(); //confirm valid id number 

			//TRAV1
			System.out.println("1) Book a Ticket \n2) Cancel an Upcoming Trip \n3) Quit");

			int c3Input0 = sc.nextInt();

			switch(c3Input0){
				case 1:
				//show flights  
				showFlightList(routes); 
				int t1Input0 = sc.nextInt();
				System.out.println("1) View Flight Details \n2) First \n3) Business \n4) Economy \n5) Quit to cancel operation");
				int fc = sc.nextInt();
				switch(fc){
					case 1:
					fr.get(t1Input0-1).showDetails(); 
					case 2:
					if(fr.get(t1Input0-1).firstClass < 0){
						System.out.println("No more seats are available"); 
					}else{							fr.get(t1Input0-1).firstClass -= 1;
						System.out.println("The seat you picked is available");
						fr.get(t1Input0-1).showDetails();
						fr.get(t1Input0-1).addEntry(membership, 1); 
					}
					case 3:
					if(fr.get(t1Input0-1).businessClass < 0){
						System.out.println("No more seats are available"); 
					}else{
						fr.get(t1Input0-1).businessClass -= 1;
						System.out.println("The seat you picked is available");
						fr.get(t1Input0-1).showDetails();
						fr.get(t1Input0-1).addEntry(membership, 2); 
					}
					case 4:
					if(fr.get(t1Input0-1).economyClass < 0){
						System.out.println("No more seats are available"); 
					}else{
						fr.get(t1Input0-1).economyClass -= 1;
						System.out.println("The seat you picked is available");
						fr.get(t1Input0-1).showDetails();
						fr.get(t1Input0-1).addEntry(membership, 3); 
					}
					case 5:
					//quit to cancle operation
				case 2:
				//CANCEL FLIGHT 
				//show flights  
				showFlightList(routes); 
				int t2Input0 = sc.nextInt();
				System.out.println("1) View Flight Details \n2) First \n3) Business \n4) Economy \n5) Quit to cancel operation");
				int fc = sc.nextInt();
				switch(fc){
					case 1:
					fr.get(t2Input0-1).showDetails(); 
					case 2:
					//remove entry from flights then add 1 to seat availability 
					if(fr.get(t2Input0-1).removeEntry(membership, 1)){
						fr.get(t2Input0-1).firstClass += 1; 
					}else{
						System.out.println("No first class entry found in system");
					}
					case 3:
					if(fr.get(t2Input0-1).removeEntry(membership, 2)){
						fr.get(t2Input0-1).businessClass += 1; 
					}else{
						System.out.println("No business class entry found in system");
					}
					case 4:
					if(fr.get(t2Input0-1).removeEntry(membership, 3)){
						fr.get(t2Input0-1).economyClass += 1; 
					}else{
						System.out.println("No economy class entry found in system");
					} 
					case 5:
					//quit to cancle operation
				case 3:
				//QUIT 
			}
		}
		sc.close();

		return 0;
	}
	public static void main(String args[]){
		Vector<flightRoute> routes = new Vector<flightRoute>();

		//flightRoute(String departure (departing city), String arrival (arrival city))
		routes.add(new flightRoute(1001,"PHL, PA", "LAX, CA", 8,3,2021));
		routes.add(new flightRoute(2021,"JFK, NY", "PDX, OR", 8,3,2021));
		routes.add(new flightRoute(2324,"BWI, MD", "MCI, MO", 8,3,2021));
		routes.add(new flightRoute(5435,"MIA, FL", "DFW, TX", 8,3,2021));
		routes.add(new flightRoute(8503,"SAN, CA", "SEA, WA", 8,3,2021));
		routes.add(new flightRoute(9053,"PHL, PA", "IAH, TX", 8,3,2021));
		routes.add(new flightRoute(0001,"ILG, DE", "PDX, OR", 8,3,2021));
		routes.add(new flightRoute(2343,"BWI, MD", "BUF, NY", 8,3,2021));
		routes.add(new flightRoute(6432,"TPA, FL", "OKC, OK", 8,3,2021));
		routes.add(new flightRoute(2635,"SFO, CA", "ATL, GA", 8,3,2021));

		//SORT VECTOR BY DEPARTURE CITY 
		showFlightList(routes);

		//Menu(); 
		

	}
}