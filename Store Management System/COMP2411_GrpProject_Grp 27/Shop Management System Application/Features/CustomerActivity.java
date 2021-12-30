package Features;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import Attributes.*;

public class CustomerActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Customer customer;
	private JButton LogoutButton, ProfileButton, ViewProductButton, MyProductButton;
	private JLabel title, header;
	public CustomerActivity(String userId) {
		super("Customer Dashboard");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		customer = new Customer(userId);
		customer.fetch();
		
		title = new JLabel("Welcome, "+userId);
		title.setBounds(30, 40, userId.length()*30+220,75);
		title.setOpaque(true);
		title.setBackground(Color.decode("#CCFFFF"));
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		LogoutButton = new JButton("Logout");
		LogoutButton.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		LogoutButton.setFont(Theme.FONT_BUTTON);
		LogoutButton.setBackground(Color.decode("#CCFFFF"));
		LogoutButton.setForeground(Theme.COLOR_TITLE);
		LogoutButton.setFocusable(false);
		LogoutButton.addActionListener(this);
		panel.add(LogoutButton);
		
		ProfileButton = new JButton("My Profile");
		ProfileButton.setBounds(Theme.GUI_WIDTH-150, 80, 120,30);
		ProfileButton.setFont(Theme.FONT_BUTTON);
		ProfileButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		ProfileButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		ProfileButton.setFocusable(false);
		ProfileButton.addActionListener(this);
		panel.add(ProfileButton);
		
		ViewProductButton = new JButton("Product List");
		ViewProductButton.setBounds(300, 210, 230, 40);
		ViewProductButton.setFont(Theme.FONT_BUTTON);
		ViewProductButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		ViewProductButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		ViewProductButton.setFocusable(false);
		ViewProductButton.addActionListener(this);
		panel.add(ViewProductButton);
		
		MyProductButton = new JButton("Purchase History");
		MyProductButton.setBounds(300, 270, 230, 40);
		MyProductButton.setFont(Theme.FONT_BUTTON);
		MyProductButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		MyProductButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		MyProductButton.setFocusable(false);
		MyProductButton.addActionListener(this);
		panel.add(MyProductButton);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(ProfileButton)) {
			this.setVisible(false);
			new MyProfileActivity(this, customer).setVisible(true);
		}
		else if (ae.getSource().equals(LogoutButton)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(ViewProductButton)) {
			this.setVisible(false);
			new ViewProductActivity(this, customer).setVisible(true);
		}
		else if (ae.getSource().equals(MyProductButton)) {
			this.setVisible(false);
			new MyProductActivity(this, customer).setVisible(true);
		}
		else {}
	}
}