package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

public class Touristenflugzeug implements Plane {
	private int geflogeneKilometer = 0;
	private int aktuellehoehe= 0;
	private boolean inDerLuft= false;
	private boolean tuerOffen= false;
	private boolean stillStehen= true;
	private boolean run=false;
	static FlightRoute newRoute;
	
	public Touristenflugzeug(int geflogeneKilometer, boolean inDerLuft, boolean tuerOffen, boolean stillStehen, boolean run, int aktuellehoehe) {
		this.geflogeneKilometer = geflogeneKilometer;
		this.inDerLuft = inDerLuft;
		this.tuerOffen = tuerOffen;
		this.stillStehen = stillStehen;
		this.run = run;
		this.aktuellehoehe = aktuellehoehe;
	}
	
	public void print(){
		System.out.println("geflogeneKilometer " + this.geflogeneKilometer);
		System.out.println("inDerLuft " + this.inDerLuft);
		System.out.println("türOffen " + this.tuerOffen);
		System.out.println("stillStehen " + this.stillStehen);
		System.out.println("running " + this.run);
		System.out.println("aktuellehoehe " + this.aktuellehoehe);
	}
	public int getGeflogeneKilometer() {
		return geflogeneKilometer;
	}

	public int getAktuellehoehe() {
		return aktuellehoehe;
	}
	
	public boolean isRunning(){
		return run;
	}
	
	public void run(String weg){
		if(!isRunning()){
			if(weg.equalsIgnoreCase("long")){
				newRoute = new FlightRoute(10,1000,5000);
				run=true;
				System.out.println("Die Simulation der Strecke "+weg+" wurde ausgewählt.");
			}else if(weg.equals("Short") || weg.equals("short")){
				newRoute = new FlightRoute(5,1000,5000);
				run=true;
				System.out.println("Die Simulation der Strecke "+weg+" wurde ausgewählt.");
			}else{
				throw new FlightSimulatorRuntimeException("Bitte geben Sie eine gültige Strecke ein!");
			}
		}else{
			throw new FlightSimulatorRuntimeException("Die Simulation läuft schon!");
		}
	}

	@Override
	public void openDoors() throws GeneralFlightSimulatorException {
		if(inDerLuft==false && stillStehen==true && inDerLuft== false){
			inDerLuft = true;
			System.out.println("Sie haben die Tür geoeffnet!");
		}else{
			throw new GeneralFlightSimulatorException ("Sie sind in der Luft die Türen koennen nicht geoeffnet werden!");
		}
		
	}

	@Override
	public void closeDoors() {
		if(inDerLuft==false){
			throw new GeneralFlightSimulatorException ("Die Tür ist nicht offen.");
//			System.out.println("Die Tür ist nicht offen.");
		}else{
			System.out.println("Sie haben die Tür geschlossen.");
			inDerLuft = false;
		}


	}

	@Override
	public void landen(){
		if(geflogeneKilometer == newRoute.getKilometer() && inDerLuft==false){
			System.out.println("Wir werden nun landen!");
			inDerLuft = false;
		}else if(geflogeneKilometer == 0 || stillStehen==true){
			throw new GeneralFlightSimulatorException ("Sie sind noch nicht losgeflogen!");
		}else{
			throw new GeneralFlightSimulatorException ("Sie koennen hier nicht landen!");
		}
	}
	
	@Override
	public void stop() throws GeneralFlightSimulatorException {
		if(stillStehen == false && inDerLuft==false){
			System.out.println("Das Flugzeug wurde nun geparkt.");
			stillStehen = true;
		}else{
			throw new GeneralFlightSimulatorException ("Sie müssen erst landen und parken um Stoppen zu koennen!");
		}
	}

	@Override
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException {
		if(tuerOffen==false){
			if(geflogeneKilometer == newRoute.getKilometer()){
				System.out.println("Sie sind am Ziel angekommen. Bitte landen Sie und stoppen das Flugzeug.");
			}else{
				if(geflogeneKilometer < 1 || aktuellehoehe + additionalHeight >= newRoute.getMinhoehe()){
					if(aktuellehoehe + additionalHeight >= 0 && aktuellehoehe + additionalHeight <= newRoute.getMaxhoehe()){
						aktuellehoehe = aktuellehoehe + additionalHeight;
						stillStehen=false;
						inDerLuft=true;
						geflogeneKilometer++;
						int rest = newRoute.getKilometer()-geflogeneKilometer;
						System.out.println("Sie befinden sich nun auf Kilometerstand "+ geflogeneKilometer +".");
						System.out.println("Sie haben noch "+ rest +" Kilometer zu fliegen.");	
					}else{
						throw new GeneralFlightSimulatorException ("Die eingegebenen Hoehe würde zu einem Crash oder zu einer Überschreitung der Maximalhoehe führen!");
					}	
				}else if(aktuellehoehe < newRoute.getMinhoehe()){
					throw new GeneralFlightSimulatorException ("Sie müssen erst steigen, da sie ab 2 KM entfernung eine Mindesthoehe von "+ newRoute.getMinhoehe()+" einhalten müssen!");
				}
			}
		}else{
			throw new GeneralFlightSimulatorException ("Sie sind in der Luft die Türen koennen nicht geoeffnet werden!"); 
		}
	}

}
