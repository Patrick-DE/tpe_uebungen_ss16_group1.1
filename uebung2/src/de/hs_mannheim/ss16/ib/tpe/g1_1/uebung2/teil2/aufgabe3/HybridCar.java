package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe3;

public class HybridCar extends Car implements Electric,Gasoline {
	private int voltage;
	private int emissionTier;
	HybridCar(String brand,int constructionYear,int price,int emissionTier, String voltage){
		super.setBrand(brand);
		super.setConstructionYear(constructionYear);
		super.setPrice(price);
		this.emissionTier = emissionTier;
		if(voltage.charAt(0) == 'H'){
			this.voltage = Electric.HIGH_VOLTAGE;
		}
		else{
			this.voltage = Electric.LOW_VOLTAGE;
		}
		
		
	}

	public int getEmissionTier() {
		return emissionTier;
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

	public int getVoltage() {
		return voltage;
	}

}
