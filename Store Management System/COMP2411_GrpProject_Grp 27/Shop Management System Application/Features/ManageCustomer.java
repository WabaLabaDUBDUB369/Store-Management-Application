package Features;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Attributes.*;

public class ManageCustomer extends JFrame implements ActionListener {
	private JPanel panel;
	ViewCustomerActivity prev;
	private Customer customer;
	private JButton BackButton, EditButton, DeleteButton;
	private JLabel title, header, userIdLabel, customerNameLabel, phoneNumberLabel, addressLabel;
	private JTextField userId, customerName, phoneNumber, phoneCode, address;
	
	public ManageCustomer(String cid, ViewCustomerActivity prev) {
		super("Manage Customer");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		customer = new Customer(cid);
		customer.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		userIdLabel = new JLabel("Customer ID: "+customer.getUserId());
		userIdLabel.setBounds(60, 20, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		
		customerNameLabel = new JLabel("Name: ");
		customerNameLabel.setBounds(60, 60, 140, 30);
		customerNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(customerNameLabel);
		
		phoneNumberLabel = new JLabel("Phone: ");
		phoneNumberLabel.setBounds(60, 100, 140, 30);
		phoneNumberLabel.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberLabel);
		
		addressLabel = new JLabel("Address: ");
		addressLabel.setBounds(60, 140, 140, 30);
		addressLabel.setFont(Theme.FONT_INPUT);
		panel.add(addressLabel);
		
		customerName = new JTextField(customer.getCustomerName());
		customerName.setBounds(160, 60, 220, 30);
		customerName.setFont(Theme.FONT_INPUT);
		customerName.setBackground(Color.decode("#E0E0E0"));
		panel.add(customerName);
		
		phoneCode = new JTextField("+852");
		phoneCode.setEnabled(false);
		phoneCode.setBounds(160, 100, 40, 30);
		phoneCode.setFont(Theme.FONT_INPUT);
		panel.add(phoneCode);
		

		phoneNumber = new JTextField(customer.getPhoneNumber().substring(4)+"");
		phoneNumber.setBounds(200, 100, 180, 30);
		phoneNumber.setFont(Theme.FONT_INPUT);
		phoneNumber.setBackground(Color.decode("#E0E0E0"));
		panel.add(phoneNumber);
		
		address = new JTextField(customer.getAddress()+"");
		address.setBounds(160, 140, 220, 30);
		address.setFont(Theme.FONT_INPUT);
		address.setBackground(Color.decode("#E0E0E0"));
		panel.add(address);
		
		EditButton = new JButton("Update");
		EditButton.setBounds(60, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		EditButton.setFont(Theme.FONT_BUTTON);
		EditButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		EditButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		EditButton.addActionListener(this);
		panel.add(EditButton);
		
		DeleteButton = new JButton("Delete");
		DeleteButton.setBounds(180, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		DeleteButton.setFont(Theme.FONT_BUTTON);
		DeleteButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		DeleteButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		DeleteButton.addActionListener(this);
		panel.add(DeleteButton);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(EditButton)) {
			try {
				customer.updateCustomer(customerName.getText(),Integer.parseInt(phoneNumber.getText()),address.getText().trim());
				if (!prev.keyword.getText().trim().isEmpty())
					prev.table.setModel(Customer.searchCustomer(prev.keyword.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Customer.searchCustomer("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(DeleteButton)) {
			customer.deleteCustomer();
			if (!prev.keyword.getText().trim().isEmpty())
				prev.table.setModel(Customer.searchCustomer(prev.keyword.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Customer.searchCustomer("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}