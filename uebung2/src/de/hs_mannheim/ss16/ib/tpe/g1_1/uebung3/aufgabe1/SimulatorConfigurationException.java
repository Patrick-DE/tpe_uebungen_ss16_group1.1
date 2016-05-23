package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

public class SimulatorConfigurationException extends Exception {
	
	public SimulatorConfigurationException() {
		
		}
		
	
	public SimulatorConfigurationException(String string) {
		
	}

	/**
	 * @return The reason for which the error occured
	 */
	public String getMessage(){
		return("The values you entered were invalid!");
	}
	/**
	 * @return The name of this exception
	 */
	public String toString(){
		return("GeneralFlightSimulatorException");
	}
	
}
