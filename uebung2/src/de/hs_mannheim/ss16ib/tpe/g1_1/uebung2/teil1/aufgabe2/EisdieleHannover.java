package de.hs_mannheim.ss16ib.tpe.g1_1.uebung2.teil1.aufgabe2;

import static gdi.MakeItSimple.*;

public class EisdieleHannover extends Eisdiele {
	String lokalesEis = "Butterkucheneis";

	@Override
	void begrüssen() {
		println("Guten Tag!");

	}

	public Eis erstelleEis(String typ) {
		if(!checkName(angebot,typ) && !equals(lokalesEis,typ)){
			return null;
		}
		Eis eis = null;
		if(equals(typ,super.angebot[0])){
			eis = new Spaghettieis();
		}
		else if(equals(typ,super.angebot[1])){
			eis = new Bananasplit();
		}
		else if(equals(typ,super.angebot[2])){
			eis = new Nussbecher();

		}
		else if(equals(typ,super.angebot[3])){
			eis = new RoteFrüchteBecher();
		}
		else if(equals(typ,lokalesEis)){
			eis = new ButterKuchenEis(); 
		}

		eis.name(typ);
		eis.behaeltnis();
		eis.art();
		eis.sorten();
		eis.extras();
		return eis;
	}

	@Override
	void kassieren(double preis) {
		println("Das macht dann " + preis +" €.");

	}

	@Override
	void verabschieden(String eis) {
		if(equals(eis, lokalesEis) || equals(eis,angebot[0]))
			println("Auf Wiedersehen! Lassen sie sich ihr " + eis + " schmecken.");
		else{
			println("Auf Wiedersehen! Lassen sie sich ihren " + eis + " schmecken.");
		}

	}

	@Override
	void entschuldigen(String typ) {
		println("Tut mir leid " + typ + " haben wir leider nicht im Sortiment.");

	}

}
