package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;


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
		setBounds(100, 100, 1160, 302);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnChooseAFile = new JButton("Choose a File for decryption");
		btnChooseAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    if (arg0.getSource() == btnChooseAFile) {
			        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			        int returnVal = fc.showOpenDialog(CryptGUI.this);
			        informationField.setText("");
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            file = fc.getSelectedFile();
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
		
		/* decryptMe with scroll*/
		decryptMe = new JTextArea(5,20);
		decryptMe.setWrapStyleWord(true);
		decryptMe.setToolTipText("decrypted text will be shown here");
		decryptMe.setEditable(false);
		JScrollPane scroll = new JScrollPane(decryptMe);
		scroll.setLocation(10, 98);
		scroll.setSize(400, 122);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		contentPanel.add(scroll);
		JLabel lblMessageToDecrypt = new JLabel("decrypted text from file:");
		scroll.setColumnHeaderView(lblMessageToDecrypt);
		
		/* informationField with scroll*/
		informationField = new JTextArea(5,20);
		informationField.setWrapStyleWord(true);
		informationField.setToolTipText("Information");
		informationField.setEditable(false);
		JScrollPane scroll0 = new JScrollPane (informationField);
		scroll0.setLocation(410, 98);
		scroll0.setSize(325, 122);
	    scroll0.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll0.setVisible(true);
	    contentPanel.add(scroll0);
	    JLabel lblLog = new JLabel("Current status");
	    scroll0.setColumnHeaderView(lblLog);
		
		/* encryptMe with scroll */
		encryptMe = new JTextArea(5, 20);
		encryptMe.setWrapStyleWord(true);
		encryptMe.setToolTipText("enter the text you want to encrypt here");
		encryptMe.setEditable(true);
		JScrollPane scroll1 = new JScrollPane (encryptMe);
		scroll1.setLocation(735, 98);
		scroll1.setSize(400, 122);
	    scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setVisible(true);
	    contentPanel.add(scroll1);
	    JLabel lblEncryptMe = new JLabel("Message to encrypt:");
	    scroll1.setColumnHeaderView(lblEncryptMe);
	    
	    JLabel lblMasterkey = new JLabel("Decryption / Encryption key (int)");
	    lblMasterkey.setBounds(10, 39, 66, 14);
	    contentPanel.add(lblMasterkey);
	    
	    JLabel lblPathForStoring = new JLabel("txt path for storing the encrypted file");
	    lblPathForStoring.setBounds(266, 39, 208, 14);
	    contentPanel.add(lblPathForStoring);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{
					JButton decrypt = new JButton("Decrypt");
					decrypt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						    try {
						        if (isExistingTxtFile(file)) {
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
						            if (file != null)
						                informationField.append(("[" + file.getPath() + "] is not a txt file. Choose another file." + newline));
						            else
						                informationField.append("No txt file chosen to decrypt. Choose a txt file." + newline);
						        }
						    } catch (NumberFormatException e) {
						        informationField.append("You have to enter an integer value as decryption key." + newline);
						    } catch (FileNotFoundException e) {
						        informationField.append("No txt file chosen to decrypt. Choose a txt file." + newline);
						    } catch (IOException e) {
						        informationField.append(newline + "Something went wrong while decrypting.");
						    }
						}
					});
					buttonPane.add(decrypt);
				}
				{
					JButton encrypt = new JButton("Encrypt");
					encrypt.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        String path = pathVar.getText();
					        try {
					            if (path != null) {
					                if (pathEndsWith(path, ".txt")) {
					                    new File(path).getParentFile().mkdirs();
					                    int shift = Integer.parseInt(key.getText());
					                    CaesarWriter writer = new CaesarWriter(new FileWriter(path), shift);

					                    informationField.append("Encryption starts." + newline);
					                    writer.write(encryptMe.getText());
					                    informationField.append("Encryption successful." + newline);
					                    encryptedFile = new File(path);
					                    writer.close();
					                } else {
					                    if (path.equals(""))
					                        informationField.append("You have to enter the path of a txt file." + newline);
					                    else
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
	
	/**
	 * seperate method for decrypt button to check, if selected file is decryptable
	 * @param file
	 *             selected file
	 * @return true when decryptable. Otherwise false.
	 */
	private boolean isExistingTxtFile(File file) {
	    if (file == null || !file.exists())
	       return false;
	    if (file.isDirectory() || !file.isFile() || !pathEndsWith(file.getPath(), ".txt"))
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
