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
	
	@Override
	public void run(){
		try {
			sleep(duration);
			} catch (InterruptedException e) {
			System.out.println(getName() + " was interrupted. " +
			"isInterrupted(): " + isInterrupted());
			return;
			}
		while(!isInterrupted()){
			if(!thread.isAlive())
				interrupt();
			if(!puffer.isPufferEmpty()){
				int print = (Integer) puffer.get();
				System.out.println(print);
				synchronized(this){
					this.notifyAll();
				}
			}
			else{
				try {
					synchronized(this){ this.wait();}
				} catch (InterruptedException e) {
					System.out.println(getName() + " was interrupted. " +
							"isInterrupted(): " + isInterrupted());
							return;
				}
			}
			
		}
		System.out.println("Das Ende " + this.getName());
		
	}

}
