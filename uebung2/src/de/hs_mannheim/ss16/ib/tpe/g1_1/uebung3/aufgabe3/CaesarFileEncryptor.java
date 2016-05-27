package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

import de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe2.CaesarReader;
import de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe2.CaesarWriter;

public class CaesarFileEncryptor implements IFileEncryptor {

    private int shift;
    private JTextArea informationField;
    
    public CaesarFileEncryptor(int shift) {
        this.shift = shift;
    }
    
    public CaesarFileEncryptor(JTextArea informationField, int shift) {
        this.informationField = informationField;
        this.shift = shift;
    }

    @Override
    public File encrypt(File sourceDirectory) {
        if (sourceDirectory.exists()) {
            if (sourceDirectory.isDirectory()) {
                File[] txt_filesToEncrypt = getTxtFiles(sourceDirectory);
                if (txt_filesToEncrypt != null) {
                    String encryptedPath = sourceDirectory.getPath() + "_encrypted";
                    File encryptedFile = new File(encryptedPath);
                    int i = 0;
                    // create new directory
                    while (!encryptedFile.mkdir())
                        encryptedFile = new File(encryptedPath+i++);

                    // get all txt files and encrypt them in destination file

                    for (i = 0; i < txt_filesToEncrypt.length; i++) {
                        FileReader reader = null;
                        CaesarWriter writer = null;
                        String path = txt_filesToEncrypt[i].getPath();
                        String encryptPath = changePath(path, encryptedFile.getPath());
                        try {
                            createNecessaryDirectories(new File(encryptPath));
                            reader = new FileReader(path);
                            writer = new CaesarWriter(new FileWriter(encryptPath), shift);

                            int sign = reader.read();
                            while (sign != -1) {
                                char c = (char) sign;
                                writer.write(c);
                                sign = reader.read();
                            }
                            reader.close();
                            writer.close();
                        } catch (IOException e) {
                            if (informationField == null)
                                System.out.println("Something went wrong");
                            else
                                informationField.append("Something went wrong\n");
                        }
                    }

                    return encryptedFile;
                } else {
                    if (informationField == null)
                        System.out.println("Source directory does not have any txt files.");
                    else
                        informationField.append("Source directory does not have any txt files.\n");
                    return null;
                }
            } else if (sourceDirectory.isFile()) {
                if (informationField == null)
                    System.out.println("Source directory is a file. So it can not be encrypted.");
                else
                    informationField.append("Source directory is a file. So it can not be encrypted.\n");
                return null;
            } else {
                if (informationField == null)
                    System.out.println("Can not be encrypted.");
                else
                    informationField.append("Can not be encrypted.\n");
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * this method creates all necessary parent folders, if they do not exist.
     * @param file
     *             the file or directory
     */
    private void createNecessaryDirectories(File file) {
        if (!file.exists())
            new File(file.getParent()).mkdirs();
    }

    /**
     * this method changes the path of path, so that the new path lays in newSource
     * @param path
     *             path to be changed
     * @param newSource
     *                  the place where the new path has to lay
     * @return
     */
    private String changePath(String path, String newSource) {
        String newPath = newSource;
        int depthOfNewSource = getDepthOfPath(newSource);
        int depthOfPath = getDepthOfPath(path);
        int referenceCounter = 0;
        int startIndex = path.length()-1;
        while (referenceCounter != depthOfPath - depthOfNewSource)
            if (path.charAt(startIndex--) == '\\')
                referenceCounter++;
        for (int i = startIndex + 1; i < path.length(); i++)
            newPath += path.charAt(i);
        
        return newPath;
    }

    /**
     * this method finds out how deep a file path
     * @param path
     *             path of file or directory
     * @return the depth of the path
     */
    private int getDepthOfPath(String path) {
        int depth = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '\\')
                depth++;
        }
        return depth;
    }

    @Override
    public File decrypt(File sourceDirectory) {
        if (sourceDirectory.exists()) {
            if (sourceDirectory.isDirectory()) {
                File[] txt_filesToDecrypt = getTxtFiles(sourceDirectory);
                if (txt_filesToDecrypt != null) {
                    String decryptedPath = sourceDirectory.getPath() + "_decrypted";
                    File decryptedFile = new File(decryptedPath);
                    int i = 0;
                    // create new directory
                    while (!decryptedFile.mkdir())
                        decryptedFile = new File(decryptedPath+i++);

                    // get all txt files and encrypt them in destination file
                    for (i = 0; i < txt_filesToDecrypt.length; i++) {
                        CaesarReader reader = null;
                        FileWriter writer = null;
                        String path = txt_filesToDecrypt[i].getPath();
                        String decryptPath = changePath(path, decryptedFile.getPath());
                        try {
                            createNecessaryDirectories(new File(decryptPath));
                            reader = new CaesarReader(new FileReader(path), shift);
                            writer = new FileWriter(decryptPath);

                            int sign = reader.read();
                            while (sign != -1) {
                                char c = (char) sign;
                                writer.write(c);
                                sign = reader.read();
                            }
                            reader.close();
                            writer.close();
                        } catch (IOException e) {
                            if (informationField == null)
                                System.out.println("Something went wrong");
                            else
                                informationField.append("Something went wrong\n");
                        }
                    }

                    return decryptedFile;
                } else {
                    if (informationField == null)
                        System.out.println("Source directory does not have any txt files.");
                    else
                        informationField.append("Source directory does not have any txt files.\n");
                    return null;
                }
            } else if (sourceDirectory.isFile()) {
                if (informationField == null)
                    System.out.println("Source directory is a file. So it can not be encrypted.");
                else
                    informationField.append("Source directory is a file. So it can not be encrypted.\n");
                return null;
            } else {
                if (informationField == null)
                    System.out.println("Can not be encrypted.");
                else
                    informationField.append("Can not be encrypted.\n");
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * this method gets all txt files from a folder and its sub folders
     * @param sourceDirectory
     *                        the start folder / file
     * @return a File array with all txt files. null, if sourceDirectory does not exist or does not have any txt files
     */
    private File[] getTxtFiles(File sourceDirectory) {
        if (sourceDirectory.exists()) {
            if (getNumberOfTxtFiles(sourceDirectory) > 0) {
                int numberOfTxtFiles = getNumberOfTxtFiles(sourceDirectory);
                File[] txt_files = new File[numberOfTxtFiles];
                File[] files = sourceDirectory.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile()) {
                        if (pathEndsWith(files[i].getPath(), ".txt"))
                            txt_files[nextFreeIndex(txt_files)] = files[i];
                    } else {
                        File[] txtfilesOfSubfolder = getTxtFiles(files[i]);
                        if (txtfilesOfSubfolder != null)
                            add(txt_files, txtfilesOfSubfolder);
                    }
                }
                return txt_files;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
    /**
     * this method adds filesToAdd to files
     * @param files
     *              the files
     * @param filesToAdd
     *                   the files, which will be added to files
     */
    private void add(File[] files, File[] filesToAdd) {
        int i = 0;
        while (nextFreeIndex(files) < files.length && i < filesToAdd.length) {
            files[nextFreeIndex(files)] = filesToAdd[i++];
        }
    }

    /**
     * 
     * @param array
     * @return first array index which is not null.
     */
    private int nextFreeIndex(Object[] array) {
        int i = 0;
        while (i < array.length) {
            if (array[i] == null)
                return i;
            else
                i++;
        }

        return i;
    }
    
    /**
     * this method counts the number of txt files in a file / directory and its sub folders
     * @param sourceDirectory
     *                        start folder or file from where the counting begins
     * @return number of txt files. -1, if sourceDirectory does not exist.
     */
    private int getNumberOfTxtFiles(File sourceDirectory) {  
        if (sourceDirectory.exists()) {
            int n = 0;
            File[] files = sourceDirectory.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    if (pathEndsWith(files[i].getPath(), ".txt"))
                        n++;
                } else {
                    n += getNumberOfTxtFiles(files[i]);
                }
            }
            return n;
        } else {
            return -1;
        }
    }
    
    /**
     * this method checks, if a path has specified ending
     * @param path path to be checked
     * @param ending the suffix of the path
     * @return true, if 'path' ends with 'ending'. Otherwise false 
     */
    private boolean pathEndsWith(String path, String ending) {

        int numberOfCorrectLetters = 0;
        if (path.length() <= ending.length() || ending.length() < 4)
            return false;
        
        for (int i = path.length() - ending.length(), j = 0; i < path.length(); i++, j++) {
            if (path.charAt(i) == ending.charAt(j))
                numberOfCorrectLetters++;    
        }
        
        if (numberOfCorrectLetters == ending.length())
            return true;
        else
            return false;
    }
}
