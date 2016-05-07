package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCar {

	@Test
	public void testCarAttributes() {
		Car car = new GasolineCar("BMW",2012,25000,2) ;
		assertEquals(car.getBrand(),"BMW");
		assertEquals(car.getPrice(),25000);
		assertEquals(car.getConstructionYear(),2012);
		
	}
	@Test
	public void testSpecificCarMethods() {
		GasolineCar car1 = new GasolineCar("BMW",2012,25000,2) ;
		assertEquals(car1.getEmissionTier(),2);
		ElectricCar car2 = new ElectricCar("Tesla",2012,25000,"HIGH_Voltage");
		assertEquals(car2.getVoltage(),600);
		HybridCar car3 = new HybridCar("Tesla",2012,25000,3,"Low_Voltage");
		assertEquals(car3.getVoltage(),480);
		assertEquals(car3.getEmissionTier(),3);
	}

}
