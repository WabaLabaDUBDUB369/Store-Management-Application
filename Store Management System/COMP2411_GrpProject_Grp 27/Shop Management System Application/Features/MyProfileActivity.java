package Features;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import Attributes.*;

public class MyProfileActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton EditButton, BackButton, LogoutButton, SubmitButton, PassButton, DeleteButton;
	private JFrame backActivity;
	private User user;
	private Employee employee;
	private Customer customer;
	private JLabel title, header, usernameLabel, nameLabel, phoneLabel, addressLabel;
	private JTextField name, phone1, phone2, address;
	private JLabel roleLabel, salaryLabel;
	public MyProfileActivity(JFrame activity, Customer customer) {
		super("My Profile");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		backActivity = activity;
		this.customer = customer;
		this.user = (User) customer;
		
		title = new JLabel("My Profile");
		title.setBounds(30, 40, 260,75);
		title.setOpaque(true);
		title.setBackground(Color.decode("#CCFFFF"));
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		EditButton = new JButton("Update Profile");
		EditButton.setBounds(60, 380, 160, 30);
		EditButton.setFont(Theme.FONT_BUTTON);
		EditButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		EditButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		EditButton.setFocusable(false);
		EditButton.addActionListener(this);
		panel.add(EditButton);
		
		SubmitButton = new JButton("Submit");
		SubmitButton.setBounds(60, 330, 120, 30);
		SubmitButton.setFont(Theme.FONT_BUTTON);
		SubmitButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		SubmitButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		SubmitButton.setVisible(false);
		SubmitButton.setFocusable(false);
		SubmitButton.addActionListener(this);
		panel.add(SubmitButton);
		
		PassButton = new JButton("Change Password");
		PassButton.setBounds(Theme.GUI_WIDTH-205, 115, 185, 30);
		PassButton.setFont(Theme.FONT_BUTTON);
		PassButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		PassButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		PassButton.setFocusable(false);
		PassButton.addActionListener(this);
		panel.add(PassButton);
		
		DeleteButton = new JButton("Delete Account");
		DeleteButton.setBounds(Theme.GUI_WIDTH-180, 150, 160, 30);
		DeleteButton.setFont(Theme.FONT_BUTTON);
		DeleteButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		DeleteButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		DeleteButton.setFocusable(false);
		DeleteButton.addActionListener(this);
		panel.add(DeleteButton);
		
		LogoutButton = new JButton("Logout");
		LogoutButton.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH, 30);
		LogoutButton.setFont(Theme.FONT_BUTTON);
		LogoutButton.setBackground(Color.decode("#CCFFFF"));
		LogoutButton.setForeground(Theme.COLOR_TITLE);
		LogoutButton.addActionListener(this);
		LogoutButton.setFocusable(false);
		panel.add(LogoutButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH, 30);
		BackButton.setFont(Theme.FONT_BUTTON);
		BackButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		BackButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		BackButton.setFocusable(false);
		BackButton.addActionListener(this);
		panel.add(BackButton);
		
		usernameLabel = new JLabel("User ID:       "+customer.getUserId());
		usernameLabel.setBounds(60, 140, 440, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(60, 190, 440, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Phone No: ");
		phoneLabel.setBounds(60, 240, 440, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		
		name = new JTextField(customer.getCustomerName());
		name.setBounds(180, 190, 220, 30);
		name.setFont(Theme.FONT_INPUT);
		name.setDisabledTextColor(Color.BLACK);
		name.setBackground(Color.decode("#E0E0E0"));
		panel.add(name);
		
		phone1 = new JTextField("+852");
		phone1.setBounds(180, 240, 40, 30);
		phone1.setFont(Theme.FONT_INPUT);
		phone1.setEnabled(false);
		phone1.setDisabledTextColor(Color.BLACK);
		panel.add(phone1);
		
		phone2 = new JTextField(customer.getPhoneNumber().substring(4));
		phone2.setBounds(220, 240, 180, 30);
		phone2.setFont(Theme.FONT_INPUT);
		phone2.setDisabledTextColor(Color.BLACK);
		phone2.setBackground(Color.decode("#E0E0E0"));
		panel.add(phone2);
		
		address = new JTextField(customer.getAddress());
		address.setBounds(180, 290, 220, 30);
		address.setFont(Theme.FONT_INPUT);
		address.setDisabledTextColor(Color.BLACK);
		address.setBackground(Color.decode("#E0E0E0"));
		panel.add(address);
		
		addressLabel = new JLabel("Address: ");
		addressLabel.setBounds(60, 290, 440, 30);
		addressLabel.setFont(Theme.FONT_REGULAR);
		panel.add(addressLabel);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public MyProfileActivity(JFrame activity, Employee employee) {
		super("My Profile");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		backActivity = activity;
		this.employee = employee;
		this.user = (User) employee;
		
		title = new JLabel("My Profile");
		title.setBounds(30, 40, 260,75);
		title.setOpaque(true);
		title.setBackground(Color.decode("#CCFFFF"));
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		EditButton = new JButton("Update Profile");
		EditButton.setBounds(60, 380, 160, 30);
		EditButton.setFont(Theme.FONT_BUTTON);
		EditButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		EditButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		EditButton.setFocusable(false);
		EditButton.addActionListener(this);
		panel.add(EditButton);
		
		SubmitButton = new JButton("Submit");
		SubmitButton.setBounds(60, 380, 120, 30);
		SubmitButton.setFont(Theme.FONT_BUTTON);
		SubmitButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		SubmitButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		SubmitButton.setVisible(false);
		SubmitButton.setFocusable(false);
		SubmitButton.addActionListener(this);
		panel.add(SubmitButton);
		
		PassButton = new JButton("Change Password");
		PassButton.setBounds(Theme.GUI_WIDTH-205, 115, 185, 30);
		PassButton.setFont(Theme.FONT_BUTTON);
		PassButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		PassButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		PassButton.setFocusable(false);
		PassButton.addActionListener(this);
		panel.add(PassButton);
		
		LogoutButton = new JButton("Logout");
		LogoutButton.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH, 30);
		LogoutButton.setFont(Theme.FONT_BUTTON);
		LogoutButton.setBackground(Color.WHITE);
		LogoutButton.setForeground(Theme.COLOR_TITLE);
		LogoutButton.setFocusable(false);
		LogoutButton.addActionListener(this);
		panel.add(LogoutButton);
		
		BackButton = new JButton("Back");
		BackButton.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH, 30);
		BackButton.setFont(Theme.FONT_BUTTON);
		BackButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		BackButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		BackButton.setFocusable(false);
		BackButton.addActionListener(this);
		panel.add(BackButton);
		
		usernameLabel = new JLabel("User ID:        "+employee.getUserId());
		usernameLabel.setBounds(60, 140, 440, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(60, 190, 440, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Phone No: ");
		phoneLabel.setBounds(60, 240, 440, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		
		roleLabel = new JLabel("Role:             "+employee.getRole());
		roleLabel.setBounds(60, 290, 440, 30);
		roleLabel.setFont(Theme.FONT_REGULAR);
		panel.add(roleLabel);
		
		salaryLabel = new JLabel("Salary:          "+employee.getSalary());
		salaryLabel.setBounds(60, 340, 440, 30);
		salaryLabel.setFont(Theme.FONT_REGULAR);
		panel.add(salaryLabel);
		
		
		name = new JTextField(employee.getEmployeeName());
		name.setBounds(180, 190, 220, 30);
		name.setFont(Theme.FONT_INPUT);
		name.setDisabledTextColor(Color.BLACK);
		name.setBackground(Color.decode("#E0E0E0"));
		panel.add(name);
		
		phone1 = new JTextField("+852");
		phone1.setBounds(180, 240, 40, 30);
		phone1.setFont(Theme.FONT_INPUT);
		phone1.setEnabled(true);
		phone1.setDisabledTextColor(Color.BLACK);
		phone1.setBackground(Color.decode("#E0E0E0"));
		panel.add(phone1);
		
		phone2 = new JTextField(employee.getPhoneNumber().substring(4));
		phone2.setBounds(220, 240, 180, 30);
		phone2.setFont(Theme.FONT_INPUT);
		phone2.setDisabledTextColor(Color.BLACK);
		phone2.setBackground(Color.decode("#E0E0E0"));
		panel.add(phone2);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(BackButton)) {
			this.setVisible(false);
			backActivity.setVisible(true);
		}
		else if (ae.getSource().equals(LogoutButton)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(EditButton)) {
			EditButton.setVisible(false);
			SubmitButton.setVisible(true);
			name.setEnabled(true);
			phone2.setEnabled(true);
			if (customer!=null)
				address.setEnabled(true);
		}
		else if (ae.getSource().equals(SubmitButton)) {
			
			if (customer!=null) {
				address.setEnabled(false);
				try {
					customer.updateCustomer(name.getText().trim(), Integer.parseInt(phone2.getText()), address.getText().trim());
					EditButton.setVisible(true);
					SubmitButton.setVisible(false);
					name.setEnabled(false);
					phone2.setEnabled(false);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Invalid Number!");
				}
			}
			else if (employee!=null) {
				try {
					employee.updateEmployee(name.getText().trim(), Integer.parseInt(phone2.getText()), employee.getRole(), employee.getSalary());
					EditButton.setVisible(true);
					SubmitButton.setVisible(false);
					name.setEnabled(false);
					phone2.setEnabled(false);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Invalid number!");
				}
			}
		}
		else if (ae.getSource().equals(PassButton)) {
			new ChangePasswordActivity(this.user).setVisible(true);
		}
		else if (ae.getSource().equals(DeleteButton)) {
			int input = JOptionPane.showConfirmDialog(null, "Sure to Delete?", "Delete "+customer.getUserId()+"?", JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				customer.deleteCustomer();
				this.setVisible(false);
				new LoginActivity().setVisible(true);
			}
			else {}
		}
		else {}
	}
}