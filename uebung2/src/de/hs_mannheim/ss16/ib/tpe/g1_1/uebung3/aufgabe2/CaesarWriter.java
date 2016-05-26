package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe2;

import java.io.Writer;
import java.io.FilterWriter;
import java.io.IOException;

public class CaesarWriter extends FilterWriter {

    private static final char[] specialAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                                                   'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
                                                   'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                                                   'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                                                   'Ä', 'Ö', 'Ü', 'ä', 'ö', 'ü'};
    private int shift;

    public CaesarWriter(Writer out, int shift) {
        super(out);
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
    public void write(String str) throws IOException {
        String messageToWrite = encrypt(str);
        super.write(messageToWrite, 0, messageToWrite.length());
    }
    
    @Override
    public void write(String str, int off, int len) throws IOException {
        String newStr = "";
        int l = off + len;
        if (l > str.length())
            l = str.length();
        
        for (int i = off; i < l; i++)
            newStr += str.charAt(i);
        this.write(newStr);
    }
    
    @Override
    public void write(char[] cbuf) throws IOException {
        this.write(encrypt(cbuf.toString()));
    }
    
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        String newStr = "";
        int l = off + len;
        if (l > cbuf.length)
            l = cbuf.length;
        
        for (int i = off; i < off + len; i++)
            newStr += cbuf[i];
        this.write(newStr);
    }
    
    @Override
    public void write(int c) throws IOException {
        String newStr = "" + (char) c;
        this.write(newStr);
    }
    
    /**
     * this method encrypts a given message
     * @param str
     *            message to be encrypted
     * @return the encrypted message
     */
    private String encrypt(String str) {
        String cryptedMessage = "";
        for (int i = 0; i < str.length(); i++) {
            if (getIndexOfCharInSpecialAlphabet(str.charAt(i)) == -1)
                cryptedMessage += str.charAt(i);
            else
                cryptedMessage += specialAlphabet[(getIndexOfCharInSpecialAlphabet(str.charAt(i)) + shift) % specialAlphabet.length];
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
