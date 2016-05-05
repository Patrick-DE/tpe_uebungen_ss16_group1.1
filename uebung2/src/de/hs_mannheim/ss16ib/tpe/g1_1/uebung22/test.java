package de.hs_mannheim.ss16ib.tpe.g1_1.uebung22;
import static gdi.MakeItSimple.*;
public class test {
	public static void main(String[] args){
		println("Um in Hannover ein Eis zu essen bitte einmal die 1, für München die 2 und für Mannheim die 3.");
		int auswahl = readInt();
		if(auswahl == 1){
			println("Guten Tag! Was hätten sie denn gerne?");
			readLine();
			String eis = readLine();
			Eisdiele eiszauber = new EisdieleHannover();
			eiszauber.bestelleEis(eis);
		}
		if(auswahl == 2){
			println("Griaß Gott! Wos hättn's denn gerne? ");
			readLine();
			String eis = readLine();
			Eisdiele tasty = new EisdieleMünchen();
			tasty.bestelleEis(eis);
			
		}
		if(auswahl == 3){
			println("Jou! Wos hätten se denn gerne? ");
			readLine();
			String eis = readLine();
			Eisdiele tasty = new EisdieleMonnem();
			tasty.bestelleEis(eis);
		}
		
	}

}
