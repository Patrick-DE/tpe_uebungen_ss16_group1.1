package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;

public class TimerThread extends Thread {
	int duration;
	
	TimerThread(int sleepTime){
		super();
		duration = sleepTime;
		
		
	}
	
	public void run(){
		try{
			sleep(duration);
					}
		catch(InterruptedException e){
			System.out.println(getName() + " was interrupted. " +
					"isInterrupted(): " + isInterrupted());
			
		}

		
	}
}
