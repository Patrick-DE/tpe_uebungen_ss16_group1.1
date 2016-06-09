package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.meinQuicksort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("1: For Sequential / 2: For Threaded Quicksort!");
        int decition = scan.nextInt();
        if(decition == 1){
	    	Comparable[] F = {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29};
	        SequentialQuicksort a = new SequentialQuicksort(true);
	        a.sort(F);
	        System.out.println(a.getSwaps());
	        System.out.println(a.getComparisons());
	        System.out.println(a.getRecursions());
        }else if(decition == 2){
        	Comparable[] F = {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29};
        	TimerThread time = new TimerThread(F);
    		time.start();
        }else{
        	System.out.println("Bitte geben Sie eine 1 oder 2 ein!");
        }
    }

}
