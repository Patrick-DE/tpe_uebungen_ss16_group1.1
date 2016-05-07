package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe2;

public interface Crypter {

    /**
     * this method encrypts a given message
     * @param message
     *                message to be encrypted
     * @return the encrypted message
     */
    public String encrypt(String message);
    
    /**
     * this method decrypts a encrypted message
     * @param cypherText
     *                   the encrypted message
     * @return the decrypted message
     */
    public String decrypt(String cypherText);
}
