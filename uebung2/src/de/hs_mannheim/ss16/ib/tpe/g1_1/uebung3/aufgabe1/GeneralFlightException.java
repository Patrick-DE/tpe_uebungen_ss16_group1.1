package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

public class GeneralFlightException extends GeneralFlightSimulatorException {

	/**
	 * 
	 */
	private String message;

	public GeneralFlightException(){

	}
	public GeneralFlightException(String string) {
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
		return("GeneralFlightException");
	}


}


