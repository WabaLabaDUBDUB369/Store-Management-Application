package Features;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributes.*;

public class EmployeeActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Employee employee;
	private JButton LogoutButton, ProfileButton, ViewProductButton;
	private JButton ViewCustomerButton, ViewSupplierButton, ViewEmployeeButton;
	private JLabel title, header;
	public EmployeeActivity(String userId) {
		super("Employee Dashboard");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		employee = new Employee(userId);
		employee.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("WELCOME, "+userId);
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
		
		ViewCustomerButton = new JButton("Customer Details");
		ViewCustomerButton.setBounds(300, 270, 230, 40);
		ViewCustomerButton.setFont(Theme.FONT_BUTTON);
		ViewCustomerButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		ViewCustomerButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		ViewCustomerButton.setFocusable(false);
		ViewCustomerButton.addActionListener(this);
		panel.add(ViewCustomerButton);
	
		
		
		ViewSupplierButton = new JButton("Supplier Details");
		ViewSupplierButton.setBounds(300, 330, 230, 40);
		ViewSupplierButton.setFont(Theme.FONT_BUTTON);
		ViewSupplierButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		ViewSupplierButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		ViewSupplierButton.setFocusable(false);
		ViewSupplierButton.addActionListener(this);
		panel.add(ViewSupplierButton);		
		
		
		
		if (employee.getRole().equals("Manager")) {
			ViewEmployeeButton = new JButton("Employee Details");
			ViewEmployeeButton.setBounds(300, 390, 230, 40);
			ViewEmployeeButton.setFont(Theme.FONT_BUTTON);
			ViewEmployeeButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
			ViewEmployeeButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
			ViewEmployeeButton.setFocusable(false);
			ViewEmployeeButton.addActionListener(this);
			panel.add(ViewEmployeeButton);
		}
		
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
			new MyProfileActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(LogoutButton)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(ViewProductButton)) {
			this.setVisible(false);
			new ViewProductActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(ViewCustomerButton)) {
			this.setVisible(false);
			new ViewCustomerActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(ViewSupplierButton)) {
			this.setVisible(false);
			new ViewSupplierActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(ViewEmployeeButton)) {
			this.setVisible(false);
			new ViewEmployeeActivity(this, employee).setVisible(true);
		}
		else {}
	}
}