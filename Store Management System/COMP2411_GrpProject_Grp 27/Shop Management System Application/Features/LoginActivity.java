package Features;

import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import Attributes.*;

public class LoginActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton ExitButton, LoginButton, SignupButton;
	private JLabel title, header, usernameLabel, passwordLabel;
	private JTextField username;
	private JPasswordField password;
	public LoginActivity() {
		super("Login");

		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Store Management System");
		title.setBounds(30, 40, 555, 75);
		title.setOpaque(true);
		title.setBackground(Color.decode("#CCFFFF"));
		title.setBorder(new EmptyBorder(0,20,0,0));
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
		
		SignupButton = new JButton("Sign up");
		SignupButton.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		SignupButton.setFont(Theme.FONT_BUTTON);
		SignupButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		SignupButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		SignupButton.setFocusable(false);
		SignupButton.addActionListener(this);
		panel.add(SignupButton);
		
		usernameLabel = new JLabel("User ID: ");
		usernameLabel.setBounds(210, 220, 120, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		username = new JTextField();
		username.setBounds(330, 220, 220, 30);
		username.setFont(Theme.FONT_INPUT);
		username.setBackground(Color.decode("#E0E0E0"));
		panel.add(username);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(210, 280, 120, 30);
		passwordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(passwordLabel);
		
		password = new JPasswordField();
		password.setBounds(330, 280, 220, 30);
		password.setFont(Theme.FONT_INPUT);
		password.setBackground(Color.decode("#E0E0E0"));
		panel.add(password);
		
		LoginButton = new JButton("Login");
		LoginButton.setBounds(230, 345, 300, 30);
		LoginButton.setFont(Theme.FONT_BUTTON);
		LoginButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		LoginButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		LoginButton.addActionListener(this);
		LoginButton.setFocusable(false);
		panel.add(LoginButton);
		
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
		else if (ae.getSource().equals(SignupButton)) {
			this.setVisible(false);
			new SignupActivity().setVisible(true);
		}
		else if (ae.getSource().equals(LoginButton)) {
			int status = User.checkStatus(username.getText(), password.getText());
			if (status == 0) {
				EmployeeActivity ea = new EmployeeActivity(username.getText());
				ea.setVisible(true);
				this.setVisible(false);
			}
			else if (status == 1) {
				CustomerActivity ca = new CustomerActivity(username.getText());
				ca.setVisible(true);
				this.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
			}
		}
		else {}
	}
}