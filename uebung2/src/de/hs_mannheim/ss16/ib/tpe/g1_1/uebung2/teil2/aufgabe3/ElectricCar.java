package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe3;

public class ElectricCar extends Car implements Electric {
	private int voltage;

	public ElectricCar(String brand,int constructionYear,int price, String voltage){
		super.setBrand(brand);
		super.setConstructionYear(constructionYear);
		super.setPrice(price);
		if(voltage.charAt(0) == 'H'){
			this.voltage = Electric.HIGH_VOLTAGE;
		}
		else{
			this.voltage = Electric.LOW_VOLTAGE;
		}
		super.setID();
		
	}

	public int getVoltage() {
		return this.voltage;
	}
	


}
