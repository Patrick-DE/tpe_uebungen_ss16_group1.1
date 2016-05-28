package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
	private JTextField key;
	final JFileChooser fc = new JFileChooser();
	private File file;
	private File destinationFile;
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
		setBounds(100, 100, 600, 302);
		getContentPane().setLayout(new BorderLayout());

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnChooseAFile = new JButton("Choose a File or Folder");
		btnChooseAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    if (arg0.getSource() == btnChooseAFile) {
			        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			        int returnVal = fc.showOpenDialog(CryptGUI.this);
			        informationField.setText("");
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            file = fc.getSelectedFile();
			            informationField.append("Opening: " + file.getName() + "." + newline);
			            destinationFile = null;
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
			key.setBounds(10, 55, 248, 20);
			contentPanel.add(key);
			key.setColumns(10);
		}
		informationField = new JTextArea(5,20);
		informationField.setToolTipText("Information");
		informationField.setEditable(false);
		
		/*SCROLL*/
		JScrollPane scroll = new JScrollPane (informationField);
        scroll.setLocation(10, 98);
        scroll.setSize(565, 110);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVisible(true);
        contentPanel.add(scroll);
        {
        	JLabel lblNewLabel = new JLabel("Crypter logs");
        	scroll.setColumnHeaderView(lblNewLabel);
        }
        {
        	JLabel label = new JLabel("Masterkey");
        	label.setBounds(10, 42, 66, 14);
        	contentPanel.add(label);
        }
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{
					JButton decrypt = new JButton("Decrypt");
					decrypt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						    if (file != null) {
						        try {
						            int shift = Integer.parseInt(key.getText());
						            informationField.append("[" + file.getPath() + "]: Decryption starts." + newline);
						            destinationFile = new CaesarFileEncryptor(informationField, shift).decrypt(file);
						            if (destinationFile == null)
						                informationField.append("[" + file.getPath() + "]: Decryption failed." + newline);
						            else {
						                informationField.append("[" + file.getPath() + "]: Decryption successful." + newline);
						            }
						        } catch (NumberFormatException e) {
						            informationField.append("You have to enter an integer value as decryption key." + newline);
						        }
						    } else {
						        informationField.append("No directory chosen to decrypt. Choose a directory." + newline);
						    }
						}
					});
					buttonPane.add(decrypt);
				}
				{
					JButton encrypt = new JButton("Encrypt");
					encrypt.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        if (file != null) {
					            try {
					                int shift = Integer.parseInt(key.getText());
                                    informationField.append("[" + file.getPath() + "]: Encryption starts." + newline);
                                    destinationFile = new CaesarFileEncryptor(informationField, shift).encrypt(file);
                                    if (destinationFile == null)
                                        informationField.append("[" + file.getPath() + "]: Encryption failed." + newline);
                                    else {
                                        informationField.append("[" + file.getPath() + "]: Encryption successful." + newline);
                                    }
					            } catch (NumberFormatException e1) {
					                informationField.append("You have to enter an integer value as encryption key." + newline);
					            }
					        } else {
					            informationField.append("No directory chosen to encrypt. Choose a directory." + newline);
					        }
						}
					});
					buttonPane.add(encrypt);
				}
				{
				    {
                        JButton showFile = new JButton("Open decrypted / encrypted Directory");
                        showFile.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent arg0) {
                                try {
                                    Runtime.getRuntime().exec("explorer.exe " + destinationFile.getPath());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (NullPointerException e) {
                                    if (file != null) {
                                    informationField.append("You have not decrypted / encrypted" + " [" + file.getPath() + "]." + newline);
                                    } else {
                                        informationField.append("No directory chosen to encrypt / decrypt. Choose a directory." + newline);
                                    }
                                }
                            }
                            
                        });
                        buttonPane.add(showFile);
                    }
				}
			}
		}
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
