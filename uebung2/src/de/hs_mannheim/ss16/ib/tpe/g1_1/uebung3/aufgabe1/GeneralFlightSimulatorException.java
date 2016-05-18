package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

public class GeneralFlightSimulatorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 659512877263952226L;

	public GeneralFlightSimulatorException(String string) {
		System.out.println(string);	
	}
	public GeneralFlightSimulatorException() {
		System.out.println("Unknown Error!");	
	}
	

}
