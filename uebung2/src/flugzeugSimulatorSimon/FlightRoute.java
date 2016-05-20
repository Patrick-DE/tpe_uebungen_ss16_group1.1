package flugzeugSimulatorSimon;


public class FlightRoute {

	private int kilometer = 0;
	private int minHeight = 0;
	private int maxHeight = 0;
	
	FlightRoute(int kilometer, int minHeight, int maxHeight) {
		try{
		setKilometer(kilometer);
		setmaxHeight(maxHeight);
		setminHeight(minHeight);
		}
		catch(SimulatorConfigurationException a){
			System.out.println("An error occured!");
			System.out.println("Reason "+ a.getMessage());
			a.printStackTrace();
		}
			
		
	}
	
	public int getKilometer()   {
		return kilometer;
	}
	public void setKilometer(int kilometer) throws SimulatorConfigurationException {
		if(kilometer <= 0){
			throw new SimulatorConfigurationException();
		}
		else{
			this.kilometer = kilometer;
		}
	}
		

	public int getminHeight() {
		return minHeight;
	}
	public void setminHeight(int minHeight) throws SimulatorConfigurationException {
		if(minHeight > getmaxHeight() || minHeight <= 0 ){
			throw new SimulatorConfigurationException();
		}
		else{
			this.minHeight = minHeight;
		}
		
	}
	public int getmaxHeight() {
		return maxHeight;
	}
	public void setmaxHeight(int maxHeight)throws SimulatorConfigurationException  {
		if(maxHeight <= 0){
			throw new SimulatorConfigurationException();
		}
		else{
			this.maxHeight = maxHeight;
		}
	}
}
