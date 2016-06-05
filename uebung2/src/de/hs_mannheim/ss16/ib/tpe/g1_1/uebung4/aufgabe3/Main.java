package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;

public class Main {
	

	public static void main(String[] args) {
		Ringpuffer puffer = new Ringpuffer(10);
		TimerThread time = new TimerThread(150);
		ErzeugerThread one = new ErzeugerThread(puffer,200,time);
		ErzeugerThread two = new ErzeugerThread(puffer,100,time);
		ErzeugerThread three = new ErzeugerThread(puffer,50,time);
		VerbraucherThread four = new VerbraucherThread(puffer,75,time);
		VerbraucherThread five = new VerbraucherThread(puffer,60,time);
		time.start();
		one.start();
		two.start();
		three.start();
		four.start();
		five.start();
	
	}

}
