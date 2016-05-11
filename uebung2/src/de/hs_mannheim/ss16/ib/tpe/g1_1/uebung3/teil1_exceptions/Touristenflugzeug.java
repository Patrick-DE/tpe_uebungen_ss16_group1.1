package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.teil1_exceptions;

public class Touristenflugzeug implements Plane {
	private int geflogeneKilometer = 0;
	private boolean inDerLuft= false;
	private boolean türOffen= false;
	private boolean stillStehen= true;
	
	public Touristenflugzeug(int geflogeneKilometer, boolean inDerLuft, boolean türOffen, boolean stillStehen) {
		this.geflogeneKilometer = geflogeneKilometer;
		this.inDerLuft = inDerLuft;
		this.türOffen = türOffen;
		this.stillStehen = stillStehen;
	}
	
	public void print(){
		System.out.println("geflogeneKilometer " + this.geflogeneKilometer);
		System.out.println("inDerLuft " + this.inDerLuft);
		System.out.println("türOffen " + this.türOffen);
		System.out.println("stillStehen " + this.stillStehen);	
	}
	
	public void run(){
		FlightRoute newRoute = new FlightRoute();
	}

	@Override
	public void openDoors() throws GeneralFlightSimulatorException {
		if(inDerLuft==false && stillStehen==true && türOffen== false){
			türOffen = true;
			System.out.println("Sie haben die Tür geöffnet!");
		}else{
			throw new GeneralFlightSimulatorException ("Sie sind in der Luft die Türen können nicht geöffnet werden!");
		}
		
	}

	@Override
	public void closeDoors() {
		if(türOffen==false){
			System.out.println("Die Tür ist nicht offen.");
		}else{
			türOffen = false;
		}


	}

	@Override
	public void stop() throws GeneralFlightSimulatorException {
		// TODO Auto-generated method stub

	}

	@Override
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException {
		// TODO Auto-generated method stub

	}

}
