package flugzeugSimulatorSimon;

public class Touristenflugzeug implements Plane {
	private int geflogeneKilometer = 0;
	private int aktuellehöhe= 0;
	private boolean inDerLuft= false;
	private boolean türOffen= false;
	private boolean stillStehen= true;
	private boolean run=false;
	static FlightRoute newRoute;

	public Touristenflugzeug(int geflogeneKilometer, boolean inDerLuft, boolean türOffen, boolean stillStehen, boolean run, int aktuellehöhe,FlightRoute route) {
		this.geflogeneKilometer = geflogeneKilometer;
		this.inDerLuft = inDerLuft;
		this.türOffen = türOffen;
		this.stillStehen = stillStehen;
		this.run = run;
		this.aktuellehöhe = aktuellehöhe;
		this.newRoute = route;
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


	@Override
	public void openDoors() throws GeneralFlightSimulatorException {
		if(inDerLuft==false && stillStehen==true && türOffen== false){
			türOffen = true;
			System.out.println("Sie haben die Tür geöffnet!");
		}else{
			new GeneralFlightSimulatorException ("Sie sind in der Luft die Türen können nicht geöffnet werden!");
		}

	}

	@Override
	public void closeDoors() {
		if(!türOffen){
			System.out.println("Die Tür ist nicht offen.");
		}else{
			System.out.println("Sie haben die Tür geschlossen.");
			türOffen = false;
		}


	}

	

	@Override
	public void stop() throws GeneralFlightSimulatorException {
		if(!stillStehen && !inDerLuft){
			System.out.println("Das Flugzeug wurde nun geparkt.");
			stillStehen = true;
		}else{
			throw new GeneralFlightSimulatorException ("Sie müssen erst landen und parken um Stoppen zu können!");
		}
	}

	@Override
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException {
		inDerLuft = true;
		stillStehen = false;
		if(additionalHeight > 100 || additionalHeight < -100){
			throw new GeneralFlightSimulatorException("Plane can't not rise more than 100 m every kilometer");

		}
		else{
			if(!türOffen && geflogeneKilometer < 2){
				if(geflogeneKilometer == 1 && additionalHeight < (newRoute.getMinhöhe()-aktuellehöhe)){
					throw new GeneralFlightSimulatorException("Plane must surpass minimum height after flying two kilometers");
				}
				else if(aktuellehöhe + additionalHeight > newRoute.getMaxhöhe()){
					throw new PlaneTooHighException(aktuellehöhe);
				}
				aktuellehöhe = aktuellehöhe + additionalHeight;
				geflogeneKilometer++;

			}
			else if(!türOffen && geflogeneKilometer >= 2 && geflogeneKilometer >= newRoute.getKilometer()-2 ){
				if(aktuellehöhe > newRoute.getMaxhöhe()){
					throw new PlaneTooHighException(aktuellehöhe);
				}
				aktuellehöhe = aktuellehöhe + additionalHeight;
				geflogeneKilometer++;

			}
			else if(!türOffen && geflogeneKilometer >= 2){
				if(aktuellehöhe + additionalHeight < newRoute.getMinhöhe()){
					throw new PlaneTooLowException(aktuellehöhe);
				}
				else if(aktuellehöhe + additionalHeight > newRoute.getMaxhöhe()){
					throw new PlaneTooHighException(aktuellehöhe);
				}
				else if(geflogeneKilometer >= newRoute.getKilometer()){
					throw new GeneralFlightSimulatorException("Plane has already arrived or has already flown over final destination without landing");
				}
				aktuellehöhe = aktuellehöhe + additionalHeight;
				geflogeneKilometer++;
			}
			
			else{
				throw new GeneralFlightSimulatorException("Doors are open. Please close the doors before you try to start flying");
			}
		}

	}

}
