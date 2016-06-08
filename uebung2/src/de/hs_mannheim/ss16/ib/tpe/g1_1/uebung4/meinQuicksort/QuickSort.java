package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung4.meinQuicksort;

import static gdi.MakeItSimple.*;

public class QuickSort {

    public static void main(String[] args) {
//      Testfelder für Quickort

        Comparable [] F;
        F = new Comparable[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//      # Rekursionen: 14 # Vergleiche: 64  # Vertauschungen: 31
        
//      F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//      # Rekursionen: 8 # Vergleiche: 45  # Vertauschungen: 0  
        
//          F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//      # Rekursionen: 8 # Vergleiche: 45  # Vertauschungen: 5


//      F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//      # Rekursionen: 6 # Vergleiche: 21  # Vertauschungen: 9

//      F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts
//      # Rekursionen: 8 # Vergleiche: 45  # Vertauschungen: 9

//      F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  // F besteht aus 2 sortierten Teilfolgen
//      # Rekursionen: 7 # Vergleiche: 25  # Vertauschungen: 5


//      F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht
//      # Rekursionen: 8 # Vergleiche: 45  # Vertauschungen: 1
        
//      F = new int[] {1};
//      # Rekursionen: 0 # Vergleiche: 0  # Vertauschungen: 0       

//      F = new int [] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // F ist fast sortiert - das größte Element steht ganz links
//      # Rekursionen: 7 # Vergleiche: 37  # Vertauschungen: 9  

      F = new Comparable [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//      # Rekursionen: 8 # Vergleiche: 45  # Vertauschungen: 0
   
        F = new Comparable [] {2, 17, 23, 13, 18, 3, 19, 11, 14, 16, 8};       
        int[] totalSwapsComparisonsAndCalls = new int[3];
        char decision;
        boolean wantDemonstration;

        do {
            println("Wollen Sie eine Beispielvorf�hrung an einem der vorgegebenen Arrays 'F's"
                    + " oder das Komplexitaetsexperiment an den grossen Arrays (1024, 2048, 4096) ?");
            println("'1' fuer Beispielausf�hrung");
            println("'2' fuer Komplexit�tsexperiment");
            decision = readChar();
            readLine();
        } while (!(decision == '1' || decision == '2'));

        if (decision == '1')
            wantDemonstration = true;
        else
            wantDemonstration = false;

        if (wantDemonstration) {
//            fillUnsortedArray(F, wantDemonstration); disable comment to create random array with the size of current array F
            println("Ausgangsarray");
            printArray(F);
            println();
            totalSwapsComparisonsAndCalls = quickSort(F, 0, F.length - 1, totalSwapsComparisonsAndCalls, wantDemonstration, true);
            println("Sortiertes Array");
            printArray(F);
            println("Vertauschungen (insgesamt): " + totalSwapsComparisonsAndCalls[0]);
            println("Vergleiche (insgesamt): " + totalSwapsComparisonsAndCalls[1]);
            println("Rekursion (insgesamt): " + totalSwapsComparisonsAndCalls[2]);
        } else {
            Comparable[] array1024 = new Comparable[1024];
            Comparable[] array2048 = new Comparable[2048];
            Comparable[] array4096 = new Comparable[4096];
            int[] totalSwapsComparisonsAndCalls1024 = new int[3];
            int[] totalSwapsComparisonsAndCalls2048 = new int[3];
            int[] totalSwapsComparisonsAndCalls4096 = new int[3];
            int sumSwaps1024 = 0;
            int sumComparisons1024 = 0;
            int sumCalls1024 = 0;
            int sumSwaps2048 = 0;
            int sumComparisons2048 = 0;
            int sumCalls2048 = 0;
            int sumSwaps4096 = 0;
            int sumComparisons4096 = 0;
            int sumCalls4096 = 0;
            int numberOfRounds = 10;
            int i = 0;
            int j = 0;
            while (i++ < 3) {
                sumSwaps1024 = 0;
                sumComparisons1024 = 0;
                sumCalls1024 = 0;
                sumSwaps2048 = 0;
                sumComparisons2048 = 0;
                sumCalls2048 = 0;
                sumSwaps4096 = 0;
                sumComparisons4096 = 0;
                sumCalls4096 = 0;
                numberOfRounds *= 10;
                j = 0;
                totalSwapsComparisonsAndCalls1024 = new int[3];
                totalSwapsComparisonsAndCalls2048 = new int[3];
                totalSwapsComparisonsAndCalls4096 = new int[3];
                while (j++ < numberOfRounds) {
                    fillUnsortedArray(array1024, wantDemonstration);
                    fillUnsortedArray(array2048, wantDemonstration);
                    fillUnsortedArray(array4096, wantDemonstration);

                    // quickSort for array1024
                    totalSwapsComparisonsAndCalls = new int[3];
                    totalSwapsComparisonsAndCalls1024 = quickSort(array1024, 0, array1024.length - 1, totalSwapsComparisonsAndCalls, wantDemonstration, true);
                    sumSwaps1024 += totalSwapsComparisonsAndCalls1024[0];
                    sumComparisons1024 += totalSwapsComparisonsAndCalls1024[1];
                    sumCalls1024 += totalSwapsComparisonsAndCalls1024[2];

                    // quickSort for array 2048
                    totalSwapsComparisonsAndCalls = new int[3];
                    totalSwapsComparisonsAndCalls2048 = quickSort(array2048, 0, array2048.length - 1, totalSwapsComparisonsAndCalls, wantDemonstration, true);
                    sumSwaps2048 += totalSwapsComparisonsAndCalls2048[0];
                    sumComparisons2048 += totalSwapsComparisonsAndCalls2048[1];
                    sumCalls2048 += totalSwapsComparisonsAndCalls2048[2];

                    // quickSort for array 4096
                    totalSwapsComparisonsAndCalls = new int[3];
                    totalSwapsComparisonsAndCalls4096 = quickSort(array4096, 0, array4096.length - 1, totalSwapsComparisonsAndCalls, wantDemonstration, true);
                    sumSwaps4096 += totalSwapsComparisonsAndCalls4096[0];
                    sumComparisons4096 += totalSwapsComparisonsAndCalls4096[1];
                    sumCalls4096 += totalSwapsComparisonsAndCalls4096[2];

                }

                println("Array-Groesse: 1024; " + "Durchgaenge: " + numberOfRounds);
                println("Vertauschungen (insgesamt): " + sumSwaps1024
                        + " Durchschnitt: " + sumSwaps1024 / numberOfRounds);
                println("Vergleiche (insgesamt): " + sumComparisons1024
                        + " Durchschnitt: " + sumComparisons1024 / numberOfRounds);
                println("Methodenaufrufe (insgesamt): " + sumCalls1024
                        + " Durchschnitt: " + sumCalls1024 / numberOfRounds);
                println("--------");
                println("Array-Groesse: 2048; " + "Durchgaenge: " + numberOfRounds);
                println("Vertauschungen (insgesamt): " + sumSwaps2048
                        + " Durchschnitt: " + sumSwaps2048 / numberOfRounds);
                println("Vergleiche (insgesamt): " + sumComparisons2048
                        + " Durchschnitt: " + sumComparisons2048 / numberOfRounds);
                println("Methodenaufrufe (insgesamt): " + sumCalls2048
                        + " Durchschnitt: " + sumCalls2048 / numberOfRounds);
                println("--------");
                println("Array-Groesse: 4096; " + "Durchgaenge: " + numberOfRounds);
                println("Vertauschungen (insgesamt): " + sumSwaps4096
                        + " Durchschnitt: " + sumSwaps4096 / numberOfRounds);
                println("Vergleiche (insgesamt): " + sumComparisons4096
                        + " Durchschnitt: " + sumComparisons4096 / numberOfRounds);
                println("Methodenaufrufe (insgesamt): " + sumCalls4096
                        + " Durchschnitt: " + sumCalls4096 / numberOfRounds);
                println("__________________________________________________");
            }
        }          
    }

    /**
     * this method fills a void array with random values
     * all commands, which are dependent from wantDemonstration does not affect the functional principle of this method
     * @param array
     * @param wantDemonstration this parameter determines, whether the array 
     *                          will be used for the demonstration or the complexity experiment
     */
    static void fillUnsortedArray(Comparable[] array, boolean wantDemonstration) {

        int maxValue;
        if (wantDemonstration)
            maxValue = 100;
        else
            maxValue = array.length;

        for (int i = 0; i < array.length; i++)
            array[i] = (int) Math.floor(Math.random() * maxValue);

    }

    /**
     * this method prints the array on the console
     * @param array
     */
    static void printArray(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            print(array[i] + "  ");
        }
        println();
    }
    /**
     * all commands, which are dependent from wantDemonstration do not affect the sorting-algorithm
     * @param array
     * @param startIndex
     * @param endIndex
     * @param totalSwapsComparisonsAndCalls
     * @param wantDemonstration
     * @param firstCall shows, whether the current call is the first call of the method or not
     * @return
     */
    static int[] quickSort(Comparable[] array, int startIndex, int endIndex, int[] totalSwapsComparisonsAndCalls, boolean wantDemonstration, boolean firstCall) {

        if (wantDemonstration)
            println("Quicksort-Bereich: " + startIndex + " bis " + endIndex);

        if (endIndex > startIndex) {
            
            if (!firstCall)
                totalSwapsComparisonsAndCalls[2]++;
            else
                firstCall = false;

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
                                print("[");

                            if (i == pivotIndex) {
                                if (i != endIndex)
                                    print(array[i] + "* ");
                                else
                                    print(array[i] + "*] ");
                            } else {
                                if (i != endIndex)
                                    print(array[i] + "  ");
                                else
                                    print(array[i] + "] ");
                            }

                        } else {
                            if (i == startIndex)
                                print("[");

                            if (i == vectorMarker || i == indexMarker) {
                                print("(" + array[i] + ") ");
                            } else {
                                if (i == pivotIndex) {
                                    print(array[i] + "*] ");
                                } else {
                                    if (i + 1 == vectorMarker || i + 1 == indexMarker)
                                        print(array[i] + " ");
                                    else
                                        print(array[i] + "  ");
                                }    
                            }
                        }
                    }
                    println();
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
                        print("[");
                    
                    if (i == index) // shows the pivotIndex in this case, because index and pivotIndex were swapped before
                        if (i == endIndex)
                            print("(" + array[i] + "*)");
                        else
                            print("(" + array[i] + "*) ");
                    else if (i == pivotIndex)
                        print("(" + array[i] + ")");
                    else
                        if (i + 1 == index || i + 1 == pivotIndex)
                            print(array[i] + " ");
                        else
                            print(array[i] + "  ");
                    
                    if (i == endIndex) {
                        if (i == array.length - 1)
                            print("]");
                        else
                            print("] ");
                    }    
                }
                println();
                println("Vertauschungen (insgesamt): " + swapCounter);
                println("Vergleiche(insgesamt): " + comparisonCounter);
                println();
            }

            totalSwapsComparisonsAndCalls[0] += swapCounter;
            totalSwapsComparisonsAndCalls[1] += comparisonCounter;

            pivotPosition = index;

            totalSwapsComparisonsAndCalls = quickSort(array, startIndex, pivotPosition - 1, totalSwapsComparisonsAndCalls, wantDemonstration, firstCall);
            totalSwapsComparisonsAndCalls = quickSort(array, pivotPosition + 1, endIndex, totalSwapsComparisonsAndCalls, wantDemonstration, firstCall);

        } else {
            if (wantDemonstration)
                if (startIndex == endIndex) {
                    println("Keine Sortierung in diesem Intervall noetig");
                    println();
                } else {
                    println("Keine Sortierung in diesem Intervall moeglich");
                    println();
                }
        }

        return totalSwapsComparisonsAndCalls;
    }

    /**
     * this method swaps the positions of numbers in an array
     * @param array
     * @param index0 represents the position of a number
     * @param index1 represents the position of a number
     */
    static void swap(Comparable[] array, int index0, int index1) {

        Comparable cache = array[index1];
        array[index1] = array[index0];
        array[index0] = cache;
    }
}
