package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBTree {

	@Test
	public void testSizeHeight() {
		BTree test = new BTree(1);
		int[] a={1,10,12,15,17,11,2,18,20,33,50,60,19,22};
		for(int i = 0; i < a.length; i++ ){
			test.insert(a[i]);
		}
		assertEquals(14,test.size());
		assertEquals(2,test.height());
		test.insert(23);
		test.insert(24);
		test.insert(25);
		test.insert(26);
		test.insert(27);
		assertEquals(3,test.height());
		assertEquals(19,test.size());
		
	}
	@Test
	public void testContains(){
		BTree test = new BTree(1);
		assertEquals(false,test.contains(5));
		test.insert(5);
		assertEquals(true,test.contains(5));
		assertEquals(false, test.contains(null));
	
	}
	@Test
	public void testIsEmpty(){
		BTree test = new BTree(1);
		assertEquals(true,test.isEmpty());
		test.insert(5);
		assertEquals(false,test.isEmpty());
	}
	@Test
	public void testMaxandMin(){
		BTree test = new BTree(1);
		int[] a={1,10,12,15,17,11,2,18,20,33,50,60,19,22};
		for(int i = 0; i < a.length; i++ ){
			test.insert(a[i]);
		}
		assertEquals(1,(int)test.getMin());
		assertEquals(60,(int)test.getMax());
		
	}@Test
	public void testDelete(){
		BTree test = new BTree(1);
		int[] a={1,10,12,15,17,11,2,18,20,33,50,60,19,22};
		for(int i = 0; i < a.length; i++ ){
			test.insert(a[i]);
		}
		test.delete(1);
		assertEquals(false,test.contains(1));
		test.delete(2);
		assertEquals(false,test.contains(2));
		
	}
	

}
