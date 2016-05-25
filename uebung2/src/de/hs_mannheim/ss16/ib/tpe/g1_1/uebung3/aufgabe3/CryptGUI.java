package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

public class CryptGUI extends JFrame implements ActionListener{

	static private final String newline = "\n";
	private final JPanel contentPanel = new JPanel();
	private static JTextArea ergebnis;
	private JTextField key;
	final JFileChooser fc = new JFileChooser();
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
		setBounds(100, 100, 399, 302);
		getContentPane().setLayout(new BorderLayout());
		{
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
			}
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnChooseAFile = new JButton("Choose a File or Folder");
		btnChooseAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Handle open button action.
			    if (arg0.getSource() == btnChooseAFile) {
			        int returnVal = fc.showOpenDialog(CryptGUI.this);

			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            //This is where a real application would open the file.
			            ergebnis.append("Opening: " + file.getName() + "." + newline);
			        } else {
			        	ergebnis.append("Open command cancelled by user." + newline);
			        }
			        ergebnis.setCaretPosition(ergebnis.getDocument().getLength());
			    }			
			}
		});
		btnChooseAFile.setBounds(10, 11, 189, 20);
		contentPanel.add(btnChooseAFile);
		
		{
			key = new JTextField();
			key.setToolTipText("Encryption Key");
			key.setBounds(10, 53, 248, 20);
			contentPanel.add(key);
			key.setColumns(10);
		}
		ergebnis = new JTextArea(5,20);
		ergebnis.setToolTipText("Result");
		ergebnis.setEditable(false);
		ergebnis.setBounds(10, 105, 363, 94);
		contentPanel.add(ergebnis);
		ergebnis.setColumns(30);
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
								eingegeben = eingabe.getText();
							} catch (StringIndexOutOfBoundsException e) {
								// TODO Auto-generated catch block
								System.out.println("Es gab ein Fehler beim einlesen des Textes!");
							}
//							Crypter caesar = new CrypterCaesar(5);
//					        Crypter reverse = new CrypterReverse();
//					        ergebnistext =(reverse.decrypt(caesar.decrypt(reverse.decrypt(eingegeben))));
					        changelabel(ergebnistext);
					        /* NACH DECRYPT DEN NEUEN PFAD AUF DEN EXPLORER VIEW SETZEN
						        http://stackoverflow.com/questions/5721504/jfilechooser-set-directory-to-a-path-in-a-file
					        */
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
							try {
								eingegeben = eingabe.getText();
							} catch (StringIndexOutOfBoundsException e1) {
								// TODO Auto-generated catch block
								System.out.println("Es gab ein Fehler beim einlesen des Textes!");
							}
//							Crypter caesar = new CrypterCaesar(5);
//					        Crypter reverse = new CrypterReverse();
//					        ergebnistext=(reverse.encrypt(caesar.encrypt(reverse.encrypt(eingegeben))));
					        changelabel(ergebnistext);
						}
					});
					buttonPane.add(encrypt);
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
	        ergebnis.getParent().invalidate(); 
	        ergebnis.setText(text); 
	        ergebnis.getParent().validate(); 
	        pack(); 
	    } 
}
