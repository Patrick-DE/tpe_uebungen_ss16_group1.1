package de.hs_mannheim.ss16ib.tpe.g1_1.uebung22;


public abstract class Eisdiele {

	String[] angebot = {"Spaghettieis","Bananasplit","Nussbecher","rote Früchtebecher"};
	String[] zubereitungsart = {"Kugeln","Spaghettis","Klekse"};
	String[] sorten = {"Kirsche","Himbeere","Erdbeere","Macadamianuss","Haselnuss","Pistazie","Banane","Straciatella","Zitrone","Schokolade","Vanille"};
	String[] extras = {"Sahne","Schokosträusel","Kekse","Schokososse"};

	abstract void begrüssen();

	public void bestelleEis(String typ){
//		begrüßen();
		Eis eis = erstelleEis(typ);
		if (eis != null) {
			eis.vorbereiten();
			eis.fuellen();
			eis.dekorieren();
			kassieren(eis.preis);
			verabschieden(eis.name);
		} else {
			entschuldigen(typ);
		}
	}


	public abstract Eis erstelleEis(String typ);


	boolean equals(String correct,String test){
		if(test.length() > correct.length()){
			return false;
		}
		else{
			for(int i = 0; i < correct.length();i++){
				if(correct.charAt(i) != test.charAt(i))
					return false;
			}
		}
		return true;
	}
	abstract void kassieren(double preis);

	abstract void verabschieden(String eis);

	abstract void entschuldigen(String typ);

	boolean checkName(String[] möglichkeiten,String test){
		boolean checkName = false;
		int z = 0;
		while(z < möglichkeiten.length && !checkName){
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
