package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.meinQuicksort;

import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;

public class SequentialQuicksort implements SortAlgorithm {

    private static final int threadCounter = 1; // non multithreaded Quicksort. So only 1 thread
    private int comparisonCounter;
    private int swapCounter;
    private int recursionCounter;
    private boolean wantDemonstration;
    
    public SequentialQuicksort() {}
    
    public SequentialQuicksort(boolean wantDemonstration) {
        this.wantDemonstration = wantDemonstration;
    }

    public int getComparisons() {
        return comparisonCounter;
    }
    
    public int getSwaps() {
        return swapCounter;
    }
    
    public int getRecursions() {
        return recursionCounter;
    }
    @Override
    public void sort(Comparable[] array) {
        recursionCounter = -1; // recursions will be incremented at each call. First call is not a recursion
        subSort(array, 0, array.length - 1);
        
        if (recursionCounter < 0)
            recursionCounter = 0;
    }

    private void subSort(Comparable[] array, int startIndex, int endIndex) {
        
        if (wantDemonstration)
            System.out.println("Quicksort-Bereich: " + startIndex + " bis " + endIndex);

        if (endIndex > startIndex) {

            recursionCounter++;

            int pivotPosition;
            int index = startIndex;
            int pivotIndex = endIndex;
            Comparable pivotNumber = array[pivotIndex];
            int swapCounter = 0;
            int comparisonCounter = 0;

            for (int vector = startIndex; vector < endIndex; vector++) {
                comparisonCounter++;
                boolean swapped = false;
                int vectorMarker = -1; // only relevant, if wantDemonstration is true. Marks the index of a swapped number
                int indexMarker = -1; // only relevant, if wantDemonstration is true. Marks the index of a swapped number
                if (array[vector].compareTo(pivotNumber) <= 0) {
                    vectorMarker = vector;
                    indexMarker = index;
                    if (vector != index) {
                        swapCounter++;
                        swap(array, vector, index);
                        swapped = true;
                    }
                    index++;
                }

                // Output after each round.
                // Marks sorting range with '[' and ']'.
                // Marks swapped numbers with '(' and ')'.
                // Marks pivot number with '*'
                if (wantDemonstration) {
                    for (int i = 0; i < array.length; i++) {
                        if (!swapped) {
                            if (i == startIndex)
                                System.out.print("[");

                            if (i == pivotIndex) {
                                if (i != endIndex)
                                    System.out.print(array[i] + "* ");
                                else
                                    System.out.print(array[i] + "*] ");
                            } else {
                                if (i != endIndex)
                                    System.out.print(array[i] + "  ");
                                else
                                    System.out.print(array[i] + "] ");
                            }

                        } else {
                            if (i == startIndex)
                                System.out.print("[");

                            if (i == vectorMarker || i == indexMarker) {
                                System.out.print("(" + array[i] + ") ");
                            } else {
                                if (i == pivotIndex) {
                                    System.out.print(array[i] + "*] ");
                                } else {
                                    if (i + 1 == vectorMarker || i + 1 == indexMarker)
                                        System.out.print(array[i] + " ");
                                    else
                                        System.out.print(array[i] + "  ");
                                }    
                            }
                        }
                    }
                    System.out.println();
                }
            }

            if (pivotIndex != index) {
                swapCounter++;
                swap(array, pivotIndex, index);
            }

            // Output after each round.
            // Marks sorting range with '[' and ']'.
            // Marks swapped numbers with '(' and ')'.
            // Marks pivot number with '*'
            if (wantDemonstration) {
                for (int i = 0; i < array.length; i++) {
                    if (i == startIndex)
                        System.out.print("[");

                    if (i == index) // shows the pivotIndex in this case, because index and pivotIndex were swapped before
                        if (i == endIndex)
                            System.out.print("(" + array[i] + "*)");
                        else
                            System.out.print("(" + array[i] + "*) ");
                    else if (i == pivotIndex)
                        System.out.print("(" + array[i] + ")");
                    else
                        if (i + 1 == index || i + 1 == pivotIndex)
                            System.out.print(array[i] + " ");
                        else
                            System.out.print(array[i] + "  ");

                    if (i == endIndex) {
                        if (i == array.length - 1)
                            System.out.print("]");
                        else
                            System.out.print("] ");
                    }    
                }
                println();
                println("Vertauschungen (insgesamt): " + swapCounter);
                println("Vergleiche(insgesamt): " + comparisonCounter);
                println();
            }

            this.swapCounter += swapCounter;
            this.comparisonCounter += comparisonCounter;

            pivotPosition = index;

            subSort(array, startIndex, pivotPosition - 1);
            subSort(array, pivotPosition + 1, endIndex);

        } else {
            if (wantDemonstration)
                if (startIndex == endIndex) {
                    System.out.println("Keine Sortierung in diesem Intervall noetig");
                    System.out.println();
                } else {
                    System.out.println("Keine Sortierung in diesem Intervall moeglich");
                    System.out.println();
                }
        }
    }

    /**
     * this method swaps the positions of numbers in an array
     * @param array
     * @param index0 represents the position of a number
     * @param index1 represents the position of a number
     */
    private void swap(Comparable[] array, int index0, int index1) {

        Comparable cache = array[index1];
        array[index1] = array[index0];
        array[index0] = cache;
    }
}
