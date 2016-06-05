package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;

public class VerbraucherThread extends Thread {
	Ringpuffer puffer;
	private int duration;
	TimerThread thread;
	
	VerbraucherThread(Ringpuffer puffer,int sleepTime,TimerThread thread){
		super();
		this.puffer = puffer;
		duration = sleepTime;
		this.thread = thread;
	}
	
	public void run(){
		try {
			sleep(duration);
			} catch (InterruptedException e) {
			System.out.println(getName() + " was interrupted. " +
			"isInterrupted(): " + isInterrupted());
			return;
			}
		while(!isInterrupted() && !thread.isInterrupted()){
			if(!puffer.isPufferEmpty()){
				int print = (Integer) puffer.get();
				System.out.println(print);
			}
			else{
				try {
					this.wait();
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
