package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe1;

import de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe3.*;
import static gdi.MakeItSimple.*;
public class BTreeWithCarObjects {
	public static void main(String[] args){
		BTree cars = new BTree(2);
		Car bmw = new GasolineCar("BMW",2012,25000,2);
		Car audi = new GasolineCar("Audi",2011,22000,3);
		Car tesla = new ElectricCar("Tesla",2015,50000,"HIGH_Voltage");
		Car vw = new HybridCar("VW",2014,30000,1,"LOW_VOLTAGE");
		cars.insert(bmw);
		cars.insert(audi);
		cars.insert(tesla);
		cars.insert(vw);
		println(cars.contains(bmw));
		println(cars.insert(bmw));
	}

}
