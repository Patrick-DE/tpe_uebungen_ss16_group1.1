package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPuffer {
	Ringpuffer puffer = new Ringpuffer(10);

	@Test
	public void testPutandGet() {
		// fill puffer and at the same time gets the value so in the end the puffer is empty
		// Modulo is applied when i reaches 10 since the rightmost index is 9 as the Puffer has a size of 10
		for(int i = 0; i < 15; i++){
			puffer.put(i);
			assertEquals(i,puffer.get());
		}
		// Now when a certain value is put and get is invoked, the same value should be received cause the puffer should be empty
		
		puffer.put(600);
		assertEquals(600,puffer.get());

	}
	@Test
	public void isPufferEmpty(){
		puffer = new Ringpuffer(10);
		assertEquals(true,puffer.isPufferEmpty());
		for(int i = 0; i < 10; i++){
			puffer.put(i);
		}
		// Puffer is full but second index is checked and is not empty
		assertEquals(false,puffer.isPufferEmpty());
	}
	@Test
	public void isPufferFull(){
		puffer = new Ringpuffer(10);
		assertEquals(false,puffer.isPufferFull());
		for(int i = 0; i < 10; i++){
			puffer.put(i);
		}
		// Puffer is full and putPosition is at index one again cause of the modulo operation (in Puffer class)
		// Index one already holds an object though since not get was invoked
		assertEquals(true,puffer.isPufferFull());
	}
	

}
