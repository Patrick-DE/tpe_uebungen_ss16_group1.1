package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFlyNextKilometer {

	@Test
	public void testCorrectInput() {
		FlightRoute route = new FlightRoute(100,200,1500);
		Plane plane = new Touristenflugzeug(0, false, false, true, 0,route);
		try{
			plane.flyNextKilometer(100);
		}
		catch(GeneralFlightSimulatorException x){
			
		}
		assertEquals(100,plane.getheight());
		assertEquals(1,plane.getcoveredDistance());
			
	}
	@Test
	public void testFallBelowMinHeight(){
		FlightRoute route = new FlightRoute(100,200,1500);
		Plane plane = new Touristenflugzeug(0, false, false, true, 0,route);
		try{
			plane.flyNextKilometer(100);
		}
		catch(GeneralFlightSimulatorException x){
			
		}
		try{
			plane.flyNextKilometer(50);
		}
		catch(GeneralFlightSimulatorException x){
			assertEquals("PlaneTooLowException",x.toString());
			
		}
	}
	@Test
	public void testAscendAboveMaxHeight(){
		FlightRoute route = new FlightRoute(100,200,300);
		Plane plane = new Touristenflugzeug(0, false, false, true, 0,route);
		for(int i = 0; i <= 4;i++){
		try{
			plane.flyNextKilometer(100);
		}
		catch(GeneralFlightSimulatorException x){	
			assertEquals("PlaneTooHighException",x.toString());
		}
		}
		
	}
	@Test 
	public void testFlyOverDestination(){
		FlightRoute route = new FlightRoute(10,200,1300);
		Plane plane = new Touristenflugzeug(0, false, false, true, 0,route);
		for(int i = 0; i < 11;i++){
		try{
			plane.flyNextKilometer(100);
		}
		catch(GeneralFlightSimulatorException x){	
			assertEquals("Plane has already arrived or has already flown over final destination without landing",x.getMessage());
		}
		}
		
	}
	
	@Test
	public void testInputTooGreatOrTooSmall(){
		FlightRoute route = new FlightRoute(100,200,1500);
		Plane plane = new Touristenflugzeug(0, false, false, true, 0,route);
		try{
			plane.flyNextKilometer(150);
		}
		catch(GeneralFlightSimulatorException x){	
			assertEquals(x.toString(),"GeneralFlightException");
		}
		try{
			plane.flyNextKilometer(-500);
		}
		catch(GeneralFlightSimulatorException x){	
			assertEquals(x.toString(),"GeneralFlightException");
		}
	
	}
	
	@Test 
	public void testDoorOpen(){
		FlightRoute route = new FlightRoute(10,200,1300);
		Plane plane = new Touristenflugzeug(0, false, true, true, 0,route);
		try{
			plane.flyNextKilometer(100);
		}
		catch(GeneralFlightSimulatorException x){	
			assertEquals("Doors are open. Please close the doors before you try to start flying",x.getMessage());
		}
		}
		
	

}
