package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;


import java.util.Scanner;


public class Main {
	static Plane newPlane;
	static Scanner scanner = new Scanner(System.in);
	static boolean exceptionThrown = false;
	static String exceptionName;
	static FlightRoute route;
	static int successfulSimulations;
	static int unsuccessfulSimulations;
	static int counterGeneralFlightSimulatorException;
	static int counterPlaneTooHighException;
	static int counterPlaneTooLowException;
	static int counterGeneralFlightException;
	static int counterNullPointerException;

	public static void main(String[] args) throws GeneralFlightSimulatorException {
		while (true){
			makeMenu();
		}

	}
	// Compares two strings to determine whether all their letters are equal
	public static boolean equals(String x,String y){
		boolean equals = true;
		if(x.length() != y.length())
			equals = false;
		else{
			for(int i = 0; i < x.length(); i++){
				if(x.charAt(i) != y.charAt(i))
					equals = false;
			}
		}
		return equals;

	}

	private static void makeMenu() throws GeneralFlightSimulatorException {

		System.out.println("---- Menü ----");
		System.out.println("0: Start new simulation ");
		System.out.println("1: Create route");
		System.out.println("2: Close doors");
		System.out.println("3: Fly complete route");
		System.out.println("10: Fly next kilometer ");
		System.out.println("11: Stop");
		System.out.println("12: Open doors");
		System.out.println("13: Evaluate simulation");
		System.out.println("90: Print Object");
		System.out.println("99: Exit");

		int selection = scanner.nextInt();

		switch (selection) {
		//resets all the information in case you want to start a new simulation
		case 0:
			newPlane = null;
			exceptionThrown = false;
			exceptionName = null;
			route = null;
			break;
			// Creates a new with values you can choose
			// If the input is invalid the program will be terminated
		case 1:
			System.out.println("How far do you want to fly(in km)?");
			int distance = scanner.nextInt();
			System.out.println("What is the minimum height(in m)?");
			int minHeight = scanner.nextInt();
			System.out.println("What is the maximum height(in m)?");
			int maxHeight = scanner.nextInt();
			route = new FlightRoute(distance,minHeight,maxHeight);			
			newPlane = new Touristenflugzeug(0, false, false, true, 0,route);
			break;
		case 2:
			try{
				newPlane.closeDoors();
			}
			// NullPointerException in case no route and plane have yet been created
			catch(NullPointerException x){
				exceptionThrown = true;
				exceptionName = x.toString();
				System.out.print(exceptionName);
				counterNullPointerException++;


			}
			break;
			// Flies the plane through the complete route. As long as the final destination is far away enough maximum height will be reached
			// Lands the plane but does not stop it
			// This simulation should normally not cause any exceptions unless the values for the route are incorrect or no route and plane has yet been created
		case 3:
			try{
				newPlane.getheight();
			}
			catch(NullPointerException a){
				exceptionThrown = true;
				exceptionName = a.toString();
				counterNullPointerException++;

			}
			if(!exceptionThrown){


				while((newPlane.getheight()/100-(route.getKilometer()-newPlane.getcoveredDistance()) )!= 0){
					try{
						if(newPlane.getheight() < route.getmaxHeight() && route.getmaxHeight() - newPlane.getheight() >= 100)
							newPlane.flyNextKilometer(100);
						else if(newPlane.getheight() <= route.getmaxHeight() && route.getmaxHeight() - newPlane.getheight() < 100)
							newPlane.flyNextKilometer(route.getmaxHeight() - newPlane.getheight());
					}
					// NullPointerException in case no route and plane have yet been created
					catch(NullPointerException|GeneralFlightSimulatorException x){
						exceptionThrown = true;
						exceptionName = x.toString();
						if(equals(exceptionName,"GeneralFlightSimulatorException"))
							counterGeneralFlightSimulatorException++;
						else if(equals(exceptionName,"PlaneTooHighException"))
							counterPlaneTooHighException++;
						else if(equals(exceptionName,"PlaneTooLowException"))
							counterPlaneTooLowException++;
						else if(equals(exceptionName,"GeneralFlightException"))
							counterGeneralFlightException++;
						else{
							counterNullPointerException++;
						}
						break;


					}
				}



				while(newPlane.getheight() > 0){
					try{
						newPlane.flyNextKilometer(-100);
					}
					// NullPointerException in case no route and plane have yet been created
					catch(NullPointerException|GeneralFlightSimulatorException x){
						exceptionThrown = true;
						exceptionName = x.toString();
						if(equals(exceptionName,"GeneralFlightSimulatorException"))
							counterGeneralFlightSimulatorException++;
						else if(equals(exceptionName,"PlaneTooHighException"))
							counterPlaneTooHighException++;
						else if(equals(exceptionName,"PlaneTooLowException"))
							counterPlaneTooLowException++;
						else if(equals(exceptionName,"GeneralFlightException"))
							counterGeneralFlightException++;
						else{
							counterNullPointerException++;
						}
						break;

					}
				}
			}
			break;
			// The user decides how much the plain should ascend in the next kilometer
			// Exceptions are being thrown in certain cases. More detailed in the javadoc for fly next Kilometer.
		case 10:
			System.out.println("How many meters do you want the plain to ascend in the course of the next kilometer?");
			int additionalHeight = scanner.nextInt();
			try{
				newPlane.flyNextKilometer(additionalHeight);
			}
			catch(NullPointerException|GeneralFlightSimulatorException x){
				exceptionThrown = true;
				exceptionName = x.toString();
				if(equals(exceptionName,"GeneralFlightSimulatorException"))
					counterGeneralFlightSimulatorException++;
				else if(equals(exceptionName,"PlaneTooHighException"))
					counterPlaneTooHighException++;
				else if(equals(exceptionName,"PlaneTooLowException"))
					counterPlaneTooLowException++;
				else if(equals(exceptionName,"GeneralFlightException"))
					counterGeneralFlightException++;
				else{
					counterNullPointerException++;
				}


			}
			break;
		case 11:
			try{
				newPlane.stop();
			}
			// NullPointerException in case no route and plane have yet been created
			catch(NullPointerException|GeneralFlightSimulatorException x){
				exceptionThrown = true;
				exceptionName = x.toString();
				if(equals(exceptionName,"GeneralFlightSimulatorException"))
					counterGeneralFlightSimulatorException++;
				else if(equals(exceptionName,"PlaneTooHighException"))
					counterPlaneTooHighException++;
				else if(equals(exceptionName,"PlaneTooLowException"))
					counterPlaneTooLowException++;
				else if(equals(exceptionName,"GeneralFlightException"))
					counterGeneralFlightException++;
				else{
					counterNullPointerException++;
				}



			}
			break;
		case 12:
			try{
				newPlane.openDoors();
			}
			// NullPointerException in case no route and plane have yet been created
			catch(NullPointerException|GeneralFlightSimulatorException x){
				exceptionThrown = true;
				exceptionName = x.toString();
				if(equals(exceptionName,"GeneralFlightSimulatorException"))
					counterGeneralFlightSimulatorException++;
				else if(equals(exceptionName,"PlaneTooHighException"))
					counterPlaneTooHighException++;
				else if(equals(exceptionName,"PlaneTooLowException"))
					counterPlaneTooLowException++;
				else if(equals(exceptionName,"GeneralFlightException"))
					counterGeneralFlightException++;
				else{
					counterNullPointerException++;
				}


			}
			break;
			// This is needed to evaluate the current simulation. Successful and unsuccessful simulations are counted.
		case 13:
			if(exceptionThrown){
				System.out.println("Simulation was unsucessful: " + exceptionName + " was thrown.");
				unsuccessfulSimulations++;
			}
			else{
				System.out.println("No problems occured");
				successfulSimulations++;
			}
			break;
		case 90:
			newPlane.print();
			break;
			// Exits the simulation and prints the number of successful and unsucessful simulations and the thrown exceptions.
		case 99:
			System.out.println("Successful Simulations: " + successfulSimulations);
			System.out.println("Unsuccessful Simulations: " + unsuccessfulSimulations);
			if(counterGeneralFlightSimulatorException != 0){
				System.out.println("Occurences of GeneralFlightSimulatorException: " + counterGeneralFlightSimulatorException);
			}
			if(counterPlaneTooHighException != 0){
				System.out.println("Occurences of PlaneTooHighException: " + counterPlaneTooHighException);
			}
			if(counterPlaneTooLowException != 0){
				System.out.println("Occurences of PlaneTooLowException: " + counterPlaneTooHighException);
			}
			if(counterGeneralFlightException != 0){
				System.out.println("Occurences of GeneralFlightException: " + counterGeneralFlightException);

			}
			if(counterNullPointerException != 0){
				System.out.println("Occurences of NullPointerException: " + counterNullPointerException);
			}
			System.out.println("Are you sure you want to exit the simulation? Enter 1 for yes and 2 for no");
			int decision = scanner.nextInt();
			if(decision == 1)
				System.exit( 0 );
			else
				break;
		default:
			System.out.println("Your selection was invalid.");
			break;
		}


	}

}

