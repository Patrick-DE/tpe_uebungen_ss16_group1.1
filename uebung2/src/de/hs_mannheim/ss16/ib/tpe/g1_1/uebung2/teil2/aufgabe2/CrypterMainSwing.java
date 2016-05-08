package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe2;

import static gdi.MakeItSimple.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import java.awt.Component;
import java.awt.Point;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CrypterMainSwing extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private String decrypted;
	private String encrypted;
	private JSplitPane splitPane;
	private JTextField decryptedText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrypterMainSwing dialog = new CrypterMainSwing();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public CrypterMainSwing() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			splitPane = new JSplitPane();
			splitPane.setBounds(5, 5, 424, 218);
			splitPane.setResizeWeight(0.5);
			splitPane.setContinuousLayout(true);
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			contentPanel.add(splitPane);
			
			
			{
				println("If you would like to enter an encrypted message press one, if you would like to enter an decrypted message press two.");
				int choice = readInt();
				readLine();
				if(choice == 1){
					encrypted = readLine();
					JLabel encryptedText = new JLabel(encrypted);
					encryptedText.setHorizontalAlignment(SwingConstants.CENTER);
					splitPane.setLeftComponent(encryptedText);
					
					
				}
				if(choice == 2){
					decrypted = readLine();
					JLabel encryptedText = new JLabel(decrypted);
					encryptedText.setHorizontalAlignment(SwingConstants.CENTER);
					splitPane.setLeftComponent(encryptedText);
				}
				
				
				
			}
			{
				decryptedText = new JTextField();
				decryptedText.setHorizontalAlignment(SwingConstants.CENTER);
				decryptedText.setText("decrypted Text");
				splitPane.setRightComponent(decryptedText);
				decryptedText.setColumns(10);
			}
		}
		{
			
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton decrypt = new JButton("Decrypt");
				decrypt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Crypter caesar = new CrypterCaesar(5);
				        Crypter reverse = new CrypterReverse();
				        decrypted=(reverse.decrypt(caesar.decrypt(reverse.decrypt(encrypted))));
				        textField = new JTextField(decrypted);
						textField.setHorizontalAlignment(SwingConstants.CENTER);
						splitPane.setRightComponent(textField);
						textField.setColumns(10);
				        
					}
				});
				decrypt.setActionCommand("Decrypt");
				buttonPane.add(decrypt);
				getRootPane().setDefaultButton(decrypt);
				
			}
			{
				JButton encrypt = new JButton("Encrypt");
				encrypt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Crypter caesar = new CrypterCaesar(5);
				        Crypter reverse = new CrypterReverse();
				        encrypted=(reverse.encrypt(caesar.encrypt(reverse.encrypt(decrypted))));
				        textField = new JTextField(encrypted);
						textField.setHorizontalAlignment(SwingConstants.CENTER);
						splitPane.setRightComponent(textField);
						textField.setColumns(10);
					}
				});
				encrypt.setActionCommand("Encrypt");
				buttonPane.add(encrypt);
				getRootPane().setDefaultButton(encrypt);
			}
			
			
		}
	}
}
