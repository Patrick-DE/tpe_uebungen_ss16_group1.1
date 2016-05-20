package flugzeugSimulatorSimon;

public class GeneralFlightSimulatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 659512877263952226L;
	private String message;

	public GeneralFlightSimulatorException(){
		
	}
	public GeneralFlightSimulatorException(String string) {
		this.message = message;
	}
	public String getMessage(){
		return message;
	}
	public String toString(){
		return("GeneralFlightSimulatorException");
	}
	

}
