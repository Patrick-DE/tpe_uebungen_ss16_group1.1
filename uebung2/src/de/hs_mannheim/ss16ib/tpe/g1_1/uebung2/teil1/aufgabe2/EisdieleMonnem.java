package de.hs_mannheim.ss16ib.tpe.g1_1.uebung2.teil1.aufgabe2;

import static gdi.MakeItSimple.*;

public class EisdieleMonnem extends Eisdiele {

	@Override
	void begrüssen() {
		println("Jou!");

	}

	public Eis erstelleEis(String typ) {
		if(!checkName(angebot,typ)){
			return null;
		}
		Eis eis = null;
		if(equals(typ,super.angebot[0])){
			eis = new SpaghettieisMonnem();
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
		

		eis.name(typ);
		eis.behaeltnis();
		eis.art();
		eis.sorten();
		eis.extras();
		return eis;
	}

	@Override
	void kassieren(double preis) {
		println("Dos macht donn " + preis +" €.");

	}

	@Override
	void verabschieden(String eis) {
			println("Alla! Lossen sie sich ihrn " + eis + " schmecka.");
		}


	@Override
	void entschuldigen(String typ) {
		println("dud mir leid " + typ + " hawwen mir nit im Sortiment.");

	}

}
