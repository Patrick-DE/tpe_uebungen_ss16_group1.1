package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe3;
import static gdi.MakeItSimple.*;
public abstract class Car implements Comparable {
	private String brand;
	private int constructionYear;
	private int price;
	private int ID = 0;
	static int idCounter = 0;


	void setBrand(String brand){
		this.brand = brand;
	}
	String getBrand(){
		return this.brand;
	}
	void setConstructionYear(int constructionYear){
		this.constructionYear = constructionYear;
	}
	int getConstructionYear(){
		return this.constructionYear;
	}
	void setPrice(int price){
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	void setID(){
		this.ID = idCounter;
		idCounter++;
		ID++;
	}
	int getID(){
		return ID;
	}
	public int compareTo(Object obj) {
		if(obj instanceof Car){
			Car car = (Car)obj;
			if(car.getID() == this.getID())
				return 0;
			else if(this.getID() < car.getID())
				return -1;
			else
				return 1;
		}
		else
			throw new GDIException("Vergleich nicht möglich, da Elemente nicht vom selben Typ");
	}

}
