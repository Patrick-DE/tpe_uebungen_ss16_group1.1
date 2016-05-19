package flugzeugSimulatorSimon;

public class PlaneTooLowException extends GeneralFlightSimulatorException {
	private int height;
	public PlaneTooLowException(){
		
	}
	public PlaneTooLowException(int height){
		this.height = height;
		
	}
	public String getMessage(){
		System.out.println("The plane is flying " + height +"m high which is below the minimum permissible height");
		return ""+height;
	}

}
