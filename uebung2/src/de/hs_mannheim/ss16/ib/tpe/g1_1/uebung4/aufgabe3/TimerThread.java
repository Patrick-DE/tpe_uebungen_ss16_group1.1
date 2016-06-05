package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;

public class TimerThread extends Thread {
	int duration;
	
	TimerThread(int sleepTime){
		duration = sleepTime;
		
	}
	
	public void run(){
		try{
			this.sleep(duration);
		}
		catch(InterruptedException e){
			
		}
		this.interrupt();
	}
}
