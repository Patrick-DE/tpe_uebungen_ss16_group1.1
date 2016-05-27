package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;


public class FlightRoute {

	private int kilometer = 0;
	private int minHeight = 0;
	private int maxHeight = 0;
	private int reachCity = 0;
	private int passCity = 0;
	
	FlightRoute(int kilometer, int minHeight, int maxHeight) {
		try{
		setKilometer(kilometer);
		setmaxHeight(maxHeight);
		setminHeight(minHeight);
		setreachCity(2);
		setpassCity(getKilometer()-2);
		}
		catch(SimulatorConfigurationException a){
			System.out.println("An error occured!");
			System.out.println("Reason: "+ a.getMessage());
			a.printStackTrace();
			System.exit( 0 );
		}
			
		
	}
			
	
	// getter Methods for all variables of FlightRoute
	public int getKilometer()   {
		return kilometer;
	}
	public int getmaxHeight() {
		return maxHeight;
	}
	public int getminHeight() {
		return minHeight;
	}

	public int getreachCity() {
		return reachCity;
	}
	public int getpassCity() {
		return passCity;
	}
	// setter methods for all variables of FlighRoute 
	// Every method checks whether the input is valid
	// If it is invalid the SimulatorConfigurationException will be thrown
	public void setKilometer(int kilometer) throws SimulatorConfigurationException {
		if(kilometer <= 0)
			throw new SimulatorConfigurationException();
		else
			this.kilometer = kilometer;
	}
	public void setminHeight(int minHeight) throws SimulatorConfigurationException {
		if(minHeight >= getmaxHeight() || minHeight <= 0 || minHeight > 200 )
			throw new SimulatorConfigurationException();
		else
			this.minHeight = minHeight;
		
	}
	
	public void setmaxHeight(int maxHeight)throws SimulatorConfigurationException  {
		if(maxHeight <= 0)
			throw new SimulatorConfigurationException();
		else
			this.maxHeight = maxHeight;
	}


	
	public void setreachCity(int reachCity)throws SimulatorConfigurationException  {
			this.reachCity = reachCity;
	}
	
	public void setpassCity(int passCity)throws SimulatorConfigurationException  {
		this.passCity = passCity;
	}
}
