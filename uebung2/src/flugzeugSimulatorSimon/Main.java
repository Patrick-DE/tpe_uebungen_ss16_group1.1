package flugzeugSimulatorSimon;

import java.util.Scanner;

import sun.security.action.GetBooleanAction;

public class Main {
	static Plane newPlane;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws GeneralFlightSimulatorException {
		while (true){
			makeMenu();
		}

	}

	private static void makeMenu() throws GeneralFlightSimulatorException {

		System.out.println("---- Menü ----");
		System.out.println("1: Create route and plane ");
		System.out.println("2: Stop");
		System.out.println("10: OpenDoors");
		System.out.println("11: CloseDoors");
		System.out.println("12: Fly");
		System.out.println("13: Landen");
		System.out.println("90: Print Object");
		System.out.println("99: Exit");

		int selection = scanner.nextInt();

		switch (selection) {
		case 1:
			System.out.println("How far do you want to fly?");
			int distance = scanner.nextInt();
			System.out.println("What is the minimum height?");
			int minHeight = scanner.nextInt();
			System.out.println("What is the maximum height?");
			int maxHeight = scanner.nextInt();
			FlightRoute route = new FlightRoute(distance,minHeight,maxHeight);
			newPlane = new Touristenflugzeug(0, false, false, true, false, 0,route);
			break;
		case 2:
			try{
				newPlane.stop();
			}catch(NullPointerException e){
				new GeneralFlightSimulatorException("Sie haben die Simulation noch nicht gestartet!");
			}
			break;
		case 10:
			try{
				newPlane.openDoors();
			}catch(NullPointerException e){
				new GeneralFlightSimulatorException("Sie haben die Simulation noch nicht gestartet!");
			}
			break;
		case 11:
			try{
				newPlane.closeDoors();
			}catch(NullPointerException e){
				new GeneralFlightSimulatorException("Sie haben die Simulation noch nicht gestartet!");
			}
			break;
		case 12:
			try{
				System.out.println("Ihre aktuelle Höhe ist: "+ newPlane.getAktuellehöhe()+".");
				System.out.println("Wie hoch möchten Sie fliegen?");
				int additionalHeight = scanner.nextInt();
				newPlane.flyNextKilometer(additionalHeight);
			}catch(NullPointerException e){
				new GeneralFlightSimulatorException("Sie haben die Simulation noch  nicht gestartet!");
			}
			break;
		case 13:
			try{
				newPlane.landen();
			}catch(NullPointerException e){
				new GeneralFlightSimulatorException("Sie haben die Simulation noch nicht gestartet!");
			}
			break;
		case 90:
			newPlane.print();
			break;
		case 99:
			System.exit( 0 );
			break;
		default:
			System.out.println("Ihre Auswahl war leider nicht gültig.");
			break;
		}

	}
		
}

