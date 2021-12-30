package Features;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Attributes.*;

public class ManageSupplier extends JFrame implements ActionListener {
	private JPanel panel;
	ViewSupplierActivity prev;
	private Supplier supplier;
	private JButton BackButton, EditButton, DeleteButton;
	private JLabel title, header, userIdLabel, supplierNameLabel, supplierLocationLabel, productIdLabel;
	private JTextField userId, supplierName, supplierLocation, productId;
	
	public ManageSupplier(String eid, ViewSupplierActivity prev) {
		super("Manage Supplier");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		supplier = new Supplier(eid);
		supplier.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		userIdLabel = new JLabel("Supplier ID: "+supplier.getUserId());
		userIdLabel.setBounds(60, 20, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		
		supplierNameLabel = new JLabel("Name: ");
		supplierNameLabel.setBounds(60, 60, 140, 30);
		supplierNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(supplierNameLabel);
		
		supplierLocationLabel = new JLabel("Location: ");
		supplierLocationLabel.setBounds(60, 100, 140, 30);
		supplierLocationLabel.setFont(Theme.FONT_INPUT);
		panel.add(supplierLocationLabel);
		
		productIdLabel = new JLabel("Product IDs: ");
		productIdLabel.setBounds(60, 140, 140, 30);
		productIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(productIdLabel);
		
		supplierName = new JTextField(supplier.getSupplierName());
		supplierName.setBounds(160, 60, 220, 30);
		supplierName.setFont(Theme.FONT_INPUT);
		supplierName.setBackground(Color.decode("#E0E0E0"));
		panel.add(supplierName);
		

		supplierLocation = new JTextField(supplier.getSupplierLocation());
		supplierLocation.setBounds(160, 100, 220, 30);
		supplierLocation.setFont(Theme.FONT_INPUT);
		supplierLocation.setBackground(Color.decode("#E0E0E0"));
		panel.add(supplierLocation);
		
		productId = new JTextField(supplier.getProductIDs()+"");
		productId.setBounds(160, 140, 220, 30);
		productId.setFont(Theme.FONT_INPUT);
		productId.setBackground(Color.decode("#E0E0E0"));
		panel.add(productId);
		
		EditButton = new JButton("Update");
		EditButton.setBounds(60, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		EditButton.setFont(Theme.FONT_BUTTON);
		EditButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		EditButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		EditButton.addActionListener(this);
		panel.add(EditButton);
		
		DeleteButton = new JButton("Delete");
		DeleteButton.setBounds(180, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
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
				supplier.updateSupplier(supplierName.getText(), supplierLocation.getText(), productId.getText());
				if (!prev.keyword.getText().trim().isEmpty())
					prev.table.setModel(Supplier.searchSupplier(prev.keyword.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Supplier.searchSupplier("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(DeleteButton)) {
			supplier.deleteSupplier();
			if (!prev.keyword.getText().trim().isEmpty())
				prev.table.setModel(Supplier.searchSupplier(prev.keyword.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Supplier.searchSupplier("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}
