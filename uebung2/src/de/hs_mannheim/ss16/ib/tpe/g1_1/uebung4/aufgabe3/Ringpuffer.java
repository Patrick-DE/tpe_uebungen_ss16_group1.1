package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;

public class Ringpuffer {
	volatile int getPosition = 0, putPosition = 0;
	Object[] puffer;

	public Ringpuffer(int pufferLength) {
		puffer = new Object[pufferLength];
	}

	public synchronized void put(Object put) {
		putPosition = putPosition % puffer.length;
		System.out.println(putPosition + " put");
		if (puffer[putPosition] == null) {
			puffer[putPosition] = put;
			putPosition++;
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

	public synchronized Object get() {
		Object get = null;
		getPosition = getPosition % puffer.length;
		System.out.println(getPosition + " get");
		if (puffer[getPosition] != null) {
			get = puffer[getPosition];
			puffer[getPosition] = null;
			getPosition++;
			System.out.println("getPosition incremented " + getPosition);
			notifyAll();
		} else {
			try {
				System.out.println("Thread is Waiting");
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread is Waiting");

			}
		}
		
		return get;

	}

	public synchronized boolean isPufferEmpty() {
		getPosition = getPosition % puffer.length;
		if (puffer[getPosition] == null) {
			return true;
		}
		return false;
	}

	public synchronized boolean isPufferFull() {
		putPosition = putPosition % puffer.length;
		if (puffer[putPosition] == null) {
			return false;
		}
		return true;
	}

}
