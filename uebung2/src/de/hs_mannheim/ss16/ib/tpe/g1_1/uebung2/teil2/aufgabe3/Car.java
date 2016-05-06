package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe3;

public abstract class Car implements Comparable {
	private String brand;
	private int constructionYear;
	private int price;
	
	
	void setBrand(String brand){
		this.brand = brand;
	}
	void setConstructionYear(int constructionYear){
		this.constructionYear = constructionYear;
	}
	void setPrice(int price){
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}

}
