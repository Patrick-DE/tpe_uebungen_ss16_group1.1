package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;

public class VerbraucherThread extends Thread {
	Ringpuffer puffer;
	private int duration;

	VerbraucherThread(Ringpuffer puffer,int sleepTime){
		super();
		this.puffer = puffer;
		duration = sleepTime;
	}

	@Override
	public void run(){
		// Condition is !isInterrupted so that run terminates when thread is interrupted in timerThread
		while(!isInterrupted()){
			// Sleeps for the given duration so that staggered execution of threads is possible

			try {
				sleep(duration);
			} catch (InterruptedException e) {
				System.out.println(getName() + " was interrupted. " +
						"isInterrupted(): " + isInterrupted());
				return;
			}
			
			try{
				int print = (Integer) puffer.get();
				System.out.println(getName() + " - get: " + print);
				System.out.println("get " + print);
			}
			catch(NullPointerException e){
				
			}
			
		}



		System.out.println("Das Ende " + this.getName());


	}

}
