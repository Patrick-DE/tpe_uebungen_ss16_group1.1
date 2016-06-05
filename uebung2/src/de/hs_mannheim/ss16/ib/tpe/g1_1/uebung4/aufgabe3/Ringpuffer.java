package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;

public class Ringpuffer {
	int getPosition = 0,putPosition = 0;
	Object[] puffer;


	public Ringpuffer(int pufferLength){
		puffer = new Object[pufferLength];
	}

	synchronized public void put(Object put){
		puffer[putPosition] = put;
		putPosition++;
		if(isPufferFull()){
			try {
				wait();
			} catch (InterruptedException e) {
				notifyAll();
			}
		}
		else if(puffer[putPosition] != null){
			for(int i = 0; i < puffer.length; i++){
				if(puffer[i] == null){
					puffer[i] = put;
					break;
				}
			}
		}
	}
	synchronized public Object get(){
		Object get;
		getPosition++;
		if(getPosition == puffer.length || puffer [getPosition] == null){
			for(int i = 0;i < puffer.length;i++){
				if(puffer [i] != null){
					getPosition = i;
				}
			}
		}
		get = puffer[getPosition];
		if(isPufferEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				notifyAll();
			}

		}
		return get;

	}
	public boolean isPufferEmpty() {
		for(int i = 0; i < puffer.length; i++){
			if(puffer[i] != null)
				return false;
		}
		return true;
	}
	public boolean isPufferFull(){
		for(int i = 0; i < puffer.length; i++){
			if(puffer[i] == null)
				return false;
		}
		return true;
	}

}
