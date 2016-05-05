package de.hsmannheim.tpe.ss16.gruppe13.uebung2.eisdielePt1;

import java.util.HashSet;
import java.util.Set;

public abstract class Eis {
	String name; 
	double preis;
	String behaeltnis;
	String art; 
	String[] sorten; 
	String[] extras; 
	private static final double STANDARD_EIS_PREIS = 3;
	private static final String STANDARD_NAME = "Default Eis",
									STANDARD_BEHAELTNIS = "Becher",
									STANDARD_ART = "B‰lle";
	private static final String[] STANDARD_SORTEN = {"Schockolade", "Vanille"},
									STANDARD_EXTRAS = {"Sahne"};
	private static final String[] STANDARD_GERICHTE = {"Spaghettieis","Bananasplit","Nussbecher"};
	//WIR SOLLEN NUR FERTIGE GERICHTE MACHEN KEINE EINZELNEN KUGELN ZUSAMMENSTELLEN
	private static final String Array[][] = { {"Spaghettieis","5","Becher","Spaghettis","Vanille Erdbeere","Fun"},
								            {"Bananasplit","6","Glas","B‰lle","Vanille Banane","Love"},
								            {"Nussbecher","4","Teller","B‰lle","Nuss","Spicy"}};
	
	/**
	 * Der Konstruktor <code>Eis(String name, double preis, String behaeltnis, String art, 
	 * String[] sorten, String[] extras)</code> erstellt ein Eisgericht mit einem Namen,
	 * einem Preis, einem Behaeltnis, einer Art, Eissorten und Extras (z.B. Sahne).
	 * Bei illegalen Eingabe Werten, wie einem <b>negativen Preis</b> und
	 * <b>null Referenzen statt Strings</b>, werden <i>Standard Werte</i> gesetzt.
	 * Soll es keine Extras geben, so uebergebe man ein <code>String[] extras</code> -Array
	 * mit dem Eintrag null. Sorten und Extras die als Duplikate vorkommen (z.B. drei mal die 
	 * Sorte Schokolade) werden aussortiert, sodass diese nur noch einmal vorkommen.
	 * @param String name
	 * @param double preis
	 * @param String behaeltnis
	 * @param String art
	 * @param String[] sorten
	 * @param String[] extras
	 */
	Eis(String name, double preis,
			String behaeltnis, String art, String[] sorten, String[] extras) {
		setName(name);
		setPreis(preis);
		setBehaeltnis(behaeltnis);
		setArt(art);
		setSorten(sorten);
		setExtras(extras);
	}
	
	/**
	 * Die Methode <code>void vorbereiten()</code> gibt auf der Console aus 
	 * <output><i>'Behaeltnis'</i> entnehmen.</output> aus.
	 */
	// /*for test*/ public String vorbereiten() {
	void vorbereiten() { 
		String output = this.behaeltnis + " entnehmen.";
		System.out.println(output);
		
		// /*for test*/ return output;
	}
	
	/**
	 * Die Methode <code>void fuellen()</code> gibt auf der Console aus 
	 * <output><i>'Behaeltnis'</i> mit <i>'Sorte 1', 'Sorte 2', ...</i> 
	 * als <i>'Art'</i> f√ºllen</output> aus.
	 */
	// /*for test*/ public String fuellen() {
	void fuellen() {		
		String output = this.behaeltnis + " mit ";
		
		//Sorten aufzaehlen
		for(int i = 0; i < sorten.length - 1; i++) {
			output += sorten[i] + ", ";
		}
		//letzte Sorte ohne Komma
		output += sorten[sorten.length - 1];
		
		//Art hinzufuegen
		output += " als " + this.art + " f√ºllen.";
		System.out.println(output);
		
		// /*for test*/ return output;
	}
	
	/**
	 * Die Methode <code>void dekorieren()</code> gibt auf der Console aus 
	 * <output><i>'Name'</i> mit <i>'Extra 1', 'Extra 2', ...</i> 
	 * dekorieren</output> aus, es sei denn es ist als Extra null enthalten,
	 * dann wird ausgegeben <output><i>'Name'</i> wird nicht dekoriert.</output>.
	 */
	void dekorieren() {		
		String output;
		
		//falls das Eis Extras hat
		//ansonsten wird das Eis nicht dekoriert
		if(this.extras[0] != null) {
			output = this.name + " mit ";
			
			//Extras aufzaehlen
			for(int i = 0; i < extras.length - 1; i++) {
				output += extras[i] + ", ";
			}
			//letzte Sorte ohne Komma
			output += extras[extras.length - 1];
			
			output += " dekorieren.";
			
		} else {
			output = this.name + " wird nicht dekoriert.";
		}
		
		System.out.println(output);
		
		// /*for test*/ return output;
	}

	//Methode zum setzen des Eisnamens
	//falls null STANDARD_NAME
	void setName(String name) {
		if(name != null) {
			this.name = name;
		} else
			this.name = STANDARD_NAME;
	}
	
	//Methode zum setzen des Eispreises
	//Ueberprueft ob der Preis legal, ansonsten
	//STANDARD_EIS_PREIS
	void setPreis(double preis) {
		if(preis >= 0) {
			this.preis = preis;
		} else 
			preis = STANDARD_EIS_PREIS;
	}
	
	//Methode zum setzen des Behaehltnis-Namens
	//falls null STANDARD_BEHAELTNIS
	void setBehaeltnis(String behaeltnis) {
		if(behaeltnis != null) {
			this.behaeltnis = behaeltnis;
		} else
			this.behaeltnis = STANDARD_BEHAELTNIS;
	}
	
	//Methode zum setzen der Art
	//falls null STANDARD_ART
	void setArt(String art) {
		if(art != null) {
			this.art = art;
		} else
			this.art = STANDARD_ART;
	}
	
	//ueberpruefe, das Sorten nicht mehrmals vorkommen
	//falls sorten == null oder Inhalt null, dann STANDARD_SORTEN
	void setSorten(String[] sorten) {
//		if(sorten != null && filterOutRedundance(sorten)[0] != null) {
		if(sorten != null) {
			this.sorten = filterOutRedundance(sorten);
		} else
			this.sorten = STANDARD_SORTEN;
	}
	
	//ueberpruefe, das Extras nicht mehrmals vorkommen
	//falls extras == null, dann STANDARD_EXTRAS
	void setExtras(String[] extras) {
		if(extras != null) {
			this.extras = filterOutRedundance(extras);
		} else
			this.sorten = STANDARD_EXTRAS;
		
	}
	
	//Methode die duplikate aus einem StringArray entsorgt
	//und das gesaeuberte Array zurueckliefert
	// /*for test*/public String[] filterOutRedundance(String[] init) {
	String[] filterOutRedundance(String[] init) {
		Set<String> strings = new HashSet<>();
		
		//fuege die Strings des init Arrays dem Set hinzu
		//wobei duplikate getilgt werden
		for(String curr : init) {
			strings.add(curr);
		}
		
		//falls sich nun die groesse des Sets von dem 
		//des inits unterscheidet bilde neues Set
		//mit entsprechender groesse und fuege Elemente ein
		if(strings.size() != init.length) {
			//falls das Array groesser als 1 ist und noch null
			//enthaelt soll dieses entfernt werden
			if(strings.size() > 1) {
				strings.remove(null);
			}
			
			init = new String[strings.size()];
			init = strings.toArray(init);
		} //ansonsten lasse init wie es ist
		
		return init;
	}

	public static String[] getStandardGerichte() {
		return STANDARD_GERICHTE;
	}
}
