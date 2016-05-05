package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2;
import static gdi.MakeItSimple.*;

public class Eisdiele {

	String[] angebot = {"Spaghettieis","Bananasplit","Nussbecher","rote Früchtebecher"};
	String[] zubereitungsart = {"Kugeln","Spaghettis","Klekse"};
	String[] sorten = {"Kirsche","Himbeere","Erdbeere","Macadamianuss","Haselnuss","Pistazie","Banane","Straciatella","Zitrone","Schokolade","Vanille"};
	String[] extras = {"Sahne","Schokosträusel","Kekse","Schokososse"};

	void begrüssen(){
		println("Guten Tag, Was hätten sie denn gerne für ein Eis?");
		println("Im Angebot haben wir Spaghettieis,Bananasplit,einen Nussbecher und einen rote Früchtebecher.");
	}

	public void bestellen(){
		begrüssen();
		Eis eis = new Eis();
		String name = readLine();
		while(checkName(angebot,name) == false){
			entschuldigen();
			name = readLine();
		}



		eis.name(name);
		println("Hätten sie ihr Eis gerne in der Waffel oder im Becher?");
		String behaeltnis = readLine();
		int i = 0;
		while(equals(behaeltnis,"Waffel") == false && equals(behaeltnis,"Becher") == false){
			println("Ich habe sie nicht verstanden. Könnten sie das nochmal wiederholen?");
			behaeltnis = readLine();
		}
		eis.behaeltnis(behaeltnis);
		eis.vorbereiten();

		String art;
		if(equals(name,angebot[0])){
			art = zubereitungsart[1];
		}
		else{
			println("Hätten sie ihr Eis gerne als Kugeln, als Spaghettis oder als Klekse?");
			art = readLine();
		}
		while(checkName(zubereitungsart,art) == false){
			entschuldigen();
			art = readLine();
		}

		eis.art(art);

		String gewählteSorten[];
		if(equals(name,angebot[1])){
			gewählteSorten = new String[2];
			gewählteSorten[0] = sorten[6];
			gewählteSorten[1] = sorten[7];
		}
		else if(equals(name,angebot[2])){
			gewählteSorten = new String[3];
			gewählteSorten[0] = sorten[3];
			gewählteSorten[1] = sorten[4];
			gewählteSorten[1] = sorten[5];
		}
		else if(equals(name,angebot[3])){
			gewählteSorten = new String[3];
			gewählteSorten[0] = sorten[0];
			gewählteSorten[1] = sorten[1];
			gewählteSorten[1] = sorten[2];
		}
		else{
			println("Wieviele verschiedene Eissorten hätten sie denn gerne?");
			int anzahl = readInt();
			println("Wir bieten Kirsche,Himbeere,Erdbeere,Macadamianuss,Haselnuss,Pistazie,Banane,Straciatella,Zitrone,Schokolade und Vanille an");
			gewählteSorten = new String[anzahl];
			readLine();
			for(i = 0; i < gewählteSorten.length; i++){
				gewählteSorten[i] = readLine();
			}
			while(checkName(sorten,gewählteSorten) == false){
				entschuldigen();
				for(i = 0; i < gewählteSorten.length; i++){
					gewählteSorten[i] = readLine();
				}
			}
			eis.sorten(gewählteSorten);
			eis.fuellen();

		}




		eis.sorten(gewählteSorten);
		println("Wieviele Extras hätten sie gerne?");
		int anzahl = readInt();
		if(anzahl != 0){
			println("Wir haben Sahne,Schokosträusel,Kekse und Schokososse.");
			String gewählteExtras[] = new String[anzahl];
			readLine();
			for(i = 0; i < gewählteExtras.length; i++){
				gewählteExtras[i] = readLine();
			}
			while(checkName(extras,gewählteExtras) == false){
				entschuldigen();
				for(i = 0; i < gewählteExtras.length; i++){
					gewählteExtras[i] = readLine();
				}
			}
			eis.extras(gewählteExtras);
		}
		eis.dekorieren();
		kassieren(eis);
		verabschieden();



	}
	boolean equals(String correct,String test){
		for(int i = 0; i < correct.length();i++){
			if(correct.charAt(i) != test.charAt(i))
				return false;
		}
		return true;
	}
	void kassieren(Eis eis){
		println("Hier bitte sehr.");
		println("Das macht dann " + eis.preis() +"€.");

	}
	void verabschieden(){
		println("Auf Wiedersehen! Lassen sie sich ihr Eis schmecken!");

	}
	void entschuldigen(){
		println("Tut mir leid, diese Eissorte(n) oder Extras haben wir nicht im Sortiment. Hätten sie gerne etwas anderes?");


	}
	boolean checkName(String[] möglichkeiten,String test){
		boolean checkName = false;
		int z = 0;
		while(z < möglichkeiten.length && checkName == false){
			while(z < möglichkeiten.length){
				if(equals(test,möglichkeiten[z])){
					checkName = true;
					return checkName;

				}
				z++;
			}



		}
		return checkName;

	}
	boolean checkName(String[] möglichkeiten,String[] test){
		int count = 0;
		int i = 0;
		while(i < test.length){
			int z = 0;
			while(z < möglichkeiten.length){
				if(equals(test[i],möglichkeiten[z])){
					count++;

				}
				z++;
			}
			i++;
		}
		if(count == test.length){
			return true;
		}



		return false;

	}

}
