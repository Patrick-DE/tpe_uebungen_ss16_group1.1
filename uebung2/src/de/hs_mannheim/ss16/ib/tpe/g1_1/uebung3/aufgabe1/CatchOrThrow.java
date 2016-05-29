package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

import java.util.Scanner;

public class CatchOrThrow  {
	static Scanner scanner = new Scanner(System.in);
	
	public static void throwException() throws GeneralFlightException{
		try{
			throwException2();
		}
		catch(SimulatorConfigurationException a){
			
		}
		
	}
	public static void throwException2() throws SimulatorConfigurationException,GeneralFlightException{
		System.out.println("To throw the SimulatorConfigurationException press 1 to throw the other exception press 2");
		int decision = scanner.nextInt();
		if(decision == 1)
			throw new SimulatorConfigurationException();
		else if(decision == 2)
			throw new GeneralFlightException();
	}
	public static void main(String[] args){
		try{
			throwException();
		}
		catch(GeneralFlightException a){
			
		}
	}

}
