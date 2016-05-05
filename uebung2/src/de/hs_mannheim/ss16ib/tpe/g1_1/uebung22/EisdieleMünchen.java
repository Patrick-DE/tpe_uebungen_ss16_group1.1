package de.hs_mannheim.ss16ib.tpe.g1_1.uebung22;

import static gdi.MakeItSimple.*;

public class EisdieleMünchen extends Eisdiele {

	@Override
	void begrüssen() {
		println("Griaß Gott!");

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
		println("Des macht dann " + preis +" €.");

	}

	@Override
	void verabschieden(String eis) {
			println("Servus! Ich hoff ihr " + eis + " schmeckt erna.");
		}


	@Override
	void entschuldigen(String typ) {
		println("Des dad ma leid " + typ + " hom mir net im Sortiment.");

	}

}
