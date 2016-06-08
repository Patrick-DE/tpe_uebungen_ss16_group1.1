package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe2;

public class Main {
	public static void main(String[] args) {
		QuickSort sortIt = new QuickSort();
		Comparable [] liste = {0,9,4,6,2,8,5,1,7,3};
		sortIt.sort(liste);
		for (int i=0; i<liste.length; i++) 
			System.out.print(liste[i]+" ");         
	}

}
