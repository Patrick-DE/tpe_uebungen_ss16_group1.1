package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;

public class Ringpuffer {
	volatile int getPosition = 0, putPosition = 0;
	Object[] puffer;

	public Ringpuffer(int pufferLength) {
		puffer = new Object[pufferLength];
	}
	// puts the object put at putPosition
	// if the puffer array is already holding and object at the putPosition the thread which tries to put, will be forced to wait
	public synchronized void put(Object put) {
	// modulo makes sure the putPosition is always in the bounds of the puffer array
		putPosition = putPosition % puffer.length;
		System.out.println(putPosition + " put");
		if (puffer[putPosition] == null) {
			puffer[putPosition] = put;
			putPosition++;
		//if the put process was successful all threads will be notified so that a new Thread can get into the monitor
			notifyAll();
		} else {
			try {
				System.out.println("Thread is Waiting");
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread is Waiting");
			}
		}

		

	}
	// gets an object from the getPosition
	// if no object is found at getPosition, the thread is forced to wait
	public synchronized Object get() {
		Object get = null;
		getPosition = getPosition % puffer.length;
		System.out.println(getPosition + " get");
		if (puffer[getPosition] != null) {
			get = puffer[getPosition];
			puffer[getPosition] = null;
			getPosition++;
			System.out.println("getPosition incremented " + getPosition);
			//if the get process was successful all threads will be notified so that a new Thread can get into the monitor
			notifyAll();
		} else {
			try {
				System.out.println("Thread is Waiting");
				wait();
			} catch (InterruptedException e) {

			}
		}
		
		return get;

	}
	// Checks whether the puffer is empty at getPosition
	public synchronized boolean isPufferEmpty() {
		getPosition = getPosition % puffer.length;
		if (puffer[getPosition] == null) {
			return true;
		}
		return false;
	}
	// Checks whether the puffer is full at putPosition
	public synchronized boolean isPufferFull() {
		putPosition = putPosition % puffer.length;
		if (puffer[putPosition] == null) {
			return false;
		}
		return true;
	}

}
