package flugzeugSimulatorSimon;

import java.io.IOException;

public class FlightRoute {

	private int kilometer = 0;
	private int minhöhe = 0;
	private int maxhöhe = 0;
	
	FlightRoute(int kilometer, int minhöhe, int maxhöhe) {
		try{
		setKilometer(kilometer);
		setMaxhöhe(maxhöhe);
		setMinhöhe(minhöhe);
		}
		catch(SimulatorConfigurationException a){
			System.out.println("An error occured!);
			System.out.println("Reason "a.getMessage());
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
		

	public int getMinhöhe() {
		return minhöhe;
	}
	public void setMinhöhe(int minhöhe) throws SimulatorConfigurationException {
		if(minhöhe > getMaxhöhe() || minhöhe <= 0 ){
			throw new SimulatorConfigurationException();
		}
		else{
			this.minhöhe = minhöhe;
		}
		
	}
	public int getMaxhöhe() {
		return maxhöhe;
	}
	public void setMaxhöhe(int maxhöhe)throws SimulatorConfigurationException  {
		if(maxhöhe <= 0){
			throw new SimulatorConfigurationException();
		}
		else{
			this.maxhöhe = maxhöhe;
		}
	}
}
