package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil1.aufgabe2;
import static gdi.MakeItSimple.*;
public class test {
	public static void main(String[] args){
		println("Um in Hannover ein Eis zu essen bitte einmal die 1, für München die 2 und für Mannheim die 3.");
		int auswahl = readInt();
		println("Eisnamen eingeben wie in Eisdiele spezifiziert außer bei besondere .");
		if(auswahl == 1){
			println("Guten Tag! Was hätten sie denn gerne?");
			println("Im Angebot haben wir Spaghettieis,Bananasplit,einen Nussbecher,einen rote Früchtebecher und Butterkucheneis.");
			readLine();
			String eis = readLine();
			Eisdiele eiszauber = new EisdieleHannover();
			eiszauber.bestelleEis(eis);
		}
		if(auswahl == 2){
			println("Griaß Gott! Wos hättn's denn gerne? ");
			println("Im Angebot ham mir Spaghettieis,Bananasplit,an Nussbecher und an rote Früchtebecher.");
			readLine();
			String eis = readLine();
			Eisdiele tasty = new EisdieleMünchen();
			tasty.bestelleEis(eis);
			
		}
		if(auswahl == 3){
			println("Jou! Wos hätten se denn gerne? ");
			println("Im Angebot hawwen mir Spaghettieis,Bananasplit,einen Nussbecher und einen rote Früchtebecher.");
			readLine();
			String eis = readLine();
			Eisdiele tasty = new EisdieleMonnem();
			tasty.bestelleEis(eis);
		}
		
	}

}
