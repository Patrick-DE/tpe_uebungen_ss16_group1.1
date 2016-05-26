package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung3.aufgabe2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class About extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	 * Create the dialog.
	 */
	public About() {
		setBounds(100, 100, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(3, 1, 0, 0));
			{
				JLabel lblNewLabel_1 = new JLabel("Gruppe: 1.1");
				panel.add(lblNewLabel_1);
				lblNewLabel_1.setEnabled(false);
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("08/05/2016 - v.0011");
				panel.add(lblNewLabel_2);
				lblNewLabel_2.setEnabled(false);
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				JLabel lblNewLabel = new JLabel("Have fun!");
				panel.add(lblNewLabel);
				lblNewLabel.setEnabled(false);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}


		
}
