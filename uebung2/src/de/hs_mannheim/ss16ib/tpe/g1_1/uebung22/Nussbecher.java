package de.hs_mannheim.ss16ib.tpe.g1_1.uebung22;
import static gdi.MakeItSimple.*;

public class Nussbecher extends Eis {

	@Override
	public void vorbereiten() {
		if(super.behaeltnis.charAt(0) == 'W')
			println("Ok, Ich hole kurz die " + super.behaeltnis + ".");
		else
			println("Ok, Ich hole kurz den " + super.behaeltnis + ".");
		println();

	}

	@Override
	public void fuellen() {
		if(super.sorten.length == 1){
			print("Einmal " +super.sorten[0]+" für sie.");
		}
		else{
			for(int i = 0; i < super.sorten.length; i++){
				if(i == 0)
					print("Einmal " + super.sorten[0]+ ", ");
				else if(i == super.sorten.length-1){
					print("und einmal " + super.sorten[super.sorten.length-1] + " für sie.");
				}
				else{
					print("einmal " + super.sorten[i]+", ");
				}
			}
		}
		println();

		
	}

	@Override
	public void dekorieren() {
		if(super.extras != null){
			print("Ich hole kurz die ");
			if(super.extras.length == 1){
				print(super.extras[0] +".");
			}
			else{
				for(int i = 0; i < super.extras.length;i++){
					if(i < super.extras.length-1)
						print(super.extras[i]+",");
					else
						print("und die " + super.extras[i]+".");
				}
			}
		}
		println();

		
	}

	@Override
	public String name(String name) {
		super.name = name;
		return super.name;
	}

	@Override
	public String behaeltnis() {
		super.behaeltnis = "Becher";
		return super.behaeltnis;
	}

	@Override
	public String art() {
		super.art = "Kugeln";
		return super.art;
	}

	@Override
	public String[] sorten() {
		super.sorten = new String[3];
		super.sorten[0] = "Haselnuss";
		super.sorten[1] = "Macadamianuss";
		super.sorten[2] = "Pistazie";
		return super.sorten;
	}

	@Override
	public String[] extras() {
		super.extras = new String[1];
		super.extras[0] = "Schokosträusel";
		return super.extras;
	}

	@Override
	public double preis() {
		super.preis = 4.50;
		return super.preis;
	}
	
	

}
