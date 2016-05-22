package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe3;

import java.io.File;

public interface IFileEncryptor {

	public File encrypt(File sourceDirectory);
	public File decrypt(File sourceDirectory);
}
