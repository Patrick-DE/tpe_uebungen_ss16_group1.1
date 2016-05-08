package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Crypter_GUI extends JFrame implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private static JTextField eingabe;
	private static JTextField ergebnis;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crypter_GUI frame = new Crypter_GUI();
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
	public Crypter_GUI() {
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
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JSplitPane splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			contentPanel.add(splitPane);
			{
				eingabe = new JTextField();
				eingabe.setText("Eingabe");
				splitPane.setLeftComponent(eingabe);
				eingabe.setColumns(10);
			}
			{
				ergebnis = new JTextField();
				eingabe.setText("Ergebnis");
				splitPane.setRightComponent(ergebnis);
				ergebnis.setColumns(30);
			}
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
							String eingegeben = null;
							String ergebnistext = null;
							try {
								eingegeben = eingabe.getText();
							} catch (StringIndexOutOfBoundsException e) {
								// TODO Auto-generated catch block
								System.out.println("Es gab ein Fehler beim einlesen des Textes!");
							}
							Crypter caesar = new CrypterCaesar(5);
					        Crypter reverse = new CrypterReverse();
					        ergebnistext =(reverse.decrypt(caesar.decrypt(reverse.decrypt(eingegeben))));
					        changelabel(ergebnistext);
						}
					});
					buttonPane.add(decrypt);
				}
				{
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
							Crypter caesar = new CrypterCaesar(5);
					        Crypter reverse = new CrypterReverse();
					        ergebnistext=(reverse.encrypt(caesar.encrypt(reverse.encrypt(eingegeben))));
					        changelabel(ergebnistext);
						}
					});
					buttonPane.add(encrypt);
				}
			}
		}
	}

	protected void changelabel(String text) {
	        ergebnis.getParent().invalidate(); 
	        ergebnis.setText(text); 
	        ergebnis.getParent().validate(); 
	        pack(); 
	    } 
		
}
