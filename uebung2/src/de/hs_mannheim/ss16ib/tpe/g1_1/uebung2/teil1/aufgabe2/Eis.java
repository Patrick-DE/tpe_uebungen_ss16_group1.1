package de.hs_mannheim.ss16ib.tpe.g1_1.uebung2.teil1.aufgabe2;

public abstract class Eis {
	String name;
	String behaeltnis;
	String art;
	String [] sorten;
	String extras[];
	double preis = 3.50;
	
	/** Setter Methode für das Feld name von Eis.
	 * @return Name der dem Feld name zugewiesen wurde.
	 */
	public abstract String name(String typ);
	/** Setter Methode für das Feld behaelnis von Eis.
	 * @return Behaltnis,das dem Feld behaeltnis zugewiesen wurde.
	 */
	public abstract String behaeltnis();
	/** Setter Methode für das Feld art von Eis.
	 * @return Art,das dem Feld art zugewiesen wurde.
	 */
	public abstract String art();
	/** Setter Methode für das Feld sorten von Eis.
	 * @return String array sorten,das dem Feld sorten zugewiesen wurde.
	 */
	public abstract String[] sorten();
	/** Setter Methode für das Feld extras von Eis.
	 * @return String array extras,das dem Feld extras zugewiesen wurde.
	 */
	public abstract String[] extras();
	/** Setter Methode für das Feld preis von Eis.
	 * @return Der Preis, der dem Feld preis zugewiesen wurde.
	 */
	public abstract double preis();
	
	public abstract void vorbereiten();
	
	public abstract void fuellen();
	
	public abstract void dekorieren();

	
}
