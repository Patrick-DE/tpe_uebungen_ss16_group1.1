package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;
import java.util.*;
public class ErzeugerThread extends Thread {
	Ringpuffer puffer;
	int duration;
	TimerThread thread;

	ErzeugerThread(Ringpuffer puffer,int sleepTime,TimerThread thread){
		super();
		this.puffer = puffer;	
		duration = sleepTime;
		this.thread = thread;
	}


	public void run(){
		Random rand = new Random(5);
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(getName() + " was interrupted. " +
					"isInterrupted(): " + isInterrupted());
			return;
		}

		while(!isInterrupted() && !thread.isInterrupted()){
			Integer random = rand.nextInt();
			if(!puffer.isPufferFull()){
				puffer.put(random);
				synchronized(this){this.notifyAll();}
			}
			else{

				try {
					synchronized(this){this.wait();}
				} catch (InterruptedException e) {
					System.out.println(getName() + " was interrupted. " +
							"isInterrupted(): " + isInterrupted());
					return;
				}
			}


	}
	this.interrupt();

}

}
