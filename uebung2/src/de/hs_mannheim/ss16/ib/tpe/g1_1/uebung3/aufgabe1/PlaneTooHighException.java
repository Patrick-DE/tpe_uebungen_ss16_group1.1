package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

public class PlaneTooHighException extends GeneralFlightSimulatorException {
	private int height;
	public PlaneTooHighException(){
		
	}
	public PlaneTooHighException(int height){
		this.height = height;
		
	}
	public String getMessage(){
		System.out.println("The plane is flying " + height +"m high which exceeds the maximum permissible height");
		return ""+height;
	}
	public String toString(){
		return "PlaneTooHighException";
	}
	

}
