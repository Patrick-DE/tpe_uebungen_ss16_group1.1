package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.autoverwaltung;

public class ElectricCar extends Car implements Electric {
	private int voltage;

	ElectricCar(String brand,int constructionYear,int price, String voltage){
		super.setBrand(brand);
		super.setConstructionYear(constructionYear);
		super.setPrice(price);
		if(voltage.charAt(0) == 'H'){
			this.voltage = Electric.HIGH_VOLTAGE;
		}
		else{
			this.voltage = Electric.LOW_VOLTAGE;
		}
		
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
