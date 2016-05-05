package de.hsmannheim.tpe.ss16.gruppe13.uebung2.eisdielePt1;
import static org.junit.Assert.*;
import org.junit.*;

public class EisTest {

	private String[] arr1 = {"Schokolade","Vanille","Schokolade","Schokolade"},
				arr2 = {null, null, null, "Schokolade"},
				arr3 = {null, null, null};
	private Eis eis1;
	
	//LAUT AUFGABENBLATT MUSS EIS ABSTRAKT SEIN!
	@Before 
	public void setUp() {
		eis1 = new Eis(null, 0, null, null, null, null);
	}
	
//	@Test
//	public void filterOutRedundanceTest1() {
//		arr1 = eis1.filterOutRedundance(arr1);
//		assertEquals(2, arr1.length);
//	}
//	
//	@Test 
//	public void filterOutRedundanceTest2() {
//		arr2 = eis1.filterOutRedundance(arr2);
//		assertEquals(1, arr2.length);
//	}
//	
//	@Test 
//	public void filterOutRedundanceTest3() {
//		arr3 = eis1.filterOutRedundance(arr3);
//		assertEquals(1, arr3.length);
//	}
}
