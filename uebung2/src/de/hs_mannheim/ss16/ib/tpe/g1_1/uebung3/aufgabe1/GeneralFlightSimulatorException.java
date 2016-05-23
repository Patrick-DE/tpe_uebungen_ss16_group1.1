package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

public class GeneralFlightSimulatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 659512877263952226L;
	private String message;

	public GeneralFlightSimulatorException(){
		super();
	}
	public GeneralFlightSimulatorException(String message) {
		this.message = message;
	}
	/**
	 * @return The message which was given to this exception's instance as a parameter
	 */
	public String getMessage(){
		return message;
	}
	/**
	 * @return The name of this exception
	 */
	public String toString(){
		return("GeneralFlightSimulatorException");
	}
	

}
