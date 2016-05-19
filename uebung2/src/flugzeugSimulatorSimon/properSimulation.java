package flugzeugSimulatorSimon;

public class properSimulation {
	public static void main(String[] args){
		FlightRoute mine = new FlightRoute(500,100,2000);
		Plane Boeing = new Touristenflugzeug(0, false, false, true, false, 0,mine);
		Boeing.closeDoors();
		while((Boeing.getAktuellehöhe()/100-(mine.getKilometer()-Boeing.getGeflogeneKilometer()) != 0)){
			try{
				if(Boeing.getAktuellehöhe() < mine.getMaxhöhe())
					Boeing.flyNextKilometer(100);
				else
					Boeing.flyNextKilometer(0);
			}
			catch(GeneralFlightSimulatorException a){
				a.printStackTrace();
				break;
			}
		}
		while(Boeing.getAktuellehöhe() > 0){
			try{
				Boeing.flyNextKilometer(-100);
			}
			catch(GeneralFlightSimulatorException a){
				a.printStackTrace();
				break;
			}
			
		}
		try{
		Boeing.stop();
		}
		catch(GeneralFlightSimulatorException a){
			a.getStackTrace();
			
		}
		try{
			Boeing.openDoors();
			}
		catch(GeneralFlightSimulatorException a){
				a.getStackTrace();	
				
			}
		Boeing.print();
	}

}
