package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;
import java.util.*;
public class ErzeugerThread extends Thread {
	Ringpuffer puffer;
	int duration;
	Random rand = new Random(5);
	volatile Integer random = rand.nextInt();

	ErzeugerThread(Ringpuffer puffer,int sleepTime){
		super();
		this.puffer = puffer;	
		duration = sleepTime;
	}


	@Override
	public  void run(){
		while(!isInterrupted()){
			try {
				sleep(duration);
			} catch (InterruptedException e) {
				System.out.println(getName() + " was interrupted. " +
						"isInterrupted(): " + isInterrupted());
				return;
			}

			System.out.println(getName() + " - put: " + random);
			puffer.put(random);
			random = rand.nextInt();
		}





		System.out.println("Das Ende " + this.getName());

	}

}
