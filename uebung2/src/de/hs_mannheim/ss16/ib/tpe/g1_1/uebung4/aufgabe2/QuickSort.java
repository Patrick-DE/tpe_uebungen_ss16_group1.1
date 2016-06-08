/**
 * 
 */
package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.aufgabe2;

/**
 * @author Patrick-DE
 *
 */


public class QuickSort implements SortAlgorithm {
	
		private int recursiveCounter, comparisonCounter, swaps, numberOfThreads,time;
	   
	    
	   public static void qsort(Comparable array[], int links, int rechts) {
	      if (links < rechts) {
	         int i = partition(array,links,rechts);
	         qsort(array,links,i-1);
	         qsort(array,i+1,rechts);
	      }
	   }
	    
	   public static int partition(Comparable array[], int links, int rechts) {
		  Comparable pivot,help; int i, j;
	      pivot = array[rechts];               
	      i     = links;
	      j     = rechts-1;
	      while(i<=j) {
	         if (array[i].compareTo(pivot) > 0) {     
	            // tausche array[i] und array[j]
	            help =  array[i]; 
	            array[i] = array[j]; 
	            array[j] = help;                             
	            j--;
	         } else i++;            
	      }
	      // tausche array[i] und array[rechts]
	      help      = array[i];
	      array[i]      = array[rechts];
	      array[rechts] = help;
	        
	      return i;
	   }
	    
	   
	@Override
	public  void sort(Comparable[] array) {
		qsort(array,0,array.length-1);
		
	}
	
	}