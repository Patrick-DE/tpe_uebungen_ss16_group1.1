package flugzeugSimulatorSimon;

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
		if(additionalHeight > 100 || additionalHeight < -100){
			throw new GeneralFlightSimulatorException("Plane can't ascend more than 100 m every kilometer");

		}
		else{
			if(!doorOpen && coveredDistance < 2){
				if(coveredDistance == 1 && additionalHeight < (newRoute.getminHeight()-height)){
					throw new GeneralFlightSimulatorException("Plane must surpass minimum height after flying two kilometers");
				}
				else if(height + additionalHeight > newRoute.getmaxHeight()){
					throw new PlaneTooHighException(height);
				}
				height = height + additionalHeight;
				coveredDistance++;

			}
			else if(!doorOpen && coveredDistance >= 2 && coveredDistance >= newRoute.getKilometer()-2 ){
				if(height > newRoute.getmaxHeight()){
					throw new PlaneTooHighException(height);
				}
				height = height + additionalHeight;
				coveredDistance++;

			}
			else if(!doorOpen && coveredDistance >= 2){
				if(height + additionalHeight < newRoute.getminHeight()){
					throw new PlaneTooLowException(height);
				}
				else if(height + additionalHeight > newRoute.getmaxHeight()){
					throw new PlaneTooHighException(height);
				}
				else if(coveredDistance >= newRoute.getKilometer()){
					throw new GeneralFlightSimulatorException("Plane has already arrived or has already flown over final destination without landing");
				}
				height = height + additionalHeight;
				coveredDistance++;
			}
			
			else{
				throw new GeneralFlightSimulatorException("Doors are open. Please close the doors before you try to start flying");
			}
		}

	}

}
