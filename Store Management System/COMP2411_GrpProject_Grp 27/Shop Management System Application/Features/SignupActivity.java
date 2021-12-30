package Features;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import Attributes.*;

public class SignupActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton ExitButton, SubmitButton, BackButton;
	private JLabel title, header, usernameLabel, passwordLabel, nameLabel, phoneLabel, addressLabel;
	private JTextField usernameTF, nameTF, phoneTF1, phoneTF2, addressTF;
	private JPasswordField passwordF;
	public SignupActivity() {
		super("Sign up");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Sign up");
		title.setBounds(30, 40, 200,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setBackground(Color.decode("#CCFFFF"));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		ExitButton = new JButton("Exit");
		ExitButton.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		ExitButton.setFont(Theme.FONT_BUTTON);
		ExitButton.setBackground(Color.decode("#CCFFFF"));
		ExitButton.setForeground(Theme.COLOR_TITLE);
		ExitButton.setFocusable(false);
		ExitButton.addActionListener(this);
		panel.add(ExitButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		BackButton.setFont(Theme.FONT_BUTTON);
		BackButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		BackButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		BackButton.setFocusable(false);
		BackButton.addActionListener(this);
		panel.add(BackButton);
		
		usernameLabel = new JLabel("User ID: ");
		usernameLabel.setBounds(60, 140, 140, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(60, 190, 140, 30);
		passwordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(passwordLabel);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(60, 240, 140, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Phone No: ");
		phoneLabel.setBounds(60, 290, 140, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		
		addressLabel = new JLabel("Address: ");
		addressLabel.setBounds(60, 340, 140, 30);
		addressLabel.setFont(Theme.FONT_REGULAR);
		panel.add(addressLabel);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(180, 140, 220, 30);
		usernameTF.setFont(Theme.FONT_INPUT);
		usernameTF.setBackground(Color.decode("#E0E0E0"));
		panel.add(usernameTF);
		
		passwordF = new JPasswordField();
		passwordF.setBounds(180, 190, 220, 30);
		passwordF.setFont(Theme.FONT_INPUT);
		passwordF.setBackground(Color.decode("#E0E0E0"));
		panel.add(passwordF);
		
		nameTF = new JTextField();
		nameTF.setBounds(180, 240, 220, 30);
		nameTF.setFont(Theme.FONT_INPUT);
		nameTF.setBackground(Color.decode("#E0E0E0"));
		panel.add(nameTF);
		
		phoneTF1 = new JTextField("+852");
		phoneTF1.setBounds(180, 290, 40, 30);
		phoneTF1.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		phoneTF1.setEnabled(false);
		phoneTF1.setFont(Theme.FONT_INPUT);
		phoneTF1.setDisabledTextColor(Color.BLACK);
		phoneTF1.setBackground(Color.decode("#E0E0E0"));
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField();
		phoneTF2.setBounds(220, 290, 180, 30);
		phoneTF2.setFont(Theme.FONT_INPUT);
		phoneTF2.setBackground(Color.decode("#E0E0E0"));
		panel.add(phoneTF2);
		
		addressTF = new JTextField();
		addressTF.setBounds(180, 340, 220, 30);
		addressTF.setFont(Theme.FONT_INPUT);
		addressTF.setBackground(Color.decode("#E0E0E0"));
		panel.add(addressTF);
		
		SubmitButton = new JButton("Submit");
		SubmitButton.setBounds(70, 400, 300, 35);
		SubmitButton.setFont(Theme.FONT_BUTTON);
		SubmitButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		SubmitButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		SubmitButton.setFocusable(false);
		SubmitButton.addActionListener(this);
		panel.add(SubmitButton);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(ExitButton))
			System.exit(0);
		else if (ae.getSource().equals(BackButton)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(SubmitButton)) {
			try {
				Customer c = new Customer(usernameTF.getText().trim());
				c.setPassword(passwordF.getText());
				c.setCustomerName(nameTF.getText());
				c.setPhoneNumber(Integer.parseInt(phoneTF2.getText()));
				c.setAddress(addressTF.getText());
				c.createCustomer(this);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Enter phone no correctly!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else {}
	}
}