package de.hsmannheim.tpe.ss16.gruppe13.uebung2.eisdielePt1;

public abstract class Eisdiele extends Eis{

	Eisdiele(String name, double preis, String behaeltnis, String art, String[] sorten, String[] extras) {
		super(name, preis, behaeltnis, art, sorten, extras);
		// TODO Auto-generated constructor stub
	}
	
	void begruessen(){
		System.out.println("Herzlich Willkommen! Was möchten Sie essen?");
	}
	void kassieren(int kosten){
		System.out.println("Das kostet: " + kosten + " !");
	}
	void verabschieden(){
		System.out.println("Auf Wiedersehen und lassen Sie sich ihr Eis schmecken!");
	}
	void entschuldigen(){		//(Falls die bestellte Eissorte nicht auf der Karte steht)
		System.out.println("Bitten entschuldigen Sie! Das von Ihnen gewählte Eis ist nicht auf der Karte!");
	}
	public Eis erstellen(String typ){
		//TODO REGINAL EIS ERZEUGEN
		return null;
	}
	
	public void bestellen(String typ){
		
	}
	
	boolean isAvail(String name){
		for(int i=0; i< getStandardGerichte().length; i++){
			if(getStandardGerichte()[i].equals(name)){
				return true;
			}
		}
		entschuldigen();
		return false;
		
	}
	
	void toString(Eisdiele eis1){
		System.out.println("Sie haben ein "+ eis1.name + " bestellt!");
		System.out.println("Das kostet "+ eis1.preis + " Euro!");
		System.out.println("Sie bekommen Ihr Eis in einem "+ eis1.behaeltnis);
		System.out.println("Die Form des Eis ist ein "+ eis1.art);
		String alleSorten = "";
		for(int i=0; i<eis1.sorten.length; i++){
			alleSorten += eis1.sorten;
		}
		System.out.println("Das Eis enthält die Sorten "+ alleSorten);
		String alleExtras = "";
		for(int i=0; i<eis1.extras.length; i++){
			alleExtras += eis1.extras;
		}
		if(eis1.extras == null){
			System.out.println("Auf Ihrem Eis sind keine Extras!");
		}else{
			System.out.println("Auf Ihrem Eis sind folgende Extras: "+ alleExtras);
		}
	}
	
}
