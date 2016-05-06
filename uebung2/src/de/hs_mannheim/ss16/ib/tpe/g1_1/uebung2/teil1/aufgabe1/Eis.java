package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil1.aufgabe1;
import static gdi.MakeItSimple.*;

public class Eis {
	// Alle relevanten Eigenschaften des Eises werden durch die darunter folgen Setter-Methoden gesetzt.
	String name;
	String behaeltnis;
	String art;
	String [] sorten;
	String extras[];
	double preis = 3.50;
	
	
	public String name(String name) {
		this.name = name;
		return this.name;
	}
	
	public String behaeltnis(String behaeltnis) {
		this.behaeltnis = behaeltnis;
		return this.behaeltnis;
	}
	
	public String art(String art) {
		this.art = art;
		return this.art;
	}
	
	public String[] sorten(String[] sorten) {
		this.sorten = sorten;
		return this.sorten;
	}
	
	public String[] extras(String[] extras) {
		this.extras = extras;
		return this.extras;
	}
	public double preis() {
		if(this.extras != null){
			this.preis = this.preis + this.extras.length*0.5;
		}
		if(this.sorten.length > 3){
			for(int i = 3; i <= this.sorten.length;i++){
				this.preis += 0.5;
			}
		}
		return this.preis;
	}
	public void vorbereiten() {
		if(behaeltnis.charAt(0) == 'W')
			println("Ok, Ich hole kurz die " + this.behaeltnis + ".");
		else
			println("Ok, Ich hole kurz den " + this.behaeltnis + ".");
		println();

	}
	public void fuellen() {
		if(this.sorten.length == 1){
			print("Einmal " + this.sorten[0]+" für sie.");
		}
		else{
			for(int i = 0; i < this.sorten.length; i++){
				if(i == 0)
					print("Einmal " + this.sorten[0]+ ", ");
				else if(i == this.sorten.length-1){
					print("und einmal " + this.sorten[this.sorten.length-1] + " für sie.");
				}
				else{
					print("einmal " + this.sorten[i]+", ");
				}
			}
		}
		println();

	}
	public void dekorieren() {
		if(this.extras != null){
			print("Ich hole kurz die ");
			if(extras.length == 1){
				print(extras[0] +".");
			}
			else{
				for(int i = 0; i < extras.length;i++){
					if(i < extras.length-1)
						print(extras[i]+",");
					else
						print("und die " + extras[i]+".");
				}
			}
		}
		println();

	}

}
