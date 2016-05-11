package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.teil1_exceptions;

import java.util.Scanner;

public class Main {
	static Plane newPlane = new Touristenflugzeug(0, false, false, true);
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws GeneralFlightSimulatorException {
		while (true){
			makeMenu();
		}

	}

	private static void makeMenu() throws GeneralFlightSimulatorException {

		System.out.println("---- Menü ----");
		System.out.println("1: OpenDoors");
		System.out.println("2: CloseDoors");
		System.out.println("90: Print Object");
		System.out.println("99: Exit");

		int selection = scanner.nextInt();

		switch (selection) {
		case 1:
			newPlane.openDoors();
			break;
		case 2:
			newPlane.closeDoors();
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

