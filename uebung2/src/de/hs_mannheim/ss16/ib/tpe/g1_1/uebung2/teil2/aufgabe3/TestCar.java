package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe3;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe1.BTree;

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
	@Test
	public void testCompareTo(){
		//ID is compared(is incremented for each instance of Car).
		Car bmw = new GasolineCar("BMW",2012,25000,2);
		Car vw = new HybridCar("VW",2014,30000,1,"LOW_VOLTAGE");
		assertEquals(0,bmw.compareTo(bmw));
		assertEquals(-1,bmw.compareTo(vw));
		assertEquals(1,vw.compareTo(bmw));
	}
	@Test
	public void insertCarsIntoBTree(){
		BTree cars = new BTree(2);
		Car bmw = new GasolineCar("BMW",2012,25000,2);
		Car audi = new GasolineCar("Audi",2011,22000,3);
		Car tesla = new ElectricCar("Tesla",2015,50000,"HIGH_Voltage");
		Car vw = new HybridCar("VW",2014,30000,1,"LOW_VOLTAGE");
		cars.insert(bmw);
		cars.insert(audi);
		cars.insert(tesla);
		cars.insert(vw);
		assertEquals(true,cars.contains(bmw));
		assertEquals(vw,cars.getMax());
		assertEquals(bmw,cars.getMin());
		cars.delete(vw);
		assertEquals(false,cars.contains(vw));
		
	}

}
