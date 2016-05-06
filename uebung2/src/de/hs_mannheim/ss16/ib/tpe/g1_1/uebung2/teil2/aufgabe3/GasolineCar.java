package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe3;

public class GasolineCar extends Car implements Gasoline {
	private int emissionTier;
	GasolineCar(String brand,int constructionYear,int price,int emissionTier){
		super.setBrand(brand);
		super.setConstructionYear(constructionYear);
		super.setPrice(price);
		this.emissionTier = emissionTier;
	}
	public int compareTo(Object obj) {
		Car car = (Car)obj;
		if(car.getPrice() == this.getPrice())
			return 0;
		else if(this.getPrice() < car.getPrice())
			return -1;
		else
			return 1;
	}
	public int getEmissionTier() {
		return emissionTier;
	}

}
