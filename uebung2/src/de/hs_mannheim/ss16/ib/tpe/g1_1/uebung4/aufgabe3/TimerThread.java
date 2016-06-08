package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;

public class TimerThread extends Thread {

	Ringpuffer puffer = new Ringpuffer(10);
	int runTime;
	ErzeugerThread one = new ErzeugerThread(puffer, 200);
	ErzeugerThread two = new ErzeugerThread(puffer, 100);
	ErzeugerThread three = new ErzeugerThread(puffer, 50);
	VerbraucherThread four = new VerbraucherThread(puffer, 50);
	VerbraucherThread five = new VerbraucherThread(puffer, 60);

	TimerThread(int sleepTime) {
		super();
		runTime = sleepTime;
		one.start();
		two.start();
		three.start();
		four.start();
		five.start();

	}

	public void run() {
		try {
			while (runTime != 0) {
				sleep(1000);
				System.out.println("========================");
				System.out.println(runTime);
				System.out.println("========================");
				runTime--;
			}
			one.interrupt();
			two.interrupt();
			three.interrupt();
			four.interrupt();
			five.interrupt();
			System.out.println("Programm should stop!");
		} catch (InterruptedException e) {
			// System.out.println(getName() + " was interrupted. " +
			// "isInterrupted(): " + isInterrupted());

		}

	}
}
