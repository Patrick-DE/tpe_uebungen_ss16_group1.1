package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe2;

import static gdi.MakeItSimple.*;

public class Main {

    public static void main(String[] args) {
        Crypter caesar = new CrypterCaesar(5);
        Crypter reverse = new CrypterReverse();
        
        println(reverse.decrypt(caesar.decrypt(reverse.decrypt("XHMSNYYXYJQQJS"))));
    }

}
