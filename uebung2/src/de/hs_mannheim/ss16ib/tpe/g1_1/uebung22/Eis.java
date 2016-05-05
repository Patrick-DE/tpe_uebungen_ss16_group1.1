package de.hs_mannheim.ss16ib.tpe.g1_1.uebung22;

public abstract class Eis {
	String name;
	String behaeltnis;
	String art;
	String [] sorten;
	String extras[];
	double preis = 3.50;

	public abstract String name(String typ);
	
	public abstract String behaeltnis();
	
	public abstract String art();
	
	public abstract String[] sorten();

	public abstract String[] extras();
	
	public abstract double preis();
	
	public abstract void vorbereiten();
	
	public abstract void fuellen();
	
	public abstract void dekorieren();

	
}
