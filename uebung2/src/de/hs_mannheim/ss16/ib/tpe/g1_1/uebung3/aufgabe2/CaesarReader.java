package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe2;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends FilterReader {

    private static final char[] specialAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                                                   'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
                                                   'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                                                   'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                                                   'Ä', 'Ö', 'Ü', 'ä', 'ö', 'ü'};
    private int shift;

    public CaesarReader(Reader arg0, int shift) {
        super(arg0);
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
            this.shift = specialAlphabet.length + (shift % specialAlphabet.length);
        else
            this.shift = shift % specialAlphabet.length;
    }
    
    @Override
    public int read() throws IOException {
        int readCharacter = super.read();
        if (readCharacter == -1) {
            return -1;
        } else if (getIndexOfCharInSpecialAlphabet((char) readCharacter) == -1) {
            return readCharacter;
        } else {
            return (int) decrypt("" + (char) readCharacter).toCharArray()[0]; // length of char array definitely 1
        }
    }
    
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int numberOfReadCharacters = super.read(cbuf, off, len);
        String decryptedMessage = decrypt(convertToString(cbuf));
        for (int i = 0; i < decryptedMessage.length(); i++)
            cbuf[i] = decryptedMessage.charAt(i);
        return numberOfReadCharacters;
    }
    
    /**
     * converts a char array to a String
     * @param cbuf
     *             the char array
     * @return char array converted to a String
     */
    private String convertToString(char[] cbuf) {
        String str = "";
        for(int i = 0; i < cbuf.length; i++)
            str += "" + cbuf[i];

        return str;
    }

    @Override
    public int read(char[] cbuf) throws IOException {
        int numberOfReadCharacters = super.read(cbuf);
        return numberOfReadCharacters;
    }
    
    /**
     * this method decrypts a given message
     * @param str
     *            message to be decrypted
     * @return the decrypted message
     */
    private String decrypt(String str) {
        String cryptedMessage = "";
        int newShift = specialAlphabet.length - shift;
        for (int i = 0; i < str.length(); i++) {
            if (getIndexOfCharInSpecialAlphabet(str.charAt(i)) == -1)
                cryptedMessage += str.charAt(i);
            else
                cryptedMessage += specialAlphabet[(getIndexOfCharInSpecialAlphabet(str.charAt(i)) + newShift) % specialAlphabet.length];
        }
        return cryptedMessage;
    }
    
    /**
     * this method looks for the position of the character in the specialAlphabet 
     * @param character
     *                  the character to look for
     * @return the index of the character in the specialAlphabet, if it was found. Otherwise -1 will be returned.
     */
    private int getIndexOfCharInSpecialAlphabet(char character) {
        int i = 0;
        while (i < specialAlphabet.length) {
            if (specialAlphabet[i] == character)
                return i;
            else
                i++;
        }
        
        return -1;
    }
}
