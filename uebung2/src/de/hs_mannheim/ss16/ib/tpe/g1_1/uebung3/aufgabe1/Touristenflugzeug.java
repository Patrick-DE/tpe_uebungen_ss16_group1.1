package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

public class Touristenflugzeug implements Plane {
	private int geflogeneKilometer = 0;
	private int aktuellehöhe= 0;
	private boolean inDerLuft= false;
	private boolean türOffen= false;
	private boolean stillStehen= true;
	private boolean run=false;
	static FlightRoute newRoute;
	
	public Touristenflugzeug(int geflogeneKilometer, boolean inDerLuft, boolean türOffen, boolean stillStehen, boolean run, int aktuellehöhe) {
		this.geflogeneKilometer = geflogeneKilometer;
		this.inDerLuft = inDerLuft;
		this.türOffen = türOffen;
		this.stillStehen = stillStehen;
		this.run = run;
		this.aktuellehöhe = aktuellehöhe;
	}
	
	public void print(){
		System.out.println("geflogeneKilometer " + this.geflogeneKilometer);
		System.out.println("inDerLuft " + this.inDerLuft);
		System.out.println("türOffen " + this.türOffen);
		System.out.println("stillStehen " + this.stillStehen);
		System.out.println("running " + this.run);
		System.out.println("aktuellehöhe " + this.aktuellehöhe);
	}
	public int getGeflogeneKilometer() {
		return geflogeneKilometer;
	}

	public int getAktuellehöhe() {
		return aktuellehöhe;
	}
	
	public void run(String weg){
		if(run==false){
			if(weg.equals("Long") || weg.equals("long")){
				newRoute = new FlightRoute(10,1000,5000);
				run=true;
				System.out.println("Die Simulation der Strecke "+weg+" wurde ausgewählt.");
			}else if(weg.equals("Short") || weg.equals("short")){
				newRoute = new FlightRoute(5,1000,5000);
				run=true;
				System.out.println("Die Simulation der Strecke "+weg+" wurde ausgewählt.");
			}else{
				throw new GeneralFlightSimulatorException("Bitte geben Sie eine gültige Strecke ein!");
//				System.out.println("Bitte geben Sie eine gültige Strecke ein!");
			}
		}else{
			throw new GeneralFlightSimulatorException("Die Simulation läuft schon!");
//			System.out.println("Die Simulation läuft schon!");
		}
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
			throw new GeneralFlightSimulatorException ("Die Tür ist nicht offen.");
//			System.out.println("Die Tür ist nicht offen.");
		}else{
			System.out.println("Sie haben die Tür geschlossen.");
			türOffen = false;
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
			throw new GeneralFlightSimulatorException ("Sie können hier nicht landen!");
		}
	}
	
	@Override
	public void stop() throws GeneralFlightSimulatorException {
		if(stillStehen == false && inDerLuft==false){
			System.out.println("Das Flugzeug wurde nun geparkt.");
			stillStehen = true;
		}else{
			throw new GeneralFlightSimulatorException ("Sie müssen erst landen und parken um Stoppen zu können!");
		}
	}

	@Override
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException {
		if(türOffen==false){
			if(geflogeneKilometer == newRoute.getKilometer()){
				System.out.println("Sie sind am Ziel angekommen. Bitte landen Sie und stoppen das Flugzeug.");
			}else{
				if(geflogeneKilometer < 1 || aktuellehöhe + additionalHeight >= newRoute.getMinhöhe()){
					if(aktuellehöhe + additionalHeight >= 0 && aktuellehöhe + additionalHeight <= newRoute.getMaxhöhe()){
						aktuellehöhe = aktuellehöhe + additionalHeight;
						stillStehen=false;
						inDerLuft=true;
						geflogeneKilometer++;
						int rest = newRoute.getKilometer()-geflogeneKilometer;
						System.out.println("Sie befinden sich nun auf Kilometerstand "+ geflogeneKilometer +".");
						System.out.println("Sie haben noch "+ rest +" Kilometer zu fliegen.");	
					}else{
						throw new GeneralFlightSimulatorException ("Die eingegebenen Höhe würde zu einem Crash oder zu einer Überschreitung der Maximalhöhe führen!");
					}	
				}else if(aktuellehöhe < newRoute.getMinhöhe()){
					throw new GeneralFlightSimulatorException ("Sie müssen erst steigen, da sie ab 2 KM entfernung eine Mindesthöhe von "+ newRoute.getMinhöhe()+" einhalten müssen!");
				}
			}
		}else{
			throw new GeneralFlightSimulatorException ("Sie sind in der Luft die Türen können nicht geöffnet werden!"); 
		}
	}

}
