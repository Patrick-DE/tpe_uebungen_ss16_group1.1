package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe2;

public class CrypterReverse implements Crypter {

    @Override
    public String encrypt(String message) {
        String cryptedMessage = "";
        for (int i = message.length() - 1; i >= 0; i--)
            cryptedMessage  += message.charAt(i);
        return cryptedMessage;
    }

    @Override
    public String decrypt(String cypherText) {
        return encrypt(cypherText);
    }

}
