package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

public class Touristenflugzeug implements Plane {
	private int coveredDistance = 0;
	private int height = 0;
	private boolean midAir = false;
	private boolean doorOpen = false;
	private boolean standingStill = true;
	static FlightRoute newRoute;

	public Touristenflugzeug(int coveredDistance, boolean midAir, boolean doorOpen, boolean standingStill, int height,FlightRoute route) {
		this.coveredDistance = coveredDistance;
		this.midAir = midAir;
		this.doorOpen = doorOpen;
		this.standingStill = standingStill;

		this.height = height;
		this.newRoute = route;
	}

	public void print(){
		System.out.println("coveredDistance " + this.coveredDistance);
		System.out.println("midAir " + this.midAir);
		System.out.println("doorOpen " + this.doorOpen);
		System.out.println("standingStill " + this.standingStill);
		System.out.println("height " + this.height);
	}
	public int getcoveredDistance() {
		return coveredDistance;
	}

	public int getheight() {
		return height;
	}


	@Override
	public void openDoors() throws GeneralFlightSimulatorException {
		if(midAir==false && standingStill==true && doorOpen== false){
			doorOpen = true;
			System.out.println("You have opened the doors!");
		}else{
			new GeneralFlightSimulatorException ("The doors can not be openend mid-air!");
		}

	}

	@Override
	public void closeDoors() {
		if(!doorOpen){
			System.out.println("The doors are already closed.");
		}else{
			System.out.println("You have closed the doors.");
			doorOpen = false;
		}


	}

	

	@Override
	public void stop() throws GeneralFlightSimulatorException {
		if(!standingStill && !midAir){
			System.out.println("The plane has now stopped.");
			standingStill = true;
		}else{
			throw new GeneralFlightSimulatorException ("You have to land first before you can stop the plane!");
		}
	}

	@Override
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException {
		midAir = true;
		standingStill = false;
		// If input is invalid
		if(additionalHeight > 100 || additionalHeight < -100){
			throw new GeneralFlightException();

		}
		else{
			// Period of time right after the start
			if(!doorOpen && coveredDistance < 2){
				// Is minimum height reached after two kilometers?
				if(coveredDistance == 1 && additionalHeight < (newRoute.getminHeight()-height)){
					throw new PlaneTooLowException();
				}
				// Is maximum height surpassed?
				else if(height + additionalHeight > newRoute.getmaxHeight()){
					throw new PlaneTooHighException(height);
				}
				height = height + additionalHeight;
				coveredDistance++;

			}
			// Plain is in reach of airport so minimum height is no requirement anymore
			else if(!doorOpen && coveredDistance >= newRoute.getKilometer()-2 ){
				if(height > newRoute.getmaxHeight()){
					height = height + additionalHeight;
					coveredDistance++;
					throw new PlaneTooHighException(height);
				}
				else if(coveredDistance >= newRoute.getKilometer()){
					height = height + additionalHeight;
					coveredDistance++;
					throw new GeneralFlightException("Plane has already arrived or has already flown over final destination without landing");
				}
				
				height = height + additionalHeight;
				coveredDistance++;

			}
			// period of time where the plain is in mid-air and not yet in reach of final destination
			// it should neither ascend over the maximum height nor descend below the minimum height
			else if(!doorOpen && coveredDistance >= 2){
				if(height + additionalHeight < newRoute.getminHeight()){
					throw new PlaneTooLowException(height);
				}
				else if(height + additionalHeight > newRoute.getmaxHeight()){
					throw new PlaneTooHighException(height);
				}
				
				height = height + additionalHeight;
				coveredDistance++;
			}
			else{
				throw new GeneralFlightException("Doors are open. Please close the doors before you try to start flying");
			}
		}

	}

}
