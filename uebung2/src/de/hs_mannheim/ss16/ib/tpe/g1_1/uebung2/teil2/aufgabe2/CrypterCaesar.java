package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe2;

public class CrypterCaesar implements Crypter {

    private int shift;

    public CrypterCaesar(int shift) {
        setShift(shift);
    }

    /**
     * this method sets shift
     * @param shift
     *              number of letters the crypted letter will be shifted
     */
    private void setShift(int shift) {
        // negative shift will be converted in a positive shift with the same effect
        if (shift < 0)
            this.shift = 26 + (shift % 26);
        else
            this.shift = shift % 26;
    }

    @Override
    public String encrypt(String message) {
        String cryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            // current letter is a capital letter [A - Z]
            if (message.charAt(i) - 'A' >= 0 && message.charAt(i) - 'A' < 26) {
                cryptedMessage += (char) ((message.charAt(i) - 'A' + shift) % 26 + 'A');

            // current letter is a small letter [a - z]
            } else if (message.charAt(i) - 'a' >= 0 && message.charAt(i) - 'a' < 26) {
                cryptedMessage += (char) ((message.charAt(i) - 'a' + shift) % 26 + 'a');

            // all other letters will not be crypted
            } else {
                cryptedMessage += message.charAt(i);
            }
        }
        
        return cryptedMessage;
    }

    @Override
    public String decrypt(String cypherText) {
        String message = "";
        for (int i = 0; i < cypherText.length(); i++) {
            // current letter is a capital letter [A - Z]
            if (cypherText.charAt(i) - 'A' >= 0 && cypherText.charAt(i) - 'A' < 26) {
                message += (char) ((cypherText.charAt(i) - 'A' + (26 - shift)) % 26 + 'A');

            // current letter is a small letter [a - z]
            } else if (cypherText.charAt(i) - 'a' >= 0 && cypherText.charAt(i) - 'a' < 26) {
                message += (char) ((cypherText.charAt(i) - 'a' + (26 - shift)) % 26 + 'a');

            // all other letters do not need to be encrypted
            } else {
                message += cypherText.charAt(i);
            }
        }
        return message;
    }

}
