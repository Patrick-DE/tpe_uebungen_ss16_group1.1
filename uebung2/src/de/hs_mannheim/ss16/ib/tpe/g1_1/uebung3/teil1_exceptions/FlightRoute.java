package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.teil1_exceptions;

public class FlightRoute {

	private int kilometer = 0;
	private int minhöhe = 0;
	private int maxhöhe = 0;
	
	FlightRoute(int kilometer, int minhöhe, int maxhöhe){
		this.kilometer = kilometer;
		this.minhöhe = minhöhe;
		this.maxhöhe = maxhöhe;
	}
	
	public int getKilometer() {
		return kilometer;
	}
	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}
	public int getMinhöhe() {
		return minhöhe;
	}
	public void setMinhöhe(int minhöhe) {
		this.minhöhe = minhöhe;
	}
	public int getMaxhöhe() {
		return maxhöhe;
	}
	public void setMaxhöhe(int maxhöhe) {
		this.maxhöhe = maxhöhe;
	}
}
