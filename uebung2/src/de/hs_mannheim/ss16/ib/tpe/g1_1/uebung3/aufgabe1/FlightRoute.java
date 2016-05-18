package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

public class FlightRoute {

	private int kilometer = 0;
	private int minhoehe = 0;
	private int maxhoehe = 0;
	
	FlightRoute(int kilometer, int minhoehe, int maxhoehe){
		setKilometer(kilometer);
		setMinhoehe(minhoehe);
		setMaxhoehe(maxhoehe);
//		this.kilometer = kilometer;
//		this.minhoehe = minhoehe;
//		this.maxhoehe = maxhoehe;
	}
	
	public int getKilometer() {
		return kilometer;
	}
	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}
	public int getMinhoehe() {
		return minhoehe;
	}
	public void setMinhoehe(int minhoehe) {
		this.minhoehe = minhoehe;
	}
	public int getMaxhoehe() {
		return maxhoehe;
	}
	public void setMaxhoehe(int maxhoehe) {
		this.maxhoehe = maxhoehe;
	}
}
