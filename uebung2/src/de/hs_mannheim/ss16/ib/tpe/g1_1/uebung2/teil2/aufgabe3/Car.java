package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe3;

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

}
