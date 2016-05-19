package flugzeugSimulatorSimon;

public class SimulatorConfigurationException extends Exception {
	
	public SimulatorConfigurationException() {
		
		}
		
	
	public SimulatorConfigurationException(String string) {
		
	}


	public String getMessage(){
		return("The values you entered were invalid!");
	}
	
}
