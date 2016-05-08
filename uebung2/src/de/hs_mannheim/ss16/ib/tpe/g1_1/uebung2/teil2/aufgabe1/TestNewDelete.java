package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe1;
import static gdi.MakeItSimple.*;
public class TestNewDelete {


	public static void main (String[] args){
		BTreeWithCopyDelete test = new BTreeWithCopyDelete(1);
		int[] a={1,10,12,15,17};
		for(int i = 0; i < a.length; i++ ){
			test.insert(a[i]);
		}
		test.delete(17);
		test.delete(1);
		println("fertig");
	}

}
