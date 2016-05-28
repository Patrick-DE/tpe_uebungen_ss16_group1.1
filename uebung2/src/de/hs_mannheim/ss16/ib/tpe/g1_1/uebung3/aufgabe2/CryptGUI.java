package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Dimension;

public class CryptGUI extends JFrame implements ActionListener{

	static private final String newline = "\n";
	private final JPanel contentPanel = new JPanel();
	private JTextArea informationField;
	private JTextArea decryptMe;
	private JTextArea encryptMe;
	private JTextField key;
	final JFileChooser fc = new JFileChooser();
	private JTextField pathVar;
	private File file;
	private File encryptedFile;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Create and set up the window.
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CryptGUI frame = new CryptGUI();
//					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
			case "OK":
				this.setVisible(false);
				break;
			default:
				break;
			}
	}
	/**
	 * Create the frame.
	 */
	public CryptGUI() {
		setBounds(100, 100, 860, 302);
		getContentPane().setLayout(new BorderLayout());
		{/*
			JMenuBar menuBar = new JMenuBar();
			getContentPane().add(menuBar, BorderLayout.NORTH);
			{
				JMenu mnNewMenu = new JMenu("Detail");
				menuBar.add(mnNewMenu);
				{
					JMenuItem about = new JMenuItem("About");
					about.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							About dialog = new About();
							dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						}
					});
					mnNewMenu.add(about);
				}
				{
					JMenuItem quit = new JMenuItem("Quit");
					quit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});
					mnNewMenu.add(quit);
				}
			}*/
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnChooseAFile = new JButton("Choose a File for decryption");
		btnChooseAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Handle open button action.
			    if (arg0.getSource() == btnChooseAFile) {
			        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			        int returnVal = fc.showOpenDialog(CryptGUI.this);
			        informationField.setText("");
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            file = fc.getSelectedFile();
			            //This is where a real application would open the file.
			            informationField.append("Opening: " + file.getName() + "." + newline);
			        } else {
			        	informationField.append("Open command cancelled by user." + newline);
			        }
			        informationField.setCaretPosition(informationField.getDocument().getLength());
			    }			
			}
		});
		btnChooseAFile.setBounds(10, 11, 189, 20);
		contentPanel.add(btnChooseAFile);
		
		{
			key = new JTextField();
			key.setToolTipText("Decrytion / Encryption Key");
			key.setBounds(10, 53, 248, 20);
			contentPanel.add(key);
			key.setColumns(10);
			
			pathVar = new JTextField();
	        pathVar.setToolTipText("path of the encrypted txt file");
	        pathVar.setBounds(266, 53, 208, 20);
	        contentPanel.add(pathVar);
	        pathVar.setColumns(10);
		}
		
		decryptMe = new JTextArea(5,20);
		decryptMe.setWrapStyleWord(true);
		decryptMe.setToolTipText("decrypted text will be shown here");
		decryptMe.setEditable(false);
		/*SCROLL*/
		JScrollPane scroll = new JScrollPane(decryptMe);
		scroll.setLocation(10, 98);
		scroll.setSize(300, 122);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		contentPanel.add(scroll);
		
		JLabel lblMessageToDecrypt = new JLabel("Message to decrypt:");
		scroll.setColumnHeaderView(lblMessageToDecrypt);
		
		informationField = new JTextArea(5,20);
		informationField.setWrapStyleWord(true);
		informationField.setToolTipText("Information");
		informationField.setEditable(false);
//		informationField.setBounds(10, 105, 248, 115);
		
		/*SCROLL*/
		JScrollPane scroll0 = new JScrollPane (informationField);
		scroll0.setLocation(310, 98);
		scroll0.setSize(225, 122);
	    scroll0.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll0.setVisible(true);
	    contentPanel.add(scroll0);
	    
	    JLabel lblLog = new JLabel("Debug logs");
	    scroll0.setColumnHeaderView(lblLog);
		
		
		encryptMe = new JTextArea(5, 20);
		encryptMe.setWrapStyleWord(true);
		encryptMe.setToolTipText("enter the text you want to encrypt here");
		encryptMe.setEditable(true);
//		encryptMe.setBounds(268, 99, 206, 121);
		/*SCROLL*/
		JScrollPane scroll1 = new JScrollPane (encryptMe);
		scroll1.setLocation(535, 98);
		scroll1.setSize(300, 122);
	    scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setVisible(true);
	    contentPanel.add(scroll1);
	    
	    JLabel lblEncryptMe = new JLabel("Message to encrypt:");
	    scroll1.setColumnHeaderView(lblEncryptMe);
	    
	    JLabel lblMasterkey = new JLabel("Masterkey");
	    lblMasterkey.setBounds(10, 39, 66, 14);
	    contentPanel.add(lblMasterkey);
	    
	    JLabel lblPathForStoring = new JLabel("Path for storing the encrypted file");
	    lblPathForStoring.setBounds(266, 39, 208, 14);
	    contentPanel.add(lblPathForStoring);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{/*TODO: DECRYPT EINBINDEN - WAS PASSIERT WENN DER BUTTON GEDRÜCKT WIRD */
				/*IN DIE TEXTBOX WAS SCHREIBEN: ergebnis.append("Opening: " + file.getName() + "." + newline); */
					JButton decrypt = new JButton("Decrypt");
					decrypt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						    String eingegeben = null;
						    String ergebnistext = null;
						    


						    try {
						        if (isExistingTxtFile(file.getPath())) {
						            int shift = Integer.parseInt(key.getText());
						            CaesarReader reader = new CaesarReader(new FileReader(file.getPath()), shift);
						            decryptMe.setText("");
						            informationField.append("[" + file.getPath() + "]: Decryption starts." + newline);
						            int sign = reader.read();
						            while (sign != -1) {
						                decryptMe.append("" + (char) sign);
						                sign = reader.read();
						            }
                                    informationField.append("[" + file.getPath() + "]: Decryption successful." + newline);
						            reader.close();
						        } else {
						            informationField.append(("[" + file.getPath() + "] is not a txt file. Choose another file."));
						        }
						    } catch (NumberFormatException e) {
						        informationField.append("You have to enter an integer value as decryption key." + newline);
						    } catch (FileNotFoundException e) {
						        informationField.append("No txt file chosen to decrypt. Choose a txt file." + newline);
						    } catch (IOException e) {
						        informationField.append(newline + "Something went wrong while decrypting.");
						    }
						    
						    /*
						    if (fc.getSelectedFile() != null) {
						        try {						            
						            
						            ////////////////////////////////
						            int shift = Integer.parseInt(key.getText());
						            File file = fc.getSelectedFile();
						            informationField.append(file.getPath() + ": Decryption starts" + newline);
						            File decryptedFile = new CaesarFileEncryptor(informationField, shift).decrypt(file);
						            if (decryptedFile == null)
						                informationField.append(file.getPath() + ": Decryption failed" + newline);
						            else {
						                informationField.append(file.getPath() + ": Decryption successful" + newline);
						                Runtime.getRuntime().exec("explorer.exe " + decryptedFile.getPath());
						                
						                /*
						                 * IM MOMENT WIRD NACH ERFOLGREICHMEM ENTSCHLÜSSELN DER ZIELORDNER IMMER GEÖFFNET
						                 * EIN BUTTON, DER DEM NUTZER DIE MÖGLICHKEIT GIBT SELBST ZU ENTSCHEIDEN, OB ER DEN
						                 * ORDNER ÖFFNEN WILL, WÄRE PERFEKT.
						                 * 
						                 * JBUTTON NAME -> "Show File"
						                 * WENN ER GEKLICKT WIRD DIESEN BEFEHL AUSFÜHREN (ÖFFNET ORDNER VIA EXPLORER) 
						                 * -> Runtime.getRuntime().exec("explorer.exe " + decryptedFile.getPath());
						                 * 
						                 * DANACH SOLL DER JBUTTON WIEDER VERSCHWINDEN
						                 * JBUTTON MUSS IN DIESEM ELSE BLOCK ERZEUGT WERDEN, 
						                 * WEIL DER ORDNER NUR ANGEZEIGT WERDEN SOLL, WENN ER AUCH WIRKLICH NACH ERFOLGREICHEM
						                 * ENTSCHLÜSSELN EXISTIERT
						                 *
						                
						            }
						        } catch (IOException e) {

						        } catch (NumberFormatException e) {
						            informationField.append("You have to enter an integer value as encryption key" + newline);
						        } catch (StringIndexOutOfBoundsException e) {
						            // TODO Auto-generated catch block
						            informationField.append("Es gab ein Fehler beim einlesen des Textes!" + newline);
						        }
						    } else {
						        informationField.append("No directory to encrypt / decrypt chosen. Choose a directory" + newline);
						    }*/
						}
					});
					buttonPane.add(decrypt);
				}
				{/*TODO: ENCRYPT EINBINDEN - WAS PASSIERT WENN DER BUTTON GEDRÜCKT WIRD */
					JButton encrypt = new JButton("Encrypt");
					encrypt.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        String eingegeben = null;
					        String ergebnistext = null;
					        
					        informationField.setText("");
					        String path = pathVar.getText();
					        try {
					            if (path != null || !path.equals("")) {
					                if (pathEndsWith(path, ".txt")) {
					                    if (new File(path).exists() || new File(path).getParent() != null) {
					                        int shift = Integer.parseInt(key.getText());
					                        CaesarWriter writer = new CaesarWriter(new FileWriter(path), shift);
					                    } else {
					                        new File(path).getParentFile().mkdirs();
					                    }


					                    int shift = Integer.parseInt(key.getText());
					                    CaesarWriter writer = new CaesarWriter(new FileWriter(path), shift);

					                    informationField.append("Encryption starts." + newline);
					                    writer.write(encryptMe.getText());
					                    informationField.append("Encryption successful." + newline);
					                    encryptedFile = new File(path);
					                    writer.close();
					                } else {
					                    informationField.append("[" + path + "] does not equal a path of a txt file");
					                }
					            } else {
					                informationField.append("You have to enter the path of a txt file." + newline);
					            }
					        } catch (FileNotFoundException e1) {
					            informationField.append("[" + path + "] is no txt file." + newline);
					        } catch (NumberFormatException e1) {
					            informationField.append("You have to enter an integer value as encryption key." + newline);
					        } catch (IOException e1) {
					            informationField.append(newline + "Something went wrong while encrypting.");
					        }
					        
					        /*
					        if (fc.getSelectedFile() != null) {
					            try {
					                int shift = Integer.parseInt(key.getText());
                                    File file = fc.getSelectedFile();
                                    informationField.append(file.getPath() + ": Encryption starts" + newline);
                                    File encryptedFile = new CaesarFileEncryptor(informationField, shift).encrypt(file);
                                    if (encryptedFile == null)
                                        informationField.append(file.getPath() + ": Encryption failed" + newline);
                                    else {
                                        informationField.append(file.getPath() + ": Encryption successful" + newline);
                                        Runtime.getRuntime().exec("explorer.exe " + encryptedFile.getPath());
                                        
                                        /*
                                         * IM MOMENT WIRD NACH ERFOLGREICHMEM VERSCHLÜSSELN DER ZIELORDNER IMMER GEÖFFNET
                                         * EIN BUTTON, DER DEM NUTZER DIE MÖGLICHKEIT GIBT SELBST ZU ENTSCHEIDEN, OB ER DEN
                                         * ORDNER ÖFFNEN WILL, WÄRE PERFEKT.
                                         * 
                                         * JBUTTON NAME -> "Show File"
                                         * WENN ER GEKLICKT WIRD DIESEN BEFEHL AUSFÜHREN (ÖFFNET ORDNER VIA EXPLORER) 
                                         * -> Runtime.getRuntime().exec("explorer.exe " + encryptedFile.getPath());
                                         * 
                                         * DANACH SOLL DER JBUTTON WIEDER VERSCHWINDEN
                                         * JBUTTON MUSS IN DIESEM ELSE BLOCK ERZEUGT WERDEN, 
                                         * WEIL DER ORDNER NUR ANGEZEIGT WERDEN SOLL, WENN ER AUCH WIRKLICH NACH ERFOLGREICHEM
                                         * VERSCHLÜSSELN EXISTIERT
                                         *
                                    }
					            } catch (IOException e1) {

					            } catch (NumberFormatException e1) {
					                informationField.append("You have to enter an integer value as encryption key" + newline);
					            } catch (StringIndexOutOfBoundsException e1) {
					                // TODO Auto-generated catch block
					                informationField.append("Es gab ein Fehler beim einlesen des Textes!" + newline);
					            }
					        } else {
					            informationField.append("No directory to encrypt / decrypt chosen. Choose a directory" + newline);
					        }*/
						}
					});
					buttonPane.add(encrypt);
				}
				{
				    JButton showEncryptedFile = new JButton("Open encrypted txt file");
				    showEncryptedFile.addActionListener(new ActionListener(){
				        public void actionPerformed(ActionEvent args0) {
				                try {
                                    Runtime.getRuntime().exec("explorer.exe " + encryptedFile.getPath());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (NullPointerException e) {
                                    informationField.append("You have not encrypted your current path or entered a acceptable path yet." + newline);
                                }
				            
				        }
				    });
				    buttonPane.add(showEncryptedFile);
				}
			}
		}
	}
	
	private boolean isExistingTxtFile(String path) throws FileNotFoundException {
	    if (file == null || !new File(path).exists())
	       throw new FileNotFoundException();
	    if (new File(path).isDirectory() || !new File(path).isFile() || !pathEndsWith(path, ".txt"))
	        return false;
	    else
	        return true;
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
	
	public JTextArea getErgebnis() {
	    return informationField;
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = CryptGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

	protected void changelabel(String text) {
	        informationField.getParent().invalidate(); 
	        informationField.setText(text); 
	        informationField.getParent().validate(); 
	        pack(); 
	    } 
}
